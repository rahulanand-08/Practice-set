Method 1: Recursive/Backtracking


class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return result;
        }
        String[] mapping = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        StringBuilder combination = new StringBuilder();
        backtrack(result, mapping, combination, digits, 0);
        return result;
    }

    private void backtrack(List<String> result, String[] mapping, StringBuilder combination, String digits, int index) {
        if (index == digits.length()) {
            result.add(combination.toString());
        } else {
            String letters = mapping[digits.charAt(index) - '0'];
            for (char letter : letters.toCharArray()) {
                combination.append(letter);
                backtrack(result, mapping, combination, digits, index + 1);
                combination.deleteCharAt(combination.length() - 1);
            }
        }
    }
}

Method 2:BFS
geeksforgeeks.org/iterative-letter-combinations-of-a-phone-number/

// Java implementation of the approach
import java.io.*;
import java.util.*;

class GFG {
	// Function to return a vector that contains
	// all the generated letter combinations
	static ArrayList<String>
	letterCombinationsUtil(int[] number, int n,
						String[] table)
	{
		// To store the generated letter combinations
		ArrayList<String> list = new ArrayList<>();

		Queue<String> q = new LinkedList<>();
		q.add("");

		while (!q.isEmpty()) {
			String s = q.remove();

			// If complete word is generated
			// push it in the list
			if (s.length() == n)
				list.add(s);
			else {
				String val = table[number[s.length()]];
				for (int i = 0; i < val.length(); i++)
				{
					q.add(s + val.charAt(i));
				}
			}
		}
		return list;
	}

	// Function that creates the mapping and
	// calls letterCombinationsUtil
	static void letterCombinations(int[] number, int n)
	{
		// table[i] stores all characters that
		// corresponds to ith digit in phone
		String[] table
			= { "0", "1", "abc", "def", "ghi",
				"jkl", "mno", "pqrs", "tuv", "wxyz" };

		ArrayList<String> list
			= letterCombinationsUtil(number, n, table);

		// Print the contents of the list
		for (int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i) + " ");
		}
	}

	// Driver code
	public static void main(String args[])
	{
		int[] number = { 2, 3 };
		int n = number.length;
	
		// Function call
		letterCombinations(number, n);
	}
}

// This code is contributed by rachana soma
