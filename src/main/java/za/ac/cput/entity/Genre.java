package za.ac.cput.entity;
import javax.persistence.Entity;
import javax.persistence.Id;
/**
 * Genre.java
 * This code represents an entity using the builder pattern
 * @author Plamedie Bitota Bukasa (219260532)
 * Date: 10th June 2021
 */
@Entity
public class Genre

{
    @Id
    private String genreId; //Added correction

    private String name;

    private Genre(Builder builder)
    {
        this.genreId= builder.genreId;
        this.name= builder.name;
    }

    public Genre() {

    }

    @Override
    public String toString() {
        return "Builder{" +
                "genreId='" + genreId + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    public String getGenreId()
    {
        return genreId;
    }

    public String getName() {
        return name;
    }

    public static class Builder
    {
        private String genreId,name;

        public Builder setGenreId(String genreId)
        {
            this.genreId = genreId;
            return this;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Genre build()
        {
            return new Genre(this);
        }
        public Builder copy (Genre genre)
        {
            this.genreId=genre.genreId;
            this.name=genre.name;
            return this;
        }

    }

}
