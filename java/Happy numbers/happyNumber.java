import java.util.*;
import java.io.*;
import java.math.*;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Solution {
        //petite fonction qui fait la somme des cases d'un tableau
    public static int getSommeDesCases ( int [] tableau){
        int sum =0 ;
        for (int i = 0; i < tableau.length; i++) {
            if(tableau[i]!=0){
            sum = sum + tableau[i];
            }
        }
        return sum;
    }
    // Fonction qui recherche si mon nombre est un happy number
    public static  boolean  getHappyNumber  (String input ){

        // Variable pour garder mes résultats
        int somme = 0;

        // Mise en place de mon entrée dans un tableau.
        char[] tabChar = new char [input.length()+1];

        // Creation d'un tableau de int pour y transferer mon tabChar et y faire les calculs
        int[] tabNum = new int [input.length()];

        for (int i = 0; i < input.length(); i++) {
            tabChar[i] = input.charAt(i);
        }
        int compteur = 0;


        // valeur max 10^26(dans l'énnoncé) donc nb max = 9²*26 soit 2106
        while(compteur < 2106){
            compteur += 1;
            //j'intègre tabChar à mon tabNum
            for (int i = 0; i < input.length(); i++) {
                if (tabChar[i] != 0){
                    //Ici -48 pour compenser la valeur 0 en ASCII base 10
                    tabNum[i] = Integer.valueOf(tabChar[i] - 48);
                }
                else{
                    tabNum[i] = 0;
                }
            }

            //calcul du carré de chaque cases de mon tabNum
            for (int i = 0; i < input.length() ; i++) {
                if(tabNum[i] != 0){
                tabNum[i] = (tabNum[i]*tabNum[i]);
                }
            }

            // je fait la somme de chaque cases
            somme = getSommeDesCases(tabNum);

            //je reset mon tableau tabNum à 0 avant d'y réintegrer "somme"
            for (int i = 0; i < tabNum.length; i++) {
                tabNum[i] = 0 ;
            }

            //idem pour mon tabChar
            for (int i = 0; i < tabChar.length; i++) {
                tabChar[i] = 0;
            }

            // je met ma somme dans tabChar et je converti
            String sumString = String.valueOf(somme);
            for (int i = 0; i < sumString.length(); i++) {
                tabChar[i] = sumString.charAt(i);
            }

            //et je return mes résultats
            if (somme == 1){
                return true;
            }
        }
        return false;
    }

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        String [] tabEntrée = new String[N];
        if (in.hasNextLine()) {
            in.nextLine();
        }
        for (int i = 0; i < N; i++) {
            String x = in.nextLine();
            tabEntrée[i]= x ;
        }
        for (int i = 0; i < tabEntrée.length; i++) {
            if(getHappyNumber(tabEntrée[i]) == true){
                System.out.println (tabEntrée[i]+" :)");
            }
            if(getHappyNumber(tabEntrée[i]) == false){
                System.out.println (tabEntrée[i]+" :(");
            }           
        }    
    }
}