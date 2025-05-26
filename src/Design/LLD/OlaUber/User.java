package Design.LLD.OlaUber;

import java.util.UUID;

public class User {
    private final String id;
    private final String name;
    private final String contactNumber;

    public User(String name, String contactNumber) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.contactNumber = contactNumber;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getContactNumber() {
        return contactNumber;
    }
}
