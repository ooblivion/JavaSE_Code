package 面试算法题.字符串;

public class ViolenceMatch {
    public static void main(String[] args) {
        String str1 = "addgadfhfgsfgs";
        String str2 = "fhf";
        int index = violenceMatch(str1, str2);
        System.out.println("index=" + index);
    }

    public static int violenceMatch(String str1, String str2) {
        char[] s1 = str1.toCharArray();
        char[] s2 = str2.toCharArray();
        int s1len = s1.length;
        int s2len = s2.length;

        //两个索引
        int i = 0;
        int j = 0;
        while (i < s1len && j < s2len){
            if(s1[i] == s2[j]){
                i++;
                j++;
            }else {
                i = i - (j-1);
                j = 0;
            }
        }
        if (j == s2len){
            return i-j;
        }else {
            return -1;
        }
    }
}
