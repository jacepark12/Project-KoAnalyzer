package text.korean;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

/**
 * Created by parkjaesung on 2016. 6. 30..
 */
public class TestKoreanTextTokenizer {

    @Test
    public void getPercentageOfPosition(){
        int wordPosition = 10;
        int textLength = 120;

        long expected = (long) 8.0;
        long result = KoreanTextTokenizer.getPercentageOfPosition(wordPosition, textLength);

        assertEquals(expected, result);
    }

}
