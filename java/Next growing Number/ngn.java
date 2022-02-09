import java.util.*;
import java.io.*;
import java.math.*;

class Solution {
    public static void afficher(int [] input){

        System.out.print("{");
        int dernierCaractère = input[input.length - 1];
        for (int i = 0; i < input.length - 1; i++) {
            String conversion = input[i] + ",";

            System.out.print(conversion);
        }
        System.out.print(dernierCaractère);
        System.out.print("}");
    }

    public static int[] getArrayOfString(String input) {
        int[] result = new int[input.length()];

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            String s = Character.toString(c);
            int value = Integer.valueOf(s);
            result[i] = value;
        }
        return result;
    }

    public static int[] getGrowing(int[] input) {
        int lastGrowing = 0;
        int indexRef = 0;
        for (int i = 0; i < input.length; i++) {
            if( input [i] > input[i+1]){
                lastGrowing = input[i];
                indexRef = i ;
                break ;
            }
        }
        for (int i = indexRef; i < input.length; i++) {
            input[i] = lastGrowing ;
        }
        return input ;
    }


    public static int[] getPlusUn(int[] input) {
        int[] tabIfOnly9 = new int [input.length+1];
        for (int i = input.length-1; i >= 0; i--) {
            if (input[i] < 9){
                input[i] += 1;
                break;
            }
            if (input[i] == 9) {
                input[i] = 0 ;
            }
            if (( i == 0 )&&(input[i] == 0)){
                tabIfOnly9[0] = 1;
                input = tabIfOnly9;
            }
        }
        return input ;
    }

    public static String getStringFromArray(int[] input) {

        String result = "";
        for (int i = 0; i < input.length; i++) {
            result = result + String.valueOf(input[i]);
        }
        return result;
    }

     public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        String n = in.nextLine();

    
        System.out.print(getStringFromArray(getGrowing(getPlusUn(getArrayOfString(n)))));

    }
}