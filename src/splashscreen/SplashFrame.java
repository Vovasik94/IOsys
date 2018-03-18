package splashscreen;

import java.awt.Dimension;
import java.awt.Toolkit;

public class SplashFrame extends javax.swing.JFrame {

   public SplashFrame() {
    initComponents();
    setLocationRelativeTo(null);
   }
   

        @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        sspanel = new javax.swing.JPanel();
        load_lable = new javax.swing.JLabel();
        percent_lable = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.WAIT_CURSOR));
        setName("ssframe"); // NOI18N
        setUndecorated(true);
        setResizable(false);

        sspanel.setBackground(new java.awt.Color(255, 255, 255));
        sspanel.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(153, 206, 230)));
        sspanel.setPreferredSize(new java.awt.Dimension(300, 300));

        load_lable.setBackground(new java.awt.Color(255, 255, 255));
        load_lable.setFont(new java.awt.Font("Century Gothic", 0, 23)); // NOI18N
        load_lable.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        load_lable.setText("Загрузка...");

        percent_lable.setFont(new java.awt.Font("Century Gothic", 0, 20)); // NOI18N
        percent_lable.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        percent_lable.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/lg.circle-slack-loading-icon.gif"))); // NOI18N
        percent_lable.setText("jLabel2");
        percent_lable.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout sspanelLayout = new javax.swing.GroupLayout(sspanel);
        sspanel.setLayout(sspanelLayout);
        sspanelLayout.setHorizontalGroup(
            sspanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(load_lable, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(sspanelLayout.createSequentialGroup()
                .addGap(0, 1, Short.MAX_VALUE)
                .addComponent(percent_lable, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        sspanelLayout.setVerticalGroup(
            sspanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sspanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(load_lable)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(percent_lable, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(sspanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(sspanel, javax.swing.GroupLayout.PREFERRED_SIZE, 300, Short.MAX_VALUE)
        );

        setBounds(0, 0, 300, 300);
    }// </editor-fold>//GEN-END:initComponents

   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel load_lable;
    protected javax.swing.JLabel percent_lable;
    private javax.swing.JPanel sspanel;
    // End of variables declaration//GEN-END:variables
}
