package fxTuloskortti;
	
import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;


/**
 * Pääohjelma tuloskorttiohjelman käynnistämiseen
 * 
 * @author tahvpwzw
 * @version 13.1.2021
 *
 */
public class TuloskorttiMain extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
		    FXMLLoader ldr = new FXMLLoader(getClass().getResource("TuloskorttiGUIView.fxml"));
		    final Pane root = (Pane)ldr.load();
		    final TuloskorttiGUIController tuloskorttiCtrl = (TuloskorttiGUIController)ldr.getController();
		    
		    final Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("tuloskortti.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setTitle("Tuloskortti");
			
			//Platform.setImplicitExit(false); //Pitää itse sulkea
			
			primaryStage.setOnCloseRequest((event) -> {
			    //kutsutaan sulkuLupa-metodia
			    if( !tuloskorttiCtrl.sulkuLupa() ) event.consume();
			});
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
