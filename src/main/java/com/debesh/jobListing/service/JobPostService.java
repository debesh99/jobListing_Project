package com.debesh.jobListing.service;

import com.debesh.jobListing.entity.JobPost;
import com.debesh.jobListing.model.JobPostModel;
import org.springframework.stereotype.Service;

import java.util.List;

public interface JobPostService {
    JobPostModel createJobPost(JobPostModel jobPostModel);
    List<JobPost> getAllJobs();
    List<JobPostModel> searchJobs(String keyword);
}
