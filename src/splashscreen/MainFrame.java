/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package splashscreen;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.RenderingHints;
import java.awt.Stroke;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFormattedTextField;
import javax.swing.JSpinner;
import javax.swing.Timer;



/**
 *
 * @author metz9
 */
public class MainFrame extends javax.swing.JFrame {
       private BufferedImage image;
       private Graphics graphics;
       private Graphics2D graphics2d;
    
       private ImageIcon KBimage = new ImageIcon();
       
       private Timer animation = null;
//       private boolean animating = false;
       private int animateX = 0;
       private int animateY = 0;
       
      /**
     * Creates new form MainFrame
     */
    public MainFrame() {
        initComponents();
        setLocationRelativeTo(null);
        setTitle("Модель подсистемы ввода-вывода"); 
         
        setIconImage(new ImageIcon(getClass().getResource("/img/tittle.png")).getImage());
        jDialog1.setTitle("Параметры моделирования");
        jDialog1.setSize(460, 330);
        jDialog1.setLocationRelativeTo(null);
        ScanLabel.setVisible(false);
        TaktButton.setVisible(false);
        Hellowlabel.setVisible(false);
        JFormattedTextField cpuPerformance = ((JSpinner.DefaultEditor)jSpinner1.getEditor())
        .getTextField();
        cpuPerformance.setSelectedTextColor(Color.black);
        cpuPerformance.setSelectionColor(Color.white);
        cpuPerformance.setEditable(false);
//        jTable1.setTableHeader(null);  
    }

    
//    public void paint (Graphics g){
//        super.paint(g);
//        
////        g.setFont(new Font("Century Gothic", 0, 15));
////        g.drawRect(540, 270, 150, 150);
////        
////        g.drawString("Северный мост", 555, 350);
////        g.drawRect(540, 500, 150, 150);
////        Graphics2D g2 = (Graphics2D) g;
////        g2.setFont(new Font("Century Gothic", 1, 15));
////        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
////        RenderingHints.VALUE_ANTIALIAS_ON);
////        Stroke s1 = new BasicStroke(1.5f);
////        g2.setStroke(s1);
////        g2.drawRect(443, 688, 40, 80);
////        g2.drawRect(540, 270, 150, 150);
////        g2.drawString("Северный мост", 555, 350);
////        g2.drawRect(540, 500, 150, 150);
////        g2.drawString("Южный мост", 565, 580);
////        g2.drawRect(575, 610, 80, 40);
////        int[] arrayX1 = {415, 440, 440, 514, 514, 539, 514, 514, 440, 440};
////        int[] arrayY1 = {350, 375, 365, 365, 375, 350, 325, 335, 335, 325};
////        Polygon poly1 = new Polygon(arrayX1, arrayY1, arrayX1.length);
////        g2.drawPolygon(poly1);
////        int[] arrayX2 = {144, 169, 169, 262, 262, 169, 169};
////        int[] arrayY2 = {350, 375, 365, 365, 335, 335, 325};
////        Polygon poly2 = new Polygon(arrayX2, arrayY2, arrayX2.length);
////        g2.drawPolygon(poly2);
////        int[] arrayX3 = {691, 716, 716, 796, 796, 821, 796, 796, 716, 716};
////        int[] arrayY3 = {350, 375, 365, 365, 375, 350, 325, 335, 335, 325};
////        Polygon poly3 = new Polygon(arrayX3, arrayY3, arrayX3.length);
////        g2.drawPolygon(poly3);
////        int[] arrayX4 = {485, 510, 510, 630, 630, 640, 615, 590, 600, 600, 510, 510};
////        int[] arrayY4 = {730, 755, 745, 745, 676, 676, 651, 676, 676, 715, 715, 705};
////        Polygon poly4 = new Polygon(arrayX4, arrayY4, arrayX4.length);
////        g2.drawPolygon(poly4);
////        int[] arrayX5 = {615, 590, 600, 600, 590, 615, 640, 630, 630, 640};
////        int[] arrayY5 = {497, 472, 472, 452, 452, 423, 452, 452, 472, 472};
////        Polygon poly5 = new Polygon(arrayX5, arrayY5, arrayX5.length);
////        g2.drawPolygon(poly5);
//    }
    
     private void animateKBtoSB(){
        if (animation != null && animation.isRunning()) {
            return;
        }      
        animateX = 0;
        animateY = 0;
        ScanLabel.setVisible(true);
        KBlabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/keyboard_back.png")));
        KBtoSBlabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/KBtoSB_back.png")));
        animation = new Timer (15, new ActionListener()
    {
      public void actionPerformed ( ActionEvent e )
      {
        if (animateX < 151) {
          animateX += 6;
          ScanLabel.setLocation(440+animateX,642);
          
        }
        else if (animateY < 67) {
            if (animateY == 0){
                ScanLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Scanhor.png")));
            }
            animateY += 6;
            ScanLabel.setLocation(572,642-animateY);  
        }
        else if (animateY == 72){        
            KBlabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/keyboard.png")));
            ScanLabel.setLocation(572,568);
            KBtoSBlabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/KBtoSB.png")));
            animation.stop ();            
        }
      }
    } );
        animation.start ();
  }
     
     private void animateSBtoCPU(){
        if ( animation != null && animation.isRunning () ) {
            return;
        }
        
    animateX = 0;
    animateY = 0;
    ScanLabel.setVisible(true);
    animation = new Timer ( 15, new ActionListener()
    {
      public void actionPerformed ( ActionEvent e )
      {
        if (animateY < 475)
        {
            animateY += 6;
            ScanLabel.setLocation(572, 568-animateY);
            switch (animateY) {
                case 120:
                    SBtoNBlabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/SBtoNB_back.png")));
                    break;
                case 324:
                    SBtoNBlabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/SBtoNB.png")));
                    break;
                case 330:
                    NBtoCPUlabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/CPUtoNB_back.png")));
                    break;
                default:
                    break;
            }
        }
        else if (animateX < 97){
            if (animateX == 0) {
                ScanLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/scan.png")));
            }
            animateX += 3;
            ScanLabel.setLocation(572-animateX, 78);
            
        }
        else if (animateX == 99){
            NBtoCPUlabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/CPUtoNB.png")));
            animation.stop ();
            
        }
      }
    } );
        animation.start ();
  }
  
          
     private void animateInterrupt(){
        if ( animation != null && animation.isRunning () ) {
            return;
        }
        
        animateX = 0;      
        animation = new Timer ( 15, new ActionListener()
        {
          public void actionPerformed ( ActionEvent e )
          {
              
              switch (animateX) {
                  case 0:
                      Interruptlabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/arrow1.png")));
                      break;
                  case 100:
                      Interruptlabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/arrow2.png")));
                      break;
                  case 200:
                      Interruptlabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/arrow.png")));
                      animation.stop ();
                      break;
                  default:
                      break;
              }
             animateX ++;
         
         
          }
        } );
        animation.start ();
  }
     
    private void animateCPUtoRAM(){
        if ( animation != null && animation.isRunning () ) {
            return;
        }
        animateX = 0;
        animateY = 0;
        ScanLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/symbcode_hor.png")));
        CPUlabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/cpu_back.png")));
        NBtoCPUlabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/CPUtoNB_back.png")));
        
        animation = new Timer ( 15, new ActionListener()
        {
          public void actionPerformed ( ActionEvent e )
          {
              
             if( animateX <= 108) {           
                 animateX += 6; 
                 ScanLabel.setLocation(476 + animateX, 78);
             }    
             else if (animateY <= 204) {
                 if (animateY == 0){
                     ScanLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/symbcode.png")));
                 }
                 animateY += 6;
                 ScanLabel.setLocation(572, 78 + animateY);                 
             }
             else if (animateY == 210) {
                CPUlabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/cpu.png")));
                NBtoCPUlabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/CPUtoNB.png")));
                animateY += 1;
             }
             else if (animateY >= 211 &&  animateY < 482) {
                   if (animateY == 283) {
                       NBtoRAMlabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/NBtoRAM_back.png")));
                       RAMlabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/RAM_back.png")));
                   }
                   if (animateY == 481){
                       NBtoRAMlabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/NBtoRAM.png")));
                       RAMlabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/RAM.png")));
                       ScanLabel.setVisible(false);
                   }
                    animateY += 6;
                    ScanLabel.setLocation(355 + animateY, 288);
             }
             else {
                animation.stop ();
             }            
         
          }
        } );
            animation.start ();
    }
     
          private void animateRAMtoVideo(){
        if ( animation != null && animation.isRunning () ) {
            return;
        }  
        animateX = 0;
        RAMlabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/RAM_back.png")));
        NBtoRAMlabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/NBtoRAM_back.png")));
        ScanLabel.setVisible(true);
        animation = new Timer ( 15, new ActionListener()
        {
          public void actionPerformed ( ActionEvent e )
          {
              
             if( animateX < 547) {
                 switch (animateX) {
                     case 198:
                         NBtoRAMlabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/NBtoRAM.png")));
                         RAMlabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/RAM.png")));
                         break;
                     case 264:
                         NBtoVideolabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/NBtoRAM_back.png")));
                         Vcardlabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/vcard_back.png")));
                         break;                   
                     case 540:
                         NBtoVideolabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/NBtoRAM.png")));
                         break;
                     default:
                         break;
                 }                
                 ScanLabel.setLocation(842 - animateX, 288);
             }
             
             else {
                ScanLabel.setVisible(false);
                animation.stop ();
             }            
             animateX += 6; 
          }
        } );
        animation.start ();
  }
          
          private void animateVideoToMon(){
        if ( animation != null && animation.isRunning () ) {
            return;
        }   
        animateX = 0;
        Hellowlabel.setVisible(true);
        VcardToMonlabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/VcardtoMon_back.png")));
        Monlabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/monitor_back.png")));
        animation = new Timer ( 15, new ActionListener()
        {
          public void actionPerformed ( ActionEvent e )
          {
              
             if ( animateX == 108) {
                Monlabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/monitor.png")));
                Vcardlabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/vcard.png")));
                VcardToMonlabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/VcardtoMon.png"))); 
                Hellowlabel.setVisible(false);
                ScanLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/scan.png")));
                animation.stop ();
             }          
            
             animateX += 6; 
          }
        } );
        animation.start ();
  }
   
     
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDialog1 = new javax.swing.JDialog();
        jPanel1 = new javax.swing.JPanel();
        Okbtn = new javax.swing.JButton();
        Cancelbtn = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jSpinner1 = new javax.swing.JSpinner();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        WithoutInputBox = new javax.swing.JCheckBox();
        jSlider1 = new javax.swing.JSlider();
        jSlider2 = new javax.swing.JSlider();
        jScrollPane1 = new javax.swing.JScrollPane();
        CPUField = new javax.swing.JTextPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        IOField = new javax.swing.JTextPane();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        OutputMonBox = new javax.swing.JCheckBox();
        jScrollPane4 = new javax.swing.JScrollPane();
        IOSymbField = new javax.swing.JTextPane();
        jSlider4 = new javax.swing.JSlider();
        MainFramePanel = new javax.swing.JPanel();
        CPUlabel = new javax.swing.JLabel();
        RAMlabel = new javax.swing.JLabel();
        Hellowlabel = new javax.swing.JLabel();
        Monlabel = new javax.swing.JLabel();
        Vcardlabel = new javax.swing.JLabel();
        ScanLabel = new javax.swing.JLabel();
        KBPlacelabel = new javax.swing.JLabel();
        KBlabel = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        SBtoNBlabel = new javax.swing.JLabel();
        NBlabel = new javax.swing.JLabel();
        SBlabel = new javax.swing.JLabel();
        KBtoSBlabel = new javax.swing.JLabel();
        NBtoVideolabel = new javax.swing.JLabel();
        NBtoRAMlabel = new javax.swing.JLabel();
        VcardToMonlabel = new javax.swing.JLabel();
        KBPlacelabel1 = new javax.swing.JLabel();
        NBtoCPUlabel = new javax.swing.JLabel();
        TaktButton = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        Interruptlabel = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        FileMenu = new javax.swing.JMenu();
        StartMenuItem = new javax.swing.JMenuItem();
        ClearMenuItem = new javax.swing.JMenuItem();
        OptionsMenuItem = new javax.swing.JMenuItem();
        ExitMenuItem = new javax.swing.JMenuItem();
        SelectModeMenu = new javax.swing.JMenu();
        PerpetualMenuItem = new javax.swing.JRadioButtonMenuItem();
        TaktMenuItem = new javax.swing.JRadioButtonMenuItem();
        AboutMenu = new javax.swing.JMenu();

        jDialog1.setModalityType(java.awt.Dialog.ModalityType.APPLICATION_MODAL);
        jDialog1.setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(407, 300));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Okbtn.setFont(new java.awt.Font("Century Gothic", 0, 13)); // NOI18N
        Okbtn.setText("ОК");
        Okbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OkbtnActionPerformed(evt);
            }
        });
        jPanel1.add(Okbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 260, 60, -1));

        Cancelbtn.setFont(new java.awt.Font("Century Gothic", 0, 13)); // NOI18N
        Cancelbtn.setText("Назад");
        Cancelbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelbtnActionPerformed(evt);
            }
        });
        jPanel1.add(Cancelbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 260, -1, -1));

        jLabel4.setFont(new java.awt.Font("Century Gothic", 0, 13)); // NOI18N
        jLabel4.setText("Быстродействие ЦПУ, млн операций");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, 250, -1));

        jSpinner1.setFont(new java.awt.Font("Century Gothic", 0, 13)); // NOI18N
        jSpinner1.setModel(new javax.swing.SpinnerNumberModel(10, 10, 100, 1));
        jSpinner1.setMinimumSize(new java.awt.Dimension(50, 23));
        jSpinner1.setPreferredSize(new java.awt.Dimension(62, 23));
        jPanel1.add(jSpinner1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 210, 50, -1));

        jLabel1.setFont(new java.awt.Font("Century Gothic", 0, 13)); // NOI18N
        jLabel1.setText("Кол-во процессорных команд, млн");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 240, -1));

        jLabel2.setFont(new java.awt.Font("Century Gothic", 0, 13)); // NOI18N
        jLabel2.setText("Кол-во операций ввода/вывода");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 240, -1));

        jLabel3.setFont(new java.awt.Font("Century Gothic", 0, 13)); // NOI18N
        jLabel3.setText("Кол-во вводимых/выводимых символов");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, -1, -1));

        WithoutInputBox.setBackground(new java.awt.Color(255, 255, 255));
        WithoutInputBox.setFont(new java.awt.Font("Century Gothic", 0, 13)); // NOI18N
        WithoutInputBox.setEnabled(false);
        WithoutInputBox.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        WithoutInputBox.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jPanel1.add(WithoutInputBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 170, 40, -1));

        jSlider1.setBackground(new java.awt.Color(255, 255, 255));
        jSlider1.setMajorTickSpacing(100);
        jSlider1.setMaximum(1000);
        jSlider1.setMinimum(100);
        jSlider1.setMinorTickSpacing(50);
        jSlider1.setPaintTicks(true);
        jSlider1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSlider1StateChanged(evt);
            }
        });
        jPanel1.add(jSlider1, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 10, 120, -1));

        jSlider2.setBackground(new java.awt.Color(255, 255, 255));
        jSlider2.setMajorTickSpacing(10);
        jSlider2.setMinorTickSpacing(5);
        jSlider2.setPaintTicks(true);
        jSlider2.setValue(0);
        jSlider2.setName(""); // NOI18N
        jSlider2.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSlider2StateChanged(evt);
            }
        });
        jPanel1.add(jSlider2, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 50, 120, -1));

        CPUField.setEditable(false);
        CPUField.setFont(new java.awt.Font("Century Gothic", 0, 13)); // NOI18N
        CPUField.setText("100");
        CPUField.setSelectedTextColor(new java.awt.Color(0, 0, 0));
        CPUField.setSelectionColor(new java.awt.Color(255, 255, 255));
        jScrollPane1.setViewportView(CPUField);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 10, 40, -1));

        IOField.setEditable(false);
        IOField.setFont(new java.awt.Font("Century Gothic", 0, 13)); // NOI18N
        IOField.setText("0");
        IOField.setToolTipText("");
        IOField.setSelectedTextColor(new java.awt.Color(0, 0, 0));
        IOField.setSelectionColor(new java.awt.Color(255, 255, 255));
        jScrollPane2.setViewportView(IOField);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 50, 40, -1));

        jLabel5.setFont(new java.awt.Font("Century Gothic", 0, 13)); // NOI18N
        jLabel5.setText("Режим без операций ввода");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, -1, -1));

        jLabel6.setFont(new java.awt.Font("Century Gothic", 0, 13)); // NOI18N
        jLabel6.setText("Вывод символов на экран");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, -1, -1));

        OutputMonBox.setBackground(new java.awt.Color(255, 255, 255));
        OutputMonBox.setFont(new java.awt.Font("Century Gothic", 0, 13)); // NOI18N
        OutputMonBox.setEnabled(false);
        OutputMonBox.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        OutputMonBox.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jPanel1.add(OutputMonBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 130, 40, -1));

        IOSymbField.setEditable(false);
        IOSymbField.setBackground(javax.swing.UIManager.getDefaults().getColor("Button.background"));
        IOSymbField.setFont(new java.awt.Font("Century Gothic", 0, 13)); // NOI18N
        IOSymbField.setText("1");
        IOSymbField.setToolTipText("");
        IOSymbField.setSelectedTextColor(new java.awt.Color(0, 0, 0));
        IOSymbField.setSelectionColor(javax.swing.UIManager.getDefaults().getColor("Button.background"));
        jScrollPane4.setViewportView(IOSymbField);

        jPanel1.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 90, 40, -1));

        jSlider4.setBackground(new java.awt.Color(255, 255, 255));
        jSlider4.setMajorTickSpacing(2);
        jSlider4.setMaximum(20);
        jSlider4.setMinimum(1);
        jSlider4.setMinorTickSpacing(1);
        jSlider4.setPaintTicks(true);
        jSlider4.setValue(1);
        jSlider4.setEnabled(false);
        jSlider4.setName(""); // NOI18N
        jSlider4.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSlider4StateChanged(evt);
            }
        });
        jPanel1.add(jSlider4, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 90, 120, -1));

        javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(jDialog1.getContentPane());
        jDialog1.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 460, Short.MAX_VALUE)
        );
        jDialog1Layout.setVerticalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        MainFramePanel.setBackground(new java.awt.Color(255, 255, 255));
        MainFramePanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        CPUlabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/cpu.png"))); // NOI18N
        MainFramePanel.add(CPUlabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 20, -1, -1));

        RAMlabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/RAM.png"))); // NOI18N
        MainFramePanel.add(RAMlabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 240, -1, -1));

        Hellowlabel.setFont(new java.awt.Font("Century Gothic", 1, 16)); // NOI18N
        Hellowlabel.setText("Hello, world!");
        MainFramePanel.add(Hellowlabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 300, 100, -1));

        Monlabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/monitor.png"))); // NOI18N
        MainFramePanel.add(Monlabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 270, -1, -1));

        Vcardlabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/vcard.png"))); // NOI18N
        MainFramePanel.add(Vcardlabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 250, -1, 130));

        ScanLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/scan.png"))); // NOI18N
        ScanLabel.setDoubleBuffered(true);
        MainFramePanel.add(ScanLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(438, 640, -1, -1));

        KBPlacelabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/KBplace.png"))); // NOI18N
        MainFramePanel.add(KBPlacelabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(436, 638, -1, -1));

        KBlabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/keyboard.png"))); // NOI18N
        MainFramePanel.add(KBlabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(212, 630, -1, -1));

        jScrollPane3.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {}
            },
            new String [] {

            }
        ));
        jScrollPane3.setViewportView(jTable1);

        MainFramePanel.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 10, 250, 150));

        SBtoNBlabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        SBtoNBlabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/SBtoNB.png"))); // NOI18N
        MainFramePanel.add(SBtoNBlabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 370, 150, -1));

        NBlabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/GMCH.png"))); // NOI18N
        MainFramePanel.add(NBlabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(538, 220, -1, -1));

        SBlabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ICH2.png"))); // NOI18N
        MainFramePanel.add(SBlabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(538, 460, -1, -1));

        KBtoSBlabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/KBtoSB.png"))); // NOI18N
        MainFramePanel.add(KBtoSBlabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 610, -1, -1));

        NBtoVideolabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/NBtoRAM.png"))); // NOI18N
        MainFramePanel.add(NBtoVideolabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(405, 280, -1, -1));

        NBtoRAMlabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/NBtoRAM.png"))); // NOI18N
        MainFramePanel.add(NBtoRAMlabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 280, -1, -1));

        VcardToMonlabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/VcardtoMon.png"))); // NOI18N
        MainFramePanel.add(VcardToMonlabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(142, 280, 110, -1));

        KBPlacelabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/KBplace.png"))); // NOI18N
        MainFramePanel.add(KBPlacelabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(471, 73, -1, 90));

        NBtoCPUlabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/CPUtoNB.png"))); // NOI18N
        MainFramePanel.add(NBtoCPUlabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(515, 80, -1, 140));

        TaktButton.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        TaktButton.setText("Следующий такт");
        MainFramePanel.add(TaktButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 80, -1, -1));

        jButton1.setText("jButton1");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        MainFramePanel.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 140, -1, -1));

        jButton2.setText("jButton2");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        MainFramePanel.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 140, -1, -1));

        jButton3.setText("jButton3");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        MainFramePanel.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 170, -1, -1));

        jButton4.setText("jButton4");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        MainFramePanel.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 170, -1, -1));

        jButton5.setText("jButton5");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        MainFramePanel.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 200, -1, -1));

        jButton6.setText("jButton6");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        MainFramePanel.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 200, -1, -1));

        Interruptlabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/arrow.png"))); // NOI18N
        MainFramePanel.add(Interruptlabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(468, 8, 540, 580));

        FileMenu.setText("Файл");
        FileMenu.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        FileMenu.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        FileMenu.setMargin(new java.awt.Insets(0, 10, 0, 10));

        StartMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_1, java.awt.event.InputEvent.CTRL_MASK));
        StartMenuItem.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        StartMenuItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-воспроизведение-14.png"))); // NOI18N
        StartMenuItem.setText("Старт");
        StartMenuItem.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        StartMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                StartMenuItemActionPerformed(evt);
            }
        });
        FileMenu.add(StartMenuItem);

        ClearMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_2, java.awt.event.InputEvent.CTRL_MASK));
        ClearMenuItem.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        ClearMenuItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-перезагрузка-filled-24.png"))); // NOI18N
        ClearMenuItem.setText("Сброс");
        ClearMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ClearMenuItemActionPerformed(evt);
            }
        });
        FileMenu.add(ClearMenuItem);

        OptionsMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_3, java.awt.event.InputEvent.CTRL_MASK));
        OptionsMenuItem.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        OptionsMenuItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-меню-32.png"))); // NOI18N
        OptionsMenuItem.setText("Параметры");
        OptionsMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OptionsMenuItemActionPerformed(evt);
            }
        });
        FileMenu.add(OptionsMenuItem);

        ExitMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.CTRL_MASK));
        ExitMenuItem.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        ExitMenuItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-выключение-системы-24.png"))); // NOI18N
        ExitMenuItem.setText("Выход");
        ExitMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExitMenuItemActionPerformed(evt);
            }
        });
        FileMenu.add(ExitMenuItem);

        jMenuBar1.add(FileMenu);

        SelectModeMenu.setText("Режим моделирования");
        SelectModeMenu.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        SelectModeMenu.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        SelectModeMenu.setMargin(new java.awt.Insets(0, 10, 0, 10));

        PerpetualMenuItem.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        PerpetualMenuItem.setSelected(true);
        PerpetualMenuItem.setText("Непрерывный");
        PerpetualMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PerpetualMenuItemActionPerformed(evt);
            }
        });
        SelectModeMenu.add(PerpetualMenuItem);

        TaktMenuItem.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        TaktMenuItem.setText("Потактовый");
        TaktMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TaktMenuItemActionPerformed(evt);
            }
        });
        SelectModeMenu.add(TaktMenuItem);

        jMenuBar1.add(SelectModeMenu);

        AboutMenu.setText("Справка");
        AboutMenu.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        AboutMenu.setMargin(new java.awt.Insets(0, 10, 0, 10));
        jMenuBar1.add(AboutMenu);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(MainFramePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(MainFramePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setBounds(0, 0, 1040, 807);
    }// </editor-fold>//GEN-END:initComponents

    private void StartMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_StartMenuItemActionPerformed
//        StartMenuItem.setEnabled(false);
//        ClearMenuItem.setEnabled(true);
//        CPUlabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/cpu_back.png")));
//        RAMlabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/RAM_back.png")));
//        KBlabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/keyboard_back.png")));
//        Monlabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/monitor_back.png")));
//        Vcardlabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/vcard_back.png")));
        
            animateSBtoCPU();
            TaktButton.setVisible(true);
//        repaint();
// TODO add your handling code here:
    }//GEN-LAST:event_StartMenuItemActionPerformed

    private void OptionsMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OptionsMenuItemActionPerformed
//        options.setVisible(true);
//        setVisible(false);
    jDialog1.setVisible(true);
// TODO add your handling code here:
    }//GEN-LAST:event_OptionsMenuItemActionPerformed

    private void ClearMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClearMenuItemActionPerformed
//        ClearMenuItem.setEnabled(false);
//        StartMenuItem.setEnabled(true);
//        CPUlabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/cpu.png")));
//        RAMlabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/RAM.png")));
//        KBlabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/keyboard.png")));
//        Monlabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/monitor.png")));
//        Vcardlabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/vcard.png")));
//        repaint();
            animateCPUtoRAM();
            TaktButton.setVisible(false);
    }//GEN-LAST:event_ClearMenuItemActionPerformed

    private void CancelbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelbtnActionPerformed
        jDialog1.dispose();
        // TODO add your handling code here:
    }//GEN-LAST:event_CancelbtnActionPerformed

    private void PerpetualMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PerpetualMenuItemActionPerformed
        TaktMenuItem.setSelected(false);
        // TODO add your handling code here:
    }//GEN-LAST:event_PerpetualMenuItemActionPerformed

    private void TaktMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TaktMenuItemActionPerformed
       
       PerpetualMenuItem.setSelected(false);// TODO add your handling code here:
    }//GEN-LAST:event_TaktMenuItemActionPerformed

    private void ExitMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExitMenuItemActionPerformed
        dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_ExitMenuItemActionPerformed

    private void OkbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OkbtnActionPerformed
        StartMenuItem.setEnabled(true);
        ClearMenuItem.setEnabled(true);
        jDialog1.dispose();
//        jTable1.addColumn();
        // TODO add your handling code here:
    }//GEN-LAST:event_OkbtnActionPerformed

    private void jSlider2StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSlider2StateChanged
        IOField.setText(Integer.toString(jSlider2.getValue()));
//        if (jSlider2.getValue() > jSlider1.getValue()){
//            jSlider1.setValue(jSlider2.getValue());
//            jTextPane1.setText(Integer.toString(jSlider1.getValue()));
//        }
        if (jSlider2.getValue() > 0 ){
            jSlider4.setEnabled(true);
            IOSymbField.setBackground(Color.white);
            WithoutInputBox.setEnabled(true);
            OutputMonBox.setEnabled(true);
        }
        else if (jSlider2.getValue() == 0){
            jSlider4.setEnabled(false);
            IOSymbField.setBackground(javax.swing.UIManager.getDefaults().getColor("Button.background"));
            WithoutInputBox.setEnabled(false);
            OutputMonBox.setEnabled(false);
        }
    }//GEN-LAST:event_jSlider2StateChanged

    private void jSlider1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSlider1StateChanged
        CPUField.setText(Integer.toString(jSlider1.getValue()));
//        if (jSlider2.getValue() > jSlider1.getValue()){
//            jSlider1.setValue(jSlider2.getValue());
//            jTextPane1.setText(Integer.toString(jSlider1.getValue()));
//        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jSlider1StateChanged

    private void jSlider4StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSlider4StateChanged
        IOSymbField.setText(Integer.toString(jSlider4.getValue()));
        // TODO add your handling code here:
    }//GEN-LAST:event_jSlider4StateChanged

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        animateKBtoSB();// TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        animateSBtoCPU();  // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        animateRAMtoVideo(); // TODO add your handling code here:
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        animateVideoToMon(); // TODO add your handling code here:
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        animateCPUtoRAM();        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        animateInterrupt();// TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        
//        
//        UIManager.put("Menu.selectionBackground", Color.lightGray);
//        UIManager.put("MenuItem.selectionBackground", Color.lightGray);
//           /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                MainFrame mf = new MainFrame();
//                Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
//                mf.setLocation(screenSize.width/2-mf.getSize().width/2, screenSize.height/2-mf.getSize().height/2);
//                mf.setVisible(true);
//                
                
//            }
//       });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu AboutMenu;
    private javax.swing.JTextPane CPUField;
    private javax.swing.JLabel CPUlabel;
    private javax.swing.JButton Cancelbtn;
    private javax.swing.JMenuItem ClearMenuItem;
    private javax.swing.JMenuItem ExitMenuItem;
    private javax.swing.JMenu FileMenu;
    private javax.swing.JLabel Hellowlabel;
    private javax.swing.JTextPane IOField;
    private javax.swing.JTextPane IOSymbField;
    private javax.swing.JLabel Interruptlabel;
    private javax.swing.JLabel KBPlacelabel;
    private javax.swing.JLabel KBPlacelabel1;
    private javax.swing.JLabel KBlabel;
    private javax.swing.JLabel KBtoSBlabel;
    private javax.swing.JPanel MainFramePanel;
    private javax.swing.JLabel Monlabel;
    private javax.swing.JLabel NBlabel;
    private javax.swing.JLabel NBtoCPUlabel;
    private javax.swing.JLabel NBtoRAMlabel;
    private javax.swing.JLabel NBtoVideolabel;
    private javax.swing.JButton Okbtn;
    private javax.swing.JMenuItem OptionsMenuItem;
    private javax.swing.JCheckBox OutputMonBox;
    private javax.swing.JRadioButtonMenuItem PerpetualMenuItem;
    private javax.swing.JLabel RAMlabel;
    private javax.swing.JLabel SBlabel;
    private javax.swing.JLabel SBtoNBlabel;
    private javax.swing.JLabel ScanLabel;
    private javax.swing.JMenu SelectModeMenu;
    private javax.swing.JMenuItem StartMenuItem;
    private javax.swing.JButton TaktButton;
    private javax.swing.JRadioButtonMenuItem TaktMenuItem;
    private javax.swing.JLabel VcardToMonlabel;
    private javax.swing.JLabel Vcardlabel;
    private javax.swing.JCheckBox WithoutInputBox;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSlider jSlider1;
    private javax.swing.JSlider jSlider2;
    private javax.swing.JSlider jSlider4;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
