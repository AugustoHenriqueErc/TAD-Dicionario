package model;

import controller.DataValidator;

public class Book {

    private int id;
    private String releaseDate;
    private Integer pages;
    private String title;

    public Book (String title, String releaseDate, Integer pages) {
        this.title = title;
        try{
            if(DataValidator.validateData(releaseDate)) this.releaseDate = releaseDate;
            else throw new IllegalArgumentException("THE VALUE "+releaseDate+" IS NOT A VALID DATE");
        }catch (IllegalArgumentException e){
            System.err.println("CANNOT CREATE BOOK, INVALID RELEASE DATE");
            e.printStackTrace();
        }

        this.releaseDate = releaseDate;
        try {
            if(DataValidator.validadePages(pages)) throw new IllegalArgumentException("THE VALUE "+ pages +" IS NOT A VALID PARAMETER FOR PAGES");
            else this.pages = pages;
        }catch (IllegalArgumentException e){
            e.printStackTrace();
        }
    }
    public Book(){
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public void setPages(Integer pages) {
        this.pages = pages;
    }

    public String getTitle() {
        return title;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public Integer getPages() {
        return pages;
    }

    public int getId() {
        return id;
    }
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("ID: ").append(id).append(" TITLE: ").append(title).append(" RELEASE DATE: ").append(releaseDate).append(" PAGES: ").append(pages);
        return sb.toString();
    }
}
