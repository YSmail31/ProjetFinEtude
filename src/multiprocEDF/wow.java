package multiprocEDF;

import java.io.File;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;

/**
 *
 * @author ismail
 */
public class wow {
    public static void main(String[] args) {
        SAXBuilder sxb = new SAXBuilder();
        try
        {
            Document document = sxb.build(new File("mpts30.xml"));
            Element racine = document.getRootElement();
            for(Element taskset : racine.getChildren("taskset"))
            {
                for(Element task : taskset.getChildren("Task"))
                {
                    if(task.getAttribute("Compute").getLongValue() > task.getAttribute("Deadline").getLongValue())
                        System.exit(0);
                }
            }
            System.out.println("Ok");
            //System.out.println(racine.getChildren("taskset").get(250).getChildren("Task").get(9).getAttribute("Compute").getLongValue());
        }
        catch(Exception e){}
    }
}
