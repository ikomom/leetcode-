package b4LongestCommonPrefix;

public class LongestCommonPrefix {
    /**
     * @return prexi
     * @author ikonon
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

    public static void main(String[] args) {
        String str = new LongestCommonPrefix().longestCommonPrefix(new String[]{"leet", "leetcode", "lee"});
        System.out.println(str);

    }
}
