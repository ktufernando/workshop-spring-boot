package ar.com.bbva.taller.app.model;

import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;

/**
 * Created by fer on 10/10/19.
 */
@Document
public class Book {

    @Id
    private String id;
    private String name;
    private String author;
    private int assessment;

    public Book() {
    }

    public Book(String name, String author, int assessment) {
        this.name = name;
        this.author = author;
        this.assessment = assessment;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getAssessment() {
        return assessment;
    }

    public void setAssessment(int assessment) {
        this.assessment = assessment;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Book{");
        sb.append("id='").append(id).append('\'');
        sb.append(", name='").append(name).append('\'');
        sb.append(", author='").append(author).append('\'');
        sb.append(", assessment=").append(assessment);
        sb.append('}');
        return sb.toString();
    }
}
