/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package splashscreen;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;

/**
 *
 * @author metz9
 */
public class GMCH {
    private BufferedImage image = new BufferedImage(150, 150, BufferedImage.TYPE_INT_RGB);
    private Graphics graphics = image.getGraphics();
    
    public Image paint() {
        graphics.drawString("Северный мост", 15, 100);
        graphics.drawRect(0, 0, 150, 150);
        return image;
    }
}
