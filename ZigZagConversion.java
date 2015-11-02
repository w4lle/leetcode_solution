/**
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)
P   A   H   N
A P L S I I G
Y   I   R
And then read line by line: "PAHNAPLSIIGYIR"
Write the code that will take a string and make this conversion given a number of rows:
string convert(string text, int nRows);
convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".
 */
public class Solution {
    public String convert(String s, int nRows) {
        int len = s.length();  
        if (len == 0 || nRows <= 1) return s;  
          
        String[] ans = new String[nRows];  
        Arrays.fill(ans, "");  
        int row = 0, delta = 1;  
        for (int i = 0; i < len; i++) {  
            ans[row] += s.charAt(i);  
            row += delta;  
            if (row >= nRows) {  
                row = nRows-2;  
                delta = -1;  
            }  
            if (row < 0) {  
                row = 1;  
                delta = 1;  
            }  
        }  
          
        String ret = "";  
        for (int i = 0; i < nRows; i++) {  
            ret += ans[i];  
        }  
        return ret;  
    }
}



Run Code Result: 

Your input

"adfadsfadf"
4
Your answer

"afdsafddaf"
Expected answer

"afdsafddaf"
Runtime: 1 ms