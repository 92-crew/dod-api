package com.crew92.doordie.content.api.controller;

import com.crew92.doordie.content.meta.todo.TodoStatus;
import java.util.Date;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TodoUpdateCondition {

    @NotNull
    private Long id;

    private String title;
    private TodoStatus status;
    private Date dueDate;

}
