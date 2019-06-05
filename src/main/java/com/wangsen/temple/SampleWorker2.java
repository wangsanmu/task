package com.wangsen.temple;

import com.netflix.conductor.client.worker.Worker;
import com.netflix.conductor.common.metadata.tasks.Task;
import com.netflix.conductor.common.metadata.tasks.TaskResult;
import net.minidev.json.JSONObject;
import org.joda.time.DateTime;

import java.util.Map;

/**
 * @Auther: wangsen
 * @Date: 2019/5/8
 * @Des:
 **/
public class SampleWorker2 implements Worker {


    private Sting mdo

    private String taskDefName;

    public SampleWorker2(String taskDefName) {
        this.taskDefName = taskDefName;
    }

    public String getTaskDefName() {
        return taskDefName;
    }

    public TaskResult execute(Task task) {





        System.out.println("start ====================================================");
        System.out.println(new DateTime().toString("yyyy-MM-dd'T'HH:mm:ss:SSS"));
        System.out.printf("Executing %s\n", taskDefName);
        System.out.println("bi1:" + task.getInputData().get("bi1"));
        System.out.println("bi2:" + task.getInputData().get("bi2"));
        TaskResult result = new TaskResult(task);
        result.setStatus(TaskResult.Status.COMPLETED);


        Map<String, Object> inputData = task.getInputData();

        jso

        api = Api


        enty =


        map


        //Register the output of the task
        result.getOutputData().put("bo1", String.valueOf(task.getInputData().get("bi1")) + " from bi1");
        result.getOutputData().put("contetnt", String.valueOf(task.getInputData().get("bi2")) + " from bi2");



        System.out.println(new DateTime().toString("yyyy-MM-dd'T'HH:mm:ss:SSS"));
        System.out.println("end ====================================================");

        return result;
    }


    public int getPollingInterval() {
        return 50;
    }
}
