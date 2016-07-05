package text.korean.DataClass;

import java.util.ArrayList;

/**
 * Created by parkjaesung on 2016. 7. 5..
 */

//Singleton Pattern
public class TextDataManager {

    private static TextDataManager instance = new TextDataManager();

    private ArrayList<TextData> textDatas = new ArrayList<>();

    //private Constructor
    private TextDataManager(){

    }

    public static TextDataManager getInstance(){
        return instance;
    }

    public ArrayList<TextData> getTextDatas() {
        return textDatas;
    }

    public void setTextDatas(ArrayList<TextData> textDatas) {
        this.textDatas = textDatas;
    }
}
