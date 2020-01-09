import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String stringWithHTMLTags = scanner.nextLine();

        // write your code here
        String regex = "<\\W*\\w.*?>";

        String stringWithoutHTMLTags = stringWithHTMLTags.replaceAll(regex, "");

        System.out.println(stringWithoutHTMLTags);

        //ref megoldas
        //stringWithHTMLTags = stringWithHTMLTags.replaceAll("<[^>]*>", "");
    }



//    Sample Input 1:
//
//    <h1>Simple header</h1>
//    Sample Output 1:
//
//    Simple header
//    Sample Input 2:
//
//    <h2>Header with <b>bold</b> text</h2>
//    Sample Output 2:
//
//    Header with bold text
}