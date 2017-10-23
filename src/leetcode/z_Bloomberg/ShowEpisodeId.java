package leetcode.z_Bloomberg;

import java.util.HashMap;
import java.util.Map;

public class ShowEpisodeId {
    Map<Integer, int[]> map;
    public ShowEpisodeId() {
        map = new HashMap<Integer, int[]>();
    }

    public void process(int show, int episode, int id) {
        map.getOrDefault(show, new int[10])[episode]++;
    }
    public void count_x() {
        int tot = map.size();
        int[] show_people = new int[tot];
        for(Map.Entry<Integer, int[]> entry : map.entrySet()){
            for(int num : entry.getValue()){
                show_people[entry.getKey()] = Math.max(show_people[entry.getKey()], num);
            }
        }
        int[] res = new int[tot];
        for(Map.Entry<Integer, int[]> entry : map.entrySet()){
            int index = entry.getKey();
            int[] nums = entry.getValue();
            for(int i = 0 ; i < 10; i++) {
                if(nums[i] / )
            }
        }
    }
    /*
    2. 设计题, 给一个文件, 上面有很多条log, log的形式是: "节目|集数|用户id", 定义一个标准x, 表示至少70%看过前x集的用户接着看完所有的集数, 输出每个节目对应x的最小值.
- 如果一个节目不存在这个x, 则不用输出.
- 一个用户如果看了i集, 那么, 第1到第i集都会看, 比如用户看了第三集, 那么文件中log就会出现, "节目|1用户id", "节目|2用户id", "节目|3用户id", 不会出现只看第三集的情况.
- 假设每个节目有10集.

要设计数据结构, 然后完成process(show, episode, id), print_x()
比如有100个人看了一个节目前5集, 然后这100个人有90个接着看了所有的集数, 5就是一个valid 的"x"(90 / 100 > 70%). 然而如果有110人看了这个节目前3集, 那么3也是一个valid的"x"(90 / 110 > 70%), 目的就是要找到最小的"x"
     */
}
