package multiprocDM;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Gossens {
    ArrayList<ArrayList<Integer>> M;
    public Gossens() {
        try {
            Scanner sc = new Scanner(new File("goos.txt"));
            M = new ArrayList<>();
            int i=0;
            while(sc.hasNextLine())
            {
                M.add(new ArrayList<>());
                String valeurs[] = sc.nextLine().split(" ");
                for(String v : valeurs)
                    M.get(i).add(Integer.valueOf(v));
                
                i++;
            }
            /*for(i=0; i < 10;i++)
                System.out.println(determinePeriode());*/
        } catch (FileNotFoundException ex) {
            System.out.println("fichier non trouvé");
        }
    }
    public long determinePeriode()
    {
        long p = 1;
        for(ArrayList<Integer> line : M)
        {
            int indice = (int)(Math.random() * (line.size()));
            p *= line.get(indice);
        }
        return p;
    }
}
