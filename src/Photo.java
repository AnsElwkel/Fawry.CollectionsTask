import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public class Photo {
    private String id;
    private String name;
    private LocalDate date;
    private String location;
    private Set<String> tags;

    public Photo(String id, String name, LocalDate date, String location, Set<String> tags) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.location = location;
        this.tags = tags;
    }


    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setTags(HashSet<String> tags) {
        this.tags = tags;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getLocation() {
        return location;
    }

    public Set<String> getTags() {
        return tags;
    }

    @Override
    public String toString() {
        return this.id + " " + this.name + " " + this.date + " " + this.location + " " + this.tags;
    }
}
