package be.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class Queue {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "serial")
    @NotNull(message = "Id can't be null")
    private long id;

    public Queue() {

    }
}
