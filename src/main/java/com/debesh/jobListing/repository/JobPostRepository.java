package com.debesh.jobListing.repository;

import com.debesh.jobListing.entity.JobPost;
import com.debesh.jobListing.model.JobPostModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobPostRepository extends MongoRepository<JobPost,Long> {

}
