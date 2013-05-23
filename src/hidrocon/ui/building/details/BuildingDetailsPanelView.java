/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * BuildingDetailsPanelView.java
 *
 * Created on 02-dic-2011, 16:00:50
 */
package hidrocon.ui.building.details;

import hidrocon.HidroconView;
import hidrocon.core.pattern.mvc.HidroController;
import hidrocon.core.utils.ActionKey;
import hidrocon.custom.Constant;
import hidrocon.custom.button.section.HidroCalendarDeleteButton;
import hidrocon.custom.button.section.HidroCalendarNewButton;
import hidrocon.custom.button.toolbar.HidroAdministratorButton;
import hidrocon.custom.button.toolbar.HidroArrowLeftButton;
import hidrocon.custom.button.toolbar.HidroArrowRightButton;
import hidrocon.custom.button.toolbar.HidroEditButton;
import hidrocon.custom.button.toolbar.HidroExitButton;
import hidrocon.custom.button.toolbar.HidroRateButton;
import hidrocon.custom.button.toolbar.HidroSaveButton;
import hidrocon.custom.legend.HidroBankLegend;
import hidrocon.custom.legend.HidroBuildingDetailsLegend;
import hidrocon.custom.legend.HidroContactLegend;
import hidrocon.custom.legend.HidroObservationsLegend;
import hidrocon.custom.legend.HidroRateLegend;
import hidrocon.custom.legend.HidroRouteMapLegend;
import hidrocon.custom.legend.HidroSeveralDataLegend;
import hidrocon.custom.panel.HidroMainPanel;
import hidrocon.webservice.Administrator;
import hidrocon.webservice.Building;
import hidrocon.webservice.Rate;
import java.awt.CardLayout;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTable;

/**
 *
 * @author David Sáenz Tagarro
 */
public class BuildingDetailsPanelView extends HidroMainPanel {

    private int mode;
    
    private HidroEditButton editButton;
    private HidroSaveButton saveButton;    
    private HidroRateButton rateButton;
    private HidroAdministratorButton administratorButton;
    private HidroArrowLeftButton arrowLeftButton;
    private HidroArrowRightButton arrowRightButton;
    private HidroExitButton exitButton;
    
    private HidroCalendarNewButton calendarNewButton;
    private HidroCalendarDeleteButton calendarDeleteButton;
    
    /** Creates new form BuildingDetailsPanelView */
    public BuildingDetailsPanelView() {
        initComponents();
        initDialog();
    }

	/*
	 * HidroDialog abstract methods implementation - BEGIN
	 */
    
    protected void initDialog() {
        initTopPanel();
        initFocus();
        customizeComponents();        
    }
    
    protected void customizeComponents() {
        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(hidrocon.HidroconApp.class).getContext().getResourceMap(HidroconView.class);
        //hidroComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { resourceMap.getString("combo.yes"), resourceMap.getString("combo.no") }));
        rateIdComboBox.setRenderer(new DefaultListCellRenderer() {
           @Override
           public Component getListCellRendererComponent(
                   JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
               super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
               if (value instanceof Rate) {
                   Rate rate = (Rate)value;
                   setText(rate.getRateName());
               }
               return this;
           }
       });
        
        //Buttons of sections:
        calendarNewButton = new HidroCalendarNewButton();
        calendarDeleteButton = new HidroCalendarDeleteButton();
        
        //Sections:
        //Details 1 panel:
        detailsSection.setImageIcon(new HidroBuildingDetailsLegend());                        
        contactSection.setImageIcon(new HidroContactLegend());
        databankSection.setImageIcon(new HidroBankLegend());
        //Details 2 panel:
        routemapSection.setImageIcon(new HidroRouteMapLegend());
        rateSection.setImageIcon(new HidroRateLegend());
        severalDataSection.setImageIcon(new HidroSeveralDataLegend());
        observationsSection.setImageIcon(new HidroObservationsLegend());
        
        routemapSection.addButton(calendarNewButton);
        routemapSection.addButton(calendarDeleteButton);
    }
    
    protected void initTopPanel() {
        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(hidrocon.HidroconApp.class).getContext().getResourceMap(HidroconView.class);
        topPanel.setTitle("  " + resourceMap.getString("building.details.toppanel.title"));
		
        arrowLeftButton = new HidroArrowLeftButton();
        rateButton = new HidroRateButton();
        administratorButton = new HidroAdministratorButton();
        editButton = new HidroEditButton();
        saveButton = new HidroSaveButton();
        exitButton = new HidroExitButton();
        arrowRightButton = new HidroArrowRightButton();
        
        editButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setMode(Constant.VIEW_MODE_UPDATE);
            }
        });       
		
        arrowLeftButton.setToolTipText(resourceMap.getString("building.details.toolbar.arrowleftbutton.tooltip"));
        arrowRightButton.setToolTipText(resourceMap.getString("building.details.toolbar.arrowrightbutton.tooltip"));
        rateButton.setToolTipText(resourceMap.getString("building.details.toolbar.ratebutton.tooltip"));
        administratorButton.setToolTipText(resourceMap.getString("building.details.toolbar.administratorbutton.tooltip"));
        editButton.setToolTipText(resourceMap.getString("building.details.toolbar.editbutton.tooltip"));
        saveButton.setToolTipText(resourceMap.getString("building.details.toolbar.savebutton.tooltip"));
        exitButton.setToolTipText(resourceMap.getString("building.details.toolbar.exitbutton.tooltip"));
        
        topPanel.addButton(arrowLeftButton);
        topPanel.addButton(arrowRightButton);
        topPanel.addButton(rateButton);
        topPanel.addButton(administratorButton);
        topPanel.addButton(editButton);
        topPanel.addButton(saveButton);
        topPanel.addButton(exitButton);
        
        arrowLeftButton.setVisible(false);
        //arrowRightButton.setVisible(true);
	}
        
    protected void initFocus() {
        buildingCodeField.requestFocusInWindow();
    }

    public void enableAllFields(boolean enabled) {
        //Init
        buildingCodeField.setEditable(enabled);
        administratorIdField.setEditable(enabled);
        modelField.setEditable(enabled);
        //Details 
        typeNameField.setEditable(enabled);
        addressField.setEditable(enabled);
        zipCodeField.setEditable(enabled);
        fechinicioField.setEditable(enabled);
        nifField.setEditable(enabled);
        numberReadingsPerYearField.setEditable(enabled);
        numberCWMField.setEditable(enabled);
        numberHWMField.setEditable(enabled);
        numberCWMPerHomeField.setEditable(enabled);
        numberHWMPerField.setEditable(enabled);
        //Contact
        nombcontacField.setEditable(enabled);
        contactPhoneNumberField.setEditable(enabled);
        contactPhoneNumber2Field.setEditable(enabled);
        noticeNameField.setEditable(enabled);
        noticeAddressField.setEditable(enabled);
        noticeZipCodeField.setEditable(enabled);
        noticeNumberField.setEditable(enabled);
        //Bank data
        relatedBankIBANField.setEditable(enabled);
        relatedBankEntityField.setEditable(enabled);
        relatedBankOfficeField.setEditable(enabled);
        relatedBankDCField.setEditable(enabled);
        relatedBankAccountField.setEditable(enabled);
        relatedBankCCCDetailsField.setEditable(enabled);
        hidroconBankIBANField.setEditable(enabled);
        hidroconBankEntityField.setEditable(enabled);
        hidroconBankOfficeField.setEditable(enabled);
        hidroconBankDCField.setEditable(enabled);
        hidroconBankAccountField.setEditable(enabled);
        //Rates
        billPerBlocksCheck.setEnabled(enabled);
        ratePersonalizedCheck.setEnabled(enabled);
        rateIdComboBox.setEnabled(enabled);
        amountM3ColdWaterField.setEditable(enabled);
        amountM3HotWaterField.setEditable(enabled);
        cuotacanalField.setEditable(enabled);
        fijoacField.setEditable(enabled);
        //Observations
        observationsField.setEditable(enabled);
        readerObservationsField.setEditable(enabled);
    }    
    
    public void writeData(Building building, Administrator administrator, ArrayList routeBuildingDateList) {
        String administratorName = "";
        if (administrator!=null) {
            administratorName = administrator.getAdministratorName()!=null? administrator.getAdministratorName() : "";
        }
        //Init
        buildingCodeField.setText(building.getBuildingCode());
        administratorIdField.setValue(building.getAdministratorId());
        administratorNameField.setText(administratorName);
        modelField.setValue(building.getModelId());
        //Details 
        typeNameField.setText(building.getTypeName());
        addressField.setText(building.getAddress());
        zipCodeField.setText(building.getZipCode());
        //fechinicioField.setText(building.getFechinicio());
        nifField.setText(building.getNif());
        numberReadingsPerYearField.setValue(building.getNumberReadingsPerYear());
        numberCWMField.setValue(building.getNumberColdWaterMeters());
        numberHWMField.setValue(building.getNumberHotWaterMeters());
        numberCWMPerHomeField.setValue(building.getNumberColdWaterMetersPerHome());
        numberHWMPerField.setValue(building.getNumberHotWaterMetersPerHome());
        //Contact
        nombcontacField.setText(building.getContactName());
        contactPhoneNumberField.setText(building.getContactPhoneNumber());
        contactPhoneNumber2Field.setText(building.getContactPhoneNumber2());
        noticeNameField.setText(building.getNoticeName());
        noticeAddressField.setText(building.getNoticeAddress());
        noticeZipCodeField.setText(building.getZipCode());
        //noticeNumberField.setValue(building.getNoticeNumber());
        //Bank data
        relatedBankIBANField.setText(building.getRelatedBankIban());
        relatedBankEntityField.setText(building.getRelatedBankEntity());
        relatedBankOfficeField.setText(building.getRelatedBankOffice());
        relatedBankDCField.setText(building.getRelatedBankDc());
        relatedBankAccountField.setText(building.getRelatedBankAccount());
        relatedBankCCCDetailsField.setText(building.getRelatedBankCccDetails());
        hidroconBankIBANField.setText(building.getHidroconBankIban());
        hidroconBankEntityField.setText(building.getHidroconBankEntity());
        hidroconBankOfficeField.setText(building.getHidroconBankOffice());
        hidroconBankDCField.setText(building.getHidroconBankDc());
        hidroconBankAccountField.setText(building.getHidroconBankAccount());
        //Rates
        billPerBlocksCheck.setSelected(building.getBillPerBlocks() == Constant.CHARACTER_TRUE);
        ratePersonalizedCheck.setEnabled(building.getRateIsDefault() == Constant.CHARACTER_FALSE);
        amountM3ColdWaterField.setValue(building.getAmmountM3ColdWater());
        amountM3HotWaterField.setValue(building.getAmmountM3HotWater());
        //cuotacanalField.setText();
        //fijoacField.setText();
        //Observations
        observationsField.setText(building.getObservations());
        readerObservationsField.setText(building.getReaderObservations());
        
        this.routeBuildingDateList.clear();
        this.routeBuildingDateList.addAll(routeBuildingDateList);                
    }    
    
	/*
	 * HidroDialog abstract methods implementation - END
	 */
    
	/*
	 * Toolbar action methods  - BEGIN
	 */
    
    public void showDetails1() {
        CardLayout cl = (CardLayout)mainPanel.getLayout();
        cl.show(mainPanel, "details1Panel");
        arrowLeftButton.setVisible(false);
        arrowRightButton.setVisible(true);
    }

    public void showDetails2() {
        CardLayout cl = (CardLayout)mainPanel.getLayout();
        cl.show(mainPanel, "details2Panel");
        arrowLeftButton.setVisible(true);
        arrowRightButton.setVisible(false);
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
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        routeBuildingDateList = org.jdesktop.observablecollections.ObservableCollections.observableList(new ArrayList<RouteBuildingDateView>());
        rateList = org.jdesktop.observablecollections.ObservableCollections.observableList(new ArrayList());
        hidroIntegerField4 = new hidrocon.custom.field.HidroIntegerField();
        topPanel = new hidrocon.custom.panel.HidroTopPanel();
        mainPanel = new hidrocon.custom.panel.HidroMainPanel();
        details1Panel = new hidrocon.custom.panel.HidroPanel();
        hidroPanel1 = new hidrocon.custom.panel.HidroPanel();
        buildingCodeLabel = new hidrocon.custom.label.HidroLabel();
        modelLabel = new hidrocon.custom.label.HidroLabel();
        administratorLabel = new hidrocon.custom.label.HidroLabel();
        buildingCodeField = new hidrocon.custom.field.HidroTextField();
        administratorIdField = new hidrocon.custom.field.HidroIntegerField();
        modelField = new hidrocon.custom.field.HidroIntegerField();
        administratorNameField = new hidrocon.custom.field.HidroTextField();
        administratorSearchButton = new hidrocon.custom.button.HidroSearchButton();
        supportTypeCodeLabel = new hidrocon.custom.label.HidroLabel();
        supportTypeCodeComboBox = new hidrocon.custom.field.HidroComboBox();
        supportExternalIDLabel = new hidrocon.custom.label.HidroLabel();
        supportExternalIDField = new hidrocon.custom.field.HidroIntegerField();
        detailsSection = new hidrocon.custom.panel.HidroSectionPanel();
        detailsPanel = new hidrocon.custom.panel.HidroPanel();
        addressField = new hidrocon.custom.field.HidroTextField();
        addressLabel = new hidrocon.custom.label.HidroLabel();
        zipCodeLabel = new hidrocon.custom.label.HidroLabel();
        nifLabel = new hidrocon.custom.label.HidroLabel();
        fechinicioLabel = new hidrocon.custom.label.HidroLabel();
        fechinicioField = new hidrocon.custom.field.HidroTextField();
        nifField = new hidrocon.custom.field.HidroTextField();
        zipCodeField = new hidrocon.custom.field.HidroTextField();
        typeNameLabel = new hidrocon.custom.label.HidroLabel();
        typeNameField = new hidrocon.custom.field.HidroTextField();
        filler2 = new javax.swing.Box.Filler(new java.awt.Dimension(10, 0), new java.awt.Dimension(10, 0), new java.awt.Dimension(10, 10));
        numberCWMField = new hidrocon.custom.field.HidroIntegerField();
        numberHWMField = new hidrocon.custom.field.HidroIntegerField();
        numberCWMPerHomeField = new hidrocon.custom.field.HidroIntegerField();
        numberHWMPerField = new hidrocon.custom.field.HidroIntegerField();
        numberMetersColdWaterLabel = new hidrocon.custom.label.HidroLabel();
        numberMetersHotWaterLabel = new hidrocon.custom.label.HidroLabel();
        numberHWMPerHomeLabel = new hidrocon.custom.label.HidroLabel();
        numberCWMPerHomeLabel = new hidrocon.custom.label.HidroLabel();
        filler3 = new javax.swing.Box.Filler(new java.awt.Dimension(35, 0), new java.awt.Dimension(35, 0), new java.awt.Dimension(35, 32767));
        filler4 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 10), new java.awt.Dimension(0, 10), new java.awt.Dimension(32767, 10));
        numberReadingsPerYearLabel = new hidrocon.custom.label.HidroLabel();
        numberReadingsPerYearField = new hidrocon.custom.field.HidroIntegerField();
        contactSection = new hidrocon.custom.panel.HidroSectionPanel();
        contactPanel = new hidrocon.custom.panel.HidroPanel();
        jLabel2 = new hidrocon.custom.label.HidroLabel();
        noticeNameField = new hidrocon.custom.field.HidroTextField();
        jLabel3 = new hidrocon.custom.label.HidroLabel();
        noticeNumberField = new hidrocon.custom.field.HidroTextField();
        noticeAddressField = new hidrocon.custom.field.HidroTextField();
        noticeZipCodeField = new hidrocon.custom.field.HidroTextField();
        phoneNumberLabel = new hidrocon.custom.label.HidroLabel();
        contactPhoneNumberField = new hidrocon.custom.field.HidroTextField();
        contactPhoneNumber2Field = new hidrocon.custom.field.HidroTextField();
        nombcontacField = new hidrocon.custom.field.HidroTextField();
        nombcontacLabel = new hidrocon.custom.label.HidroLabel();
        databankSection = new hidrocon.custom.panel.HidroSectionPanel();
        databankPanel = new hidrocon.custom.panel.HidroPanel();
        relatedBankLabel = new hidrocon.custom.label.HidroLabel();
        hidroconBankLabel = new hidrocon.custom.label.HidroLabel();
        relatedBankIBANField = new hidrocon.custom.field.HidroTextField();
        relatedBankEntityField = new hidrocon.custom.field.HidroTextField();
        relatedBankOfficeField = new hidrocon.custom.field.HidroTextField();
        relatedBankDCField = new hidrocon.custom.field.HidroTextField();
        relatedBankAccountField = new hidrocon.custom.field.HidroTextField();
        hidroconBankAccountField = new hidrocon.custom.field.HidroTextField();
        hidroconBankIBANField = new hidrocon.custom.field.HidroTextField();
        hidroconBankEntityField = new hidrocon.custom.field.HidroTextField();
        hidroconBankOfficeField = new hidrocon.custom.field.HidroTextField();
        hidroconBankDCField = new hidrocon.custom.field.HidroTextField();
        relatedBankIBANLabel = new hidrocon.custom.label.HidroXSLabel();
        relatedBankCCCDetailsField = new hidrocon.custom.field.HidroTextField();
        relatedBankCCCDetailsLabel = new hidrocon.custom.label.HidroLabel();
        relatedBankEntityLabel = new hidrocon.custom.label.HidroXSLabel();
        relatedBankOfficeLabel = new hidrocon.custom.label.HidroXSLabel();
        relatedBankDCLabel = new hidrocon.custom.label.HidroXSLabel();
        relatedBankAccountLabel = new hidrocon.custom.label.HidroXSLabel();
        hidroconBankIBANLabel = new hidrocon.custom.label.HidroXSLabel();
        hidroconBankEntityLabel = new hidrocon.custom.label.HidroXSLabel();
        hidroconBankOfficeLabel = new hidrocon.custom.label.HidroXSLabel();
        hidroconBankDCLabel = new hidrocon.custom.label.HidroXSLabel();
        hidroconBankAccountLabel = new hidrocon.custom.label.HidroXSLabel();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(5, 0), new java.awt.Dimension(5, 0), new java.awt.Dimension(5, 32767));
        printPanel = new hidrocon.custom.panel.HidroPanel();
        lgLabel = new hidrocon.custom.label.HidroLabel();
        lsTextField = new hidrocon.custom.field.HidroIntegerField();
        laTextField = new hidrocon.custom.field.HidroIntegerField();
        laLabel = new hidrocon.custom.label.HidroLabel();
        lsLabel = new hidrocon.custom.label.HidroLabel();
        lpTextField = new hidrocon.custom.field.HidroIntegerField();
        lbTextField = new hidrocon.custom.field.HidroIntegerField();
        lgTextField = new hidrocon.custom.field.HidroTextField();
        lpLabel = new hidrocon.custom.label.HidroLabel();
        lbLabel = new hidrocon.custom.label.HidroLabel();
        left1Filler = new javax.swing.Box.Filler(new java.awt.Dimension(25, 0), new java.awt.Dimension(25, 0), new java.awt.Dimension(25, 32767));
        right1Filler = new javax.swing.Box.Filler(new java.awt.Dimension(25, 0), new java.awt.Dimension(25, 0), new java.awt.Dimension(25, 32767));
        details2Panel = new hidrocon.custom.panel.HidroPanel();
        routemapSection = new hidrocon.custom.panel.HidroSectionPanel();
        routemapPanel = new hidrocon.custom.panel.HidroPanel();
        routeBuildingDateScrollPane = new javax.swing.JScrollPane();
        routeBuildingDateTable = new hidrocon.custom.table.HidroDetailsTable();
        routePersonalizedCheckBox = new hidrocon.custom.field.HidroCheckBox();
        estimateReadingTypeComboBox = new hidrocon.custom.field.HidroComboBox();
        estimateReadingTypeLabel = new hidrocon.custom.label.HidroLabel();
        rateSection = new hidrocon.custom.panel.HidroSectionPanel();
        ratePanel = new hidrocon.custom.panel.HidroPanel();
        amountM3ColdWaterLabel = new hidrocon.custom.label.HidroLabel();
        cuotacanalLabel = new hidrocon.custom.label.HidroLabel();
        amountM3ColdWaterField = new hidrocon.custom.field.HidroFloatField();
        cuotacanalField = new hidrocon.custom.field.HidroFloatField();
        amountM3HotWaterLabel = new hidrocon.custom.label.HidroLabel();
        fijoacLabel = new hidrocon.custom.label.HidroLabel();
        amountM3HotWaterField = new hidrocon.custom.field.HidroFloatField();
        fijoacField = new hidrocon.custom.field.HidroFloatField();
        billPerBlocksCheck = new hidrocon.custom.field.HidroCheckBox();
        ratePersonalizedCheck = new hidrocon.custom.field.HidroCheckBox();
        rateIdComboBox = new hidrocon.custom.field.HidroComboBox();
        left2Filler = new javax.swing.Box.Filler(new java.awt.Dimension(25, 25), new java.awt.Dimension(25, 25), new java.awt.Dimension(25, 32767));
        right2Filler = new javax.swing.Box.Filler(new java.awt.Dimension(25, 0), new java.awt.Dimension(25, 0), new java.awt.Dimension(25, 32767));
        severalDataSection = new hidrocon.custom.panel.HidroSectionPanel();
        severalDataPanel = new hidrocon.custom.panel.HidroPanel();
        hidroLabel2 = new hidrocon.custom.label.HidroLabel();
        hidroIntegerField1 = new hidrocon.custom.field.HidroIntegerField();
        hidroLabel3 = new hidrocon.custom.label.HidroLabel();
        hidroIntegerField2 = new hidrocon.custom.field.HidroIntegerField();
        hidroLabel4 = new hidrocon.custom.label.HidroLabel();
        hidroIntegerField3 = new hidrocon.custom.field.HidroIntegerField();
        hidroLabel5 = new hidrocon.custom.label.HidroLabel();
        hidroIntegerField5 = new hidrocon.custom.field.HidroIntegerField();
        hidroLabel6 = new hidrocon.custom.label.HidroLabel();
        hidroIntegerField6 = new hidrocon.custom.field.HidroIntegerField();
        hidroLabel7 = new hidrocon.custom.label.HidroLabel();
        hidroLabel8 = new hidrocon.custom.label.HidroLabel();
        hidroCheckBox1 = new hidrocon.custom.field.HidroCheckBox();
        hidroFloatField1 = new hidrocon.custom.field.HidroFloatField();
        hidroFloatField2 = new hidrocon.custom.field.HidroFloatField();
        observationsSection = new hidrocon.custom.panel.HidroSectionPanel();
        observationsPanel = new hidrocon.custom.panel.HidroPanel();
        readerObservationsScrollPane = new javax.swing.JScrollPane();
        readerObservationsField = new hidrocon.custom.field.HidroTextArea();
        observationsScrollPane = new javax.swing.JScrollPane();
        observationsField = new hidrocon.custom.field.HidroTextArea();
        obs2Label = new hidrocon.custom.label.HidroLabel();
        bottom2Filler = new javax.swing.Box.Filler(new java.awt.Dimension(0, 10), new java.awt.Dimension(0, 10), new java.awt.Dimension(32767, 10));

        hidroIntegerField4.setName("hidroIntegerField4"); // NOI18N

        setMinimumSize(new java.awt.Dimension(600, 625));
        setName("Form"); // NOI18N
        setPreferredSize(new java.awt.Dimension(600, 625));
        setLayout(new java.awt.BorderLayout());

        topPanel.setMaximumSize(new java.awt.Dimension(580, 35));
        topPanel.setName("topPanel"); // NOI18N
        add(topPanel, java.awt.BorderLayout.PAGE_START);

        mainPanel.setMaximumSize(new java.awt.Dimension(600, 600));
        mainPanel.setMinimumSize(new java.awt.Dimension(600, 650));
        mainPanel.setName("mainPanel"); // NOI18N
        mainPanel.setPreferredSize(new java.awt.Dimension(600, 600));
        mainPanel.setLayout(new java.awt.CardLayout());

        details1Panel.setMaximumSize(new java.awt.Dimension(580, 549));
        details1Panel.setMinimumSize(new java.awt.Dimension(580, 549));
        details1Panel.setName("details1Panel"); // NOI18N
        details1Panel.setPreferredSize(new java.awt.Dimension(580, 549));
        details1Panel.setLayout(new java.awt.GridBagLayout());

        hidroPanel1.setMaximumSize(new java.awt.Dimension(560, 32767));
        hidroPanel1.setName("hidroPanel1"); // NOI18N
        hidroPanel1.setPreferredSize(new java.awt.Dimension(577, 44));

        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(hidrocon.HidroconApp.class).getContext().getResourceMap(BuildingDetailsPanelView.class);
        buildingCodeLabel.setText(resourceMap.getString("buildingCodeLabel.text")); // NOI18N
        buildingCodeLabel.setName("buildingCodeLabel"); // NOI18N

        modelLabel.setText(resourceMap.getString("modelLabel.text")); // NOI18N
        modelLabel.setName("modelLabel"); // NOI18N

        administratorLabel.setText(resourceMap.getString("administratorLabel.text")); // NOI18N
        administratorLabel.setName("administratorLabel"); // NOI18N

        buildingCodeField.setName("buildingCodeField"); // NOI18N

        administratorIdField.setText(resourceMap.getString("administratorIdField.text")); // NOI18N
        administratorIdField.setName("administratorIdField"); // NOI18N

        modelField.setName("modelField"); // NOI18N

        administratorNameField.setName("administratorNameField"); // NOI18N

        administratorSearchButton.setName("administratorSearchButton"); // NOI18N

        supportTypeCodeLabel.setText(resourceMap.getString("supportTypeCodeLabel.text")); // NOI18N
        supportTypeCodeLabel.setName("supportTypeCodeLabel"); // NOI18N

        supportTypeCodeComboBox.setName("supportTypeCodeComboBox"); // NOI18N

        supportExternalIDLabel.setText(resourceMap.getString("supportExternalIDLabel.text")); // NOI18N
        supportExternalIDLabel.setName("supportExternalIDLabel"); // NOI18N

        supportExternalIDField.setText(resourceMap.getString("supportExternalIDField.text")); // NOI18N
        supportExternalIDField.setName("supportExternalIDField"); // NOI18N

        javax.swing.GroupLayout hidroPanel1Layout = new javax.swing.GroupLayout(hidroPanel1);
        hidroPanel1.setLayout(hidroPanel1Layout);
        hidroPanel1Layout.setHorizontalGroup(
            hidroPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(hidroPanel1Layout.createSequentialGroup()
                .addGroup(hidroPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(buildingCodeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(modelLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(4, 4, 4)
                .addGroup(hidroPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(buildingCodeField, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(modelField, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(hidroPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(administratorLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(supportTypeCodeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(hidroPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(hidroPanel1Layout.createSequentialGroup()
                        .addComponent(administratorIdField, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(administratorNameField, javax.swing.GroupLayout.DEFAULT_SIZE, 245, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(administratorSearchButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(hidroPanel1Layout.createSequentialGroup()
                        .addComponent(supportTypeCodeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(supportExternalIDLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(supportExternalIDField, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)))
                .addContainerGap())
        );
        hidroPanel1Layout.setVerticalGroup(
            hidroPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(hidroPanel1Layout.createSequentialGroup()
                .addGroup(hidroPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(hidroPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(administratorLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(administratorIdField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(administratorNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(administratorSearchButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(hidroPanel1Layout.createSequentialGroup()
                        .addGroup(hidroPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(buildingCodeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(buildingCodeField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(hidroPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(modelLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(modelField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(supportTypeCodeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(supportTypeCodeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(supportExternalIDLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(supportExternalIDField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 10, 0);
        details1Panel.add(hidroPanel1, gridBagConstraints);

        detailsSection.setMaximumSize(new java.awt.Dimension(560, 30));
        detailsSection.setName("detailsSection"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        details1Panel.add(detailsSection, gridBagConstraints);

        detailsPanel.setMaximumSize(new java.awt.Dimension(540, 105));
        detailsPanel.setMinimumSize(new java.awt.Dimension(540, 105));
        detailsPanel.setName("detailsPanel"); // NOI18N
        detailsPanel.setPreferredSize(new java.awt.Dimension(540, 100));
        detailsPanel.setLayout(new java.awt.GridBagLayout());

        addressField.setName("addressField"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 300;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(3, 10, 0, 0);
        detailsPanel.add(addressField, gridBagConstraints);

        addressLabel.setText(resourceMap.getString("addressLabel.text")); // NOI18N
        addressLabel.setName("addressLabel"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 0, 0, 0);
        detailsPanel.add(addressLabel, gridBagConstraints);

        zipCodeLabel.setText(resourceMap.getString("zipCodeLabel.text")); // NOI18N
        zipCodeLabel.setName("zipCodeLabel"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 0, 0, 0);
        detailsPanel.add(zipCodeLabel, gridBagConstraints);

        nifLabel.setText(resourceMap.getString("nifLabel.text")); // NOI18N
        nifLabel.setMaximumSize(new java.awt.Dimension(50, 17));
        nifLabel.setName("nifLabel"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 20, 0, 5);
        detailsPanel.add(nifLabel, gridBagConstraints);

        fechinicioLabel.setText(resourceMap.getString("fechinicioLabel.text")); // NOI18N
        fechinicioLabel.setName("fechinicioLabel"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 0, 0, 0);
        detailsPanel.add(fechinicioLabel, gridBagConstraints);

        fechinicioField.setName("fechinicioField"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.ipadx = 93;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(3, 10, 0, 0);
        detailsPanel.add(fechinicioField, gridBagConstraints);

        nifField.setName("nifField"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 99;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(3, 0, 0, 0);
        detailsPanel.add(nifField, gridBagConstraints);

        zipCodeField.setName("zipCodeField"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.ipadx = 93;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(3, 10, 0, 0);
        detailsPanel.add(zipCodeField, gridBagConstraints);

        typeNameLabel.setText(resourceMap.getString("typeNameLabel.text")); // NOI18N
        typeNameLabel.setName("typeNameLabel"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 0, 0, 0);
        detailsPanel.add(typeNameLabel, gridBagConstraints);

        typeNameField.setName("typeNameField"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 300;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(3, 10, 0, 0);
        detailsPanel.add(typeNameField, gridBagConstraints);

        filler2.setName("filler2"); // NOI18N
        filler2.setOpaque(true);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 12;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        detailsPanel.add(filler2, gridBagConstraints);

        numberCWMField.setName("numberCWMField"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 11;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 38;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(3, 10, 0, 0);
        detailsPanel.add(numberCWMField, gridBagConstraints);

        numberHWMField.setName("numberHWMField"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 11;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.ipadx = 38;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(3, 10, 0, 0);
        detailsPanel.add(numberHWMField, gridBagConstraints);

        numberCWMPerHomeField.setName("numberCWMPerHomeField"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 11;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.ipadx = 38;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(3, 10, 0, 0);
        detailsPanel.add(numberCWMPerHomeField, gridBagConstraints);

        numberHWMPerField.setName("numberHWMPerField"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 11;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.ipadx = 38;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(3, 10, 0, 0);
        detailsPanel.add(numberHWMPerField, gridBagConstraints);

        numberMetersColdWaterLabel.setText(resourceMap.getString("numberMetersColdWaterLabel.text")); // NOI18N
        numberMetersColdWaterLabel.setName("numberMetersColdWaterLabel"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 10;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 0, 0, 0);
        detailsPanel.add(numberMetersColdWaterLabel, gridBagConstraints);

        numberMetersHotWaterLabel.setText(resourceMap.getString("numberMetersHotWaterLabel.text")); // NOI18N
        numberMetersHotWaterLabel.setName("numberMetersHotWaterLabel"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 10;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 0, 0, 0);
        detailsPanel.add(numberMetersHotWaterLabel, gridBagConstraints);

        numberHWMPerHomeLabel.setText(resourceMap.getString("numberHWMPerHomeLabel.text")); // NOI18N
        numberHWMPerHomeLabel.setName("numberHWMPerHomeLabel"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 10;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 0, 0, 0);
        detailsPanel.add(numberHWMPerHomeLabel, gridBagConstraints);

        numberCWMPerHomeLabel.setText(resourceMap.getString("numberCWMPerHomeLabel.text")); // NOI18N
        numberCWMPerHomeLabel.setName("numberCWMPerHomeLabel"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 10;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 0, 0, 0);
        detailsPanel.add(numberCWMPerHomeLabel, gridBagConstraints);

        filler3.setName("filler3"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 9;
        gridBagConstraints.gridy = 0;
        detailsPanel.add(filler3, gridBagConstraints);

        filler4.setName("filler4"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        detailsPanel.add(filler4, gridBagConstraints);

        numberReadingsPerYearLabel.setText(resourceMap.getString("numberReadingsPerYearLabel.text")); // NOI18N
        numberReadingsPerYearLabel.setName("numberReadingsPerYearLabel"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.insets = new java.awt.Insets(6, 20, 0, 5);
        detailsPanel.add(numberReadingsPerYearLabel, gridBagConstraints);

        numberReadingsPerYearField.setName("numberReadingsPerYearField"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(3, 0, 0, 0);
        detailsPanel.add(numberReadingsPerYearField, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 0, 0);
        details1Panel.add(detailsPanel, gridBagConstraints);

        contactSection.setMaximumSize(new java.awt.Dimension(560, 30));
        contactSection.setName("contactSection"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        details1Panel.add(contactSection, gridBagConstraints);

        contactPanel.setMaximumSize(new java.awt.Dimension(540, 105));
        contactPanel.setMinimumSize(new java.awt.Dimension(540, 105));
        contactPanel.setName("contactPanel"); // NOI18N

        jLabel2.setText(resourceMap.getString("jLabel2.text")); // NOI18N
        jLabel2.setName("jLabel2"); // NOI18N

        noticeNameField.setName("noticeNameField"); // NOI18N

        jLabel3.setText(resourceMap.getString("jLabel3.text")); // NOI18N
        jLabel3.setName("jLabel3"); // NOI18N

        noticeNumberField.setName("noticeNumberField"); // NOI18N

        noticeAddressField.setName("noticeAddressField"); // NOI18N

        noticeZipCodeField.setName("noticeZipCodeField"); // NOI18N

        phoneNumberLabel.setText(resourceMap.getString("phoneNumberLabel.text")); // NOI18N
        phoneNumberLabel.setName("phoneNumberLabel"); // NOI18N

        contactPhoneNumberField.setName("contactPhoneNumberField"); // NOI18N

        contactPhoneNumber2Field.setName("contactPhoneNumber2Field"); // NOI18N

        nombcontacField.setDoubleBuffered(true);
        nombcontacField.setName("nombcontacField"); // NOI18N

        nombcontacLabel.setText(resourceMap.getString("nombcontacLabel.text")); // NOI18N
        nombcontacLabel.setName("nombcontacLabel"); // NOI18N

        javax.swing.GroupLayout contactPanelLayout = new javax.swing.GroupLayout(contactPanel);
        contactPanel.setLayout(contactPanelLayout);
        contactPanelLayout.setHorizontalGroup(
            contactPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contactPanelLayout.createSequentialGroup()
                .addGroup(contactPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(contactPanelLayout.createSequentialGroup()
                        .addComponent(contactPhoneNumberField, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                        .addComponent(contactPhoneNumber2Field, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(phoneNumberLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nombcontacField, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nombcontacLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(contactPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(contactPanelLayout.createSequentialGroup()
                        .addComponent(noticeZipCodeField, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(3, 3, 3)
                        .addComponent(noticeNumberField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(noticeNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(noticeAddressField, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        contactPanelLayout.setVerticalGroup(
            contactPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, contactPanelLayout.createSequentialGroup()
                .addGroup(contactPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(contactPanelLayout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(noticeNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(noticeAddressField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(contactPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(noticeNumberField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(contactPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(noticeZipCodeField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(contactPanelLayout.createSequentialGroup()
                        .addComponent(phoneNumberLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(contactPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(contactPhoneNumberField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(contactPhoneNumber2Field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(contactPanelLayout.createSequentialGroup()
                        .addComponent(nombcontacLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nombcontacField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 0, 0);
        details1Panel.add(contactPanel, gridBagConstraints);

        databankSection.setMaximumSize(new java.awt.Dimension(560, 30));
        databankSection.setName("databankSection"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        details1Panel.add(databankSection, gridBagConstraints);

        databankPanel.setMaximumSize(new java.awt.Dimension(540, 116));
        databankPanel.setMinimumSize(new java.awt.Dimension(540, 115));
        databankPanel.setName("databankPanel"); // NOI18N
        databankPanel.setPreferredSize(new java.awt.Dimension(540, 115));
        databankPanel.setLayout(new java.awt.GridBagLayout());

        relatedBankLabel.setText(resourceMap.getString("relatedBankLabel.text")); // NOI18N
        relatedBankLabel.setName("relatedBankLabel"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 8;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        databankPanel.add(relatedBankLabel, gridBagConstraints);

        hidroconBankLabel.setText(resourceMap.getString("hidroconBankLabel.text")); // NOI18N
        hidroconBankLabel.setName("hidroconBankLabel"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 21;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 18, 0, 0);
        databankPanel.add(hidroconBankLabel, gridBagConstraints);

        relatedBankIBANField.setName("relatedBankIBANField"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.ipadx = 35;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 0, 0, 0);
        databankPanel.add(relatedBankIBANField, gridBagConstraints);

        relatedBankEntityField.setName("relatedBankEntityField"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.ipadx = 35;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 6, 0, 0);
        databankPanel.add(relatedBankEntityField, gridBagConstraints);

        relatedBankOfficeField.setName("relatedBankOfficeField"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 7;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.ipadx = 35;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 6, 0, 0);
        databankPanel.add(relatedBankOfficeField, gridBagConstraints);

        relatedBankDCField.setName("relatedBankDCField"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 8;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.ipadx = 20;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 6, 0, 0);
        databankPanel.add(relatedBankDCField, gridBagConstraints);

        relatedBankAccountField.setName("relatedBankAccountField"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 9;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.ipadx = 85;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 6, 0, 0);
        databankPanel.add(relatedBankAccountField, gridBagConstraints);

        hidroconBankAccountField.setName("hidroconBankAccountField"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 26;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.ipadx = 85;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 6, 0, 0);
        databankPanel.add(hidroconBankAccountField, gridBagConstraints);

        hidroconBankIBANField.setName("hidroconBankIBANField"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 21;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.ipadx = 35;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 18, 0, 0);
        databankPanel.add(hidroconBankIBANField, gridBagConstraints);

        hidroconBankEntityField.setName("hidroconBankEntityField"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 23;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.ipadx = 35;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 6, 0, 0);
        databankPanel.add(hidroconBankEntityField, gridBagConstraints);

        hidroconBankOfficeField.setName("hidroconBankOfficeField"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 24;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.ipadx = 35;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 6, 0, 0);
        databankPanel.add(hidroconBankOfficeField, gridBagConstraints);

        hidroconBankDCField.setName("hidroconBankDCField"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 25;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.ipadx = 20;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 6, 0, 0);
        databankPanel.add(hidroconBankDCField, gridBagConstraints);

        relatedBankIBANLabel.setText(resourceMap.getString("relatedBankIBANLabel.text")); // NOI18N
        relatedBankIBANLabel.setName("relatedBankIBANLabel"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.ipadx = 15;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 0, 0, 0);
        databankPanel.add(relatedBankIBANLabel, gridBagConstraints);

        relatedBankCCCDetailsField.setName("relatedBankCCCDetailsField"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 10;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 200;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(4, 0, 0, 0);
        databankPanel.add(relatedBankCCCDetailsField, gridBagConstraints);

        relatedBankCCCDetailsLabel.setText(resourceMap.getString("relatedBankCCCDetailsLabel.text")); // NOI18N
        relatedBankCCCDetailsLabel.setName("relatedBankCCCDetailsLabel"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 8;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 0, 0, 0);
        databankPanel.add(relatedBankCCCDetailsLabel, gridBagConstraints);

        relatedBankEntityLabel.setText(resourceMap.getString("relatedBankEntityLabel.text")); // NOI18N
        relatedBankEntityLabel.setName("relatedBankEntityLabel"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 6, 0, 0);
        databankPanel.add(relatedBankEntityLabel, gridBagConstraints);

        relatedBankOfficeLabel.setText(resourceMap.getString("relatedBankOfficeLabel.text")); // NOI18N
        relatedBankOfficeLabel.setName("relatedBankOfficeLabel"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 7;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 6, 0, 0);
        databankPanel.add(relatedBankOfficeLabel, gridBagConstraints);

        relatedBankDCLabel.setText(resourceMap.getString("relatedBankDCLabel.text")); // NOI18N
        relatedBankDCLabel.setName("relatedBankDCLabel"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 8;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 6, 0, 0);
        databankPanel.add(relatedBankDCLabel, gridBagConstraints);

        relatedBankAccountLabel.setText(resourceMap.getString("relatedBankAccountLabel.text")); // NOI18N
        relatedBankAccountLabel.setName("relatedBankAccountLabel"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 9;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 6, 0, 0);
        databankPanel.add(relatedBankAccountLabel, gridBagConstraints);

        hidroconBankIBANLabel.setText(resourceMap.getString("hidroconBankIBANLabel.text")); // NOI18N
        hidroconBankIBANLabel.setName("hidroconBankIBANLabel"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 21;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 18, 0, 0);
        databankPanel.add(hidroconBankIBANLabel, gridBagConstraints);

        hidroconBankEntityLabel.setText(resourceMap.getString("hidroconBankEntityLabel.text")); // NOI18N
        hidroconBankEntityLabel.setName("hidroconBankEntityLabel"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 23;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 6, 0, 0);
        databankPanel.add(hidroconBankEntityLabel, gridBagConstraints);

        hidroconBankOfficeLabel.setText(resourceMap.getString("hidroconBankOfficeLabel.text")); // NOI18N
        hidroconBankOfficeLabel.setName("hidroconBankOfficeLabel"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 24;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 6, 0, 0);
        databankPanel.add(hidroconBankOfficeLabel, gridBagConstraints);

        hidroconBankDCLabel.setText(resourceMap.getString("hidroconBankDCLabel.text")); // NOI18N
        hidroconBankDCLabel.setName("hidroconBankDCLabel"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 25;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 6, 0, 0);
        databankPanel.add(hidroconBankDCLabel, gridBagConstraints);

        hidroconBankAccountLabel.setText(resourceMap.getString("hidroconBankAccountLabel.text")); // NOI18N
        hidroconBankAccountLabel.setName("hidroconBankAccountLabel"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 26;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 6, 0, 0);
        databankPanel.add(hidroconBankAccountLabel, gridBagConstraints);

        filler1.setName("filler1"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 27;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        databankPanel.add(filler1, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 0, 0);
        details1Panel.add(databankPanel, gridBagConstraints);

        printPanel.setMaximumSize(new java.awt.Dimension(560, 32767));
        printPanel.setName("printPanel"); // NOI18N
        printPanel.setPreferredSize(new java.awt.Dimension(560, 19));

        lgLabel.setText(resourceMap.getString("lgLabel.text")); // NOI18N
        lgLabel.setName("lgLabel"); // NOI18N

        lsTextField.setName("lsTextField"); // NOI18N

        laTextField.setName("laTextField"); // NOI18N

        laLabel.setText(resourceMap.getString("laLabel.text")); // NOI18N
        laLabel.setName("laLabel"); // NOI18N

        lsLabel.setText(resourceMap.getString("lsLabel.text")); // NOI18N
        lsLabel.setName("lsLabel"); // NOI18N

        lpTextField.setName("lpTextField"); // NOI18N

        lbTextField.setName("lbTextField"); // NOI18N

        lgTextField.setName("lgTextField"); // NOI18N

        lpLabel.setText(resourceMap.getString("lpLabel.text")); // NOI18N
        lpLabel.setName("lpLabel"); // NOI18N

        lbLabel.setText(resourceMap.getString("lbLabel.text")); // NOI18N
        lbLabel.setName("lbLabel"); // NOI18N

        javax.swing.GroupLayout printPanelLayout = new javax.swing.GroupLayout(printPanel);
        printPanel.setLayout(printPanelLayout);
        printPanelLayout.setHorizontalGroup(
            printPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(printPanelLayout.createSequentialGroup()
                .addComponent(lgLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(lgTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(lbTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lpLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(lpTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(laLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(laTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lsLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(lsTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        printPanelLayout.setVerticalGroup(
            printPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(printPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(lgLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(lgTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(lbLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(lbTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(lpLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(lpTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(laLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(laTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(lsLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(lsTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 12;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        details1Panel.add(printPanel, gridBagConstraints);

        left1Filler.setName("left1Filler"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        details1Panel.add(left1Filler, gridBagConstraints);

        right1Filler.setName("right1Filler"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        details1Panel.add(right1Filler, gridBagConstraints);

        mainPanel.add(details1Panel, "details1Panel");

        details2Panel.setMaximumSize(new java.awt.Dimension(560, 575));
        details2Panel.setMinimumSize(new java.awt.Dimension(560, 575));
        details2Panel.setName("details2Panel"); // NOI18N
        details2Panel.setPreferredSize(new java.awt.Dimension(560, 575));
        details2Panel.setRequestFocusEnabled(false);
        details2Panel.setLayout(new java.awt.GridBagLayout());

        routemapSection.setName("routemapSection"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 0, 0);
        details2Panel.add(routemapSection, gridBagConstraints);

        routemapPanel.setMinimumSize(new java.awt.Dimension(0, 100));
        routemapPanel.setName("routemapPanel"); // NOI18N
        routemapPanel.setPreferredSize(new java.awt.Dimension(10, 100));

        routeBuildingDateScrollPane.setName("routeBuildingDateScrollPane"); // NOI18N

        routeBuildingDateTable.setColumnSelectionAllowed(true);
        routeBuildingDateTable.setName("routeBuildingDateTable"); // NOI18N

        org.jdesktop.swingbinding.JTableBinding jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, routeBuildingDateList, routeBuildingDateTable);
        org.jdesktop.swingbinding.JTableBinding.ColumnBinding columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${meterReadingDate}"));
        columnBinding.setColumnName("Meter Reading Date");
        columnBinding.setColumnClass(java.util.Date.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${routeName}"));
        columnBinding.setColumnName("Route Name");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();
        routeBuildingDateScrollPane.setViewportView(routeBuildingDateTable);
        routeBuildingDateTable.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        routeBuildingDateTable.getColumnModel().getColumn(0).setHeaderValue(resourceMap.getString("routeBuildingDateTable.columnModel.title0")); // NOI18N
        routeBuildingDateTable.getColumnModel().getColumn(1).setHeaderValue(resourceMap.getString("routeBuildingDateTable.columnModel.title1")); // NOI18N

        routePersonalizedCheckBox.setText(resourceMap.getString("routePersonalizedCheckBox.text")); // NOI18N
        routePersonalizedCheckBox.setName("routePersonalizedCheckBox"); // NOI18N

        estimateReadingTypeComboBox.setName("estimateReadingTypeComboBox"); // NOI18N

        org.jdesktop.swingbinding.JComboBoxBinding jComboBoxBinding = org.jdesktop.swingbinding.SwingBindings.createJComboBoxBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, rateList, estimateReadingTypeComboBox);
        bindingGroup.addBinding(jComboBoxBinding);

        estimateReadingTypeLabel.setText(resourceMap.getString("estimateReadingTypeLabel.text")); // NOI18N
        estimateReadingTypeLabel.setName("estimateReadingTypeLabel"); // NOI18N

        javax.swing.GroupLayout routemapPanelLayout = new javax.swing.GroupLayout(routemapPanel);
        routemapPanel.setLayout(routemapPanelLayout);
        routemapPanelLayout.setHorizontalGroup(
            routemapPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(routemapPanelLayout.createSequentialGroup()
                .addComponent(routeBuildingDateScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(routemapPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(estimateReadingTypeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(estimateReadingTypeComboBox, javax.swing.GroupLayout.DEFAULT_SIZE, 249, Short.MAX_VALUE)
                    .addComponent(routePersonalizedCheckBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        routemapPanelLayout.setVerticalGroup(
            routemapPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(routeBuildingDateScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 116, Short.MAX_VALUE)
            .addGroup(routemapPanelLayout.createSequentialGroup()
                .addComponent(routePersonalizedCheckBox, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(estimateReadingTypeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(estimateReadingTypeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54))
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 10, 0);
        details2Panel.add(routemapPanel, gridBagConstraints);

        rateSection.setName("rateSection"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        details2Panel.add(rateSection, gridBagConstraints);

        ratePanel.setMinimumSize(new java.awt.Dimension(0, 103));
        ratePanel.setName("ratePanel"); // NOI18N
        ratePanel.setPreferredSize(new java.awt.Dimension(550, 103));

        amountM3ColdWaterLabel.setText(resourceMap.getString("amountM3ColdWaterLabel.text")); // NOI18N
        amountM3ColdWaterLabel.setName("amountM3ColdWaterLabel"); // NOI18N

        cuotacanalLabel.setText(resourceMap.getString("cuotacanalLabel.text")); // NOI18N
        cuotacanalLabel.setName("cuotacanalLabel"); // NOI18N

        amountM3ColdWaterField.setName("amountM3ColdWaterField"); // NOI18N

        cuotacanalField.setName("cuotacanalField"); // NOI18N

        amountM3HotWaterLabel.setText(resourceMap.getString("amountM3HotWaterLabel.text")); // NOI18N
        amountM3HotWaterLabel.setName("amountM3HotWaterLabel"); // NOI18N

        fijoacLabel.setText(resourceMap.getString("fijoacLabel.text")); // NOI18N
        fijoacLabel.setName("fijoacLabel"); // NOI18N

        amountM3HotWaterField.setName("amountM3HotWaterField"); // NOI18N

        fijoacField.setName("fijoacField"); // NOI18N

        billPerBlocksCheck.setText(resourceMap.getString("billPerBlocksCheck.text")); // NOI18N
        billPerBlocksCheck.setName("billPerBlocksCheck"); // NOI18N

        ratePersonalizedCheck.setText(resourceMap.getString("ratePersonalizedCheck.text")); // NOI18N
        ratePersonalizedCheck.setName("ratePersonalizedCheck"); // NOI18N

        rateIdComboBox.setName("rateIdComboBox"); // NOI18N

        jComboBoxBinding = org.jdesktop.swingbinding.SwingBindings.createJComboBoxBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, rateList, rateIdComboBox);
        bindingGroup.addBinding(jComboBoxBinding);

        javax.swing.GroupLayout ratePanelLayout = new javax.swing.GroupLayout(ratePanel);
        ratePanel.setLayout(ratePanelLayout);
        ratePanelLayout.setHorizontalGroup(
            ratePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ratePanelLayout.createSequentialGroup()
                .addGroup(ratePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(billPerBlocksCheck, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(ratePanelLayout.createSequentialGroup()
                        .addGroup(ratePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(amountM3ColdWaterLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cuotacanalLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(ratePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cuotacanalField, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
                            .addComponent(amountM3ColdWaterField, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(ratePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(ratePanelLayout.createSequentialGroup()
                                .addComponent(amountM3HotWaterLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(amountM3HotWaterField, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(ratePanelLayout.createSequentialGroup()
                                .addComponent(fijoacLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(fijoacField, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(ratePanelLayout.createSequentialGroup()
                        .addComponent(ratePersonalizedCheck, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(rateIdComboBox, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(116, Short.MAX_VALUE))
        );
        ratePanelLayout.setVerticalGroup(
            ratePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ratePanelLayout.createSequentialGroup()
                .addComponent(billPerBlocksCheck, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(ratePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ratePersonalizedCheck, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rateIdComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(ratePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(ratePanelLayout.createSequentialGroup()
                        .addComponent(amountM3ColdWaterLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cuotacanalLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(ratePanelLayout.createSequentialGroup()
                        .addGroup(ratePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(amountM3ColdWaterField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(amountM3HotWaterLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(amountM3HotWaterField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(ratePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cuotacanalField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(fijoacLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(fijoacField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 12, 0);
        details2Panel.add(ratePanel, gridBagConstraints);

        left2Filler.setName("left2Filler"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridheight = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        details2Panel.add(left2Filler, gridBagConstraints);

        right2Filler.setName("right2Filler"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridheight = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        details2Panel.add(right2Filler, gridBagConstraints);

        severalDataSection.setName("severalDataSection"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        details2Panel.add(severalDataSection, gridBagConstraints);

        severalDataPanel.setMinimumSize(new java.awt.Dimension(0, 100));
        severalDataPanel.setName("severalDataPanel"); // NOI18N

        hidroLabel2.setText(resourceMap.getString("hidroLabel2.text")); // NOI18N
        hidroLabel2.setName("hidroLabel2"); // NOI18N

        hidroIntegerField1.setText(resourceMap.getString("hidroIntegerField1.text")); // NOI18N
        hidroIntegerField1.setName("hidroIntegerField1"); // NOI18N

        hidroLabel3.setText(resourceMap.getString("hidroLabel3.text")); // NOI18N
        hidroLabel3.setName("hidroLabel3"); // NOI18N

        hidroIntegerField2.setName("hidroIntegerField2"); // NOI18N

        hidroLabel4.setText(resourceMap.getString("hidroLabel4.text")); // NOI18N
        hidroLabel4.setName("hidroLabel4"); // NOI18N

        hidroIntegerField3.setName("hidroIntegerField3"); // NOI18N

        hidroLabel5.setText(resourceMap.getString("hidroLabel5.text")); // NOI18N
        hidroLabel5.setName("hidroLabel5"); // NOI18N

        hidroIntegerField5.setName("hidroIntegerField5"); // NOI18N

        hidroLabel6.setText(resourceMap.getString("hidroLabel6.text")); // NOI18N
        hidroLabel6.setName("hidroLabel6"); // NOI18N

        hidroIntegerField6.setName("hidroIntegerField6"); // NOI18N

        hidroLabel7.setText(resourceMap.getString("hidroLabel7.text")); // NOI18N
        hidroLabel7.setName("hidroLabel7"); // NOI18N

        hidroLabel8.setText(resourceMap.getString("hidroLabel8.text")); // NOI18N
        hidroLabel8.setName("hidroLabel8"); // NOI18N

        hidroCheckBox1.setText(resourceMap.getString("hidroCheckBox1.text")); // NOI18N
        hidroCheckBox1.setName("hidroCheckBox1"); // NOI18N

        hidroFloatField1.setText(resourceMap.getString("hidroFloatField1.text")); // NOI18N
        hidroFloatField1.setName("hidroFloatField1"); // NOI18N

        hidroFloatField2.setText(resourceMap.getString("hidroFloatField2.text")); // NOI18N
        hidroFloatField2.setName("hidroFloatField2"); // NOI18N

        javax.swing.GroupLayout severalDataPanelLayout = new javax.swing.GroupLayout(severalDataPanel);
        severalDataPanel.setLayout(severalDataPanelLayout);
        severalDataPanelLayout.setHorizontalGroup(
            severalDataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(severalDataPanelLayout.createSequentialGroup()
                .addGroup(severalDataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(hidroLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(hidroLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(hidroLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(hidroLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(severalDataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(hidroIntegerField1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(hidroIntegerField2, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(hidroIntegerField3, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(hidroIntegerField5, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(severalDataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(severalDataPanelLayout.createSequentialGroup()
                        .addComponent(hidroLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(hidroIntegerField6, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(hidroCheckBox1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(severalDataPanelLayout.createSequentialGroup()
                        .addGroup(severalDataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(hidroLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(hidroLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(severalDataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(hidroFloatField2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(hidroFloatField1, javax.swing.GroupLayout.DEFAULT_SIZE, 77, Short.MAX_VALUE))))
                .addContainerGap(177, Short.MAX_VALUE))
        );
        severalDataPanelLayout.setVerticalGroup(
            severalDataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(severalDataPanelLayout.createSequentialGroup()
                .addGroup(severalDataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(hidroLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(hidroIntegerField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(hidroLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(hidroIntegerField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(severalDataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(hidroLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(hidroIntegerField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(hidroCheckBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(severalDataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(hidroLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(hidroIntegerField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(hidroLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(hidroFloatField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(severalDataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(hidroLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(hidroIntegerField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(hidroLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(hidroFloatField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        details2Panel.add(severalDataPanel, gridBagConstraints);

        observationsSection.setName("observationsSection"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        details2Panel.add(observationsSection, gridBagConstraints);

        observationsPanel.setMinimumSize(new java.awt.Dimension(0, 120));
        observationsPanel.setName("observationsPanel"); // NOI18N
        observationsPanel.setPreferredSize(new java.awt.Dimension(0, 110));
        observationsPanel.setLayout(new java.awt.GridBagLayout());

        readerObservationsScrollPane.setBorder(null);
        readerObservationsScrollPane.setName("readerObservationsScrollPane"); // NOI18N

        readerObservationsField.setColumns(20);
        readerObservationsField.setName("readerObservationsField"); // NOI18N
        readerObservationsScrollPane.setViewportView(readerObservationsField);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 488;
        gridBagConstraints.ipady = 28;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        observationsPanel.add(readerObservationsScrollPane, gridBagConstraints);

        observationsScrollPane.setBorder(null);
        observationsScrollPane.setName("observationsScrollPane"); // NOI18N

        observationsField.setColumns(20);
        observationsField.setName("observationsField"); // NOI18N
        observationsScrollPane.setViewportView(observationsField);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 488;
        gridBagConstraints.ipady = 28;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        observationsPanel.add(observationsScrollPane, gridBagConstraints);

        obs2Label.setText(resourceMap.getString("obs2Label.text")); // NOI18N
        obs2Label.setName("obs2Label"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 0, 0);
        observationsPanel.add(obs2Label, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 0, 0);
        details2Panel.add(observationsPanel, gridBagConstraints);

        bottom2Filler.setName("bottom2Filler"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.weighty = 1.0;
        details2Panel.add(bottom2Filler, gridBagConstraints);

        mainPanel.add(details2Panel, "details2Panel");

        add(mainPanel, java.awt.BorderLayout.CENTER);

        bindingGroup.bind();
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private hidrocon.custom.field.HidroTextField addressField;
    private hidrocon.custom.label.HidroLabel addressLabel;
    private hidrocon.custom.field.HidroIntegerField administratorIdField;
    private hidrocon.custom.label.HidroLabel administratorLabel;
    private hidrocon.custom.field.HidroTextField administratorNameField;
    private hidrocon.custom.button.HidroSearchButton administratorSearchButton;
    private hidrocon.custom.field.HidroFloatField amountM3ColdWaterField;
    private hidrocon.custom.label.HidroLabel amountM3ColdWaterLabel;
    private hidrocon.custom.field.HidroFloatField amountM3HotWaterField;
    private hidrocon.custom.label.HidroLabel amountM3HotWaterLabel;
    private hidrocon.custom.field.HidroCheckBox billPerBlocksCheck;
    private javax.swing.Box.Filler bottom2Filler;
    private hidrocon.custom.field.HidroTextField buildingCodeField;
    private hidrocon.custom.label.HidroLabel buildingCodeLabel;
    private hidrocon.custom.panel.HidroPanel contactPanel;
    private hidrocon.custom.field.HidroTextField contactPhoneNumber2Field;
    private hidrocon.custom.field.HidroTextField contactPhoneNumberField;
    private hidrocon.custom.panel.HidroSectionPanel contactSection;
    private hidrocon.custom.field.HidroFloatField cuotacanalField;
    private hidrocon.custom.label.HidroLabel cuotacanalLabel;
    private hidrocon.custom.panel.HidroPanel databankPanel;
    private hidrocon.custom.panel.HidroSectionPanel databankSection;
    private hidrocon.custom.panel.HidroPanel details1Panel;
    private hidrocon.custom.panel.HidroPanel details2Panel;
    private hidrocon.custom.panel.HidroPanel detailsPanel;
    private hidrocon.custom.panel.HidroSectionPanel detailsSection;
    private hidrocon.custom.field.HidroComboBox estimateReadingTypeComboBox;
    private hidrocon.custom.label.HidroLabel estimateReadingTypeLabel;
    private hidrocon.custom.field.HidroTextField fechinicioField;
    private hidrocon.custom.label.HidroLabel fechinicioLabel;
    private hidrocon.custom.field.HidroFloatField fijoacField;
    private hidrocon.custom.label.HidroLabel fijoacLabel;
    private javax.swing.Box.Filler filler1;
    private javax.swing.Box.Filler filler2;
    private javax.swing.Box.Filler filler3;
    private javax.swing.Box.Filler filler4;
    private hidrocon.custom.field.HidroCheckBox hidroCheckBox1;
    private hidrocon.custom.field.HidroFloatField hidroFloatField1;
    private hidrocon.custom.field.HidroFloatField hidroFloatField2;
    private hidrocon.custom.field.HidroIntegerField hidroIntegerField1;
    private hidrocon.custom.field.HidroIntegerField hidroIntegerField2;
    private hidrocon.custom.field.HidroIntegerField hidroIntegerField3;
    private hidrocon.custom.field.HidroIntegerField hidroIntegerField4;
    private hidrocon.custom.field.HidroIntegerField hidroIntegerField5;
    private hidrocon.custom.field.HidroIntegerField hidroIntegerField6;
    private hidrocon.custom.label.HidroLabel hidroLabel2;
    private hidrocon.custom.label.HidroLabel hidroLabel3;
    private hidrocon.custom.label.HidroLabel hidroLabel4;
    private hidrocon.custom.label.HidroLabel hidroLabel5;
    private hidrocon.custom.label.HidroLabel hidroLabel6;
    private hidrocon.custom.label.HidroLabel hidroLabel7;
    private hidrocon.custom.label.HidroLabel hidroLabel8;
    private hidrocon.custom.panel.HidroPanel hidroPanel1;
    private hidrocon.custom.field.HidroTextField hidroconBankAccountField;
    private hidrocon.custom.label.HidroXSLabel hidroconBankAccountLabel;
    private hidrocon.custom.field.HidroTextField hidroconBankDCField;
    private hidrocon.custom.label.HidroXSLabel hidroconBankDCLabel;
    private hidrocon.custom.field.HidroTextField hidroconBankEntityField;
    private hidrocon.custom.label.HidroXSLabel hidroconBankEntityLabel;
    private hidrocon.custom.field.HidroTextField hidroconBankIBANField;
    private hidrocon.custom.label.HidroXSLabel hidroconBankIBANLabel;
    private hidrocon.custom.label.HidroLabel hidroconBankLabel;
    private hidrocon.custom.field.HidroTextField hidroconBankOfficeField;
    private hidrocon.custom.label.HidroXSLabel hidroconBankOfficeLabel;
    private hidrocon.custom.label.HidroLabel jLabel2;
    private hidrocon.custom.label.HidroLabel jLabel3;
    private hidrocon.custom.label.HidroLabel laLabel;
    private hidrocon.custom.field.HidroIntegerField laTextField;
    private hidrocon.custom.label.HidroLabel lbLabel;
    private hidrocon.custom.field.HidroIntegerField lbTextField;
    private javax.swing.Box.Filler left1Filler;
    private javax.swing.Box.Filler left2Filler;
    private hidrocon.custom.label.HidroLabel lgLabel;
    private hidrocon.custom.field.HidroTextField lgTextField;
    private hidrocon.custom.label.HidroLabel lpLabel;
    private hidrocon.custom.field.HidroIntegerField lpTextField;
    private hidrocon.custom.label.HidroLabel lsLabel;
    private hidrocon.custom.field.HidroIntegerField lsTextField;
    private hidrocon.custom.panel.HidroMainPanel mainPanel;
    private hidrocon.custom.field.HidroIntegerField modelField;
    private hidrocon.custom.label.HidroLabel modelLabel;
    private hidrocon.custom.field.HidroTextField nifField;
    private hidrocon.custom.label.HidroLabel nifLabel;
    private hidrocon.custom.field.HidroTextField nombcontacField;
    private hidrocon.custom.label.HidroLabel nombcontacLabel;
    private hidrocon.custom.field.HidroTextField noticeAddressField;
    private hidrocon.custom.field.HidroTextField noticeNameField;
    private hidrocon.custom.field.HidroTextField noticeNumberField;
    private hidrocon.custom.field.HidroTextField noticeZipCodeField;
    private hidrocon.custom.field.HidroIntegerField numberCWMField;
    private hidrocon.custom.field.HidroIntegerField numberCWMPerHomeField;
    private hidrocon.custom.label.HidroLabel numberCWMPerHomeLabel;
    private hidrocon.custom.field.HidroIntegerField numberHWMField;
    private hidrocon.custom.field.HidroIntegerField numberHWMPerField;
    private hidrocon.custom.label.HidroLabel numberHWMPerHomeLabel;
    private hidrocon.custom.label.HidroLabel numberMetersColdWaterLabel;
    private hidrocon.custom.label.HidroLabel numberMetersHotWaterLabel;
    private hidrocon.custom.field.HidroIntegerField numberReadingsPerYearField;
    private hidrocon.custom.label.HidroLabel numberReadingsPerYearLabel;
    private hidrocon.custom.label.HidroLabel obs2Label;
    private hidrocon.custom.field.HidroTextArea observationsField;
    private hidrocon.custom.panel.HidroPanel observationsPanel;
    private javax.swing.JScrollPane observationsScrollPane;
    private hidrocon.custom.panel.HidroSectionPanel observationsSection;
    private hidrocon.custom.label.HidroLabel phoneNumberLabel;
    private hidrocon.custom.panel.HidroPanel printPanel;
    private hidrocon.custom.field.HidroComboBox rateIdComboBox;
    private java.util.List<Rate> rateList;
    private hidrocon.custom.panel.HidroPanel ratePanel;
    private hidrocon.custom.field.HidroCheckBox ratePersonalizedCheck;
    private hidrocon.custom.panel.HidroSectionPanel rateSection;
    private hidrocon.custom.field.HidroTextArea readerObservationsField;
    private javax.swing.JScrollPane readerObservationsScrollPane;
    private hidrocon.custom.field.HidroTextField relatedBankAccountField;
    private hidrocon.custom.label.HidroXSLabel relatedBankAccountLabel;
    private hidrocon.custom.field.HidroTextField relatedBankCCCDetailsField;
    private hidrocon.custom.label.HidroLabel relatedBankCCCDetailsLabel;
    private hidrocon.custom.field.HidroTextField relatedBankDCField;
    private hidrocon.custom.label.HidroXSLabel relatedBankDCLabel;
    private hidrocon.custom.field.HidroTextField relatedBankEntityField;
    private hidrocon.custom.label.HidroXSLabel relatedBankEntityLabel;
    private hidrocon.custom.field.HidroTextField relatedBankIBANField;
    private hidrocon.custom.label.HidroXSLabel relatedBankIBANLabel;
    private hidrocon.custom.label.HidroLabel relatedBankLabel;
    private hidrocon.custom.field.HidroTextField relatedBankOfficeField;
    private hidrocon.custom.label.HidroXSLabel relatedBankOfficeLabel;
    private javax.swing.Box.Filler right1Filler;
    private javax.swing.Box.Filler right2Filler;
    private java.util.List<RouteBuildingDateView> routeBuildingDateList;
    private javax.swing.JScrollPane routeBuildingDateScrollPane;
    private hidrocon.custom.table.HidroDetailsTable routeBuildingDateTable;
    private hidrocon.custom.field.HidroCheckBox routePersonalizedCheckBox;
    private hidrocon.custom.panel.HidroPanel routemapPanel;
    private hidrocon.custom.panel.HidroSectionPanel routemapSection;
    private hidrocon.custom.panel.HidroPanel severalDataPanel;
    private hidrocon.custom.panel.HidroSectionPanel severalDataSection;
    private hidrocon.custom.field.HidroIntegerField supportExternalIDField;
    private hidrocon.custom.label.HidroLabel supportExternalIDLabel;
    private hidrocon.custom.field.HidroComboBox supportTypeCodeComboBox;
    private hidrocon.custom.label.HidroLabel supportTypeCodeLabel;
    private hidrocon.custom.panel.HidroTopPanel topPanel;
    private hidrocon.custom.field.HidroTextField typeNameField;
    private hidrocon.custom.label.HidroLabel typeNameLabel;
    private hidrocon.custom.field.HidroTextField zipCodeField;
    private hidrocon.custom.label.HidroLabel zipCodeLabel;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables

    
    /**
     * IEntityManager methods implementation - BEGIN
     */
    
    public void setMode(int mode) {
        this.mode = mode;
        if (this.mode == Constant.VIEW_MODE_CREATION) {
            enableAllFields(true);
            showCreationModeButtons();
        }
        else if (this.mode == Constant.VIEW_MODE_READONLY) {
            enableAllFields(false);
            showReadonlyModeButtons();
        }   
        else if (this.mode == Constant.VIEW_MODE_UPDATE) {
            enableAllFields(true);
            buildingCodeField.requestFocusInWindow();
        }        
        else if (this.mode == Constant.ENTITY_MANAGEMENT_MODE_SUMMARY) {
            enableAllFields(false);
            showSummaryModeButtons();
        }
    }
    
    private void showCreationModeButtons() {
        editButton.setVisible(false);
        saveButton.setVisible(true);
        administratorButton.setVisible(false);
        rateButton.setVisible(false);
    }
    
    private void showSummaryModeButtons() {
        editButton.setVisible(false);
        saveButton.setVisible(false);
        administratorButton.setVisible(true);
        rateButton.setVisible(true);
    }
    
    private void showReadonlyModeButtons() {
        editButton.setVisible(true);
        saveButton.setVisible(true);
        administratorButton.setVisible(true);
        rateButton.setVisible(true);
    }
    
    /**
     * IEntityManager methods implementation - END
     */    

    /**
     * @return the routeBuildingDateList
     */
    public java.util.List<RouteBuildingDateView> getRouteBuildingDateList() {
        return null; //routeBuildingDateList;
    }

    /**
     * @param routeBuildingDateList the routeBuildingDateList to set
     */
    public void setRouteBuildingDateList(java.util.List<RouteBuildingDateView> routeBuildingDateList) {
        //this.routeBuildingDateList = routeBuildingDateList;
    }

    public void addController(HidroController controller) {
        arrowLeftButton.setActionCommand(ActionKey.BUILDING_DETAILS_SHOW_PREVIOUS_TAB);
	arrowLeftButton.addActionListener(controller);
        arrowRightButton.setActionCommand(ActionKey.BUILDING_DETAILS_SHOW_NEXT_TAB);
        arrowRightButton.addActionListener(controller);        
	rateButton.setActionCommand(ActionKey.BUILDING_DETAILS_VIEW_RATE);
        rateButton.addActionListener(controller);
        administratorButton.setActionCommand(ActionKey.BUILDING_DETAILS_VIEW_ADMINISTRATOR);
	administratorButton.addActionListener(controller);
        editButton.setActionCommand(ActionKey.BUILDING_DETAILS_EDIT);
	editButton.addActionListener(controller);        
        saveButton.setActionCommand(ActionKey.BUILDING_DETAILS_SAVE);
	saveButton.addActionListener(controller);        
        administratorSearchButton.setActionCommand(ActionKey.BUILDING_DETAILS_SELECT_ADMINISTRATOR);
	administratorSearchButton.addActionListener(controller);        
        calendarNewButton.setActionCommand(ActionKey.BUILDING_DETAILS_CREATE_ROUTE_BUILDING_DATE);
	calendarNewButton.addActionListener(controller);        
        calendarDeleteButton.setActionCommand(ActionKey.BUILDING_DETAILS_DELETE_ROUTE_BUILDING_DATE);
	calendarDeleteButton.addActionListener(controller);                
        exitButton.setActionCommand(ActionKey.BUILDING_DETAILS_CLOSE);
        exitButton.addActionListener(controller);        
        
        routeBuildingDateTable.addKeyListener(controller);
        routeBuildingDateTable.addMouseListener(controller);
    }
    
    public void loadAdministrator(Administrator administrator) {
        if (administrator != null) {
            administratorIdField.setValue(administrator.getAdministratorId());
            administratorNameField.setText(administrator.getAdministratorName());
        }
    }
    
    public JPanel getMainPanel() {
        return mainPanel;
    }
    
    public JTable getRouteBuildingDateTable() {
        return routeBuildingDateTable;
    }

    public void setRateList(List list) {
        rateList.clear();
        rateList.addAll(list);
    }
}
