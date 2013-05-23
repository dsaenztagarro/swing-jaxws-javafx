/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hidrocon.ui.comment.panels.details;

import hidrocon.HidroconView;
import hidrocon.core.generic.pattern.observer.AppEvent;
import hidrocon.core.pattern.mvc.HidroModel;
import hidrocon.core.utils.ObservableActionKey;
import hidrocon.webservice.Comment;
import hidrocon.webservice.HidroconWS;
import hidrocon.webservice.HidroconWS_Service;
import java.util.concurrent.ExecutionException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.SwingWorker;

/**
 *
 * @author David Sáenz Tagarro
 */
public class CommentDetailsModel extends HidroModel {    

    private class CreateCommentWorker extends SwingWorker<Comment,Void> {

        Comment comment = null;

        public CreateCommentWorker(Comment comment) {
            this.comment = comment;
        }
        
        @Override
        protected Comment doInBackground() throws Exception {
            HidroconWS_Service service = new HidroconWS_Service();
            HidroconWS port = service.getHidroconWSPort();
            port.createComment(comment);
            return comment;
        }
        
        @Override
        public void done() {
            AppEvent message = null;
            try {
                message = new AppEvent(ObservableActionKey.INFO_CREATED,get());
            } catch (InterruptedException ex) {
                Logger.getLogger(CommentDetailsModel.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ExecutionException ex) {
                Logger.getLogger(CommentDetailsModel.class.getName()).log(Level.SEVERE, null, ex);
            }
            notifyController(message);
        }
    }

    public void createComment(Comment Comment) {
        CreateCommentWorker worker = new CreateCommentWorker(Comment);
        worker.execute();
    }
     
    public void showMessageCommentCreated() {
        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(hidrocon.HidroconApp.class).getContext().getResourceMap(HidroconView.class);
        Object[] options = { resourceMap.getString("message.dialog.continue") };
        JOptionPane.showOptionDialog(null, resourceMap.getString("comment.message.dialog.create"), resourceMap.getString("message.information"),
            JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE,
            null, options, options[0]);            
    }
    
    private class UpdateCommentWorker extends SwingWorker<Void,Void> {

        Comment comment = null;

        public UpdateCommentWorker(Comment comment) {
            this.comment = comment;
        }
        
        @Override
        protected Void doInBackground() throws Exception {
            HidroconWS_Service service = new HidroconWS_Service();
            HidroconWS port = service.getHidroconWSPort();
            port.updateComment(comment);
            return null;
        }
        
        @Override
        public void done() {
            AppEvent message = null;
            try {
                message = new AppEvent(ObservableActionKey.INFO_UPDATED,get());
            } catch (InterruptedException ex) {
                Logger.getLogger(CommentDetailsModel.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ExecutionException ex) {
                Logger.getLogger(CommentDetailsModel.class.getName()).log(Level.SEVERE, null, ex);
            }
            notifyController(message);
        }
    }

    public void updateComment(Comment Comment) {
        UpdateCommentWorker worker = new UpdateCommentWorker(Comment);
        worker.execute();
    }    

    public void showMessageCommentUpdated() {
        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(hidrocon.HidroconApp.class).getContext().getResourceMap(HidroconView.class);
        Object[] options = { resourceMap.getString("message.dialog.continue") };
        JOptionPane.showOptionDialog(null, resourceMap.getString("comment.message.dialog.edit"), resourceMap.getString("message.information"),
            JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE,
            null, options, options[0]); 
    }
    
}
