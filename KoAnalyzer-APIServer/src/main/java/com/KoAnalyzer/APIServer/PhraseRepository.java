package com.KoAnalyzer.APIServer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

/**
 * Created by parkjaesung on 2016. 9. 16..
 */
public interface PhraseRepository extends JpaRepository<Phrase, Long>{
}
