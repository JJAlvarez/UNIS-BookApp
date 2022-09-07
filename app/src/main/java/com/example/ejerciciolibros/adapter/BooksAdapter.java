package com.example.ejerciciolibros.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.ejerciciolibros.R;
import com.example.ejerciciolibros.model.Book;

import java.util.List;

public class BooksAdapter extends RecyclerView.Adapter<BooksAdapter.ViewHolder> {

    private List<Book> mBooks;
    private Context context;

    public BooksAdapter(List<Book> mBooks) {
        this.mBooks = mBooks;
    }

    public void reloadData(List<Book> books) {
        this.mBooks = books;
    }

    @NonNull
    @Override
    public BooksAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        this.context = parent.getContext();

        LayoutInflater inflater = LayoutInflater.from(this.context);

        // Inflate the custom layout
        View contactView = inflater.inflate(R.layout.item_book, parent, false);

        // Return a new holder instance
        ViewHolder viewHolder = new ViewHolder(contactView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull BooksAdapter.ViewHolder holder, int position) {
        // Get the data model based on position
        Book book = mBooks.get(position);

        // Set item views based on your views and data model
        TextView bookNameTextView = holder.mBookName;
        bookNameTextView.setText(book.mTitle);
        TextView bookAuthorTextView = holder.mBookAuthor;
        bookAuthorTextView.setText(book.mAuthor);
        ImageView bookImage = holder.mBookImage;

        Glide.with(this.context).load(book.mImageUrl).into(bookImage);
    }

    @Override
    public int getItemCount() {
        return mBooks.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView mBookImage;
        private TextView mBookName;
        private TextView mBookAuthor;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            mBookImage = (ImageView) itemView.findViewById(R.id.book_image);
            mBookName = (TextView) itemView.findViewById(R.id.book_name);
            mBookAuthor = (TextView) itemView.findViewById(R.id.book_author);
        }
    }
}
