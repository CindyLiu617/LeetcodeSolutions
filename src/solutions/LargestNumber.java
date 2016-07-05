package solutions;
import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by James on 7/1/16.
 */
public class LargestNumber {
    public String largestNumber(int[] nums) {
        if (nums == null || nums.length == 0)
            return null;
        String[] strs = new String[nums.length];
        for (int i = 0; i < nums.length; ++i){
            strs[i] = Integer.toString(nums[i]);
        }
        StringBuilder sb = new StringBuilder();
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
