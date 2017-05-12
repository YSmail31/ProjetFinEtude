package multiprocDM;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Interface extends javax.swing.JFrame {

    private String pathFile="";
    private UUnifast uunifast;
    private Modele modele;
    private Parser parser;
    private Parser p;
    private String pathFile2="";
    private String browsePath="";
    private String saveAsPath="";
    public Interface() {
        initComponents();
        setLocationRelativeTo(null);
        //setPreferredSize(new Dimension(1000, 800));
        setResizable(false);
        setTitle("Generateur");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        pu = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        nt = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        gpu = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        path = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        nprc1 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        check1 = new javax.swing.JComboBox<>();
        jPanel3 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        ntt = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        path1 = new javax.swing.JTextField();
        genTaskSets = new javax.swing.JButton();
        saveTaskSets = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        ntpu = new javax.swing.JTextField();
        barts = new javax.swing.JProgressBar();
        check = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        nprc = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        mutil = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        browse = new javax.swing.JTextField();
        saveas = new javax.swing.JTextField();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        barg = new javax.swing.JProgressBar();
        typeInsertion = new javax.swing.JComboBox<>();
        jButton8 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Process Utilization ");

        pu.setText("0.8");

        jLabel2.setText("Number of Task");

        nt.setText("10");

        jLabel4.setText("Generated Process Utilization");

        gpu.setEditable(false);
        gpu.setText(" ");
        gpu.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        gpu.setSelectedTextColor(new java.awt.Color(51, 255, 0));

        jButton1.setText("Browse");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        path.setEditable(false);

        jButton2.setText("Generate");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Save TaskSet");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(table);

        nprc1.setText("4");

        jLabel9.setText("Processor's Number");

        check1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "FirstFit", "NextFit", "BestFit", "WorstFit" }));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(gpu, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 11, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(path))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 57, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(pu, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(nt, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(nprc1, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(check1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 389, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton3)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(pu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(nt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(nprc1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(check1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(gpu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3)
                    .addComponent(jButton2)
                    .addComponent(path, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("1 TaskSet", jPanel2);

        jLabel5.setText("Number of Task / TaskSet");

        ntt.setText("10");

        jButton4.setText("Browse");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        path1.setEditable(false);

        genTaskSets.setText("Generate");
        genTaskSets.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                genTaskSetsActionPerformed(evt);
            }
        });

        saveTaskSets.setText("Save TaskSet");
        saveTaskSets.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveTaskSetsActionPerformed(evt);
            }
        });

        jLabel6.setText("Number of TaskSet / ProcessUtilization");

        ntpu.setText("10");

        barts.setForeground(new java.awt.Color(102, 255, 51));
        barts.setMaximum(8);

        check.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "FirstFit", "NextFit", "BestFit", "WorstFit" }));

        jLabel7.setText("Processor's Number");

        nprc.setText("4");

        jLabel8.setText("Max Utilisation");

        mutil.setText("3");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(0, 6, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(barts, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(ntt, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(ntpu, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(nprc, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(mutil, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(check, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGap(0, 5, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addComponent(genTaskSets)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(saveTaskSets))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addComponent(jButton4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(path1, javax.swing.GroupLayout.PREFERRED_SIZE, 607, javax.swing.GroupLayout.PREFERRED_SIZE))))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ntpu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(check, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ntt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nprc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(mutil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(path1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(genTaskSets)
                    .addComponent(saveTaskSets))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(barts, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(49, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("N TaskSet", jPanel3);

        browse.setEditable(false);

        saveas.setEditable(false);

        jButton5.setText("Ficher XML");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setText("Enregistrer Sous");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton7.setText("Generate");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        barg.setForeground(new java.awt.Color(102, 255, 51));
        barg.setMaximum(8);

        typeInsertion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Insertion Locale","Insertion Globale"}));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jButton7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(browse)
                    .addComponent(saveas)
                    .addComponent(barg, javax.swing.GroupLayout.DEFAULT_SIZE, 564, Short.MAX_VALUE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(typeInsertion, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(browse, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(saveas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton7)
                    .addComponent(typeInsertion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addComponent(barg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(76, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Générer Graphe", jPanel4);

        jButton8.setText("Retour");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton8)
                .addGap(315, 315, 315))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton8)
                .addGap(0, 11, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        if(pathFile.equals(""))
        {
            JOptionPane.showMessageDialog(this,"Veuillez specifier un fichier de sauvegarde avant","Chemin Incorrect",JOptionPane.ERROR_MESSAGE);
        }
        else if(uunifast == null)
        {
            JOptionPane.showMessageDialog(this,"Veuillez generer avant","Erreur de generation",JOptionPane.ERROR_MESSAGE);
        }
        else
            parser.enregistre(pathFile);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        try
        {
            double u=Double.parseDouble(pu.getText());
            int n=Integer.parseInt(nt.getText());
            int algo = check1.getSelectedIndex();
            int nbp = Integer.valueOf(nprc1.getText());
            uunifast = new UUnifast(u, n,algo,nbp);
            parser=new Parser(uunifast.ts, nbp, algo, u);
            modele = new Modele(uunifast.ts.getTaskSet());
            table.setModel(modele);
            String val = uunifast.ts.getU()+"";
            gpu.setText(val.substring(0,9));
            if(choix())
            {
                JFileChooser jf=new JFileChooser();
                jf.setCurrentDirectory(new File("."));
                jf.addChoosableFileFilter(new FileNameExtensionFilter("XML", "xml", "xml"));
                jf.setAcceptAllFileFilterUsed(false);
                int res=jf.showSaveDialog(this);
                if(res == JFileChooser.APPROVE_OPTION)
                {
                    String s = jf.getSelectedFile().getAbsolutePath();
                    if(!s.endsWith(".xml"))
                        s += ".xml";
                    parser.enregistre(s);
                }
            }
        }
        catch(NumberFormatException e){System.out.println("erreur format");}
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        JFileChooser jf=new JFileChooser();
        jf.setCurrentDirectory(new File("."));
        int res=jf.showSaveDialog(this);
        if(res == JFileChooser.APPROVE_OPTION)
        {
            pathFile = jf.getSelectedFile().getAbsolutePath();
            path.setText(pathFile);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        JFileChooser jf=new JFileChooser();
        jf.setCurrentDirectory(new File("."));
        int res=jf.showSaveDialog(this);
        if(res == JFileChooser.APPROVE_OPTION)
        {
            pathFile2 = jf.getSelectedFile().getAbsolutePath();
            path1.setText(pathFile2);
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void genTaskSetsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_genTaskSetsActionPerformed
        barts.setValue(0);
        int nt = Integer.parseInt(ntt.getText());
        int ntp = Integer.parseInt(ntpu.getText());
        double mu = Double.valueOf(mutil.getText());
        int nbp = Integer.parseInt(nprc.getText());
        int algo = check.getSelectedIndex();
        int n = (int)(mu*10);
        ArrayList<TaskSet> tasksets = new ArrayList<>();
        for(int i = 1 ; i < n ; i++)
        {
            System.out.println(i/10.0);
            System.out.println("-------");
            for(int j=0;j<ntp;j++)
            {  
                UUnifast u;
                u = new UUnifast(i/10.0, nt, algo,nbp);
                tasksets.add(u.ts);
                System.out.println(j);
            }
            barts.setValue(i);
        }
        System.out.println("Fin"+tasksets.size());
        p = new Parser(tasksets, nbp, algo, mu,ntp);
        if(choix())
        {
            JFileChooser jf=new JFileChooser();
            jf.setCurrentDirectory(new File("."));
            jf.addChoosableFileFilter(new FileNameExtensionFilter("XML", "xml", "xml"));
            jf.setAcceptAllFileFilterUsed(false);
            int res=jf.showSaveDialog(this);
            if(res == JFileChooser.APPROVE_OPTION)
            {
                String s = jf.getSelectedFile().getAbsolutePath();
                if(!s.endsWith(".xml"))
                    s += ".xml";
                p.enregistre(s);
            }
        }
    }//GEN-LAST:event_genTaskSetsActionPerformed

    private void saveTaskSetsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveTaskSetsActionPerformed
        if(pathFile2.equals(""))
        {
            JOptionPane.showMessageDialog(this,"Veuillez specifier un fichier de sauvegarde avant","Chemin Incorrect",JOptionPane.ERROR_MESSAGE);
        }
        else if(uunifast == null)
        {
            JOptionPane.showMessageDialog(this,"Veuillez generer avant","Erreur de generation",JOptionPane.ERROR_MESSAGE);
        }
        else
            p.enregistre(pathFile2);
    }//GEN-LAST:event_saveTaskSetsActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        JFileChooser jf=new JFileChooser();
        jf.setCurrentDirectory(new File("."));
        int res=jf.showOpenDialog(this);
        if(res == JFileChooser.APPROVE_OPTION)
        {
            browsePath = jf.getSelectedFile().getAbsolutePath();
            browse.setText(browsePath);
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        JFileChooser jf=new JFileChooser();
        jf.setCurrentDirectory(new File("."));
        int res=jf.showSaveDialog(this);
        if(res == JFileChooser.APPROVE_OPTION)
        {
            saveAsPath = jf.getSelectedFile().getAbsolutePath();
            saveas.setText(saveAsPath);
        }
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        if(browsePath.equals(""))
           JOptionPane.showMessageDialog(this,"Veuillez specifier un fichier source","Chemin Incorrect",JOptionPane.ERROR_MESSAGE);
        else if(saveAsPath.equals(""))
            JOptionPane.showMessageDialog(this,"Veuillez specifier un fichier de sauvegarde avant","Chemin Incorrect",JOptionPane.ERROR_MESSAGE);
        else
            try {
                gen(typeInsertion.getSelectedIndex());
        } catch (IOException ex) {
            Logger.getLogger(Interface.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        InterfacePrincipale.Interface.ip.setVisible(true);
        InterfacePrincipale.Interface.dm.setVisible(false);
        InterfacePrincipale.Interface.edf.setVisible(false);
    }//GEN-LAST:event_jButton8ActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Interface().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JProgressBar barg;
    private javax.swing.JProgressBar barts;
    private javax.swing.JTextField browse;
    private javax.swing.JComboBox<String> check;
    private javax.swing.JComboBox<String> check1;
    private javax.swing.JButton genTaskSets;
    private javax.swing.JTextField gpu;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField mutil;
    private javax.swing.JTextField nprc;
    private javax.swing.JTextField nprc1;
    private javax.swing.JTextField nt;
    private javax.swing.JTextField ntpu;
    private javax.swing.JTextField ntt;
    private javax.swing.JTextField path;
    private javax.swing.JTextField path1;
    private javax.swing.JTextField pu;
    private javax.swing.JButton saveTaskSets;
    private javax.swing.JTextField saveas;
    private javax.swing.JTable table;
    private javax.swing.JComboBox<String> typeInsertion;
    // End of variables declaration//GEN-END:variables

    private String headerTiks(){
        return "\\resizebox{8cm}{5cm}{\n"+"\\begin{tikzpicture}[thick, framed]\n";
    }    
    private String headerTex(){
        return "\\documentclass{article}\n" + "\\usepackage{tikz}\n" + "\\usetikzlibrary{arrows,backgrounds,snakes}\n" +"\\begin{document}\n"+"\\begin{center}\n";
    }
    private String footerTiks(double mu){
        String s = "\\draw [->](0,0) -- coordinate (x axis mid) ("+(mu*10+0.5)+",0);\n" +
                "\\draw [->](0,0) -- coordinate (y axis mid) (0,10.5);\n" + 
                "\\node[below=0.8cm] at (x axis mid) {Taux utilisation avant insertion};\n" +
                "\\node[rotate=90, above=0.8cm] at (y axis mid) {Pourcentage d'efficacité};\n";
        for(int i = 0 ; i < 11 ; i++)
            s += "\\draw (0,"+i+") -- (-0.5,"+i+") node[fill=white] {"+(i/10.0)+"};\n";
        for(int i = 0 ; i < mu*10 ; i++)
            s += "\\draw ("+i+",0) -- ("+i+",-0.5) node[fill=white,rotate=90] {"+(i/10.0)+"};\n";
        s += "\\end{tikzpicture}\n"+
                "}\n";
        return  s;
    }    
    private String footerTex(){
        return  "\\end{center}"+"\\end{document}";
    }    
    private void gen(int type) throws IOException {
        Parser p = new Parser();
        p.ouvrir(browsePath);
        ArrayList<Double> list = new ArrayList<>();
        String box = "";
        int nbex = p.nbtu;
        int fin = (int)(p.mu*10);
        int nbprc = p.nbp;
        int algo = p.algo;
        barg.setValue(0);
        FileWriter fwr = new FileWriter(saveAsPath+".data");
        for(int j=1;j<fin;j++)
        {
            System.out.println(j/10.0);
            System.out.println("----");
            double efficacitéMoyenne = 0;
            for(int i = ((j-1)*nbex); i < (j*nbex) ; i++)
            {
                System.out.println(i);
                TaskSet ts = p.getTaskSet(i);
                double U = ts.getU();
                Processors processors = new Processors(nbprc, ts);
                processors.placement(algo);
                switch(type)
                {
                    case 0: processors.insertionLocale();break;
                    case 1: processors.insertionGlobale();break;
                }
                efficacitéMoyenne += (processors.getU()-U) / (nbprc-j/10.0);
            }
            efficacitéMoyenne /= nbex;
            list.add(efficacitéMoyenne*10);
            /*box += "\\draw [line width=1pt] (?,?) -- (?,?);\n";
            box = box.replaceFirst("[?]", j+"");
            box = box.replaceFirst("[?]", "0");
            box = box.replaceFirst("[?]", j+"");
            box = box.replaceFirst("[?]", efficacitéMoyenne*10+"");*/
            barg.setValue(j);
            fwr.write(j+"\t"+(efficacitéMoyenne*10)+"\n");
        }
        box += "\\draw plot[mark=*, mark options={fill=white}] \n" + "file {?};\n";
        String nomFichier = saveAsPath.substring(saveAsPath.lastIndexOf("\\")+1);
        box = box.replaceFirst("[?]",nomFichier+".data");
        fwr.close();
        try {
            FileWriter fw = new FileWriter(new File(saveAsPath));
            fw.write(headerTex());
            fw.write(headerTiks());
            fw.write(box);
            fw.write(footerTiks(p.mu-0.1));
            fw.write(footerTex());
            fw.close();
        } catch (IOException ex) {
            Logger.getLogger(Interface.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    boolean choix()
    {
        JOptionPane option = new JOptionPane();
        int retour = option.showConfirmDialog(this, "Voulez vous enregistrer ?", 
            "", JOptionPane.YES_NO_OPTION);
        return (retour == 0);
    }
}
