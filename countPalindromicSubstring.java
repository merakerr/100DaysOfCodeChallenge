/**
 
 You are given a string str.
2. You are required to print the count of palindromic substrings in string str.

input:
abccbc

output:
9

 */

    import java.util.*;
    import java.io.*;
    public class countPalindromicSubstring {
        public static boolean checkPalindrome(String str, int start, int end ){
            while(start<end){
                if(str.charAt(start) != str.charAt(end)){
                    return false;
                }
                start++;
                end--;
            }
            return true;
        }
        public static void findSubString(String str){
            int n = str.length();
            int count = 0;
            for(int i = 0; i<n; i++){
                for(int j = i;j<n;j++){
                    if(checkPalindrome(str,i,j)){
                      // System.out.println(str.substring(i,j+1));
                      count++;
                    }
                }
            }
            System.out.println(count);
        }
    
        public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
            String str = scn.next();
            findSubString(str);
        }
    }
	
 //a  
 //b
 //bccb
 //c
 //cc
 //c
 //cbc
 //b
 //c
    
