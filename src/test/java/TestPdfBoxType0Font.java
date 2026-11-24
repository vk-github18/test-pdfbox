
import java.awt.FontFormatException;
import java.io.IOException;
import java.io.InputStream;
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
        try {
            InputStream is = this.getClass().getResourceAsStream("ttf/Arimo-Regular.ttf");
            PDType0Font font = PDType0Font.load(doc, is);
            return font;
        } catch (IOException e) {
            e.printStackTrace();
            throw e;
        }
    }

    PDType0Font loadFontDictionary() throws IOException, FontFormatException, URISyntaxException {
        PDType0Font font = new PDType0Font(loadFontInputStream().getCOSObject());
        return font;
        // Nov. 24, 2026 10:57:59 PM org.apache.pdfbox.pdmodel.font.PDCIDFontType2 findFontOrSubstitute
        // WARNUNG: Using fallback font LiberationSans for CID-keyed TrueType font Arimo-Regular
        // descendantFont.ttf="LiberationSans"
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