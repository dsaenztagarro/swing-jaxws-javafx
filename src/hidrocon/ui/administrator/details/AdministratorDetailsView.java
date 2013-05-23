/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * AdministratorDetailsView.java
 *
 * Created on 08-dic-2011, 16:31:30
 */
package hidrocon.ui.administrator.details;

import hidrocon.HidroconView;
import hidrocon.core.utils.ActionKey;
import hidrocon.custom.Constant;
import hidrocon.custom.button.toolbar.HidroEditButton;
import hidrocon.custom.button.toolbar.HidroExitButton;
import hidrocon.custom.button.toolbar.HidroSaveButton;
import hidrocon.custom.legend.HidroAdministratorLegend;
import hidrocon.custom.legend.HidroObservationsLegend;
import hidrocon.custom.legend.HidroPresentadorLegend;
import hidrocon.webservice.Administrator;
import java.awt.event.ActionListener;
import javax.swing.JPanel;

/**
 *
 * @author David Sáenz Tagarro
 */
public class AdministratorDetailsView extends javax.swing.JPanel {

    private int mode;
    
    private HidroEditButton editButton;
    private HidroSaveButton saveButton;
    private HidroExitButton exitButton;
    
    /** Creates new form AdministratorDetailsView */
    public AdministratorDetailsView() {
        initComponents();
        initTopPanel();
        customizeComponents();
    }

	protected void initTopPanel() {
		org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(hidrocon.HidroconApp.class).getContext().getResourceMap(HidroconView.class);
		topPanel.setTitle("  " + resourceMap.getString("administrator.details.toppanel.title"));

        editButton = new HidroEditButton();
		saveButton = new HidroSaveButton();
        exitButton = new HidroExitButton();
        
        editButton.setToolTipText(resourceMap.getString("administrator.toolbar.editbutton.tooltip"));
		saveButton.setToolTipText(resourceMap.getString("administrator.toolbar.savebutton.tooltip"));
        exitButton.setToolTipText(resourceMap.getString("administrator.toolbar.exitbutton.tooltip"));

        topPanel.addButton(editButton);
		topPanel.addButton(saveButton);
        topPanel.addButton(exitButton);
	}
    
    protected void initFocus() {
        administratorNumberField.requestFocusInWindow();
    }
    
    protected void customizeComponents() {
        //Sections
        administratordataSection.setImageIcon(new HidroAdministratorLegend());  
        presentadordataSection.setImageIcon(new HidroPresentadorLegend());
        observationsSection.setImageIcon(new HidroObservationsLegend());
    }
    
    public void enableAllFields(boolean enabled) {
        administratorNumberField.setEditable(enabled);
        referenceField.setEditable(enabled);
        //Administrator details
        adminNameField.setEditable(enabled);
        addressField.setEditable(enabled);
        zipCodeField.setEditable(enabled);
        provinceField.setEditable(enabled);
        cityField.setEditable(enabled);
        phoneNumberField.setEditable(enabled);
        phoneNumber2Field.setEditable(enabled);
        faxField.setEditable(enabled);
        emailAddressField.setEditable(enabled);
        //Presentador details
        presenterNameField.setEditable(enabled);
        suffixName.setEditable(enabled);
        presenterNifField.setEditable(enabled);
        entityField.setEditable(enabled);
        observationsField.setEditable(enabled);
    }
    
    public void writeData(Administrator administrator) {
        administratorNumberField.setValue(administrator.getAdministratorId());
        referenceField.setValue(administrator.getReference());
        //Administrator details
        adminNameField.setText(administrator.getAdministratorName());
        addressField.setText(administrator.getAddress());
        zipCodeField.setText(administrator.getZipCode());
        provinceField.setText(administrator.getProvince());
        cityField.setText(administrator.getCity());
        phoneNumberField.setText(administrator.getPhoneNumber());
        phoneNumber2Field.setText(administrator.getPhoneNumber2());
        faxField.setText(administrator.getFax());
        emailAddressField.setText(administrator.getEmailAddress());
        //Presentador details
        presenterNameField.setText(administrator.getPresenterName());
        suffixName.setText(administrator.getPresenterSuffix());
        presenterNifField.setText(administrator.getPresenterNif());
        entityField.setText(administrator.getPresenterEntity());
        observationsField.setText(administrator.getObservations());        
    }
    
    public void readData(Administrator administrator) {
        administrator.setAdministratorId(administratorNumberField.getValue());
        administrator.setReference(referenceField.getValue());
        //Administrator details
        administrator.setAdministratorName(adminNameField.getText());
        administrator.setAddress(addressField.getText());
        administrator.setZipCode(zipCodeField.getText());
        administrator.setProvince(provinceField.getText());
        administrator.setCity(cityField.getText());
        administrator.setPhoneNumber(phoneNumberField.getText());
        administrator.setPhoneNumber2(phoneNumber2Field.getText());
        administrator.setFax(faxField.getText());
        administrator.setEmailAddress(emailAddressField.getText());        
        //Presentador details
        administrator.setPresenterName(presenterNameField.getText());
        administrator.setPresenterSuffix(suffixName.getText());
        administrator.setPresenterNif(presenterNifField.getText());
        administrator.setPresenterEntity(entityField.getText());
        administrator.setObservations(observationsField.getText());                
    }
    
    public void setMode(int mode) {
        this.mode = mode;
        if (this.mode == Constant.VIEW_MODE_CREATION) {
            enableAllFields(true);
        }
        else if (this.mode == Constant.VIEW_MODE_READONLY) {
            enableAllFields(false);
        }   
        else if (this.mode == Constant.VIEW_MODE_UPDATE) {
            enableAllFields(true);
            administratorNumberField.requestFocusInWindow();
        }        
        else if (this.mode == Constant.ENTITY_MANAGEMENT_MODE_SUMMARY) {
            enableAllFields(false);
        }
        
        showButtons();
    }
    
    protected void showButtons() {
        if (mode == Constant.VIEW_MODE_CREATION) {
            editButton.setVisible(false);
            saveButton.setVisible(true);
        }
        else if (mode == Constant.ENTITY_MANAGEMENT_MODE_SUMMARY) {
            editButton.setVisible(false);
            saveButton.setVisible(false);
        }
        else if (mode == Constant.VIEW_MODE_READONLY ) {
            editButton.setVisible(true);
            saveButton.setVisible(true);
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
        java.awt.GridBagConstraints gridBagConstraints;

        topPanel = new hidrocon.custom.panel.HidroTopPanel();
        mainPanel = new hidrocon.custom.panel.HidroMainPanel();
        initPanel = new hidrocon.custom.panel.HidroPanel();
        poradmLabel = new hidrocon.custom.label.HidroLabel();
        administratorNumberLabel = new hidrocon.custom.label.HidroLabel();
        referenceField = new hidrocon.custom.field.HidroIntegerField();
        administratorNumberField = new hidrocon.custom.field.HidroIntegerField();
        administratordataSection = new hidrocon.custom.panel.HidroSectionPanel();
        administratordataPanel = new hidrocon.custom.panel.HidroPanel();
        cityLabel = new hidrocon.custom.label.HidroLabel();
        adminNameLabel = new hidrocon.custom.label.HidroLabel();
        emailAddressLabel = new hidrocon.custom.label.HidroLabel();
        phoneNumberLabel = new hidrocon.custom.label.HidroLabel();
        phoneNumberField = new hidrocon.custom.field.HidroTextField();
        provinceLabel = new hidrocon.custom.label.HidroLabel();
        addressField = new hidrocon.custom.field.HidroTextField();
        faxLabel = new hidrocon.custom.label.HidroLabel();
        provinceField = new hidrocon.custom.field.HidroTextField();
        zipCodeLabel = new hidrocon.custom.label.HidroLabel();
        cityField = new hidrocon.custom.field.HidroTextField();
        phoneNumber2Field = new hidrocon.custom.field.HidroTextField();
        adminNameField = new hidrocon.custom.field.HidroTextField();
        faxField = new hidrocon.custom.field.HidroTextField();
        addressLabel = new hidrocon.custom.label.HidroLabel();
        emailAddressField = new hidrocon.custom.field.HidroTextField();
        zipCodeField = new hidrocon.custom.field.HidroTextField();
        rightAdministratorDataFiller = new javax.swing.Box.Filler(new java.awt.Dimension(5, 0), new java.awt.Dimension(5, 0), new java.awt.Dimension(5, 32767));
        presentadordataSection = new hidrocon.custom.panel.HidroSectionPanel();
        presentadordataPanel = new hidrocon.custom.panel.HidroPanel();
        hidroLabel1 = new hidrocon.custom.label.HidroLabel();
        presenterNameField = new hidrocon.custom.field.HidroTextField();
        sufijLabel = new hidrocon.custom.label.HidroLabel();
        suffixName = new hidrocon.custom.field.HidroTextField();
        nifpresenLabel = new hidrocon.custom.label.HidroLabel();
        presenterNifField = new hidrocon.custom.field.HidroTextField();
        entsucLabel = new hidrocon.custom.label.HidroLabel();
        entityField = new hidrocon.custom.field.HidroTextField();
        observationsSection = new hidrocon.custom.panel.HidroSectionPanel();
        obsadmScrollPane = new javax.swing.JScrollPane();
        observationsField = new hidrocon.custom.field.HidroTextArea();
        leftFiller = new javax.swing.Box.Filler(new java.awt.Dimension(25, 0), new java.awt.Dimension(25, 0), new java.awt.Dimension(25, 32767));
        rightFiller = new javax.swing.Box.Filler(new java.awt.Dimension(25, 0), new java.awt.Dimension(25, 0), new java.awt.Dimension(25, 32767));
        bottomFiller = new javax.swing.Box.Filler(new java.awt.Dimension(0, 5), new java.awt.Dimension(0, 5), new java.awt.Dimension(32767, 5));

        setMinimumSize(new java.awt.Dimension(494, 575));
        setName("Form"); // NOI18N
        setLayout(new java.awt.BorderLayout());

        topPanel.setName("topPanel"); // NOI18N
        topPanel.setPreferredSize(new java.awt.Dimension(400, 35));
        add(topPanel, java.awt.BorderLayout.PAGE_START);

        mainPanel.setMaximumSize(new java.awt.Dimension(540, 560));
        mainPanel.setMinimumSize(new java.awt.Dimension(400, 400));
        mainPanel.setName("mainPanel"); // NOI18N
        mainPanel.setPreferredSize(new java.awt.Dimension(400, 540));
        mainPanel.setLayout(new java.awt.GridBagLayout());

        initPanel.setMinimumSize(new java.awt.Dimension(416, 31));
        initPanel.setName("initPanel"); // NOI18N

        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(hidrocon.HidroconApp.class).getContext().getResourceMap(AdministratorDetailsView.class);
        poradmLabel.setText(resourceMap.getString("poradmLabel.text")); // NOI18N
        poradmLabel.setName("poradmLabel"); // NOI18N

        administratorNumberLabel.setText(resourceMap.getString("administratorNumberLabel.text")); // NOI18N
        administratorNumberLabel.setName("administratorNumberLabel"); // NOI18N

        referenceField.setName("referenceField"); // NOI18N

        administratorNumberField.setName("administratorNumberField"); // NOI18N

        javax.swing.GroupLayout initPanelLayout = new javax.swing.GroupLayout(initPanel);
        initPanel.setLayout(initPanelLayout);
        initPanelLayout.setHorizontalGroup(
            initPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(initPanelLayout.createSequentialGroup()
                .addComponent(administratorNumberLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(administratorNumberField, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(poradmLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(referenceField, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(72, Short.MAX_VALUE))
        );
        initPanelLayout.setVerticalGroup(
            initPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(initPanelLayout.createSequentialGroup()
                .addGroup(initPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(administratorNumberLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(administratorNumberField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(poradmLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(referenceField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 0, 0);
        mainPanel.add(initPanel, gridBagConstraints);

        administratordataSection.setName("administratordataSection"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        mainPanel.add(administratordataSection, gridBagConstraints);

        administratordataPanel.setMinimumSize(new java.awt.Dimension(445, 200));
        administratordataPanel.setName("administratordataPanel"); // NOI18N
        administratordataPanel.setPreferredSize(new java.awt.Dimension(445, 200));
        administratordataPanel.setLayout(new java.awt.GridBagLayout());

        cityLabel.setText(resourceMap.getString("cityLabel.text")); // NOI18N
        cityLabel.setName("cityLabel"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 0, 0, 0);
        administratordataPanel.add(cityLabel, gridBagConstraints);

        adminNameLabel.setText(resourceMap.getString("adminNameLabel.text")); // NOI18N
        adminNameLabel.setName("adminNameLabel"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 0, 0, 0);
        administratordataPanel.add(adminNameLabel, gridBagConstraints);

        emailAddressLabel.setText(resourceMap.getString("emailAddressLabel.text")); // NOI18N
        emailAddressLabel.setName("emailAddressLabel"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 0, 0, 0);
        administratordataPanel.add(emailAddressLabel, gridBagConstraints);

        phoneNumberLabel.setText(resourceMap.getString("phoneNumberLabel.text")); // NOI18N
        phoneNumberLabel.setName("phoneNumberLabel"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 0, 0, 0);
        administratordataPanel.add(phoneNumberLabel, gridBagConstraints);

        phoneNumberField.setName("phoneNumberField"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.ipadx = 109;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(3, 10, 0, 0);
        administratordataPanel.add(phoneNumberField, gridBagConstraints);

        provinceLabel.setText(resourceMap.getString("provinceLabel.text")); // NOI18N
        provinceLabel.setName("provinceLabel"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 0, 0, 0);
        administratordataPanel.add(provinceLabel, gridBagConstraints);

        addressField.setName("addressField"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.ipadx = 337;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(3, 10, 0, 0);
        administratordataPanel.add(addressField, gridBagConstraints);

        faxLabel.setText(resourceMap.getString("faxLabel.text")); // NOI18N
        faxLabel.setName("faxLabel"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 0, 0, 0);
        administratordataPanel.add(faxLabel, gridBagConstraints);

        provinceField.setName("provinceField"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.ipadx = 337;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(3, 10, 0, 0);
        administratordataPanel.add(provinceField, gridBagConstraints);

        zipCodeLabel.setText(resourceMap.getString("zipCodeLabel.text")); // NOI18N
        zipCodeLabel.setName("zipCodeLabel"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 0, 0, 0);
        administratordataPanel.add(zipCodeLabel, gridBagConstraints);

        cityField.setName("cityField"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 6;
        gridBagConstraints.ipadx = 337;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(3, 10, 0, 0);
        administratordataPanel.add(cityField, gridBagConstraints);

        phoneNumber2Field.setName("phoneNumber2Field"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 107;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(3, 10, 0, 0);
        administratordataPanel.add(phoneNumber2Field, gridBagConstraints);

        adminNameField.setName("adminNameField"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.ipadx = 337;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(3, 10, 0, 0);
        administratordataPanel.add(adminNameField, gridBagConstraints);

        faxField.setName("faxField"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.ipadx = 338;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(3, 10, 0, 0);
        administratordataPanel.add(faxField, gridBagConstraints);

        addressLabel.setText(resourceMap.getString("addressLabel.text")); // NOI18N
        addressLabel.setName("addressLabel"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 0, 0, 0);
        administratordataPanel.add(addressLabel, gridBagConstraints);

        emailAddressField.setName("emailAddressField"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 338;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(3, 10, 0, 0);
        administratordataPanel.add(emailAddressField, gridBagConstraints);

        zipCodeField.setName("zipCodeField"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.ipadx = 109;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(3, 10, 0, 0);
        administratordataPanel.add(zipCodeField, gridBagConstraints);

        rightAdministratorDataFiller.setName("rightAdministratorDataFiller"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        administratordataPanel.add(rightAdministratorDataFiller, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        mainPanel.add(administratordataPanel, gridBagConstraints);

        presentadordataSection.setName("presentadordataSection"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        mainPanel.add(presentadordataSection, gridBagConstraints);

        presentadordataPanel.setAlignmentX(0.0F);
        presentadordataPanel.setAlignmentY(0.0F);
        presentadordataPanel.setMinimumSize(new java.awt.Dimension(400, 112));
        presentadordataPanel.setName("presentadordataPanel"); // NOI18N

        hidroLabel1.setText(resourceMap.getString("hidroLabel1.text")); // NOI18N
        hidroLabel1.setName("hidroLabel1"); // NOI18N

        presenterNameField.setName("presenterNameField"); // NOI18N

        sufijLabel.setText(resourceMap.getString("sufijLabel.text")); // NOI18N
        sufijLabel.setName("sufijLabel"); // NOI18N

        suffixName.setName("suffixName"); // NOI18N

        nifpresenLabel.setText(resourceMap.getString("nifpresenLabel.text")); // NOI18N
        nifpresenLabel.setName("nifpresenLabel"); // NOI18N

        presenterNifField.setName("presenterNifField"); // NOI18N

        entsucLabel.setText(resourceMap.getString("entsucLabel.text")); // NOI18N
        entsucLabel.setName("entsucLabel"); // NOI18N

        entityField.setName("entityField"); // NOI18N

        javax.swing.GroupLayout presentadordataPanelLayout = new javax.swing.GroupLayout(presentadordataPanel);
        presentadordataPanel.setLayout(presentadordataPanelLayout);
        presentadordataPanelLayout.setHorizontalGroup(
            presentadordataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(presentadordataPanelLayout.createSequentialGroup()
                .addGroup(presentadordataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(hidroLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(entsucLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nifpresenLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sufijLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(4, 4, 4)
                .addGroup(presentadordataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(presenterNifField, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(entityField, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(suffixName, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(presenterNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(55, Short.MAX_VALUE))
        );
        presentadordataPanelLayout.setVerticalGroup(
            presentadordataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(presentadordataPanelLayout.createSequentialGroup()
                .addGroup(presentadordataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(hidroLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(presenterNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(presentadordataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sufijLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(suffixName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(presentadordataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nifpresenLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(presenterNifField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(presentadordataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(entsucLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(entityField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(8, 0, 5, 0);
        mainPanel.add(presentadordataPanel, gridBagConstraints);

        observationsSection.setName("observationsSection"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        mainPanel.add(observationsSection, gridBagConstraints);

        obsadmScrollPane.setBorder(null);
        obsadmScrollPane.setMinimumSize(new java.awt.Dimension(23, 40));
        obsadmScrollPane.setName("obsadmScrollPane"); // NOI18N
        obsadmScrollPane.setPreferredSize(new java.awt.Dimension(400, 40));

        observationsField.setName("observationsField"); // NOI18N
        obsadmScrollPane.setViewportView(observationsField);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 400;
        gridBagConstraints.ipady = 40;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 0, 0);
        mainPanel.add(obsadmScrollPane, gridBagConstraints);

        leftFiller.setName("leftFiller"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 4;
        mainPanel.add(leftFiller, gridBagConstraints);

        rightFiller.setName("rightFiller"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        mainPanel.add(rightFiller, gridBagConstraints);

        bottomFiller.setName("bottomFiller"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.weighty = 1.0;
        mainPanel.add(bottomFiller, gridBagConstraints);

        add(mainPanel, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private hidrocon.custom.field.HidroTextField addressField;
    private hidrocon.custom.label.HidroLabel addressLabel;
    private hidrocon.custom.field.HidroTextField adminNameField;
    private hidrocon.custom.label.HidroLabel adminNameLabel;
    private hidrocon.custom.field.HidroIntegerField administratorNumberField;
    private hidrocon.custom.label.HidroLabel administratorNumberLabel;
    private hidrocon.custom.panel.HidroPanel administratordataPanel;
    private hidrocon.custom.panel.HidroSectionPanel administratordataSection;
    private javax.swing.Box.Filler bottomFiller;
    private hidrocon.custom.field.HidroTextField cityField;
    private hidrocon.custom.label.HidroLabel cityLabel;
    private hidrocon.custom.field.HidroTextField emailAddressField;
    private hidrocon.custom.label.HidroLabel emailAddressLabel;
    private hidrocon.custom.field.HidroTextField entityField;
    private hidrocon.custom.label.HidroLabel entsucLabel;
    private hidrocon.custom.field.HidroTextField faxField;
    private hidrocon.custom.label.HidroLabel faxLabel;
    private hidrocon.custom.label.HidroLabel hidroLabel1;
    private hidrocon.custom.panel.HidroPanel initPanel;
    private javax.swing.Box.Filler leftFiller;
    private hidrocon.custom.panel.HidroMainPanel mainPanel;
    private hidrocon.custom.label.HidroLabel nifpresenLabel;
    private javax.swing.JScrollPane obsadmScrollPane;
    private hidrocon.custom.field.HidroTextArea observationsField;
    private hidrocon.custom.panel.HidroSectionPanel observationsSection;
    private hidrocon.custom.field.HidroTextField phoneNumber2Field;
    private hidrocon.custom.field.HidroTextField phoneNumberField;
    private hidrocon.custom.label.HidroLabel phoneNumberLabel;
    private hidrocon.custom.label.HidroLabel poradmLabel;
    private hidrocon.custom.panel.HidroPanel presentadordataPanel;
    private hidrocon.custom.panel.HidroSectionPanel presentadordataSection;
    private hidrocon.custom.field.HidroTextField presenterNameField;
    private hidrocon.custom.field.HidroTextField presenterNifField;
    private hidrocon.custom.field.HidroTextField provinceField;
    private hidrocon.custom.label.HidroLabel provinceLabel;
    private hidrocon.custom.field.HidroIntegerField referenceField;
    private javax.swing.Box.Filler rightAdministratorDataFiller;
    private javax.swing.Box.Filler rightFiller;
    private hidrocon.custom.field.HidroTextField suffixName;
    private hidrocon.custom.label.HidroLabel sufijLabel;
    private hidrocon.custom.panel.HidroTopPanel topPanel;
    private hidrocon.custom.field.HidroTextField zipCodeField;
    private hidrocon.custom.label.HidroLabel zipCodeLabel;
    // End of variables declaration//GEN-END:variables

    public void buttonActionListeners(ActionListener al) {
        editButton.setActionCommand(ActionKey.ADMINISTRATOR_DETAILS_EDIT);
		editButton.addActionListener(al);
        saveButton.setActionCommand(ActionKey.ADMINISTRATOR_DETAILS_SAVE);
		saveButton.addActionListener(al);
        exitButton.setActionCommand(ActionKey.ADMINISTRATOR_DETAILS_CLOSE);
		exitButton.addActionListener(al);
    }
    
    public JPanel getMainPanel() {
        return mainPanel;
    }

}
