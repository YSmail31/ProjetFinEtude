package multiprocEDF;

import java.util.ArrayList;

public class Processor {

    TaskSet taskset;

    public Processor() {
        taskset = new TaskSet();
    }    
    public void addTask(Task t) {
        taskset.addTask(t);
    }
    boolean isEDFSchedulable(Task t) {
        TaskSet t1 = new TaskSet((ArrayList<Task>) taskset.getTasks().clone());
        t1.addTask(t);
        return t1.dbfTest();
    }
    double processUtil() {
        return taskset.getU();
    }
    long localHarmonicPeriode() {
        taskset.getHarmonicPeriode();
        return taskset.getHarmonicPeriode();
    }
    boolean testHarmonic(long hpm) {
        ArrayList<Task> tasks = taskset.getTaskSet();
        int i = 0;
        while(i < tasks.size() && 2*hpm < tasks.get(i).getT())
            i++;
        
        return i == tasks.size();
    }
    public Task getSleepTask(long t){
        return taskset.getSleepTask(t);
    }
    @Override
    public String toString() {
        for(Task t : taskset.getTaskSet())
            System.out.print(t.id+"\t");
        
        return "";
    }
    
}
