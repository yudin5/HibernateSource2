public class Start {

//    private static final Logger LOG = Logger.getLogger(AuthorHelper.class.getName());

    public static void main(String[] args) {
        // Здесь не нужно открывать сессию
//        Session session = HibernateUtil.getSessionFactory().openSession();

//        for (Author author : new AuthorHelper().getAuthorList()) {
//            System.out.println("author = " + author.getName());
////            LOG.warn(author.getName());
//        }
//
//        for (Book book : new BookHelper().getBookList()) {
//            System.out.println("book = " + book.getName());
////            LOG.warn(book.getName());
//        }

        // Добавляем нового автора
//        Author author = new Author("Тест3");

//        new AuthorHelper().addAuthor(author);

        // Добавляем 200 авторов
//        new AuthorHelper().add200authors();

        new AuthorHelper().getAuthorList();
        System.out.println("End");
    }
}
