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
import java.util.stream.Collectors;

public class P355DesignTwitter {
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Twitter {
        
        class Tweet {
            int userId, tweetId, timestamp;
            Tweet(int uid, int tid, int time) {
                this.userId = uid;
                this.tweetId = tid;
                this.timestamp = time;
            }
        }

        class User {
            int userId;
            List<Tweet> tweets; // user's own up to latest 10 tweets
            Set<Integer> followingUserIds; // this user is following these users

            User(int id) {
                this.userId = id;
                this.tweets = new LinkedList<>();
                this.followingUserIds = new HashSet<>();
                this.followingUserIds.add(this.userId); // follow self
            }

            void postTweet(Tweet tweet) {
                this.tweets.add(0, tweet);
                if (this.tweets.size() > 10) {
                    this.tweets.remove(this.tweets.size() - 1);
                }
            }

            void follow(User toFollow) {
                this.followingUserIds.add(toFollow.userId);
            }

            void unfollow(User toUnfollow) {
                this.followingUserIds.remove(toUnfollow.userId);
            }
        }

        private int timestamp;
        private final Map<Integer, User> userMap;

        public Twitter() {
            this.timestamp = 0;
            this.userMap = new HashMap<>();
        }

        public void postTweet(int userId, int tweetId) {
            User user = this.userMap.computeIfAbsent(userId, User::new);
            Tweet tweet = new Tweet(userId, tweetId, this.timestamp);
            this.timestamp++;
            user.postTweet(tweet);
        }

        public List<Integer> getNewsFeed(int userId) {
            User user = this.userMap.get(userId);
            if (user == null) {
                return List.of();
            }

            Queue<Tweet> tweetPriorityQueue = new PriorityQueue<>(Comparator.comparingInt(tweet -> -tweet.timestamp));
            Map<Integer, Iterator<Tweet>> iteratorMap = new HashMap<>();
            
            for (int followingUserId : user.followingUserIds) {
                User followingUser = this.userMap.get(followingUserId);
                Iterator<Tweet> iterator = followingUser.tweets.iterator();
                if (iterator.hasNext()) {
                    tweetPriorityQueue.offer(iterator.next());
                    iteratorMap.put(followingUserId, iterator);
                }
            }

            List<Integer> res = new LinkedList<>();
            while (res.size() < 10 && !tweetPriorityQueue.isEmpty()) {
                Tweet tweet = tweetPriorityQueue.poll();
                Iterator<Tweet> iterator = iteratorMap.get(tweet.userId);
                if (iterator.hasNext()) {
                    tweetPriorityQueue.offer(iterator.next());
                }
                res.add(tweet.tweetId);
            }
            
            return res;
        }

        public void follow(int followerId, int followeeId) {
            User follower = this.userMap.computeIfAbsent(followerId, User::new);
            User followee = this.userMap.computeIfAbsent(followeeId, User::new);
            follower.follow(followee);
        }

        public void unfollow(int followerId, int followeeId) {
            User follower = this.userMap.computeIfAbsent(followerId, User::new);
            User followee = this.userMap.computeIfAbsent(followeeId, User::new);
            follower.unfollow(followee);
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
}