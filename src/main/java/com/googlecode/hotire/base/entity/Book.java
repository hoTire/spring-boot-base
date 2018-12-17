package com.googlecode.hotire.base.entity;

import lombok.Data;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

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
