package web.searcher;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class QueryTest {
    @Test
    public void get() {
        String originalQuery = "Hello Günter";
        Query query = new Query(originalQuery);
        assertEquals("Hello+G%C3%BCnter", query.get());
    }
}
