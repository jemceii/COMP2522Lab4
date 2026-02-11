package ca.bcit.comp2522.lab4;

public class Main
{
    public static void main(final String[] args)
    {
        final Book book1;
        final Book book2;
        final Book book3;
        final Book book4;
        final Book book5;

        final Author author1;
        final Author author2;
        final Author author3;
        final Author author4;
        final Author author5;

        final Date birth1;
        final Date birth2;
        final Date birth3;
        final Date birth4;
        final Date birth5;

        final Date death1;
        final Date death2;
        final Date death3;
        final Date death4;
        final Date death5;

        final Name name1;
        final Name name2;
        final Name name3;
        final Name name4;
        final Name name5;

        // Book 1
        birth1 = new Date(1903, 6, 25);
        death1 = new Date(1950, 1, 21);

        name1 = new Name("George", "Orwell");

        author1 = new Author(birth1, death1, name1, "Dystopian");
        book1 = new Book("1984", 1949, author1);

        System.out.println(book1);
    }
}
