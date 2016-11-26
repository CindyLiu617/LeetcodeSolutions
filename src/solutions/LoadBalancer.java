package solutions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

//https://zhengyang2015.gitbooks.io/lintcode/content/load_balancer_526.html
//add(): 用list保存加入的server，用dict记录每个server加入的位置，重复加入的server会更新为最新的位置。
//remove(): 先从dict中得到要删去server的位置，然后将list中最后一位元素移到该位置上，
//并将dict中该元素的位置更新，最后删去最后一位元素，并将dict中要删去的server删去。
//为什么要移动而不能直接删去？增加随机性？
//pick(): 用random对象随机生成，nextInt()取整之后％list.size()得到0-list.size()之间的随机数。
public class LoadBalancer {
    ArrayList<Integer> list;
    HashMap<Integer, Integer> dict;

    public LoadBalancer() {
        // Initialize your data structure here.
        list = new ArrayList<Integer>();
        dict = new HashMap<Integer, Integer>();
    }

    // @param server_id add a new server to the cluster
    // @return void
    public void add(int server_id) {
        // Write your code here
        int index = list.size();
        //用dict记录每个server加入的位置，重复加入的server会更新为最新的位置
        dict.put(server_id, index);
        list.add(server_id);
    }

    // @param server_id server_id remove a bad server from the cluster
    // @return void
    public void remove(int server_id) {
        // Write your code here
        //获得要删除元素的位置
        int index = dict.get(server_id);
        //若要删除的server不存在则返回
        if(index == -1){
            return;
        }
        int n = list.size();
        //将list最后一个server移到要删除的位置上，并更新该元素在dict中记录的位置
        list.set(index, list.get(n - 1));
        dict.put(list.get(n - 1), index);
        //删去最后一个元素
        list.remove(n - 1);
        dict.remove(server_id);
    }

    // @return pick a server in the cluster randomly with equal probability
    public int pick() {
        // Write your code here
        int size = list.size();
        Random r = new Random();
        int index = Math.abs(r.nextInt()) % size;
        return list.get(index);
    }
}
