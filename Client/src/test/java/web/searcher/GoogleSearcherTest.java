package web.searcher;

import org.junit.Assert;
import org.junit.Test;

public class GoogleSearcherTest {
    @Test
    public void search() {
        final int pages = 5;
        //TODO: Make a local page to test a search consistently.
        String expected = "https://www.hello.com/";
        GoogleSearcher searcher = new GoogleSearcher();
        Result actual = searcher.search(new Query("Hello"), pages);
        Assert.assertEquals(expected, actual.get(0));
    }
}
