package fxTuloskortti;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import tuloskortti.Tuloskortti; 


/**
 * Pääohjelma tuloskorttiohjelman käynnistämiseen
 * tahvpwzw@jyu.student.fi
 * @author tahvpwzw
 * @version 13.1.2021
 *
 */
public class TuloskorttiMain extends Application {
	
    @Override
	public void start(Stage primaryStage) {
		try {
		    final FXMLLoader ldr = new FXMLLoader(getClass().getResource("TuloskorttiGUIView.fxml"));
		    final Pane root = (Pane)ldr.load();
		    final TuloskorttiGUIController tuloskorttiCtrl = (TuloskorttiGUIController)ldr.getController();
		    
		    final Scene scene = new Scene(root);
		    
			scene.getStylesheets().add(getClass().getResource("tuloskortti.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setTitle("Tuloskortti");
			
			primaryStage.setOnCloseRequest((event) -> {
			    //kutsutaan sulkuLupa-metodia
			    if( !tuloskorttiCtrl.sulkuLupa() ) event.consume();
			});

	        Tuloskortti tuloskortti = new Tuloskortti();
	        tuloskorttiCtrl.setTuloskortti(tuloskortti);
			
			primaryStage.show();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Käynnistää käyttöliittymän
	 * @param args ei käytössä
	 */
	public static void main(String[] args) {
		launch(args);
	}

}
