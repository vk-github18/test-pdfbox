
            PDFont arimo0 = PDType0Font.load(
                    doc, this.getClass().getResourceAsStream("/fonts/arimo/Arimo-Regular.ttf"));

            return ((PDType0Font) pdFont).getCmapLookup().getGlyphId(codePoint) != 0;
            
            
            
            byte[] encoded0 = arimo0.encode("⁰");
            HexFormat.of().formatHex()
            System.out.println("Encoded String" + new String(encoded0, StandardCharsets.UTF_8));

            byte[] encoded = arimo.encode("⁰");
            System.out.println("Encoded String" + new String(encoded, StandardCharsets.UTF_8));
