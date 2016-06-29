package text.korean;

import com.opencsv.CSVReader;

import java.io.FileReader;
import java.io.IOException;

/**
 * Created by parkjaesung on 2016. 6. 29..
 */
public class SearchCorpusData{

    //set filePath in property file
    private static String filePath = System.getProperty("user.dir") + "/Kopinion-TestModule/src/main/resources/TextData/corpus.csv";

    public static void isNegOrPos(CharSequence word) throws IOException{
        System.out.println(filePath);

        CSVReader reader = new CSVReader(new FileReader(filePath));
        String[] nextLine;
        while ((nextLine = reader.readNext()) != null) {
            // nextLine[] is an array of values from the line
            //System.out.println("단어 : " + nextLine[3]);

            if(nextLine[3].contains(word)){
                System.out.println("긍정 혹은 부정 : " + nextLine[6]);
            }
        }
    }
}
