package com.example.FindJob.Models;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Arrays;

@Document(collection = "jobs")
@Data

public class JobPost {
    private String title;
    private String desc;
    private String location;
    private String[] tech;
    private int exp;

    @Override
    public String toString() {
        return "JobPost{" +
                "title='" + title + '\'' +
                ", desc='" + desc + '\'' +
                ", location='" + location + '\'' +
                ", tech=" + Arrays.toString(tech) +
                ", exp=" + exp +
                '}';
    }
}
