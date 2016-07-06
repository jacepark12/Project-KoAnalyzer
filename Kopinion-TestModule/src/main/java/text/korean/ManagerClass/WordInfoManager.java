package text.korean.managerclass;

import text.korean.DataClass.WordInfo;

import java.util.ArrayList;

/**
 * Created by parkjaesung on 2016. 6. 29..
 */

//Singleton Pattern
public class WordInfoManager {

    private ArrayList<WordInfo> wordInfoArrayList = new ArrayList<>();

    //Constructor
    public WordInfoManager(){

    }

    //Getter & Setter
    public ArrayList<WordInfo> getWordInfoArrayList() {
        return wordInfoArrayList;
    }

    public void setWordInfoArrayList(ArrayList<WordInfo> wordInfoArrayList) {
        this.wordInfoArrayList = wordInfoArrayList;
    }

    public void addWordInfoToArrayList(WordInfo wordInfo){
        this.wordInfoArrayList.add(wordInfo);
    }

    public void printWordInfo(ArrayList<WordInfo> wordInfoArrayList){

        for (WordInfo wordInfo: wordInfoArrayList) {
            System.out.println("단어 : " + wordInfo.getWord());
            System.out.println("감성 타입 : " + wordInfo.getSentimentType().name());
            System.out.println("글 내에서의 위치 : " + wordInfo.getPositionAtText() + "%");
        }
    }

}
