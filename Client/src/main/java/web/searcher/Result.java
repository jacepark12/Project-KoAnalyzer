package web.searcher;

import java.util.ArrayList;
import java.util.List;

public class Result {
    private ArrayList<String> result = new ArrayList<String>();

    public Result(List<List<String>> searched) {
        for (List<String> list : searched) {
            result.addAll(list);
        }
    }

    public String get(int idx) {
        return result.get(idx);
    }

    public boolean has(int idx) {
        if (idx < 0 || idx >= result.size()) return false;
        return true;
    }
}