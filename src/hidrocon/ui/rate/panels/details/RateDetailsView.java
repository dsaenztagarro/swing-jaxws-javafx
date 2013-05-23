/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * RateDetailsView.java
 *
 * Created on 16-dic-2011, 22:45:14
 */
package hidrocon.ui.rate.panels.details;

import hidrocon.HidroconView;
import hidrocon.core.utils.ActionKey;
import hidrocon.custom.Constant;
import hidrocon.custom.button.toolbar.HidroEditButton;
import hidrocon.custom.button.toolbar.HidroExitButton;
import hidrocon.custom.button.toolbar.HidroSaveButton;
import hidrocon.custom.legend.HidroRateLegend;
import hidrocon.custom.legend.HidroSummerRateLegend;
import hidrocon.custom.legend.HidroWinterRateLegend;
import hidrocon.webservice.Rate;
import java.awt.event.ActionListener;
import javax.swing.JPanel;

/**
 *
 * @author David Sáenz Tagarro
 */
public class RateDetailsView extends javax.swing.JPanel {

    private int mode;
    
    private HidroEditButton editButton;
    private HidroSaveButton saveButton;
    private HidroExitButton exitButton;
    
    /** Creates new form RateDetailsView */
    public RateDetailsView() {
        initComponents();
        initTopPanel();
        customizeComponents();
    }

    protected void customizeComponents() {
        //Sections:
        winterRateSection.setImageIcon(new HidroWinterRateLegend());
        summerRateSection.setImageIcon(new HidroSummerRateLegend());
        detailsSection.setImageIcon(new HidroRateLegend());                        
    }
    
	protected void initTopPanel() {
		org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(hidrocon.HidroconApp.class).getContext().getResourceMap(HidroconView.class);
		topPanel.setTitle("  " + resourceMap.getString("rate.details.toppanel.title"));
		
		editButton = new HidroEditButton();
		saveButton = new HidroSaveButton();
		exitButton = new HidroExitButton();
                 		
		editButton.setToolTipText(resourceMap.getString("rate.details.toolbar.editbutton.tooltip"));
		saveButton.setToolTipText(resourceMap.getString("rate.details.toolbar.savebutton.tooltip"));
		exitButton.setToolTipText(resourceMap.getString("rate.details.toolbar.exitbutton.tooltip"));
        
		topPanel.addButton(editButton);
		topPanel.addButton(saveButton);
        topPanel.addButton(exitButton);
	}
    
    protected void enableAllFields(boolean enabled) {
        rateNameField.setEditable(enabled);
        isDefaultCheck.setEnabled(enabled);
        
        //Bloques 1-4 Aduccion Invierno
        bloque1AduccionInviernoField.setEditable(enabled);
        bloque2AduccionInviernoField.setEditable(enabled);
        bloque3AduccionInviernoField.setEditable(enabled);
        bloque4AduccionInviernoField.setEditable(enabled);
        //Bloques 1-4 Distribucion Invierno
        bloque1DistribucionInviernoField.setEditable(enabled);
        bloque2DistribucionInviernoField.setEditable(enabled);
        bloque3DistribucionInviernoField.setEditable(enabled);
        bloque4DistribucionInviernoField.setEditable(enabled);
        //Bloques 1-4 Saneamiento Invierno
        bloque1SaneamientoInviernoField.setEditable(enabled);
        bloque2SaneamientoInviernoField.setEditable(enabled);
        bloque3SaneamientoInviernoField.setEditable(enabled);
        bloque4SaneamientoInviernoField.setEditable(enabled);
        //Bloques 1-4 Depuracion Invierno
        bloque1DepuracionInviernoField.setEditable(enabled);
        bloque2DepuracionInviernoField.setEditable(enabled);
        bloque3DepuracionInviernoField.setEditable(enabled);
        bloque4DepuracionInviernoField.setEditable(enabled);
        
        //Bloques 1-4 Aduccion Verano
        bloque1AduccionVeranoField.setEditable(enabled);
        bloque2AduccionVeranoField.setEditable(enabled);
        bloque3AduccionVeranoField.setEditable(enabled);
        bloque4AduccionVeranoField.setEditable(enabled);
        //Bloques 1-4 Distribucion Verano
        bloque1DistribucionVeranoField.setEditable(enabled);
        bloque2DistribucionVeranoField.setEditable(enabled);
        bloque3DistribucionVeranoField.setEditable(enabled);
        bloque4DistribucionVeranoField.setEditable(enabled);
        //Bloques 1-4 Saneamiento Verano
        bloque1SaneamientoVeranoField.setEditable(enabled);
        bloque2SaneamientoVeranoField.setEditable(enabled);
        bloque3SaneamientoVeranoField.setEditable(enabled);
        bloque4SaneamientoVeranoField.setEditable(enabled);
        //Bloques 1-4 Depuracion Verano
        bloque1DepuracionVeranoField.setEditable(enabled);
        bloque2DepuracionVeranoField.setEditable(enabled);
        bloque3DepuracionVeranoField.setEditable(enabled);
        bloque4DepuracionVeranoField.setEditable(enabled);
        
        ivaCanalField.setEditable(enabled);
        ivaHidroconField.setEditable(enabled);
        percentAduccionField.setEditable(enabled);
        percentAlcantarilladoField.setEditable(enabled);
        percentDepuracionField.setEditable(enabled);
        percentDistribucionField.setEditable(enabled);
        
        numRecibosField.setEditable(enabled);
        contadorCalienteField.setEditable(enabled);
        contadorFriaField.setEditable(enabled);
        
        bloque1EurM3InviernoField.setEditable(false);
        bloque2EurM3InviernoField.setEditable(false);
        bloque3EurM3InviernoField.setEditable(false);
        bloque4EurM3InviernoField.setEditable(false);
        
        bloque1EurM3VeranoField.setEditable(false);
        bloque2EurM3VeranoField.setEditable(false);
        bloque3EurM3VeranoField.setEditable(false);
        bloque4EurM3VeranoField.setEditable(false);
        
        if (enabled) {
            bloque1EurM3InviernoField.setText("");
            bloque2EurM3InviernoField.setText("");
            bloque3EurM3InviernoField.setText("");
            bloque4EurM3InviernoField.setText("");
            
            bloque1EurM3VeranoField.setText("");
            bloque2EurM3VeranoField.setText("");
            bloque3EurM3VeranoField.setText("");
            bloque4EurM3VeranoField.setText("");            
        }
    }    
    
    private void showEurM3plusIVA(Rate rate) {
        //Winter rate
        if (false) {
            double bloque1EurM3 = ((rate.getIvaCuotaCanal()/100)+1) * 
                                        rate.getBloque1AduccionInvierno() +
                                        rate.getBloque1DistribucionInvierno() + 
                                        rate.getBloque1SaneamientoInvierno();
            double bloque2EurM3 = ((rate.getIvaCuotaCanal()/100)+1) * 
                                    rate.getBloque2AduccionInvierno() +
                                    rate.getBloque2DistribucionInvierno() + 
                                    rate.getBloque2SaneamientoInvierno();
            double bloque3EurM3 = ((rate.getIvaCuotaCanal()/100)+1) * 
                                    rate.getBloque3AduccionInvierno() +
                                    rate.getBloque3DistribucionInvierno() + 
                                    rate.getBloque3SaneamientoInvierno();
            double bloque4EurM3 = ((rate.getIvaCuotaCanal()/100)+1) * 
                                    rate.getBloque4AduccionInvierno() +
                                    rate.getBloque4DistribucionInvierno() + 
                                    rate.getBloque4SaneamientoInvierno();

            bloque1EurM3InviernoField.setValue(Double.valueOf(bloque1EurM3));
            bloque2EurM3InviernoField.setValue(Double.valueOf(bloque2EurM3));
            bloque3EurM3InviernoField.setValue(Double.valueOf(bloque3EurM3));
            bloque4EurM3InviernoField.setValue(Double.valueOf(bloque4EurM3)); 

            //Summer rate
            double bloque1EurM3Verano = ((rate.getIvaCuotaCanal()/100)+1) * 
                                        rate.getBloque1AduccionVerano() +
                                        rate.getBloque1DistribucionVerano() + 
                                        rate.getBloque1SaneamientoVerano();
            double bloque2EurM3Verano = ((rate.getIvaCuotaCanal()/100)+1) * 
                                    rate.getBloque2AduccionVerano() +
                                    rate.getBloque2DistribucionVerano() + 
                                    rate.getBloque2SaneamientoVerano();
            double bloque3EurM3Verano = ((rate.getIvaCuotaCanal()/100)+1) * 
                                    rate.getBloque3AduccionVerano() +
                                    rate.getBloque3DistribucionVerano() + 
                                    rate.getBloque3SaneamientoVerano();
            double bloque4EurM3Verano = ((rate.getIvaCuotaCanal()/100)+1) * 
                                    rate.getBloque4AduccionVerano() +
                                    rate.getBloque4DistribucionVerano() + 
                                    rate.getBloque4SaneamientoVerano();

            bloque1EurM3VeranoField.setValue(Double.valueOf(bloque1EurM3Verano));
            bloque2EurM3VeranoField.setValue(Double.valueOf(bloque2EurM3Verano));
            bloque3EurM3VeranoField.setValue(Double.valueOf(bloque3EurM3Verano));
            bloque4EurM3VeranoField.setValue(Double.valueOf(bloque4EurM3Verano));         
        }
    }     
    
    public void writeData(Rate rate) {
        rateNameField.setText(rate.getRateName());
        //isDefaultCheck.setVEnabled(enabled);
        
        //Bloques 1-4 Aduccion Invierno
        bloque1AduccionInviernoField.setValue(rate.getBloque1AduccionInvierno());
        bloque2AduccionInviernoField.setValue(rate.getBloque2AduccionInvierno());
        bloque3AduccionInviernoField.setValue(rate.getBloque3AduccionInvierno());
        bloque4AduccionInviernoField.setValue(rate.getBloque4AduccionInvierno());
        //Bloques 1-4 Distribucion Invierno
        bloque1DistribucionInviernoField.setValue(rate.getBloque1DistribucionInvierno());
        bloque2DistribucionInviernoField.setValue(rate.getBloque2DistribucionInvierno());
        bloque3DistribucionInviernoField.setValue(rate.getBloque3DistribucionInvierno());
        bloque4DistribucionInviernoField.setValue(rate.getBloque4DistribucionInvierno());
        //Bloques 1-4 Saneamiento Invierno
        bloque1SaneamientoInviernoField.setValue(rate.getBloque1SaneamientoInvierno());
        bloque2SaneamientoInviernoField.setValue(rate.getBloque2SaneamientoInvierno());
        bloque3SaneamientoInviernoField.setValue(rate.getBloque3SaneamientoInvierno());
        bloque4SaneamientoInviernoField.setValue(rate.getBloque4SaneamientoInvierno());
        //Bloques 1-4 Depuracion Invierno
        bloque1DepuracionInviernoField.setValue(rate.getBloque1DepuracionInvierno());
        bloque2DepuracionInviernoField.setValue(rate.getBloque2DepuracionInvierno());
        bloque3DepuracionInviernoField.setValue(rate.getBloque3DepuracionInvierno());
        bloque4DepuracionInviernoField.setValue(rate.getBloque4DepuracionInvierno());
        
        //Bloques 1-4 Aduccion Verano
        bloque1AduccionVeranoField.setValue(rate.getBloque1AduccionVerano());
        bloque2AduccionVeranoField.setValue(rate.getBloque2AduccionVerano());
        bloque3AduccionVeranoField.setValue(rate.getBloque3AduccionVerano());
        bloque4AduccionVeranoField.setValue(rate.getBloque4AduccionVerano());
        //Bloques 1-4 Distribucion Verano
        bloque1DistribucionVeranoField.setValue(rate.getBloque1DistribucionVerano());
        bloque2DistribucionVeranoField.setValue(rate.getBloque2DistribucionVerano());
        bloque3DistribucionVeranoField.setValue(rate.getBloque3DistribucionVerano());
        bloque4DistribucionVeranoField.setValue(rate.getBloque4DistribucionVerano());
        //Bloques 1-4 Saneamiento Verano
        bloque1SaneamientoVeranoField.setValue(rate.getBloque1SaneamientoVerano());
        bloque2SaneamientoVeranoField.setValue(rate.getBloque2SaneamientoVerano());
        bloque3SaneamientoVeranoField.setValue(rate.getBloque3SaneamientoVerano());
        bloque4SaneamientoVeranoField.setValue(rate.getBloque4SaneamientoVerano());
        //Bloques 1-4 Depuracion Verano
        bloque1DepuracionVeranoField.setValue(rate.getBloque1DepuracionVerano());
        bloque2DepuracionVeranoField.setValue(rate.getBloque2DepuracionVerano());
        bloque3DepuracionVeranoField.setValue(rate.getBloque3DepuracionVerano());
        bloque4DepuracionVeranoField.setValue(rate.getBloque4DepuracionVerano());
        
        ivaCanalField.setValue(rate.getIvaCuotaCanal());
        ivaHidroconField.setValue(rate.getIvaHidrocon());
        percentAduccionField.setValue(rate.getPercentAduccion());
        percentAlcantarilladoField.setValue(rate.getPercentAlcantarillado());
        percentDepuracionField.setValue(rate.getPercentDepuracion());
        percentDistribucionField.setValue(rate.getPercentDistribucion());
        
        numRecibosField.setValue(rate.getRecibohi());
        contadorCalienteField.setValue(rate.getDinconac());
        contadorFriaField.setValue(rate.getDinconaf());
        
        showEurM3plusIVA(rate);        
    }
    
    public void readData(Rate rate) {
        rate.setRateName(rateNameField.getText());
        //isDefaultCheck.setVEnabled(enabled);
        
        //Bloques 1-4 Aduccion Invierno
        rate.setBloque1AduccionInvierno(bloque1AduccionInviernoField.getDoubleValue());
        rate.setBloque2AduccionInvierno(bloque2AduccionInviernoField.getDoubleValue());
        rate.setBloque3AduccionInvierno(bloque3AduccionInviernoField.getDoubleValue());
        rate.setBloque4AduccionInvierno(bloque4AduccionInviernoField.getDoubleValue());
        //Bloques 1-4 Distribucion Invierno
        rate.setBloque1DistribucionInvierno(bloque1DistribucionInviernoField.getDoubleValue());
        rate.setBloque2DistribucionInvierno(bloque2DistribucionInviernoField.getDoubleValue());
        rate.setBloque3DistribucionInvierno(bloque3DistribucionInviernoField.getDoubleValue());
        rate.setBloque4DistribucionInvierno(bloque4DistribucionInviernoField.getDoubleValue());
        //Bloques 1-4 Saneamiento Invierno
        rate.setBloque1SaneamientoInvierno(bloque1SaneamientoInviernoField.getDoubleValue());
        rate.setBloque2SaneamientoInvierno(bloque2SaneamientoInviernoField.getDoubleValue());
        rate.setBloque3SaneamientoInvierno(bloque3SaneamientoInviernoField.getDoubleValue());
        rate.setBloque4SaneamientoInvierno(bloque4SaneamientoInviernoField.getDoubleValue());
        //Bloques 1-4 Depuracion Invierno
        rate.setBloque1DepuracionInvierno(bloque1DepuracionInviernoField.getDoubleValue());
        rate.setBloque2DepuracionInvierno(bloque2DepuracionInviernoField.getDoubleValue());
        rate.setBloque3DepuracionInvierno(bloque3DepuracionInviernoField.getDoubleValue());
        rate.setBloque4DepuracionInvierno(bloque4DepuracionInviernoField.getDoubleValue());
        
        //Bloques 1-4 Aduccion Verano
        rate.setBloque1AduccionVerano(bloque1AduccionVeranoField.getDoubleValue());
        rate.setBloque2AduccionVerano(bloque2AduccionVeranoField.getDoubleValue());
        rate.setBloque3AduccionVerano(bloque3AduccionVeranoField.getDoubleValue());
        rate.setBloque4AduccionVerano(bloque4AduccionVeranoField.getDoubleValue());
        //Bloques 1-4 Distribucion Verano
        rate.setBloque1DistribucionVerano(bloque1DistribucionVeranoField.getDoubleValue());
        rate.setBloque2DistribucionVerano(bloque2DistribucionVeranoField.getDoubleValue());
        rate.setBloque3DistribucionVerano(bloque3DistribucionVeranoField.getDoubleValue());
        rate.setBloque4DistribucionVerano(bloque4DistribucionVeranoField.getDoubleValue());
        //Bloques 1-4 Saneamiento Verano
        rate.setBloque1SaneamientoVerano(bloque1SaneamientoVeranoField.getDoubleValue());
        rate.setBloque2SaneamientoVerano(bloque2SaneamientoVeranoField.getDoubleValue());
        rate.setBloque3SaneamientoVerano(bloque3SaneamientoVeranoField.getDoubleValue());
        rate.setBloque4SaneamientoVerano(bloque4SaneamientoVeranoField.getDoubleValue());
        //Bloques 1-4 Depuracion Verano
        rate.setBloque1DepuracionVerano(bloque1DepuracionVeranoField.getDoubleValue());
        rate.setBloque2DepuracionVerano(bloque2DepuracionVeranoField.getDoubleValue());
        rate.setBloque3DepuracionVerano(bloque3DepuracionVeranoField.getDoubleValue());
        rate.setBloque4DepuracionVerano(bloque4DepuracionVeranoField.getDoubleValue());
        
        rate.setIvaCuotaCanal(ivaCanalField.getValue());
        rate.setIvaHidrocon(ivaHidroconField.getValue());
        rate.setPercentAduccion(percentAduccionField.getDoubleValue());
        rate.setPercentAlcantarillado(percentAlcantarilladoField.getDoubleValue());
        rate.setPercentDepuracion(percentDepuracionField.getDoubleValue());
        rate.setPercentDistribucion(percentDistribucionField.getDoubleValue());
        
        //numRecibosField.setValue(rate.getRecibohi());
        //contadorCalienteField.setValue(rate.getDinconac());
        //contadorFriaField.setValue(rate.getDinconaf());
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
            rateNameField.requestFocusInWindow();
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
        rateNameField = new hidrocon.custom.field.HidroTextField();
        rateNameLabel = new hidrocon.custom.label.HidroLabel();
        isDefaultCheck = new hidrocon.custom.field.HidroCheckBox();
        winterRateSection = new hidrocon.custom.panel.HidroSectionPanel();
        winterRatePanel = new hidrocon.custom.panel.HidroPanel();
        bloque1InviernoLabel = new hidrocon.custom.label.HidroLabel();
        bloque2InviernoLabel = new hidrocon.custom.label.HidroLabel();
        bloque3InviernoLabel = new hidrocon.custom.label.HidroLabel();
        aduccionInviernoLabel = new hidrocon.custom.label.HidroLabel();
        bloque1AduccionInviernoField = new hidrocon.custom.field.HidroFloatField();
        bloque1DistribucionInviernoField = new hidrocon.custom.field.HidroFloatField();
        bloque1SaneamientoInviernoField = new hidrocon.custom.field.HidroFloatField();
        bloque1EurM3InviernoField = new hidrocon.custom.field.HidroFloatField();
        bloque1DepuracionInviernoField = new hidrocon.custom.field.HidroFloatField();
        bloque2AduccionInviernoField = new hidrocon.custom.field.HidroFloatField();
        bloque2DistribucionInviernoField = new hidrocon.custom.field.HidroFloatField();
        bloque2SaneamientoInviernoField = new hidrocon.custom.field.HidroFloatField();
        bloque2EurM3InviernoField = new hidrocon.custom.field.HidroFloatField();
        bloque2DepuracionInviernoField = new hidrocon.custom.field.HidroFloatField();
        bloque3AduccionInviernoField = new hidrocon.custom.field.HidroFloatField();
        bloque3DistribucionInviernoField = new hidrocon.custom.field.HidroFloatField();
        bloque3SaneamientoInviernoField = new hidrocon.custom.field.HidroFloatField();
        bloque3EurM3InviernoField = new hidrocon.custom.field.HidroFloatField();
        bloque3DepuracionInviernoField = new hidrocon.custom.field.HidroFloatField();
        bloque4AduccionInviernoField = new hidrocon.custom.field.HidroFloatField();
        bloque4DistribucionInviernoField = new hidrocon.custom.field.HidroFloatField();
        bloque4SaneamientoInviernoField = new hidrocon.custom.field.HidroFloatField();
        bloque4EurM3InviernoField = new hidrocon.custom.field.HidroFloatField();
        bloque4DepuracionInviernoField = new hidrocon.custom.field.HidroFloatField();
        bloque4InviernoLabel = new hidrocon.custom.label.HidroLabel();
        distribucionInviernoLabel = new hidrocon.custom.label.HidroLabel();
        saneamientoInviernoLabel = new hidrocon.custom.label.HidroLabel();
        eurM3InviernoLabel = new hidrocon.custom.label.HidroLabel();
        depuracionInviernoLabel = new hidrocon.custom.label.HidroLabel();
        summerRateSection = new hidrocon.custom.panel.HidroSectionPanel();
        summerRatePanel = new hidrocon.custom.panel.HidroPanel();
        bloque1VeranoLabel = new hidrocon.custom.label.HidroLabel();
        bloque2VeranoLabel = new hidrocon.custom.label.HidroLabel();
        bloque3VeranoLabel = new hidrocon.custom.label.HidroLabel();
        hidroLabel14 = new hidrocon.custom.label.HidroLabel();
        bloque1AduccionVeranoField = new hidrocon.custom.field.HidroFloatField();
        bloque1DistribucionVeranoField = new hidrocon.custom.field.HidroFloatField();
        bloque1SaneamientoVeranoField = new hidrocon.custom.field.HidroFloatField();
        bloque1EurM3VeranoField = new hidrocon.custom.field.HidroFloatField();
        bloque1DepuracionVeranoField = new hidrocon.custom.field.HidroFloatField();
        bloque2AduccionVeranoField = new hidrocon.custom.field.HidroFloatField();
        bloque2DistribucionVeranoField = new hidrocon.custom.field.HidroFloatField();
        bloque2SaneamientoVeranoField = new hidrocon.custom.field.HidroFloatField();
        bloque2EurM3VeranoField = new hidrocon.custom.field.HidroFloatField();
        bloque2DepuracionVeranoField = new hidrocon.custom.field.HidroFloatField();
        bloque3AduccionVeranoField = new hidrocon.custom.field.HidroFloatField();
        bloque3DistribucionVeranoField = new hidrocon.custom.field.HidroFloatField();
        bloque3SaneamientoVeranoField = new hidrocon.custom.field.HidroFloatField();
        bloque3EurM3VeranoField = new hidrocon.custom.field.HidroFloatField();
        bloque3DepuracionVeranoField = new hidrocon.custom.field.HidroFloatField();
        bloque4AduccionVeranoField = new hidrocon.custom.field.HidroFloatField();
        bloque4DistribucionVeranoField = new hidrocon.custom.field.HidroFloatField();
        bloque4SaneamientoVeranoField = new hidrocon.custom.field.HidroFloatField();
        bloque4EurM3VeranoField = new hidrocon.custom.field.HidroFloatField();
        bloque4DepuracionVeranoField = new hidrocon.custom.field.HidroFloatField();
        bloque4VeranoLabel = new hidrocon.custom.label.HidroLabel();
        hidroLabel16 = new hidrocon.custom.label.HidroLabel();
        hidroLabel17 = new hidrocon.custom.label.HidroLabel();
        hidroLabel18 = new hidrocon.custom.label.HidroLabel();
        hidroLabel19 = new hidrocon.custom.label.HidroLabel();
        detailsSection = new hidrocon.custom.panel.HidroSectionPanel();
        detailPanel = new hidrocon.custom.panel.HidroPanel();
        hidroLabel20 = new hidrocon.custom.label.HidroLabel();
        ivaCanalField = new hidrocon.custom.field.HidroIntegerField();
        hidroLabel21 = new hidrocon.custom.label.HidroLabel();
        ivaHidroconField = new hidrocon.custom.field.HidroIntegerField();
        percentAduccionLabel = new hidrocon.custom.label.HidroLabel();
        percentDistribucionLabel = new hidrocon.custom.label.HidroLabel();
        percentDepuracionLabel = new hidrocon.custom.label.HidroLabel();
        percentAlcantarilladoLabel = new hidrocon.custom.label.HidroLabel();
        percentAduccionField = new hidrocon.custom.field.HidroFloatField();
        percentDistribucionField = new hidrocon.custom.field.HidroFloatField();
        percentDepuracionField = new hidrocon.custom.field.HidroFloatField();
        percentAlcantarilladoField = new hidrocon.custom.field.HidroFloatField();
        numRecibosLabel = new hidrocon.custom.label.HidroLabel();
        contadorFriaLabel = new hidrocon.custom.label.HidroLabel();
        contadorCalienteLabel = new hidrocon.custom.label.HidroLabel();
        numRecibosField = new hidrocon.custom.field.HidroIntegerField();
        contadorFriaField = new hidrocon.custom.field.HidroFloatField();
        contadorCalienteField = new hidrocon.custom.field.HidroFloatField();
        bottomFiller = new javax.swing.Box.Filler(new java.awt.Dimension(0, 5), new java.awt.Dimension(0, 5), new java.awt.Dimension(32767, 5));

        setName("Form"); // NOI18N
        setLayout(new java.awt.BorderLayout());

        topPanel.setMaximumSize(new java.awt.Dimension(580, 35));
        topPanel.setName("topPanel"); // NOI18N
        add(topPanel, java.awt.BorderLayout.PAGE_START);

        mainPanel.setMaximumSize(new java.awt.Dimension(700, 500));
        mainPanel.setMinimumSize(new java.awt.Dimension(700, 500));
        mainPanel.setName("mainPanel"); // NOI18N
        mainPanel.setPreferredSize(new java.awt.Dimension(700, 500));
        mainPanel.setLayout(new java.awt.GridBagLayout());

        initPanel.setMinimumSize(new java.awt.Dimension(530, 25));
        initPanel.setName("initPanel"); // NOI18N

        rateNameField.setName("rateNameField"); // NOI18N

        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(hidrocon.HidroconApp.class).getContext().getResourceMap(RateDetailsView.class);
        rateNameLabel.setText(resourceMap.getString("rateNameLabel.text")); // NOI18N
        rateNameLabel.setName("rateNameLabel"); // NOI18N

        isDefaultCheck.setText(resourceMap.getString("isDefaultCheck.text")); // NOI18N
        isDefaultCheck.setName("isDefaultCheck"); // NOI18N

        javax.swing.GroupLayout initPanelLayout = new javax.swing.GroupLayout(initPanel);
        initPanel.setLayout(initPanelLayout);
        initPanelLayout.setHorizontalGroup(
            initPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(initPanelLayout.createSequentialGroup()
                .addComponent(rateNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rateNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(isDefaultCheck, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(123, Short.MAX_VALUE))
        );
        initPanelLayout.setVerticalGroup(
            initPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(initPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(rateNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(rateNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(isDefaultCheck, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 5, 0);
        mainPanel.add(initPanel, gridBagConstraints);

        winterRateSection.setName("winterRateSection"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        mainPanel.add(winterRateSection, gridBagConstraints);

        winterRatePanel.setMinimumSize(new java.awt.Dimension(635, 126));
        winterRatePanel.setName("winterRatePanel"); // NOI18N
        winterRatePanel.setPreferredSize(new java.awt.Dimension(635, 126));
        winterRatePanel.setLayout(new java.awt.GridBagLayout());

        bloque1InviernoLabel.setText(resourceMap.getString("bloque1InviernoLabel.text")); // NOI18N
        bloque1InviernoLabel.setName("bloque1InviernoLabel"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.ipadx = 30;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 0, 0, 0);
        winterRatePanel.add(bloque1InviernoLabel, gridBagConstraints);

        bloque2InviernoLabel.setText(resourceMap.getString("bloque2InviernoLabel.text")); // NOI18N
        bloque2InviernoLabel.setName("bloque2InviernoLabel"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.ipadx = 30;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(6, 0, 0, 0);
        winterRatePanel.add(bloque2InviernoLabel, gridBagConstraints);

        bloque3InviernoLabel.setText(resourceMap.getString("bloque3InviernoLabel.text")); // NOI18N
        bloque3InviernoLabel.setName("bloque3InviernoLabel"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.ipadx = 30;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(7, 0, 0, 0);
        winterRatePanel.add(bloque3InviernoLabel, gridBagConstraints);

        aduccionInviernoLabel.setText(resourceMap.getString("aduccionInviernoLabel.text")); // NOI18N
        aduccionInviernoLabel.setName("aduccionInviernoLabel"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 12, 0, 0);
        winterRatePanel.add(aduccionInviernoLabel, gridBagConstraints);

        bloque1AduccionInviernoField.setName("bloque1AduccionInviernoField"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.ipadx = 100;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 10, 0, 0);
        winterRatePanel.add(bloque1AduccionInviernoField, gridBagConstraints);

        bloque1DistribucionInviernoField.setName("bloque1DistribucionInviernoField"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.ipadx = 100;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 10, 0, 0);
        winterRatePanel.add(bloque1DistribucionInviernoField, gridBagConstraints);

        bloque1SaneamientoInviernoField.setName("bloque1SaneamientoInviernoField"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.ipadx = 100;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 10, 0, 0);
        winterRatePanel.add(bloque1SaneamientoInviernoField, gridBagConstraints);

        bloque1EurM3InviernoField.setName("bloque1EurM3InviernoField"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.ipadx = 100;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 10, 0, 0);
        winterRatePanel.add(bloque1EurM3InviernoField, gridBagConstraints);

        bloque1DepuracionInviernoField.setName("bloque1DepuracionInviernoField"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.ipadx = 100;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 10, 0, 0);
        winterRatePanel.add(bloque1DepuracionInviernoField, gridBagConstraints);

        bloque2AduccionInviernoField.setName("bloque2AduccionInviernoField"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.ipadx = 100;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 10, 0, 0);
        winterRatePanel.add(bloque2AduccionInviernoField, gridBagConstraints);

        bloque2DistribucionInviernoField.setName("bloque2DistribucionInviernoField"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.ipadx = 100;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 10, 0, 0);
        winterRatePanel.add(bloque2DistribucionInviernoField, gridBagConstraints);

        bloque2SaneamientoInviernoField.setName("bloque2SaneamientoInviernoField"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.ipadx = 100;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 10, 0, 0);
        winterRatePanel.add(bloque2SaneamientoInviernoField, gridBagConstraints);

        bloque2EurM3InviernoField.setName("bloque2EurM3InviernoField"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.ipadx = 100;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 10, 0, 0);
        winterRatePanel.add(bloque2EurM3InviernoField, gridBagConstraints);

        bloque2DepuracionInviernoField.setName("bloque2DepuracionInviernoField"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.ipadx = 100;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 10, 0, 0);
        winterRatePanel.add(bloque2DepuracionInviernoField, gridBagConstraints);

        bloque3AduccionInviernoField.setName("bloque3AduccionInviernoField"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.ipadx = 100;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 10, 0, 0);
        winterRatePanel.add(bloque3AduccionInviernoField, gridBagConstraints);

        bloque3DistribucionInviernoField.setName("bloque3DistribucionInviernoField"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.ipadx = 100;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 10, 0, 0);
        winterRatePanel.add(bloque3DistribucionInviernoField, gridBagConstraints);

        bloque3SaneamientoInviernoField.setName("bloque3SaneamientoInviernoField"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.ipadx = 100;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 10, 0, 0);
        winterRatePanel.add(bloque3SaneamientoInviernoField, gridBagConstraints);

        bloque3EurM3InviernoField.setName("bloque3EurM3InviernoField"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.ipadx = 100;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 10, 0, 0);
        winterRatePanel.add(bloque3EurM3InviernoField, gridBagConstraints);

        bloque3DepuracionInviernoField.setName("bloque3DepuracionInviernoField"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.ipadx = 100;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 10, 0, 0);
        winterRatePanel.add(bloque3DepuracionInviernoField, gridBagConstraints);

        bloque4AduccionInviernoField.setName("bloque4AduccionInviernoField"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.ipadx = 100;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 10, 0, 0);
        winterRatePanel.add(bloque4AduccionInviernoField, gridBagConstraints);

        bloque4DistribucionInviernoField.setName("bloque4DistribucionInviernoField"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.ipadx = 100;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 10, 0, 0);
        winterRatePanel.add(bloque4DistribucionInviernoField, gridBagConstraints);

        bloque4SaneamientoInviernoField.setName("bloque4SaneamientoInviernoField"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.ipadx = 100;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 10, 0, 0);
        winterRatePanel.add(bloque4SaneamientoInviernoField, gridBagConstraints);

        bloque4EurM3InviernoField.setName("bloque4EurM3InviernoField"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.ipadx = 100;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 10, 0, 0);
        winterRatePanel.add(bloque4EurM3InviernoField, gridBagConstraints);

        bloque4DepuracionInviernoField.setName("bloque4DepuracionInviernoField"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.ipadx = 100;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 10, 0, 0);
        winterRatePanel.add(bloque4DepuracionInviernoField, gridBagConstraints);

        bloque4InviernoLabel.setText(resourceMap.getString("bloque4InviernoLabel.text")); // NOI18N
        bloque4InviernoLabel.setName("bloque4InviernoLabel"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(7, 0, 0, 0);
        winterRatePanel.add(bloque4InviernoLabel, gridBagConstraints);

        distribucionInviernoLabel.setText(resourceMap.getString("distribucionInviernoLabel.text")); // NOI18N
        distribucionInviernoLabel.setName("distribucionInviernoLabel"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        winterRatePanel.add(distribucionInviernoLabel, gridBagConstraints);

        saneamientoInviernoLabel.setText(resourceMap.getString("saneamientoInviernoLabel.text")); // NOI18N
        saneamientoInviernoLabel.setName("saneamientoInviernoLabel"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 0;
        winterRatePanel.add(saneamientoInviernoLabel, gridBagConstraints);

        eurM3InviernoLabel.setText(resourceMap.getString("eurM3InviernoLabel.text")); // NOI18N
        eurM3InviernoLabel.setName("eurM3InviernoLabel"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 0;
        winterRatePanel.add(eurM3InviernoLabel, gridBagConstraints);

        depuracionInviernoLabel.setText(resourceMap.getString("depuracionInviernoLabel.text")); // NOI18N
        depuracionInviernoLabel.setName("depuracionInviernoLabel"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 0;
        winterRatePanel.add(depuracionInviernoLabel, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 10, 0);
        mainPanel.add(winterRatePanel, gridBagConstraints);

        summerRateSection.setName("summerRateSection"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        mainPanel.add(summerRateSection, gridBagConstraints);

        summerRatePanel.setMinimumSize(new java.awt.Dimension(635, 126));
        summerRatePanel.setName("summerRatePanel"); // NOI18N
        summerRatePanel.setPreferredSize(new java.awt.Dimension(635, 126));
        summerRatePanel.setLayout(new java.awt.GridBagLayout());

        bloque1VeranoLabel.setText(resourceMap.getString("bloque1VeranoLabel.text")); // NOI18N
        bloque1VeranoLabel.setName("bloque1VeranoLabel"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.ipadx = 30;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 0, 0, 0);
        summerRatePanel.add(bloque1VeranoLabel, gridBagConstraints);

        bloque2VeranoLabel.setText(resourceMap.getString("bloque2VeranoLabel.text")); // NOI18N
        bloque2VeranoLabel.setName("bloque2VeranoLabel"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.ipadx = 30;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(6, 0, 0, 0);
        summerRatePanel.add(bloque2VeranoLabel, gridBagConstraints);

        bloque3VeranoLabel.setText(resourceMap.getString("bloque3VeranoLabel.text")); // NOI18N
        bloque3VeranoLabel.setName("bloque3VeranoLabel"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.ipadx = 30;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(7, 0, 0, 0);
        summerRatePanel.add(bloque3VeranoLabel, gridBagConstraints);

        hidroLabel14.setText(resourceMap.getString("hidroLabel14.text")); // NOI18N
        hidroLabel14.setName("hidroLabel14"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 12, 0, 0);
        summerRatePanel.add(hidroLabel14, gridBagConstraints);

        bloque1AduccionVeranoField.setName("bloque1AduccionVeranoField"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.ipadx = 100;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 10, 0, 0);
        summerRatePanel.add(bloque1AduccionVeranoField, gridBagConstraints);

        bloque1DistribucionVeranoField.setName("bloque1DistribucionVeranoField"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.ipadx = 100;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 10, 0, 0);
        summerRatePanel.add(bloque1DistribucionVeranoField, gridBagConstraints);

        bloque1SaneamientoVeranoField.setName("bloque1SaneamientoVeranoField"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.ipadx = 100;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 10, 0, 0);
        summerRatePanel.add(bloque1SaneamientoVeranoField, gridBagConstraints);

        bloque1EurM3VeranoField.setName("bloque1EurM3VeranoField"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.ipadx = 100;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 10, 0, 0);
        summerRatePanel.add(bloque1EurM3VeranoField, gridBagConstraints);

        bloque1DepuracionVeranoField.setName("bloque1DepuracionVeranoField"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.ipadx = 100;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 10, 0, 0);
        summerRatePanel.add(bloque1DepuracionVeranoField, gridBagConstraints);

        bloque2AduccionVeranoField.setName("bloque2AduccionVeranoField"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.ipadx = 100;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 10, 0, 0);
        summerRatePanel.add(bloque2AduccionVeranoField, gridBagConstraints);

        bloque2DistribucionVeranoField.setName("bloque2DistribucionVeranoField"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.ipadx = 100;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 10, 0, 0);
        summerRatePanel.add(bloque2DistribucionVeranoField, gridBagConstraints);

        bloque2SaneamientoVeranoField.setName("bloque2SaneamientoVeranoField"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.ipadx = 100;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 10, 0, 0);
        summerRatePanel.add(bloque2SaneamientoVeranoField, gridBagConstraints);

        bloque2EurM3VeranoField.setName("bloque2EurM3VeranoField"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.ipadx = 100;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 10, 0, 0);
        summerRatePanel.add(bloque2EurM3VeranoField, gridBagConstraints);

        bloque2DepuracionVeranoField.setName("bloque2DepuracionVeranoField"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.ipadx = 100;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 10, 0, 0);
        summerRatePanel.add(bloque2DepuracionVeranoField, gridBagConstraints);

        bloque3AduccionVeranoField.setName("bloque3AduccionVeranoField"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.ipadx = 100;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 10, 0, 0);
        summerRatePanel.add(bloque3AduccionVeranoField, gridBagConstraints);

        bloque3DistribucionVeranoField.setName("bloque3DistribucionVeranoField"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.ipadx = 100;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 10, 0, 0);
        summerRatePanel.add(bloque3DistribucionVeranoField, gridBagConstraints);

        bloque3SaneamientoVeranoField.setName("bloque3SaneamientoVeranoField"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.ipadx = 100;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 10, 0, 0);
        summerRatePanel.add(bloque3SaneamientoVeranoField, gridBagConstraints);

        bloque3EurM3VeranoField.setName("bloque3EurM3VeranoField"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.ipadx = 100;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 10, 0, 0);
        summerRatePanel.add(bloque3EurM3VeranoField, gridBagConstraints);

        bloque3DepuracionVeranoField.setName("bloque3DepuracionVeranoField"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.ipadx = 100;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 10, 0, 0);
        summerRatePanel.add(bloque3DepuracionVeranoField, gridBagConstraints);

        bloque4AduccionVeranoField.setName("bloque4AduccionVeranoField"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.ipadx = 100;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 10, 0, 0);
        summerRatePanel.add(bloque4AduccionVeranoField, gridBagConstraints);

        bloque4DistribucionVeranoField.setName("bloque4DistribucionVeranoField"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.ipadx = 100;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 10, 0, 0);
        summerRatePanel.add(bloque4DistribucionVeranoField, gridBagConstraints);

        bloque4SaneamientoVeranoField.setName("bloque4SaneamientoVeranoField"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.ipadx = 100;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 10, 0, 0);
        summerRatePanel.add(bloque4SaneamientoVeranoField, gridBagConstraints);

        bloque4EurM3VeranoField.setName("bloque4EurM3VeranoField"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.ipadx = 100;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 10, 0, 0);
        summerRatePanel.add(bloque4EurM3VeranoField, gridBagConstraints);

        bloque4DepuracionVeranoField.setName("bloque4DepuracionVeranoField"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.ipadx = 100;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 10, 0, 0);
        summerRatePanel.add(bloque4DepuracionVeranoField, gridBagConstraints);

        bloque4VeranoLabel.setText(resourceMap.getString("bloque4VeranoLabel.text")); // NOI18N
        bloque4VeranoLabel.setName("bloque4VeranoLabel"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(7, 0, 0, 0);
        summerRatePanel.add(bloque4VeranoLabel, gridBagConstraints);

        hidroLabel16.setText(resourceMap.getString("hidroLabel16.text")); // NOI18N
        hidroLabel16.setName("hidroLabel16"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        summerRatePanel.add(hidroLabel16, gridBagConstraints);

        hidroLabel17.setText(resourceMap.getString("hidroLabel17.text")); // NOI18N
        hidroLabel17.setName("hidroLabel17"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 0;
        summerRatePanel.add(hidroLabel17, gridBagConstraints);

        hidroLabel18.setText(resourceMap.getString("hidroLabel18.text")); // NOI18N
        hidroLabel18.setName("hidroLabel18"); // NOI18N
        summerRatePanel.add(hidroLabel18, new java.awt.GridBagConstraints());

        hidroLabel19.setText(resourceMap.getString("hidroLabel19.text")); // NOI18N
        hidroLabel19.setName("hidroLabel19"); // NOI18N
        summerRatePanel.add(hidroLabel19, new java.awt.GridBagConstraints());

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 10, 0);
        mainPanel.add(summerRatePanel, gridBagConstraints);

        detailsSection.setName("detailsSection"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        mainPanel.add(detailsSection, gridBagConstraints);

        detailPanel.setMinimumSize(new java.awt.Dimension(560, 160));
        detailPanel.setName("detailPanel"); // NOI18N
        detailPanel.setPreferredSize(new java.awt.Dimension(560, 160));
        detailPanel.setLayout(new java.awt.GridBagLayout());

        hidroLabel20.setText(resourceMap.getString("hidroLabel20.text")); // NOI18N
        hidroLabel20.setName("hidroLabel20"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 100;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(6, 0, 0, 0);
        detailPanel.add(hidroLabel20, gridBagConstraints);

        ivaCanalField.setName("ivaCanalField"); // NOI18N
        ivaCanalField.setPreferredSize(new java.awt.Dimension(35, 19));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 100;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 10, 0, 0);
        detailPanel.add(ivaCanalField, gridBagConstraints);

        hidroLabel21.setText(resourceMap.getString("hidroLabel21.text")); // NOI18N
        hidroLabel21.setName("hidroLabel21"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 0, 0, 0);
        detailPanel.add(hidroLabel21, gridBagConstraints);

        ivaHidroconField.setName("ivaHidroconField"); // NOI18N
        ivaHidroconField.setPreferredSize(new java.awt.Dimension(35, 19));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.ipadx = 100;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 10, 0, 0);
        detailPanel.add(ivaHidroconField, gridBagConstraints);

        percentAduccionLabel.setText(resourceMap.getString("percentAduccionLabel.text")); // NOI18N
        percentAduccionLabel.setName("percentAduccionLabel"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 0, 0, 0);
        detailPanel.add(percentAduccionLabel, gridBagConstraints);

        percentDistribucionLabel.setText(resourceMap.getString("percentDistribucionLabel.text")); // NOI18N
        percentDistribucionLabel.setName("percentDistribucionLabel"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 0, 0, 0);
        detailPanel.add(percentDistribucionLabel, gridBagConstraints);

        percentDepuracionLabel.setText(resourceMap.getString("percentDepuracionLabel.text")); // NOI18N
        percentDepuracionLabel.setName("percentDepuracionLabel"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(6, 0, 0, 0);
        detailPanel.add(percentDepuracionLabel, gridBagConstraints);

        percentAlcantarilladoLabel.setText(resourceMap.getString("percentAlcantarilladoLabel.text")); // NOI18N
        percentAlcantarilladoLabel.setName("percentAlcantarilladoLabel"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.ipadx = 100;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(6, 0, 0, 0);
        detailPanel.add(percentAlcantarilladoLabel, gridBagConstraints);

        percentAduccionField.setMinimumSize(new java.awt.Dimension(100, 19));
        percentAduccionField.setName("percentAduccionField"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.ipadx = 50;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 10, 0, 0);
        detailPanel.add(percentAduccionField, gridBagConstraints);

        percentDistribucionField.setMinimumSize(new java.awt.Dimension(100, 19));
        percentDistribucionField.setName("percentDistribucionField"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.ipadx = 50;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 10, 0, 0);
        detailPanel.add(percentDistribucionField, gridBagConstraints);

        percentDepuracionField.setMinimumSize(new java.awt.Dimension(100, 19));
        percentDepuracionField.setName("percentDepuracionField"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.ipadx = 50;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 10, 0, 0);
        detailPanel.add(percentDepuracionField, gridBagConstraints);

        percentAlcantarilladoField.setMinimumSize(new java.awt.Dimension(100, 19));
        percentAlcantarilladoField.setName("percentAlcantarilladoField"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.ipadx = 50;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 10, 0, 0);
        detailPanel.add(percentAlcantarilladoField, gridBagConstraints);

        numRecibosLabel.setText(resourceMap.getString("numRecibosLabel.text")); // NOI18N
        numRecibosLabel.setName("numRecibosLabel"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 7;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 43, 0, 0);
        detailPanel.add(numRecibosLabel, gridBagConstraints);

        contadorFriaLabel.setText(resourceMap.getString("contadorFriaLabel.text")); // NOI18N
        contadorFriaLabel.setName("contadorFriaLabel"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 7;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(7, 43, 0, 0);
        detailPanel.add(contadorFriaLabel, gridBagConstraints);

        contadorCalienteLabel.setText(resourceMap.getString("contadorCalienteLabel.text")); // NOI18N
        contadorCalienteLabel.setName("contadorCalienteLabel"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 7;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(7, 43, 0, 0);
        detailPanel.add(contadorCalienteLabel, gridBagConstraints);

        numRecibosField.setName("numRecibosField"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 9;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.ipadx = 100;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 10, 0, 0);
        detailPanel.add(numRecibosField, gridBagConstraints);

        contadorFriaField.setName("contadorFriaField"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 9;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.ipadx = 100;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 10, 0, 0);
        detailPanel.add(contadorFriaField, gridBagConstraints);

        contadorCalienteField.setName("contadorCalienteField"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 9;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.ipadx = 100;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 10, 0, 0);
        detailPanel.add(contadorCalienteField, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        mainPanel.add(detailPanel, gridBagConstraints);

        bottomFiller.setName("bottomFiller"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.weighty = 1.0;
        mainPanel.add(bottomFiller, gridBagConstraints);

        add(mainPanel, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private hidrocon.custom.label.HidroLabel aduccionInviernoLabel;
    private hidrocon.custom.field.HidroFloatField bloque1AduccionInviernoField;
    private hidrocon.custom.field.HidroFloatField bloque1AduccionVeranoField;
    private hidrocon.custom.field.HidroFloatField bloque1DepuracionInviernoField;
    private hidrocon.custom.field.HidroFloatField bloque1DepuracionVeranoField;
    private hidrocon.custom.field.HidroFloatField bloque1DistribucionInviernoField;
    private hidrocon.custom.field.HidroFloatField bloque1DistribucionVeranoField;
    private hidrocon.custom.field.HidroFloatField bloque1EurM3InviernoField;
    private hidrocon.custom.field.HidroFloatField bloque1EurM3VeranoField;
    private hidrocon.custom.label.HidroLabel bloque1InviernoLabel;
    private hidrocon.custom.field.HidroFloatField bloque1SaneamientoInviernoField;
    private hidrocon.custom.field.HidroFloatField bloque1SaneamientoVeranoField;
    private hidrocon.custom.label.HidroLabel bloque1VeranoLabel;
    private hidrocon.custom.field.HidroFloatField bloque2AduccionInviernoField;
    private hidrocon.custom.field.HidroFloatField bloque2AduccionVeranoField;
    private hidrocon.custom.field.HidroFloatField bloque2DepuracionInviernoField;
    private hidrocon.custom.field.HidroFloatField bloque2DepuracionVeranoField;
    private hidrocon.custom.field.HidroFloatField bloque2DistribucionInviernoField;
    private hidrocon.custom.field.HidroFloatField bloque2DistribucionVeranoField;
    private hidrocon.custom.field.HidroFloatField bloque2EurM3InviernoField;
    private hidrocon.custom.field.HidroFloatField bloque2EurM3VeranoField;
    private hidrocon.custom.label.HidroLabel bloque2InviernoLabel;
    private hidrocon.custom.field.HidroFloatField bloque2SaneamientoInviernoField;
    private hidrocon.custom.field.HidroFloatField bloque2SaneamientoVeranoField;
    private hidrocon.custom.label.HidroLabel bloque2VeranoLabel;
    private hidrocon.custom.field.HidroFloatField bloque3AduccionInviernoField;
    private hidrocon.custom.field.HidroFloatField bloque3AduccionVeranoField;
    private hidrocon.custom.field.HidroFloatField bloque3DepuracionInviernoField;
    private hidrocon.custom.field.HidroFloatField bloque3DepuracionVeranoField;
    private hidrocon.custom.field.HidroFloatField bloque3DistribucionInviernoField;
    private hidrocon.custom.field.HidroFloatField bloque3DistribucionVeranoField;
    private hidrocon.custom.field.HidroFloatField bloque3EurM3InviernoField;
    private hidrocon.custom.field.HidroFloatField bloque3EurM3VeranoField;
    private hidrocon.custom.label.HidroLabel bloque3InviernoLabel;
    private hidrocon.custom.field.HidroFloatField bloque3SaneamientoInviernoField;
    private hidrocon.custom.field.HidroFloatField bloque3SaneamientoVeranoField;
    private hidrocon.custom.label.HidroLabel bloque3VeranoLabel;
    private hidrocon.custom.field.HidroFloatField bloque4AduccionInviernoField;
    private hidrocon.custom.field.HidroFloatField bloque4AduccionVeranoField;
    private hidrocon.custom.field.HidroFloatField bloque4DepuracionInviernoField;
    private hidrocon.custom.field.HidroFloatField bloque4DepuracionVeranoField;
    private hidrocon.custom.field.HidroFloatField bloque4DistribucionInviernoField;
    private hidrocon.custom.field.HidroFloatField bloque4DistribucionVeranoField;
    private hidrocon.custom.field.HidroFloatField bloque4EurM3InviernoField;
    private hidrocon.custom.field.HidroFloatField bloque4EurM3VeranoField;
    private hidrocon.custom.label.HidroLabel bloque4InviernoLabel;
    private hidrocon.custom.field.HidroFloatField bloque4SaneamientoInviernoField;
    private hidrocon.custom.field.HidroFloatField bloque4SaneamientoVeranoField;
    private hidrocon.custom.label.HidroLabel bloque4VeranoLabel;
    private javax.swing.Box.Filler bottomFiller;
    private hidrocon.custom.field.HidroFloatField contadorCalienteField;
    private hidrocon.custom.label.HidroLabel contadorCalienteLabel;
    private hidrocon.custom.field.HidroFloatField contadorFriaField;
    private hidrocon.custom.label.HidroLabel contadorFriaLabel;
    private hidrocon.custom.label.HidroLabel depuracionInviernoLabel;
    private hidrocon.custom.panel.HidroPanel detailPanel;
    private hidrocon.custom.panel.HidroSectionPanel detailsSection;
    private hidrocon.custom.label.HidroLabel distribucionInviernoLabel;
    private hidrocon.custom.label.HidroLabel eurM3InviernoLabel;
    private hidrocon.custom.label.HidroLabel hidroLabel14;
    private hidrocon.custom.label.HidroLabel hidroLabel16;
    private hidrocon.custom.label.HidroLabel hidroLabel17;
    private hidrocon.custom.label.HidroLabel hidroLabel18;
    private hidrocon.custom.label.HidroLabel hidroLabel19;
    private hidrocon.custom.label.HidroLabel hidroLabel20;
    private hidrocon.custom.label.HidroLabel hidroLabel21;
    private hidrocon.custom.panel.HidroPanel initPanel;
    private hidrocon.custom.field.HidroCheckBox isDefaultCheck;
    private hidrocon.custom.field.HidroIntegerField ivaCanalField;
    private hidrocon.custom.field.HidroIntegerField ivaHidroconField;
    private hidrocon.custom.panel.HidroMainPanel mainPanel;
    private hidrocon.custom.field.HidroIntegerField numRecibosField;
    private hidrocon.custom.label.HidroLabel numRecibosLabel;
    private hidrocon.custom.field.HidroFloatField percentAduccionField;
    private hidrocon.custom.label.HidroLabel percentAduccionLabel;
    private hidrocon.custom.field.HidroFloatField percentAlcantarilladoField;
    private hidrocon.custom.label.HidroLabel percentAlcantarilladoLabel;
    private hidrocon.custom.field.HidroFloatField percentDepuracionField;
    private hidrocon.custom.label.HidroLabel percentDepuracionLabel;
    private hidrocon.custom.field.HidroFloatField percentDistribucionField;
    private hidrocon.custom.label.HidroLabel percentDistribucionLabel;
    private hidrocon.custom.field.HidroTextField rateNameField;
    private hidrocon.custom.label.HidroLabel rateNameLabel;
    private hidrocon.custom.label.HidroLabel saneamientoInviernoLabel;
    private hidrocon.custom.panel.HidroPanel summerRatePanel;
    private hidrocon.custom.panel.HidroSectionPanel summerRateSection;
    private hidrocon.custom.panel.HidroTopPanel topPanel;
    private hidrocon.custom.panel.HidroPanel winterRatePanel;
    private hidrocon.custom.panel.HidroSectionPanel winterRateSection;
    // End of variables declaration//GEN-END:variables

    public void buttonActionListeners(ActionListener al) {
        editButton.setActionCommand(ActionKey.RATE_DETAILS_EDIT);
		editButton.addActionListener(al);
        saveButton.setActionCommand(ActionKey.RATE_DETAILS_SAVE);
		saveButton.addActionListener(al);
        exitButton.setActionCommand(ActionKey.RATE_DETAILS_CLOSE);
		exitButton.addActionListener(al);
    }
    
    public JPanel getMainPanel() {
        return mainPanel;
    }
}
