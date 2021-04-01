package fxTuloskortti;

import java.net.URL;
import java.util.ResourceBundle;

import fi.jyu.mit.fxgui.Dialogs;
import fi.jyu.mit.fxgui.ModalController;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import fi.jyu.mit.fxgui.ModalControllerInterface;

/**
 * Kontrolleri lisäämiselle ja muokkaukselle
 * @author tahvpwzw
 * @version 17.2.2021
 *
 */
public class UusiGUIController implements ModalControllerInterface<String>, Initializable{
    
    @FXML private Button buttonPeruuta;
    @FXML private Button buttonTallenna;
    @FXML private TextField textUusiNimi;
    @FXML private TextField par1;
    @FXML private TextField par2;
    @FXML private TextField par3;
    @FXML private TextField par4;
    @FXML private TextField par5;
    @FXML private TextField par6;
    @FXML private TextField par7;
    @FXML private TextField par8;
    @FXML private TextField par9;
    @FXML private TextField par10;
    @FXML private TextField par11;
    @FXML private TextField par12;
    @FXML private TextField par13;
    @FXML private TextField par14;
    @FXML private TextField par15;
    @FXML private TextField par16;
    @FXML private TextField par17;
    @FXML private TextField par18;
    private String[] pohja = {"Esimerkki", "1","2","3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18"};
    

    @Override
    public void setDefault(String oletus) {
         
         textUusiNimi.setText(pohja[0]);
         par1.setText(pohja[1]);
         par2.setText(pohja[2]);
         par3.setText(pohja[3]);
         par4.setText(pohja[4]);
         par5.setText(pohja[5]);
         par6.setText(pohja[6]);
         par7.setText(pohja[7]);
         par8.setText(pohja[8]);
         par9.setText(pohja[9]);
         par10.setText(pohja[10]);
         par11.setText(pohja[11]);
         par12.setText(pohja[12]);
         par13.setText(pohja[13]);
         par14.setText(pohja[14]);
         par15.setText(pohja[15]);
         par16.setText(pohja[16]);
         par17.setText(pohja[17]);
         par18.setText(pohja[18]);
        
    }
    

    @Override
    public void handleShown() {
        textUusiNimi.requestFocus();
        
    }
    
    @FXML private void handleTallenna() {
        tallenna();
        ModalController.closeStage(buttonTallenna);
    }
    
    @FXML private void handlePeruuta() {
        ModalController.closeStage(buttonPeruuta);
    }
    
    @FXML private void handlePlus() {
        Dialogs.showMessageDialog("ei toimi +");
    }
      
    @FXML private void handleMiinus() {
        Dialogs.showMessageDialog("ei toimi -");
    }
    
    @FXML private void handleVayla() {
        Dialogs.showMessageDialog("ei voi vielä lisätä");
    }
    
    //TODO väylien poistaminen jos vahingossa lisätty radalle liikaa
    
    private String[] tallenna() {
        //Dialogs.showMessageDialog("Ei toimi, mutta tallenetaan");
        String[] uRata = new String[19];
        uRata[0] = textUusiNimi.getText();
        uRata[1] = par1.getText();
        uRata[2] = par2.getText();
        uRata[3] = par3.getText();
        uRata[4] = par4.getText();
        uRata[5] = par5.getText();
        uRata[6] = par6.getText();
        uRata[7] = par7.getText();
        uRata[8] = par8.getText();
        uRata[9] = par9.getText();
        uRata[10] = par10.getText();
        uRata[11] = par11.getText();
        uRata[12] = par12.getText();
        uRata[13] = par13.getText();
        uRata[14] = par14.getText();
        uRata[15] = par15.getText();
        uRata[16] = par16.getText();
        uRata[17] = par17.getText();
        uRata[18] = par18.getText();
        
        
        return uRata;
        }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public String getResult() {
        // TODO Auto-generated method stub
        return null;
    }




}