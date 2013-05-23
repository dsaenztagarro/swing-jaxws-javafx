/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hidrocon.ui.meter.metertype;

import hidrocon.component.meter.MeterTypeNodeView;
import hidrocon.core.database.metertype.entities.MeterType;
import hidrocon.core.pattern.mvc.HidroController;
import hidrocon.custom.panel.HidroPanel;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JDialog;

/**
 *
 * @author David Sáenz Tagarro
 */
public class MeterTypePanelController extends HidroController {
    
    private JDialog dialog;
    private List<MeterTypeNodeView> meterTypeNodeViewList;
    private List<MeterType> meterTypeList;
    private int indexSelected;
    
    private MeterTypePanelView view;
    private MeterTypePanelModel model;
    
    public MeterTypePanelController(MeterTypePanelModel model, MeterTypePanelView view) {
        this.view = view;
        this.model = model;
        
        view.addController(this);
        loadMeterTypeNodeList();
    }

    /*@Override
    public void actionPerformed(ActionEvent e) {
        String action = e.getActionCommand();
          
        if (action.equals(HidroAction.METER_TYPE_CLOSE)) {
            e.getSource();
        }
        else if (action.equals(HidroAction.METER_TYPE_CLOSE)) {
            close();
        } 
    }*/
    
    @Override
    public void mouseClicked(MouseEvent evt) {
        Object object = evt.getSource();
        if (object instanceof MeterTypeNodeView) {
            MeterTypeNodeView meterTypeNodeViewSelected = (MeterTypeNodeView)object;
            for (MeterTypeNodeView meterTypeNodeView : meterTypeNodeViewList) {
                meterTypeNodeView.setSelected(false);
            }
            meterTypeNodeViewSelected.setSelected(true);        
            indexSelected = meterTypeNodeViewList.indexOf(meterTypeNodeViewSelected);
        }
    }
    
    private void close() {
        if (dialog!=null) {
            dialog.setVisible(false);
        }
    }        
    
    public MeterType getMeterTypeSelected() {
        return meterTypeList.get(indexSelected);
    }
    
    private void loadMeterTypeNodeList() {
        HidroPanel content = new HidroPanel();
        GridLayout layout = new GridLayout(0, 2, 20, 20);
        content.setLayout(layout);
        
        meterTypeNodeViewList = new ArrayList();
        
        meterTypeList = model.getMeterTypeList();
        for (int i=0; i<meterTypeList.size(); i++) {
            MeterType meterType = (MeterType)meterTypeList.get(i);
            MeterTypeNodeView meterTypeNodeView = new MeterTypeNodeView();
            meterTypeNodeView.setData(meterType);
            content.add(meterTypeNodeView);
            meterTypeNodeViewList.add(meterTypeNodeView);
            meterTypeNodeView.addMouseListener(this);
        }
        view.setContent(content);
    }
    
    public void unselectMeterTypeNodeList() {
        for (MeterTypeNodeView meterTypeNodeView : meterTypeNodeViewList) {
            meterTypeNodeView.setSelected(false);
        }
    }
    
    public void addMeterTypeNodeMouseListener(MouseListener ml) {
        for (MeterTypeNodeView meterTypeNodeView : meterTypeNodeViewList) {
            meterTypeNodeView.addMouseListener(ml);
        }
    }

}
