import java.util.*;
import java.io.*;
import java.math.*;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Solution {
        public static boolean isAllNumbers (int [] input){
        Arrays.sort(input);
        int nombreTrue = 0 ;
        for (int i = 0; i < input.length; i++) {
            if (input[i] != i + 1) {
                return false;
            }
        }
        return true;
    }

    public static boolean isLineOk ( int[][] tab1){

        int[] ligne = new int[9];

        for (int i = 0; i < ligne.length; i++) {
            for (int j = 0; j < ligne.length; j++) {
                ligne[j] = tab1[i][j];

            }
            if (isAllNumbers(ligne) == false) {
                return false;
            }
        }
        return true ;
    }

    public static boolean isColumnOk ( int [][] input){

        int nbLigne = input.length;
        int nbcolonnes = input[0].length;

        // Pour chaque colonne
        for (int iCol = 0; iCol < nbcolonnes; iCol++) {
            int[] colonne = new int[nbLigne];
            // Parcourir les lignes
            for (int ilig = 0; ilig < nbLigne; ilig++) {
                // Mettre la valeur dans un tableau
                colonne[ilig] = input[ilig][iCol];
            }
            if(isAllNumbers(colonne) == false) {
                return false;
            }
        }
        return true ;
    }


    public static boolean isAllNumberSqr3 ( int[][] input ){
        int indexLigne =0;
        int indexCol = 0 ;
        int[] lecture3x3 = new int [9];
        int compteur = 0;

        // Defile les colones par tranche de 3
        for (int l = 0; l < 3; l++) {

            //defile les lignes par tranche de 3
            for (int k = 0; k < 3; k++) {

                //Verifie un 3x3
                for (int i = indexLigne; i < indexLigne + 3; i++) {
                    for (int j = indexCol; j < indexCol + 3; j++) {
                        lecture3x3[compteur] = input[i][j];
                        compteur += 1;
                    }
                }
                if (isAllNumbers(lecture3x3) == false) {
                    return false;
                }
                // reset en fin de 3x3 ( recommence 3 lignes plus bas (si c'est possible d'où la condition ) et remet le compteur à 0)
                if (indexLigne < 8) {
                    compteur = 0;
                    indexLigne += 3;

                    //reset mes lignes une fois arrivé en bas du tableau (ligne 9)
                    if (indexLigne == 9){
                        indexLigne = 0;
                    }
                }
            }
            // Une foi mes lignes reset , recommence 3 colones plus loin (idem si c'est possible)
            if (indexCol < 8){
                compteur =0;
                indexCol += 3;
            }
        }
        return true ;
    }


    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int[][] sudoku = new int[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                int n = in.nextInt();
                sudoku[i][j] = n ;
            }
        }
        if((isLineOk(sudoku)==true)&&(isColumnOk(sudoku)==true)&&(isAllNumberSqr3(sudoku)==true)){
            System.out.println("true");
        }
        else{
            System.out.println("false");
        }

             
    }
}