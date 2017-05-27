package leetcode.other;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by qifu on 17/2/11.
 */
public class CourseSscheduleII {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        for(int[] cur : prerequisites) {
            indegree[cur[0]]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < numCourses; i++) {
            if(indegree[i] == 0) {
                queue.add(i);
            }
        }
        int[] res = new int[numCourses];
        int index = 0;
        while(!queue.isEmpty()) {
            numCourses--;
            int finished = queue.poll();
            res[index++] = finished;
            for(int[] cur : prerequisites) {
                if(cur[1] == finished) {
                    indegree[cur[0]]--;
                    if(indegree[cur[0]] == 0) {
                        queue.add(cur[0]);
                    }
                }
            }
        }
        if(numCourses > 0) return new int[0];
        else return res;
    }
}
/*
开一个数组存入度, 入度为0表示该课程可被完成,
首先将入度为0的课程存入队列,
扫队列, 将以当前课程为前置的课程入度减1,
如果入度为0 存入队列
直到队列为空
若numCourses大于0则表示课程并没全部完成

 */