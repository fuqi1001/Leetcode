package leetcode;

/**
 * Created by qifu on 16/9/22.
 */
public class CompareVersionNumbers {
    public int compareVersion(String version1, String version2) {
        String[] str1 = version1.split("\\.");
        String[] str2 = version2.split("\\.");

        int i = 0;
        while(str1.length>i || str2.length>i){
            int value1 = 0;
            int value2 = 0;

            if(str1.length > i){
                value1 = Integer.valueOf(str1[i]);
            }

            if(str2.length > i){
                value2 = Integer.valueOf(str2[i]);
            }

            if(value1>value2) return 1;
            if(value1 < value2) return -1;
            i++;
        }
    return 0;

    }

    ///
    public int compareVersion(String version1, String version2) {
        int len1 = version1.length();
        int len2 = version2.length();
        int i1 = 0;
        int i2 = 0;
        int value1 = 0;
        int value2 = 0;

        while(i1 < len1 || i2 < len2){
            while(i1 < len1 && version1.charAt(i1)!='.'){
                value1 = value1*10 + (version1.charAt(i1)-'0');
                i1++;
            }
            while(i2 < len2 && version2.charAt(i2)!='.'){
                value2 = value2*10 + (version2.charAt(i2)-'0');
                i2++;
            }
            if(value1 > value2) return 1;
            else if(value1<value2) return -1;
            else{
                value1=0;
                value2=0;
                i1++;
                i2++;
            }
        }
        return 0;
    }
}
