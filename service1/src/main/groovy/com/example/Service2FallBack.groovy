package com.example

import com.example.domain.Book
import io.micronaut.retry.annotation.Fallback
import io.reactivex.Flowable

// https://mfarache.github.io/mfarache/Building-microservices-Micronoaut/
@Fallback
class Service2FallBack implements Service2Client{
    @Override
    Flowable<ArrayList<Book>> findBooks(){
        Book book = new Book()
        book.setTitle("Service 2 is down and will be up shortly")
        return Flowable.just([book])
    }
}