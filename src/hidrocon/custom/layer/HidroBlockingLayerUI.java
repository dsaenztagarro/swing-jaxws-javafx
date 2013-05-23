/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hidrocon.custom.layer;

import java.awt.AWTEvent;
import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JComponent;
import javax.swing.JLayer;
import javax.swing.JPanel;
import javax.swing.plaf.LayerUI;

/**
 *
 * @author David Sáenz Tagarro
 */
public class HidroBlockingLayerUI extends LayerUI<JPanel>{

     public void paint(Graphics g, JComponent c) {
         // paint the layer as is
         super.paint(g, c);
         // fill it with the translucent green
         int w = c.getWidth();
         int h = c.getHeight();
         Graphics2D g2 = (Graphics2D) g.create();
         g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP, .65f));
         g2.setBackground(Color.BLUE);
         g2.setColor(Color.BLACK);
         g2.fillRect(0,0,w,h);
     }

     public void installUI(JComponent c) {
         super.installUI(c);
         // enable mouse motion events for the layer's subcomponents
         ((JLayer) c).setLayerEventMask(AWTEvent.MOUSE_MOTION_EVENT_MASK);
     }

     public void uninstallUI(JComponent c) {
         super.uninstallUI(c);
         // reset the layer event mask
         ((JLayer) c).setLayerEventMask(0);
     }

     // overridden method which catches MouseMotion events
     public void eventDispatched(AWTEvent e, JLayer<? extends JPanel> l) {
         //System.out.println("AWTEvent detected: " + e);
     }
    
}
