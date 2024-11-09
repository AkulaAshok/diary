package main.java.com.apps.diary.controller;

import main.java.com.apps.diary.entity.TaskEntity;
import main.java.com.apps.diary.entity.UserEntity;
import main.java.com.apps.diary.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import jakarta.servlet.http.HttpSession;

import java.util.List;

@Controller
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @Autowired
    private HttpSession session;

    @GetMapping
    public String getAllTasks(Model model) 
    {
    	UserEntity user = (UserEntity) session.getAttribute("user");
   	 
   	 System.out.println(user);
        
        int userId=user.getId();
        
        List<TaskEntity> tasks = null;

        if (userId>0) 
        {
            tasks = taskService.getTasksByUserId((long)userId);
            model.addAttribute("tasks", tasks);
            
        } else {
            model.addAttribute("tasks", List.of());
        }

        model.addAttribute("userId", userId);
        model.addAttribute("pageTitle", "Your Dashboard");

        return "dashboard";
    }

    @GetMapping("/add")
    public String showAddTaskForm(Model model) {
        model.addAttribute("task", new TaskEntity());
        return "add-task";
    }

    @PostMapping("/save")
    public String saveTask(@ModelAttribute("task") TaskEntity task, Model model) 
    {
    	 UserEntity user = (UserEntity) session.getAttribute("user");
    	 
    	 System.out.println(user);
         
         int userId=user.getId();
        
        if (userId>0) {
            task.setUserId((long) userId);
            taskService.saveTask(task);
        }
        
        return getAllTasks(model);
    }

    @GetMapping("/edit/{id}")
    public String showEditTaskForm(@PathVariable("id") Long id, Model model) {
        TaskEntity task = taskService.getTaskById(id);
        model.addAttribute("task", task);
        return "edit-task";
    }

    @PostMapping("/update")
    public String updateTask(@ModelAttribute("task") TaskEntity task, Model model) {
 UserEntity user = (UserEntity) session.getAttribute("user");
         
         int userId=user.getId();
                if (userId>0) {
            task.setUserId((long)userId);
            taskService.updateTask(task);
        }

        return getAllTasks(model);
    }

    @PostMapping("/delete/{id}")
    public String deleteTask(@PathVariable("id") Long id, Model model) {
        taskService.deleteTask(id);
        
        return getAllTasks(model);
    }
}