import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class App extends Application {
    public static void main(String[] args) throws Exception {
        launch(args); 
    }

    @Override 
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("lector.fxml"));
        Parent root = fxmlLoader.load(); 
        Scene scene = new Scene(root); 

        Image icon = new Image("lector.png"); 
        primaryStage.getIcons().add(icon); 
        primaryStage.setTitle("Lector de Nivel");
        primaryStage.setScene(scene);
        primaryStage.show(); 
    }

}

