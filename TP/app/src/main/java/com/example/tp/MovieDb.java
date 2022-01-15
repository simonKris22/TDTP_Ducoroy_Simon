package com.example.tp;

import java.util.List;

public class MovieDb {
    private List<Movie> results;
    private int page;
    public  MovieDb(List<Movie> list,int page ){
        this.setResults(list);
        this.setPage(page);
    }


    public List<Movie> getResults() {
        return results;
    }

    public void setResults(List<Movie> results) {
        this.results = results;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }
}
