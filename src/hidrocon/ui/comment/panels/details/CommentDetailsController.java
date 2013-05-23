/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hidrocon.ui.comment.panels.details;

import hidrocon.core.generic.pattern.observer.AppEvent;
import hidrocon.core.pattern.mvc.HidroController;
import hidrocon.core.utils.ActionKey;
import hidrocon.core.utils.ObservableActionKey;
import hidrocon.custom.Constant;
import hidrocon.webservice.Comment;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.Observable;
import javax.swing.JDialog;

/**
 *
 * @author David Sáenz Tagarro
 */
public class CommentDetailsController extends HidroController {
    
    private int mode;
    
    private JDialog dialog;
    
    private Comment comment;
    
    private CommentDetailsModel model;
    private CommentDetailsView view;
    
    public CommentDetailsController(CommentDetailsModel model, CommentDetailsView view) {
        this.model = model;
        this.view = view;
        view.buttonActionListeners(this);
    }
    
    public void actionPerformed(ActionEvent e) {
        String action = e.getActionCommand();
        
        if (action.equals(ActionKey.COMMENT_DETAILS_EDIT)) {
            editComment();
        }        
        else if (action.equals(ActionKey.COMMENT_DETAILS_SAVE)) {
            saveComment();
        }
        else if (action.equals(ActionKey.COMMENT_DETAILS_CLOSE)) {
            close();
        }        
    }

    @Override
    public void update(Observable o, Object arg) {
        AppEvent message = (AppEvent)arg;
        String action = message.getEventName();
        Object argument = message.getArgument();
        
        if (o instanceof CommentDetailsModel) {
            if (action.equals(ObservableActionKey.INFO_CREATED)) {
                showMessageCommentCreated();
            }
            else if (action.equals(ObservableActionKey.INFO_UPDATED)) {
                showMessageCommentUpdated();
            }
        }
    }
    
    public void setMode(int mode) {
        this.mode = mode;
    }
    public void showMessageCommentCreated() {
        model.showMessageCommentCreated();
        close();
    }
    
    public void showMessageCommentUpdated() {
        model.showMessageCommentUpdated();
        close();
    }
    
    public void setComment(Comment comment) {
        this.comment = comment;
        view.writeData(comment);
    }
    
    private void editComment() {
        view.setMode(Constant.VIEW_MODE_UPDATE);
    }
    
    private void saveComment() {
        view.readData(comment);
        if (mode == Constant.VIEW_MODE_CREATION) {
            model.createComment(comment);
        }
        else if (mode == Constant.VIEW_MODE_UPDATE) {
            model.updateComment(comment);
        }
    }
    
    private void close() {
        if (dialog!=null) {
            dialog.setVisible(false);
        }
    }
        
    public void keyTyped(KeyEvent e) {
        //do nothing
    }

    public void keyPressed(KeyEvent evt) {
        int keyCode = evt.getKeyCode();

    }

    public void keyReleased(KeyEvent e) {
        //do nothing
    }
    
    public void setDialog(JDialog dialog) {
        this.dialog = dialog;
    }
}
