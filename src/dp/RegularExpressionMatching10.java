package dp;

/**
 * This class
 *
 * @author Yi Qin
 * @date 2018-04-20
 *
 *
 * refer: https://www.youtube.com/watch?v=c5vsle60Uw8
 *  example
 * ('aa', 'a') -> F
 * ('aa', 'aa') -> T
 * ('aaa','aa') -> F
 * ('aa', 'a*') -> T
 * ('aa', '.*') -> T
 * ('ab', '.*') -> T
 * ('aab', 'c*a*b') -> T
 *
 * attention :
 * 1. 'aa' -> '.*'
 * 2. 'ab' -> '.*'
 * 3. 'aab' -> 'c*a*b'
 *
 *
 * dp[i][j]  means whether or not s[0-i] and p[0-j] is match
 *
 * discussion:
 *          1. if s.charAt(i) == p.charAt(j) -> dp[i][j] = dp[i-1][j-1]
 *          2. if p.charAt(j) == '.'  -> dp[i][j] = dp[i-1][j-1]
 *          3. if p.charAt(j) == '*'
 *             1) handle ('aab','c*a*b'): 'c*' seems like empty, c!=''
 *                                         if s.charAt(i) != p.charAt(j-1) ->dp[i][j] = dp[i][j-2]
 *             2) if s.charAt(i) == p.charAt(j-1) || p.charAt(j-1) == '.'
 *                   (1) handle 'aa', 'a*': dp[i][j] = dp[i][j-1]
 *                   (2) handle 'aaa', 'a*': dp[i][j] = dp[i-1][j] !!! trick point
 *                   (3) handle 'a*', empty: dp[i][j] = dp[i][j-2]
 *
 *
 */
public class RegularExpressionMatching10 {
    public boolean isMatch(String s, String p) {
        if(s == null || p == null) return false;
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        dp[0][0] = true;
        //handle the start empty of pattern !!!
        for(int i = 0; i < p.length(); i++){
            if(p.charAt(i) == '*' && dp[0][i-1]){
                dp[0][i+1] = true;
            }
        }
        //because dp[][] contains dp[0][0] so dp[i+1][j+1]
        for(int i = 0; i < s.length(); i++){
            for(int j=0; j < p.length(); j++){
                if(s.charAt(i) == p.charAt(j)){
                    dp[i+1][j+1] = dp[i][j];
                }
                if(p.charAt(j) == '.'){
                    dp[i+1][j+1] = dp[i][j];
                }
                if(p.charAt(j) == '*'){
                    if(s.charAt(i) != p.charAt(j-1) && p.charAt(j-1) != '.'){
                        dp[i+1][j+1] = dp[i+1][j-1];
                    }else{
                        //get write together
                        dp[i+1][j+1] = (dp[i+1][j] || dp[i][j+1] || dp[i+1][j-1]);
                    }
                }
            }
        }
        return dp[s.length()][p.length()];
    }
}
