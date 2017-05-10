package multiprocEDF;


public class MultiProc {

    final static int n = 12;
    public static void main(String[] args) {
        Parser p = new Parser();
        p.ouvrir("test.xml");
        for(int i=0;i<1;i++)
        {
            Processors processors = new Processors(1,p.getTaskSet(0));
            System.out.println(processors.DMfirstFit());
            System.out.println(processors.getU());
            processors.insertionLocale();
            System.out.println(processors.getU());
        }
        TaskSet ts = p.getTaskSet(0);
        ts.calcule(9);
    }
    
}
