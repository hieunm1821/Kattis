import java.util.*;
public class ApaxianName {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] input = sc.nextLine().toCharArray();
        String output = "";
        output += input[0];
        for (int i = 1; i < input.length; i++){
            if (input[i] != input[i-1]) {
                output += input[i];
            }
        }
        System.out.println(input.length);
    }
}