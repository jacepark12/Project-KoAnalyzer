package text.korean.DataClass;

import java.util.ArrayList;

/**
 * Created by parkjaesung on 2016. 6. 29..
 */
//Singleton Pattern
public class WordInfoManager {

    public static ArrayList<WordInfo> wordInfoArrayList = new ArrayList<>();
    private static WordInfoManager instance = new WordInfoManager();

    //Constructor
    private WordInfoManager(){

    }

    //Getter & Setter
    public static ArrayList<WordInfo> getWordInfoArrayList() {
        return wordInfoArrayList;
    }

    public static void setWordInfoArrayList(ArrayList<WordInfo> wordInfoArrayList) {
        WordInfoManager.wordInfoArrayList = wordInfoArrayList;
    }

    public static void printWordInfo(ArrayList<WordInfo> wordInfoArrayList){

        for (WordInfo wordInfo: wordInfoArrayList) {
            System.out.println("단어 : " + wordInfo.getWord());
            System.out.println("감성 타입 : " + wordInfo.getSentimentType().name());
            System.out.println("글 내에서의 위치 : " + wordInfo.getPositionAtText() + "%");
        }
    }

    public static WordInfoManager getInstance(){
        return instance;
    }

}
