package text.korean.DataClass;

/**
 * Created by parkjaesung on 2016. 6. 29..
 */
public class WordInfo implements SentimentTypeInterface{

    private StringBuffer word;
    private SentimentType sentimentType;
    private int positionAtText; //save as percentage by multiples of 10

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

    public int getPositionAtText() {
        return positionAtText;
    }

    public void setPositionAtText(int positionAtText) {
        this.positionAtText = positionAtText;
    }
}
