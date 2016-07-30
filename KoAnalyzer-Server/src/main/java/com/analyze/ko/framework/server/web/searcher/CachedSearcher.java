package com.analyze.ko.framework.server.web.searcher;

public class CachedSearcher implements Searcher {
    private GoogleSearcher searcher = null;
    private Result cache = null;

    public CachedSearcher(GoogleSearcher searcher) {
        this.searcher = searcher;
    }

    @Override
    public Result search(Query query) {
        return search(query, 1);
    }

    @Override
    public Result search(Query query, int pages) {
        if (cache == null)
            cache = searcher.search(query, pages);
        return cache;
    }

    public Result cache() {
        return cache;
    }
}
