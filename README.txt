
setUp()
            PDType0Font fontInputStream = PDType0Font.load(
                    doc, this.getClass().getResourceAsStream("/fonts/arimo/Arimo-Regular.ttf"));
            PDType0Font fontDictionary = new PDType0Font(fontInputStream.getCOSObject());
            int codePoint = 0x2070;

testCmapLookupIsNotNullForFontCreatedWithInputStream
            assertNotNull(fontInputStream.getCmapLookup());

testCmapLookupIsNotNullForFontCreatedWithDictionary
            assertNotNull(fontInputStream.getCmapLookup());
            
            
testArimoContainsU2070ForFontCreatedWithInputStream 
        assertDoesNotThrow(() -> fontInputStream.encode("\u2070"));


testArimoContainsU2070ForFontCreatedWithDictionary
        assertDoesNotThrow(() -> fontDictionary.encode("\u2070"));

