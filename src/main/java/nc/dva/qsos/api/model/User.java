package nc.dva.qsos.api.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User implements Serializable {

    /**
     * generated serialVersionUID.
     */
    private static final long serialVersionUID = 6499380602428621765L;

    @Id()
    @GeneratedValue
    @Column(name = "id")
    private int id;

    @Column(name = "login")
    private String login;

    @Column(name = "pass_md5")
    private String md5Password;

    @Column(name = "mail")
    private String mail;

    @Column(name = "contributions")
    private long contributions;

    @Column(name = "status")
    private String status;

    /**
     * @param id
     * @param login
     * @param md5Password
     * @param mail
     * @param contributions
     * @param status
     */
    public User(int id, String login, String md5Password, String mail,
            long contributions, String status) {
        this.id = id;
        this.login = login;
        this.md5Password = md5Password;
        this.mail = mail;
        this.contributions = contributions;
        this.status = status;
    }

    /**
     *
     */
    public User() {
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id
     *            the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the login
     */
    public String getLogin() {
        return login;
    }

    /**
     * @param login
     *            the login to set
     */
    public void setLogin(String login) {
        this.login = login;
    }

    /**
     * @return the md5Password
     */
    public String getMd5Password() {
        return md5Password;
    }

    /**
     * @param md5Password
     *            the md5Password to set
     */
    public void setMd5Password(String md5Password) {
        this.md5Password = md5Password;
    }

    /**
     * @return the mail
     */
    public String getMail() {
        return mail;
    }

    /**
     * @param mail
     *            the mail to set
     */
    public void setMail(String mail) {
        this.mail = mail;
    }

    /**
     * @return the contributions
     */
    public long getContributions() {
        return contributions;
    }

    /**
     * @param contributions
     *            the contributions to set
     */
    public void setContributions(long contributions) {
        this.contributions = contributions;
    }

    /**
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status
     *            the status to set
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        final int prime = (int) serialVersionUID;
        int result = 1;
        result = prime * result
                + (int) (contributions ^ (contributions >>> 32));
        result = prime * result + id;
        result = prime * result + ((login == null) ? 0 : login.hashCode());
        result = prime * result + ((mail == null) ? 0 : mail.hashCode());
        result = prime * result
                + ((md5Password == null) ? 0 : md5Password.hashCode());
        result = prime * result + ((status == null) ? 0 : status.hashCode());
        return result;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof User)) {
            return false;
        }
        User other = (User) obj;
        if (contributions != other.contributions) {
            return false;
        }
        if (id != other.id) {
            return false;
        }
        if (login == null) {
            if (other.login != null) {
                return false;
            }
        } else if (!login.equals(other.login)) {
            return false;
        }
        if (mail == null) {
            if (other.mail != null) {
                return false;
            }
        } else if (!mail.equals(other.mail)) {
            return false;
        }
        if (md5Password == null) {
            if (other.md5Password != null) {
                return false;
            }
        } else if (!md5Password.equals(other.md5Password)) {
            return false;
        }
        if (status == null) {
            if (other.status != null) {
                return false;
            }
        } else if (!status.equals(other.status)) {
            return false;
        }
        return true;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("User [\n\tid=");
        builder.append(id);
        builder.append("\n\t, login=");
        builder.append(login);
        builder.append("\n\t, md5Password=");
        builder.append(md5Password);
        builder.append("\n\t, mail=");
        builder.append(mail);
        builder.append("\n\t, contributions=");
        builder.append(contributions);
        builder.append("\n\t, status=");
        builder.append(status);
        builder.append("\n]");
        return builder.toString();
    }

}
