package solutions;

import java.util.BitSet;
import java.util.HashMap;

/**
 * Created by James on 8/4/16.
 */
public class Backpack {
    private HashMap<Key, Integer> cache;

    public int backPack(int bagSize, int[] items) {
        // write your code here
        if (items == null || items.length == 0 || bagSize <= 0) {
            return 0;
        }
        cache = new HashMap<Key, Integer>();
        BitSet chosen = new BitSet(items.length);
        return dfs(bagSize, items, bagSize, chosen);
    }

    private int dfs(final int bagSize, int[] items, int sizeRemain,
                    BitSet chosen) {
        Key key = new Key(sizeRemain, chosen);
        if (!cache.containsKey(key)) {
            int localMax = 0;
            for (int i = 0; i < items.length; ++i) {
                if (!chosen.get(i) && sizeRemain >= items[i]) {
                    chosen.flip(i);
                    localMax = Math.max(localMax,
                            dfs(bagSize, items, sizeRemain - items[i], chosen));
                    chosen.flip(i);
                }
            }
            //if entered for loop and if
            cache.put(key, localMax == 0 ? bagSize - sizeRemain : localMax);
        }
        return cache.get(key);
    }

    static class Key {
        private final int sizeRemain;
        private final BitSet chosen;

        Key(int s, BitSet c) {
            this.sizeRemain = s;
            this.chosen = c;
        }

        @Override
        public int hashCode() {
            return sizeRemain * 33 + chosen.hashCode();
        }

        @Override
        public boolean equals(Object lhs) {
            if (lhs == null || !(lhs instanceof Key)) {
                return false;
            }
            Key other = (Key) lhs;
            return this.sizeRemain == other.sizeRemain &&
                    this.chosen.equals(other.chosen);
        }
    }

    static public class Test {
        static private Backpack _solution = new Backpack();

        static public void randomTest() {
            int[] items = {2, 3, 5, 7};
            int rst1 = _solution.backPack(12, items);
            System.out.println(rst1);
        }
    }
}
