package leetcode.Implement;

import java.util.*;

/**
 * Created by qifu on 17/2/14.
 */
public class DesignTwitter {
    int timeStamp = 0;
    private Map<Integer, User> userMap;

    public class Tweet {
        public int id;
        public int time;
        public Tweet next;

        public Tweet(int id){
            this.id = id;
            time = timeStamp++;
            next = null;
        }
    }

    private class User {
        public int id;
        public Set<Integer> followed;   //keep follow info
        public Tweet tweet_head;        //keep first tweet;

        public User(int id) {
            this.id = id;
            followed = new HashSet<>();
            follow(id);
            tweet_head = null;
        }

        public void follow(int id){
            followed.add(id);
        }

        public void unfollow(int id){
            followed.remove(id);
        }
        public void post(int id){
            Tweet temp = new Tweet(id);
            temp.next = tweet_head;
            tweet_head = temp;
        }
    }

    /** Initialize your data structure here. */
    public Twitter() {
        userMap = new HashMap<Integer, User>();
    }

    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        if(!userMap.containsKey(userId)){
            User u = new User(userId);
            userMap.put(userId, u);
        }
        userMap.get(userId).post(tweetId);
    }

    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> res = new LinkedList<>();

        if(!userMap.containsKey(userId)) return res;

        Set<Integer> users = userMap.get(userId).followed;
        PriorityQueue<Tweet> queue = new PriorityQueue<Tweet>(users.size(),(a,b)->(b.time - a.time));
        for(int user : users){
            Tweet t = userMap.get(user).tweet_head;
            if(t != null) {
                queue.add(t);
            }
        }

        int n = 0;
        while(!queue.isEmpty() && n < 10){
            Tweet temp = queue.poll();
            res.add(temp.id);
            n++;
            if(temp.next != null){
                queue.add(temp.next);
            }
        }
        return res;
    }

    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        if(!userMap.containsKey(followerId)){
            User u = new User(followerId);
            userMap.put(followerId, u);
        }
        if(!userMap.containsKey(followeeId)){
            User u = new User(followeeId);
            userMap.put(followeeId, u);
        }
        userMap.get(followerId).follow(followeeId);
    }

    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        if(!userMap.containsKey(followerId) || followerId == followeeId) return;
        userMap.get(followerId).unfollow(followeeId);
    }
}
