import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String codeWithComments = scanner.nextLine();

        // write your code here
        String regex = "(/\\*.*?\\*/|/\\*.*?\\*\\*/|//.*)";

        System.out.println(codeWithComments.replaceAll(regex, ""));

        //ref megoldas
        //System.out.println(codeWithComments.replaceAll("/\\*.*?\\*/", "").replaceAll("//.*$", ""));
    }
}