package za.ac.cput.Entity;

/**
 * author.java
 * This code represents an entity using the builder pattern
 * @author: Melven Johannes Booysen (219201277)
 * Date: 10 June 2021
 */

public class Author
{
    private String authorId, name, surname, bio;

    private Author(Builder builder)
    {
        this.authorId = builder.authorId;
        this.name = builder.name;
        this.surname = builder.surname;
        this.bio = builder.bio;
    }

    @Override
    public String toString()
    {
        return "Author{" +
                "authorId='" + authorId + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", bio='" + bio + '\'' +
                '}';
    }

    public static class Builder
    {
        private String  authorId, name, surname, bio;

        public Builder setAuthorId(String authorId)
        {
            this.authorId = authorId;
            return this;
        }

        public Builder setName(String name)
        {
            this.name = name;
            return this;
        }

        public Builder setSurname(String surname)
        {
            this.surname = surname;
            return this;
        }

        public Builder setBio(String bio)
        {
            this.bio = bio;
            return this;
        }

        public Author build()
        {
            return new Author(this);
        }

        public Builder copy(Author author)
        {
            this.authorId = author.authorId;
            this.name = author.name;
            this.surname = author.surname;
            this.bio = author.bio;

            return this;
        }
    }//*** End of inner class ***

}//*** End of outer class ***
