package com.spring.springtask1.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.spring.springtask1.enums.PointEnum;
import com.spring.springtask1.enums.TaskPriorityEnum;
import com.spring.springtask1.enums.TaskStatusEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;


@Data
@Table(name="tasks")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Task {
    @Id
    @SequenceGenerator(name = "task_id", sequenceName = "task_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "task_id")
    private Integer id;
    private String descriptiom;
    private LocalDateTime deadline;
    private PointEnum point;
    private TaskPriorityEnum taskPriority;
    private TaskStatusEnum taskStatus;

    @ManyToMany(mappedBy = "userTasks")
    @JsonBackReference
    private List<User> taskUsers;


    @ManyToOne()
    @JsonBackReference
    @JoinColumn(name="admin_id")
    private Admin admin;
}
