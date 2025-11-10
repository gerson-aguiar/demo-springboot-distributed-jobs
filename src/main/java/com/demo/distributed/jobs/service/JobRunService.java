package com.demo.distributed.jobs.service;

import com.demo.distributed.jobs.entity.JobRunRequest;
import com.demo.distributed.jobs.repository.JobRunRequestRepository;
import org.springframework.stereotype.Service;

@Service
public class JobRunService {

    private final JobRunRequestRepository jobRunRequestRepository;

    public JobRunService(JobRunRequestRepository jobRunRequestRepository) {
        this.jobRunRequestRepository = jobRunRequestRepository;
    }

    public JobRunRequest createRunRequest(String jobName) {
        JobRunRequest jobRunRequest = new JobRunRequest();

        return jobRunRequestRepository.save(jobRunRequest);
    }
}
