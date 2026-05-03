package Entities;
import java.util.UUID;

public abstract class ParentEntity {
    private String id = UUID.randomUUID().toString().substring(0, 8);
    private String name;

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
}