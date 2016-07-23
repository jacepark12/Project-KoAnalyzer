package web.searcher;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class ResultTest {
    private List<URL> expected;

    @Before
    public void setUp() {
        try {
            expected = new ArrayList<>();
            expected.add(new URL("http://www.A.com"));
            expected.add(new URL("http://www.B.com"));
        } catch (Exception e) {
        }
    }

    @Test
    public void next() {
        Result result = new Result(expected);
        Assert.assertEquals(expected.get(0), result.next());
        Assert.assertEquals(expected.get(1), result.next());
    }

    @Test(expected = NoSuchElementException.class)
    public void nextException() {
        Result result = new Result(expected);
        for (int i = 0; i <= expected.size(); i++) {
            result.next();
        }
    }

    @Test
    public void hasNext() {
        Result result = new Result(expected);
        result.next();
        result.next();

        Assert.assertFalse(result.hasNext());
    }
}
