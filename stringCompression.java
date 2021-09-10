/*
1. You are given a string. 
2. You have to compress the given string in the following two ways - 
   First compression -> The string should be compressed such that consecutive duplicates of characters are replaced with a single character.
   For "aaabbccdee", the compressed string will be "abcde".
   Second compression -> The string should be compressed such that consecutive duplicates of characters are replaced with the character and followed by the number of consecutive duplicates.
   For "aaabbccdee", the compressed string will be "a3b2c2de2".
*/

import java.util.*;
public class stringCompression {

  public static String compression1(String str){
       int len = str.length();
       String newStr = str.charAt(0)+"";
       for(int i = 1;i<len;i++){
           char curr = str.charAt(i);
           char prev = str.charAt(i-1);
           if(curr != prev){
                  newStr+= curr;
           }
       }
       return newStr;
  }
  public static String compression2(String str){
     ///aaaabbcd--->>a4b2cd
     int len = str.length();
     int count = 1;
     String newStr = str.charAt(0)+"";
     for(int i = 1;i<len;i++){
         char curr = str.charAt(i);
         char prev = str.charAt(i-1);
         if(curr == prev){
             count++;
         }else{
             if(count >1){
                newStr+=count;
               // count=1;
             }
             newStr+=curr;
         }
     }
     if(count>1){
        newStr+=count;
        count = 1;
    }
     return newStr;
  }

    public static void main(String []args){
    
    Scanner sc = new Scanner(System.in);

    String str = sc.next();
    System.out.println(compression1(str));
    System.out.println(compression2(str));


    }
}
