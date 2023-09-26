package com.example.FindJob.JobService;

import com.example.FindJob.JobRepo.JobRepo;
import com.example.FindJob.JobRepo.SearchRepo;
import com.example.FindJob.Models.JobPost;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobService {
    @Autowired
    JobRepo jb;
    @Autowired
    SearchRepo sp;
    public List<JobPost>getAll(){
        return jb.findAll();
    }

    public void addJob(JobPost Jp) {
        jb.insert(Jp);
    }

    public List<JobPost> getJobByText(String text) {
        return sp.findByText(text);
    }
}
