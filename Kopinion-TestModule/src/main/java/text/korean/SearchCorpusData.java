package text.korean;

import com.opencsv.CSVReader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by parkjaesung on 2016. 6. 29..
 */
public class SearchCorpusData{

    //set filePath in property file
    private static String filePath = System.getProperty("user.dir") + "/Kopinion-TestModule/src/main/resources/TextData/corpus.csv";

    //private CSVReader reader;
    private static SearchCorpusData instance =  new SearchCorpusData();

    //constructor
    private SearchCorpusData(){
/*
        try {
            this.reader = new CSVReader(new FileReader(filePath));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }*/
    }

    public static SearchCorpusData getInstance(){
        return instance;
    }


    //true : if word has positive sentiment
    //false : if word has negative sentiment
    //리팩토링 필요 : 긍정이 아니면 무조건 false이므로, 중립적인단어임에도 불구하고 부정으로 판별될 수 있음
    // TODO What if there is no word data in corpus?
    public boolean isWordPositive(CharSequence word)throws IOException{
        CSVReader reader = new CSVReader(new FileReader(filePath));

        System.out.println("isWordPositive!");
        boolean result = false;
        String[] nextLine;

        boolean isWordDataExists = false;

        while ((nextLine = reader.readNext()) != null) {
            // nextLine[] is an array of values from the line
            //System.out.println("단어 : " + nextLine[3]);
            if(nextLine[2].equals("Seed")){
                if(nextLine[3].matches(".*"+word +"*.") || nextLine[13].contains(word)){
                    System.out.println("긍정 혹은 부정 : " + nextLine[6]);

                    isWordDataExists = true;

                    switch (nextLine[6]){
                        case "POS" : result = true;
                            break;
                        case "NEG" : result = false;
                            break;
                        default: result = false;

                    }
                    break;
                }
        }else if(nextLine[2].equals("SubjTag")){
                if(nextLine[3].matches(".*"+word +"*.") || nextLine[13].contains(word)){
                    System.out.println("긍정 혹은 부정 : " + nextLine[7]);

                    isWordDataExists = true;

                    switch (nextLine[7]){
                        case "POS" : result = true;
                            break;
                        case "NEG" : result = false;
                            break;
                        default: result = false;

                    }
                    break;
                }
            }

        }

        if(!isWordDataExists){
            System.out.println(word.toString() + " 데이터가 검색되지 않음!");
        }else{
            System.out.println("데이터 있음!!");
        }

        return result;

    }
}
