package leetcode.editor.en;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class P355DesignTwitterTest {

    private P355DesignTwitter.Twitter twitter;

    @BeforeEach
    public void setUp() {
        twitter = new P355DesignTwitter().new Twitter();
    }

    @Test
    public void test1() {
        twitter.postTweet(1, 5);
        assertEquals(List.of(5), twitter.getNewsFeed(1));
        twitter.follow(1, 2);
        twitter.postTweet(2, 6);
        assertEquals(List.of(6, 5), twitter.getNewsFeed(1));
        twitter.unfollow(1, 2);
        assertEquals(List.of(5), twitter.getNewsFeed(1));
    }

    @Test
    public void test2() {
        twitter.postTweet(1, 5);
        twitter.postTweet(1, 3);
        twitter.postTweet(1, 101);
        twitter.postTweet(1, 13);
        twitter.postTweet(1, 10);
        twitter.postTweet(1, 2);
        twitter.postTweet(1, 94);
        twitter.postTweet(1, 505);
        twitter.postTweet(1, 333);
        twitter.postTweet(1, 22);
        twitter.postTweet(1, 11);
        assertEquals(List.of(11, 22, 333, 505, 94, 2, 10, 13, 101, 3), twitter.getNewsFeed(1));
    }

    @Test
    public void test3() {
        twitter.postTweet(1, 5);
        twitter.postTweet(2, 3);
        twitter.postTweet(1, 101);
        twitter.postTweet(2, 13);
        twitter.postTweet(2, 10);
        twitter.postTweet(1, 2);
        twitter.postTweet(1, 94);
        twitter.postTweet(2, 505);
        twitter.postTweet(1, 333);
        twitter.postTweet(2, 22);
        twitter.postTweet(1, 11);
        twitter.postTweet(1, 205);
        twitter.postTweet(2, 203);
        twitter.postTweet(1, 201);
        twitter.postTweet(2, 213);
        twitter.postTweet(1, 200);
        twitter.postTweet(2, 202);
        twitter.postTweet(1, 204);
        twitter.postTweet(2, 208);
        twitter.postTweet(2, 233);
        twitter.postTweet(1, 222);
        twitter.postTweet(2, 211);
        assertEquals(List.of(222,204,200,201,205,11,333,94,2,101), twitter.getNewsFeed(1));
        assertEquals(List.of(211,233,208,202,213,203,22,505,10,13), twitter.getNewsFeed(2));
        twitter.follow(1, 2);
        assertEquals(List.of(211,222,233,208,204,202,200,213,201,203), twitter.getNewsFeed(1));
        twitter.unfollow(1, 2);
        assertEquals(List.of(222,204,200,201,205,11,333,94,2,101), twitter.getNewsFeed(1));
    }
}