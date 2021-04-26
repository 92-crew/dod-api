package com.crew92.doordie.content.api.dto;

import com.crew92.doordie.content.domain.repository.entity.TodoEntity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TodoDto {

    private Long id;
    private Long memberId;
    private String title;
    private String status;
    private String dueDate;

    public static TodoDto transfer(TodoEntity entity) {
        TodoDto dto = new TodoDto();
        dto.setId(entity.getId());
        dto.setMemberId(entity.getMemberId());
        dto.setTitle(entity.getTitle());
        dto.setStatus(entity.getStatus().name());
        dto.setDueDate(entity.getDueDate().toString());

        return dto;
    }
}
