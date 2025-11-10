package com.demo.distributed.jobs.entity;

import com.demo.distributed.jobs.enums.JobRunStatus;
import jakarta.persistence.*;

@Entity
@Table(name = "job_run_request")
public class JobRunRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String jobName;

    @Enumerated(EnumType.STRING)
    private JobRunStatus status;
}
