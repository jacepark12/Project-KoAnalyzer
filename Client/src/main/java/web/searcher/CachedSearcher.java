package web.searcher;

import java.util.ArrayList;
import java.util.List;

public class CachedSearcher {
    private GoogleSearcher searcher = null;
    private ArrayList<String> cache = new ArrayList<String>();

    public CachedSearcher(GoogleSearcher searcher) {
        this.searcher = searcher;
    }

    public List<List<String>> search(Query q) {
        List<List<String>> result = searcher.search(q);
        for (List<String> list : result) {
            cache.addAll(list);
        }
        return result;
    }

    public List<String> cache() {
        return (List<String>)(cache.clone());
    }
}
