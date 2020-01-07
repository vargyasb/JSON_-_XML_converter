import java.util.Scanner;
import java.util.SortedSet;
import java.util.TreeSet;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        scanner.nextLine();

        SortedSet<String> set = new TreeSet<>();
        for (int i = 0; i < size; i++) {
            set.add(scanner.nextLine());
        }

        for (String s : set) {
            System.out.println(s);
        }
    }
}