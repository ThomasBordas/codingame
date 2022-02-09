import java.util.*;
import java.io.*;
import java.math.*;


class Solution {
    public static int getTimePerVault (int C , int N ){
        int vowels = C - N ;
        double vr = Math.pow( 5,vowels);
        double dr  = Math.pow(10 , N);
        int vowelsResult =(int)vr;
        int digitResult = (int)dr;

        int totalTime = vowelsResult * digitResult ;

        return totalTime;

    }

    public static int getIndexVoleurMin (int [] input){
        int voleurMin = Integer.MAX_VALUE;
        int indexMin = 0;
        for (int i = 0; i < input.length ; i++) {
            if (input[i] < voleurMin) {
                voleurMin = input[i];
            }
        }
        for (int i = 0; i < input.length; i++) {
            if (input[i] == voleurMin){
                indexMin = i ;
            }
        }
        return indexMin;
    }

    public static int getMax (int [] input){
        int valeurMax = Integer.MIN_VALUE;
        for (int i = 0; i < input.length; i++) {
            if (input[i] > valeurMax) {
                valeurMax = input[i];
            }
        }
        return valeurMax;
    }

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int R = in.nextInt();
        int V = in.nextInt();
        int tpsMax = 0;
        int voleurMin =0;
        int[] coffres = new int[V];        
        int[] voleurs = new int[R];

        for (int i = 0; i < V; i++) {
            int C = in.nextInt();
            int N = in.nextInt();
            coffres[i] = getTimePerVault(C, N);
            // Si un seul coffre
            if(coffres.length == 1){
                tpsMax = coffres[i];
            }
            
        }
        // Dans le cas ou le nombre de voleur est egal au nb de tableaux
        if( voleurs.length == coffres.length){
            for (int i = 0; i < coffres.length-1; i++) {
                if (coffres[i] < coffres[i+1]){
                    coffres [i] = coffres[i+1];
                    tpsMax = coffres[i];
                }
            }
            System.out.print(tpsMax);
        }

        // Dans le cas ou le nombre de voleurs est infèrieur
        if (voleurs.length < coffres.length) {
            for (int i = 0; i < voleurs.length; i++) {
                voleurs[i] = coffres[i];
            }
            for (int i = 0; i < coffres.length-voleurs.length; i++) {
                voleurs[getIndexVoleurMin(voleurs)] += coffres[i+voleurs.length];
            }
            System.out.print(getMax(voleurs));
        }
        
    }
}