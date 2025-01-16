package com.debesh.jobListing.controller;

import com.debesh.jobListing.entity.JobPost;
import com.debesh.jobListing.model.JobPostModel;
import com.debesh.jobListing.service.JobPostService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
@CrossOrigin
public class JobPostController {

    private static final Logger logger = LoggerFactory.getLogger(JobPostController.class);

    @Autowired
    private JobPostService jps;

    @PostMapping("/addPost")
    public ResponseEntity<JobPostModel> addPost(@RequestBody JobPostModel jobPostModel){
        JobPostModel createdJobPost = jps.createJobPost(jobPostModel);
        logger.info("Job post created successfully: {} ", createdJobPost);
        return new ResponseEntity<JobPostModel>(createdJobPost, HttpStatus.OK);
    }

    @GetMapping("/allPosts")
    public ResponseEntity<List<JobPost>> getAllJobs(){
        List<JobPost> ljp = jps.getAllJobs();
        return new ResponseEntity<List<JobPost>>(ljp, HttpStatus.OK);
    }

    @GetMapping("/searchPost/{post}")
    public ResponseEntity<List<JobPostModel>> searchPost(@PathVariable String post){
        List<JobPostModel> result = jps.searchJobs(post);
        return new ResponseEntity<List<JobPostModel>>(result, HttpStatus.OK);
    }
}
