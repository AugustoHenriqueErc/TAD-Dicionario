package model;

import controller.DataValidator;

public class Book {

    private int id;
    private String releaseDate;
    private Integer pages;
    private String title;
    private static int ID_COUNTER = 1;

    public Book (String title, String releaseDate, Integer pages) {
        this.title = title;
        setId();
        try{
            if(DataValidator.validateDate(releaseDate)) this.releaseDate = releaseDate;
            else throw new IllegalArgumentException("THE VALUE "+releaseDate+" IS NOT A VALID DATE");
        }catch (IllegalArgumentException e){
            System.err.println("CANNOT CREATE BOOK, INVALID RELEASE DATE");
            e.printStackTrace();
        }
        try {
            if(DataValidator.validadePages(pages)) this.pages = pages;
            else throw new IllegalArgumentException("THE VALUE "+ pages +" IS NOT A VALID PARAMETER FOR PAGES");
        }catch (IllegalArgumentException e){
            e.printStackTrace();
        }
    }
    public Book(){
    }
    private void setId() {
        this.id = ID_COUNTER;
        ID_COUNTER++;
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
