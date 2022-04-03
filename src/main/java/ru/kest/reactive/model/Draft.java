package ru.kest.reactive.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.Table;

import java.time.Instant;


@Data
@Table("drafts")
@NoArgsConstructor
@AllArgsConstructor
public class Draft {

    @Id
    private long orderId;

    @Column("type")
    private String type;

    @Column("updated")
    private Instant updated;
}
