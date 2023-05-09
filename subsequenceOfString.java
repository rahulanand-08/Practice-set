
import java.util.* ;
import java.io.*; 
import java.util.ArrayList;

class Solution {
    public static ArrayList<String> subsequences(String str) {
        ArrayList<String> ans=new ArrayList<String>();
        String output = new String("");
        int index = 0;
        solve(str, output, index, ans);
        return ans;
    }
    
    public static void solve(String str, String output, int index, ArrayList<String> ans) {
        if(index >= str.length()) {
            if(output.length() > 0) {
                ans.add(new String(output));
            }
            return;
        }

        // include case
        output += str.substring(index, index+1);
        solve(str, output, index+1, ans);

        // exclude case
        output = output.substring(0, output.length()-1);
        solve(str, output, index+1, ans);
    }
}
