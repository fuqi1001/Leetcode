package leetcode.other;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by qifu on 17/2/7.
 */
public class CourseSchedule {

    ////BFS

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        Queue<Integer> queue = new LinkedList<>();

        for(int[] pair : prerequisites){
            indegree[pair[0]]++;
        }

        for(int i = 0 ; i < numCourses; i++){
            if(indegree[i] == 0){
                queue.add(i);
            }
        }

        while(!queue.isEmpty()){
            numCourses--;
            int course = queue.poll();

            for(int[] pair : prerequisites){
                if(pair[1] == course){
                    indegree[pair[0]]--;
                    if(indegree[pair[0]] == 0){
                        queue.add(pair[0]);
                    }
                }
            }
        }
        return numCourses == 0;
    }

    ////DFS
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(numCourses == 0 || prerequisites.length == 0) return true;
        List<List<Integer>> courses = new ArrayList<List<Integer>>(numCourses);
        for(int i = 0; i < numCourses; i++){
            courses.add(new ArrayList<Integer>());
        }
        for(int[] pair : prerequisites){
            courses.get(pair[1]).add(pair[0]);      //为前置课添加后续可完成课程
        }
        int[] visited = new int[numCourses];
        for(int i = 0 ; i < numCourses; i++){
            if(!dfs(i,courses,visited)) return false;
        }
        return true;
    }

    private boolean dfs(int course, List<List<Integer>> courses, int[] visited){
        visited[course] = 1;                //   作为前置课正在被使用
        List<Integer> child_course = courses.get(course);

        for(int i = 0; i < child_course.size(); i++){
            int cur_course = child_course.get(i);

            if(visited[cur_course] == 1) return false; ///成环;
            if(visited[cur_course] == 0) {
                if(!dfs(cur_course, courses, visited)){
                    return false;
                }
            }
        }

        visited[course] = 2;
        /*
        这里把visited[course]设成2  比设成0 能优化很多
        设成0的话,又把course当成没扫过的点了 下次碰到还会进行dfs操作,
        但是如果设成2的话,下次碰到就能直接跳过
         */
        return true;
    }
}
