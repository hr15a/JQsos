package nc.dva.qsos.api.model;

import java.io.Serializable;
import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "templates")
public class Template extends QsosFile implements Serializable {

    /**
     * Generated serialVersionUID
     */
    private static final long serialVersionUID = -6725877320125924573L;

    @Column(name = "updatedate")
    private String updateTimestamp;

    /**
     * Default constructor.
     */
    public Template() {
    }

    /**
     * @param id
     * @param qsosAppFamily
     * @param qsosSpecificFormat
     * @param language
     * @param file
     * @param creationTimestamp
     * @param updateTimestamp
     * @param uploader
     * @param repository
     * @param fileContent
     */
    public Template(long id, String qsosAppFamily, String qsosSpecificFormat,
            String language, String file, String creationTimestamp,
            String updateTimestamp, String uploader, String repository,
            byte[] fileContent) {
        this.id = id;
        this.qsosAppFamily = qsosAppFamily;
        this.qsosSpecificFormat = qsosSpecificFormat;
        this.language = language;
        this.file = file;
        this.creationTimestamp = creationTimestamp;
        this.updateTimestamp = updateTimestamp;
        this.uploader = uploader;
        this.repository = repository;
        this.fileContent = Arrays.copyOf(fileContent, fileContent.length);
    }

    public Template(QsosFile file) {
        this.id = file.getId();
        this.qsosAppFamily = file.getQsosAppFamily();
        this.qsosSpecificFormat = file.getQsosSpecificFormat();
        this.language = file.getLanguage();
        this.file = file.getFile();
        this.creationTimestamp = file.getCreationTimestamp();
        this.uploader = file.getUploader();
        this.repository = file.getRepository();
        this.fileContent = Arrays.copyOf(file.getFileContent(),
                file.getFileContent().length);
    }

    /**
     * @return the updateTimestamp
     */
    public String getUpdateTimestamp() {
        return updateTimestamp;
    }

    /**
     * @param updateTimestamp
     *            the updateTimestamp to set
     */
    public void setUpdateTimestamp(String updateTimestamp) {
        this.updateTimestamp = updateTimestamp;
    }

    /*
     * (non-Javadoc)
     * 
     * @see nc.dva.qsos.api.model.QsosFile#getId()
     */
    @Override
    public Long getId() {
        // TODO Auto-generated method stub
        return super.getId();
    }

    /*
     * (non-Javadoc)
     * 
     * @see nc.dva.qsos.api.model.QsosFile#setId(long)
     */
    @Override
    public void setId(Long id) {
        // TODO Auto-generated method stub
        super.setId(id);
    }

    /*
     * (non-Javadoc)
     * 
     * @see nc.dva.qsos.api.model.QsosFile#getQsosAppFamily()
     */
    @Override
    public String getQsosAppFamily() {
        // TODO Auto-generated method stub
        return super.getQsosAppFamily();
    }

    /*
     * (non-Javadoc)
     * 
     * @see nc.dva.qsos.api.model.QsosFile#setQsosAppFamily(java.lang.String)
     */
    @Override
    public void setQsosAppFamily(String qsosAppFamily) {
        // TODO Auto-generated method stub
        super.setQsosAppFamily(qsosAppFamily);
    }

    /*
     * (non-Javadoc)
     * 
     * @see nc.dva.qsos.api.model.QsosFile#getQsosSpecificFormat()
     */
    @Override
    public String getQsosSpecificFormat() {
        // TODO Auto-generated method stub
        return super.getQsosSpecificFormat();
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * nc.dva.qsos.api.model.QsosFile#setQsosSpecificFormat(java.lang.String)
     */
    @Override
    public void setQsosSpecificFormat(String qsosSpecificFormat) {
        // TODO Auto-generated method stub
        super.setQsosSpecificFormat(qsosSpecificFormat);
    }

    /*
     * (non-Javadoc)
     * 
     * @see nc.dva.qsos.api.model.QsosFile#getLanguage()
     */
    @Override
    public String getLanguage() {
        // TODO Auto-generated method stub
        return super.getLanguage();
    }

    /*
     * (non-Javadoc)
     * 
     * @see nc.dva.qsos.api.model.QsosFile#setLanguage(java.lang.String)
     */
    @Override
    public void setLanguage(String language) {
        // TODO Auto-generated method stub
        super.setLanguage(language);
    }

    /*
     * (non-Javadoc)
     * 
     * @see nc.dva.qsos.api.model.QsosFile#getFile()
     */
    @Override
    public String getFile() {
        // TODO Auto-generated method stub
        return super.getFile();
    }

    /*
     * (non-Javadoc)
     * 
     * @see nc.dva.qsos.api.model.QsosFile#setFile(java.lang.String)
     */
    @Override
    public void setFile(String file) {
        // TODO Auto-generated method stub
        super.setFile(file);
    }

    /*
     * (non-Javadoc)
     * 
     * @see nc.dva.qsos.api.model.QsosFile#getCreationTimestamp()
     */
    @Override
    public String getCreationTimestamp() {
        // TODO Auto-generated method stub
        return super.getCreationTimestamp();
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * nc.dva.qsos.api.model.QsosFile#setCreationTimestamp(java.lang.String)
     */
    @Override
    public void setCreationTimestamp(String creationTimestamp) {
        // TODO Auto-generated method stub
        super.setCreationTimestamp(creationTimestamp);
    }

    /*
     * (non-Javadoc)
     * 
     * @see nc.dva.qsos.api.model.QsosFile#getUploader()
     */
    @Override
    public String getUploader() {
        // TODO Auto-generated method stub
        return super.getUploader();
    }

    /*
     * (non-Javadoc)
     * 
     * @see nc.dva.qsos.api.model.QsosFile#setUploader(java.lang.String)
     */
    @Override
    public void setUploader(String uploader) {
        // TODO Auto-generated method stub
        super.setUploader(uploader);
    }

    /*
     * (non-Javadoc)
     * 
     * @see nc.dva.qsos.api.model.QsosFile#getRepository()
     */
    @Override
    public String getRepository() {
        // TODO Auto-generated method stub
        return super.getRepository();
    }

    /*
     * (non-Javadoc)
     * 
     * @see nc.dva.qsos.api.model.QsosFile#setRepository(java.lang.String)
     */
    @Override
    public void setRepository(String repository) {
        // TODO Auto-generated method stub
        super.setRepository(repository);
    }

    /*
     * (non-Javadoc)
     * 
     * @see nc.dva.qsos.api.model.QsosFile#getFileContent()
     */
    @Override
    public byte[] getFileContent() {
        // TODO Auto-generated method stub
        return super.getFileContent();
    }

    /*
     * (non-Javadoc)
     * 
     * @see nc.dva.qsos.api.model.QsosFile#setFileContent(byte[])
     */
    @Override
    public void setFileContent(byte[] fileContent) {
        // TODO Auto-generated method stub
        super.setFileContent(fileContent);
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
        result = prime
                * result
                + ((creationTimestamp == null) ? 0 : creationTimestamp
                        .hashCode());
        result = prime * result + ((file == null) ? 0 : file.hashCode());
        result = prime * result + (int) (id ^ (id >>> 32));
        result = prime * result
                + ((language == null) ? 0 : language.hashCode());
        result = prime * result
                + ((qsosAppFamily == null) ? 0 : qsosAppFamily.hashCode());
        result = prime
                * result
                + ((qsosSpecificFormat == null) ? 0 : qsosSpecificFormat
                        .hashCode());
        result = prime * result
                + ((repository == null) ? 0 : repository.hashCode());
        result = prime * result
                + ((updateTimestamp == null) ? 0 : updateTimestamp.hashCode());
        result = prime * result
                + ((uploader == null) ? 0 : uploader.hashCode());
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
        if (!(obj instanceof Template)) {
            return false;
        }
        Template other = (Template) obj;
        if (creationTimestamp == null) {
            if (other.creationTimestamp != null) {
                return false;
            }
        } else if (!creationTimestamp.equals(other.creationTimestamp)) {
            return false;
        }
        if (file == null) {
            if (other.file != null) {
                return false;
            }
        } else if (!file.equals(other.file)) {
            return false;
        }
        if (id != other.id) {
            return false;
        }
        if (language == null) {
            if (other.language != null) {
                return false;
            }
        } else if (!language.equals(other.language)) {
            return false;
        }
        if (qsosAppFamily == null) {
            if (other.qsosAppFamily != null) {
                return false;
            }
        } else if (!qsosAppFamily.equals(other.qsosAppFamily)) {
            return false;
        }
        if (qsosSpecificFormat == null) {
            if (other.qsosSpecificFormat != null) {
                return false;
            }
        } else if (!qsosSpecificFormat.equals(other.qsosSpecificFormat)) {
            return false;
        }
        if (repository == null) {
            if (other.repository != null) {
                return false;
            }
        } else if (!repository.equals(other.repository)) {
            return false;
        }
        if (updateTimestamp == null) {
            if (other.updateTimestamp != null) {
                return false;
            }
        } else if (!updateTimestamp.equals(other.updateTimestamp)) {
            return false;
        }
        if (uploader == null) {
            if (other.uploader != null) {
                return false;
            }
        } else if (!uploader.equals(other.uploader)) {
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
        builder.append("Template [\n\tid=");
        builder.append(id);
        builder.append("\n\t, qsosAppFamily=");
        builder.append(qsosAppFamily);
        builder.append("\n\t, qsosSpecificFormat=");
        builder.append(qsosSpecificFormat);
        builder.append("\n\t, language=");
        builder.append(language);
        builder.append("\n\t, file=");
        builder.append(file);
        builder.append("\n\t, creationTimestamp=");
        builder.append(creationTimestamp);
        builder.append("\n\t, updateTimestamp=");
        builder.append(updateTimestamp);
        builder.append("\n\t, uploader=");
        builder.append(uploader);
        builder.append("\n\t, repository=");
        builder.append(repository);
        builder.append("\n\t, fileContent=");
        builder.append(Arrays.toString(fileContent));
        builder.append("\n]");
        return builder.toString();
    }

}
