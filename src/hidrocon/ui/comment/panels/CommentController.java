/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hidrocon.ui.comment.panels;

import hidrocon.core.database.comment.entities.Comment;
import hidrocon.core.utils.ActionKey;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 *
 * @author David Sáenz Tagarro
 */
public class CommentController implements ActionListener, KeyListener, MouseListener {
    
    private CommentModel model;
    private CommentView view;
    
    public CommentController(CommentModel model, CommentView view) {
        this.model = model;
        this.view = view;
        view.buttonActionListeners(this);
        view.tableKeyListeners(this);
        view.tableMouseListeners(this);
    }
    
    public void actionPerformed(ActionEvent e) {
        String action = e.getActionCommand();
        
        if (action.equals(ActionKey.COMMENT_PRINT)) {
            printComment();
        }
        else if (action.equals(ActionKey.COMMENT_CREATE)) {
            createComment();
        }        
        else if (action.equals(ActionKey.COMMENT_UPDATE)) {
            updateComment();
        }
        else if (action.equals(ActionKey.COMMENT_DELETE)) {
            deleteComment();
        }        
    }
    
    private void printComment() {
        
    }
    
    private void createComment() {
        Comment comment = new Comment();  
        boolean created = model.createComment(comment);
        if (created) {
            view.addComment(comment);
            model.showMessageCommentCreated();
        }
    }
    
    private void updateComment() {
        Comment comment = view.getCommentSelected();  
        boolean updated = model.updateComment(comment);
        if (updated) {
            view.refreshCommentList();
            model.showMessageCommentUpdated();
        }
    }
    
    private void deleteComment() {
        Comment comment = view.getCommentSelected();  
        boolean deleted = model.deleteComment(comment);
        if (deleted) {
            view.removeComment(comment);
            model.showMessageCommentDeleted();
        }
    }
    
    public void keyTyped(KeyEvent e) {
        //do nothing
    }

    public void keyPressed(KeyEvent evt) {
		int keyCode = evt.getKeyCode();
        if (keyCode == KeyEvent.VK_F8) {
            createComment();
            evt.consume();
        }
        else if (keyCode == KeyEvent.VK_ENTER) {
            updateComment();
            evt.consume();
        }
        else if (keyCode == KeyEvent.VK_F9) {
            deleteComment();
            evt.consume();
        }
    }

    public void keyReleased(KeyEvent e) {
        //do nothing
    }

    
    public void mouseClicked(MouseEvent evt) {
        if (evt.getClickCount() == 2) {
            evt.consume();
            updateComment();
        }
    }

    public void mousePressed(MouseEvent e) {
        //do nothing
    }

    public void mouseReleased(MouseEvent e) {
        //do nothing
    }

    public void mouseEntered(MouseEvent e) {
        //do nothing
    }

    public void mouseExited(MouseEvent e) {
        //do nothing
    }
    
}
