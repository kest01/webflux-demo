package ru.kest.reactive.serivce;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import ru.kest.reactive.model.Draft;
import ru.kest.reactive.repository.DraftRepository;

import java.time.OffsetDateTime;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@Slf4j
@Service
@RequiredArgsConstructor
public class DraftService {

    private final DraftRepository draftRepository;

    public void updateDraft(Long orderId) {
//        log.debug("Find draft for id: {}", orderId);
        Draft draft = draftRepository.findById(orderId).orElseThrow(() -> new ResponseStatusException(NOT_FOUND, "Draft not found"));
        draft.setUpdated(OffsetDateTime.now().toInstant());
        draftRepository.save(draft);
//        log.debug("saved draft: {}", draft);
//        sleep(1000);
        draftRepository.updateTimestamp(orderId);
    }

    private void sleep(long mills) {
        try {
            Thread.sleep(mills);
        } catch (InterruptedException e) {
            throw new RuntimeException("Interrupted", e);
        }
    }
}
