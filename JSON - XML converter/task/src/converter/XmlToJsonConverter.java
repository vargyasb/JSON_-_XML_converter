package converter;

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

        if (emptyElementIndicator == -1) {
            if (matcher.find()) {
                elementContent = "\"" + matcher.replaceAll("") + "\"";
                matcher = Pattern.compile("(?<=<)[0-9a-z]+", Pattern.CASE_INSENSITIVE).matcher(text);
                if (matcher.find()) {
                    tag = matcher.group();
                }
            }
        } else if (text.contains("\"")) {
            //ide
        } else {
            elementContent = null;
            matcher = Pattern.compile("(?<=)[0-9a-z]+").matcher(text);
            if (matcher.find()) {
                tag = matcher.group();
            }
        }

        return "{\"" + tag + "\":" + elementContent + "}";
    }
}
