package web.searcher;

import static org.junit.Assert.*;
import org.junit.Test;

import java.util.List;

public class GoogleSearcherTest {
    @Test
    public void search() {
        final int pages = 5;
        //TODO: Make a local page to test a search consistently.
        String expected = "http://www.hellomagazine.com/";
        GoogleSearcher searcher = new GoogleSearcher();
        List<List<String>> searched = searcher.search(new Query("Hello"), pages);
        assertEquals(expected, searched.get(0).get(0));
    }
}
