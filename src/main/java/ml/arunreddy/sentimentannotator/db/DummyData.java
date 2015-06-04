package ml.arunreddy.sentimentannotator.db;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by arun on 6/3/15.
 */
public class DummyData {

  public List<Sentiment> getDummyData(){
    List<Sentiment> sentimentList = new ArrayList<Sentiment>();

    Sentiment sentiment = new Sentiment("Text 01");
    sentimentList.add(sentiment);

    sentiment = new Sentiment("Text 01");
    sentimentList.add(sentiment);

    sentiment = new Sentiment("Text 02");
    sentimentList.add(sentiment);

    sentiment = new Sentiment("Text 03");
    sentimentList.add(sentiment);

    sentiment = new Sentiment("Text 04");
    sentimentList.add(sentiment);

    sentiment = new Sentiment("Text 05");
    sentimentList.add(sentiment);

    return sentimentList;
  }
}
