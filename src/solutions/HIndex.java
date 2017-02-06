package solutions;

import java.util.Arrays;

public class HIndex {
    /*
    Given an array of citations (each citation is a non-negative integer) of a
    researcher, write a function to compute the researcher's h-index.

According to the definition of h-index on Wikipedia: "A scientist has index h
if h of his/her N papers have at least h citations each, and the other N − h
papers have no more than h citations each."

For example, given citations = [3, 0, 6, 1, 5], which means the researcher has
]5 papers in total and each of them had received 3, 0, 6, 1, 5 citations
respectively. Since the researcher has 3 papers with at least 3 citations each
and the remaining two with no more than 3 citations each, his h-index is 3.

Note: If there are several possible values for h, the maximum one is taken as
the h-index.
     */
    public int hIndex(int[] citations) {
        if (citations == null || citations.length == 0) {
            return 0;
        }
        Arrays.sort(citations);
        int rst = 0;
        /*
        1、将某作者的所有文章的引用频次按照从大到小的位置排列
2、从前到后，找到最后一个满足条件的位置，其条件为：此位置是数组的第x个，其值为y，
必须满足 y >= x;
         */
        for (int i = citations.length - 1; i >= 0; --i) {
            if (citations[i] >= citations.length - i) {
               rst = citations.length - i;
            } else {
                break;
            }
        }
        return rst;
    }

    /*
    follow-up:
    What if the citations array is sorted in ascending order? Could you optimize
    your algorithm? O(log(n))
     */
    public int hIndex2(int[] citations) {
        if (citations == null || citations.length == 0) {
            return 0;
        }
        int left = 0, len = citations.length, right = len - 1;
        //how to write binary search : http://blog.jobbole.com/101231/
        while (left <= right) {
            int mid = (left + right) / 2;
            if (citations[mid] < len - mid) {
                left = mid + 1;
            } else if (citations[mid] == len - mid) {
                return len - mid;
            } else {
                right = mid - 1;
            }
        }
        return len - left;
    }

    static public class Test {
        static private HIndex _solution = new HIndex();

        static public void randomTest() {
            int[] nums = {0, 1, 3, 5, 6};
            int rst = _solution.hIndex2(nums);
            System.out.println(rst);
            }
        }
}
