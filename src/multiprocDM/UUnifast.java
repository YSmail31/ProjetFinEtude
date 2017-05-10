package multiprocDM;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UUnifast {

    private void writeTs(FileWriter fw) throws IOException {
        for(Task t:ts.getTaskSet())
        {
            fw.write(t.getC()+" "+t.getD()+" "+t.getT()+"\n");
        }
    }
    TaskSet ts;
    double uTotal,tHarmonic;
    int n;
    boolean isHarmonic;
    Gossens gossens;
    public UUnifast(double uTotal, double tHarmonic, int n, int algo,int nbp) {
        this.uTotal = uTotal;
        this.tHarmonic = tHarmonic;
        this.n = n;
        this.isHarmonic = isHarmonic;
        ArrayList<Task> tasks=new ArrayList<>();
        gossens = new Gossens();
        do
        {
            tasks = generateTasks();
            ts = new TaskSet(tasks);
        }while(!new Processors(nbp, ts).DMTest(algo) || !(ts.getU() < uTotal+0.1 && ts.getU() >= uTotal));
    }   
    private ArrayList<Task> generateTasks() {
        ArrayList<Task> tasks=new ArrayList<>();
        Task t;
        do
        {
            Task.initialise();
            tasks.clear();
            double sum=uTotal,nextSum=0;
            double uTask;
            int i;
            for(i=0;i<n-1;i++)
            {
                do
                {
                    nextSum= sum * Math.pow(Math.random(), 1.0/(n-i));
                    uTask = sum - nextSum;
                }while(uTask*nextSum == 0 && uTask >= 1);
                if(uTask >=1)
                {
                    tasks.clear();
                    i=-1;
                    Task.initialise();
                    sum=uTotal;
                    nextSum=0;
                }
                else
                {
                    t = getTask(uTask);
                    sum = nextSum;
                    tasks.add(t);
                }
            }
            t = getTask(sum);
            tasks.add(t);
        }while(t.computeUtil() >=1);
        return tasks;
    }
    public void saveTaskSet(String path){
        try {
            FileWriter fw = new FileWriter(new File(path));
            writeTs(fw);
            fw.close();
        } catch (IOException ex) {
            Logger.getLogger(UUnifast.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static void main(String[] args) {
        Parser p = new Parser();
        p.ouvrir("mpts30.xml");
        int nbex = 10;        
        double efficacitéMoyenne = 0;
        TaskSet ts = p.getTaskSet(250);
        double U = ts.getU();
        Processors processors = new Processors(4, ts);
        processors.DMfirstFit();
        for(Processor proc : processors.getProcessors())
        {            
            if(!proc.taskset.getTaskSet().isEmpty())
            {
                Task tsl = proc.taskset.getDMSleepTask();
                if(tsl.getC() > 0)
                {
                    proc.addTask(tsl);
                }
            }
            else
                proc.taskset.addTask(new Task(1, 1, 1));
        }
        efficacitéMoyenne += (processors.getU()-U) / (4-U);
    }
    private Task getTask(double uTask) {
        long p = gossens.determinePeriode();
        long c = (long) Math.ceil(p * uTask);        
        long d = c +(long)(Math.random() * (p-c));
        return new Task(c, d, p);
    }     
}
