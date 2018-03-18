/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package splashscreen;

import java.awt.Color;
import java.awt.EventQueue;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author metz9
 */
public class Main {
      
    public static void main(String[] args) {
  
        
       
        
       try {
          String systemLookAndFeelClassName = UIManager.getSystemLookAndFeelClassName();
          UIManager.setLookAndFeel(systemLookAndFeelClassName);
      } catch (UnsupportedLookAndFeelException e) {
          System.err.println("Can't use the specified look and feel on this platform.");
      } catch (Exception e) {
          System.err.println("Couldn't get specified look and feel, for some reason.");
      }
       
       UIManager.put("FormattedTextField.inactiveBackground",Color.white);
        
        SplashFrame ss = new SplashFrame();
        ss.setVisible(true);
        
//        Thread thread = new Thread() {
//        public void run() {
//            game.play();
//        }
//        };
//        thread.start();
        
        try {
            for (int i = 0; i <= 100; i++) {
                Thread.sleep(18);
                ss.percent_lable.setText(Integer.toString(i) + " %");
                if (i == 100) {
                    ss.dispose();
                }
            }
        } catch (Exception e) {
          }
        
                
         javax.swing.SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {  
                MainFrame mf = new MainFrame();
                mf.setVisible(true);
            }
        });
        
    }
    
}
