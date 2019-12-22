package converter;

public class JsonToXmlConverter implements Converter {
    @Override
    public String convert(String text) {

        //  {"jdk" : "1.8.9"} --> <jdk>1.8.9</jdk>
        //  { "storage" : null } --> <storage/>

        int keysFirstDoubleQuote = text.indexOf("\"");
        int keysSecondDoubleQuote = text.indexOf("\"",keysFirstDoubleQuote+1);
        String key = text.substring(keysFirstDoubleQuote+1,keysSecondDoubleQuote);

        int emptyValueIndicator = text.indexOf("\"",keysSecondDoubleQuote+1);

        String value;
        int valuesFirstDoubleQuote;
        String openingTag;
        String closingTag;
        if (emptyValueIndicator == -1) {
            openingTag = "<" + key + "/>";
            value = "";
            closingTag = "";
        } else {
            String newText = text.substring(emptyValueIndicator);

            valuesFirstDoubleQuote = newText.indexOf("\"");
            value = newText.substring(valuesFirstDoubleQuote+1,
                                        newText.indexOf("\"", valuesFirstDoubleQuote+1));

            openingTag = "<" + key + ">";
            closingTag = "</" + key + ">";
        }

        return openingTag + value + closingTag;
    }
}
