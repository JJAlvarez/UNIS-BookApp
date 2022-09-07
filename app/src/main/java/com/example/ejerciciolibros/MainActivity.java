package com.example.ejerciciolibros;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.example.ejerciciolibros.adapter.BooksAdapter;
import com.example.ejerciciolibros.api.ApiClient;
import com.example.ejerciciolibros.api.BooksApi;
import com.example.ejerciciolibros.model.Book;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private List<Book> mBooks;
    private BooksApi mApi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mApi = ApiClient.getInstance().create(BooksApi.class);

        RecyclerView rvBooks = (RecyclerView) findViewById(R.id.books_list);
        // Create adapter passing in the sample user data
        BooksAdapter adapter = new BooksAdapter(new ArrayList<>());
        // Attach the adapter to the recyclerview to populate items
        rvBooks.setAdapter(adapter);
        // Set layout manager to position the items
        rvBooks.setLayoutManager(new LinearLayoutManager(this));

        Call<List<Book>> bookCall = mApi.getBooks();
        bookCall.enqueue(new Callback<List<Book>>() {
            @Override
            public void onResponse(Call<List<Book>> call, Response<List<Book>> response) {
                adapter.reloadData(response.body());
            }

            @Override
            public void onFailure(Call<List<Book>> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Error al obtener los libros", Toast.LENGTH_SHORT).show();
            }
        });
    }
}