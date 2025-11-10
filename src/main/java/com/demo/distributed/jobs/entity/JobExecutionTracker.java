package com.demo.distributed.jobs.entity;

import jakarta.persistence.*;

import java.time.Instant;

@Entity
@Table(
        name = "job_execution_tracker",
        uniqueConstraints = {
                @UniqueConstraint(name = "uk_job_execution_tracker_job_name", columnNames = "job_name")
        }
)
public class JobExecutionTracker {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "job_name", nullable = false, unique = true)
    private String jobName;

    @Column(name = "execution_count", nullable = false)
    private Long executionCount;

    @Column(name = "last_execution_at", nullable = false)
    private Instant lastExecutionAt;

    @Column(name = "last_updated_by", nullable = false)
    private String lastUpdatedBy;


    @Version
    private long version;

    protected JobExecutionTracker() {
        // JPA
    }

    public JobExecutionTracker(String jobName, Long executionCount, Instant lastExecutionAt, String lastUpdatedBy) {
        this.jobName = jobName;
        this.executionCount = executionCount;
        this.lastExecutionAt = lastExecutionAt;
        this.lastUpdatedBy = lastUpdatedBy;
    }

    public Long getId() {
        return id;
    }

    public Long getVersion() { return version;}

    public String getJobName() {
        return jobName;
    }

    public Long getExecutionCount() {
        return executionCount;
    }

    public Instant getLastExecutionAt() {
        return lastExecutionAt;
    }

    public String getLastUpdatedBy() {
        return lastUpdatedBy;
    }

    public void markExecuted(Instant executionTime, String updatedBy) {
        this.executionCount = this.executionCount + 1;
        this.lastExecutionAt = executionTime;
        this.lastUpdatedBy = updatedBy;
    }
}

