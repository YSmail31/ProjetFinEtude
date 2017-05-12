package multiprocRMS;

import java.util.ArrayList;
import java.util.Comparator;

public class TaskSet    { 
    
    private ArrayList<Task> taskSet;
    int size;
    double u;
    public static int SORT_D=1,SORT_T=2,SORT_ID=3;
    private int CsleepMin = 2;
    public TaskSet() {
            this.taskSet = new ArrayList<>();
            size = 0;
    }
    public TaskSet(ArrayList<Task> t) {
        this.taskSet = t;
        size = t.size();
        sort(SORT_ID);
    }
    public Task getDMSleepTask(){
        sort(TaskSet.SORT_T);
        long periode = hyperPeriod();
        if(size > 0)
            periode = taskSet.get(0).getT();
        else
            periode = CsleepMin;
        
        int i=1;
        while(i<size && taskSet.get(i).getT() > 2*periode)
            i++;
            
        if(i < size )
            periode /= 2;

        
        return BMS(periode);
    }
    public boolean worstCaseResp(Task tSleep){
        for(Task t:taskSet)
        {
            long w=t.getC()+tSleep.getT()-tSleep.getC(),w1=w-1;
            while(w != w1)
            {
                w1 = w;
                w = (long) (t.getC() + Math.ceil((double) w1/tSleep.getT())*tSleep.getC());
                for(int i=0; taskSet.get(i) != t; i++)
                    w += (long) (Math.ceil((double) w1/taskSet.get(i).getT())*taskSet.get(i).getC());
            }
            if( w > t.getD())
                return false;
        }
        return true;
    }
    public double processUtil() {
        double s=0;
        if(taskSet.isEmpty())
            s=1;
        else
            for(Task t:taskSet)
                s += (double)t.getC()/t.getT();
        return s;
    }
    public long hyperPeriod(){
		if(size>0)
		{
			long h=taskSet.get(0).getT();
			int i=1;
			while(i<size)
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
    public void addTask(Task t){
            taskSet.add(t);
            size ++ ;
    }
    public void printTs(){
            for(Task t:taskSet)
            {
                    System.out.println(t);
            }
	}
    public void setTaskSet(ArrayList<Task> ts){
            taskSet=ts;
            size = ts.size();
	}
    public ArrayList<Task> getTaskSet() {
            return taskSet;
	}
    public Task getTask(int i){
            return taskSet.get(i);
	}
    void sort(int type){
        Comparator sorter = new Comparator<Task>() {
            @Override
            public int compare(Task t1, Task t2) {
                if(type == 1 && t1.getD() != t2.getD())
                    return (int)(t1.getD() - t2.getD());
                
                if(type == 2 && t1.getT() != t2.getT())
                    return (int)(t1.getT() - t2.getT());
                
                return (int)(t1.getId() - t2.getId());
            }
        };
        taskSet.sort(sorter);
    }        
    boolean worstCaseResp() {
        for(Task t:taskSet)
        {
            long w=t.getC(),w1=w-1;
            while(w != w1)
            {
                w1 = w;
                w = t.getC();
                for(int i=0; taskSet.get(i) != t; i++)
                    w += (int) (Math.ceil((double) w1/taskSet.get(i).getT())*taskSet.get(i).getC());
            }
            if( w > t.getD())
                return false;
            }
        return true;
    }
    public void genDMSleepTask(){
        Task t= getDMSleepTask();
        if(t.getC() > CsleepMin)
            addTask(t);
    }
    public long HarmonicPeriode(){
        sort(SORT_T);
        if(size > 0)
        {
            long periode = taskSet.get(0).getT();
            for(int i = 1;i < taskSet.size();i++)
                if(taskSet.get(i).getT() < 2*periode)
                    return periode / 2;
            
            return periode;
        }
        return 0;
    }
    Task getSleepTask(long t) {
        sort(TaskSet.SORT_T);
        long periode = t;
        double u=processUtil();
        long tempsExec = (int)((1 - u) * periode); 
        if(taskSet.size() == 0)
            tempsExec = periode;
        Task sleepTask = new Task(tempsExec, periode, periode);
        
        while(!worstCaseResp(sleepTask) && tempsExec > 0)
        {
            tempsExec -- ;
            sleepTask.setC(tempsExec);
        }
        
        if(tempsExec <= CsleepMin)
            sleepTask.setC(0);
        
        return sleepTask;
    }
    public void U() {
        u = 0;
        for(Task t : taskSet)
            u += t.getC()/(double) t.getT();
    }
    double getU() {
        U();
        return u;
    } 

    private Task BMS(long periode) {
        double cDn = CsleepMin;
        double cUp = periode;
        Task t = new Task(CsleepMin, periode, periode);
        if(!worstCaseResp(t))
        {
            t.setC(0);
            return t;
        }
        double cs;
        while(cUp - cDn > 1)
        {
            cs = (cUp + cDn)/2.0;
            t.setC((long)cs);
            if(worstCaseResp(t))
                cDn = cs;
            else
                cUp = cs;
        }
        t.setC((long)cDn);
        return t;
    }
}
