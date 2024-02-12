import java.util.*;

class Main {
    private static void log(Map<Long, String> map) {
        // implement me
        int size= map.size();
        if(size==1){
            System.out.println("Something in the map");
        } else if(size>1) {
            System.out.println("Too many objects");
        } else {
            System.out.println("There is no objects");
        }
    }

    // do not change the code below
    public static void main(String[] args) {
        String valueBase = "value-";
        Scanner scanner = new Scanner(System.in);

        Map<Long, String> m = new HashMap<>();
        long size = scanner.nextLong();
        for (long i = 0; i < size; ++i) {
            Long key = i;
            String value = valueBase + i;
            m.put(key, value);
        }
        log(Map.copyOf(m));
    }
}