package ir.smrahmadi.instageramfarsi.models;

/**
 * Created by lincoln on 3/13/18.
 */

public class User {
    private  String profilePicture;

    public String getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(String profilePicture) {
        this.profilePicture = profilePicture;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    private  String fullName;
}
