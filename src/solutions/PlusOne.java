package solutions;

/**
 * Created by James on 10/11/16.
 */
public class PlusOne {
    public int[] plusOne(int[] digits) {
        if (digits == null || digits.length == 0){
            return  null;
        }
        int n = digits.length;
        for (int i=n-1; i>=0; --i) {
            if (digits[i] < 9) {
                ++digits[i];
                return digits;
            } else {
                digits[i] = 0;
            }
        }
        // if we are here, digits are 99...99 and the result should be 100...00.
        int[] result = new int[n+1]; // initialized to all 0's by default
        result[0] = 1;
        return result;
    }
}
