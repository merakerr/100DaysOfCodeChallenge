
/*
1. You are given an ArrayList of positive integers.
2. You have to remove prime numbers from the given ArrayList and return the updated ArrayList.

Note -> The order of elements should remain same.

input: 
4
3 12 13 15

output:
[12, 15]
*/

import java.io.*;
import java.util.*;

public class removePrimes {
    public static boolean isprime(int val){
        for(int i = 2;i*i<=val;i++){
            if(val%i == 0){
                return false;
            }
        }
        return true;
    }
	public static void solution(ArrayList<Integer> al){
		int len = al.size()-1;
        for(int i = len;i>=0;i--){
            if(isprime(al.get(i))){
                al.remove(i);
            }
        }
	}
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		ArrayList<Integer> al = new ArrayList<>();
		for(int i = 0 ; i < n; i++){
			al.add(scn.nextInt());
		}
		solution(al);
		System.out.println(al);
	}

}