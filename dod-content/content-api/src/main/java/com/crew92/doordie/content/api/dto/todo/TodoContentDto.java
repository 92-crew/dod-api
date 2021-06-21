package com.crew92.doordie.content.api.dto.todo;

import static java.util.stream.Collectors.toList;

import com.crew92.doordie.content.api.dto.ContentDto;
import com.crew92.doordie.content.domain.repository.entity.TodoEntity;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

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
