package by.epamtc.VaskevichArtsiom.task04.java.entity;

import java.util.Objects;

public class Literature {
    private Integer literatureId;
    private String name;
    private String author;
    private String type;

    public Literature() {
    }

    public Literature(String name, String author, String type) {
        this.name = name;
        this.author = author;
        this.type = type;
    }

    public Integer getLiteratureId() {
        return literatureId;
    }

    public void setLiteratureId(Integer literatureId) {
        this.literatureId = literatureId;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Literature that = (Literature) o;
        return Objects.equals(literatureId, that.literatureId) && Objects.equals(name, that.name)
                && Objects.equals(author, that.author) && Objects.equals(type, that.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(literatureId, name, author, type);
    }

    @Override
    public String toString() {
        return "Literature{" +
                "literatureId=" + literatureId +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
