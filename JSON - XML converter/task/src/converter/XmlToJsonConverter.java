package converter;

public class XmlToJsonConverter implements Converter {
    @Override
    public String convert(String text) {

        //  <host>127.0.0.1</host> --> {"host":"127.0.0.1"}
        //  <success/> --> {"success": null }

        int emptyElementIndicator = text.indexOf("/>");
        String tag;
        String elementContent;

        if ( emptyElementIndicator == -1) {
            tag = text.substring(text.indexOf('<')+1,text.indexOf('>'));
            elementContent = "\"" + text.substring(text.indexOf('>')+1,text.indexOf("</")) + "\"";
        } else {
            tag = text.substring(text.indexOf("<")+1, emptyElementIndicator);
            elementContent = null;
        }


        return "{\"" + tag + "\":" + elementContent + "}";
    }
}
