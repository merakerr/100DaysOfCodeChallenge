//169. Majority Element leetcode
    
/*
The majority element is the element that appears more than ⌊n / 2⌋ times.
 You may assume that the majority element always exists in the array
 Example 1:
  Input: nums = [3,2,3]
   Output: 3
   Example 2:

 Input: nums = [2,2,1,1,1,2,2]
  Output: 2
*/



import java.util.*;

    public class majorityElement {
    
        // ~~~~~~~~~~~~~~~~~~~~~User Section~~~~~~~~~~~~~~~~~~~~~
        

        public static int validCandidate(int[] nums){
        int val = nums[0];
        int count = 1;

        int i = 1;
        while(i < nums.length) {
            if(val == nums[i]) {
                // increase the count 
                count++;
            }

            else{
                count--;

            }
            if(count == 0){
                val = nums[i];
                count = 1;
            }
            i++;
        }
        // majority always exist, so val is result
        return val;
        }
        public static void printMajorityElement(int[] arr) {
            int val = validCandidate(arr);
           
            //finding  freq for potential candidate
            int count = 0;
            for(int i = 0; i < arr.length; i++){
                if(arr[i] == val){
                   count++;
                }
            }
            if(count > arr.length/2){
                //for majority , it should be > length/2
                System.out.println(val);
            }
            else{
                System.out.println("No Majority Element Exist");
            }
        }
    
        // ~~~~~~~~~~~~~~~~~~~Input Management~~~~~~~~~~~~~~~~~~~
    
        public static void main(String[] args) {
            Scanner scn = new Scanner(System.in);
            int n = scn.nextInt();
    
            int[] arr = new int[n];
    
            for(int i = 0; i < n; i++) {
                arr[i] = scn.nextInt();
            }
    
            printMajorityElement(arr);
        }
    }
