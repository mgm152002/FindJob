package com.example.FindJob.JobControllers;

import com.example.FindJob.JobService.JobService;
import com.example.FindJob.Models.JobPost;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(path = "/job")

public class JobController {
    @Autowired
    JobService Js;


    @GetMapping
    public List<JobPost> getJobs(){
        return Js.getAll();
    }
    @PostMapping
    public String addJobs(@RequestBody JobPost Jp){

        Js.addJob(Jp);
        return "Added Successfully";
    }
    @GetMapping("/{text}")
    public List<JobPost>getJobByText(@PathVariable String text){
        return Js.getJobByText(text);

    }
}
