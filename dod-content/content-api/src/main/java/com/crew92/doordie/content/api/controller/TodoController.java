package com.crew92.doordie.content.api.controller;

import com.crew92.doordie.content.api.dto.todo.TodoDto;
import com.crew92.doordie.content.api.dto.todo.TodosDto;
import com.crew92.doordie.content.api.service.TodoService;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class TodoController {

    private final TodoService todoService;

    @GetMapping("/api/v1/content/todo/{id}")
    public TodoDto getById(@PathVariable Long id) {
        return todoService.getById(id);
    }

    @GetMapping("/api/v1/content/todos")
    public TodosDto getByMemberId(@RequestHeader(HeaderNames.MEMBER_ID) Long memberId) {
        return todoService.getByMemberId(memberId);
    }

    @PostMapping("/api/v1/content/todo")
    public TodoDto create(@RequestHeader(HeaderNames.MEMBER_ID) Long memberId, @RequestBody @Valid TodoCreateCondition condition) {
        return todoService.create(memberId, condition);
    }

    @PutMapping("/api/v1/content/todo")
    public TodoDto update(@RequestHeader(HeaderNames.MEMBER_ID) Long memberId, @RequestBody @Valid TodoUpdateCondition condition) {
        return todoService.update(memberId, condition);
    }

    @DeleteMapping("/api/v1/content/todo/{id}")
    public void delete(@PathVariable Long id) {
        todoService.removeById(id);
    }

    private static class HeaderNames {
        public static final String MEMBER_ID = "x-dod-mid";
    }

}
