import java.io.Serializable;
import java.util.UUID;

public class Patron implements Serializable {
    private static final long serialVersionUID = 1L;

    private final String id;
    private String name;
    private String email;

    public Patron(String name, String email) {
        this.id = UUID.randomUUID().toString();
        this.name = name.trim();
        this.email = email == null ? "" : email.trim();
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public String getEmail() { return email; }

    public void setName(String name) { this.name = name.trim(); }
    public void setEmail(String email) { this.email = email.trim(); }

    @Override
    public String toString() {
        return String.format("[%s] %s (%s)", id.substring(0, 8), name, email);
    }
}
