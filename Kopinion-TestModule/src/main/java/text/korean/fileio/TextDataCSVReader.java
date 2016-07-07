package text.korean.fileio;

import com.opencsv.CSVReader;
import text.korean.DataClass.SentimentTypeInterface;
import text.korean.DataClass.TextData;

import javax.xml.soap.Text;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
        ArrayList<TextData> result = new ArrayList<>();

        CSVReader csvReader = new CSVReader(new FileReader(filePath));

        String[] nextLine = null;
        while ((nextLine = csvReader.readNext()) != null) {
            System.out.println("READ!");
            TextData textData = new TextData();

            textData.setTextData(nextLine[0]);

            switch (nextLine[1])
            {
                case "POS" :
                    textData.setSentimentType(SentimentType.POS);
                    break;
                case "NEG" :
                    textData.setSentimentType(SentimentType.NEG);
                    break;
                default:
                    textData.setSentimentType(SentimentType.NEUT);
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
