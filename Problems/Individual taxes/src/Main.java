import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // write your code here
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt(); // number of companies
        int[] yearlyIncomes = new int[n];
        int[] taxPercentages = new int[n];

        for (int i = 0; i < n; i++) {
            yearlyIncomes[i] = scanner.nextInt();
        }
        for (int i = 0; i < n; i++) {
            taxPercentages[i] = scanner.nextInt();
        }

        double maxTax = yearlyIncomes[0] * (taxPercentages[0] / 100);
        int maxTaxIndex = 0;
        for (int i = 1; i < n; i++) {
            double currentTax = yearlyIncomes[i] *  ((double) taxPercentages[i] / 100);
            if (currentTax > maxTax) {
                maxTax = currentTax;
                maxTaxIndex = i;
            }
        }

        System.out.println(maxTaxIndex+1);
    }
}