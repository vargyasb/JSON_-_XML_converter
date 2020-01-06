import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        boolean isOccured = true;

        int size = scanner.nextInt();
        int[] numbers = new int[size];

        for (int i = 0; i < size; i++) {
            numbers[i] = scanner.nextInt();
        }

        int n = scanner.nextInt();
        int m = scanner.nextInt();

        for (int i = 0; i < size-1; i++) {
            if (numbers[i] == n || numbers[i] == m) {
                if (numbers[i+1] == n || numbers[i+1] == m) {
                    isOccured = false;
                }
            }
        }

        System.out.println(isOccured);
    }
}