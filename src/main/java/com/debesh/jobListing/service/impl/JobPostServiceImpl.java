package com.debesh.jobListing.service.impl;

import com.debesh.jobListing.entity.JobPost;
import com.debesh.jobListing.model.JobPostModel;
import com.debesh.jobListing.repository.JobPostRepository;
import com.debesh.jobListing.repository.SearchJobRepository;
import com.debesh.jobListing.service.JobPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobPostServiceImpl implements JobPostService {

    @Autowired
    JobPostRepository jpr;
    @Autowired
    SearchJobRepository sjr;

    public JobPostModel createJobPost(JobPostModel jobPostModel){
        JobPost jp = new JobPost();
        jp.setProfile(jobPostModel.getProfile());
        jp.setDesc(jobPostModel.getDesc());
        jp.setExp(jobPostModel.getExp());
        jp.setTechs(jobPostModel.getTechs());
        jpr.save(jp);
        return jobPostModel;
    }

    @Override
    public List<JobPost> getAllJobs() {
        return jpr.findAll();
    }

    @Override
    public List<JobPostModel> searchJobs(String keyword) {
        return sjr.searchByText(keyword);
    }

}
