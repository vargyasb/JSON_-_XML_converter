import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // write your code here
        Scanner scanner = new Scanner(System.in);

        String regex = "(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[\\w]{12,}";

        String pw = scanner.nextLine();

        System.out.println(pw.matches(regex) ? "YES" : "NO");

    //referencia
//        if (password.length() >= 12
//                & password.matches(".*[0-9]+.*")
//                & password.matches(".*[A-Z]+.*")
//                & password.matches(".*[a-z]+.*")) {
//            System.out.println("YES");
//        } else {
//            System.out.println("NO");
//        }
    }
}