package fxTuloskortti;


import java.io.PrintStream;
import java.net.URL;
import java.util.ResourceBundle;

import fi.jyu.mit.fxgui.Dialogs;
import fi.jyu.mit.fxgui.ListChooser;
import fi.jyu.mit.fxgui.ModalController;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import tuloskortti.Tuloskortti;


/**
 * Luokka käyttöliittymän käsittelyille
 * @author tahvpwzw
 * @version 13.1.2021
 * 
 */

public class TuloskorttiGUIController implements Initializable{    
    
    @FXML private TextField hakuehto;
    @FXML private Label labelVirhe;
    @FXML private ScrollPane panelRata;
    @FXML private ListChooser<String[]> chooserRata;

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
    
    
    @Override
    public void initialize(URL url, ResourceBundle bundle) { 
        alusta();
        avaa();
    }
    
    
    @FXML private void handleHakuEhto() {
        String ehto = hakuehto.getText();
        
        if ( ehto.isEmpty() )
            naytaVirhe(null);
        else
            naytaVirhe("Ei osata vielä hakea "  + ": " + ehto);

    }
    
    
    @FXML private void handleAvaa() {
        avaa();
    }
    
    
    @FXML private void handleUusi(){
        boolean kumpi; 
        kumpi = (Dialogs.showQuestionDialog("Uusi", "Lisätäänkö rata vai tulos?", "Uusi rata", "Uusi tuloskortti"));
        if (kumpi == true) handleUusirata();
        if (kumpi == false) handleUusiTuloskortti();
    }
    
    
    /**
     * Käsittelee uuden tuloskortin
     */
    @FXML private void handleUusiTuloskortti() {
        // uusiTulos();
        var resurssi = TuloskorttiGUIController.class.getResource("UusiTulosView.fxml");
        ModalController.showModal(resurssi, "Uusi Tuloskortti",null, "");
    }
    
    
    /** 
     * Käsittelee uuden radan
     */
    @FXML private void handleUusirata() {
        Dialogs.showMessageDialog("Ei toimi radan lisäys");
        var resurssi = TuloskorttiGUIController.class.getResource("UusirataView.fxml");
        ModalController.showModal(resurssi, "Uusi rata",null, "");
        //String[] ratatiedot = {"Esimerkki", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18"};
        //lisaaRata(ratatiedot);
    }
    
    
    /**
     * Käsittelee tallennuspyynnön
     */
    @FXML private void handleTallenna() {
        tallenna();
    }
    
    
    /**
     * Käsittelee lopetuskäskyn
     */
    @FXML private void handleLopeta()   {
        Platform.exit();
    }
    
    
    /**
     * Käsittelee radan/tuloksen poistamisen
     */
    @FXML private void handlePoista() {
        // poista();
        Dialogs.showMessageDialog("Ei toimi poisto");
    }
    
    
    /**
     * Käsittelee radan muokkauksen
     */
    @FXML private void handleMuokkaa() {
        // uusiRata(@par muokattava);
        Dialogs.showMessageDialog("Ei toimi");
        var resurssi = TuloskorttiGUIController.class.getResource("UusirataView.fxml");
        ModalController.showModal(resurssi, "Uusi rata",null, "");
    }
    
    
    /**
     * Avaa suunnitelman tms
     */
    @FXML private void handleAbout() {
        Dialogs.showMessageDialog("Ei toimi");
    }
    
    @FXML private void handleLisaa() {
        lisaa();
    }
    
    
//===========================================================================================    
// Tästä eteenpäin ei käyttöliittymään suoraan liittyvää koodia    

    private Tuloskortti tuloskortti;
    private String[] rataKohdalla;
    
    /**
     * Tallentaa tiedot
     * @return null jos onnistuu, muuten virhe tekstinä
     */
    private String tallenna() {
        //try {
            tuloskortti.tallenna();
            return null;
        //} catch (IOException io){
        //    Dialogs.showMessageDialog("Tallennuksessa ongelmia! " + io.getMessage());
        //    return io.getMessage();
        //} TODO korjaa kun viimestellään
    }
    
    /**
     *  lisaa radan
     */
    protected void lisaa() {
        
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
        
        lisaaRata(uRata);
    }
    
    
    /**
     * Tarkistetaan onko tallennettu 
     * TODO lisätä varmistus tallennustarpeelle
     * @return true jos saa sulkea sovelluksen, false jos ei
     */
    public boolean sulkuLupa() {
        return true;
    }
    
    
    /**
     *  alustaa 
     */
    protected void alusta() {
        panelRata.setFitToHeight(true);
        
        chooserRata.clear();
        chooserRata.addSelectionListener(e -> naytaRata());

    }
    
    /** tulostaa radan tiedot
     * 
     */
    protected void naytaRata() {
        
        rataKohdalla = chooserRata.getSelectedObject();
        
        if (rataKohdalla == null) return;
        
        textUusiNimi.setText(rataKohdalla[0]);
        par1.setText(rataKohdalla[1]);
        par2.setText(rataKohdalla[2]);
        par3.setText(rataKohdalla[3]);
        par4.setText(rataKohdalla[4]);
        par5.setText(rataKohdalla[5]);
        par6.setText(rataKohdalla[6]);
        par7.setText(rataKohdalla[7]);
        par8.setText(rataKohdalla[8]);
        par9.setText(rataKohdalla[9]);
        par10.setText(rataKohdalla[10]);
        par11.setText(rataKohdalla[11]);
        par12.setText(rataKohdalla[12]);
        par13.setText(rataKohdalla[13]);
        par14.setText(rataKohdalla[14]);
        par15.setText(rataKohdalla[15]);
        par16.setText(rataKohdalla[16]);
        par17.setText(rataKohdalla[17]);
        par18.setText(rataKohdalla[18]);
    }
    
    
    private void naytaVirhe(String virhe) {
        if (virhe == null || virhe.isEmpty()) {
            labelVirhe.setText("");
            labelVirhe.getStyleClass().removeAll("virhe");
            return;
        }
        labelVirhe.setText(virhe);
        labelVirhe.getStyleClass().add("virhe");
    }

    
    /** asettaa ohjelman käyttöliittymään tuloskorttiolion
     * @param tuloskortti asetettava tuloskortti
     */
    public void setTuloskortti(Tuloskortti tuloskortti) {
        this.tuloskortti = tuloskortti;
        lataa();
        naytaRata();
    }
    
    /**
     * lisää uuden radan muokattavaksi
     * @param ratatiedot tiedot minkä pohjalta uusi rata luodaan
     */
    protected void lisaaRata(String[] ratatiedot){
        
        tuloskortti.lisaaRata(ratatiedot);
        hae(tuloskortti.annaRataId());
    }
    
    
    
    /**
     * TODO ei toimi
     * hakee kohteen valittavaksi
     * @param hakuid luku jolla haetaan
     */
    protected void hae(int hakuid) {
        
        String[] tiedot = new String[19];
        int index = 0;
        for(int i = 0; i <= tuloskortti.rataMaara(); i++) {
            if (tuloskortti.annaRataId() == hakuid) {
                tiedot = tuloskortti.annaRata(hakuid);
                index = i;
                break;
            }
        }
        chooserRata.add(tiedot[0], tiedot);
        chooserRata.setSelectedIndex(index);
        naytaRata();    
    }
    
    /**
     * @param os virta minne tulostetaan
     * @param ratatiedot tulostettavat tratatiedot
     */
    public void tulosta(PrintStream os, String[] ratatiedot) {
        os.println("Radan nimi: " + ratatiedot[0]);
        for(int i = 1; i < ratatiedot.length; i++) {
            os.println("Väylä: "+ i + " Par: " + ratatiedot[i]);
        }
    }
    
    /**
     * lataa tiedostojen tiedot esille
     */
    public void lataa() {
        lueTiedosto();
        int maara = tuloskortti.rataMaara();
        int lisatyt = 0;
        for(int i = 0; lisatyt < maara; i++) {            
            String[] tiedot = tuloskortti.annaRata(i);
            if(tiedot[0] == "")continue;
            chooserRata.add(tiedot[0], tiedot);
            lisatyt++;
        }
    }



    /**
     * @return palauttaa avausluvan
     */
    public boolean avaa() {
        //TODO method stub
        return true;
    }
    
    /**
     * lukee tiedot
     */
    public void lueTiedosto() {
        tuloskortti.lueTiedostot();
    }
    
    
}
