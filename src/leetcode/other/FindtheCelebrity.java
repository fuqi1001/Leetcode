package leetcode.other;

/**
 * Created by qifu on 17/2/4.
 */


/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */
public class FindtheCelebrity {
    public int findCelebrity(int n) {
        int candidate = 0;
        for(int i = 1; i < n; i++){
            if(knows(candidate, i)){   // if candidate know i, candidate cant be candidate anymore.
                candidate = i;  //switch i to candidate.
            }
        }

        for(int i = 0; i < n; i++){
            if( (i != candidate && knows(candidate,i)) || !(knows(i,candidate)) ) return -1;;
        }

        return candidate;
    }
}
