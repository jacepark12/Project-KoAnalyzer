package web.searcher;

import java.util.ArrayList;
import java.util.List;

public class CachedSearcher {
    private GoogleSearcher searcher = null;
    private Result cache = null;

    public CachedSearcher(GoogleSearcher searcher) {
        this.searcher = searcher;
    }

    public Result search(Query q) {
        return cache = searcher.search(q);
    }

    public Result cache() {
        return cache;
    }
}
