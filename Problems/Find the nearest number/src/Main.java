import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // write your code here
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> inputList = new ArrayList<>();
        ArrayList<Integer> nearestList = new ArrayList<>();

        String[] numbersAsString = scanner.nextLine().split("\\s+");

        for (String nums : numbersAsString) {
            inputList.add(Integer.parseInt(nums));
        }
//        while (scanner.hasNextInt()) {
//            int number = scanner.nextInt();
//            if (number == -1) {
//                break;
//            }
//            inputList.add(number);
//        }

        int n = scanner.nextInt();
        int distance = Math.abs(n-inputList.get(0));
        nearestList.add(inputList.get(0));

        for (int i = 1; i < inputList.size(); i++) {
            if (distance > Math.abs(n-inputList.get(i))) {
                distance = Math.abs(n-inputList.get(i));
                nearestList.clear();
                nearestList.add(inputList.get(i));
            } else if (distance == Math.abs(n-inputList.get(i))){
                nearestList.add(inputList.get(i));
            }
        }

        Collections.sort(nearestList);

        for (Integer num : nearestList) {
            System.out.print(num + " ");
        }
    }
}