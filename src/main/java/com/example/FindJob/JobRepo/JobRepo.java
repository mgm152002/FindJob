package com.example.FindJob.JobRepo;

import com.example.FindJob.Models.JobPost;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobRepo extends MongoRepository<JobPost,String> {
}
