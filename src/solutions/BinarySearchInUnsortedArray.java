package solutions;

/**
 * Created by James on 10/12/16.
 */
public class BinarySearchInUnsortedArray {
    public int findTarget (int[] array, int left, int right, int target){
        //二分查找
// *函数调用BinarySearch(a,n,key);
// *在无序数组a[n]中查找x是否存在，如果存在返回1，不存在返回0
//                *这里我们用到快速排序中的划分规则，大致意思如下
//                *将数组A[p..r]划分为两个字数组A[p..q-1]和A[q+1..r],使得
//                *A[p..q-1]中的每个元素都小于等于A[q],并且，小于等于A[q+1..r]
//                *对于查找关键字key，if(key==A[q]) return 1;
// *if(key<A[q]) 查找字数组A[p..q-1]
// *if(key>A[q]) 查找字数组A[q+1..r]
        if (array == null || array.length == 0){
            return 0;
        }
        while (left < right){
            int mid = findPartitionPos(array);
            if (array[mid] == target){
                return mid;
            }
            else if (array[mid] > target){
                findTarget(array, left, mid - 1, target);
            }
            else if (array[mid]< target){
                findTarget(array, mid + 1, right, target);
            }
        }
        return -1;
    }

    //返回partition index
    private int findPartitionPos (int[] array){
        int len = array.length, tmp = array[0], i = 1, j = len - 1;
        while (true){
            while (array[i] <= tmp){
                ++i;
            }
            while (array[j] > tmp){
                --j;
            }
            if (j <= i){
                break;
            }
            else {
                swap(array, i, j);
                ++i;
                --j;
            }
        }
        swap(array, 0, j);
        return j;
    }

    private void swap(int[] array, int idx1, int idx2){
        int tmp = array[idx1];
        array[idx1] = array[idx2];
        array[idx2] = tmp;
    }

    static public class Test {
        static private BinarySearchInUnsortedArray _solution = new BinarySearchInUnsortedArray();

        static public void test(int[] nums, int left, int right, int target,
                                int ans) {
            assert ans == (_solution.findTarget(nums, left, right, target));
        }

        static public void randomTest() {
            int[] nums = {4,6,1,0,77,3,7,9,6};
            test(nums, 0, 8, 3, 0);
        }
    }
}
