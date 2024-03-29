package com.analyze.ko.framework.korean.fileio;

import com.analyze.ko.framework.korean.DataClass.SentimentTypeInterface;
import com.analyze.ko.framework.korean.DataClass.WordInfo;
import com.opencsv.CSVWriter;


import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by parkjaesung on 2016. 6. 30..
 */
public class WordInfoCSVWriter implements SentimentTypeInterface {

    //set filePath in property file
    private static String filePath = System.getProperty("user.dir") + "/Kopinion-TestModule/src/main/resources/OutPutResources/";

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

    //ArrayList wordInfos should be sorted by density
    public void exportDensityToCSV(ArrayList<WordInfo> wordInfos) {

        int outputNum = 20; //20개만 출력

        CSVWriter csvWriter = null;

        try {
            csvWriter = new CSVWriter(new FileWriter(filePath + "WordDensity.csv"));
        } catch (IOException e) {
            e.printStackTrace();

        }
        assert csvWriter != null;

        //Word Density Sentiment -> 기본 형식
        csvWriter.writeNext(new String[] {"Word", "Density", "Sentiment"});

        int count = 0;
        for (WordInfo wordInfo: wordInfos) {
            if(count == outputNum)
                break;

            if(!wordInfo.getSentimentType().toString().equals("NEUT")){
            csvWriter.writeNext(new String[] {wordInfo.getWord(), String.valueOf(wordInfo.getDensity()), wordInfo.getSentimentType().toString()});
            count++;
            }
        }

        try {
            csvWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void exportPositionToCSV(ArrayList<WordInfo> wordInfos){

        CSVWriter csvWriter = null;

        int posCount[] = new int[11];
        int negCount[] = new int[11];
        int neutCount[] = new int[11];

        //% 기본 입력
        try {
            csvWriter = new CSVWriter(new FileWriter(filePath+ "SummaryGraph.csv"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        assert csvWriter != null;
        csvWriter.writeNext(new String[] {"0", "10", "20", "30", "40", "50", "60", "70", "80", "90", "100"});

        for (WordInfo wordInfo : wordInfos) {
            if(wordInfo.getSentimentType().equals(SentimentType.POS)){
                posCount[wordInfo.getPosAtTextPerCentage()/10] ++;
            }else if(wordInfo.getSentimentType().equals(SentimentType.NEG)){
                negCount[wordInfo.getPosAtTextPerCentage()/10] ++;
            }else if(wordInfo.getSentimentType().equals(SentimentType.NEUT)){
                neutCount[wordInfo.getPosAtTextPerCentage()/10] ++;
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
