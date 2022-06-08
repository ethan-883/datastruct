package dp;

public class _97_交错字符串 {
    public boolean isInterleave(String s1, String s2, String s3) {
        int len1 = s1.length(), len2 = s2.length();
        if (s3.length() != len1 + len2) {
            return false;
        }
        boolean[][] dp = new boolean[len1 + 1][len2 + 1];
        dp[0][0] = true;
        for (int i = 1; i <= len1 && s1.charAt(i - 1) == s3.charAt(i - 1); i++) {
            dp[i][0] = true;
        }
        for (int j = 1; j <= len2 && s2.charAt(j - 1) == s3.charAt(j - 1); j++) {
            dp[0][j] = true;
        }
        for (int i= 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                dp[i][j] = (dp[i - 1][j] && s3.charAt(i + j - 1) == s1.charAt(i - 1))
                    || (dp[i][j - 1] && s3.charAt(i + j - 1) == s2.charAt(j - 1));
            }
        }
        return dp[len1][len2];
        //没考虑顺序
    //     HashMap<Character, Integer> map = new HashMap<>();
    //     char[] arr1 = s1.toCharArray();
    //     char[] arr2 = s2.toCharArray();
    //     char[] arr3 = s3.toCharArray();
    //     for (char c : arr1) {
    //         if (map.containsKey(c)) {
    //             map.put(c, map.get(c) + 1);
    //         } else {
    //             map.put(c, 1);
    //         }
    //     }
    //     for (char c : arr2) {
    //         if (map.containsKey(c)) {
    //             map.put(c, map.get(c) + 1);
    //         } else {
    //             map.put(c, 1);
    //         }
    //     }

    //     for (char c : arr3) {
    //         if (map.containsKey(c)) {
    //             if (map.get(c) == 1) {
    //                 map.remove(c);
    //             } else {
    //                 map.put(c, map.get(c) - 1);
    //             }
    //         } else {
    //             return false;
    //         }
    //     }
    //     return map.isEmpty();
    }
}
