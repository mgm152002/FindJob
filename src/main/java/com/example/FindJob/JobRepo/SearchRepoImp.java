package com.example.FindJob.JobRepo;

import com.example.FindJob.Models.JobPost;
import com.mongodb.client.AggregateIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.convert.MongoConverter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import java.util.ArrayList;
import java.util.List;
@Component
public class SearchRepoImp implements SearchRepo{
    @Autowired
    MongoClient client;

    @Autowired
    MongoConverter converter;

    @Override
    public List<JobPost> findByText(String text) {
        final List<JobPost> posts = new ArrayList<>();

        MongoDatabase database = client.getDatabase("Job");
        MongoCollection<Document> collection = database.getCollection("jobs");

        AggregateIterable<Document> result = collection.aggregate(Arrays.asList(new Document("$search",
                        new Document("text",
                                new Document("query", text)
                                        .append("path", Arrays.asList("tech", "desc", "title")))),
                new Document("$sort",
                        new Document("exp", 1L)),
                new Document("$limit", 5L)));

        result.forEach(doc -> posts.add(converter.read(JobPost.class,doc)));

        return posts;

    }
}
