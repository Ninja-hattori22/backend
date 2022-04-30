package com.tweetApp2.tweetApp2.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tweetApp2.tweetApp2.entity.Tweet;

public interface Tweetdao extends JpaRepository<Tweet, Long>{

}
