
import solutions.JumpGame;

/**
 * Created by James on 3/24/16.
 */
public class Test {
    static public void main(String[] args){
        long startTime = System.nanoTime();
        JumpGame.Test.randomTest();
        System.out.println("Total Time: " + (System.nanoTime() - startTime) / 1000000 + "ms");
    }
}
