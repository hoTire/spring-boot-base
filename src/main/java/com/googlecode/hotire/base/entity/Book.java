package com.googlecode.hotire.base.entity;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;

@Builder
@Data
@Entity
@ToString
public class Book {

    @Id
    @GeneratedValue
    private Long id;
    private String name;

    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    private Date created;

}
