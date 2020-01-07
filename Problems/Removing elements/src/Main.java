import java.util.*;

class SetUtils {

    public static Set<Integer> getSetFromString(String str) {
        // write your code here
        Set<Integer> numSet = new HashSet<>();
        String[] splittedStr = str.split("\\s+");
        for (String s : splittedStr) {
            numSet.add(Integer.parseInt(s));
        }
        return numSet;
    }

    public static void removeAllNumbersGreaterThan10(Set<Integer> set) {
        // write your code here
        Set<Integer> setToBeRemoved = new HashSet<>();
        for (Integer num : set) {
            if (num > 10) {
                setToBeRemoved.add(num);
            }
        }
        set.removeAll(setToBeRemoved);
    }

}

/* Do not change code below */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String numbers = scanner.nextLine();
        Set<Integer> set = SetUtils.getSetFromString(numbers);
        SetUtils.removeAllNumbersGreaterThan10(set);
        set.forEach(e -> System.out.print(e + " "));
    }
}