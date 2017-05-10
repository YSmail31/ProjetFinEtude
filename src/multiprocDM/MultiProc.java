package multiprocDM;

public class MultiProc {

    final static int n = 12;
    public static void main(String[] args) {
        Parser p = new Parser();
        p.ouvrir("t2.xml");
        for(int i=0;i<p.nbts;i++)
        {
            Processors processors = new Processors(4,p.getTaskSet(i));
            processors.DMfirstFit();
            Task t = processors.getSleepTask();
            if(t.getC() > 0)
            {
                System.out.println(t);
                processors.addSleepTask(t);
                System.out.println(processors.getU());
            }
        }
        
    }
    
}
