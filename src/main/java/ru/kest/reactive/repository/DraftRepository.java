package ru.kest.reactive.repository;

import org.springframework.data.cassandra.repository.Query;
import org.springframework.data.cassandra.repository.ReactiveCassandraRepository;
import reactor.core.publisher.Mono;
import ru.kest.reactive.model.Draft;

public interface DraftRepository extends ReactiveCassandraRepository<Draft, Long> {

    @Query("UPDATE drafts SET updated = toTimestamp(now()) WHERE orderid = :orderId")
    Mono<Void> updateTimestamp(Long orderId);

}
