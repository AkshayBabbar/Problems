package src.Interview.hackerranktest.MorganStanley;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

class Library {
    private Integer numberOfBooks;
    private String name;
    private Map<String, Integer> bookGenres;

    public Map<String, Integer> getBookGenres() {
        return bookGenres;
    }

    public void setBookGenres(Map<String, Integer> bookGenres) {
        this.bookGenres = bookGenres;
    }

    public Integer getNumber_of_books() {
        return numberOfBooks;
    }

    public void setNumber_of_books(Integer numberOfBooks) {
        this.numberOfBooks = numberOfBooks;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}

