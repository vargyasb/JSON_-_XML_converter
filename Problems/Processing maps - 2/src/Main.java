import java.util.*;

class MapUtils {

    public static NavigableMap<Integer, String> getSubMap(NavigableMap<Integer, String> map){
        // write your code here
        Integer from;
        Integer to;
        if (map.firstKey() % 2 != 0) {
            from = map.firstKey();
            to = map.firstKey() + 4;
        } else {
            from = map.lastKey()-4;
            to = map.lastKey();
        }
        return map.subMap(from, true, to, true).descendingMap();
    }

}

/* Do not modify code below */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TreeMap<Integer, String> map = new TreeMap<>();
        Arrays.stream(scanner.nextLine().split("\\s")).forEach(s -> {
            String[] pair = s.split(":");
            map.put(Integer.parseInt(pair[0]),pair[1]);
        });
        NavigableMap<Integer, String> res = MapUtils.getSubMap(map);
        res.forEach((k, v) -> System.out.println(k + " : " + v));
    }
}