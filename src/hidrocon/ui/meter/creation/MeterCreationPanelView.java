/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * NeighbourDialog.java
 *
 * Created on 06-dic-2011, 4:32:08
 */
package hidrocon.ui.meter.creation;

import hidrocon.custom.panel.HidroMainPanel;
import java.awt.BorderLayout;
import java.awt.Dimension;

/**
 *
 * @author David Sáenz Tagarro
 */
public final class MeterCreationPanelView extends HidroMainPanel {

    /** Creates new form NeighbourDialog */
    public MeterCreationPanelView() {
        super();
        //initComponents();
        initContent();
    }
    
    private void initContent() {
        BorderLayout layout = new BorderLayout();
        setLayout(layout);
        
        setMinimumSize(new Dimension(650,375));
        setMaximumSize(new Dimension(650,375));
        setPreferredSize(new Dimension(650,375));          
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
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

}