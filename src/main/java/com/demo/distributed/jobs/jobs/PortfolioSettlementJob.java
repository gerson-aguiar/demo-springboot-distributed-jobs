package com.demo.distributed.jobs.jobs;

import com.demo.distributed.jobs.service.JobExecutionTrackerService;
import net.javacrumbs.shedlock.spring.annotation.SchedulerLock;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class PortfolioSettlementJob {

    private static final Logger log = LoggerFactory.getLogger(PortfolioSettlementJob.class);
    private static final String JOB_NAME = "portfolio-settlement";

    private final JobExecutionTrackerService jobExecutionTrackerService;

    public PortfolioSettlementJob(JobExecutionTrackerService jobExecutionTrackerService) {
        this.jobExecutionTrackerService = jobExecutionTrackerService;
    }

    @Scheduled(fixedRate = 1_000)
    @SchedulerLock(name = "portfolio-settlement", lockAtLeastFor = "PT1S", lockAtMostFor = "PT10S")
    public void reconcilePortfolios() {
        log.info("Starting scheduled execution for [{}]", JOB_NAME);
        jobExecutionTrackerService.registerExecution(JOB_NAME);
    }
}

