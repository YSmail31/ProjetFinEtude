package multiprocRMS;

import java.util.ArrayList;

public class Processor {

    TaskSet taskset;

    public Processor() {
        taskset = new TaskSet();
    }    
    public void addTask(Task t) {
        taskset.addTask(t);
    }
    boolean isDMSchedulable(Task t) {
        return taskset.worstCaseResp(t);
    }
    double processUtil() {
        return taskset.processUtil();
    }
    long localHarmonicPeriode() {
        return taskset.HarmonicPeriode();
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
