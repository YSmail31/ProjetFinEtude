package multiprocDM;

import java.util.ArrayList;
import java.util.Comparator;

public class Processors {
    private ArrayList<Processor> processors;
    private TaskSet taskset;
    private int nbrProc;
    public long harmonicPeriode;
    public long harmonicDeadline;
    public Processors(int n) {
        taskset = new TaskSet();
        nbrProc = n ; 
        initialise();
    }
    public Processors(int n,TaskSet ts) {
        taskset = ts ;
        nbrProc = n ; 
        initialise();
    }
    private void initialise() {
        processors = new ArrayList<>();
        
        for(int i=0 ; i < nbrProc ; i++)
            processors.add(new Processor());
    } 
    public boolean DMfirstFit(){
        initialise();
        for(Task t : taskset.getTaskSet())
        {
            int i = 0;
            while(i < nbrProc && !processors.get(i).isDMSchedulable(t))
                i++;
            
            if(i == nbrProc)
                return false; 
            
            processors.get(i).addTask(t);
        }
        return true;
    }
    public boolean DMnextFit(){
        initialise();
        int nextFit = 0;
        for(Task t : taskset.getTaskSet())
        {
            int i = nextFit;
            while(i != nextFit && !processors.get(i).isDMSchedulable(t))
                i = (i+1)%nbrProc;
            
            if(i == nextFit)
                return false; 
            
            nextFit=i;
            processors.get(i).addTask(t);
        }
        return true;
            }
    public boolean DMbestFit(){
        initialise();
        for(Task t : taskset.getTaskSet())
        {
            double minUtil = Double.MAX_VALUE;
            int i;
            int indProc = 0;
            boolean existSchedulable = false;
            for(i = 0 ; i < nbrProc ; i++)
            {
                double utilisation = processors.get(i).processUtil() + (double)t.getC()/t.getT();

                if(minUtil > utilisation && processors.get(i).isDMSchedulable(t))
                {
                    existSchedulable = true;
                    minUtil = utilisation;
                    indProc = i;
                }
            }
            if(!existSchedulable)
                return false; 

            processors.get(indProc).addTask(t);
        }
        return true;
    }
    public boolean DMworstFit(){
        initialise();
        for(Task t : taskset.getTaskSet())
        {
            double maxUtil = 0;
            int i;
            int indProc = 0;
            boolean existSchedulable = false;
            for(i = 0 ; i < nbrProc ; i++)
            {
                double utilisation = processors.get(i).processUtil() + (double)t.getC()/t.getT();

                if(maxUtil < utilisation && processors.get(i).isDMSchedulable(t))
                {
                    existSchedulable = true;
                    maxUtil = utilisation;
                    indProc = i;
                }
            }
            if(!existSchedulable)
                return false; 

            processors.get(indProc).addTask(t);
        }
        return true;
    }
    public void afficher(){
        for(int i = 0 ; i < nbrProc ; i++)
        {
            System.out.println("processeur "+i);
            processors.get(i).taskset.printTs();
            System.out.println("--------------");
        }
            
    }
    public void insertDMTaskSleep(){
        for(int i = 0 ; i < processors.size() ; i++)
        {
            Processor p = processors.get(i);
            System.out.println("processeur "+i);
            System.out.println("--------------");
            System.out.println("utilsation avant : "+p.processUtil());
            p.taskset.genDMSleepTask();
            System.out.println("utilisation apres : "+p.processUtil());
            System.out.println("--------------");
        }
    }
    public long getHarmonicPeriode(){
        sort();
        long periode = taskset.getTaskSet().get(0).getT();
        for(int i=1;i<taskset.getTaskSet().size();i++)
            if(taskset.getTaskSet().get(i).getT() < 2*periode)
                return periode /= 2;
        return periode;
    }
    public void setHarmonicPeriode(){
        harmonicPeriode = getHarmonicPeriode();
    }
    public Task getSleepTask(){    
        setHarmonicPeriode();
        long tSleep = harmonicPeriode;
        long cSleep = harmonicPeriode;
        for(Processor p:processors)
        {
            if(cSleep > p.getSleepTask(tSleep).getC())
                cSleep = p.getSleepTask(tSleep).getC();
        }
        return new Task(cSleep, tSleep, tSleep);
    }
    void addSleepTask(Task globalSleepTask) {
        for(int i = 0 ; i < processors.size() ; i++)
        {
            processors.get(i).addTask(globalSleepTask);
        }
    }
    public void setTaskset(TaskSet taskset) {
        this.taskset = taskset;
    }
    boolean DMTest(int i) {
        switch(i)
        {
            case 0 : return DMfirstFit();
            case 1 : return DMnextFit();
            case 2 : return DMbestFit();
            case 3 : return DMworstFit();
        }
        return false;
    }
    public ArrayList<Processor> getProcessors() {
        return processors;
    }
    double getU(){
        double u = 0;
        for(Processor p : processors)
            u += p.processUtil();
        return u;
    }
    void sort(){
        Comparator sorter = new Comparator<Task>() {
            @Override
            public int compare(Task t1, Task t2) {
                if(t1.getT() != t2.getT())
                    return (int)(t1.getT() - t2.getT());
                return (int)(t1.getId() - t2.getId());
            }
        };
        taskset.getTaskSet().sort(sorter);
    }

    void placement(int algo) {
        switch(algo)
        {
            case 0:DMfirstFit();break;
            case 1:DMnextFit();break;
            case 2:DMbestFit();break;
            case 3:DMworstFit();break;
        }
    }

    void insertionLocale() {
        for(Processor proc : getProcessors())
        {
            Task tsl = proc.taskset.getDMSleepTask();
            if(tsl.getC() > 0)
            {
                proc.addTask(tsl);
            }
        }
    }

    void insertionGlobale() {
        Task t = getSleepTask();
        if(t.getC() > 0)
        {
            addSleepTask(t);
        }
    }
}
