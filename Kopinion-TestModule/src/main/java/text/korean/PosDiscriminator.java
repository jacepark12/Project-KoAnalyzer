package text.korean;

import com.twitter.penguin.korean.tokenizer.KoreanTokenizer;

/**
 * Created by parkjaesung on 2016. 6. 29..
 */

//TODO Put Method into other classes
public class PosDiscriminator {

    public enum Pos{Noun, Adverb, Adjective};

    //private constructor
    private PosDiscriminator() {

    }

    public static boolean isSentimentWord(KoreanTokenizer.KoreanToken input){
        String pos = input.pos().toString();
        boolean result = false;

        if(pos.equals("Adverb") || pos.equals("Adjective")){
            result = true;
        }

        return result;
    }

}
