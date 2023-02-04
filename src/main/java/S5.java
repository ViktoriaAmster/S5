import java.util.*;

public class S5 {
    public static void main(String[] args) {
        HashMap<Integer,String> my_map = new HashMap<>();

        my_map.putIfAbsent(11,"Red");
        my_map.putIfAbsent(24,"Black");
        my_map.putIfAbsent(8,"Green");

        Iterator<Integer> iterator = my_map.keySet().iterator();
        while (iterator.hasNext()) {
//            Integer tmp =iterator.next();
//            my_map.put(tmp, my_map.get(tmp)+"!");
            my_map.compute(iterator.next(), (k,v) -> v+="!");
        }
        System.out.println(my_map);
        Set<Integer> keysetmaps = my_map.keySet();
        while (keysetmaps.size() < 10000) {
            int key = new Random().nextInt(Short.MAX_VALUE);
            my_map.putIfAbsent(key, "ferret!");
        }

        TreeMap<Integer,String> treemap = new TreeMap<>();
        treemap.putIfAbsent(11, "Red");
        treemap.putIfAbsent(24, "Black");
        treemap.putIfAbsent(8, "Green");
        System.out.println(treemap);

        Set <Integer> keyset = treemap.keySet();
        while (keyset.size() < 10000) {
            int key = new Random().nextInt(Short.MAX_VALUE);
            treemap.putIfAbsent(key, "ferret");
        }
        System.out.println(keyset.size());

        long start1 = System.currentTimeMillis();
        Iterator<Integer> tempiterator1 = treemap.keySet().iterator();
        while (tempiterator1.hasNext()){
            String val = treemap.get(tempiterator1.next());
        }
        long end1 = System.currentTimeMillis();
        System.out.println(end1-start1);

        long start2 = System.currentTimeMillis();
        Iterator<Integer> tempiterator2 = my_map.keySet().iterator();
        while (tempiterator2.hasNext()){
            String val = my_map.get(tempiterator2.next());
        }
        System.out.println(System.currentTimeMillis() - start2);
    }
}
