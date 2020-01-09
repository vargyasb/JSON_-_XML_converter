import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String part = scanner.nextLine();
        String line = scanner.nextLine();

        //ref megoldás
        //Pattern pattern = Pattern.compile("(?i)\\b[a-z]+" + part + "[a-z]+\\b");
        // write your code here
        Pattern pattern = Pattern.compile(".*\\S" + part + "\\S.*", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(line);

        System.out.println(matcher.matches() ? "YES" : "NO");

    }
}