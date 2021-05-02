package com.crew92.doordie.content.api.dto.todo;

import com.crew92.doordie.content.api.dto.ContentDto;
import com.crew92.doordie.content.domain.repository.entity.TodoEntity;
import lombok.Getter;
import lombok.Setter;
import org.springframework.util.ObjectUtils;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toList;
import static org.springframework.util.ObjectUtils.isEmpty;

@Getter
@Setter
public class TodoContentDto implements ContentDto {

    private String dueDateString;
    private List<TodoDto> todos;

    public static TodoContentDto of(String dueDateString, List<TodoEntity> entities) {
        TodoContentDto dto = new TodoContentDto();
        List<TodoDto> todos = entities.stream().map(TodoDto::transfer).collect(toList());
        dto.setTodos(todos);
        dto.setDueDateString(dueDateString);

        return dto;
    }
}
