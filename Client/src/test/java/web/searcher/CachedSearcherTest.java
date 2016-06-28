package web.searcher;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class CachedSearcherTest {
    @Test
    public void search() {
        String expected = "https://www.hello.com/";
        CachedSearcher cachedSearcher = new CachedSearcher(new GoogleSearcher());
        List<List<String>> actual = cachedSearcher.search(new Query("Hello"));
        Assert.assertEquals(expected, actual.get(0).get(0));
    }

    @Test
    public void cache() {
        String expected = "https://www.hello.com/";
        CachedSearcher cachedSearcher = new CachedSearcher(new GoogleSearcher());
        cachedSearcher.search(new Query("Hello"));
        List<String> actual = cachedSearcher.cache();
        Assert.assertEquals(expected, actual.get(0));
    }
}
