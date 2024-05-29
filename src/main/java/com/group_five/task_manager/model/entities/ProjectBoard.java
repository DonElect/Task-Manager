package com.group_five.task_manager.model.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "project_board")
public class ProjectBoard extends BaseEntity{
    @Column(nullable = false)
    private String boardName;
    @Column(nullable = false)
    private String owner;

    @OneToMany(mappedBy = "projectBoard", cascade = {CascadeType.DETACH,CascadeType.MERGE
            ,CascadeType.PERSIST,CascadeType.REFRESH},fetch = FetchType.LAZY)
    private List<TaskEntity> boardTasks = new ArrayList<>();
}
