package lenguajesAutomatasI;

import java.util.Random;
import javax.swing.JOptionPane;

/**
 * Programa en Java que genera una matriz de 5x10 donde los renglones represent-
 * aran los 10 dígitos del sistema decimal y las columnas representan las 5 voc-
 * ales. La matriz es llenada con números aleatorios del 0 al 10, posteriormente
 * debe leer una cadena String de letras y esta cadena debe ir moviéndose en la
 * matriz.
 *
 * Lenguajes Autómatas I (11 - 12 hrs) MC Juan Fraustro de la O.
 *
 * @author Brandon Alexis Prado Castro, Braulio Dávila Saucedo
 * @version 1.0.19.02.2023
 */
public class MatrizLocaGUI extends javax.swing.JFrame {

    //Se declara la matriz de 10 filas por 5 columnas en modo global
    private static int[][] matriz = new int[10][5];

    public void GenerarMatriz() {

        //Se declara la variable que tendra los valores aleatorios
        Random numAleatorio = new Random();

        // Llenar matriz con números aleatorios del 0 al 10
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                matriz[i][j] = numAleatorio.nextInt(11);
            }
        }

        // Imprimir matriz
        String datoMatriz = "";
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                datoMatriz += matriz[i][j] + " | ";
            }
            if (i != matriz.length - 1) {
                datoMatriz += "\n";
            }
        }
        TxtMatrizGenerada.setText(datoMatriz);
    }

    public void MatrizLocaProceso() {
        //Valor obtenido de la caja de texto
        String cadena = TxtCadena.getText();
        //Dato generado en cada iteracción
        String datoProgreso = "La búsqueda inicia en la fila 0\n\n";
        //El proceso siempre va a iniciar en la fila 0 y este irá cambiando
        //cuando no se encuentre un 10
        int fila = 0;
        //Bandera que nos indica si fue encontrado para abortar programa
        Boolean encontrado = false;
        //Recorrer la palabra o frase ingresada
        for (int letra = 0; letra < cadena.length(); letra++) {
            TxtProceso.setText(datoProgreso);
            char caracter = cadena.charAt(letra);
            datoProgreso += (letra + 1) + ". Carácter analizado: " + caracter + "\n";

            switch (caracter) {
                case 'a':
                    if (10 == matriz[fila][0]) {
                        datoProgreso += " → Éxito se ha encontrado el 10 en la fila: " + fila + " columna: a\n";
                        encontrado = true;
                        //Habilita botones y caja de texto para una nueva búsqueda
                        BtnLimpiar.setEnabled(true);
                        TxtCadena.setEnabled(true);
                        BtnIniciar.setEnabled(true);
                    } else {
                        fila = matriz[fila][0];
                        datoProgreso += " → No encontrado, cambiando a fila: " + fila + "\n";
                    }
                    break;

                case 'e':
                    if (10 == matriz[fila][1]) {
                        datoProgreso += " → Éxito se ha encontrado el 10 en la fila: " + fila + " columna: e\n";
                        encontrado = true;
                        //Habilita botones y caja de texto para una nueva búsqueda
                        BtnLimpiar.setEnabled(true);
                        TxtCadena.setEnabled(true);
                        BtnIniciar.setEnabled(true);
                    } else {
                        fila = matriz[fila][1];
                        datoProgreso += " → No encontrado, cambiando a fila: " + fila + "\n";
                    }
                    break;

                case 'i':
                    if (10 == matriz[fila][2]) {
                        datoProgreso += " → Éxito se ha encontrado el 10 en la fila: " + fila + " columna: i\n";
                        encontrado = true;
                        BtnLimpiar.setEnabled(true);
                        TxtCadena.setEnabled(true);
                        BtnIniciar.setEnabled(true);
                    } else {
                        fila = matriz[fila][2];
                        datoProgreso += " → No encontrado, cambiando a fila: " + fila + "\n";
                    }
                    break;

                case 'o':
                    if (10 == matriz[fila][3]) {
                        datoProgreso += " → Éxito se ha encontrado el 10 en la fila: " + fila + " columna: o\n";
                        encontrado = true;
                        //Habilita botones y caja de texto para una nueva búsqueda
                        BtnLimpiar.setEnabled(true);
                        TxtCadena.setEnabled(true);
                        BtnIniciar.setEnabled(true);
                    } else {
                        fila = matriz[fila][3];
                        datoProgreso += " → No encontrado, cambiando a fila: " + fila + "\n";
                    }
                    break;

                case 'u':
                    if (10 == matriz[fila][4]) {
                        datoProgreso += " → Éxito se ha encontrado el 10 en la fila: " + fila + " columna: u\n";
                        encontrado = true;
                        //Habilita botones y caja de texto para una nueva búsqueda
                        BtnLimpiar.setEnabled(true);
                        TxtCadena.setEnabled(true);
                        BtnIniciar.setEnabled(true);
                    } else {
                        fila = matriz[fila][4];
                        datoProgreso += " → No encontrado, cambiando a fila: " + fila + "\n";
                    }
                    break;

                default:
                    datoProgreso += " → No es vocal, seguimos con el sig. carácter, pero en la misma fila: " + fila + "\n";
                    break;

            }

            //Si la letra coincide con el 10 entonces se habrá encontrado
            //y sale del ciclo
            if (encontrado) {
                break;
            }

        }

        //Notifica al usuario cual fue el resultado
        if (!encontrado) {
            datoProgreso += "\n*** Proceso fallido ***";
            TxtProceso.setText(datoProgreso);
        } else {
            datoProgreso += "\n*** Proceso exitoso ***";
            TxtProceso.setText(datoProgreso);
        }

        //Habilita los botones para una nueva busqueda
        BtnLimpiar.setEnabled(true);
        TxtCadena.setEnabled(true);
        BtnIniciar.setEnabled(true);
    }

    //Creación del formulario (iniciando el contructor qeu contiene la GUI)
    public MatrizLocaGUI() {
        initComponents();
    }

    //Este método contiene la GUI del formulario, botones y cajas de texto
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanelPrincipal = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TxtMatrizGenerada = new javax.swing.JTextArea();
        BtnGenerarMatriz = new javax.swing.JButton();
        BtnLimpiar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextPane2 = new javax.swing.JTextPane();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTextPane3 = new javax.swing.JTextPane();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        TxtCadena = new javax.swing.JTextPane();
        BtnIniciar = new javax.swing.JButton();
        jScrollPane6 = new javax.swing.JScrollPane();
        TxtProceso = new javax.swing.JTextArea();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setAlwaysOnTop(true);
        setResizable(false);

        PanelPrincipal.setFocusable(false);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("MATRIZ LOCA");

        jLabel3.setText("Matriz generada con números aleatorios:");

        TxtMatrizGenerada.setEditable(false);
        TxtMatrizGenerada.setColumns(20);
        TxtMatrizGenerada.setRows(5);
        TxtMatrizGenerada.setTabSize(10);
        TxtMatrizGenerada.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jScrollPane1.setViewportView(TxtMatrizGenerada);

        BtnGenerarMatriz.setText("Generar");
        BtnGenerarMatriz.setToolTipText("Haz clic para generar la matriz");
        BtnGenerarMatriz.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnGenerarMatrizActionPerformed(evt);
            }
        });

        BtnLimpiar.setText("Limpiar");
        BtnLimpiar.setToolTipText("Haz clic para limpiar la matriz");
        BtnLimpiar.setEnabled(false);
        BtnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnLimpiarActionPerformed(evt);
            }
        });

        jTextPane1.setEditable(false);
        jTextPane1.setContentType("0\n1\n2\n3"); // NOI18N
        jTextPane1.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jTextPane1.setText("0\n1\n2\n3\n4\n5\n6\n7\n8\n9");
        jScrollPane2.setViewportView(jTextPane1);

        jTextPane2.setEditable(false);
        jTextPane2.setContentType("0\n1\n2\n3"); // NOI18N
        jTextPane2.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jScrollPane3.setViewportView(jTextPane2);

        jTextPane3.setEditable(false);
        jTextPane3.setContentType("0\n1\n2\n3"); // NOI18N
        jTextPane3.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jTextPane3.setText("a       e       i      o       u");
        jScrollPane4.setViewportView(jTextPane3);

        jLabel4.setText("Ingresa la cadena:");

        TxtCadena.setEnabled(false);
        jScrollPane5.setViewportView(TxtCadena);

        BtnIniciar.setText("Iniciar");
        BtnIniciar.setToolTipText("Haz clic para iniciar la búsqueda");
        BtnIniciar.setEnabled(false);
        BtnIniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnIniciarActionPerformed(evt);
            }
        });

        TxtProceso.setEditable(false);
        TxtProceso.setColumns(20);
        TxtProceso.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        TxtProceso.setRows(5);
        TxtProceso.setTabSize(10);
        TxtProceso.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jScrollPane6.setViewportView(TxtProceso);

        jLabel5.setText("Proceso:");

        javax.swing.GroupLayout PanelPrincipalLayout = new javax.swing.GroupLayout(PanelPrincipal);
        PanelPrincipal.setLayout(PanelPrincipalLayout);
        PanelPrincipalLayout.setHorizontalGroup(
            PanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(PanelPrincipalLayout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(PanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelPrincipalLayout.createSequentialGroup()
                        .addGroup(PanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(PanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PanelPrincipalLayout.createSequentialGroup()
                                .addGroup(PanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, PanelPrincipalLayout.createSequentialGroup()
                                        .addGap(205, 205, 205)
                                        .addComponent(BtnIniciar, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(PanelPrincipalLayout.createSequentialGroup()
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(PanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(BtnGenerarMatriz, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(BtnLimpiar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(PanelPrincipalLayout.createSequentialGroup()
                                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(PanelPrincipalLayout.createSequentialGroup()
                        .addGroup(PanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3)
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 346, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 39, Short.MAX_VALUE))))
        );
        PanelPrincipalLayout.setVerticalGroup(
            PanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelPrincipalLayout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addGroup(PanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelPrincipalLayout.createSequentialGroup()
                        .addComponent(BtnGenerarMatriz)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BtnLimpiar))
                    .addGroup(PanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(PanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(BtnIniciar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane5))
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(PanelPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 7, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtnIniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnIniciarActionPerformed
        if ("".equals(TxtCadena.getText())) {
            JOptionPane.showMessageDialog(null, "Cadena vacía, ingresa una cadena de texto");
        } else {
            //Inhabilita botones y caja de texto
            TxtCadena.setEnabled(false);
            BtnGenerarMatriz.setEnabled(false);
            BtnLimpiar.setEnabled(false);
            BtnIniciar.setEnabled(false);
            //Inicia proceso de búsqueda
            MatrizLocaProceso();
        }
    }//GEN-LAST:event_BtnIniciarActionPerformed

    private void BtnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnLimpiarActionPerformed
        //Limpia la matriz y caja de texto
        TxtMatrizGenerada.setText("");
        TxtCadena.setText("");
        TxtCadena.setEnabled(false);
        TxtProceso.setText("");
        //Inhabilita botones
        BtnLimpiar.setEnabled(false);
        BtnIniciar.setEnabled(false);
        //Habilita el botón generar
        BtnGenerarMatriz.setEnabled(true);
    }//GEN-LAST:event_BtnLimpiarActionPerformed

    private void BtnGenerarMatrizActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnGenerarMatrizActionPerformed
        //Llama el método genera matriz
        GenerarMatriz();
        //Habilita botones y caja de texto
        BtnLimpiar.setEnabled(true);
        TxtCadena.setEnabled(true);
        BtnIniciar.setEnabled(true);
    }//GEN-LAST:event_BtnGenerarMatrizActionPerformed

    //Método Main
    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MatrizLocaGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MatrizLocaGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MatrizLocaGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MatrizLocaGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MatrizLocaGUI().setVisible(true);
            }
        });
    }

    // Variables asociadas a cada panel, boton y caja de texto
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton BtnGenerarMatriz;
    public javax.swing.JButton BtnIniciar;
    public javax.swing.JButton BtnLimpiar;
    private javax.swing.JPanel PanelPrincipal;
    public javax.swing.JTextPane TxtCadena;
    private javax.swing.JTextArea TxtMatrizGenerada;
    private javax.swing.JTextArea TxtProceso;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTextPane jTextPane1;
    private javax.swing.JTextPane jTextPane2;
    private javax.swing.JTextPane jTextPane3;
    // End of variables declaration//GEN-END:variables
}
