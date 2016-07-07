package text.korean.managerclass;

import text.korean.DataClass.TextData;

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

    public void addTextData(TextData input){
        this.textDatas.add(input);
    }
}
