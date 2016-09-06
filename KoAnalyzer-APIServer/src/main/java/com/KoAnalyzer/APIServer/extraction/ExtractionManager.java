package com.KoAnalyzer.APIServer.extraction;

import com.twitter.penguin.korean.TwitterKoreanProcessorJava;
import com.twitter.penguin.korean.phrase_extractor.KoreanPhraseExtractor;
import com.twitter.penguin.korean.tokenizer.KoreanTokenizer;
import org.springframework.stereotype.Service;
import scala.collection.Seq;

import java.util.List;

/**
 * Created by parkjaesung on 2016. 9. 6..
 * Singleton Class
 * ExtractionManger works with ExtractionText class
 */
@Service
public class ExtractionManager {

    private static ExtractionManager instance = new ExtractionManager();

    public ExtractionManager(){

    }

    public static ExtractionManager getInstance(){
        return instance;
    }

    public ExtractionText extractText(ExtractionText extractionText){
        Seq<KoreanTokenizer.KoreanToken> tokens = TwitterKoreanProcessorJava.tokenize(extractionText.getOriginalText());
        List<KoreanPhraseExtractor.KoreanPhrase> phrases = TwitterKoreanProcessorJava.extractPhrases(tokens, true, true);

        extractionText.setPhrases(phrases);

        return extractionText;
    }
}

