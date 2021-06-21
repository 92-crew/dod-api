package com.crew92.doordie.content.api.dto.todo;

import com.crew92.doordie.content.domain.repository.entity.TodoEntity;
import java.util.Date;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TodoDto {

    private Long id;
    private Long memberId;
    private String title;
    private String status;
    private Date dueDate;

    public static TodoDto transfer(TodoEntity entity) {
        TodoDto dto = new TodoDto();
        dto.setId(entity.getId());
        dto.setMemberId(entity.getMemberId());
        dto.setTitle(entity.getTitle());
        dto.setStatus(entity.getStatus().name());
        dto.setDueDate(entity.getDueDate());

        return dto;
    }

}
