package com.krisven;

import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.annotation.AfterJob;
import org.springframework.batch.core.annotation.BeforeJob;

public class ReportListener {
    @BeforeJob
    public void beforeJob(JobExecution jobExecution){
        System.out.println("JobExecution createTime:" + jobExecution.getCreateTime());
    }

    @AfterJob
    public void afterJob(JobExecution jobExecution){
        System.out.println("JobExecution endTime:" + jobExecution.getEndTime());
    }

}
