package entity;

import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.io.Serializable;

@Entity
// @Table(уточняющие параметры) - если название таблицы и класса совпадают, то этой аннотации нам не нужно
@Getter // Это lombok, только для удобства. Можно и вручную сгенерить.
@Setter // То же
@AllArgsConstructor // То же
@NoArgsConstructor  // То же
@RequiredArgsConstructor  // То же
@DynamicUpdate // Хибернетовская аннотация. Позволяет апдейтить только измененное поле
@DynamicInsert // То же. Эти 2 аннотации не JPA
public class Author implements Serializable { // правило хорошего тона добавить Serializable

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY) // Генерация ID через AutoIncrement в MySQL
    private long id;

    @NonNull
    private String name;

    @Column(name = "second_name")
    private String secondName;

    public Author(long id, String name) {
        this.id = id;
        this.name = name;
    }

}
