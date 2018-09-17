package com.udacityclass.android.popularmovies;

public class PopularMovieResponse {
    public int page;
    public int total_result;
    public int total_pages;
    public Movie[] results;

    public PopularMovieResponse(int page, int total_result, int total_pages, Movie[] results) {
        this.page = page;
        this.total_result = total_result;
        this.total_pages = total_pages;
        this.results = results;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getTotal_result() {
        return total_result;
    }

    public void setTotal_result(int total_result) {
        this.total_result = total_result;
    }

    public int getTotal_pages() {
        return total_pages;
    }

    public void setTotal_pages(int total_pages) {
        this.total_pages = total_pages;
    }

    public Movie[] getResults() {
        return results;
    }

    public void setResults(Movie[] results) {
        this.results = results;
    }


}
