package my.test.testtask.Responces;

import com.google.gson.annotations.SerializedName;

public class NoteResponce {

    @SerializedName("type")
    private String type;

    @SerializedName("contents")
    private String contents;

    @SerializedName("url")
    private String url;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
