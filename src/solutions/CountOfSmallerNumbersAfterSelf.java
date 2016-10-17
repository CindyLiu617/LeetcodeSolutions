package solutions;


import solutions.utils.Interval;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.Arrays.asList;

/**
 * Created by James on 3/28/16.
 */
public class CountOfSmallerNumbersAfterSelf {
    public List<Integer> countSmaller(int[] nums) {
        if (nums == null || nums.length == 0)
            return new ArrayList<Integer>();
        Integer[] rst = new Integer[nums.length];
        Node root = new Node(nums[nums.length - 1]);
        rst[nums.length - 1] = 0;
        for (int i = nums.length - 2; i >= 0; --i){
            int count = BSTInsertNode(root, nums[i]);
            rst[i] = count;
        }
        return Arrays.asList(rst);
    }

    private int BSTInsertNode(Node root, int val){
        //在向BST插入节点时顺便做统计, 当前节点node左侧全部是值小于或者等于当前节点val的节点
        int smallerCount = 0;
        while (root != null){
            if (val <= root.getValue()){
                root.plusOneCount();
                if( root.getLeft() == null){
                    root.setLeft(val);
                    break;
                }
                else
                    root = root.getLeft();
            }
            else{
                smallerCount += root.getCount();
                if (root.getRight() == null){
                    root.setRight(val);
                    break;
                }
                else
                    root = root.getRight();
            }
        }
        return smallerCount;
    }

    class Node{
        private int value;
        private Node left;
        private Node right;
        private int count = 1;

        public Node(int val){
            value = val;
        }

        public int getValue(){
            return this.value;
        }

        public Node getLeft(){
            return this.left;
        }

        public void setLeft(int val){
            Node newNode = new Node(val);
            this.left = newNode;
        }

        public Node getRight(){
            return this.right;
        }

        public void setRight(int val){
            Node newNode = new Node(val);
            this.right = newNode;
        }

        public int getCount(){
            return count;
        }

        public void plusOneCount(){
            this.count += 1;
        }
    }

    static public class Test {
        static private CountOfSmallerNumbersAfterSelf _solution = new CountOfSmallerNumbersAfterSelf();

//        static public void test(int[] A, List<Integer> ans) {
//            for (int i = 0; i < A.length; ++i) {
//                assert ans.get(i).equals(_solution.countSmaller(A).get(i));
//            }
//        }

        static public void randomTest() {
            int[] nums = {5,2,6,1};
//            test(nums, new ArrayList<Integer>(Arrays.asList(2,1,1,0)));
            List<Integer> rst = _solution.countSmaller(nums);

//            int[] nums2 = {1};
//            test(nums2, new ArrayList<Integer>(Collections.singletonList(0)));
//
//            int[] nums3 = {1, 2, 3, 4};
//            test(nums3, new ArrayList<Integer>(Arrays.asList(0, 0, 0, 0)));

//            int[] nums4 = {4, 3, 2, 1};
//            test(nums4, new ArrayList<Integer>(asList(3, 2, 1, 0)));
        }
    }
}
