package com.demo.distributed.jobs.repository;

import com.demo.distributed.jobs.entity.JobExecutionTracker;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface JobExecutionTrackerRepository extends JpaRepository<JobExecutionTracker, Long> {

    Optional<JobExecutionTracker> findByJobName(String jobName);
}
