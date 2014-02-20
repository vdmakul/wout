package lv.vdm.wout.domain;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Media {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private String url;

    private String contentType;

    private Boolean internalMedia;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdTime;

    @Lob
    private byte[] content;

    protected Media() {
    }

    public Media(String name, byte[] content, String contentType) {
        this.name = name;
        this.content = content;
        this.contentType = contentType;
        this.internalMedia = true;
        this.createdTime = new Date();
    }

    public Media(String name, String url, String contentType) {
        this.name = name;
        this.url = url;
        this.contentType = contentType;
        this.internalMedia = false;
        this.createdTime = new Date();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public byte[] getContent() {
        return content;
    }

    public void setContent(byte[] content) {
        this.content = content;
    }

    public Boolean getInternalMedia() {
        return internalMedia;
    }

    public void setInternalMedia(Boolean internalMedia) {
        this.internalMedia = internalMedia;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Media media = (Media) o;

        if (createdTime != null ? !createdTime.equals(media.createdTime) : media.createdTime != null) return false;
        if (name != null ? !name.equals(media.name) : media.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (createdTime != null ? createdTime.hashCode() : 0);
        return result;
    }
}
