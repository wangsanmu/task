package com.wangsen.temple;

import com.netflix.conductor.client.http.TaskClient;
import com.netflix.conductor.client.task.WorkflowTaskCoordinator;
import com.netflix.conductor.client.worker.Worker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Auther: wangsen
 * @Date: 2019/5/8
 * @Des:
 **/
public class temple {

    private static Logger logger = LoggerFactory.getLogger(temple.class);

    public static void main(String[] args) {
        TaskClient taskClient = new TaskClient();
//        taskClient.setRootURI("http://vdbus-16:8081/api/");       //Point this to the server API
        taskClient.setRootURI("http://nlp-1:8080/api/");       //Point this to the server API

        int threadCount = 550;         //number of threads used to execute workers.  To avoid starvation, should be same or more than number of workers

        Worker worker1 = new SampleWorker("task_5");
        Worker worker2 = new SampleWorker("task_10");
        Worker worker3 = new SampleWorker("task_11");
        Worker worker4 = new SampleWorker("task_20");
        Worker worker5 = new SampleWorker("task_21");
        Worker worker6 = new SampleWorker("task_28");
        Worker worker7 = new SampleWorker("task_30");

        logger.info("pollCount === {}", worker1.getPollCount());

        //Create WorkflowTaskCoordinator
        WorkflowTaskCoordinator.Builder builder = new WorkflowTaskCoordinator.Builder();
        WorkflowTaskCoordinator coordinator =
                builder.withWorkers(
                        worker1, worker2, worker3, worker4, worker5 ,worker6,worker7).withThreadCount(threadCount).withTaskClient(taskClient).withWorkerQueueSize(500).build();

        //Start for polling and execution of the tasks
        coordinator.init();
//        coordinator.shutdown();
    }
}
