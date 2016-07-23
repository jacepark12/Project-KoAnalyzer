package web;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class DocumentTest {
    @Test
    public void withoutTags() {
        //TODO: Replace <br> with \n.
        Document expected = new Document("Sentence 1Sentence 2");
        Document with = new Document(
            "<div id=\"id\"><p>Sentence 1<br>Sentence 2</p></div>"
        );
        Document without = with.withoutTags();
        assertEquals(expected.toString(), without.toString());
    }
}
