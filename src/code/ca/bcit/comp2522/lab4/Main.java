package ca.bcit.comp2522.lab4;

import java.sql.SQLOutput;

public class Main
{
    public static void main(final String[] args)
    {

        // Books
        final Book book1;
        final Book book2;
        final Book book3;
        final Book book4;
        final Book book5;

        // Biography

        final Biography biography1;
        final Biography biography2;
        final Biography biography3;
        final Biography biography4;
        final Biography biography5;


        // Authors

        final Author author1;
        final Author author2;
        final Author author3;
        final Author author4;
        final Author author5;

        final Author author6;
        final Author author7;
        final Author author8;
        final Author author9;
        final Author author10;

        final Date birth1;
        final Date birth2;
        final Date birth3;
        final Date birth4;
        final Date birth5;

        final Date birth6;
        final Date birth7;
        final Date birth8;
        final Date birth9;
        final Date birth10;

        final Date birth11;
        final Date birth12;
        final Date birth13;
        final Date birth14;
        final Date birth15;

        final Date death1;
        final Date death2;
        final Date death3;
        final Date death4;
        final Date death5;

        final Date death6;
        final Date death7;
        final Date death8;
        final Date death9;
        final Date death10;

        final Date death11;
        final Date death12;
        final Date death13;
        final Date death14;
        final Date death15;

        final Name name1;
        final Name name2;
        final Name name3;
        final Name name4;
        final Name name5;

        final Name name6;
        final Name name7;
        final Name name8;
        final Name name9;
        final Name name10;

        System.out.println("Five of the Greatest Books: ");

        // Book 1
        birth1 = new Date(1903, 6, 25);
        death1 = new Date(1950, 1, 21);
        book1.display();

        // Book 2
        birth2 = new Date(1926, 4, 26);
        death2 = new Date(2016, 2, 19);

        name2 = new Name("Harper", "Lee");

        author2 = new Author(birth2, death2, name2, "Fiction");
        book2 = new Book("To Kill a Mockingbird", 1960, author2);

        book2.display();

        // Book 3
        birth3 = new Date(1775, 12, 16);
        death3 = new Date(1817, 7, 18);

        name3 = new Name("Jane", "Austen");

        author3 = new Author(birth3, death3, name3, "Dystopian");
        book3 = new Book("Pride and Prejudice", 1813, author3);

        book3.display();

        // Book 4
        birth4 = new Date(1896, 9, 24);
        death4 = new Date(1940, 12, 21);

        name4 = new Name("F. Scott", "Fitzgerald");

        author4 = new Author(birth4, death4, name4, "Dystopian");
        book4 = new Book("The Great Gatsby", 1925, author4);

        book4.display();

        // Book 5
        birth5 = new Date(1819, 8, 1);
        death5 = new Date(1891, 7, 28);

        name5 = new Name("Herman", "Melville");

        author5 = new Author(birth5, death5, name5, "Dystopian");
        book5 = new Book("Moby-Dick", 1851, author5);

        book5.display();

        System.out.println("Five of the Greatest Books: ");
    }
}
