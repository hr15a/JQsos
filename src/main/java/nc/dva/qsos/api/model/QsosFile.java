package nc.dva.qsos.api.model;

import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class QsosFile {

    @Id()
    @GeneratedValue
    @Column(name = "id")
    protected Long id;

    @Column(name = "qsosappfamily")
    protected String qsosAppFamily;

    @Column(name = "qsosspecificformat")
    protected String qsosSpecificFormat;

    @Column(name = "language")
    protected String language;

    @Column(name = "filename")
    protected String file;

    @Column(name = "creation")
    protected String creationTimestamp;

    @Column(name = "uploader")
    protected String uploader;

    @Column(name = "repo")
    protected String repository;

    @Column(name = "filecontent", columnDefinition = "BLOB")
    protected byte[] fileContent;

    /**
     * @param id
     * @param qsosAppFamily
     * @param qsosSpecificFormat
     * @param language
     * @param file
     * @param creationTimestamp
     * @param uploader
     * @param repository
     * @param fileContent
     */
    public QsosFile(long id, String qsosAppFamily, String qsosSpecificFormat,
            String language, String file, String creationTimestamp,
            String uploader, String repository, byte[] fileContent) {
        this.id = id;
        this.qsosAppFamily = qsosAppFamily;
        this.qsosSpecificFormat = qsosSpecificFormat;
        this.language = language;
        this.file = file;
        this.creationTimestamp = creationTimestamp;
        this.uploader = uploader;
        this.repository = repository;
        this.fileContent = fileContent;
    }

    /**
     *
     */
    public QsosFile() {
    }

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id
     *            the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return the qsosAppFamily
     */
    public String getQsosAppFamily() {
        return qsosAppFamily;
    }

    /**
     * @param qsosAppFamily
     *            the qsosAppFamily to set
     */
    public void setQsosAppFamily(String qsosAppFamily) {
        this.qsosAppFamily = qsosAppFamily;
    }

    /**
     * @return the qsosSpecificFormat
     */
    public String getQsosSpecificFormat() {
        return qsosSpecificFormat;
    }

    /**
     * @param qsosSpecificFormat
     *            the qsosSpecificFormat to set
     */
    public void setQsosSpecificFormat(String qsosSpecificFormat) {
        this.qsosSpecificFormat = qsosSpecificFormat;
    }

    /**
     * @return the language
     */
    public String getLanguage() {
        return language;
    }

    /**
     * @param language
     *            the language to set
     */
    public void setLanguage(String language) {
        this.language = language;
    }

    /**
     * @return the file
     */
    public String getFile() {
        return file;
    }

    /**
     * @param file
     *            the file to set
     */
    public void setFile(String file) {
        this.file = file;
    }

    /**
     * @return the creationTimestamp
     */
    public String getCreationTimestamp() {
        return creationTimestamp;
    }

    /**
     * @param creationTimestamp
     *            the creationTimestamp to set
     */
    public void setCreationTimestamp(String creationTimestamp) {
        this.creationTimestamp = creationTimestamp;
    }

    /**
     * @return the uploader
     */
    public String getUploader() {
        return uploader;
    }

    /**
     * @param uploader
     *            the uploader to set
     */
    public void setUploader(String uploader) {
        this.uploader = uploader;
    }

    /**
     * @return the repository
     */
    public String getRepository() {
        return repository;
    }

    /**
     * @param repository
     *            the repository to set
     */
    public void setRepository(String repository) {
        this.repository = repository;
    }

    /**
     * @return the fileContent
     */
    public byte[] getFileContent() {
        return Arrays.copyOf(fileContent, fileContent.length);
    }

    /**
     * @param fileContent
     *            the fileContent to set
     */
    public void setFileContent(byte[] fileContent) {
        this.fileContent = Arrays.copyOf(fileContent, fileContent.length);
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("QsosFile [\n\tid=");
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
        builder.append("\n\t, uploader=");
        builder.append(uploader);
        builder.append("\n\t, repository=");
        builder.append(repository);
        builder.append("\n]");
        return builder.toString();
    }

}
