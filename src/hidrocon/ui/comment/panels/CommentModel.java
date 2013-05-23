/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hidrocon.ui.comment.panels;

import hidrocon.HidroconApp;
import hidrocon.HidroconView;
import hidrocon.core.database.comment.entities.Comment;
import hidrocon.core.database.comment.manager.CommentManager;
import hidrocon.custom.Constant;
import hidrocon.custom.dialog.HidroDialog;
import hidrocon.custom.dialog.interfaces.IEntityView;
import hidrocon.custom.utils.HidroDialogFactory;
import javax.swing.JOptionPane;

/**
 *
 * @author David Sáenz Tagarro
 */
public class CommentModel {
        
	public boolean createComment(Comment comment) {
        if (comment!=null) {
            HidroDialogFactory hdf = HidroDialogFactory.getInstance();
            HidroDialog dialog = hdf.getDialog(HidroDialogFactory.COMMENT_DETAILS);
            IEntityView emDialog = (IEntityView)dialog;
            emDialog.setEntity(comment);
            emDialog.setMode(Constant.VIEW_MODE_CREATION);        
            HidroconApp.getApplication().show(dialog);

            if (emDialog.isEntityUpdated()) {
                CommentManager commentsManager = new CommentManager();
                commentsManager.createComment(comment);
                return true;
            }
        }
        return false;
	}
    
    public void showMessageCommentCreated() {
        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(hidrocon.HidroconApp.class).getContext().getResourceMap(HidroconView.class);
        Object[] options = { resourceMap.getString("message.dialog.continue") };
        JOptionPane.showOptionDialog(null, resourceMap.getString("comment.message.dialog.create"), resourceMap.getString("message.information"),
            JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE,
            null, options, options[0]);                    
    }
    
	public boolean updateComment(Comment comment) {
		if (comment!=null) {	
            HidroDialogFactory hdf = HidroDialogFactory.getInstance();
            HidroDialog dialog = hdf.getDialog(HidroDialogFactory.COMMENT_DETAILS);
            IEntityView emDialog = (IEntityView)dialog;
			emDialog.setEntity(comment);
            emDialog.setMode(Constant.VIEW_MODE_READONLY);
			HidroconApp.getApplication().show(dialog);
            
			if (emDialog.isEntityUpdated()) {
				CommentManager commentManager = new CommentManager();
				commentManager.updateComment(comment);
                return true;
			}
		}
        return false;
    }
    
    public void showMessageCommentUpdated() {
        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(hidrocon.HidroconApp.class).getContext().getResourceMap(HidroconView.class);
        Object[] options = { resourceMap.getString("message.dialog.continue") };
        JOptionPane.showOptionDialog(null, resourceMap.getString("comment.message.dialog.edit"), resourceMap.getString("message.information"),
            JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE,
            null, options, options[0]);         
    }
    
	public boolean deleteComment(Comment comment) {
		if (comment!=null) {
			org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(hidrocon.HidroconApp.class).getContext().getResourceMap(HidroconView.class);
			Object[] options = { resourceMap.getString("message.dialog.yes"), resourceMap.getString("message.dialog.no") };
			int optionSelected = JOptionPane.showOptionDialog(null, resourceMap.getString("comment.message.dialog.delete.question"), "Atención",
				JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE,
				null, options, options[0]);

			if (optionSelected == 0) {
				CommentManager commentManager = new CommentManager();
				commentManager.deleteComment(comment);
                return true;
			}
		}
        return false;
	}
    
    public void showMessageCommentDeleted() {
        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(hidrocon.HidroconApp.class).getContext().getResourceMap(HidroconView.class);
        Object[] options = { resourceMap.getString("message.dialog.continue") };
        JOptionPane.showOptionDialog(null, resourceMap.getString("comment.message.dialog.delete"), resourceMap.getString("message.information"),
            JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE,
            null, options, options[0]);         
    }
    
}
