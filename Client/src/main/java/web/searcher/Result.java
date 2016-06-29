package web.searcher;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Result {
    private List<String> result = null;

    public Result(List<String> searched) {
        result = searched;
    }

    public String get(int idx) {
        return result.get(idx);
    }

    public boolean has(int idx) {
        if (idx < 0 || idx >= result.size()) return false;
        return true;
    }
}