package com.mobileapps.trainingweekonedaytwo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*
        int returnFromMethod = someMethod(32);
        Log.d("TAG", "onCreate: " + returnFromMethod);

        //List<String> arr = new ArrayList<>();

        List<String> arr = Arrays.asList("cat", "dog", "cow", "dog", "horse");
        int returnFromMethod = findDuplicates(arr);
        Log.d("RESULTS:", "Duplicates: " + returnFromMethod);

        String word = "m";
        boolean returnFromMethod = checkPalindrome(word);
        Log.d("RESULTS:", "isPalindrome: " + returnFromMethod);
        int results = fizzBuzz(20);

        boolean returnFromMethod = checkAnagrams("a da", "daa");
        Log.d("RESULTS:", "isAnagram: " + returnFromMethod);
        */

        printTables(10,10);

    }
    public int someMethod(int i) {
        //System.out.println("Passed int = " + i);
        return i + 6;
    }

//    Print a multiplication table from 1 to 10 using
//    multidimensional array

    public void printTables(int x, int y){

        int[][] multi = new int[x][y];

        for (int i = 0; i < x; i++){
            for (int j = 0; j < y; j++){
                multi[i][j] = (i+1) * (j+1);
            }
        }
        String line = "";
        for (int i = 0; i < x; i++){
            for (int j = 0; j < y; j++){
                line = line + multi[i][j] + " ";
            }
            Log.d("RESULTS:", line);
            line = "";
        }
    }

    public boolean checkAnagrams(String word1, String word2){

        boolean isAnagram = true;
        word1 = word1.replace(" ","");
        word2 = word2.replace(" ","");
        //Log.d("RESULTS", "checkAnagrams: word1.length: " + word1.length() + ", word2.length: " + word2.length());
        if (word1.length() != word2.length()) {
            isAnagram = false;
            return isAnagram;
        }
        boolean found = false;
        String new2 = "";
        for (int i = 0; i < word1.length() && isAnagram; i++){
            for (int j = 0; j < word2.length(); j++){
                if (word1.charAt(i) == word2.charAt(j) && !found){
                    found = true;
                } else {
                    new2 = new2 + word2.charAt(j);
                }
            }
            if (!found) isAnagram = false;
            word2 = new2;
        }
        return isAnagram;
    }


    public int fizzBuzz(int count){
        boolean flag = false;
        String result = "";
        // You can use a for loop for using the first 20 integers
        for (int i = 1 ; i < count + 1; i++) {
            // "fizz" if the number is divisible by 3
            if (i%3 == 0) {
                //System.out.printf("fizz");
                result = "fizz";
                flag = true;
            }
            // "buzz" if the number is divisible by 5
            if (i%5 == 0) {
                //System.out.printf("buzz");
                result = result + "buzz";
                flag = true;
            }
            // "fizzbuzz" if the number is divisible by both
            if (!flag) {
                // and the integer for the rest
                //System.out.printf("%d\n", i);
                result = result + i;
            }
            Log.d("RESULTS", "fizzBuzz: " + result);
            flag = false;
            result = "";
        }
        return count;
    }

    public boolean checkPalindrome(String word){
        boolean isPalindrome = true;

        // loop from 1st char to middle
        word = word.replace(" ","");

        for(int i = 0 ; i < word.length()/2; i++ ) {
            //get nth term
            if (word.charAt(i) != word.charAt(word.length() - 1 - i)) {
                isPalindrome = false;
            }
        }
        return isPalindrome;
    }

    public int findDuplicates(List<String> strings){
        ArrayList<String> results = new ArrayList<>();

        int dups = 0;
        for(int i = 0 ; i < strings.size(); i++ ) {
            //get nth term
            String temp = strings.get(i);
            //loop to compare to each term
            for(int j = 0 ; j < strings.size() ; j++) {
                if(i != j) {
                    if(temp.equals(strings.get(j))){
                        //if same save to duplist
                        //results.add(temp);
                        Log.d("RESULTS:", "findDuplicates: " + temp);
                        dups++;
                    }
                }
            }
        }
        return dups;
    }
}
/*    public void findDuplicates(List<String> strings){
        ArrayList<String> results = new ArrayList<>();

        for(int i = 0 ; i < strings.size(); i++ ) {
            //get nth term
            String temp = strings.get(i);
            //loop to compare to each term
            for(int j = 0 ; j < strings.size() ; j++) {
                if(i != j) {
                    if(temp.equals(strings.get(j))){
                        resutls.add(temp);
                    }
                }
            }
        }
        //if same save to duplist
    }

/*
    public class DayOneCodingQuiz {
        int x;


        public boolean checkPalindrome(String word){
            boolean isPalindrome;
            isPalindrome = true;

            // loop from 1st char to middle
            word = word.replace(" ","");
            int l = word.length();
            for(int i = 0 ; i < l/2; i++ ) {
                //get nth term
                if (word.charAt(i) != word.charAt(l-i)) {
                    return false;
                }
                return true;
            }
        }
    }
}
*/
/*
    public int someMethod2(int i) {
        // Create the text message with a string
        Intent sendIntent = new Intent();
        sendIntent.setAction(Intent.ACTION_SEND);
        sendIntent.setType("text/plain");
        sendIntent.putExtra(Intent.EXTRA_TEXT, "Goodbye World.");
        // Start the activity
        startActivity(sendIntent);
        return 1;
    }
*/