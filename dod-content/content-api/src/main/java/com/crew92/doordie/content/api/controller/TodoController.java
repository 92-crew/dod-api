package com.crew92.doordie.content.api.controller;

import com.crew92.doordie.content.api.dto.TodoDto;
import com.crew92.doordie.content.api.exception.InvalidMemberIdException;
import com.crew92.doordie.content.api.service.TodoService;
import java.util.List;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class TodoController {

    private final TodoService todoService;

    @GetMapping("/api/content/v1/todo/{id}")
    public TodoDto getById(@PathVariable Long id) {
        return todoService.getById(id);
    }

    @GetMapping("/api/content/v1/todos")
    public List<TodoDto> getByMemberId(@RequestHeader(HeaderNames.MEMBER_ID) Long memberId) {
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
