package com.crew92.doordie.content.api.service;

import static com.crew92.doordie.content.api.dto.TodoDto.transfer;
import static java.util.Objects.isNull;
import static java.util.stream.Collectors.toList;

import com.crew92.doordie.content.api.controller.TodoCreateCondition;
import com.crew92.doordie.content.api.controller.TodoUpdateCondition;
import com.crew92.doordie.content.api.dto.TodoDto;
import com.crew92.doordie.content.api.exception.InvalidMemberIdException;
import com.crew92.doordie.content.api.exception.TodoNotFoundException;
import com.crew92.doordie.content.domain.provider.TodoProvider;
import com.crew92.doordie.content.domain.repository.entity.TodoEntity;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TodoService {

    private final TodoProvider todoProvider;

    public TodoDto getById(Long todoId) {
        if (isNull(todoId) || todoId == 0) {
            throw new TodoNotFoundException();
        }

        return transfer(todoProvider.findById(todoId));
    }

    public TodoDto create(Long memberId, TodoCreateCondition condition) {
        if (isNull(memberId) || memberId == 0) {
            throw new InvalidMemberIdException();
        }

        TodoEntity entity = new TodoEntity();
        entity.setMemberId(memberId);
        entity.setTitle(condition.getTitle());
        entity.setStatus(condition.getStatus());
        entity.setDueDate(condition.getDueDate());

        return transfer(todoProvider.create(entity));
    }

    public TodoDto update(Long memberId, TodoUpdateCondition condition) {
        if (isNull(memberId) || memberId == 0) {
            throw new InvalidMemberIdException();
        }

        TodoEntity entity = todoProvider.findById(condition.getId());
        if (isNull(entity)) {
            throw new TodoNotFoundException();
        }

        entity.setTitle(condition.getTitle());
        entity.setStatus(condition.getStatus());
        entity.setDueDate(condition.getDueDate());

        return transfer(todoProvider.update(entity));
    }

    public List<TodoDto> getByMemberId(Long memberId) {
        if (isNull(memberId) || memberId == 0) {
            throw new InvalidMemberIdException();
        }

        return todoProvider.findByMemberId(memberId).stream()
            .map(TodoDto::transfer)
            .collect(toList()
            );
    }

    public void removeById(Long id) {
        todoProvider.removeById(id);
    }
}
