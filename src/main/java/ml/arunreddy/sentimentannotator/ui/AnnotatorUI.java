package ml.arunreddy.sentimentannotator.ui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import java.io.File;

/**
 * Created by arun on 6/3/15.
 */
public class AnnotatorUI extends  Application {


  @Override
  public void start(Stage primaryStage) throws Exception {

    File file = new File("annotator.fxml");
    Parent root = FXMLLoader.load(file.toURL());

    Scene scene = new Scene(root, 600, 600);
   

    primaryStage.setTitle("Sentiment Annotator v0.2");
    primaryStage.setScene(scene);
    primaryStage.show();
    scene.getRoot().requestFocus();
  }


  public static void main(String[] args) {
    launch();
  }
}
