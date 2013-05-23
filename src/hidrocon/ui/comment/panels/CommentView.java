/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * CommentView.java
 *
 * Created on 14-sep-2011, 22:53:31
 */

package hidrocon.ui.comment.panels;

import hidrocon.HidroconView;
import hidrocon.custom.button.toolbar.HidroDeleteButton;
import hidrocon.custom.button.toolbar.HidroNewButton;
import hidrocon.custom.button.toolbar.HidroPrintButton;
import hidrocon.core.database.comment.entities.Comment;
import hidrocon.core.utils.ActionKey;
import hidrocon.custom.button.toolbar.HidroInfoButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
/**
 *
 * @author david
 */
public class CommentView extends hidrocon.custom.panel.HidroMainPanel {

	private final int COLUMN_NUMERO_COMENTARIO = 0;
	private final int COLUMN_DESCRIPCION = 1;
    
    HidroPrintButton printButton;
    HidroNewButton newButton;
    HidroInfoButton infoButton;
    HidroDeleteButton deleteButton;    
	
    /** Creates new form CommentView */
    public CommentView() {
        initComponents();
		initTopPanel();
		initSearchFields();
    }

	private void initFocus() {
		commentsTable.setFocusCycleRoot(true);
	}
	    
	private void initTopPanel() {
		org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(hidrocon.HidroconApp.class).getContext().getResourceMap(HidroconView.class);
		topPanel.setTitle("  " + resourceMap.getString("comment.toppanel.title"));

		printButton = new HidroPrintButton();
		newButton = new HidroNewButton();
		infoButton = new HidroInfoButton();
		deleteButton = new HidroDeleteButton();

		printButton.setToolTipText(resourceMap.getString("comment.toolbar.printbutton.tooltip"));
		newButton.setToolTipText(resourceMap.getString("comment.toolbar.newbutton.tooltip"));
		infoButton.setToolTipText(resourceMap.getString("comment.toolbar.infobutton.tooltip"));
		deleteButton.setToolTipText(resourceMap.getString("comment.toolbar.deletebutton.tooltip"));

		topPanel.addButton(printButton);
		topPanel.addButton(newButton);
		topPanel.addButton(infoButton);
		topPanel.addButton(deleteButton);
	}

	public void refreshCommentList() {
		java.util.List auxList = new java.util.ArrayList();
		auxList.addAll(commentsList);
		commentsList.clear();
		commentsList.addAll(auxList);
	}    
    
    public Comment getCommentSelected() {
		if (commentsTable.getSelectedRow() > -1) {
			return commentsList.get(commentsTable.convertRowIndexToModel(commentsTable.getSelectedRow()));
        }
        return null;
    }
    
    public void addComment(Comment comment) {
        commentsList.add(comment);
    }
    
    public void removeComment(Comment comment) {
        commentsList.remove(comment);        
    }
    
    /*
     * Search filter methods
     */   
    
	private void initSearchFields() {
		initSearchNumeroComentario();
	}

	private void initSearchNumeroComentario() {
		numerocomentarioTextField.getDocument().addDocumentListener(new DocumentListener() {
			public void changedUpdate(DocumentEvent e) {
				newNumeroComentarioFilter();
			}
			public void insertUpdate(DocumentEvent e) {
				newNumeroComentarioFilter();
			}
			public void removeUpdate(DocumentEvent e) {
				newNumeroComentarioFilter();
			}
		});
	}

    private void newNumeroComentarioFilter() {
		String value = numerocomentarioTextField.getText();
		if (value!=null && !value.equals("")) {
			//clearOtherFilters(COLUMN_NUMERO_COMENTARIO);
			commentsTable.newNumberFilter(new Integer(value), COLUMN_NUMERO_COMENTARIO);
		} else {
			commentsTable.clearFilter();
		}
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        hidrocon.core.database.comment.manager.CommentManager commentsManager = new hidrocon.core.database.comment.manager.CommentManager();
        commentsList = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : org.jdesktop.observablecollections.ObservableCollections.observableList(commentsManager.getAllComments());
        topPanel = new hidrocon.custom.panel.HidroTopPanel();
        mainPanel = new hidrocon.custom.panel.HidroMainPanel();
        commentsScrollPane = new javax.swing.JScrollPane();
        commentsTable = new hidrocon.custom.table.HidroTable();
        mainLeftPanel = new hidrocon.custom.panel.HidroPanel();
        mainRightPanel = new hidrocon.custom.panel.HidroPanel();
        mainTopPanel = new hidrocon.custom.panel.HidroPanel();
        numerocomentarioLabel = new hidrocon.custom.label.HidroLabel();
        filterLegend1 = new hidrocon.custom.legend.FilterLegend();
        numerocomentarioTextField = new hidrocon.custom.field.HidroTextField();
        mainBottomPanel = new hidrocon.custom.panel.HidroPanel();

        setName("Form"); // NOI18N
        setLayout(new java.awt.BorderLayout());

        topPanel.setName("topPanel"); // NOI18N
        add(topPanel, java.awt.BorderLayout.PAGE_START);

        mainPanel.setName("mainPanel"); // NOI18N
        mainPanel.setLayout(new java.awt.BorderLayout());

        commentsScrollPane.setName("commentsScrollPane"); // NOI18N
        commentsScrollPane.setPreferredSize(new java.awt.Dimension(452, 302));

        commentsTable.setName("commentsTable"); // NOI18N

        org.jdesktop.swingbinding.JTableBinding jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, commentsList, commentsTable);
        org.jdesktop.swingbinding.JTableBinding.ColumnBinding columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${commentNumber}"));
        columnBinding.setColumnName("Comment Number");
        columnBinding.setColumnClass(Integer.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${commentText}"));
        columnBinding.setColumnName("Comment Text");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();
        commentsScrollPane.setViewportView(commentsTable);
        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(hidrocon.HidroconApp.class).getContext().getResourceMap(CommentView.class);
        commentsTable.getColumnModel().getColumn(0).setMinWidth(75);
        commentsTable.getColumnModel().getColumn(0).setMaxWidth(75);
        commentsTable.getColumnModel().getColumn(0).setHeaderValue(resourceMap.getString("commentsTable.columnModel.title0")); // NOI18N
        commentsTable.getColumnModel().getColumn(1).setMinWidth(500);
        commentsTable.getColumnModel().getColumn(1).setHeaderValue(resourceMap.getString("commentsTable.columnModel.title1")); // NOI18N

        mainPanel.add(commentsScrollPane, java.awt.BorderLayout.CENTER);

        mainLeftPanel.setName("mainLeftPanel"); // NOI18N
        mainLeftPanel.setPreferredSize(new java.awt.Dimension(25, 100));
        mainPanel.add(mainLeftPanel, java.awt.BorderLayout.LINE_START);

        mainRightPanel.setName("mainRightPanel"); // NOI18N
        mainRightPanel.setPreferredSize(new java.awt.Dimension(25, 100));
        mainPanel.add(mainRightPanel, java.awt.BorderLayout.LINE_END);

        mainTopPanel.setMinimumSize(new java.awt.Dimension(0, 0));
        mainTopPanel.setName("mainTopPanel"); // NOI18N
        mainTopPanel.setPreferredSize(new java.awt.Dimension(712, 45));

        numerocomentarioLabel.setText(resourceMap.getString("numerocomentarioLabel.text")); // NOI18N
        numerocomentarioLabel.setName("numerocomentarioLabel"); // NOI18N

        filterLegend1.setText(resourceMap.getString("filterLegend1.text")); // NOI18N
        filterLegend1.setName("filterLegend1"); // NOI18N

        numerocomentarioTextField.setEditable(true);
        numerocomentarioTextField.setText(resourceMap.getString("numerocomentarioTextField.text")); // NOI18N
        numerocomentarioTextField.setName("numerocomentarioTextField"); // NOI18N

        javax.swing.GroupLayout mainTopPanelLayout = new javax.swing.GroupLayout(mainTopPanel);
        mainTopPanel.setLayout(mainTopPanelLayout);
        mainTopPanelLayout.setHorizontalGroup(
            mainTopPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainTopPanelLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(numerocomentarioLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(numerocomentarioTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(filterLegend1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(531, Short.MAX_VALUE))
        );
        mainTopPanelLayout.setVerticalGroup(
            mainTopPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainTopPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(mainTopPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(numerocomentarioLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(filterLegend1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(numerocomentarioTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        mainPanel.add(mainTopPanel, java.awt.BorderLayout.PAGE_START);

        mainBottomPanel.setName("mainBottomPanel"); // NOI18N
        mainBottomPanel.setPreferredSize(new java.awt.Dimension(100, 25));
        mainPanel.add(mainBottomPanel, java.awt.BorderLayout.PAGE_END);

        add(mainPanel, java.awt.BorderLayout.CENTER);

        bindingGroup.bind();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.util.List<hidrocon.core.database.comment.entities.Comment> commentsList;
    private javax.swing.JScrollPane commentsScrollPane;
    private hidrocon.custom.table.HidroTable commentsTable;
    private hidrocon.custom.legend.FilterLegend filterLegend1;
    private hidrocon.custom.panel.HidroPanel mainBottomPanel;
    private hidrocon.custom.panel.HidroPanel mainLeftPanel;
    private hidrocon.custom.panel.HidroMainPanel mainPanel;
    private hidrocon.custom.panel.HidroPanel mainRightPanel;
    private hidrocon.custom.panel.HidroPanel mainTopPanel;
    private hidrocon.custom.label.HidroLabel numerocomentarioLabel;
    private hidrocon.custom.field.HidroTextField numerocomentarioTextField;
    private hidrocon.custom.panel.HidroTopPanel topPanel;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables

    public void buttonActionListeners(ActionListener al) {
        printButton.setActionCommand(ActionKey.COMMENT_PRINT);
		printButton.addActionListener(al);
		newButton.setActionCommand(ActionKey.COMMENT_CREATE);
        newButton.addActionListener(al);
        infoButton.setActionCommand(ActionKey.COMMENT_UPDATE);
		infoButton.addActionListener(al);
        deleteButton.setActionCommand(ActionKey.COMMENT_DELETE);
		deleteButton.addActionListener(al);        
    }
    
    public void tableKeyListeners(KeyListener kl) {
        commentsTable.addKeyListener(kl);
    }
    
    public void tableMouseListeners(MouseListener ml) {
        commentsTable.addMouseListener(ml);
    }    
}
