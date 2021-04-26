package com.crew92.doordie.content.domain.repository.entity;

import com.crew92.doordie.content.domain.repository.CommonEntity;
import com.crew92.doordie.content.meta.todo.TodoStatus;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "dod_todos")
public class TodoEntity extends CommonEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long memberId;
    private String title;

    @Enumerated(EnumType.STRING)
    private TodoStatus status;

    @Temporal(TemporalType.DATE)
    private Date dueDate;

}
