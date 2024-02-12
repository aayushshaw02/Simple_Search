import java.util.*;

public class Main {
    public static void main(String[] args) {
        // write your code here
        Scanner sc=new Scanner(System.in);
        int a=sc.nextInt();
        int b= sc.nextInt();
        int c= sc.nextInt();
        int n= sc.nextInt();
        int upp=65;
        int low=97;
        int dig=48;
        Random r=new Random();
        String s="";
        for(int i=0;i<a;i++){
            char x;
            while(true) {
                x = (char) (r.nextInt(26) + upp);
                if(s.isEmpty()||x!=s.charAt(s.length()-1))
                    break;
            }
            s+=Character.toString(x);
        }
        for(int i=0;i<b;i++){
            char x;
            while(true) {
                x= (char) ( r.nextInt(26)+low);
                if(s.isEmpty()||x!=s.charAt(s.length()-1))
                    break;
            }
            s+=Character.toString(x);
        }
        for(int i=0;i<c;i++){
            char x;
            while(true) {
                x= (char) ( r.nextInt(10)+dig);
                if(s.isEmpty()||x!=s.charAt(s.length()-1))
                    break;
            }
            s+=Character.toString(x);
        }
        while(s.length()<n){
            char x;
            while(true) {
                x = (char) (r.nextInt(26) + upp);
                if(s.isEmpty()||x!=s.charAt(s.length()-1))
                    break;
            }
            s+=Character.toString(x);
        }
        System.out.println(s);
    }
}