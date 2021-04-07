import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class CourseList {
    @SerializedName("data")
    private ArrayList<Information> data;

    public ArrayList<Information> getData() {
        return data;
    }

    public void setData(ArrayList<Information> data) {
        this.data = data;
    }
}
class Information {
    private long id;
    private String name;
    @SerializedName("owner")
    private Owner owner;
    private boolean isPublish;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public boolean isPublish() {
        return isPublish;
    }

    public void setPublish(boolean publish) {
        isPublish = publish;
    }
}
class Owner {
    private long id;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}