package search;

import java.util.ArrayList;
import java.util.Map;

public interface Strategy {
    ArrayList<String> search(String[] words, Map<String,ArrayList<Integer>> invertedIndex,ArrayList<String> details);
}
class Context{
    private Strategy strategy;
    public void setStrategy(Strategy strategy){
        this.strategy=strategy;
    }
    public ArrayList<String> search(String[] words,Map<String,ArrayList<Integer>> invertedIndex,ArrayList<String> details){
        return strategy.search(words,invertedIndex,details);
    }
}
class All implements Strategy {
    public ArrayList<String> search(String[] queryWords,Map<String,ArrayList<Integer>> invertedIndex,ArrayList<String> details){

        ArrayList<Integer> index=new ArrayList<>();
        ArrayList<String> result=new ArrayList<>();
        for(String word: queryWords){
            ArrayList<String> temp= new ArrayList<>();
            if(invertedIndex.containsKey(word.toLowerCase()))
                index=invertedIndex.get(word.toLowerCase());
            for(int i: index){
                temp.add(details.get(i));
            }
            if(!result.isEmpty())
                result.retainAll(temp);
            else
                result.addAll(temp);
        }
        //System.out.println("Result: "+result);
        return result;
    }
}
class Any implements Strategy{
    public ArrayList<String> search(String[] queryWords,Map<String,ArrayList<Integer>> invertedIndex,ArrayList<String> details){

        ArrayList<Integer> index=new ArrayList<>();
        ArrayList<String> result=new ArrayList<>();
        for(String word: queryWords){
            ArrayList<String> temp= new ArrayList<>();
            if(invertedIndex.containsKey(word.toLowerCase()))
                index=invertedIndex.get(word.toLowerCase());
            for(int i: index){
                temp.add(details.get(i));
            }
            result.addAll(temp);
        }
        //System.out.println("Result: "+result);
        return result;
    }
}
class None implements Strategy{
    public ArrayList<String> search(String[] queryWords,Map<String,ArrayList<Integer>> invertedIndex,ArrayList<String> details){

        ArrayList<Integer> index=new ArrayList<>();
        ArrayList<String> result=new ArrayList<>(details);
        for(String word: queryWords){
            ArrayList<String> temp= new ArrayList<>();
            if(invertedIndex.containsKey(word.toLowerCase()))
                index=invertedIndex.get(word.toLowerCase());
            for(int i: index){
                temp.add(details.get(i));
            }
            result.removeAll(temp);
        }
        //System.out.println("Result: "+result);
        return result;
    }
}
