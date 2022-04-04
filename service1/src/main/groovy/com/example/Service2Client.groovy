package com.example

import com.example.domain.Book
import io.micronaut.http.annotation.Get
import io.micronaut.http.client.annotation.Client
import io.reactivex.Flowable
import io.micronaut.retry.annotation.CircuitBreaker

// https://mfarache.github.io/mfarache/Building-microservices-Micronoaut/
@Client(id = "service2")
@CircuitBreaker(delay = "2s", attempts = "1", multiplier = "2", reset = "2s")
interface Service2Client {
    @Get("/books")
    Flowable<ArrayList<Book>> findBooks();
}