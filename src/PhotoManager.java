import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class PhotoManager {
    private ArrayList<Photo> photos ;
    private HashMap<String, ArrayList<Photo>> tags;
    private HashMap<String, ArrayList<Photo>> location;
    private HashMap<LocalDate, ArrayList<Photo>> date;

    PhotoManager(){
        photos = new ArrayList<>();
        tags = new HashMap<>();
        location = new HashMap<>();
        date = new HashMap<>();
    }

    public void uploadPhoto(Photo photo){
        photos.add(photo);
        for(String tag : photo.getTags()){
            if(!tags.containsKey(tag))
                tags.put(tag, new ArrayList<>());
            tags.get(tag).add(photo);
        }
        if(!location.containsKey(photo.getLocation()))
            location.put(photo.getLocation(), new ArrayList<>());
        location.get(photo.getLocation()).add(photo);
        if(!date.containsKey(photo.getDate()))
            date.put(photo.getDate(), new ArrayList<>());
        date.get(photo.getDate()).add(photo);
    }

    public ArrayList<Photo> searchByTag(String tag){
        return tags.containsKey(tag) ? tags.get(tag) : new ArrayList<>();
    }

    public ArrayList<Photo> searchByDate(LocalDate date){
        return this.date.containsKey(date) ? this.date.get(date) : new ArrayList<>();
    }

    public ArrayList<Photo> searchByLocation(String location){
        return this.location.containsKey(location) ? this.location.get(location) : new ArrayList<>();
    }

    public ArrayList<Photo> searchByMultipleTags(Set<String> st){
        var tags = new ArrayList<>(st);
        var ret = new ArrayList<Photo>();
        if(tags.isEmpty())
            return ret;

        ret.addAll(searchByTag(tags.get(0)));
        for(int i = 1; i < tags.size() ; ++i)
            ret.retainAll(searchByTag(tags.get(i)));
        return ret;
    }
}
