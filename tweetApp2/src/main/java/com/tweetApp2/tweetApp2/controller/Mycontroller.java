package com.tweetApp2.tweetApp2.controller;

import java.util.List;

import org.hibernate.cache.spi.support.AbstractReadWriteAccess.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.tweetApp2.tweetApp2.entity.Tweet;
import com.tweetApp2.tweetApp2.message.ItemProducer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tweetApp2.tweetApp2.Service.TweetService;
@CrossOrigin(origins = {"http://localhost:3000"})
@RestController
public class Mycontroller {
	
	@Autowired
	private TweetService TweetService;
	
	@Autowired
    ObjectMapper objectMapper;
    
    @Autowired
    ItemProducer itemProducer;
	
	@GetMapping("/api/v1.0/tweets/all")
	public List<Tweet> getAllTweets(){
		return this.TweetService.getAllTweets();
	}
	@PostMapping("/api/v1.0/tweets/add")
	public Tweet addtweet(@RequestBody Tweet tweet) {
		return this.TweetService.addtweet(tweet);
	}
	@PutMapping("/api/v1.0/tweets/update")
	public Tweet updateTweet(@RequestBody Tweet tweet){
		return this.TweetService.updateTweet(tweet);
	}
	@DeleteMapping("/api/v1.0/tweets/<username>/delete/{tweetID}")
	public ResponseEntity<HttpStatus> deletetweet(@PathVariable String tweetID){
		try {
			this.TweetService.deletetweet(Long.parseLong(tweetID));
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e)
		{
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	 @PostMapping(value = "/postItem",consumes = {"application/json"},produces = {"application/json"})
	    public String postJsonMessage(@RequestBody Item item) {
	    	
	        try {
	        	String itemStr=objectMapper.writeValueAsString(item);
	        	itemProducer.publishItem(itemStr);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        return "Message published successfully";
	    }
}
