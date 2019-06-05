package com.wangsen.temple;

import com.netflix.conductor.client.http.TaskClient;
import com.netflix.conductor.client.task.WorkflowTaskCoordinator;
import com.netflix.conductor.client.worker.Worker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Auther: wangsen
 * @Date: 2019/5/13
 * @Des:
 **/
public class kitchensink {


    private Logger logger = LoggerFactory.getLogger(getClass());

    public static void main(String[] args) {

        TaskClient taskClient = new TaskClient();
        taskClient.setRootURI("http://nlp-1:8080/api/");       //Point this to the server API
        int threadCount = 100;         //number of threads used to execute workers.  To avoid starvation, should be same or more than number of workers

        Worker worker1 = new SampleWorker("mytask1");
        Worker worker2 = new SampleWorker2("mytask2");


        System.out.println(worker1.getPollingInterval());
        System.out.println(worker1.getPollCount());
        System.out.println(worker1.getLongPollTimeoutInMS());

        //Create WorkflowTaskCoordinator
        WorkflowTaskCoordinator.Builder builder = new WorkflowTaskCoordinator.Builder();
        WorkflowTaskCoordinator coordinator = builder.withWorkers(worker1, worker2).withThreadCount(threadCount).withTaskClient(taskClient).build();
        coordinator.init();


    }
}
