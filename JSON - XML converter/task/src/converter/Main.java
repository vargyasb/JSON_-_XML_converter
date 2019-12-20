package converter;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        Converter converter;

        String input = reader.nextLine().trim();

        if (input.charAt(0) == '<') {
            converter = new XmlToJsonConverter();
            System.out.println(converter.convert(input));
        } else if (input.charAt(0) == '{') {
            converter = new JsonToXmlConverter();
            System.out.println(converter.convert(input));
        }

    }
}
