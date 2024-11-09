package main.java.com.apps.diary.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "tasks")
public class TaskEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;
    private LocalDate createdDate; // New date field
    
    @Column(name="user_id")
    private Long userId; // New date field


    public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	// Default constructor
    public TaskEntity() {}

    // Parameterized constructor
    public TaskEntity(String title, String description, LocalDate createdDate) {
        this.title = title;
        this.description = description;
        this.createdDate = createdDate;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDate createdDate) {
        this.createdDate = createdDate;
    }
}
