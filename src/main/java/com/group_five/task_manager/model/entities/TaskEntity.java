package com.group_five.task_manager.model.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.group_five.task_manager.model.enums.TaskStatus;
import jakarta.persistence.*;
import lombok.*;

import java.sql.Timestamp;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "task_table")
public class TaskEntity extends BaseEntity{
    private Integer periodInDays;

    @Column(nullable = false)
    @JsonFormat(pattern="yyyy-MM-dd")
    private Timestamp startDate;

    @Column(nullable = false, length = 25)
    @Enumerated(EnumType.STRING)
    private TaskStatus status;

    @Column(nullable = false)
    private String taskTitle;

    @Column(length = 1000)
    private String taskDetails;

    @Column(nullable = false)
    private Long createdById;

    private Long assignById;

    @ManyToOne(cascade = {CascadeType.DETACH,CascadeType.MERGE
            ,CascadeType.PERSIST,CascadeType.REFRESH}, fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private UserEntity user;

    @ManyToOne(cascade = {CascadeType.DETACH,CascadeType.MERGE
            ,CascadeType.PERSIST,CascadeType.REFRESH}, fetch = FetchType.LAZY)
    @JoinColumn(name = "project_board_id")
    private ProjectBoard projectBoard;
}
