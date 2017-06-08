package leetcode.Implement;

import java.util.*;

/**
 * Created by qifu on 17/2/14.
 */
public class DesignTwitter {
    //keep time;
    int timeStamp = 0;
    Map<Integer, User> userMap;
    //User class
    public class User {
        int id;
        Set<Integer> followeed;
        Tweet tweet_head;

        public User(int id) {
            this.id = id;
            followeed = new HashSet<>();
            follow(id);
            tweet_head = null;
        }
        public void follow(int id) {
            followeed.add(id);
        }
        public void unfollow(int id) {
            followeed.remove(id);
        }
        public void post(int id) {
            Tweet new_tweet = new Tweet(id);
            new_tweet.next = tweet_head;
            tweet_head = new_tweet;
        }
    }

    //Tweet class
    public class Tweet {
        int id;
        int time;
        Tweet next;

        public Tweet(int id) {
            this.id = id;
            this.time = timeStamp++;
            next = null;
        }
    }


    /** Initialize your data structure here. */
    public Twitter() {
        userMap = new HashMap<>();
    }

    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        if(!userMap.containsKey(userId)) {
            User new_user = new User(userId);
            userMap.put(userId, new_user);
        }
        userMap.get(userId).post(tweetId);
    }

    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> res = new LinkedList<>();
        if(!userMap.containsKey(userId)) return res;

        Set<Integer> followeed_users = userMap.get(userId).followeed;
        PriorityQueue<Tweet> queue = new PriorityQueue<>(followeed_users.size(), (a, b)->(b.time - a.time));
        for(int cur : followeed_users) {
            Tweet tweet = userMap.get(cur).tweet_head;
            if(tweet != null) {
                queue.add(tweet);
            }
        }

        int count = 0;
        while(!queue.isEmpty() && count < 10) {
            Tweet tweet = queue.poll();
            res.add(tweet.id);
            count++;
            if(tweet.next != null) {
                queue.add(tweet.next);
            }
        }
        return res;
    }

    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        if(!userMap.containsKey(followerId)) {
            User new_user = new User(followerId);
            userMap.put(followerId, new_user);
        }
        if(!userMap.containsKey(followeeId)) {
            User new_user = new User(followeeId);
            userMap.put(followeeId, new_user);
        }
        userMap.get(followerId).follow(followeeId);
    }

    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        if(!userMap.containsKey(followerId) || followerId == followeeId) return;
        userMap.get(followerId).unfollow(followeeId);
    }
}
