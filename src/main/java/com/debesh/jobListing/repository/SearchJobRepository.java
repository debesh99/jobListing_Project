package com.debesh.jobListing.repository;

import com.debesh.jobListing.model.JobPostModel;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SearchJobRepository {
    List<JobPostModel> searchByText(String keyword);
}
