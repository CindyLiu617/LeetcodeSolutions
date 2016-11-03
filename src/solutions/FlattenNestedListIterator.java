package solutions;
import solutions.utils.NestedInteger;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.*;


public class FlattenNestedListIterator implements Iterator<Integer>{
    Stack<NestedInteger> stack;

    public FlattenNestedListIterator(List<NestedInteger> nestedList) {
        // Initialize your data structure here.
        Stack<NestedInteger> stack = new Stack<NestedInteger>();
        for (int i = nestedList.size() - 1; i >= 0; --i){
           stack.push(nestedList.get(i));
        }
    }

    // @return {int} the next element in the iteration
    @Override
    public Integer next() {
        // Write your code here
        try{
            NestedInteger nxt = stack.peek();
            stack.pop();
            return nxt.getInteger();
        } catch (EmptyStackException e){
            throw new NoSuchElementException();
        }
    }

    // @return {boolean} true if the iteration has more element or false
    @Override
    public boolean hasNext() {
        // Write your code here
        while (stack != null && !stack.isEmpty()){
            if (stack.peek().isInteger()){
                return true;
            }
            NestedInteger cur = stack.pop();
            for (int i = cur.getList().size() - 1; i >= 0;
                 --i){
                stack.add(cur.getList().get(i));
            }
        }
        return false;
    }

    @Override
    public void remove() {
        throw new NotImplementedException();
    }
}
