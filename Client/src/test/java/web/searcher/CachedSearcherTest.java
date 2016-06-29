package web.searcher;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class CachedSearcherTest {
    @Test
    public void search() {
        String expected = "https://www.hello.com/";
        CachedSearcher cachedSearcher = new CachedSearcher(new GoogleSearcher());
        Result actual = cachedSearcher.search(new Query("Hello"));
        Assert.assertEquals(expected, actual.next());
    }

    @Test
    public void cache() {
        String expected = "https://www.hello.com/";
        CachedSearcher cachedSearcher = new CachedSearcher(new GoogleSearcher());
        cachedSearcher.search(new Query("Hello"));
        Result actual = cachedSearcher.cache();
        Assert.assertEquals(expected, actual.next());
    }
}
