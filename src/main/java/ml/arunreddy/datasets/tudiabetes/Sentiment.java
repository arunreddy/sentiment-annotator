package ml.arunreddy.datasets.tudiabetes;


/**
 * Created by arun on 6/3/15.
 */
public class Sentiment {

  private String text;

  private int label=-10;

  private String user;

  private long id;

  public Sentiment(){
    this(null);
  }

  public Sentiment(String text){
    this.text = text;
  }

  public String getText() {
    return text;
  }

  public void setText(String text) {
    this.text = text;
  }

  public int getLabel() {
    return label;
  }

  public void setLabel(int label) {
    this.label = label;
  }

  public String getUser() {
    return user;
  }

  public void setUser(String user) {
    this.user = user;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }
}
