package text.korean;

import com.twitter.penguin.korean.KoreanPosJava;
import com.twitter.penguin.korean.TwitterKoreanProcessorJava;
import com.twitter.penguin.korean.phrase_extractor.KoreanPhraseExtractor;
import com.twitter.penguin.korean.tokenizer.KoreanTokenizer;
import scala.collection.Seq;

import java.io.IOException;
import java.util.List;

/**
 * Created by parkjaesung on 2016. 6. 29..
 */
public class KoreanTextExample {
    public static void main(String[] args) {
        String text = "박근혜는 너무 나쁘다";

        // Normalize
        CharSequence normalized = TwitterKoreanProcessorJava.normalize(text);
        System.out.println(normalized);
        // 한국어를 처리하는 예시입니다ㅋㅋ #한국어


        // Tokenize
        Seq<KoreanTokenizer.KoreanToken> tokens = TwitterKoreanProcessorJava.tokenize(normalized);
        System.out.println(TwitterKoreanProcessorJava.tokensToJavaStringList(tokens));
        // [한국어, 를, 처리, 하는, 예시, 입니, 다, ㅋㅋ, #한국어]
        System.out.println(TwitterKoreanProcessorJava.tokensToJavaKoreanTokenList(tokens));
        // [한국어(Noun: 0, 3), 를(Josa: 3, 1),  (Space: 4, 1), 처리(Noun: 5, 2), 하는(Verb: 7, 2),  (Space: 9, 1), 예시(Noun: 10, 2), 입니(Adjective: 12, 2), 다(Eomi: 14, 1), ㅋㅋ(KoreanParticle: 15, 2),  (Space: 17, 1), #한국어(Hashtag: 18, 4)]


        // Stemming
        Seq<KoreanTokenizer.KoreanToken> stemmed = TwitterKoreanProcessorJava.stem(tokens);
        System.out.println(TwitterKoreanProcessorJava.tokensToJavaStringList(stemmed));
        // [한국어, 를, 처리, 하다, 예시, 이다, ㅋㅋ, #한국어]
        System.out.println(TwitterKoreanProcessorJava.tokensToJavaKoreanTokenList(stemmed));
        // [한국어(Noun: 0, 3), 를(Josa: 3, 1),  (Space: 4, 1), 처리(Noun: 5, 2), 하다(Verb: 7, 2),  (Space: 9, 1), 예시(Noun: 10, 2), 이다(Adjective: 12, 3), ㅋㅋ(KoreanParticle: 15, 2),  (Space: 17, 1), #한국어(Hashtag: 18, 4)]


        // Phrase extraction
        List<KoreanPhraseExtractor.KoreanPhrase> phrases = TwitterKoreanProcessorJava.extractPhrases(tokens, true, true);
        System.out.println(phrases);
        // [한국어(Noun: 0, 3), 처리(Noun: 5, 2), 처리하는 예시(Noun: 5, 7), 예시(Noun: 10, 2), #한국어(Hashtag: 18, 4)]

        KoreanPhraseExtractor.KoreanPhrase testObject = phrases.get(0);

        System.out.println("pos :" + testObject.pos());

        if(testObject.pos().toString().equals("Noun")){
            System.out.println("this is noun");
        }

        System.out.println("text : " + testObject.text());
        System.out.println("tokens : " + testObject.tokens());

        StringBuffer stringBuffer = new StringBuffer("문제");
        try {
            SearchCorpusData.isNegOrPos(stringBuffer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
