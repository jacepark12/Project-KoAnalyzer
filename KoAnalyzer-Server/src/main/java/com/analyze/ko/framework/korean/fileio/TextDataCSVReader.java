package com.analyze.ko.framework.korean.fileio;

import com.analyze.ko.framework.korean.DataClass.SentimentTypeInterface;
import com.opencsv.CSVReader;
import com.analyze.ko.framework.korean.DataClass.TextData;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by parkjaesung on 2016. 7. 6..
 */
public class TextDataCSVReader implements SentimentTypeInterface{

    //set filePath in property file
    private static String filePath = System.getProperty("user.dir") + "/Kopinion-TestModule/src/main/resources/TextData/textData.csv";

    private static TextDataCSVReader instance = new TextDataCSVReader();

    public static TextDataCSVReader getInstance(){
        return instance;
    }
    //private constructor
    private TextDataCSVReader() {
    }

    public ArrayList<TextData> getTextDatasFromCSV() throws IOException {
        ArrayList<TextData> result = new ArrayList();

        CSVReader csvReader = new CSVReader(new FileReader(filePath));

        String[] nextLine = null;
        while ((nextLine = csvReader.readNext()) != null) {
            System.out.println("READ!");
            TextData textData = new TextData();

            textData.setTextData(nextLine[0]);

            if (nextLine[1].equals("POS")) {
                textData.setOriginalSentiment(SentimentType.POS);

            } else if (nextLine[1].equals("NEG")) {
                textData.setOriginalSentiment(SentimentType.NEG);

            } else {
                textData.setOriginalSentiment(SentimentType.NEUT);
            }

            //전처리 작업
            //특수문자 제거 및 textLength 설정
            textData.removeSpecialChar();
            textData.setTextLength();
            result.add(textData);
        }
        return result;
    }
}
