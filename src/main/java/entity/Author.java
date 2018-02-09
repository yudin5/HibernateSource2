package entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
// @Table(уточняющие параметры) - если название таблицы и класса совпадают, то этой аннотации нам не нужно
@Getter // Это lombok, только для удобства. Можно и вручную сгенерить.
@Setter // То же
public class Author implements Serializable { // правило хорошего тона добавить Serializable

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY) // Генерация ID через AutoIncrement в MySQL
    private long id;

    private String name;
}
