/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * NeighbourDialog.java
 *
 * Created on 06-dic-2011, 4:32:08
 */
package hidrocon.ui.neighbour.menu;

import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JPanel;

/**
 *
 * @author David Sáenz Tagarro
 */
public final class NeighbourMenuView extends JPanel {

    /** Creates new form NeighbourDialog */
    public NeighbourMenuView() {
        super();
        //initComponents();
        initContent();
    }
    
    private void initContent() {
        
        BorderLayout layout = new BorderLayout();
        setLayout(layout);
        
        //HidroBlockingLayerUI layerUI = new HidroBlockingLayerUI();
        //JLayer<JPanel> jlayerMain = new JLayer<JPanel>(view, layerUI);
        //getContentPane().add(jlayerMain);
        
        setMinimumSize(new Dimension(650,575));
        setMaximumSize(new Dimension(650,575));
        setPreferredSize(new Dimension(650,575));          
    }


    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setName("Form"); // NOI18N
        setLayout(new java.awt.BorderLayout());
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

}
