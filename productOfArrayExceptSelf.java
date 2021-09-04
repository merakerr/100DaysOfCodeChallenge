 //leetcode 238
 /*
 Given an integer array nums, return an array answer such that answer[i] is equal 
 to the product of all the elements of nums except nums[i].
The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
You must write an algorithm that runs in O(n) time and without using the division operation.
 

Input: nums = [1,2,3,4]
Output: [24,12,8,6]

Input: nums = [-1,1,0,-3,3]
Output: [0,0,9,0,0]
 */


    
    import java.util.*;

    public class productOfArrayExceptSelf {
        
        //~~~~~~~~~~~~~~~~~User Section~~~~~~~~~~~~~~~
        public static int[] productExceptSelf(int[] nums) {
            int n = nums.length;

        int[] leftProd = new int[n];
        int[] rightProd = new int[n];

        // left
        leftProd[0] = nums[0];
        for(int i = 1; i < n; i++) {
            leftProd[i] = leftProd[i - 1] * nums[i];
        }

        // right
        rightProd[n - 1] = nums[n - 1];
        for(int i = n - 2; i >= 0; i--) {
            rightProd[i] = rightProd[i + 1] * nums[i];
        }

        // res
        int[] res = new int[n];
        res[0] = rightProd[1];
        res[n - 1] = leftProd[n - 2];

        for(int i = 1; i < n - 1; i++) {
            res[i] = leftProd[i - 1] * rightProd[i + 1];
        }
        return res;
        }
    
        //~~~~~~~~~~~~~~~~~Input Management~~~~~~~~~~~~~~~
        public static void main(String[] args) {
            Scanner scn = new Scanner(System.in);
            int n = scn.nextInt();
            int[] arr = new int[n];
            for(int i = 0; i < n; i++) {
                arr[i] = scn.nextInt();
            }
            int[] res = productExceptSelf(arr);
            for(int i = 0; i < arr.length; i++) {
                System.out.print(res[i] + " ");
            }
        }
    }
