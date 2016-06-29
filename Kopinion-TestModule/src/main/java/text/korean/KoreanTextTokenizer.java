package text.korean;

import com.twitter.penguin.korean.TwitterKoreanProcessorJava;
import com.twitter.penguin.korean.tokenizer.KoreanTokenizer;
import scala.collection.Iterable;
import scala.collection.Seq;
import scala.collection.convert.WrapAsJava;
import scala.collection.convert.WrapAsJava$;

import java.util.List;

/**
 * Created by parkjaesung on 2016. 6. 29..
 */
public class KoreanTextTokenizer {

    private static String text = "박근혜는 너무 나쁘다";
    public static void main(String[] args){

        // Normalize
        CharSequence normalized = TwitterKoreanProcessorJava.normalize(text);
        System.out.println(normalized);

        // Tokenize
        Seq<KoreanTokenizer.KoreanToken> tokens = TwitterKoreanProcessorJava.tokenize(normalized);
        System.out.println(TwitterKoreanProcessorJava.tokensToJavaStringList(tokens));
        // [한국어, 를, 처리, 하는, 예시, 입니, 다, ㅋㅋ, #한국어]
        System.out.println(TwitterKoreanProcessorJava.tokensToJavaKoreanTokenList(tokens));
        // [한국어(Noun: 0, 3), 를(Josa: 3, 1),  (Space: 4, 1), 처리(Noun: 5, 2), 하는(Verb: 7, 2),  (Space: 9, 1), 예시(Noun: 10, 2), 입니(Adjective: 12, 2), 다(Eomi: 14, 1), ㅋㅋ(KoreanParticle: 15, 2),  (Space: 17, 1), #한국어(Hashtag: 18, 4)]

        List test = convertToList(tokens);
        for (Object textToken: test
             ) {
            System.out.println(textToken.toString());
        }
    }

    private static java.util.List<KoreanTokenizer.KoreanToken> convertToList(scala.collection.Seq<KoreanTokenizer.KoreanToken> seq) {
        return WrapAsJava$.MODULE$.seqAsJavaList(seq);
    }

}


