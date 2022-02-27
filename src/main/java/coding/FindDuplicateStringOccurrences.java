package coding;

import java.util.HashMap;
import java.util.Iterator;

public class FindDuplicateStringOccurrences {
    public static void main(String[] args) {
//        findDuplicateWord("I am am learning java java");
        findDuplicateValues();;
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

    public static void findDuplicateWor1(String str){
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

    public static void findDuplicateValues(){
        int[] arr = {4,5,2,4,5,9,9,4,4};
        HashMap<Integer, Integer> hm = new HashMap<>();

        for(int i = 0; i < arr.length; i++){
            for(int j = i + 1; j< arr.length; j++){
                if(arr[i] == arr[j]){
                    if(hm.get(arr[j]) != null){
                        hm.put(arr[j], hm.get(arr[j]) + 1);
                    } else {
                        hm.put(arr[j], 1);
                    }
                }
            }
        }
        Iterator<Integer> tempInt = hm.keySet().iterator();
        while(tempInt.hasNext()){
            Integer temp = tempInt.next();
            if(hm.get(temp) > 1){
                System.out.println("The word " + temp + " appeared " + hm.get(temp) + " time(s)!");
            }
        }
    }


} //End of class declaration
