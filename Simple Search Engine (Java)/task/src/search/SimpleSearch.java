package search;

import java.io.File;
import java.util.*;

import static java.lang.System.exit;

public class SimpleSearch {
    public ArrayList<String> details = new ArrayList<>();
    public Map<String,ArrayList<Integer>> invertedIndex=new HashMap<>();
    public int countUser=0;
    public void addUser(String s){
        String[] words=s.split("\\s+");
        this.details.add(s);
        for(String it: words){
            if(invertedIndex.containsKey(it.toLowerCase())) {
                invertedIndex.get(it.toLowerCase()).add(details.indexOf(s));
            }
            else{
                ArrayList<Integer> temp=new ArrayList<>();
                temp.add(details.indexOf(s));
                invertedIndex.put(it.toLowerCase(),temp);
            }
        }
        countUser=this.details.size();
    }
    public void initiateFileDetails(String Path){
        File file;
        Scanner sc;
        try {
            file = new File(Path);
            sc=new Scanner(file);
        } catch(Exception e){
            System.out.println("File not found");
            return;
        }
        while(sc.hasNextLine()){
            String temp=sc.nextLine();
            addUser(temp);
        }
    }
    public void initiateDetails(){
        Scanner sc = new Scanner(System.in);
        int count;
        while(true) {
            try {
                System.out.println("Enter the number of people:");
                count = Integer.parseInt(sc.nextLine());
                break;
            } catch (Exception e){
                System.out.println("Enter Integer Only!!");
            }
        }
        System.out.println("Enter all people:");
        for (int i = 0; i < count; i++) {
            String temp=sc.nextLine();
            addUser(temp);
        }
    }
    public void printInvertedIndex(){
        for(String s: invertedIndex.keySet()){
            System.out.println(invertedIndex.get(s));
        }
    }
    public boolean condition1(String detail,String query){
        return detail.toLowerCase().contains(query.trim().toLowerCase());
    }
    public void printSearchResult(ArrayList<String> result){
        if (!result.isEmpty()) {
            System.out.println();
            System.out.println("Found people:");
            for (String it : result) {
                System.out.println(it);
            }
        } else {
            System.out.println("No matching people found.");
        }
    }
    public void printDetails(){
        System.out.println("=== List of people ===");
        for(String s: this.details){
            System.out.println(s);
        }
    }

    public void findPerson(){
        Scanner sc=new Scanner(System.in);
        String choice;
        Context c=new Context();
        while(true){
                System.out.println("Select a matching strategy: ALL, ANY, NONE");
                choice=sc.nextLine();
                switch(choice){
                    case "ALL": c.setStrategy(new All());
                                break;
                    case "ANY": c.setStrategy(new Any());
                                break;
                    case "NONE": c.setStrategy(new None());
                                 break;
                    default:
                        System.out.println("Invalid option! Select from above options only!!");
                        continue;
                }
                break;
        }
        System.out.println("Enter a name or email to search all suitable people.");
        String query=sc.nextLine();
        String[] queryWords=query.trim().split("\\s+");
        ArrayList<String> result=c.search(queryWords,this.invertedIndex,this.details);
        printSearchResult(result);
    }
    public void menu(){
        int choice;
        Scanner sc=new Scanner(System.in);
        while(true){
            while (true) {
                try {
                    System.out.println("=== Menu ===");
                    System.out.println("1. Find a person");
                    System.out.println("2. Print all people");
                    System.out.println("0. Exit");
                    choice = sc.nextInt();
                    switch (choice) {
                        case 1:
                            findPerson();
                            break;
                        case 2:
                            printDetails();
                            break;
                        case 0:
                            System.out.println("Bye!");
                            exit(0);
                        default:
                            System.out.println("Incorrect option! Try again.");
                    }
                    break;
                } catch (Exception e) {
                    System.out.println("Enter Integer Only!");
                    sc.nextLine();
                }
            }
        }
    }
    public void expandedSearch() {
        initiateDetails();
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the number of search queries:");
        int countQuery;
        while (true) {
            try {
                countQuery = Integer.parseInt(sc.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Enter a integer only!");
            }
        }
        for (int i = 0; i < countQuery; i++) {
            System.out.println("Enter data to search people:");
            String query = sc.nextLine();
            ArrayList<String> result = new ArrayList<>();
            for (String detail : this.details) {
                if (condition1(detail,query)) {
                    result.add(detail);
                }
            }
            printSearchResult(result);
        }
    }
}
