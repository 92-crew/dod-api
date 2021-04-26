package com.crew92.doordie.content.domain.repository;

import com.crew92.doordie.content.domain.repository.entity.TodoEntity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<TodoEntity, Long> {

    List<TodoEntity> findAllByMemberId(long memberId);

}
