package ml.arunreddy.sentimentannotator.ui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import ml.arunreddy.datasets.tudiabetes.Sentiment;

import java.net.URL;
import java.util.ResourceBundle;
import com.ohmdb.api.Db;
import com.ohmdb.api.Ohm;
import com.ohmdb.api.Table;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import static javafx.scene.input.KeyCode.*;

/**
 * Created by arun on 6/3/15.
 */
public class AnnotatorController implements Initializable{

  private int index;

  private Table<Sentiment> sentimentTable;

  @FXML
  private Label indexLabel;

  @FXML
  private Label sentimentLabel;

  private Sentiment sentiment;
  
  @FXML
  private TextField jumpIndexTextField;


  @FXML
  private TextArea sentimentTextArea;

  @FXML
  protected void handleNegativeButtonAction(ActionEvent event){
    sentiment.setLabel(-1);
    sentimentTable.update(sentiment);
    update();
  }

  @FXML
  protected void handlePositiveButtonAction(ActionEvent event){
    sentiment.setLabel(1);
    sentimentTable.update(sentiment);
    update();
  }

  @FXML
  protected void handleNeutralButtonAction(ActionEvent event){
    sentiment.setLabel(0);
    sentimentTable.update(sentiment);
    update();
  }

  @FXML
  protected  void handleNextButtonAction(ActionEvent event){
    if(index < sentimentTable.size()-1){
      index++;
    }
    update();
  }

  @FXML
  protected void handleBackButtonAction(ActionEvent event){

    if(index>0){
      index--;
    }
    update();
  }
  
  @FXML
  protected void handleGoButtonAction(ActionEvent event){
      String text = jumpIndexTextField.getText();
      if(text!=null && text.matches("\\d+")){
          int i = Integer.parseInt(text);
          index = i;
          update();
      }else{
          alert("Invalid entry. Make sure the value is an integer.");
      }
      
  }
  
  @FXML
  protected void keyPressedEvent(KeyEvent event){
     
      switch(event.getCode()){
          case A:
              this.handleNegativeButtonAction(null);
          case S:
              this.handleNeutralButtonAction(null);
          case D:
              this.handleNextButtonAction(null);
          case LEFT:
             this.handleBackButtonAction(null);
          case RIGHT:
             this.handleNextButtonAction(null);
          default:
              //Do Nothing.
      }
  }

  private void update(){
    indexLabel.setText("Index:" + index);
    sentiment = sentimentTable.get(index);
    String text = sentiment.getText().trim();
    sentimentTextArea.setText(text);
    if(sentiment.getLabel()==-1){
      sentimentLabel.setText("Negative");
    }else if (sentiment.getLabel() == 0){
      sentimentLabel.setText("Neutral");
    }else if (sentiment.getLabel() == 1){
      sentimentLabel.setText("Positive");
    }else{
      sentimentLabel.setText("Unlabeled");
    }
  }

  
  private void alert(String message){
    Alert alert = new Alert(AlertType.INFORMATION);
    alert.setTitle("Information Dialog");
    alert.setHeaderText(null);
    alert.setContentText(message);
    alert.showAndWait();
  }
  
  @Override
  public void initialize(URL location, ResourceBundle resources) {
    Db db = Ohm.db("diabetes-sisters.db");
    sentimentTable = db.table(Sentiment.class);

    update();

  }
}
