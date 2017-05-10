package multiprocEDF;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;

public class TaskSet {
    private ArrayList<Task> tasks;
    private int n;
    private ArrayList<Couple> Q;
    private long maxQt;
    private long hp;
    private long dMax;
    private double u;
    private static FileWriter fw;
    private long harmonicPeriode;
    boolean dbfTest() {
        long hyperPeriod = hyperPeriod();
        for(Task t : tasks)
        {
            int j = 0;
            
            long l = t.getT()* j + t.getD();
            while(j <= hyperPeriod/t.getT() && dbf(l) <= l)
            {
                j++;
                l = t.getT()* j + t.getD();
            }
            if(j <= hyperPeriod/t.getT())
                return false;
        }
        return true;
    }
    public TaskSet(ArrayList<Task> tasks) {
        this.tasks = tasks;
        this.n = tasks.size();
        Q = new ArrayList<>();
        hp = hyperPeriod();
        dMax();
        U();
    }
    public static void initialise() throws IOException {
        fw = new FileWriter("rapport.txt");
    }
    public static void write(String val) throws IOException {
        fw.write(val);
    }
    public static void enregistrer() throws IOException {
        fw.close();
    }
    public TaskSet() {
        tasks = new ArrayList<>();
        n = 0;
        Q = new ArrayList<>();
        dMax = 0;
    }
    public ArrayList<Task> getTasks() {
        return tasks;
    }
    public int getN() {
        return n;
    }
    public ArrayList<Couple> getQ() {
        return Q;
    }
    public long getHp() {
        return hp;
    }
    public long getdMax() {
        return dMax;
    }
    public double getU() {
        U();
        return u;
    }
    public void addTask(Task t) {
        tasks.add(t);
        n++;
        hp = hyperPeriod();
        if(t.getD() > dMax)
            dMax = t.getD() ;
        u += t.getC()/t.getT();
    }   
    public boolean calcule() {
        maxQt = Long.MAX_VALUE;
        for(Task t : tasks)
        {
            for(int i=0;i < hp/t.getT();i++)
            {
                Couple c =new Couple(t.getD()+i*t.getT());
                if(!Q.contains(c))
                    Q.add(c);
            }
        }
        Q.sort(new Comparator<Couple>() {
            @Override
            public int compare(Couple c1, Couple c2) {
                return (int)(c1.getTd()-c2.getTd());
            }
        });
        if(n > 0)
        {
            long dk = Q.get(0).getTd();
            Q.get(0).setQt(dk-dbf(dk));
            if(maxQt > Q.get(0).getQt())
                maxQt = Q.get(0).getQt();
            for(int i=1 ; i < Q.size() ; i++)
            {
                if(Q.get(i-1).getTd() == Q.get(i).getTd())
                {
                    Q.remove(i);
                    i--;
                }
                else
                {
                    dk= Q.get(i).getTd();
                    long qt = Q.get(i-1).getQt();
                    Q.get(i).setQt(Long.min(qt, dk-dbf(dk)));
                    if(maxQt > Q.get(i).getQt())
                        maxQt = Q.get(i).getQt();
                    if(Q.get(i).getQt() == Q.get(i-1).getQt())
                    {
                        Q.get(i-1).setTf(Q.get(i).getTd());
                        Q.remove(i);
                        i--;
                    }
                    
                    if(Q.get(i).getQt() < 0)
                        return false; 
                }
            }
        }
        
        /*for(int i=0 ; i < Q.size()-1 ; i++)
            Q.get(i).setTf(Q.get(i+1).getTd());
        
        Q.get(Q.size()-1).setTf(hp);*/
        return true;
    }
    public boolean calcule(long periode) {
        Q.clear();
        maxQt = Long.MAX_VALUE;
        Q.add(new Couple(0));
        Q.get(0).setQt(Long.MAX_VALUE);
        for(Task t : tasks)
        {
            for(int i=0;i < hp/t.getT();i++)
            {
                Couple c =new Couple(t.getD()+i*t.getT());
                if(!Q.contains(c))
                    Q.add(c);
            }
        }
        Q.sort(new Comparator<Couple>() {
            @Override
            public int compare(Couple c1, Couple c2) {
                return (int)(c1.getTd()-c2.getTd());
            }
        });
        if(n > 0)
        {
            long dk = Q.get(0).getTd();
            for(int i=1 ; i < Q.size() ; i++)
            {
                if(Q.get(i-1).getTd() == Q.get(i).getTd())
                {
                    Q.remove(i);
                    i--;
                }
                else
                {
                    dk= Q.get(i).getTd();
                    long qt = Q.get(i-1).getQt();
                    Q.get(i).setQt(Long.min(qt, dk-dbf(dk)));
                    Q.get(i-1).setTf(Q.get(i).getTd());
                    if(Q.get(i).getQt() == Q.get(i-1).getQt())
                    {
                        Q.remove(i);
                        i--;
                    }
                        
                    if(Q.get(i).getQt() < 0)
                        return false; 
                }
            }
            int i=0;
            while(i < Q.size())
            {
                while(i < Q.size() && periode > Q.get(i).getTf())
                    i++;
                if(i<Q.size() && periode >= Q.get(i).getTd() && periode < Q.get(i).getTf() && maxQt > Q.get(i).getQt())
                    maxQt = Q.get(i).getQt();
                
                periode += periode;
            }
        }   
        return true;
    }
    public long hyperPeriod() {
		if(n>0)
		{
			long h=tasks.get(0).getT();
			int i=1;
			while(i<n)
			{
				h=h*getTask(i).getT()/pgcd(h,getTask(i).getT());
				i++;
			}
			return h;
		}
		return 0;
	}
    public long pgcd(long h, long t) {
		if(t>h)
		{
			long c=t;
			t=h;
			h=c;
		}
		while(h%t!=0)
		{
			long c=h;
			h=t;
			t=c%t;
		}
		return t;
    }
    private Task getTask(int i) {
        return tasks.get(i);
    }
    public long dbf(Task task,long t) {
        long val = (int)(task.getC()*(Math.floor((t-task.getD())/(double)task.getT())+1));
        return Math.max(0, val);
    }
    public long dbf(long t) {
        long s=0;
        
        for(Task task : tasks)
            s += dbf(task, t);
        
        return s;
    }
    private void dMax() {
        dMax = 0;
        for(Task t : tasks)
            if(t.getD() > dMax)
                dMax = t.getD() ;
    }
    public double T() {
        double s=0;
        for(Task t : tasks)
            s += t.computeUtil()*(t.getT()-t.getD());
        
        s *= (1/1-u);
        
        return Double.max(hp,Double.min(s, dMax));
    }
    public void U() {
        u = 0;
        for(Task t : tasks)
            u += t.getC()/(double) t.getT();
    }
    public Task getSleepTask() {
        setHarmonicPeriode();
        calcule(harmonicPeriode);
        long c = Math.min(maxQt,harmonicPeriode);
        long CsleepMin = 2;
        boolean schedulable;
        do{
            c = Math.min(maxQt,c);
            tasks.add(0,new Task(c, harmonicPeriode, harmonicPeriode));
            schedulable = calcule(harmonicPeriode);
            if(!test(this,c))
                c--;
            tasks.remove(0);
        }while(c > CsleepMin && !test(this,c));
        
        if(!schedulable || c <= CsleepMin)
            c=0;
        
        return new Task(c, harmonicPeriode, harmonicPeriode);
    }
    public int pMin() {
        int min = 0;
        for(int i=0; i < tasks.size() ; i++)
            if(tasks.get(i).getT() < tasks.get(min).getT())
                min = i ;
        return min;
    }
    private boolean test(TaskSet ts, long c) {
        int i=0;
        while(i < ts.Q.size() &&  c < ts.Q.get(i).getQt())
            i++;
        
        return i == ts.Q.size();
    }
    ArrayList<Task> getTaskSet() {
        return tasks;
    }
    double processUtil() {
        double s=0;
        if(tasks.isEmpty())
            s=1;
        else
            for(Task t:tasks)
                s += (double)t.getC()/t.getT();
        return s;
    }

    Task getSleepTask(long t) {
        calcule(t);
        long c = Math.min(maxQt,t);
        long CsleepMin = 2;
        boolean schedulable;
        do{
            c = Math.min(maxQt,c);
            tasks.add(0,new Task(c, t, t));
            schedulable = calcule(t);
            c--;
            tasks.remove(0);
        }while(c > CsleepMin && !test(this,c));
        
        if(!schedulable || c <= CsleepMin)
            c=0;
        
        return new Task(c, t, t);
    }
    
    public long getHarmonicPeriode(){
        sort();
        if(tasks.size() > 0)
        {
            long periode = tasks.get(0).getT();
            for(int i = 1;i < tasks.size();i++)
                if(tasks.get(i).getT() < 2*periode)
                    return periode / 2;
            
            return periode;
        }
        return 1;
    }
    void sort(){
        Comparator sorter = new Comparator<Task>() {
            @Override
            public int compare(Task t1, Task t2) {
                return (int)(t1.getT() - t2.getT());
            }
        };
        tasks.sort(sorter);
    }  

    private void setHarmonicPeriode() {
        harmonicPeriode = getHarmonicPeriode();
    }
}
