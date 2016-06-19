package com.coshaho.learn.service.test;
 
import java.util.List;
 
import org.activiti.engine.HistoryService;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.history.HistoricProcessInstance;
import org.activiti.engine.task.Task;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
 
public class ActivitiTest
{
    public static void main(String[] args)
    {   
        @SuppressWarnings("resource")
        ApplicationContext ac = new ClassPathXmlApplicationContext(new String[]{"spring.xml"});
        ProcessEngine processEngine = (ProcessEngine)ac.getBean("processEngine");
         
        // 发布流程
        RepositoryService repositoryService = processEngine.getRepositoryService();
        repositoryService.createDeployment().addClasspathResource("Interview.bpmn").deploy(); 
         
        // 启动流程实例
        RuntimeService runtimeService = processEngine.getRuntimeService(); 
        String processId = runtimeService.startProcessInstanceByKey("Interview").getId();
        System.out.println("此次启动的流程实例为：" + processId);
         
        // 获取人力资源任务
        TaskService taskService = processEngine.getTaskService();  
        List<Task> tasks = taskService.createTaskQuery().taskCandidateGroup("人力资源部").list(); 
        System.out.println("******人力资源部任务列表******");    
        for (Task task : tasks)
        {       
            if("笔试".equals(task.getName()))
            {
                System.out.println("张三领取笔试任务：" + task.getId());
                taskService.claim(task.getId(), "张三");  
            }
            else if("HR面".equals(task.getName()))
            {
                System.out.println("李四领取HR面任务：" + task.getId());
                taskService.claim(task.getId(), "李四");
            }
            else
            {
                System.out.println("王五领取发放Offer任务：" + task.getId());
                taskService.claim(task.getId(), "王五");
            }
        } 
         
        System.out.println("张三的笔试任务数量："+taskService.createTaskQuery().taskAssignee("张三").count()); 
        tasks = taskService.createTaskQuery().taskAssignee("张三").list(); 
        for (Task task : tasks)
        {      
            System.out.println("张三处理笔试任务, id:"+task.getId());     
            taskService.complete(task.getId());  
        }  
         
        System.out.println("李四的HR面任务数量："+taskService.createTaskQuery().taskAssignee("李四").count()); 
        tasks = taskService.createTaskQuery().taskAssignee("李四").list(); 
        for (Task task : tasks)
        {      
            System.out.println("李四处理HR面任务, id:"+task.getId());     
            taskService.complete(task.getId());  
        } 
         
        System.out.println("王五的发放Offer任务数量："+taskService.createTaskQuery().taskAssignee("王五").count()); 
        tasks = taskService.createTaskQuery().taskAssignee("王五").list(); 
        for (Task task : tasks)
        {      
            System.out.println("王五处理发放Offer任务, id:"+task.getId());     
            taskService.complete(task.getId());  
        } 
         
        tasks = taskService.createTaskQuery().taskCandidateGroup("技术部").list();
        System.out.println("******技术部任务列表******");    
        for (Task task : tasks)
        {      
            if("技术一面".equals(task.getName()))
            {
                System.out.println("马六领取技术一面任务：" + task.getId());
                taskService.claim(task.getId(), "马六");  
            } 
            else
            {
                System.out.println("胜七领取技术二面任务：" + task.getId());
                taskService.claim(task.getId(), "胜七");
            }
        }   
        System.out.println("马六的技术一面任务数量："+taskService.createTaskQuery().taskAssignee("马六").count()); 
        tasks = taskService.createTaskQuery().taskAssignee("马六").list(); 
        for (Task task : tasks)
        {      
            System.out.println("马六处理技术一面任务, id:"+task.getId());     
            taskService.complete(task.getId());  
        } 
        System.out.println("胜七的技术二面任务数量："+taskService.createTaskQuery().taskAssignee("胜七").count()); 
        tasks = taskService.createTaskQuery().taskAssignee("胜七").list(); 
        for (Task task : tasks)
        {      
            System.out.println("胜七处理技术二面任务, id:"+task.getId());     
            taskService.complete(task.getId());  
        } 
         
        HistoryService historyService = processEngine.getHistoryService(); 
        List<HistoricProcessInstance> historicProcessInstanceList = historyService
                .createHistoricProcessInstanceQuery().list();
             
        if(null != historicProcessInstanceList && 0 != historicProcessInstanceList.size())
        {
            for(HistoricProcessInstance hisInstance : historicProcessInstanceList)
            {
                System.out.println("历史流程, id = "+hisInstance.getId()
                        + ", end time = " + hisInstance.getEndTime());
            }
        }
    }
}