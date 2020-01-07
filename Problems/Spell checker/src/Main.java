import java.util.*;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        int d = scanner.nextInt();
        Set<String> correctWords = new HashSet<>();

        for (int i = 0; i < d; i++) {
            correctWords.add(scanner.next().toLowerCase(Locale.ENGLISH));
        }

        int l = scanner.nextInt();
        scanner.nextLine(); //consume newline leftover
        List<String> texts = new ArrayList<>();
        String[] strs;

        for (int i = 0; i < l; i++) {
            strs = scanner.nextLine().split("\\s+");
            for (String s : strs) {
                texts.add(s.toLowerCase(Locale.ENGLISH));
            }
        }


        Set<String> erroneousWords = new HashSet<>();
        for (String s : texts) {
            if (!correctWords.contains(s)) {
                erroneousWords.add(s);
            }
        }

        for (String s : erroneousWords) {
            System.out.println(s);
        }
    }
}