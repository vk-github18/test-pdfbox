Test of dictionary constructor for PDType0Font using PDType0Font.getCOSObject() to obtain a dictionary.
Using a constructor with an input stream everything works.

Using a constructor with a dictionary, the font is not correctly constructed.
The descendent font is set to a fallback font, descendantFont.ttf="LiberationSans"
getCmapLookup() returns null
Some characters are not supported, e.g. "\u2070"
       
