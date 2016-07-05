package text.korean.DataClass;

import java.util.ArrayList;

/**
 * Created by parkjaesung on 2016. 7. 2..
 */
public class WordDistributionManager {

    private static WordDistributionManager instance = new WordDistributionManager();
    private ArrayList<WordDistribution> wordDistributionArrayList = new ArrayList<>();

    public static WordDistributionManager getInstance(){
        return instance;
    }

}
