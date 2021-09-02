
    //leetcode 925  --->>. Long Pressed Name 
  
   /*
    1) shree 
    2) sshhrreee
   
    if the same keyboard is pressed any number of time then no issue, 
    but if it misses any then return false

    In the above , 2) s is pressed twice (OK), h is pressed twice (OK), similarly r and e
    so it will return true,
     1)saeed
     2)ssaaedd
 
     here in 2) s is pressed twice (OK), a is pressed twice (OK), e is pressed one (OK), 
     but for another e , nothing pressed, so
     it will return false

   */



    import java.util.*;

    public class longPressedName {
    
        // ~~~~~~~~~~~~~~~~~~~~~User Section~~~~~~~~~~~~~~~~~~~~~
    
        public static boolean isPossible(String name, String typed) {
            if(name.length() > typed.length()) return false;

            int i = 0;  //name string
            int j = 0; //typed string 
            while(i < name.length() && j < typed.length()){
                
            if(name.charAt(i) == typed.charAt(j)){
                i++;
                j++;
            }
            else if(0 <= i-1 && name.charAt(i-1) == typed.charAt(j)){
               j++;
            }else{
                return false;
            }
        }
        //if any of the i and j is invalid then out of the loop

        while(j < typed.length()){  //check if the j index is greater than its length
            if(typed.charAt(j) != name.charAt(i-1)){
                return false;
            }
            j++;
        }
        return i < name.length() ? false : true; 
        //if ith index is less than name.length means item has not been typed, so return false
        //else return true  
        }
    
        // ~~~~~~~~~~~~~~~~~~~Input Management~~~~~~~~~~~~~~~~~~~
    
        public static void main(String[] args) {
            Scanner scn = new Scanner(System.in);
            
            String name = scn.next();
            String typed = scn.next();
    
            boolean res = isPossible(name, typed);
    
            System.out.println(res);
        }
    }
