package ru.kest.reactive.serivce;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.PostConstruct;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

@Service
public class RandomOrderIdService {

    private List<Long> orders;

    @PostConstruct
    private void init()  {
        InputStream is = getResourceFileAsInputStream("orders.txt");
        if (is != null) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            orders = reader.lines()
                    .filter(StringUtils::hasText)
                    .map(Long::valueOf)
                    .collect(Collectors.toList());
        } else {
            throw new RuntimeException("File with orders not found");
        }
    }

    public Long getRandomOrderId() {
        return orders.get(ThreadLocalRandom.current().nextInt(orders.size()));
    }

    public static InputStream getResourceFileAsInputStream(String fileName) {
        ClassLoader classLoader = RandomOrderIdService.class.getClassLoader();
        return classLoader.getResourceAsStream(fileName);
    }
}
