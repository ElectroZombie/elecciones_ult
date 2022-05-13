/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Visuales;

import Utiles.Tupla;
import Utiles.Entero;
import Base_de_Datos.Gestion;
import Clases_De_Proyecto.*;
import Utiles.Sonido;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.util.Vector;
import javax.swing.JOptionPane;

/**
 *
 * @author Estudiantes
 */
public class Nueva_Universidad extends javax.swing.JFrame {

    private final Gestion G;
    private final Vector<Facultad> Vector_facultades;
    private final Vector<Beca> Vector_becas;
    private int matricula;

    public Nueva_Universidad() {
        initComponents();
        Carreras.setVisible(false);
        Agregar_carrera.setVisible(false);
        jList3.setVisible(false);
        G = new Gestion();
        Vector_facultades = new Vector<>();
        Vector_becas = new Vector<>();
        this.matricula = 0;
        this.setLocationRelativeTo(null);
        setTitle("Elecciones Estudiantiles : Creación de Nueva Universidad");
        Agregar.setVisible(true);
        Actualizar.setVisible(false);
        Eliminar.setVisible(false);
    }

    public Nueva_Universidad(String nombre) {
        initComponents();

        G = new Gestion();
        Universidad U = G.crear_universidad(nombre);
        this.setLocationRelativeTo(null);
        setTitle("Elecciones Estudiantiles : Edición de la Universidad: "+U.getNombre());
        Vector_becas = U.getBecas();
        Vector_facultades = U.getFacultades();

        Carreras.setVisible(false);
        Agregar_carrera.setVisible(false);
        jList3.setVisible(false);

        this.matricula = U.getMatricula();
        Matricula_total.setText(matricula + "");
        Nombre_Universidad.setText(U.getNombre());
        Nombre_Universidad.setEnabled(false);

        actualizar_lista1();
        actualizar_lista2();
        Agregar.setVisible(false);
        Actualizar.setVisible(true);
        Eliminar.setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Menu_context = new javax.swing.JPopupMenu();
        Borrar = new javax.swing.JMenuItem();
        Editar_Nombre = new javax.swing.JMenuItem();
        Editar_Matricula = new javax.swing.JMenuItem();
        Editar_Duración = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        Nombre_Universidad = new javax.swing.JTextField();
        Lista_facultades = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        Facultades = new javax.swing.JLabel();
        Agregar_facultad = new javax.swing.JButton();
        Lista_becas = new javax.swing.JScrollPane();
        jList2 = new javax.swing.JList<>();
        Becas = new javax.swing.JLabel();
        Agregar_beca = new javax.swing.JButton();
        Agregar_carrera = new javax.swing.JButton();
        Carreras = new javax.swing.JLabel();
        Lista_carreras = new javax.swing.JScrollPane();
        jList3 = new javax.swing.JList<>();
        Agregar = new javax.swing.JButton();
        Matricula_total = new javax.swing.JLabel();
        Actualizar = new javax.swing.JButton();
        Eliminar = new javax.swing.JButton();

        Menu_context.setMinimumSize(new java.awt.Dimension(4, 7));

        Borrar.setText("Borrar");
        Borrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BorrarActionPerformed(evt);
            }
        });
        Menu_context.add(Borrar);

        Editar_Nombre.setText("Editar Nombre");
        Editar_Nombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Editar_NombreActionPerformed(evt);
            }
        });
        Menu_context.add(Editar_Nombre);

        Editar_Matricula.setText("Editar Matrícula");
        Editar_Matricula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Editar_MatriculaActionPerformed(evt);
            }
        });
        Menu_context.add(Editar_Matricula);

        Editar_Duración.setText("Editar Duración");
        Editar_Duración.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Editar_DuraciónActionPerformed(evt);
            }
        });
        Menu_context.add(Editar_Duración);

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
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Nombre_Universidad.setBackground(new java.awt.Color(255, 255, 255));
        Nombre_Universidad.setToolTipText("Nombre de la universidad");
        jPanel1.add(Nombre_Universidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 12, 366, 27));

        jList1.setBackground(new java.awt.Color(204, 204, 204));
        jList1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jList1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jList1MouseClicked(evt);
            }
        });
        jList1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jList1KeyPressed(evt);
            }
        });
        Lista_facultades.setViewportView(jList1);

        jPanel1.add(Lista_facultades, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 64, 221, 323));

        Facultades.setForeground(new java.awt.Color(0, 0, 0));
        Facultades.setText("Facultades");
        jPanel1.add(Facultades, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 45, 109, -1));

        Agregar_facultad.setBackground(new java.awt.Color(102, 102, 102));
        Agregar_facultad.setText("Agregar facultad");
        Agregar_facultad.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Agregar_facultadMouseClicked(evt);
            }
        });
        jPanel1.add(Agregar_facultad, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 393, 221, -1));

        jList2.setBackground(new java.awt.Color(204, 204, 204));
        jList2.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jList2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jList2MouseClicked(evt);
            }
        });
        jList2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jList2KeyPressed(evt);
            }
        });
        Lista_becas.setViewportView(jList2);

        jPanel1.add(Lista_becas, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 66, 218, 321));

        Becas.setForeground(new java.awt.Color(0, 0, 0));
        Becas.setText("Residencias");
        jPanel1.add(Becas, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 45, -1, -1));

        Agregar_beca.setBackground(new java.awt.Color(102, 102, 102));
        Agregar_beca.setText("Agregar Residencias");
        Agregar_beca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Agregar_becaActionPerformed(evt);
            }
        });
        jPanel1.add(Agregar_beca, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 393, 218, -1));

        Agregar_carrera.setBackground(new java.awt.Color(102, 102, 102));
        Agregar_carrera.setText("Agregar carrera");
        Agregar_carrera.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Agregar_carreraActionPerformed(evt);
            }
        });
        jPanel1.add(Agregar_carrera, new org.netbeans.lib.awtextra.AbsoluteConstraints(258, 393, 225, -1));

        Carreras.setForeground(new java.awt.Color(0, 0, 0));
        Carreras.setText("Carreras");
        jPanel1.add(Carreras, new org.netbeans.lib.awtextra.AbsoluteConstraints(258, 45, -1, -1));

        jList3.setBackground(new java.awt.Color(204, 204, 204));
        jList3.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jList3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jList3MouseClicked(evt);
            }
        });
        jList3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jList3KeyPressed(evt);
            }
        });
        Lista_carreras.setViewportView(jList3);

        jPanel1.add(Lista_carreras, new org.netbeans.lib.awtextra.AbsoluteConstraints(258, 66, 225, 321));

        Agregar.setBackground(new java.awt.Color(102, 102, 102));
        Agregar.setText("Agregar");
        Agregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AgregarActionPerformed(evt);
            }
        });
        jPanel1.add(Agregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(654, 13, -1, -1));

        Matricula_total.setForeground(new java.awt.Color(0, 0, 0));
        Matricula_total.setText("0");
        jPanel1.add(Matricula_total, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 12, 56, 27));

        Actualizar.setBackground(new java.awt.Color(102, 102, 102));
        Actualizar.setText("Actualizar");
        Actualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ActualizarActionPerformed(evt);
            }
        });
        jPanel1.add(Actualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(464, 13, -1, -1));

        Eliminar.setBackground(new java.awt.Color(102, 102, 102));
        Eliminar.setText("Eliminar");
        Eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EliminarActionPerformed(evt);
            }
        });
        jPanel1.add(Eliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(558, 13, 85, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 740, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 452, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void actualizar_lista1() {
        String[] model = new String[Vector_facultades.size()];

        for (int i = 0; i < Vector_facultades.size(); i++) {
            model[i] = Vector_facultades.elementAt(i).getNombre() + ": " + Vector_facultades.elementAt(i).getMatricula();
        }

        jList1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = model;

            @Override
            public int getSize() {
                return strings.length;
            }

            @Override
            public String getElementAt(int i) {
                return strings[i];
            }
        });
    }

    private void borrar_lista_1() {

        if (!jList1.isSelectionEmpty()) {
            int temp = jList1.getSelectedIndex();
            matricula -= Vector_facultades.elementAt(temp).getMatricula();
            Matricula_total.setText(matricula + "");
            Vector_facultades.remove(temp);

            actualizar_lista1();

            Carreras.setVisible(false);
            Agregar_carrera.setVisible(false);
            jList3.setVisible(false);

        }
    }

    private void actualizar_lista2() {
        String[] model = new String[Vector_becas.size()];

        for (int i = 0; i < Vector_becas.size(); i++) {
            model[i] = Vector_becas.elementAt(i).getNombre() + ": " + Vector_becas.elementAt(i).getMatricula();
        }

        jList2.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = model;

            @Override
            public int getSize() {
                return strings.length;
            }

            @Override
            public String getElementAt(int i) {
                return strings[i];
            }
        });
    }

    private void borrar_lista2() {
        if (!jList2.isSelectionEmpty()) {
            int temp = jList2.getSelectedIndex();

            Vector_becas.remove(temp);

            actualizar_lista2();

        }
    }

    private void actualizar_lista3() {
        String[] model = new String[Vector_facultades.elementAt(jList1.getSelectedIndex()).getCarreras().size()];

        for (int i = 0; i < model.length; i++) {
            model[i] = Vector_facultades.elementAt(jList1.getSelectedIndex()).getCarreras().elementAt(i).getNombre() + ": " + Vector_facultades.elementAt(jList1.getSelectedIndex()).getCarreras().elementAt(i).getMatricula() + "(" + Vector_facultades.elementAt(jList1.getSelectedIndex()).getCarreras().elementAt(i).getDuracion() + " años)";
        }

        jList3.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = model;

            @Override
            public int getSize() {
                return strings.length;
            }

            @Override
            public String getElementAt(int i) {
                return strings[i];
            }
        });
    }

    private void borrar_lista3() {
        if (!jList3.isSelectionEmpty()) {
            int pos = jList1.getSelectedIndex();
            int temp = jList3.getSelectedIndex();
            matricula -= Vector_facultades.elementAt(pos).getCarreras().elementAt(temp).getMatricula();
            Matricula_total.setText(matricula + "");
            Vector_facultades.elementAt(pos).setMatricula(Vector_facultades.elementAt(pos).getMatricula() - Vector_facultades.elementAt(pos).getCarreras().elementAt(temp).getMatricula());
            Vector_facultades.elementAt(pos).getCarreras().remove(temp);

            actualizar_lista3();
            actualizar_lista1();
            jList1.setSelectedIndex(pos);
        }
    }


    private void BorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BorrarActionPerformed
        Point Menu = Menu_context.getLocationOnScreen();
        Point Lista1 = jList1.getLocationOnScreen();
        Point Lista2 = jList2.getLocationOnScreen();
        Point Lista3 = jList3.getLocationOnScreen();

        if (Menu.x >= Lista1.x && Menu.x <= (Lista1.x + jList1.getSize().width) && Menu.y >= Lista1.y && Menu.y <= (Lista1.y + jList1.getSize().height)) {
            borrar_lista_1();
        } else if (Menu.x >= Lista2.x && Menu.x <= (Lista2.x + jList2.getSize().width) && Menu.y >= Lista2.y && Menu.y <= (Lista2.y + jList2.getSize().height)) {
            borrar_lista2();
        } else if (Menu.x >= Lista3.x && Menu.x <= (Lista3.x + jList3.getSize().width) && Menu.y >= Lista3.y && Menu.y <= (Lista3.y + jList3.getSize().height)) {
            borrar_lista3();
        }
        Menu_context.setVisible(false);
    }//GEN-LAST:event_BorrarActionPerformed

    private void Editar_NombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Editar_NombreActionPerformed
        Point Menu = Menu_context.getLocationOnScreen();
        Point Lista1 = jList1.getLocationOnScreen();
        Point Lista2 = jList2.getLocationOnScreen();
        Point Lista3 = jList3.getLocationOnScreen();
        Menu_context.setVisible(false);
        try {
            if (Menu.x >= Lista1.x && Menu.x <= (Lista1.x + jList1.getSize().width) && Menu.y >= Lista1.y && Menu.y <= (Lista1.y + jList1.getSize().height)) {
                String X = JOptionPane.showInputDialog(this, "Añada el nombre de la facultad");
                if (X == null) {
                    throw new NumberFormatException();
                }
                Vector_facultades.elementAt(jList1.getSelectedIndex()).setNombre(X);
                actualizar_lista1();
            } else if (Menu.x >= Lista2.x && Menu.x <= (Lista2.x + jList2.getSize().width) && Menu.y >= Lista2.y && Menu.y <= (Lista2.y + jList2.getSize().height)) {
                String X = JOptionPane.showInputDialog(this, "Añada el nombre de la beca");
                if (X == null) {
                    throw new NumberFormatException();
                }
                Vector_becas.elementAt(jList2.getSelectedIndex()).setNombre(X);

                actualizar_lista2();
            } else if (Menu.x >= Lista3.x && Menu.x <= (Lista3.x + jList3.getSize().width) && Menu.y >= Lista3.y && Menu.y <= (Lista3.y + jList3.getSize().height)) {
                String X = JOptionPane.showInputDialog(this, "Añada el nombre de la carrera");
                if (X == null) {
                    throw new NumberFormatException();
                }
                Vector_facultades.elementAt(jList1.getSelectedIndex()).getCarreras().elementAt(jList3.getSelectedIndex()).setNombre(X);

                actualizar_lista3();
            }
        } catch (HeadlessException | NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Ha ocurrido un error. Inténtelo de nuevo");
        }
    }//GEN-LAST:event_Editar_NombreActionPerformed

    private void Editar_MatriculaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Editar_MatriculaActionPerformed
        Point Menu = Menu_context.getLocationOnScreen();
        Point Lista2 = jList2.getLocationOnScreen();
        Point Lista3 = jList3.getLocationOnScreen();
        Menu_context.setVisible(false);
        try {
            if (Menu.x >= Lista2.x && Menu.x <= (Lista2.x + jList2.getSize().width) && Menu.y >= Lista2.y && Menu.y <= (Lista2.y + jList2.getSize().height)) {
                String X = JOptionPane.showInputDialog(this, "Añada la matrícula de la beca");
                Vector_becas.elementAt(jList2.getSelectedIndex()).setMatricula(Integer.parseInt(X));
                actualizar_lista2();
            } else if (Menu.x >= Lista3.x && Menu.x <= (Lista3.x + jList3.getSize().width) && Menu.y >= Lista3.y && Menu.y <= (Lista3.y + jList3.getSize().height)) {
                int pos = jList1.getSelectedIndex();
                String X = JOptionPane.showInputDialog(this, "Añada la matrícula de la carrera");

                matricula -= Vector_facultades.elementAt(jList1.getSelectedIndex()).getCarreras().elementAt(jList3.getSelectedIndex()).getMatricula();
                Vector_facultades.elementAt(jList1.getSelectedIndex()).setMatricula(Vector_facultades.elementAt(jList1.getSelectedIndex()).getMatricula() - Vector_facultades.elementAt(jList1.getSelectedIndex()).getCarreras().elementAt(jList3.getSelectedIndex()).getMatricula());
                Vector_facultades.elementAt(jList1.getSelectedIndex()).getCarreras().elementAt(jList3.getSelectedIndex()).setMatricula(Integer.parseInt(X));
                Vector_facultades.elementAt(jList1.getSelectedIndex()).setMatricula(Vector_facultades.elementAt(jList1.getSelectedIndex()).getMatricula() + Vector_facultades.elementAt(jList1.getSelectedIndex()).getCarreras().elementAt(jList3.getSelectedIndex()).getMatricula());
                matricula += Vector_facultades.elementAt(jList1.getSelectedIndex()).getCarreras().elementAt(jList3.getSelectedIndex()).getMatricula();

                Matricula_total.setText(matricula + "");

                actualizar_lista3();
                actualizar_lista1();

                jList1.setSelectedIndex(pos);
            }
        } catch (HeadlessException | NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Ha ocurrido un error. Inténtelo de nuevo");
        }
    }//GEN-LAST:event_Editar_MatriculaActionPerformed

    private void Editar_DuraciónActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Editar_DuraciónActionPerformed
        Point Menu = Menu_context.getLocationOnScreen();
        Point Lista3 = jList3.getLocationOnScreen();
        Menu_context.setVisible(false);
        try {
            if (Menu.x >= Lista3.x && Menu.x <= (Lista3.x + jList3.getSize().width) && Menu.y >= Lista3.y && Menu.y <= (Lista3.y + jList3.getSize().height)) {
                int pos = jList1.getSelectedIndex();
                String X = JOptionPane.showInputDialog(this, "Añada la duración de la carrera");

                Vector_facultades.elementAt(pos).getCarreras().elementAt(jList3.getSelectedIndex()).setDuracion(Integer.parseInt(X));

                actualizar_lista3();
                actualizar_lista1();

                jList1.setSelectedIndex(pos);
            }
        } catch (HeadlessException | NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Ha ocurrido un error. Inténtelo de nuevo");
        }
    }//GEN-LAST:event_Editar_DuraciónActionPerformed

    private void EliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EliminarActionPerformed

        int question = JOptionPane.showConfirmDialog(this, "¡Está seguro que desea eliminar la universidad?");
        if (question != 0) {
            return;
        }
        Tupla<Entero, Entero> TEMP = G.restringir_universidad_anterior(Nombre_Universidad.getText());
        if (TEMP.getN2().getEntero() > 0) {
            int answer = JOptionPane.showConfirmDialog(this, "¡Desea usar la anterior disposición de esta universidad?");
            if (answer == 0) {
                G.habilitar_universidad(TEMP.getN1().getEntero());
            }
        }
        dispose();
    }//GEN-LAST:event_EliminarActionPerformed

    private void ActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ActualizarActionPerformed

        int question = JOptionPane.showConfirmDialog(this, "¡Está seguro que desea actualizar la universidad?");
        if (question != 0) {
            return;
        }

        try {
            
            String nombre = Nombre_Universidad.getText();
             if (revisar_facultades(Vector_facultades)) {
           throw new IllegalArgumentException();
             }
            Universidad U = new Universidad(nombre, matricula, Vector_becas, Vector_facultades);

            int id = G.restringir_universidad_anterior(U.getNombre()).getN1().getEntero();
            G.agregar_universidad(U, id);
            dispose();

        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(this, "Los datos introducidos no son correctos");
        }
    }//GEN-LAST:event_ActualizarActionPerformed

    private void AgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AgregarActionPerformed

        try {
            String nombre = Nombre_Universidad.getText();
            if (nombre.equals("") || Vector_facultades.isEmpty()) {
                throw new IllegalArgumentException();
            }
            if (revisar_facultades(Vector_facultades)) {
                throw new IllegalArgumentException();            }
            Universidad U = new Universidad(nombre, matricula, Vector_becas, Vector_facultades);
            if (G.revisar_nombre_universidad(U)) {
                JOptionPane.showMessageDialog(this, "Ya hay una universidad con este nombre");
            } else {
                G.agregar_universidad(U, -1);
                Sonido Sound = new Sonido();
                Sound.sonido("audio");
                dispose();
            }
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(this, "Los datos introducidos no son correctos");
        }
    }//GEN-LAST:event_AgregarActionPerformed

    private void jList3KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jList3KeyPressed

        if (evt.getKeyCode() == 8) {
            borrar_lista3();
        }

    }//GEN-LAST:event_jList3KeyPressed

    private void jList3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jList3MouseClicked
        Menu_context.setVisible(false);

        if (evt.getButton() == MouseEvent.BUTTON3) {
            if (!jList3.isSelectionEmpty()) {
                Menu_context.setVisible(true);
                Menu_context.setLocation(evt.getLocationOnScreen());
                Editar_Matricula.setVisible(true);
                Editar_Duración.setVisible(true);
                Menu_context.setPopupSize(110, 96);
            }
        }
    }//GEN-LAST:event_jList3MouseClicked

    private void Agregar_carreraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Agregar_carreraActionPerformed

        try {
            int pos = jList1.getSelectedIndex();
            String X = JOptionPane.showInputDialog(this, "Añada el nombre de la carrera");
            if (X == null) {
                throw new NumberFormatException();
            }
            String Y = JOptionPane.showInputDialog(this, "Añada la matrícula de la carrera");
            String Z = JOptionPane.showInputDialog(this, "Añada la duración de la carrera");
            Vector_facultades.elementAt(jList1.getSelectedIndex()).getCarreras().add(new Carrera(X, Integer.parseInt(Y), Integer.parseInt(Z)));
            Vector_facultades.elementAt(jList1.getSelectedIndex()).setMatricula(Vector_facultades.elementAt(jList1.getSelectedIndex()).getMatricula() + Integer.parseInt(Y));
            matricula += Integer.parseInt(Y);
            Matricula_total.setText(matricula + "");

            actualizar_lista3();
            actualizar_lista1();
            jList1.setSelectedIndex(pos);

        } catch (HeadlessException | NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Ha ocurrido un error. Inténtelo de nuevo");
        }
    }//GEN-LAST:event_Agregar_carreraActionPerformed

    private void Agregar_becaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Agregar_becaActionPerformed
        try {
            String X = JOptionPane.showInputDialog(this, "Añada el nombre de la beca");
            if (X == null) {
                throw new HeadlessException();
            }
            String Y = JOptionPane.showInputDialog(this, "Añada la matrícula de la beca");
            Beca B = new Beca(X, Integer.parseInt(Y));
            Vector_becas.add(B);

            actualizar_lista2();

        } catch (HeadlessException e) {
            JOptionPane.showMessageDialog(this, "Ha ocurrido un error. Inténtelo de nuevo");
        }
    }//GEN-LAST:event_Agregar_becaActionPerformed

    private void jList2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jList2KeyPressed
        if (evt.getKeyCode() == 8) {
            borrar_lista2();
        }
    }//GEN-LAST:event_jList2KeyPressed

    private void jList2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jList2MouseClicked
        Menu_context.setVisible(false);
        Editar_Duración.setVisible(false);

        if (evt.getButton() == MouseEvent.BUTTON3) {
            if (!jList2.isSelectionEmpty()) {
                Menu_context.setVisible(true);
                Editar_Matricula.setVisible(true);
                Menu_context.setLocation(evt.getLocationOnScreen());
                Menu_context.setPopupSize(110, 72);
            }
        }
    }//GEN-LAST:event_jList2MouseClicked

    private void Agregar_facultadMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Agregar_facultadMouseClicked
        try {
            int pos = jList1.getSelectedIndex();
            String X = JOptionPane.showInputDialog(this, "Añada el nombre de la facultad");
            if (X == null) {
                throw new HeadlessException();
            }
            Facultad F = new Facultad(X, 0, new Vector<>());
            Vector_facultades.add(F);

            actualizar_lista1();

            jList1.setSelectedIndex(pos);
        } catch (HeadlessException e) {

        }
    }//GEN-LAST:event_Agregar_facultadMouseClicked

    private void jList1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jList1KeyPressed

        if (evt.getKeyCode() == 8) {
            borrar_lista_1();
        }
    }//GEN-LAST:event_jList1KeyPressed

    private void jList1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jList1MouseClicked
        Editar_Matricula.setVisible(false);
        Editar_Duración.setVisible(false);
        Menu_context.setVisible(false);

        if (evt.getButton() == MouseEvent.BUTTON1) {
            if (!jList1.isSelectionEmpty()) {
                Carreras.setVisible(true);
                Agregar_carrera.setVisible(true);
                jList3.setVisible(true);
                jList3.removeAll();

                actualizar_lista3();
            } else {
                Carreras.setVisible(false);
                Agregar_carrera.setVisible(false);
                jList3.setVisible(false);
            }
        } else if (evt.getButton() == MouseEvent.BUTTON3) {
            if (!jList1.isSelectionEmpty()) {
                Menu_context.setVisible(true);
                Menu_context.setLocation(evt.getLocationOnScreen());
                Menu_context.setPopupSize(110, 48);
            }
        }
    }//GEN-LAST:event_jList1MouseClicked

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        Principal P = new Principal();
        Menu_context.setVisible(false);
        P.setVisible(true);
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
    private javax.swing.JButton Actualizar;
    private javax.swing.JButton Agregar;
    private javax.swing.JButton Agregar_beca;
    private javax.swing.JButton Agregar_carrera;
    private javax.swing.JButton Agregar_facultad;
    private javax.swing.JLabel Becas;
    private javax.swing.JMenuItem Borrar;
    private javax.swing.JLabel Carreras;
    private javax.swing.JMenuItem Editar_Duración;
    private javax.swing.JMenuItem Editar_Matricula;
    private javax.swing.JMenuItem Editar_Nombre;
    private javax.swing.JButton Eliminar;
    private javax.swing.JLabel Facultades;
    private javax.swing.JScrollPane Lista_becas;
    private javax.swing.JScrollPane Lista_carreras;
    private javax.swing.JScrollPane Lista_facultades;
    private javax.swing.JLabel Matricula_total;
    private javax.swing.JPopupMenu Menu_context;
    private javax.swing.JTextField Nombre_Universidad;
    private javax.swing.JList<String> jList1;
    private javax.swing.JList<String> jList2;
    private javax.swing.JList<String> jList3;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables

    private boolean revisar_facultades(Vector<Facultad> v) {
        boolean flag = false;
        for (int i = 0; i < v.size(); i++) {
            if (v.elementAt(i).getCarreras().isEmpty()) {
                flag = true;
                break;
            }
        }
        return flag;
    }
}