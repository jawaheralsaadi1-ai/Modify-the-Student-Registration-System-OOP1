/*
package Entities;

public abstract class ParentEntity {

    //Every item has an ID and a Name.
    private int id;
    private String name;

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
}
*/
// Refactor
package Entities;
import java.util.UUID;//UUID library to ensure every student and teacher has a truly unique code.

public abstract class ParentEntity {
    // Using UUID makes the ID a unique string
    private String id = UUID.randomUUID().toString();
    private String name;

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
}