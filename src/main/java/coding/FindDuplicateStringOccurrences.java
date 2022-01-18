package coding;

import java.util.HashMap;
import java.util.Iterator;

public class FindDuplicateStringOccurrences {
    public static void main(String[] args) {
        findDuplicateWord("I am am learning java java");
    }

    public static void findDuplicateWord(String str){
        HashMap<String, Integer> hm = new HashMap<String, Integer>();
        String[] words = str.split(" ");
        for(String tempString : words){
            if(hm.get(tempString) != null){
                hm.put(tempString, hm.get(tempString) + 1);
            } else {
                hm.put(tempString, 1);
            }
        }
        Iterator<String> tempString = hm.keySet().iterator();
        while(tempString.hasNext()){
            String temp = tempString.next();
            if(hm.get(temp) > 1){
                System.out.println("The word " + temp + " appeared " + hm.get(temp) + " time(s)!");
            }
        }
    }
}
