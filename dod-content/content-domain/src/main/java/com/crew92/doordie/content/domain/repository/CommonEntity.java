package com.crew92.doordie.content.domain.repository;

import java.util.Date;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

public class CommonEntity {

    @CreatedDate
    private Date createdAt;

    @CreatedBy
    private String createdBy;

    @LastModifiedDate
    private Date updatedAt;

    @LastModifiedBy
    private String updatedBy;

}
