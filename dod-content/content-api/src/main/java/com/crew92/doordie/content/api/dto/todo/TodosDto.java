package com.crew92.doordie.content.api.dto.todo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class TodosDto {

    @JsonProperty("contents")
    private List<TodoContentDto> todos = new ArrayList<>();

    public static TodosDto of(List<TodoContentDto> todos) {
        TodosDto dto = new TodosDto();
        dto.setTodos(todos);

        return dto;
    }
}
