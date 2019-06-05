package com.wangsen.temple;

import com.netflix.conductor.client.worker.Worker;
import com.netflix.conductor.common.metadata.tasks.Task;
import com.netflix.conductor.common.metadata.tasks.TaskResult;
import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * @Auther: wangsen
 * @Date: 2019/5/8
 * @Des:
 **/
public class SampleWorker implements Worker {

    private Logger logger = LoggerFactory.getLogger(getClass());


    private String taskDefName;


    public SampleWorker(String taskDefName) {
        this.taskDefName = taskDefName;
    }
    public String getTaskDefName() {
        return taskDefName;
    }


    public TaskResult execute(Task task) {
        logger.info("start task currentTime == {{}}",new DateTime().toString("yyyy-MM-dd'T'HH:mm:ss:SSS"));

        

        TaskResult result = new TaskResult(task);
        logger.info("currentTask  taskName = {{}}", task.getTaskDefName() );
        result.setStatus(TaskResult.Status.COMPLETED);
        logger.info("end task currentTime == {{}}",new DateTime().toString("yyyy-MM-dd'T'HH:mm:ss:SSS"));
        return result;
    }


    public int getPollingInterval() {
        return 10;
    }


    @Override
    public int getPollCount() {
        return 1;
    }
}
