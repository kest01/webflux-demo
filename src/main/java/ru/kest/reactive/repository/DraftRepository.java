package ru.kest.reactive.repository;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Query;
import ru.kest.reactive.model.Draft;

public interface DraftRepository  extends CassandraRepository<Draft, Long> {

    @Query("UPDATE drafts SET updated = toTimestamp(now()) WHERE orderid = :orderId")
    void updateTimestamp(Long orderId);

}
