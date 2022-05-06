import static org.junit.Assert.*;
import java.util.ArrayList;
import java.io.IOException;
import org.junit.*;
import java.nio.file.Files;
import java.nio.file.Path;

public class MarkdownParseTest {
    @Test
    public void addition() {
        assertEquals(2, 1 + 1);
    }

    @Test
    public void testGetLinks() {
        String toTest =
        "[link](https://rando.org/file-name) [link2](https://google.com) [link3](rando.gov)";
        ArrayList<String> expected = new ArrayList<>();
        expected.add("https://rando.org/file-name");
        expected.add("https://google.com");
        expected.add("rando.gov");
        ArrayList<String> result = MarkdownParse.getLinks(toTest);
        assertEquals(expected,result);
    }

    @Test
    public void testGetLinks5() throws IOException {
        MarkdownParse test = new MarkdownParse();

        Path fileName = Path.of("test-file2.md");
        String content = Files.readString(fileName);
        ArrayList<String> links = test.getLinks(content);
        ArrayList<String> expected = new ArrayList<>();
        expected.add("https://something.com");
        expected.add("some-page.html");

        assertEquals(expected,links);

    }
}

