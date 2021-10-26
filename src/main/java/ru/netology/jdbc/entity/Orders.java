package ru.netology.jdbc.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    @OneToOne(optional = false)
    private Customers customers;

    @Column(nullable = false)
    private String productName;

    private int amount;
}
