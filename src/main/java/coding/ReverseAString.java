package coding;

public class ReverseAString {
    public static void main(String[] args) {
        //1. Approach #1 - StringBuilder 'reverse' API
        //2. Approach #2 - Old school of reversing a string with a for-loop in reverse
        String str = "Hello World";
        System.out.println(reverseWithStringBuilder(str));
        System.out.println(reverseManually(str));
    }
    private static String reverseWithStringBuilder(String str){
        return new StringBuilder(str)
                .reverse()
                .toString();
    }
    private static String reverseManually(String str){
        StringBuilder sb = new StringBuilder();
        for(int i = str.length() -1; i>= 0; i--){
            sb.append(str.charAt(i));
        }
        return sb.toString();
    }
}
