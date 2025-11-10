package com.demo.distributed.jobs.service;

import com.demo.distributed.jobs.entity.JobExecutionTracker;
import com.demo.distributed.jobs.repository.JobExecutionTrackerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.lang.management.ManagementFactory;
import java.time.Clock;
import java.time.Instant;

@Service
public class JobExecutionTrackerService {
    private static final Logger log = LoggerFactory.getLogger(JobExecutionTrackerService.class);

    private final JobExecutionTrackerRepository jobExecutionTrackerRepository;
    private final Clock clock;
    private final String instanceId;

    public JobExecutionTrackerService(JobExecutionTrackerRepository jobExecutionTrackerRepository) {
        this.jobExecutionTrackerRepository = jobExecutionTrackerRepository;
        this.clock = Clock.systemUTC();
        this.instanceId = ManagementFactory.getRuntimeMXBean().getName();
    }

    @Transactional
    public JobExecutionTracker registerExecution(String jobName) {
        Instant now = clock.instant();

        JobExecutionTracker tracker = jobExecutionTrackerRepository
                .findByJobName(jobName)
                .orElseGet(() -> jobExecutionTrackerRepository.save(
                        new JobExecutionTracker(jobName, 0L, now, instanceId)
                ));

        tracker.markExecuted(now, instanceId);

        JobExecutionTracker updated = jobExecutionTrackerRepository.save(tracker);

        log.info("Job [{}] executed at {} \n(count={}, instance={})",
                jobName,
                updated.getLastExecutionAt(),
                updated.getExecutionCount(),
                updated.getLastUpdatedBy()
        );
        return updated;
    }
}
