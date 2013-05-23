/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * AdministratorSelectionDialog.java
 *
 * Created on 29-nov-2011, 7:16:41
 */
package hidrocon.ui.administrator.dialog;

import hidrocon.custom.Constant;
import hidrocon.custom.dialog.HidroDialog;
import hidrocon.custom.dialog.interfaces.ISelector;
import hidrocon.ui.administrator.menu.AdministratorMenuController;
import hidrocon.ui.administrator.menu.AdministratorMenuModel;
import hidrocon.ui.administrator.menu.AdministratorMenuView;
import java.awt.Dimension;

/**
 *
 * @author David Sáenz Tagarro
 */
public final class AdministratorSelectionDialog extends HidroDialog implements ISelector{

    private AdministratorMenuModel model;
    private AdministratorMenuView view;
    private AdministratorMenuController controller;
    
    /** Creates new form AdministratorSelectionDialog */
    public AdministratorSelectionDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initContent();
    }
    
    private void initContent() {
        view = new AdministratorMenuView(Constant.ENTITY_MANAGEMENT_MODE_SELECTION);
        model = new AdministratorMenuModel();
        controller = new AdministratorMenuController(model, view);
        
        controller.setDialog(this);

        view.setMinimumSize(new Dimension(450,575));
        view.setMaximumSize(new Dimension(450,575));
        view.setPreferredSize(new Dimension(450,575));
        getContentPane().add(view);
        pack();        
    }
    
    protected void initTopPanel(){}
    protected void initFocus(){}
    protected void initKeyBinding(){}
    protected void customizeComponents(){}    
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setName("Form"); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

    public Object getSelection() {
        return controller.getAdministratorSelected();
    }

    public boolean isSelection() {
        return controller.isAdministratorSelected();
    }
}
