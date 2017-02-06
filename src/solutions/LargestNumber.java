package solutions;
import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by James on 7/1/16.
 */
public class LargestNumber {
    /*
    Given a list of non negative integers, arrange them such that they form the
    largest number.
For example, given [3, 30, 34, 5, 9], the largest formed number is 9534330.
Note: The result may be very large, so you need to return a string instead of an
integer.
     */
    public String largestNumber(int[] nums) {
        if (nums == null || nums.length == 0)
            return null;
        /*
        如何判断大小？对于每个元素，左边第一位大的在前面，如5>30。因为5的第一位是5是5,30的
        第一位是3。依次比较。
那么3应该比30大，因为3 + 30 = 330 ，而30 + 3 = 303。
所以本题可分为4步：
定义string数组，将int数组，转成string数组
对string数组按照定义的规则排序
如果strs第一个元素是“0”，则结果是0
连接strs数组成字符串，即为结果
         */
        String[] strs = new String[nums.length];
        for (int i = 0; i < nums.length; ++i){
            strs[i] = Integer.toString(nums[i]);
        }
        StringBuilder sb = new StringBuilder();
        //!!!
        Arrays.sort(strs, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o2 + o1).compareTo(o1 + o2);
            }
        });
        for (int i = 0; i < strs.length; ++i){
            sb.append(strs[i]);
        }

        String result = sb.toString();
        int index = 0;
        while (index < result.length() && result.charAt(index) == '0')
            ++index;
        if (index == result.length())
            return "0";
        return result.substring(index);
    }
    static public class Test {
        static private LargestNumber _solution = new LargestNumber();

        static public void randomTest() {
            int[] nums = {3, 30, 34, 5, 9};
            String rst = _solution.largestNumber(nums);
            System.out.println(rst);

        }
    }
}
