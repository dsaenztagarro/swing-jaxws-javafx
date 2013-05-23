/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hidrocon.ui.rate.panels;

import hidrocon.core.database.rate.entities.Rate;
import hidrocon.core.utils.ActionKey;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JDialog;

/**
 *
 * @author David Sáenz Tagarro
 */
public class RateController implements ActionListener, KeyListener, MouseListener {
    
    private JDialog dialog;
    
    private Rate selection;
    
    private RateModel model;
    private RateView view;
    
    public RateController(RateModel model, RateView view) {
        this.model = model;
        this.view = view;
        view.buttonActionListeners(this);
        view.tableKeyListeners(this);
        view.tableMouseListeners(this);
    }
    
    public void actionPerformed(ActionEvent e) {
        String action = e.getActionCommand();
        
        if (action.equals(ActionKey.RATE_PRINT)) {
            printRate();
        }
        else if (action.equals(ActionKey.RATE_CREATE)) {
            createRate();
        }        
        else if (action.equals(ActionKey.RATE_UPDATE)) {
            updateRate();
        }
        else if (action.equals(ActionKey.RATE_DELETE)) {
            deleteRate();
        }
        else if (action.equals(ActionKey.RATE_SELECT)) {
            selectRate();
        }        
        else if (action.equals(ActionKey.RATE_CLOSE)) {
            close();
        }        
    }
    
    private void printRate() {
        
    }
    
    private void createRate() {
        Rate rate = new Rate();  
        boolean created = model.createRate(rate);
        if (created) {
            view.addRate(rate);
            model.showMessageRateCreated();
        }
    }
    
    private void updateRate() {
        Rate rate = view.getRateSelected();  
        boolean updated = model.updateRate(rate);
        if (updated) {
            view.refreshRateList();
            model.showMessageRateUpdated();
        }
    }
    
    private void deleteRate() {
        Rate rate = view.getRateSelected();  
        boolean deleted = model.deleteRate(rate);
        if (deleted) {
            view.removeRate(rate);
            model.showMessageRateDeleted();
        }
    }
    
    private void selectRate() {
        selection = view.getRateSelected();
        if (selection!=null) {
            close();
        }
    }
    
    private void close() {
        if (dialog!=null) {
            dialog.setVisible(false);
        }
    }
    
    public void clearSelection() {
        selection = null;
    }
    
    public Rate getRateSelected() {
        return selection;
    }
    
    public boolean isRateSelected() {
        return selection!=null;
    }
    
    public void keyTyped(KeyEvent e) {
        //do nothing
    }

    public void keyPressed(KeyEvent evt) {
		int keyCode = evt.getKeyCode();
        if (keyCode == KeyEvent.VK_F8) {
            createRate();
            evt.consume();
        }
        else if (keyCode == KeyEvent.VK_ENTER) {
            updateRate();
            evt.consume();
        }
        else if (keyCode == KeyEvent.VK_F9) {
            deleteRate();
            evt.consume();
        }
    }

    public void keyReleased(KeyEvent e) {
        //do nothing
    }

    
    public void mouseClicked(MouseEvent evt) {
        if (evt.getClickCount() == 2) {
            evt.consume();
            updateRate();
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
    
    public void setDialog(JDialog dialog) {
        this.dialog = dialog;
    }    
}
