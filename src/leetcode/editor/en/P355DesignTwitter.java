//Design a simplified version of Twitter where users can post tweets, follow/
//unfollow another user, and is able to see the 10 most recent tweets in the user's 
//news feed. 
//
// Implement the Twitter class: 
//
// 
// Twitter() Initializes your twitter object. 
// void postTweet(int userId, int tweetId) Composes a new tweet with ID tweetId 
//by the user userId. Each call to this function will be made with a unique 
//tweetId. 
// List<Integer> getNewsFeed(int userId) Retrieves the 10 most recent tweet IDs 
//in the user's news feed. Each item in the news feed must be posted by users who 
//the user followed or by the user themself. Tweets must be ordered from most 
//recent to least recent. 
// void follow(int followerId, int followeeId) The user with ID followerId 
//started following the user with ID followeeId. 
// void unfollow(int followerId, int followeeId) The user with ID followerId 
//started unfollowing the user with ID followeeId. 
// 
//
// 
// Example 1: 
//
// 
//Input
//["Twitter", "postTweet", "getNewsFeed", "follow", "postTweet", "getNewsFeed", 
//"unfollow", "getNewsFeed"]
//[[], [1, 5], [1], [1, 2], [2, 6], [1], [1, 2], [1]]
//Output
//[null, null, [5], null, null, [6, 5], null, [5]]
//
//Explanation
//Twitter twitter = new Twitter();
//twitter.postTweet(1, 5); // User 1 posts a new tweet (id = 5).
//twitter.getNewsFeed(1);  // User 1's news feed should return a list with 1 
//tweet id -> [5]. return [5]
//twitter.follow(1, 2);    // User 1 follows user 2.
//twitter.postTweet(2, 6); // User 2 posts a new tweet (id = 6).
//twitter.getNewsFeed(1);  // User 1's news feed should return a list with 2 
//tweet ids -> [6, 5]. Tweet id 6 should precede tweet id 5 because it is posted 
//after tweet id 5.
//twitter.unfollow(1, 2);  // User 1 unfollows user 2.
//twitter.getNewsFeed(1);  // User 1's news feed should return a list with 1 
//tweet id -> [5], since user 1 is no longer following user 2.
// 
//
// 
// Constraints: 
//
// 
// 1 <= userId, followerId, followeeId <= 500 
// 0 <= tweetId <= 10⁴ 
// All the tweets have unique IDs. 
// At most 3 * 10⁴ calls will be made to postTweet, getNewsFeed, follow, and 
//unfollow. 
// 
// Related Topics Hash Table Linked List Design Heap (Priority Queue) 👍 1950 👎
// 271


package leetcode.editor.en;

// 2022-04-09 15:46:51

import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

public class P355DesignTwitter {
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Twitter {

        class Tweet {
            int tweetId;
            int userId;
            int timestamp;

            Tweet next;

            Tweet(int tweetId, int userId) {
                this.tweetId = tweetId;
                this.userId = userId;
                this.timestamp = globalTimestamp;
                globalTimestamp++;
            }
        }

        class User {
            int userId;
            Set<Integer> followees; // In pull model, keep track of users whom current user is following
            Tweet myTweets; // Current user's tweets

            public User(int userId) {
                this.userId = userId;
                this.followees = new HashSet<>();
                this.followees.add(userId); // follow self so that feeds include self tweets
            }

            void follow(int followeeId) {
                this.followees.add(followeeId);
            }

            void unfollow(int followeeId) {
                this.followees.remove(followeeId);
            }

            Tweet tweet(int tweetId) {
                Tweet t = new Tweet(tweetId, userId);
                t.next = myTweets;
                myTweets = t;
                return myTweets;
            }

            List<Integer> getTop10Feed() {
                List<Integer> top10 = new LinkedList<>();

                // Create and initialize max heap
                Queue<Tweet> maxHeap = new PriorityQueue<>(Comparator.comparingInt(tweet -> -tweet.timestamp));
                for (int followeeId : followees) {
                    User followee = userPool.get(followeeId);
                    Tweet followeeTweets = followee.myTweets;
                    if (followeeTweets != null) {
                        maxHeap.offer(followeeTweets);
                    }
                }

                // Collect top 10 latest
                while (!maxHeap.isEmpty() && top10.size() < 10) {
                    Tweet tweet = maxHeap.poll();
                    top10.add(tweet.tweetId);
                    if (tweet.next != null) {
                        tweet = tweet.next;
                        maxHeap.offer(tweet);
                    }
                }

                return top10;
            }
        }

        private int globalTimestamp;
        private Map<Integer, User> userPool;

        public Twitter() {
            this.globalTimestamp = 0;
            this.userPool = new HashMap<>();
        }

        public void postTweet(int userId, int tweetId) {
            // 1. Create tweet
            User user = userPool.computeIfAbsent(userId, User::new);
            user.tweet(tweetId);
        }

        public List<Integer> getNewsFeed(int userId) {
            if (!userPool.containsKey(userId)) {
                return List.of();
            }
            return userPool.get(userId).getTop10Feed();
        }

        public void follow(int followerId, int followeeId) {
            User follower = userPool.computeIfAbsent(followerId, User::new);
            userPool.computeIfAbsent(followeeId, User::new);
            follower.follow(followeeId);
        }

        public void unfollow(int followerId, int followeeId) {
            if (!userPool.containsKey(followerId)) {
                return;
            }
            userPool.get(followerId).unfollow(followeeId);
        }
    }

    /**
     * Your Twitter object will be instantiated and called as such:
     * Twitter obj = new Twitter();
     * obj.postTweet(userId,tweetId);
     * List<Integer> param_2 = obj.getNewsFeed(userId);
     * obj.follow(followerId,followeeId);
     * obj.unfollow(followerId,followeeId);
     */
    //leetcode submit region end(Prohibit modification and deletion)
    public static void main(String[] args) {
        Queue<Integer> pq = new PriorityQueue<>();
        pq.offer(3);
        pq.offer(1);
        pq.offer(2);

        for (int n : pq) {
            System.out.print(n + " "); // 1 3 2
        }

        System.out.println();

        Iterator<Integer> iter = pq.iterator();
        iter.forEachRemaining(System.out::println); // 1 3 2
    }
}