package ml.arunreddy.sentimentannotator.ui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;

import java.net.URL;
import java.util.ResourceBundle;


/**
 * Created by arun on 6/3/15.
 */
public class AnnotatorController implements Initializable{

  private int index;


  @FXML
  private TextArea sentimentTextArea;

  @FXML
  protected void handleNegativeButtonAction(ActionEvent event){
    System.out.println(event);
    sentimentTextArea.setText(event.toString());
  }

  @FXML
  protected void handlePositiveButtonAction(ActionEvent event){
    System.out.println(event);
    sentimentTextArea.setText(event.toString());
  }

  @FXML
  protected void handleNeutralButtonAction(ActionEvent event){
    System.out.println(event);
    sentimentTextArea.setText(event.toString());
  }

  @FXML
  protected  void handleNextButtonAction(ActionEvent event){

  }

  @FXML
  protected void handleBackButtonAction(ActionEvent event){
    
  }


  @Override
  public void initialize(URL location, ResourceBundle resources) {

  }
}
