package search;
import java.util.*;
public class Main {
    public static void search(){
        Scanner sc=new Scanner(System.in);
        String line=sc.nextLine();
        String word=sc.nextLine();
        String[] words=line.split("\\s+");
        int ind=Arrays.asList(words).indexOf(word)+1;
        if(ind==0){
            System.out.println("Not found");
            return;
        }
        System.out.println(ind);
    }

    public static void main(String[] args) {

        // STAGE1
        // search();

        /*STAGE2
        SimpleSearch s=new SimpleSearch();
        s.expandedSearch();
        */

        /*STAGE3
        SimpleSearch s=new SimpleSearch();
        s.initiateDetails();
        s.menu();
        */

        //STAGE4
        SimpleSearch s=new SimpleSearch();
        s.initiateFileDetails(args[1]);
        s.menu();
    }
}
