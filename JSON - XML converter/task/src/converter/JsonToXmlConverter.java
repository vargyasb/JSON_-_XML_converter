package converter;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JsonToXmlConverter implements Converter {
    @Override
    public String convert(String text) {

        //  {"jdk" : "1.8.9"} --> <jdk>1.8.9</jdk>
        //  { "storage" : null } --> <storage/>

//        int keysFirstDoubleQuote = text.indexOf("\"");
//        int keysSecondDoubleQuote = text.indexOf("\"",keysFirstDoubleQuote+1);
//        String key = text.substring(keysFirstDoubleQuote+1,keysSecondDoubleQuote);
//
//        int emptyValueIndicator = text.indexOf("\"",keysSecondDoubleQuote+1);
//
//        String value;
//        int valuesFirstDoubleQuote;
//        String openingTag;
//        String closingTag;
//        if (emptyValueIndicator == -1) {
//            openingTag = "<" + key + "/>";
//            value = "";
//            closingTag = "";
//        } else {
//            String newText = text.substring(emptyValueIndicator);
//
//            valuesFirstDoubleQuote = newText.indexOf("\"");
//            value = newText.substring(valuesFirstDoubleQuote+1,
//                                        newText.indexOf("\"", valuesFirstDoubleQuote+1));
//
//            openingTag = "<" + key + ">";
//            closingTag = "</" + key + ">";
//        }
//
//        return openingTag + value + closingTag;

        String value = "";
        String openingTag = "";
        String closingTag = "";
        Map<String, String> attributeMap = new LinkedHashMap<>();

        Matcher matcher = Pattern.compile("(?<=\")[0-9a-z]+", Pattern.CASE_INSENSITIVE).matcher(text);

        if (!text.contains("null")) {
            if (!text.contains("@")){ // ha nincs benne @, akkor nincs attribute
                if (matcher.find()) {
                    openingTag = "<" + matcher.group() + ">";
                    closingTag = "</" + matcher.group() + ">";
                    value = text.replaceAll("\\{\"\\w*\\W.*?\"", "").replaceAll("\"}", "");
                }
                return openingTag + value + closingTag;
            } else {
                if (matcher.find()) {
                    openingTag = "<" + matcher.group();
                    closingTag = "</" + matcher.group() + ">";
                    //regex levagni az attribute reszt
                    matcher = Pattern.compile(":\\s*\\{.*\"#", Pattern.CASE_INSENSITIVE).matcher(text);
                    String tagWithAttributes = "";
                    if (matcher.find()) { tagWithAttributes = matcher.group(); }
                    //regex splittelni az attribute reszt key-value parokra ((?<=\s)[0-9a-z]+|(?<=\s)".*?")
                    matcher = Pattern.compile("((?<=)[0-9a-z]+|(?<=\\s)\".*?\")", Pattern.CASE_INSENSITIVE).matcher(tagWithAttributes);
                    while (matcher.find()) {
                        String attribute = matcher.group().replaceAll("@", "").replaceAll("\"", "");
                        matcher.find();
                        String attributeValue = matcher.group();
                        if (matcher.group().matches("\\d*")){
                            attributeValue = "\"" + attributeValue + "\"";
                        }
                        attributeMap.put(attribute, attributeValue);
                    }
                    //{.*?"\w*\W.*?#\w*"\W* regex levagni a value reszt
                    //".*" levagni a veget
                    value = text.replaceAll("\\{.*?\"\\w*\\W.*?#\\w*\"\\W*", "").replaceAll("\"*}*", "");
                }
                return openingTag + printHashMap(attributeMap) + ">" + value + closingTag;
            }
        } else {
            if (!text.contains("@")){// ha nincs benne @, akkor nincs attribute
                if (matcher.find()) {
                    openingTag = "<" + matcher.group() + "/>";
                }
                return openingTag + value + closingTag;
            } else {
                if (matcher.find()) {
                    openingTag = "<" + matcher.group();
                    //regex levagni az attribute reszt
                    matcher = Pattern.compile(":\\s*\\{.*\"#", Pattern.CASE_INSENSITIVE).matcher(text);
                    String tagWithAttributes = "";
                    if (matcher.find()) { tagWithAttributes = matcher.group(); }
                    //regex splittelni az attribute reszt key-value parokra
                    matcher = Pattern.compile("((?<=)[0-9a-z]+|(?<=\\s)\".*?\")", Pattern.CASE_INSENSITIVE).matcher(tagWithAttributes);
                    while (matcher.find()) {
                        String attribute = matcher.group().replaceAll("@", "").replaceAll("\"", "");
                        matcher.find();
                        String attributeValue = matcher.group();
                        if (attributeValue.matches("\\d*")){
                            attributeValue = "\"" + attributeValue + "\"";
                        }
                        attributeMap.put(attribute, attributeValue);
                    }
                }
                return openingTag + printHashMap(attributeMap) + "/>";
            }
        }

    }

    private String printHashMap(Map<String, String> map) {
        String returnVal = "";
        for (String key : map.keySet()) {
            returnVal += " " + key + " = " + map.get(key);
        }
        return returnVal;
    }
}
