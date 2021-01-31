package com.example.demo;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class BookService {
    private List<Book> books = new ArrayList<>(Arrays.asList(new Book(1,"Harry Pottter", "JK ROWLING"),
            new Book(2,"ForgetfulDatabas","Rahul Kumar"),
            new Book(3,"Amazing Spiderman","Stan lee")));

    public List<Book> getAllBooks(){
        return books;
    }
    public Book getBook(int id){
        return books.stream().filter(t -> t.getId()==id).findFirst().get();
    }
    public void addBook(Book book)
    {
        books.add(book);
    }

    public void updateBooks(Book bookes, int id) {
        for(int i=0;i<books.size();i++)
        {
            Book b = books.get(i);
            if(b.getId()== id){
                books.set(i,bookes);
                return;
            }
        }
    }

    public void deleteBooks(int id) {
        books.removeIf(t -> t.getId() == id);
    }
}
