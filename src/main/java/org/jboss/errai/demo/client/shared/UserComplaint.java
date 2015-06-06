package org.jboss.errai.demo.client.shared;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Version;

import org.jboss.errai.common.client.api.annotations.Portable;
import org.jboss.errai.databinding.client.api.Bindable;

/**
 * This is a JPA entity representing a user complaint. It is used on both the
 * server and the client. On the server, it is persisted into the relational
 * database that is configured as data source in META-INF/persistence.xml. On
 * the client, it is persisted into the browser's offline storage.
 */
@Entity
@Bindable
@Portable
@NamedQueries({@NamedQuery(name = "allComplaints", query = "SELECT c FROM UserComplaint c ORDER BY c.id")})
public class UserComplaint {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Version
    private Long version;

    private String name;
    private String email;
    private String text;

    private boolean done;

    @Lob
    private String image;

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getText() {
        return text;
    }

    public void setText(String complaint) {
        this.text = complaint;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        UserComplaint that = (UserComplaint) o;

        if (done != that.done) {
            return false;
        }
        if (id != null ? !id.equals(that.id) : that.id != null) {
            return false;
        }
        if (version != null ? !version.equals(that.version) : that.version != null) {
            return false;
        }
        if (name != null ? !name.equals(that.name) : that.name != null) {
            return false;
        }
        if (email != null ? !email.equals(that.email) : that.email != null) {
            return false;
        }
        if (text != null ? !text.equals(that.text) : that.text != null) {
            return false;
        }
        return !(image != null ? !image.equals(that.image) : that.image != null);
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (version != null ? version.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (text != null ? text.hashCode() : 0);
        result = 31 * result + (done ? 1 : 0);
        result = 31 * result + (image != null ? image.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "UserComplaint{" +
                "id=" + id +
                ", version=" + version +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", text='" + text + '\'' +
                ", done=" + done +
                ", image='" + image + '\'' +
                '}';
    }
}
