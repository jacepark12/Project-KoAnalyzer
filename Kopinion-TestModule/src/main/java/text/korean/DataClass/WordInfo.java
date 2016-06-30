package text.korean.DataClass;

/**
 * Created by parkjaesung on 2016. 6. 29..
 */
public class WordInfo implements SentimentTypeInterface{

    private StringBuffer word;
    private SentimentType sentimentType;
    private double positionAtText;

    public SentimentType getSentimentType() {
        return sentimentType;
    }

    public void setSentimentType(SentimentType sentimentType) {
        this.sentimentType = sentimentType;
    }

    public StringBuffer getWord() {
        return word;
    }

    public void setWord(StringBuffer word) {
        this.word = word;
    }

    public double getPositionAtText() {
        return positionAtText;
    }

    public void setPositionAtText(double positionAtText) {
        this.positionAtText = positionAtText;
    }
}
