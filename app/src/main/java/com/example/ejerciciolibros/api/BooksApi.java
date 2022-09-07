package com.example.ejerciciolibros.api;

import com.example.ejerciciolibros.model.Book;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface BooksApi {

    @GET("/books.json")
    Call<List<Book>> getBooks();

}
