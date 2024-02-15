package lk.ijse;

import lk.ijse.config.FactoryConfiguration;
import lk.ijse.entity.Author;
import lk.ijse.entity.Book;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        /*Author omesh = new Author("S001", "Omesh","Sri lanka", null);
        Author nuhara = new Author("S002", "Nuhara","Norway", null);
        Author kamal = new Author("S003", "Kamal","UK", null);
        Author nuwan = new Author("S004", "Nuwan", "USA", null);

        Book book1 = new Book("B001", "Life", 1994, 2200.00, nuhara);
        Book book2 = new Book("B002", "Lite", 1998, 2200.00, omesh);
        Book book3 = new Book("B003", "Madol", 2012, 3400.00, nuhara);
        Book book4 = new Book("B004", "quite", 2008, 5050.00, kamal);
        Book book5 = new Book("B005", "sleep", 2033, 1200.00, nuwan);
        Book book6 = new Book("B006", "Book of cooking", 1999, 4200.00, nuwan);

        List<Book> books = List.of(book2, book3);

        nuhara.setBooks(books);
        nuwan.setBooks(List.of(book4));
        nuwan.setBooks(List.of(book6));
        omesh.setBooks(List.of(book5));
        kamal.setBooks(List.of(book1));

        session.save(omesh);
        session.save(nuhara);
        session.save(kamal);
        session.save(nuwan);

        session.save(book1);
        session.save(book2);
        session.save(book3);
        session.save(book4);
        session.save(book5);
        session.save(book6);

        transaction.commit();*/

        // Q1

        Query query = session.createQuery("select title from Book where publicationYear >= 2010");
        List resultList = query.getResultList();

        System.out.println(resultList.toString());


        // Q2

        Query query1 = session.createQuery("update Book b set b.price = b.price * 1.1 where b.author.id = :authorId");
        query.setParameter("authorId", 1);

        int result = query.executeUpdate();
        System.out.println("Result: " + result);


        //Q3
        //-

        // Q4

        Query query2 = session.createQuery("SELECT AVG(b.price) FROM Book b");
        Double averagePrice = (Double) query.getSingleResult();;
        System.out.println(averagePrice);


        // Question 05

        Query query3 = session.createQuery("SELECT a.id, COUNT(b.id) FROM Author a JOIN Book b on a.id = b.author.id GROUP BY a.id");
        List<Object[]> resultList1 = query.getResultList();

        for (Object[] objects : resultList1) {
            System.out.println(objects[0] + " : " + objects[1]);
        }


        // Q6

        Query query4 = session.createQuery("SELECT b.title FROM Book b JOIN Author a on b.author.id = a.id WHERE a.country = :countryName");
        query.setParameter("countryName", "japan");
        List resultList2 = query.getResultList();

        for (Object o : resultList) {
            System.out.println(o);
        }


        // Question 07

        //-


        // Qustion 10

        Query query5 = session.createQuery("SELECT a.name FROM Author a WHERE ( SELECT COUNT(b.id) FROM Book b WHERE a.id = b.author.id ) > ( SELECT AVG(authorBookCount) FROM ( SELECT COUNT(b.id) AS authorBookCount FROM Book b GROUP BY b.author.id ))");
        List<String> resultList3 = query.getResultList();

        for (String s : resultList3) {
            System.out.println(s);
        }

        session.close();
    }
}
