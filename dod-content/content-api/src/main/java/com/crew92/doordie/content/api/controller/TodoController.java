package com.crew92.doordie.content.api.controller;

import com.crew92.doordie.content.api.dto.todo.TodoDto;
import com.crew92.doordie.content.api.dto.todo.TodosDto;
import com.crew92.doordie.content.api.exception.InvalidMemberIdException;
import com.crew92.doordie.content.api.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
public class TodoController {

    private final TodoService todoService;

    @GetMapping("/api/content/v1/todo/{id}")
    public TodoDto getById(@PathVariable Long id) {
        return todoService.getById(id);
    }

    @GetMapping("/api/content/v1/todos")
    public TodosDto getByMemberId(@RequestHeader(HeaderNames.MEMBER_ID) Long memberId) {
        return todoService.getByMemberId(memberId);
    }

    @PostMapping("/api/content/v1/todo")
    public TodoDto create(@RequestHeader(HeaderNames.MEMBER_ID) Long memberId, @RequestBody @Valid TodoCreateCondition condition) {
        return todoService.create(memberId, condition);
    }

    @PutMapping("/api/content/v1/todo")
    public TodoDto update(@RequestHeader(HeaderNames.MEMBER_ID) Long memberId, @RequestBody @Valid TodoUpdateCondition condition) {
        return todoService.update(memberId, condition);
    }

    @DeleteMapping("/api/content/v1/todo/{id}")
    public void delete(@PathVariable Long id) {
        todoService.removeById(id);
    }

    private static class HeaderNames {

        public static final String MEMBER_ID = "x-dod-mid";
    }

    @ExceptionHandler(InvalidMemberIdException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public String invalidMemberIdException(InvalidMemberIdException e) {
        throw e;
    }

}
