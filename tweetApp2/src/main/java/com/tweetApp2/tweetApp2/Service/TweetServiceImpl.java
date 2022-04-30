package com.tweetApp2.tweetApp2.Service;


import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tweetApp2.tweetApp2.entity.Tweet;
import com.tweetApp2.tweetApp2.Dao.Tweetdao;;

@Service
public class TweetServiceImpl implements TweetService {
	 
	@Autowired
	private Tweetdao Tweetdao; 
	 
	public TweetServiceImpl() {
		
	}

	@Override
	public List<Tweet> getAllTweets() {
		return Tweetdao.findAll();
	}

	@Override
	public Tweet addtweet(Tweet tweet) {
		Tweetdao.save(tweet);
		return tweet;
	}

	@Override
	public Tweet updateTweet(Tweet tweet) {
		Tweetdao.save(tweet);
		return tweet;
	}

	@SuppressWarnings("deprecation")
	@Override
	public void deletetweet(long tweetID) {
		Tweet entity= Tweetdao.getOne(tweetID);
		Tweetdao.delete(entity);
		
		
	}

	

	

}
