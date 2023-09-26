package com.example.FindJob.JobRepo;

import com.example.FindJob.Models.JobPost;

import java.util.List;

public interface SearchRepo {
    List<JobPost> findByText(String text);
}
