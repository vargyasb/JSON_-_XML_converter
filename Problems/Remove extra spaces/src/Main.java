import java.util.Scanner;

class RemoveExtraSpacesProblem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();

        // write your code here
        String regex = "\\s+";
        String cleanedUpText = text.replaceAll(regex, " ");

        System.out.println(cleanedUpText);
        //ref megoldas
        //System.out.println(text.trim().replaceAll("\\s+", " "));
    }
}