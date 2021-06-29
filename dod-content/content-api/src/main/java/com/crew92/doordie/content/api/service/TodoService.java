package com.crew92.doordie.content.api.service;

import static com.crew92.doordie.content.api.dto.todo.TodoContentDto.of;
import static com.crew92.doordie.content.api.dto.todo.TodoDto.transfer;
import static java.util.Objects.isNull;
import static java.util.stream.Collectors.groupingBy;
import static org.springframework.util.ObjectUtils.isEmpty;

import com.crew92.doordie.content.api.controller.TodoCreateCondition;
import com.crew92.doordie.content.api.controller.TodoUpdateCondition;
import com.crew92.doordie.content.api.converter.TodoConverter;
import com.crew92.doordie.content.api.dto.todo.TodoContentDto;
import com.crew92.doordie.content.api.dto.todo.TodoDto;
import com.crew92.doordie.content.api.dto.todo.TodosDto;
import com.crew92.doordie.content.api.exception.InvalidMemberIdException;
import com.crew92.doordie.content.api.exception.TodoNotFoundException;
import com.crew92.doordie.content.domain.provider.TodoProvider;
import com.crew92.doordie.content.domain.repository.entity.TodoEntity;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TodoService {

    private final TodoProvider todoProvider;
    private final Comparator<TodoContentDto> ORDER_BY_DUE_DATE_DESC = (do1, do2) -> do2.getDueDate().compareTo(do1.getDueDate());

    public TodoDto getById(Long todoId) {
        if (isNull(todoId) || todoId == 0) {
            throw new TodoNotFoundException();
        }

        return transfer(todoProvider.findById(todoId));
    }

    public TodosDto getByMemberId(Long memberId) {
        if (isNull(memberId) || memberId == 0) {
            throw new InvalidMemberIdException();
        }

        List<TodoEntity> entities = todoProvider.findByMemberId(memberId);
        if (isEmpty(entities)) {
            return new TodosDto();
        }

        Map<Date, List<TodoEntity>> dueDateMap = entities.stream().collect(groupingBy(TodoEntity::getDueDate));
        List<TodoContentDto> todos = new ArrayList<>();
        for (Date dueDate : dueDateMap.keySet()) {
            todos.add(of(dueDate, dueDateMap.get(dueDate)));
        }

        todos.sort(ORDER_BY_DUE_DATE_DESC);

        return TodosDto.of(todos);
    }

    public TodoDto create(Long memberId, TodoCreateCondition condition) {
        if (isNull(memberId) || memberId == 0) {
            throw new InvalidMemberIdException();
        }

        TodoEntity entity = TodoConverter.create(memberId, condition);

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

        TodoConverter.update(condition, entity);

        return transfer(todoProvider.update(entity));
    }


    public void removeById(Long id) {
        todoProvider.removeById(id);
    }
}
