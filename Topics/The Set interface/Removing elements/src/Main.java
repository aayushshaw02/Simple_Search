import java.util.*;

class SetUtils {

    public static Set<Integer> getSetFromString(String str) {
        // write your code here
        Set<Integer> s=new HashSet<>();
        String[] num=str.split("\\s+");
        for(String it: num){
            int x=Integer.parseInt(it);
            s.add(x);
        }
        return s;
    }

    public static void removeAllNumbersGreaterThan10(Set<Integer> set) {
        // write your code here
        SortedSet<Integer> s= new TreeSet<>(set);
        set.retainAll(s.headSet(11));
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
