package text.korean.fileio;

import com.opencsv.CSVWriter;
import text.korean.DataClass.SentimentTypeInterface;
import text.korean.DataClass.WordInfo;

import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

/**
 * Created by parkjaesung on 2016. 6. 30..
 */
public class WordInfoCSVWriter implements SentimentTypeInterface{

    //set filePath in property file
    private static String filePath = System.getProperty("user.dir") + "/Kopinion-TestModule/src/main/resources/OutPutResources/SummaryGraph.csv";

    private static WordInfoCSVWriter instance = new WordInfoCSVWriter();

    //private constructor
    private WordInfoCSVWriter(){

    }

    public static WordInfoCSVWriter getInstance(){
        return instance;
    }

    //OutPut Format
    /*
    (%) 10,20,30,40,50,60,70,80,90,100
    (긍정 개수) 25,50,50.5,44.5,53.5,49,54,66,59,68,54
    (부정 개수) 24,31,26,30.5,38,37,52,63,59,64.5,43
    (중립 개수) 22,23.5,25.5,29.5,32,32,37,49,42,55,37
    */
    public void exportWordInfoToCVS(ArrayList<WordInfo> wordInfoArrayList){

        CSVWriter csvWriter = null;

        int posCount[] = new int[11];
        int negCount[] = new int[11];
        int neutCount[] = new int[11];

        //% 기본 입력
        try {
            csvWriter = new CSVWriter(new FileWriter(filePath));
        } catch (IOException e) {
            e.printStackTrace();
        }

        assert csvWriter != null;
        csvWriter.writeNext(new String[] {"0", "10", "20", "30", "40", "50", "60", "70", "80", "90", "100"});

        for (WordInfo wordInfo: wordInfoArrayList) {
            if(wordInfo.getSentimentType().equals(SentimentType.POS)){
                posCount[wordInfo.getPositionAtText()/10] ++;
            }else if(wordInfo.getSentimentType().equals(SentimentType.NEG)){
                negCount[wordInfo.getPositionAtText()/10] ++;
            }else if(wordInfo.getSentimentType().equals(SentimentType.NEUT)){
                neutCount[wordInfo.getPositionAtText()/10] ++;
            }

        }

        String[] posString = new String[11];

        for(int i = 0; i<11 ;i++){
            posString[i] = String.valueOf(posCount[i]);
        }

        csvWriter.writeNext(posString);


        String[] negString = new String[11];

        for(int i = 0; i<11 ;i++){
            negString[i] = String.valueOf(negCount[i]);
        }

        csvWriter.writeNext(negString);


        String[] neutString = new String[11];

        for(int i = 0; i<11 ;i++){
            neutString[i] = String.valueOf(neutCount[i]);
        }

        csvWriter.writeNext(neutString);

        try {
            csvWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
