package curso.java.hibernate.data.entity;

import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
@Entity
@Table(name = "TBL_SCOPE")
public class Scope implements Serializable{

    @Serial
    private static final long serialVersionUID = -1;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer id;
    @Column
    private String name;
    @Column
    private String description;


    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }


    @Override
    public String toString() {
        return "Scope{" +
                "id=" + id +
                ", name=" + name + '\'' +
                ", description=" + description + '\'' +
                '}';
    }
}