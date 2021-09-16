//leetcode 915
    /*
    
Given an integer array nums, partition it into two (contiguous) subarrays left and right so that:

Every element in left is less than or equal to every element in right.
left and right are non-empty.
left has the smallest possible size.
Return the length of left after such a partitioning.

Test cases are generated such that partitioning exists.

 

Example 1:

Input: nums = [5,0,3,8,6]
Output: 3
Explanation: left = [5,0,3], right = [8,6]
Example 2:

Input: nums = [1,1,1,0,6,12]
Output: 4
Explanation: left = [1,1,1,0], right = [6,12]
    
    */
    import java.util.*;

    public class partitionDisjoints {
    
      // ~~~~~~~~~~~~~~User's Section~~~~~~~~~~~~~~~

      // O(n)

      //method 1
      public static int partitionDisjoint(int[] nums) {
        int n = nums.length;

        // right min creation
        int[] rightMin = new int[n];
        rightMin[n-1] = nums[n-1];
        for(int i = n-2 ; i >= 0; i--){
            rightMin[i] = Math.min(nums[i], rightMin[i+1]);
        }

        //travel and solve , also maintain the leftmax simultaneously
        int leftmax = Integer.MIN_VALUE;
        int ans = 0;
        for(int i = 0; i < n-1; i++){
            leftmax = Math.max(leftmax, nums[i]);
            if(leftmax <= rightMin[i+1])
            {
            ans = i;
            break;
            }
        }
        return ans+1;
      }

     //method 2
      public static int partitionDisjoint2(int[] nums) {
        int leftMax = nums[0];
        int maxInRun = nums[0];
        int ans = 0;
        
        for(int i = 1; i < nums.length; i++){
            if(nums[i] > maxInRun){
                maxInRun = nums[i];
            }
            else if(nums[i] < leftMax){
                ans = i;
                leftMax = maxInRun;
            }
        }
        return ans + 1;
      }
    
    
      // ~~~~~~~~~~~~~Input Management~~~~~~~~~~~~~~~
      public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
    
        for (int i = 0; i < n; i++) {
          arr[i] = scn.nextInt();
        }
    
        int len = partitionDisjoint(arr);
        System.out.println(len);
      }
    }
