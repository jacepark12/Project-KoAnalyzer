package com.analyze.ko.framework.korean.fileio;

import com.analyze.ko.framework.korean.DataClass.Document;
import com.analyze.ko.framework.korean.DataClass.SentimentTypeInterface;
import com.opencsv.CSVReader;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by parkjaesung on 2016. 7. 6..
 */
public class TextDataCSVReader implements SentimentTypeInterface{

    //set filePath in property file
    private static String filePath = System.getProperty("user.dir") + "/Kopinion-TestModule/src/main/resources/Document/textData.csv";

    private static TextDataCSVReader instance = new TextDataCSVReader();

    public static TextDataCSVReader getInstance(){
        return instance;
    }
    //private constructor
    private TextDataCSVReader() {
    }

    public ArrayList<Document> getTextDatasFromCSV() throws IOException {
        ArrayList<Document> result = new ArrayList();

        CSVReader csvReader = new CSVReader(new FileReader(filePath));

        String[] nextLine = null;
        while ((nextLine = csvReader.readNext()) != null) {
            System.out.println("READ!");
            Document document = new Document();

            document.setTextData(nextLine[0]);

            if (nextLine[1].equals("POS")) {
                document.setOriginalSentiment(SentimentType.POS);

            } else if (nextLine[1].equals("NEG")) {
                document.setOriginalSentiment(SentimentType.NEG);

            } else {
                document.setOriginalSentiment(SentimentType.NEUT);
            }

            //전처리 작업
            //특수문자 제거 및 textLength 설정
            document.removeSpecialChar();
            document.setTextLength();
            result.add(document);
        }
        return result;
    }
}
