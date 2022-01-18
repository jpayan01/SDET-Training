package coding;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static void main(String[] args) {
        // Given an array of integers, return indices of the two numbers such that they add up to a specific target.
        // You may assume that each input would have exactly one solution, and you may not use the same element twice.
        int[] number = {2, 7, 11, 15}; //target = 9
        // Because number[0] + number[1] = 2 + 7 = 9;
        // return [0,1]

        int[] numbers = new int[] {2,3,7,4,8};
        int target = 7;
        int[] result = getTwoSum(numbers, target);
        System.out.println(result[0] + " " + result[1]);

    }

    public static int[] getTwoSum(int[] numbers, int target){
        Map<Integer, Integer> visitedNumbers = new HashMap<>();
        for(int i = 0; i < numbers.length; i++){
            int delta = target - numbers[i];
            if(visitedNumbers.containsKey(delta)){
                return new int[] {visitedNumbers.get(delta), i};
            }
            visitedNumbers.put(numbers[i], i);
        }
        return new int[] {-1, -1};
    }
}
