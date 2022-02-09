//SOLUTION DU PUZZLE ENIGMA

import java.util.*;
import java.io.*;
import java.math.*;
import java.sql.ResultSetMetaData;


class Solution {

    public static String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public static String getAddRandomNumber(int randomNumber, String message) {

        int index = 0;
        char[] tabSortie = new char[message.length()];

        for (int i = 0; i < message.length(); i++) {
            index = ALPHABET.indexOf(message.charAt(i)) + randomNumber;
            index = index % 26;
            tabSortie[i] = ALPHABET.charAt(index);
            randomNumber += 1;
        }
        String sortie = String.valueOf(tabSortie);

        return sortie;

    }
    public static String getSubstractNumber (int randomNumber , String message){

        int index = 0;
        char[] tabSortie = new char[message.length()];

        for (int i = 0; i < message.length(); i++) {
            index = ALPHABET.indexOf(message.charAt(i)) - randomNumber;
            index = (index % 26 + 26) % 26;
            tabSortie[i] = ALPHABET.charAt(index);
            randomNumber += 1;
        }
        String sortie = String.valueOf(tabSortie);

        return sortie;

    }

    public static String getPassageRotor(String rotor, String message) {

        char[] tabMessage = new char [message.length()];

        for (int i = 0; i < message.length(); i++) {
            for (int j = 0; j < ALPHABET.length(); j++) {
                if (message.charAt(i) == ALPHABET.charAt(j) ){
                    tabMessage[i] = rotor.charAt(j);
                }
            }
        }
        String sortie = String.valueOf(tabMessage);
        return sortie;
    }

    public static String getInvRotor (String rotor , String input){

        char[] tabMessage = new char [input.length()];

        for (int i = 0; i < input.length(); i++) {
            for (int j = 0; j < rotor.length(); j++) {
                if (input.charAt(i) == rotor.charAt(j) ){
                    tabMessage[i] = ALPHABET.charAt(j);
                }
            }
        }
        String sortie = String.valueOf(tabMessage);
        return sortie;

        
    }



    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        String operation = in.nextLine();
        int pseudoRandomNumber = in.nextInt();
        String [] rotorTab = new String [3];
        if (in.hasNextLine()) {
            in.nextLine();
        }
        for (int i = 0; i < 3; i++) {
            String rotor = in.nextLine();
            rotorTab[i] = rotor ;
        }
        String message = in.nextLine();

        if(operation.equals("ENCODE")){

            String messPostNum = getAddRandomNumber(pseudoRandomNumber, message);
            String[] tabResult= new String [rotorTab.length+1];
            tabResult[0] = messPostNum;
            for (int i = 0; i < rotorTab.length; i++) {

                tabResult[i+1] = getPassageRotor((rotorTab[i]), tabResult[i]);

            }
            System.out.println(tabResult[3]);
        }

        if(operation.equals("DECODE")){
            
              String[] tabResult = new String [rotorTab.length+1];
            tabResult [0] = message;
            int origine = 0;

                for (int j = rotorTab.length-1; j >= 0; j--) {
                    tabResult[origine+1] = getInvRotor(rotorTab[j],tabResult[origine]);
                    origine += 1;
                }
            String sortie = getSubstractNumber(pseudoRandomNumber, tabResult[tabResult.length-1]);
            System.out.println(sortie);


        }


    }
}