package web.searcher;

import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class Result implements Iterator<URL> {
    private List<URL> data = null;
    private int index = 0;

    public Result(List<URL> searched) {
        data = searched;
    }

    @Override
    public URL next() {
        if (hasNext())
            return data.get(index++);
        else
            throw new NoSuchElementException("There are no elements size = " + data.size());
    }

    @Override
    public boolean hasNext() {
        return !(data.size() == index);
    }
}