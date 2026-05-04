package Entities;
import java.util.UUID;

public abstract class ParentEntity {
    // We use String for ID because UUID gives us a unique text code
    private String id = UUID.randomUUID().toString().substring(0, 8); // Just take the first 8 characters
    private String name;
    // Add Email and phone
    private String email;
    private String phone;

    // Standard getters and setters so we can read and write the data
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    // Add getters and setting of Email and phone
    //Email
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    //Phone
    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }
}