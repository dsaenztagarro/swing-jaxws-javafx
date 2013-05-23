/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hidrocon.ui.migration.menu;

import hidrocon.core.utils.ActionKey;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author David Sáenz Tagarro
 */
public class MigrationMenuController implements ActionListener {

    private MigrationMenuModel model;
    private MigrationMenuView view;
    
    public MigrationMenuController(MigrationMenuModel model, MigrationMenuView view) {

        this.view = view;
        this.model = model;     
    }

    public void actionPerformed(ActionEvent e) {
        String action = e.getActionCommand();
        
        if (action.equals(ActionKey.COMMENT_DETAILS_EDIT)) {
            
        }
    }
    

}
