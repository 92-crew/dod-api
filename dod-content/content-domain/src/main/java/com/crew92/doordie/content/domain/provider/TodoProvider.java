package com.crew92.doordie.content.domain.provider;

import com.crew92.doordie.content.domain.repository.TodoRepository;
import com.crew92.doordie.content.domain.repository.entity.TodoEntity;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TodoProvider {

    private final TodoRepository todoRepository;

    public TodoEntity findById(long todoId) {
        return todoRepository.findById(todoId).orElse(null);
    }

    public List<TodoEntity> findByMemberId(long memberId) {
        return todoRepository.findAllByMemberId(memberId);
    }

    public TodoEntity create(TodoEntity entity) {
        return todoRepository.save(entity);
    }

    public TodoEntity update(TodoEntity entity) {
        return todoRepository.save(entity);
    }

    public void removeById(long todoId) {
        todoRepository.deleteById(todoId);
    }
}
