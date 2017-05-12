package multiprocRMS;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jdom2.DataConversionException;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

public class Parser {
    TaskSet taskset;
    Element racine= new Element("tasksets");;
    int nbp,algo,nbtu,nbts;
    double mu,deb;
    public Parser(TaskSet taskset,int nbp,int algo,double mu) {
        Element inf = new Element("Information");
        inf.setAttribute("nbts", "1");
        inf.setAttribute("nbtu", "1");
        inf.setAttribute("nbprc",nbp+"");
        inf.setAttribute("algo",algo+"");
        inf.setAttribute("maxU",mu+"");
        racine.addContent(inf);
        createTaskSet(taskset);
    }    
    Parser(ArrayList<TaskSet> tasksets,int nbp,int algo,double mu,int nbtu){
        Element inf = new Element("Information");
        inf.setAttribute("nbts", tasksets.size()+"");
        inf.setAttribute("nbtu", nbtu+"");
        inf.setAttribute("nbprc",nbp+"");
        inf.setAttribute("algo",algo+"");
        inf.setAttribute("maxU",mu+"");
        racine.addContent(inf);
        for(TaskSet ts: tasksets)
            createTaskSet(ts);
    }
    Parser() {
        taskset = new TaskSet();
    }
    public void affiche(){
        try
        {
            XMLOutputter sortie = new XMLOutputter(Format.getPrettyFormat());
            sortie.output(racine, System.out);
        }
        catch (java.io.IOException e){}
    }
    public void enregistre(String fichier){
        try
        {
            XMLOutputter sortie = new XMLOutputter(Format.getPrettyFormat());
            OutputStream fos = new FileOutputStream(fichier);
            sortie.output(racine, fos);
            fos.close();
        }
        catch (java.io.IOException e){}
    }
    private void createTaskSet(TaskSet taskset){
        Element ts = new Element("taskset");
        ts.setAttribute("TauxUtil", taskset.processUtil()+"");
        ts.setAttribute("HyperPeriode",taskset.hyperPeriod()+"");
        for(Task t:taskset.getTaskSet())
        {
            Element task=new Element("Task");
            task.setAttribute("Id", t.getId()+"");
            task.setAttribute("Compute",t.getC()+"");
            task.setAttribute("Deadline", t.getD()+"");
            task.setAttribute("Periode", t.getT()+"");
            ts.addContent(task);
        }
        racine.addContent(ts);
    }
    public void ouvrir(String path){
        SAXBuilder sxb = new SAXBuilder();
        try
        {
            Document document = sxb.build(new File(path));
            racine = document.getRootElement();
            Element inf = racine.getChild("Information");
            nbp = inf.getAttribute("nbprc").getIntValue();
            algo = inf.getAttribute("algo").getIntValue();
            nbtu = inf.getAttribute("nbtu").getIntValue();
            nbts = inf.getAttribute("nbts").getIntValue();
            mu = inf.getAttribute("maxU").getDoubleValue();
            deb = 0;
            if(nbts == 1)
                deb = mu;
        }
        catch(Exception e){}
    }
    public TaskSet getTaskSet(int i){
        TaskSet ts = new TaskSet();
        List<Element> elements = racine.getChildren("taskset");
        for(Element element : elements.get(i).getChildren())
        {
            try {
                long id = element.getAttribute("Id").getLongValue();
                long c = element.getAttribute("Compute").getLongValue();
                long d = element.getAttribute("Deadline").getLongValue();
                long t = element.getAttribute("Periode").getLongValue();
                Task task=new Task(id, c, d, t);
                ts.addTask(task);
            } catch (DataConversionException ex) {
                Logger.getLogger(Parser.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return ts;
    }
    public int numberOfTaskSet(){
        return racine.getChildren("taskset").size();
    }
    public double getProcessUtil(int i) throws DataConversionException{
        return racine.getChildren("taskset").get(i).getAttribute("TauxUtil").getDoubleValue();
    }
    public void setTaskset(TaskSet taskset) {
        this.taskset = taskset;
    }
    
}
