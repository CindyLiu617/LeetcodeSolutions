package solutions;

import solutions.utils.NestedInteger;

import java.util.ArrayList;
import java.util.List;

public class FlattenList {
    // @param nestedList a list of NestedInteger
    // @return a list of integer
    public List<Integer> flatten(List<NestedInteger> nestedList) {
        List<Integer> rst = new ArrayList<Integer>();
        if (nestedList == null || nestedList.size() == 0) {
            return rst;
        }
        for (NestedInteger ni: nestedList) {
            if (ni.isInteger()) {
                rst.add(ni.getInteger());
            } else {
                rst.addAll(flatten(ni.getList()));
            }
        }
        return rst;
    }
}

