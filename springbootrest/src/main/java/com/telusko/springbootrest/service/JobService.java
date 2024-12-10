package com.telusko.springbootrest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.telusko.springbootrest.model.JobPost;
import com.telusko.springbootrest.repo.JobRepo;


@Service
public class JobService {
	@Autowired
	public JobRepo repo;
	
	
	
	//method to return all JobPosts
	public List<JobPost> getAllJobs() {
		return repo.getAllJobs();

		
	}
	
	
	
	

	// ***************************************************************************


	
	
	
	// method to add a jobPost
	public void addJobPost(JobPost jobPost) {
		 repo.addJobPost(jobPost);
	
	}





    public JobPost getJob(int postId) {
        // TODO Auto-generated method stub
		return repo.getJob(postId);
	}





	public void updateJob(JobPost jobPost) {
		// TODO Auto-generated method stub

		repo.updateJob(jobPost);

	}





    public void deleteJob(int postId) {
        // TODO Auto-generated method stub
	
		repo.deleteJob(postId);
	}


	
}
