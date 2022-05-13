/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Visuales;

import Utiles.Tupla;
import Utiles.Trio;
import Utiles.Entero;
import Clases_De_Proyecto.Elecc;
import Base_de_Datos.Gestion;
import Clases_De_Proyecto.Universidad;
import Utiles.Bloqueo;
import java.util.Vector;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author SchWarZer
 */
public class Gestor_de_Elecciones extends javax.swing.JFrame {
    Gestion G = new Gestion();
    Vector<Tupla<Entero, Trio<String, String, String>>> V;
    boolean[] B;
    
    boolean cerrar;
    /**
     * Creates new form Gestor_de_Elecciones
     */
    public Gestor_de_Elecciones() {
        initComponents();
        V = new Vector<>();
        
        V = G.devolver_elecciones();
        
        B = new boolean[V.size()];
        limpiarB();
        
        actualizar_lista();
        
        AnoL.setVisible(false);
        UniL.setVisible(false);
        OtroL.setVisible(false);
        Anno.setVisible(false);
        Universidad.setVisible(false);
        Object.setVisible(false);
        Aceptar.setVisible(false);
        cerrar = true;
        
 this.setLocationRelativeTo(null);
        setTitle("Elecciones Estudiantiles: Gestor de Elecciones");        
    }
    
    
    private void limpiarB(){
        
         for(int i = 0; i < B.length; i++){
            B[i] = true;
        }
         
    }
    
    
     private void actualizar_lista(){
        
         DefaultTableModel d = new DefaultTableModel(){
             @Override
             public boolean isCellEditable(int row, int column) {
                 return column == 3; //To change body of generated methods, choose Tools | Templates.
             }
         };
       
       Tabla = new JTable(d);
       jScrollPane2.setViewportView(Tabla);
       
       d.addColumn("Año");
       d.addColumn("Universidad");
       d.addColumn("Tipo");
       
       for(int i = 0; i < V.size(); i++){
           String[] X = new String[3];
           if(B[i]){
               X[0] = V.elementAt(i).getN2().getN1();
               X[1] = V.elementAt(i).getN2().getN2();
               X[2] = V.elementAt(i).getN2().getN3();
               d.addRow(X);
           }
       }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        Filtrar = new javax.swing.JButton();
        Continuar_elecciones = new javax.swing.JButton();
        Estadisticas = new javax.swing.JButton();
        Universidad = new javax.swing.JTextField();
        Object = new javax.swing.JTextField();
        AnoL = new javax.swing.JLabel();
        UniL = new javax.swing.JLabel();
        OtroL = new javax.swing.JLabel();
        Aceptar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        Tabla = new javax.swing.JTable();
        Anno = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setIconImage(getIconImage());
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(153, 153, 153));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 0, 0)));

        Filtrar.setBackground(new java.awt.Color(102, 102, 102));
        Filtrar.setText("Filtrar");
        Filtrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FiltrarActionPerformed(evt);
            }
        });

        Continuar_elecciones.setBackground(new java.awt.Color(102, 102, 102));
        Continuar_elecciones.setText("Continuar Elecciones");
        Continuar_elecciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Continuar_eleccionesActionPerformed(evt);
            }
        });

        Estadisticas.setBackground(new java.awt.Color(102, 102, 102));
        Estadisticas.setText("Estadísticas");
        Estadisticas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EstadisticasActionPerformed(evt);
            }
        });

        Universidad.setBackground(new java.awt.Color(204, 204, 204));

        Object.setBackground(new java.awt.Color(204, 204, 204));

        AnoL.setForeground(new java.awt.Color(0, 0, 0));
        AnoL.setText("Año");

        UniL.setForeground(new java.awt.Color(0, 0, 0));
        UniL.setText("Universidad");

        OtroL.setForeground(new java.awt.Color(0, 0, 0));
        OtroL.setText("Otro");

        Aceptar.setBackground(new java.awt.Color(102, 102, 102));
        Aceptar.setText("Aceptar");
        Aceptar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AceptarMouseClicked(evt);
            }
        });

        Tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Año", "Universidad", "Tipo"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(Tabla);

        Anno.setBackground(new java.awt.Color(204, 204, 204));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 523, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(AnoL)
                            .addComponent(Universidad, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Object, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Aceptar)
                            .addComponent(UniL)
                            .addComponent(OtroL)
                            .addComponent(Anno, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(Filtrar)
                        .addGap(18, 18, 18)
                        .addComponent(Continuar_elecciones)
                        .addGap(18, 18, 18)
                        .addComponent(Estadisticas)))
                .addGap(19, 19, 19))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addComponent(AnoL)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Anno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25)
                        .addComponent(UniL)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Universidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(OtroL)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Object, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(Aceptar)))
                .addGap(6, 6, 6)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Filtrar)
                    .addComponent(Continuar_elecciones)
                    .addComponent(Estadisticas)))
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

    private void FiltrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FiltrarActionPerformed
        
        limpiarB();
        
        
         AnoL.setVisible(true);
        UniL.setVisible(true);
        OtroL.setVisible(true);
        Anno.setVisible(true);
        Anno.setText("");
        Universidad.setVisible(true);
        Universidad.setText("");
        Object.setVisible(true);
        Object.setText("");
        Aceptar.setVisible(true);
        
    }//GEN-LAST:event_FiltrarActionPerformed

    private void AceptarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AceptarMouseClicked
        boolean year = false;
        String Year = "";
        boolean university = false;
        String University = "";
        boolean object = false;
        String OBJ = "";
        
        if(!Anno.getText().equals("")){
            year = true;
            Year = Anno.getText();
        }
        
        if(!Universidad.getText().equals("")){
            university = true;
            University = Universidad.getText();
        }
        
        if(!Object.getText().equals("")){
            object = true;
            OBJ = Object.getText();
        }
        
        if(!(!year && !university && !object)){
        
        
        for(int i = 0; i < V.size(); i++){
            if(year && university && object){
                if(!(V.elementAt(i).getN2().getN1().contains(Year) && V.elementAt(i).getN2().getN2().contains(University) && V.elementAt(i).getN2().getN3().contains(OBJ))){
                    B[i] = false;
                }
            }
            else if(year && university){
                if(!(V.elementAt(i).getN2().getN2().contains(University) && V.elementAt(i).getN2().getN1().contains(Year))){
                    B[i] = false;
                }
            }
            else if(year && object){
                if(!(V.elementAt(i).getN2().getN3().contains(OBJ) && V.elementAt(i).getN2().getN1().contains(Year))){
                    B[i] = false;
                }
            }
             else if(university && object){
                if(!(V.elementAt(i).getN2().getN2().contains(University) && V.elementAt(i).getN2().getN1().contains(Year))){
                    B[i] = false;
                }
            }
             else if(year){
                if(!V.elementAt(i).getN2().getN1().contains(Year)){
                    B[i] = false;
                }
            }
            else if(university){
                if(!V.elementAt(i).getN2().getN2().contains(University)){
                    B[i] = false;
                }
            }
            else if(object){
                if(!V.elementAt(i).getN2().getN3().contains(OBJ)){
                    B[i] = false;
                }
            }
            
        }
        
        }
        
        
        actualizar_lista();
        
        AnoL.setVisible(false);
        UniL.setVisible(false);
        OtroL.setVisible(false);
        Anno.setVisible(false);
        Universidad.setVisible(false);
        Object.setVisible(false);
        Aceptar.setVisible(false);
    }//GEN-LAST:event_AceptarMouseClicked

    private void EstadisticasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EstadisticasActionPerformed
        try{
        int select = Tabla.getSelectedRow();
        select++;
        int count = 0;
        for(int i = 0; i < B.length; i++){
            if(B[i]){
                count++;
                if(count == select){
                    break;
                }
            }
        }
        int id = V.elementAt(count-1).getN1().getEntero();
        
        Tupla<Elecc, Entero> T = G.extraer_eleccion(id);
            Bloqueo BLO = new Bloqueo(this);
        Estadisticas Est = new Estadisticas(T.getN1(), BLO);
        Est.setVisible(true);
        }catch(ArrayIndexOutOfBoundsException e){
            
        }
    }//GEN-LAST:event_EstadisticasActionPerformed

    private void Continuar_eleccionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Continuar_eleccionesActionPerformed
        
      try{
        int select = Tabla.getSelectedRow();
        select++;
        int count = 0;
        for(int i = 0; i < B.length; i++){
            if(B[i]){
                count++;
                if(count == select){
                    break;
                }
            }
        }
        int id = V.elementAt(count-1).getN1().getEntero();
        
        Tupla <Elecc, Entero> T = G.extraer_eleccion(id);
        Universidad UNI = G.crear_universidad(T.getN2().getEntero());
        
        if(G.revisar_eleccion(T.getN1())){
        Conteo_de_boletas CB = new Conteo_de_boletas(T.getN1(), UNI);
        CB.setVisible(true);
        }
        else{
            Agregar_candidatos AC = new Agregar_candidatos(T.getN1(), UNI, false);
            AC.setVisible(true);
        }
        
        cerrar = false;
        dispose();
      }catch(ArrayIndexOutOfBoundsException E){
          
      }
    }//GEN-LAST:event_Continuar_eleccionesActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        if(cerrar){
            Principal P = new Principal();
            P.setVisible(true);
        }
    }//GEN-LAST:event_formWindowClosed

    
    @Override
    public Image getIconImage() {
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("imagenes/eleccion.png"));
        return retValue;

    }
    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Aceptar;
    private javax.swing.JTextField Anno;
    private javax.swing.JLabel AnoL;
    private javax.swing.JButton Continuar_elecciones;
    private javax.swing.JButton Estadisticas;
    private javax.swing.JButton Filtrar;
    private javax.swing.JTextField Object;
    private javax.swing.JLabel OtroL;
    private javax.swing.JTable Tabla;
    private javax.swing.JLabel UniL;
    private javax.swing.JTextField Universidad;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}