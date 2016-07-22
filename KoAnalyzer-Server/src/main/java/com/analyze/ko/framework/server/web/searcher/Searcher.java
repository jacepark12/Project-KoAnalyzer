package com.analyze.ko.framework.server.web.searcher;

public interface Searcher {
    public Result search(Query query);
    public Result search(Query query, int pages);
}
