package model;

public class NewPost {
    private String id;

    private String user_login;

    private String dateToRelease;

    private String title;

    private String content;

    public String getId() {
        return id;
    }

    public NewPost() {
    }

    public NewPost(String id, String user_login, String dateToRelease, String title, String content) {
        this.id = id;
        this.user_login = user_login;
        this.dateToRelease = dateToRelease;
        this.title = title;
        this.content = content;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUser_login() {
        return user_login;
    }

    public void setUser_login(String user_login) {
        this.user_login = user_login;
    }

    public String getDateToRelease() {
        return dateToRelease;
    }

    public void setDateToRelease(String dateToRelease) {
        this.dateToRelease = dateToRelease;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
