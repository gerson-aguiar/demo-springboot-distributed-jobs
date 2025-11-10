package com.demo.distributed.jobs.repository;

import com.demo.distributed.jobs.entity.JobRunRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface JobRunRequestRepository extends JpaRepository<JobRunRequest, Long> {

    Optional<JobRunRequest> findByJobNameAndStatus(
            String jobName,
            String status
    );
}
