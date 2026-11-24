
import java.awt.FontFormatException;
import java.io.IOException;
import java.net.URISyntaxException;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertNotNull;


import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.font.PDType0Font;

/**
 *
 */
class TestPdfBoxType0Font {

    PDType0Font loadFontInputStream() throws IOException, FontFormatException, URISyntaxException {
        PDDocument doc = new PDDocument();
        return PDType0Font.load(
                doc, this.getClass().getResourceAsStream("/ttf/Arimo-Regular.ttf"));
    }

    PDType0Font loadFontDictionary() throws IOException, FontFormatException, URISyntaxException {
        return new PDType0Font(loadFontInputStream().getCOSObject());
    }

    @Test
    void testCmapLookupIsNotNullForFontCreatedWithInputStream() throws IOException, FontFormatException, URISyntaxException {
        assertNotNull(loadFontInputStream().getCmapLookup());
    }

    @Test
    void testCmapLookupIsNotNullForFontCreatedWithDictionary() throws IOException, FontFormatException, URISyntaxException {
        assertNotNull(loadFontDictionary().getCmapLookup());
    }

    @Test
    void testArimoContainsU2070ForFontCreatedWithInputStream() throws IOException, FontFormatException, URISyntaxException {
        assertDoesNotThrow(() -> loadFontInputStream().encode("\u2070"));
    }

    @Test
    void testArimoContainsU2070ForFontCreatedWithDictionary() throws IOException, FontFormatException, URISyntaxException {
        assertDoesNotThrow(() -> loadFontDictionary().encode("\u2070"));
    }
}