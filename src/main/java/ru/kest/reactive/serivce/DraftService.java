package ru.kest.reactive.serivce;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import reactor.core.publisher.Mono;
import ru.kest.reactive.repository.DraftRepository;

import java.time.OffsetDateTime;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@Slf4j
@Service
@RequiredArgsConstructor
public class DraftService {

    private final DraftRepository draftRepository;

    public Mono<String> updateDraft(Long orderId) {
//        log.debug("Find draft for id: {}", orderId);
        return draftRepository.findById(orderId)
                .switchIfEmpty(Mono.error(new ResponseStatusException(NOT_FOUND, "Draft not found")))
                .flatMap(draft -> {
                    draft.setUpdated(OffsetDateTime.now().toInstant());
                    return draftRepository.save(draft);
                })
                .flatMap(draft -> draftRepository.updateTimestamp(orderId)
                        .thenReturn(orderId.toString())
                );
    }

}
