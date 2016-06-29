package text.korean.DataClass;

/**
 * Created by parkjaesung on 2016. 6. 29..
 */
public class WordInfo {

    private StringBuffer word;
    private boolean isPositive;
    private double positionAtText;

    public StringBuffer getWord() {
        return word;
    }

    public void setWord(StringBuffer word) {
        this.word = word;
    }

    public boolean isPositive() {
        return isPositive;
    }

    public void setPositive(boolean positive) {
        isPositive = positive;
    }

    public double getPositionAtText() {
        return positionAtText;
    }

    public void setPositionAtText(double positionAtText) {
        this.positionAtText = positionAtText;
    }
}
