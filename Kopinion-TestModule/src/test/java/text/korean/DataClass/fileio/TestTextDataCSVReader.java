package text.korean.DataClass.fileio;

import text.korean.DataClass.TextData;
import text.korean.fileio.TextDataCSVReader;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by parkjaesung on 2016. 7. 6..
 */
public class TestTextDataCSVReader {

    public static void main(String[] args){
        TextDataCSVReader textDataCSVReader = TextDataCSVReader.getInstance();
        ArrayList<TextData> textDatas = null;
        try {
            textDatas = textDataCSVReader.getTextDatasFromCSV();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(textDatas.size());

    }
}
