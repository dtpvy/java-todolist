package BLL;

import javax.persistence.*;

@Entity
@Table(name = "Item")
public class Item {

    Item() {
        setName("");
    }

    Item(String name) {
        setName(name);
    }

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="name", length=20)
    private String name;

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}

