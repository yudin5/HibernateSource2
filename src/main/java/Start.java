import entity.Author;
import entity.Book;
import org.apache.log4j.Logger;
import org.hibernate.Session;

public class Start {

    private static final Logger LOG = Logger.getLogger(AuthorHelper.class.getName());

    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        for (Author author : new AuthorHelper().getAuthorList()) {
//            System.out.println("author = " + author.getName());
            LOG.warn(author.getName());
        }

        for (Book book : new BookHelper().getBookList()) {
            System.out.println("book = " + book.getName());
        }
    }
}
