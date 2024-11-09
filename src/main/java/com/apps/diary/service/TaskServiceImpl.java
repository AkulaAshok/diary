package main.java.com.apps.diary.service;

import main.java.com.apps.diary.entity.TaskEntity;
import main.java.com.apps.diary.repository.TaskRepository;
import main.java.com.apps.diary.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskRepository taskRepository;

    @Override
    public List<TaskEntity> getAllTasks() {
        return taskRepository.findAll();
    }

    @Override
    public List<TaskEntity> getTasksByUserId(long userId) {
        return taskRepository.findByUserId(userId);
    }

    @Override
    public TaskEntity saveTask(TaskEntity task) {
        return taskRepository.save(task);
    }

    @Override
    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }

    @Override
    public TaskEntity getTaskById(Long id) {
        return taskRepository.findById(id).orElse(null);
    }

    @Override
    public void updateTask(TaskEntity task) {
        taskRepository.save(task);
    }
}
