package text.korean.DataClass;

/**
 * Created by parkjaesung on 2016. 7. 5..
 */
public class TextData {

    private String textData;
    private int textLength;

    //TODO Refactor code using REGEX
    public void removeSpecialChar(){

        this.textData = this.textData.replaceAll("\"", "");
        this.textData = this.textData.replaceAll("<", "");
        this.textData = this.textData.replaceAll(">", "");
        this.textData = this.textData.replaceAll("\n", "");
    }

    public void setTextLength(){
        this.textLength = textData.length();
    }

    public int getTextLength(){
        return this.textLength;
    }

    public String getTextData(){
        return this.textData;
    }

}
