package multiprocEDF;


public class Test {
    public static void main(String[] args) {
        Processors p = new Processors(4);
        TaskSet ts = new TaskSet();
        ts.addTask(new Task(1,5,10,10));
        ts.addTask(new Task(2,7,21,21));
        ts.addTask(new Task(3,3,22,22));
        ts.addTask(new Task(4,1,24,24));
        ts.addTask(new Task(5,10,30,30));
        ts.addTask(new Task(6,16,40,40));
        ts.addTask(new Task(7,1,50,50));
        ts.addTask(new Task(8,3,55,55));
        ts.addTask(new Task(9,9,70,70));
        ts.addTask(new Task(10,17,100,100));
        p.setTaskset(ts);
        System.out.println(p.DMfirstFit());
        System.out.println(p.DMbestFit());
    }
}
