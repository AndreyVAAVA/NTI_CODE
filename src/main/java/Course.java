import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Course {
    private long id;
    private String name;
    @SerializedName("owner")
    private Owner owner;
    private boolean isPublish;
    private boolean isPreModerationEnabled;
    @SerializedName("groups")
    private ArrayList<Groups> groups;
    private String trajectory;
    private long passingScore;
    private String certSetting;
    private String visibilityStatus;
    @SerializedName("additionalFields")
    private ArrayList<String> additionalFields;
    private String locale;

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

    public boolean isPreModerationEnabled() {
        return isPreModerationEnabled;
    }

    public void setPreModerationEnabled(boolean preModerationEnabled) {
        isPreModerationEnabled = preModerationEnabled;
    }

    public ArrayList<Groups> getGroups() {
        return groups;
    }

    public void setGroups(ArrayList<Groups> groups) {
        this.groups = groups;
    }

    public String getTrajectory() {
        return trajectory;
    }

    public void setTrajectory(String trajectory) {
        this.trajectory = trajectory;
    }

    public long getPassingScore() {
        return passingScore;
    }

    public void setPassingScore(long passingScore) {
        this.passingScore = passingScore;
    }

    public String getCertSetting() {
        return certSetting;
    }

    public void setCertSetting(String certSetting) {
        this.certSetting = certSetting;
    }

    public String getVisibilityStatus() {
        return visibilityStatus;
    }

    public void setVisibilityStatus(String visibilityStatus) {
        this.visibilityStatus = visibilityStatus;
    }

    public ArrayList<String> getAdditionalFields() {
        return additionalFields;
    }

    public void setAdditionalFields(ArrayList<String> additionalFields) {
        this.additionalFields = additionalFields;
    }

    public String getLocale() {
        return locale;
    }

    public void setLocale(String locale) {
        this.locale = locale;
    }
}
class Groups extends Owner{ }

