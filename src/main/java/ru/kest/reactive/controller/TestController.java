package ru.kest.reactive.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;
import ru.kest.reactive.serivce.DraftService;
import ru.kest.reactive.serivce.RandomOrderIdService;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/test")
public class TestController {

    private final RandomOrderIdService randomOrderIdService;
    private final DraftService draftService;

    @GetMapping("/update")
    public Mono<String> executeRandomUpdate() {
        Long orderId = randomOrderIdService.getRandomOrderId();

        return draftService.updateDraft(orderId);
    }


}
