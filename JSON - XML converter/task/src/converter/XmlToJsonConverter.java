package converter;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class XmlToJsonConverter implements Converter {
    @Override
    public String convert(String text) {

        //  <host>127.0.0.1</host> --> {"host":"127.0.0.1"}
        //  <success/> --> {"success": null }

//        int emptyElementIndicator = text.indexOf("/>");
//        String tag;
//        String elementContent;
//
//        if ( emptyElementIndicator == -1) {
//            tag = text.substring(text.indexOf('<')+1,text.indexOf('>'));
//            elementContent = "\"" + text.substring(text.indexOf('>')+1,text.indexOf("</")) + "\"";
//        } else {
//            tag = text.substring(text.indexOf("<")+1, emptyElementIndicator);
//            elementContent = null;
//        }
//
//
//        return "{\"" + tag + "\":" + elementContent + "}";
        Matcher matcher = Pattern.compile("<\\W*\\w.*?>", Pattern.CASE_INSENSITIVE).matcher(text);

        int emptyElementIndicator = text.indexOf("/>");
        String tag = "";
        String elementContent = "";
        Map<String, String> attributeMap = new LinkedHashMap<>();

        if (emptyElementIndicator == -1) { //ha nem empty xml tag, pl nem <employee/>
            if (!text.contains("\"")) { //ha nincs benne ", akkor nincs attribute
                if (matcher.find()) {
                    elementContent = "\"" + matcher.replaceAll("") + "\"";
                    matcher = Pattern.compile("(?<=<)[0-9a-z]+", Pattern.CASE_INSENSITIVE).matcher(text);
                    if (matcher.find()) {
                        tag = matcher.group();
                    }
                }
                return "{\"" + tag + "\":" + elementContent + "}";
            } else {//van benne attribute
                if (matcher.find()) {
                    elementContent = "\"" + matcher.replaceAll("") + "\"";
                    matcher = Pattern.compile("(?<=<)[0-9a-z]+", Pattern.CASE_INSENSITIVE).matcher(text);
                    if (matcher.find()) {
                        tag = matcher.group();
                    }
                    //((?<=\s)[0-9a-z]+|(?<=\s)".*?") elkapja az attribute es attribute value-kat
                    //<.*?(?<=\s)[0-9a-z]+.*?> replace a text-et csak a < > koze esore
                    matcher = Pattern.compile("<.*?(?<=\\s)[0-9a-z]+.*?>", Pattern.CASE_INSENSITIVE).matcher(text);
                    String tagWithAttributes = "";
                    if (matcher.find()) { tagWithAttributes = matcher.group(); }
                    matcher = Pattern.compile("((?<=\\s)[0-9a-z]+|(?<=\\s)\".*?\")", Pattern.CASE_INSENSITIVE).matcher(tagWithAttributes);
                    while (matcher.find()) {
                        attributeMap.put(matcher.group(),
                                matcher.find() ? matcher.group() : "");
                    }
                }
                return "{\"" + tag + "\": { " + printHashMap(attributeMap) + "\"#" + tag + "\" : " + elementContent + " } }";
            }
        } else { //ha empty xml tag, pl <employee/>
            if (!text.contains("\"")){ //ha nincs benne ", akkor nincs attribute
                matcher = Pattern.compile("(?<=)[0-9a-z]+").matcher(text);
                if (matcher.find()) {
                    tag = matcher.group();
                }
                return "{\"" + tag + "\":" + null + "}";
            } else { // van benne attribute
                matcher = Pattern.compile("(?<=)[0-9a-z]+").matcher(text);
                if (matcher.find()) {
                    tag = matcher.group();
                }
                matcher = Pattern.compile("((?<=\\s)[0-9a-z]+|(?<=\\s)\".*?\")", Pattern.CASE_INSENSITIVE).matcher(text);
                while (matcher.find()) {
                    attributeMap.put(matcher.group(),
                            matcher.find() ? matcher.group() : "");
                }
                return "{\"" + tag + "\": { " + printHashMap(attributeMap) + "\"#" + tag + "\" : " + null + " } }";
            }
        }
    }

    private String printHashMap(Map<String, String> map) {
        String returnVal = "";
        for (String key : map.keySet()) {
            returnVal += "\"@" + key + "\" : " + map.get(key) + ", ";
        }
        return returnVal;
    }
}
