package com.debesh.jobListing.repository;

import com.debesh.jobListing.model.JobPostModel;
import com.mongodb.client.AggregateIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.convert.MongoConverter;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class SearchJobRepoImpl implements SearchJobRepository {
    @Autowired
    MongoClient mongoClient;

    @Autowired
    MongoConverter mongoConverter;

    @Override
    public List<JobPostModel> searchByText(String keyword) {
        List<JobPostModel> jobLists = new ArrayList<>();

//        Aggregated this below code from mongodb atlas
        MongoDatabase database = mongoClient.getDatabase("debesh");
        MongoCollection<Document> collection = database.getCollection("jobposts");
        AggregateIterable<Document> result = collection.aggregate(Arrays.asList(new Document("$search",
                        new Document("text",
                                new Document("query", keyword)
                                        .append("path", Arrays.asList("profile", "desc", "techs")))),
                new Document("$sort",
                        new Document("exp", 1L))));

// Convert the document result into JobPostModel
        result.forEach(doc -> {
            JobPostModel jobPostModel = mongoConverter.read(JobPostModel.class, doc);
            jobLists.add(jobPostModel);
        });

        return jobLists;
    }
}

