import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();

        // write your code here
        Matcher matcher = Pattern.compile("password\\W*[a-zA-Z0-9]*", Pattern.CASE_INSENSITIVE).matcher(text);

        boolean noPassword = true;
        while (matcher.find()){
            noPassword = false;
            Matcher helperMatcher = Pattern.compile("password\\W*", Pattern.CASE_INSENSITIVE).matcher(matcher.group());
            if (helperMatcher.find()){ // kell a find kulonben nem lehet meghivni a group()-ot
                System.out.println(matcher.group().substring(helperMatcher.end()));
            }
        }

        System.out.println(noPassword ? "No passwords found.": "");


        //ref megoldas
//        Matcher matcher = Pattern.compile(
//                "(?i:(?<=password)[\\s:]*[0-9a-z]+)"
//        ).matcher(text);
//
//        if (matcher.find()) {
//            do {
//                System.out.println(matcher.group().replaceAll("[\\s:]*", ""));
//            } while (matcher.find());
//        } else {
//            System.out.println("No passwords found.");
//        }
    }
}