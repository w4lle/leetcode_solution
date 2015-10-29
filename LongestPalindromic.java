/**
 * Given a string S, find the longest palindromic substring in S.
 You may assume that the maximum length of S is 1000, and there exists one unique longest palindromic substring.

 动态规划（DP solution）
 定义方法
 P[i,j] = 字符串区间[i,j]是否为palindrome.

 首先找个例子，比如S="abccb",
 S =    a  b  c  c  b
 Index = 0  1  2  3  4

 ```
 P[0,0] = 1
 P[0,1] = S[0] == S[1]  , P[1,1] =1
 P[0,2] = S[0] == S[2] && P[1,1], P[1,2] = S[1] == S[2] ,  P[2,2] = 1
 P[0,3] = S[0] == S[3] && P[1,2], P[1,3] = S[1] == S[3] && P[2,2] , P[2,3] =S[2] ==S[3],  P[3,3]=1
 ```


 ......................
 由此就可以推导出规律

 ```
 P[i,j] = 1  if i ==j
 P[i,j] = S[i] ==S[j]   if j = i+1
 P[i,j] = S[i] == S[j] && P[i+1][j-1]  if j>i+1

 * @param s
 * @return
 */
private String longestPalindrome(String s) {
    int len = s.length();
    boolean[][] p = new boolean[len][len];
    int maxLength = 0, start = 0, end = 0;
    for (int i = 0; i < len; i++) {
        for (int j = 0; j < i; j++) {
            p[j][i] = (s.charAt(j) == s.charAt(i) && (i - j < 2 || p[j + 1][i - 1]));
            if (maxLength < (i - j + 1)) {
                maxLength = i - j + 1;
                start = j;
                end = i;
            }
        }
        p[i][i] = true;
    }
    return s.substring(start, end);
}