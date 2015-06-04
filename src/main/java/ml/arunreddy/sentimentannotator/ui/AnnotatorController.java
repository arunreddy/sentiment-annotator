package ml.arunreddy.sentimentannotator.ui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import ml.arunreddy.datasets.tudiabetes.Sentiment;
import ml.arunreddy.sentimentannotator.db.DummyData;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import com.ohmdb.api.Db;
import com.ohmdb.api.Ohm;
import com.ohmdb.api.Table;


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

  private void update(){
    indexLabel.setText("Index:" + index);
    System.out.println(index);
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

  @Override
  public void initialize(URL location, ResourceBundle resources) {
    Db db = Ohm.db("tu-diabetes.db");
    sentimentTable = db.table(Sentiment.class);

    update();

  }
}
