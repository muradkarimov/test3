package com.spring.springtask1.entities;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@Table(name="admins")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Admin {
    @Id
    @SequenceGenerator(name = "admin_id", sequenceName = "admin_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "admin_id")
    private Integer id;
    private String adminName;

    @OneToMany(mappedBy = "admin")
    @JsonManagedReference
    @JoinColumn(name="task_id")
    private List<Task> task;
}
