package leetcode.other;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by qifu on 17/2/11.
 */
public class CourseSscheduleII {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];

        for(int[] cur : prerequisites){
            indegree[cur[0]]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < numCourses; i++){
            if(indegree[i] == 0){
                queue.add(i);
            }
        }
        int[] res = new int[numCourses];
        int index = 0;
        while(!queue.isEmpty()){
            numCourses--;
            int cur_course = queue.poll();
            res[index++] = cur_course;

            for(int[] pair : prerequisites){
                if(pair[1] == cur_course){
                    indegree[pair[0]]--;
                    if(indegree[pair[0]] == 0){
                        queue.add(pair[0]);
                    }
                }
            }
        }
        if(numCourses > 0) return new int[0];
        else {
            return res;
        }
    }
}
