package Models;

public class MovieTypeEntry {
    private int id;
    private String type;

    // Getters and setters
    public int getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "MovieTypeEntry{" +
                "id=" + id +
                ", type='" + type + '\'' +
                '}';
    }
}
