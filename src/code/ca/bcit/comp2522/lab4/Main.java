package ca.bcit.comp2522.lab4;


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

        final Name name11;
        final Name name12;
        final Name name13;
        final Name name14;
        final Name name15;

        // Subjects

        final Person subject1;
        final Person subject2;
        final Person subject3;
        final Person subject4;
        final Person subject5;

        final Person subject6;
        final Person subject7;
        final Person subject8;
        final Person subject9;
        final Person subject10;


        System.out.println("Five of the Greatest Books: ");

        // Book 1
        birth1 = new Date(1903, 6, 25);
        death1 = new Date(1950, 1, 21);

        name1 = new Name("George", "Orwell");

        author1 = new Author(birth1, death1, name1, "Dystopian");
        book1 = new Book("1984", 1949, author1);

        book1.display();

        // Book 2
        birth2 = new Date(1926, 4, 26);
        death2 = new Date(2016, 2, 19);

        name2 = new Name("Harper", "Lee");

        author2 = new Author(birth2, death2, name2, "Southern Gothic");
        book2 = new Book("To Kill a Mockingbird", 1960, author2);

        book2.display();

        // Book 3
        birth3 = new Date(1775, 12, 16);
        death3 = new Date(1817, 7, 18);

        name3 = new Name("Jane", "Austen");

        author3 = new Author(birth3, death3, name3, "Romance");
        book3 = new Book("Pride and Prejudice", 1813, author3);

        book3.display();

        // Book 4
        birth4 = new Date(1896, 9, 24);
        death4 = new Date(1940, 12, 21);

        name4 = new Name("F. Scott", "Fitzgerald");

        author4 = new Author(birth4, death4, name4, "Modernist");
        book4 = new Book("The Great Gatsby", 1925, author4);

        book4.display();

        // Book 5
        birth5 = new Date(1819, 8, 1);
        death5 = new Date(1891, 7, 28);

        name5 = new Name("Herman", "Melville");

        author5 = new Author(birth5, death5, name5, "Adventure");
        book5 = new Book("Moby-Dick", 1851, author5);

        book5.display();

        //---------------------

        System.out.println("Five of the Greatest Biographies \n");

        // Biography 1
        birth6 = new Date(1903, 6, 25);
        name6 = new Name("Robert", "Caro");

        author6 = new Author(birth6, null, name6, "Placeholder");


        birth11 = new Date(1888, 12, 18);
        death11 = new Date(1981, 7, 29);
        name11 = new Name("Robert", "Moses");

        subject1 = new Person(birth11, death11, name11);

        biography1 = new Biography("The Power Broker",1974, author6, subject1);

        biography1.display();

        // Biography 2
        birth7 = new Date(1952, 5, 20);
        name7 = new Name("Walter", "Isaacson");

        author7 = new Author(birth7, null, name7, "Placeholder");


        birth12 = new Date(1955, 2, 24);
        death12 = new Date(2011, 5, 10);
        name12 = new Name("Steve", "Jobs");

        subject2 = new Person(birth12, death12, name12);

        biography2 = new Biography("Steve Jobs",2011, author7, subject2);

        biography2.display();

        // Biography 3
        birth8 = new Date(1936, 10, 14);
        death8 = new Date(2015, 2, 3);
        name8 = new Name("Martin", "Gilbert");

        author8 = new Author(birth8, death8, name8, "Placeholder");


        birth13 = new Date(1874, 11, 30);
        death13 = new Date(1965, 1, 24);
        name13 = new Name("Winston", "Churchill");

        subject3 = new Person(birth13, death13, name13);

        biography3 = new Biography("A Life",1991, author8, subject3);

        biography3.display();

        // Biography 4
        birth9 = new Date(1949, 3, 3);
        name9 = new Name("Ron", "Chernow");

        author9 = new Author(birth9, null, name9, "Placeholder");


        birth14 = new Date(1755, 1, 11);
        death14 = new Date(1804, 7, 12);
        name14 = new Name("Alexander", "Hamilton");

        subject4 = new Person(birth14, death14, name14);

        biography4 = new Biography("Alexander Hamilton",2004, author9, subject4);

        biography4.display();

        // Biography 5
        birth15 = new Date(1879, 3, 14);
        death15 = new Date(1955, 4, 18);
        name15 = new Name("Albert", "Einstein");

        subject5 = new Person(birth15, death15, name15);

        biography5 = new Biography("Einstein: His Life and Universe",2007, author7, subject5);

        biography5.display();

    }
}
