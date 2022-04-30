package com.tweetApp2.tweetApp2.Service;

import java.util.List;

import com.tweetApp2.tweetApp2.entity.Tweet;


public interface TweetService {
	public List<Tweet> getAllTweets();
	public Tweet addtweet(Tweet tweet);
	public Tweet updateTweet(Tweet tweet);
	public void deletetweet(long tweetID);
	
}
