/*
1. Given an array nums of 'n' integers and a variable 'K'.
2. You have to return an array of all the unique set [nums[a], nums[b], nums[c],
 nums[d] . . . K Elements] such that: 
    2.1 a, b, c, d . . . K Elements are less than 'n' and greater than 0.
    2.2 a,. b, c, d upto K different indexes are Unique.
    2.3 nums[a] + nums[b] + nums[c] + nums[d] + . . . + nums[K distinct indexes] == target.
3. You can return answer in any order.

input:
6
-1 0 1 2 -1 -4
0
3

output:
-1 -1 2 
-1 0 1 

*/
    
    import java.util.*;
//tc n^k-1 + nlon
    public class KSum {
    
    public static List<List<Integer>> kSum(int[] arr, int target,  int k) {
     Arrays.sort(arr);
     return kSum_(arr,target, 0, k);
    }


      public static List<List<Integer>> kSum_(int[] arr, int target,int si,  int k) {
        if(k == 2){
            //base case
          return twoSum(arr, si, arr.length-1, target);
        }
       
      
        int n = arr.length;
        List<List<Integer>> res = new ArrayList<>();
        if(n-k < 0){
            return res;
        }
        for(int i = si; i < n - (k - 1); i++){
            if(i != si && arr[i] == arr[i-1]){
                continue;
            }

            int val1 = arr[i];
            int targ = target - val1;
            List<List<Integer>> subres = kSum_(arr, targ, i+1, k-1);

            for(List<Integer> list : subres){
                list.add(val1);
                res.add(list);
            }
        }
         return res;

      }
      private static List<List<Integer>> twoSum(int[] arr, int st, int end, int target) {
        int left = st;
        int right = end;
        List<List<Integer>> res = new ArrayList<>();
        while(left < right) {
            if(left != st && arr[left] == arr[left - 1]) {
                left++;
                continue;
            }
            int sum = arr[left] + arr[right];
            if(sum == target) {
                List<Integer> subres = new ArrayList<>();
                subres.add(arr[left]);
                subres.add(arr[right]);
                res.add(subres);

                left++;
                right--;
            } else if(sum > target) {
                right--;
            } else {
                left++;
            }
        }
        return res;
    }
      public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
          arr[i] = scn.nextInt();
        }
        int target = scn.nextInt();
        int k = scn.nextInt();
        List<List<Integer>> res = kSum(arr, target, k);
        ArrayList<String> finalResult = new ArrayList<>();
        for (List<Integer> list : res) {
          Collections.sort(list);
          String ans = "";
          for (int val : list) {
            ans += val + " ";
          }
          finalResult.add(ans);
        }
        Collections.sort(finalResult);
        for (String str : finalResult) {
          System.out.println(str);
        }
      }
    
    }
