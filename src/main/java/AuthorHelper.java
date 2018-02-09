import entity.Author;
import entity.Author_;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.persistence.criteria.Selection;
import java.util.List;

public class AuthorHelper {
    private SessionFactory sessionFactory;

    public AuthorHelper() {
        sessionFactory = HibernateUtil.getSessionFactory();
    }

    public List<Author> getAuthorList() {
        // открыть сессию - для манипуляции с персистентными объектами
        Session session = sessionFactory.openSession();
        session.get(Author.class, 1L); // получение объекта по id

        // этап подготовки запроса
        // объект-конструктор запросов для Criteria API
        CriteriaBuilder cb = session.getCriteriaBuilder();// не использовать session.createCriteria, т.к. deprecated
        CriteriaQuery cq = cb.createQuery(Author.class);
        Root<Author> root = cq.from(Author.class);// первостепенный, корневой entity (в sql запросе - from)
        //cq.select(root);// необязательный оператор, если просто нужно получить все значения

        // выборка полей, в классе Автор должен быть конструктор с этими параметрами
        Selection[] selection = {root.get(Author_.id), root.get(Author_.name)};

        cq.select(cb.construct(Author.class, selection)); // Необязательный оператор, если просто нужно получить все значения

        // этап выполнения запроса
        Query query = session.createQuery(cq);
        List<Author> authorList = query.getResultList();
        session.close();
        return authorList;
    }
    // Добавляет нового автора в таблицу Author
    public Author addAuthor(Author author) {
//        Session session = sessionFactory.openSession();
//        session.beginTransaction();
//        session.save(author); // генерит ID и вставляет в объект
//        session.getTransaction().commit();
//        session.close();

        Session session = sessionFactory.openSession();
        Author a1 = session.get(Author.class, 1L);
        a1.setName("FirstElement");
        a1.setSecondName("Number1");
        session.beginTransaction();
        session.save(a1); // сгенерит ID и вставляет в объект
        session.getTransaction().commit();
        session.close();

        return author;
    }
    public void add200authors() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        for (int i = 0; i < 200; i++) {
            Author author = new Author();
            author.setName("FirstName200+" + i);
            author.setSecondName("SecondName+" + i);
            session.save(author);
            if (i % 10 == 0) session.flush();
        }

        session.getTransaction().commit();
        session.close();
    }
    public Author getAuthor(String name){
        return null;
    }

}
