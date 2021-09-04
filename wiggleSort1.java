
    /*
1. Given an unsorted array 'arr'.
2. Reorder it in-place such that :  arr[0] <= arr[1] >= arr[2] <= arr[3] . . . .
3. Please sort the array in place and do not define additional arrays.
4. Allowed Time Complexity : O(n)
    
Input: [3, 5, 2, 1, 6, 4]
Output: [1, 6, 2, 5, 3, 4]
    
    */
    import java.util.*;

    public class wiggleSort1 {
    

      // ~~~~~~~~~~~~~~User Section~~~~~~~~~~~~~~
      public static void wiggleSort(int[] arr) {
        for(int i = 0; i < arr.length - 1; i++){
            if(i % 2 == 0){
                //even
                if(arr[i] > arr[i+1]){
                    swap(arr, i, i+1);
                }
            }else{
                //odd 
                if(arr[i] < arr[i+1]){
                    swap(arr, i, i+1);
                }
            }
        }
      }

      private static void swap(int[] arr, int i, int j){
          int temp = arr[i];
          arr[i] = arr[j];
          arr[j] = temp;
      }
    
      // ~~~~~~~~~~~~Input Management~~~~~~~~~~~~~
      public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
    
        int n = scn.nextInt();
        int[] arr = new int[n];
    
        for (int i = 0; i < n; i++) {
          arr[i] = scn.nextInt();
        }
    
        wiggleSort(arr);
    
        for (int val : arr) {
          System.out.print(val + " ");
        }
        System.out.println();
      }
    
    }
    
