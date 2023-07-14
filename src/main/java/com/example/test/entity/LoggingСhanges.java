package com.example.test.entity;


import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Table(name = "LOGGING_СHANGES")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LoggingСhanges {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @Temporal(value = TemporalType.DATE)
    Date date;

    @Column(name = "COUNT", nullable = false)
    Long count;

    @Override
    public String toString() {
        return "ID: " + id.toString() + " " +
               "count: " + count.toString();
    }
}
