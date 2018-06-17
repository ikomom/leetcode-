package b4LongestCommonPrefix;

public class LongestCommonPrefix {
    /**
     * O(S) S是字符串中所有字符的集合 O(n)
     * @author ikonon
     * @return prefix
     */
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++)
            //有包含，返回0表示从最左边开始，直接跳过检测；否则，循环减去最右边的项，若到空值，则返回“”
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) return "";
            }
        return prefix;
    }

    /**
     * O(n^2)
     * @author classic
     */
    public String longestCommonPrefix1(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        for (int i = 0; i < strs[0].length() ; i++){
            char c = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j ++) {
                if (i == strs[j].length() || strs[j].charAt(i) != c)
                    return strs[0].substring(0, i);
            }
        }
        return strs[0];
    }

    public static void main(String[] args) {
        String str = new LongestCommonPrefix().longestCommonPrefix1(new String[]{"leet", "leetcode", "lee"});
        System.out.println(str);

    }
}
