package com.analyze.ko.framework.server.web.searcher;

import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class Result implements Iterator<String> {
    private List<String> data = null;
    private int index = 0;

    public Result(List<String> searched) {
        data = searched;
    }

    public String next() {
        if (hasNext())
            return data.get(index++);
        else
            throw new NoSuchElementException("There are no elements size = " + data.size());
    }

    public boolean hasNext() {
        return !(data.size() == index);
    }
}