package main.java.com.apps.diary.service;

import main.java.com.apps.diary.entity.TaskEntity;
import java.util.List;

public interface TaskService {
    List<TaskEntity> getAllTasks();
    List<TaskEntity> getTasksByUserId(long userId); // Retrieve tasks by userId
    TaskEntity saveTask(TaskEntity task);
    void deleteTask(Long id);
    TaskEntity getTaskById(Long id);
    void updateTask(TaskEntity task);
}
