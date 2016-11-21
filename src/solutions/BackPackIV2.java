package solutions;

public class BackPackVI2 {
    /**
     * @param nums an integer array and all positive numbers, no duplicates
     * @param target an integer
     * @return an integer
     */
    public int backPackIV(int[] nums, int target) {
        int[] fillNum = new int[target + 1];
        fillNum[0] = 1;
        for (int i = 0; i < nums.length; ++i){
            for (int j = 1; j <= target; ++j){
                if (j == nums[i]){
                    ++fillNum[j];
                }
                if (j > nums[i]){
                    fillNum[j] += fillNum[j - nums[i]];
                }
            }
        }
        return fillNum[target];
    }


    //Combination sum
//    public ArrayList<ArrayList<Integer>> combinationSum(int[] candidates, int target) {
//        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
//
//        if(candidates == null || candidates.length == 0) return result;
//
//        ArrayList<Integer> current = new ArrayList<Integer>();
//        Arrays.sort(candidates);
//
//        combinationSum(candidates, target, 0, current, result);
//
//        return result;
//    }
//
//    public void combinationSum(int[] candidates, int target, int j, ArrayList<Integer> curr, ArrayList<ArrayList<Integer>> result){
//        if(target == 0){
//            ArrayList<Integer> temp = new ArrayList<Integer>(curr);
//            result.add(temp);
//            return;
//        }
//
//        for(int i=j; i<candidates.length; i++){
//            if(target < candidates[i])
//                return;
//
//            curr.add(candidates[i]);
//            combinationSum(candidates, target - candidates[i], i, curr, result);
//            curr.remove(curr.size()-1);
//        }
//    }
}
