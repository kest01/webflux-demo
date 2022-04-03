package ru.kest.reactive;

//@SpringBootTest
class WebfluxDemoApplicationTests {

/*
    @Test
    void simpleFluxExample() {
        Flux<String> fluxColors = Flux.just("red", "green", "blue");
//        fluxColors.subscribe(System.out::println);
        fluxColors.log().doOnComplete(() -> System.out.println("### onComplete"))
                .subscribe(System.out::println);
        fluxColors.log().subscribe((String s) -> System.out.println("New sub: " + s));
    }

    @Test
    void zipExample() {
        Flux<String> fluxFruits = Flux.just("apple", "pear", "plum");
        Flux<String> fluxColors = Flux.just("red", "green", "blue");
        Flux<Integer> fluxAmounts = Flux.just(10, 20, 30);
        Flux.zip(fluxFruits, fluxColors, fluxAmounts).subscribe(System.out::println);
    }

    @Test
    public void onErrorExample() {
        Flux<String> fluxCalc = Flux.just(-1, 3, 1)
                .map(i -> "10 / " + i + " = " + (10 / i))
                .onErrorReturn(ArithmeticException.class, "Division by 0 not allowed");

        fluxCalc.subscribe(value -> System.out.println("Next: " + value),
                error -> System.err.println("Error: " + error));
    }

    @Test
    public void coldPublisherExample() throws InterruptedException {
        Flux<Long> intervalFlux = Flux.interval(Duration.ofSeconds(1));
        Thread.sleep(2000);
        intervalFlux.subscribe(i -> System.out.println(String.format("Subscriber A, value: %d", i)));
        Thread.sleep(2000);
        intervalFlux.subscribe(i -> System.out.println(String.format("Subscriber B, value: %d", i)));
        Thread.sleep(3000);
    }
*/

}
