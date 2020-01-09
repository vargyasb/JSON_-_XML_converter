import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // write your code here
        Scanner scanner = new Scanner(System.in);

        String ip = scanner.nextLine();

        String regex =  "(25[0-5]|2[0-4]\\d|1\\d{2}|[1-9]\\d|\\d)\\." +
                        "(25[0-5]|2[0-4]\\d|1\\d{2}|[1-9]\\d|\\d)\\." +
                        "(25[0-5]|2[0-4]\\d|1\\d{2}|[1-9]\\d|\\d)\\." +
                        "(25[0-5]|2[0-4]\\d|1\\d{2}|[1-9]\\d|\\d)";

        //referencia megoldas, szar, mert a 09.09.09.09 IP-re is matchel
//        final String bytePattern = "(1?\\d?\\d|2[0-4]\\d|25[0-5])";
//        final String ipPattern = String.join(
//                "\\.", bytePattern, bytePattern, bytePattern, bytePattern
//        );

        System.out.println(ip.matches(regex) ? "YES" : "NO");
    }
}