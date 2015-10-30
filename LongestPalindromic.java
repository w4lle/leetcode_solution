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

/**
 * Manacher's ALGORITHM: O(n)
 * blog http://blog.csdn.net/hlglinglong/article/details/49493895
 */

public class Solution{
    public String getManacherString(String str){
        StringBuilder sb=new StringBuilder("$");
        int n=str.length();
        for(int i=0;i<n;i++){
            sb.append("#").append(str.charAt(i));
        }
        sb.append("#");
        return sb.toString();
    }
    public String longestPalindrome(String s){
        String newStr=getManacherString(s);
        int len=newStr.length();
        int[] radiusArray=new int[len];
        int end=0;
        int index=0;
        int maxLen=0;
        int maxIndex=0;
        for(int i=1;i<len;i++){
            if(end>i){
                radiusArray[i]=Math.min(radiusArray[2*index-i], end-i);
            }else{
                radiusArray[i]=1;
            }
            while(i+radiusArray[i]<len&&i-radiusArray[i]>=1){
                if(newStr.charAt(i+radiusArray[i])==newStr.charAt(i-radiusArray[i])){
                    radiusArray[i]++;
                }else{
                    break;
                }
            }
            if(radiusArray[i]+i>end){
                end=radiusArray[i]+i;
                index=i;
            }
            if(radiusArray[i]>maxLen){
                maxLen=radiusArray[i];
                maxIndex=i;
            }
        }
        StringBuilder sb=new StringBuilder();
        for(int i=maxIndex-maxLen+1;i<maxIndex;i++){
            if(newStr.charAt(i)!='#'){
                sb.append(newStr.charAt(i));
            }
        }
        String resultStr=sb.toString();
        if(newStr.charAt(maxIndex)!='#'){
            resultStr+=newStr.charAt(maxIndex);
        }
        resultStr+=sb.reverse().toString();
        return resultStr;
    }

}