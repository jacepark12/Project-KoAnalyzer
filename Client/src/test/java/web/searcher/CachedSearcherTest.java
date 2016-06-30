package web.searcher;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class CachedSearcherTest {
    private String expected;
    private Result actual;
    private CachedSearcher cachedSearcher;

    @Before
    public void setUp() {
        expected = "https://www.hello.com/";

        cachedSearcher = new CachedSearcher(new GoogleSearcher());
        actual = cachedSearcher.search(new Query("Hello"));
    }

    @Test
    public void search() {
        Assert.assertEquals(expected, actual.next());
    }

    @Test
    public void cache() {
        Assert.assertEquals(expected, cachedSearcher.cache().next());
    }
}
