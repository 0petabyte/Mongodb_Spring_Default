package com.peta.home;

import java.util.List;

import javax.inject.Inject;

import org.bson.Document;
import org.bson.types.ObjectId;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mongodb.WriteConcern;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.peta.config.MongoDBConfig;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=MongoDBConfig.class)
public class TestDbGet extends MongoDBConfig{

	@Inject
	private MongoTemplate mongoTemplate;
	
	@Inject
	private MongoDatabase db;
	
	
	@Test
	public void test() throws Exception{
		
		String uid = "5e40d926260f0e184ff2a0a0";
		System.out.println("MongoClient Start----------------");
		
		MongoCollection<Document> target = db.getCollection("board");
		Document find = new Document("_id", new ObjectId(uid));
		Document clientDoc = target.find(find).first();
		System.out.println(clientDoc);
		
		System.out.println("MongoClient END----------------");
		
		
		System.out.println("MongoTemplate Start----------------");
		
		Query query = new Query();

		query = new Query((new Criteria()).
				andOperator(new Criteria[] { Criteria.where("id").is(uid)}));
		
		List<TestDTO> test = mongoTemplate.find(query, TestDTO.class,"board");
		
		System.out.println(test.toString());
		
		System.out.println("MongoTemplate END----------------");
	}
}
