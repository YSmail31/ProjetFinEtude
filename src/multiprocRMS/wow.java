package multiprocRMS;

import java.io.File;
import java.util.ArrayList;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;

/**
 *
 * @author ismail
 */
public class wow {
    public static void main(String[] args) {
        Parser p = new Parser();
        p.ouvrir("rmts4_3.xml");
        int nbex = p.nbtu;
        int deb = (int)(p.deb*10);
        int fin = (int)(p.mu*10);
        int nbprc = p.nbp;
        int algo = p.algo;
        for(int j=1;j<fin;j++)
        {
            double efficacitéMoyenne = 0;
            for(int i = ((j-1)*nbex); i < (j*nbex) ; i++)
            {
                TaskSet ts = p.getTaskSet(i);
                double U = ts.getU();
                Processors processors = new Processors(nbprc, ts);
                processors.placement(algo);
                processors.insertionLocale();
                System.out.println("####"+(processors.getU()-U));
                efficacitéMoyenne += (processors.getU()-U) / (nbprc-j/10.0);
            }
            efficacitéMoyenne /= nbex;
            System.out.println(efficacitéMoyenne);
        }
    }
}
