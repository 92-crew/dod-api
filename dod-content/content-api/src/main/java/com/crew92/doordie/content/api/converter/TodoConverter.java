package com.crew92.doordie.content.api.converter;

import com.crew92.doordie.content.api.controller.TodoCreateCondition;
import com.crew92.doordie.content.api.controller.TodoUpdateCondition;
import com.crew92.doordie.content.domain.repository.entity.TodoEntity;
import org.springframework.stereotype.Component;

public class TodoConverter {

    public static TodoEntity create(Long memberId, TodoCreateCondition condition) {
        TodoEntity entity = new TodoEntity();
        entity.setMemberId(memberId);
        entity.setTitle(condition.getTitle());
        entity.setStatus(condition.getStatus());
        entity.setDueDate(condition.getDueDate());

        return entity;
    }

    public static void update(TodoUpdateCondition condition, TodoEntity entity) {
        entity.setTitle(condition.getTitle());
        entity.setStatus(condition.getStatus());
        entity.setDueDate(condition.getDueDate());
    }

}
