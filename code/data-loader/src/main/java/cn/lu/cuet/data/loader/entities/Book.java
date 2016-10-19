package cn.lu.cuet.data.loader.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldIndex;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mofang on 18/10/16.
 */
@Document(indexName = "library", type = "book")
public class Book {
    @Id
    @Field(type = FieldType.String, index = FieldIndex.not_analyzed, store = true)
    private Long id;

    @Field(type = FieldType.Object)
    private Author author;

    @Field(type = FieldType.String)
    private List<String> characters = new ArrayList<>();

    @Field(type = FieldType.Long)
    private Long copies;

    @Field(type = FieldType.String)
    private String oTitle;

    @Field(type = FieldType.String)
    private List<String> tags = new ArrayList<>();

    @Field(type = FieldType.String)
    private String title;

    @Field(type = FieldType.Long)
    private Long year;

    @Field(type = FieldType.Boolean)
    private boolean available;

    @Field(type = FieldType.Long)
    private Long section;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public List<String> getCharacters() {
        return characters;
    }

    public void addCharacter(String character) {
        characters.add(character);
    }

    public Long getCopies() {
        return copies;
    }

    public void setCopies(Long copies) {
        this.copies = copies;
    }

    public String getoTitle() {
        return oTitle;
    }

    public void setoTitle(String oTitle) {
        this.oTitle = oTitle;
    }

    public List<String> getTags() {
        return tags;
    }

    public void addTag(String tag) {
        tags.add(tag);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getYear() {
        return year;
    }

    public void setYear(Long year) {
        this.year = year;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public Long getSection() {
        return section;
    }

    public void setSection(Long section) {
        this.section = section;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id='" + id + '\'' +
                ", author='" + author + '\'' +
                ", characters='" + characters + '\'' +
                ", copies=" + copies +
                ", oTitle='" + oTitle + '\'' +
                ", tags='" + tags + '\'' +
                ", title='" + title + '\'' +
                ", year=" + year +
                ", available=" + available +
                '}';
    }
}
