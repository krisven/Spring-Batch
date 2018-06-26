package com.krisven;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;

public class App {
    public static void main(String[] args) {

        String[] springConfig = {"database.xml", "context.xml", "job-report.xml"};

        ApplicationContext context = new ClassPathXmlApplicationContext(springConfig);

        JobLauncher jobLauncher = (JobLauncher) context.getBean("jobLauncher");
        Job job = (Job) context.getBean("reportJob");

        try {
            JobParametersBuilder jobParametersBuilder = new JobParametersBuilder();//构建参数
            //jobParametersBuilder.addString("inputResource", "classpath:report.csv");
            jobParametersBuilder.addDate("date", new Date());//添加必须输入的参数（选择输入可以不添加）
            JobParameters jobParameters = jobParametersBuilder.toJobParameters();
            JobExecution execution = jobLauncher.run(job, jobParameters);
            System.out.println("Exit Status : " + execution.getStatus());
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Done");
    }
}