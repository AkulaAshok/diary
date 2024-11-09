package main.java.com.apps.diary.repository;

import main.java.com.apps.diary.entity.TaskEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface TaskRepository extends JpaRepository<TaskEntity, Long> {
    List<TaskEntity> findByUserId(Long userId);
}
