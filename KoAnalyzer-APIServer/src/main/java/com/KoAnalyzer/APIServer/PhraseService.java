package com.KoAnalyzer.APIServer;

import org.springframework.stereotype.Service;
import sun.util.PreHashedMap;

import java.util.List;

/**
 * Created by parkjaesung on 2016. 9. 16..
 */
@Service
public interface PhraseService {
    void savePhrase(Phrase phrase);
    void savePhrases(List<Phrase> phrases);
    List<Phrase> findAll();
    List<Phrase> findByTask();
    void deletePhrase(Phrase phrase);
}
