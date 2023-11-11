package com.hoangtien2k3.reactor;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

public class reactorDemo {
    public Mono<List<String>> fruitMonoFlatMap() {
        return Mono.just("Mango")
                .flatMap(s -> Mono.just(List.of(s.split(""))))
                .log();
    }

    public Flux<String> fruitMonoFlatMapMany() {
        return Mono.just("Mango")
                .flatMapMany(s -> Flux.just(s.split("")))
                .log();
    }

    public static void main(String[] args) {

        reactorDemo reactorDemo
                = new reactorDemo();

        reactorDemo.fruitMonoFlatMap()
                .subscribe(s -> {
                    System.out.println("s = " + s);
                });

        reactorDemo.fruitMonoFlatMapMany()
                .subscribe(s -> {
                    System.out.println("Mono -> s = " + s);
                });
    }
}
