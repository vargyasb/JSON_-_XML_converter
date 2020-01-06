import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);

        int size = scanner.nextInt();
        int[] numbers = new int[size];


        for (int i = 0; i < size; i++) {
            numbers[i] = scanner.nextInt();
        }

        int n  = scanner.nextInt();
        int sum = 0;

        for (int num : numbers) {
            if (num > n) {
                sum += num;
            }
        }


        System.out.println(sum);

    }
}