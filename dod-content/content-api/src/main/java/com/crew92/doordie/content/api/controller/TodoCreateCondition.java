package com.crew92.doordie.content.api.controller;

import com.crew92.doordie.content.meta.todo.TodoStatus;
import java.util.Date;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TodoCreateCondition {

    @NotNull
    private String title;

    @NotNull
    private TodoStatus status;

    @NotNull
    private Date dueDate;

}
