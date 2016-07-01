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
        boolean result = true;

        //대명사 조사 등 제외
        if(input.text().length()==1 || pos.contains("Number")||pos.contains("Punctuation")||pos.contains("Alpha")||pos.contains("Space")||pos.contains("Josa") || pos.contains("Eomi") || pos.contains("ProperNoun")){
            result = false;
        }

        return result;
    }

}
