package com.KoAnalyzer.APIServer.NLPManager;

import com.KoAnalyzer.APIServer.Phrase;
import com.twitter.penguin.korean.phrase_extractor.KoreanPhraseExtractor;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by parkjaesung on 2016. 9. 22..
 */
public class PhraseManagerImpl implements PhraseManagerInterface {
    @Override
    public List<Phrase> convertKoreanPhrase(List<KoreanPhraseExtractor.KoreanPhrase> phrases, String task) {

        ArrayList<Phrase> converted = new ArrayList<Phrase>();

        for (KoreanPhraseExtractor.KoreanPhrase phrase: phrases) {
            Phrase convertedPhrase = new Phrase();

            convertedPhrase.setText(phrase.text());
            convertedPhrase.setPos(phrase.pos().toString());
            convertedPhrase.setOffset(phrase.offset());
            convertedPhrase.setLength(phrase.length());
            convertedPhrase.setTask(task);

            converted.add(convertedPhrase);
        }

        return converted;
    }
}
