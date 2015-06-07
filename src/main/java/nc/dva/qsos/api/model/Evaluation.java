package nc.dva.qsos.api.model;

import java.io.Serializable;
import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "evaluations")
@NamedQueries({
		@NamedQuery(name = "evaluation.findByDomain", query = "SELECT e FROM Evaluation e WHERE e.qsosAppFamily = ?"),
		@NamedQuery(name = "evaluation.countByDomain", query = "SELECT COUNT(e.id) FROM Evaluation e WHERE e.qsosAppFamily = ?") })
public class Evaluation extends QsosFile implements Serializable {

	/**
	 * Generated serialVersionUID.
	 */
	private static final long serialVersionUID = -7028980233056931783L;

	@Column(name = "qsosappname")
	private String qsosAppName;

	@Column(name = "releasenumber")
	private String release;

	@Column(name = "appname")
	private String appName;

	@Column(name = "licensedesc")
	private String licenseDesc;

	@Column(name = "validation")
	private String validation;

	@Column(name = "sections")
	private Long sections;

	@Column(name = "criteria")
	private Long criteria;

	@Column(name = "criteria_scorable")
	private Long criteriaScorable;

	@Column(name = "criteria_scored")
	private Long criteriaScored;

	@Column(name = "criteria_notscored")
	private Long criteriaNotScored;

	@Column(name = "comments")
	private Long comments;

	@Column(name = "criteria_commented")
	private Long criteriaCommented;

	@Column(name = "criteria_notcommented")
	private Long criteriaNotCommented;

	/**
	 * Default constructor.
	 */
	public Evaluation() {
	}

	/**
	 * @param id
	 * @param qsosAppFamily
	 * @param qsosSpecificFormat
	 * @param language
	 * @param file
	 * @param qsosAppName
	 * @param release
	 * @param appName
	 * @param licenseDesc
	 * @param creationTimestamp
	 * @param validation
	 * @param sections
	 * @param criteria
	 * @param criteriaScorable
	 * @param criteriaScored
	 * @param criteriaNotScored
	 * @param comments
	 * @param criteriaCommented
	 * @param criteriaNotCommented
	 * @param uploader
	 * @param repository
	 * @param fileContent
	 */
	public Evaluation(long id, String qsosAppFamily, String qsosSpecificFormat,
			String language, String file, String qsosAppName, String release,
			String appName, String licenseDesc, String creationTimestamp,
			String validation, Long sections, Long criteria,
			Long criteriaScorable, Long criteriaScored, Long criteriaNotScored,
			Long comments, Long criteriaCommented, Long criteriaNotCommented,
			String uploader, String repository, byte[] fileContent) {
		this.id = id;
		this.qsosAppFamily = qsosAppFamily;
		this.qsosSpecificFormat = qsosSpecificFormat;
		this.language = language;
		this.file = file;
		this.qsosAppName = qsosAppName;
		this.release = release;
		this.appName = appName;
		this.licenseDesc = licenseDesc;
		this.creationTimestamp = creationTimestamp;
		this.validation = validation;
		this.sections = sections;
		this.criteria = criteria;
		this.criteriaScorable = criteriaScorable;
		this.criteriaScored = criteriaScored;
		this.criteriaNotScored = criteriaNotScored;
		this.comments = comments;
		this.criteriaCommented = criteriaCommented;
		this.criteriaNotCommented = criteriaNotCommented;
		this.uploader = uploader;
		this.repository = repository;
		this.fileContent = Arrays.copyOf(fileContent, fileContent.length);
	}

	public Evaluation(QsosFile file) {
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
	 * @return the qsosAppName
	 */
	public String getQsosAppName() {
		return qsosAppName;
	}

	/**
	 * @param qsosAppName
	 *            the qsosAppName to set
	 */
	public void setQsosAppName(String qsosAppName) {
		this.qsosAppName = qsosAppName;
	}

	/**
	 * @return the release
	 */
	public String getRelease() {
		return release;
	}

	/**
	 * @param release
	 *            the release to set
	 */
	public void setRelease(String release) {
		this.release = release;
	}

	/**
	 * @return the appName
	 */
	public String getAppName() {
		return appName;
	}

	/**
	 * @param appName
	 *            the appName to set
	 */
	public void setAppName(String appName) {
		this.appName = appName;
	}

	/**
	 * @return the licenseDesc
	 */
	public String getLicenseDesc() {
		return licenseDesc;
	}

	/**
	 * @param licenseDesc
	 *            the licenseDesc to set
	 */
	public void setLicenseDesc(String licenseDesc) {
		this.licenseDesc = licenseDesc;
	}

	/**
	 * @return the validation
	 */
	public String getValidation() {
		return validation;
	}

	/**
	 * @param validation
	 *            the validation to set
	 */
	public void setValidation(String validation) {
		this.validation = validation;
	}

	/**
	 * @return the sections
	 */
	public Long getSections() {
		return sections;
	}

	/**
	 * @param sections
	 *            the sections to set
	 */
	public void setSections(Long sections) {
		this.sections = sections;
	}

	/**
	 * @return the criteria
	 */
	public Long getCriteria() {
		return criteria;
	}

	/**
	 * @param criteria
	 *            the criteria to set
	 */
	public void setCriteria(Long criteria) {
		this.criteria = criteria;
	}

	/**
	 * @return the criteriaScorable
	 */
	public Long getCriteriaScorable() {
		return criteriaScorable;
	}

	/**
	 * @param criteriaScorable
	 *            the criteriaScorable to set
	 */
	public void setCriteriaScorable(Long criteriaScorable) {
		this.criteriaScorable = criteriaScorable;
	}

	/**
	 * @return the criteriaScored
	 */
	public Long getCriteriaScored() {
		return criteriaScored;
	}

	/**
	 * @param criteriaScored
	 *            the criteriaScored to set
	 */
	public void setCriteriaScored(Long criteriaScored) {
		this.criteriaScored = criteriaScored;
	}

	/**
	 * @return the criteriaNotScored
	 */
	public Long getCriteriaNotScored() {
		return criteriaNotScored;
	}

	/**
	 * @param criteriaNotScored
	 *            the criteriaNotScored to set
	 */
	public void setCriteriaNotScored(Long criteriaNotScored) {
		this.criteriaNotScored = criteriaNotScored;
	}

	/**
	 * @return the comments
	 */
	public Long getComments() {
		return comments;
	}

	/**
	 * @param comments
	 *            the comments to set
	 */
	public void setComments(Long comments) {
		this.comments = comments;
	}

	/**
	 * @return the criteriaCommented
	 */
	public Long getCriteriaCommented() {
		return criteriaCommented;
	}

	/**
	 * @param criteriaCommented
	 *            the criteriaCommented to set
	 */
	public void setCriteriaCommented(Long criteriaCommented) {
		this.criteriaCommented = criteriaCommented;
	}

	/**
	 * @return the criteriaNotCommented
	 */
	public Long getCriteriaNotCommented() {
		return criteriaNotCommented;
	}

	/**
	 * @param criteriaNotCommented
	 *            the criteriaNotCommented to set
	 */
	public void setCriteriaNotCommented(Long criteriaNotCommented) {
		this.criteriaNotCommented = criteriaNotCommented;
	}

	@Override
	public int hashCode() {
		final int prime = 32;
		int result = 1;
		result = prime * result + ((appName == null) ? 0 : appName.hashCode());
		result = prime * result
				+ ((comments == null) ? 0 : comments.hashCode());
		result = prime
				* result
				+ ((creationTimestamp == null) ? 0 : creationTimestamp
						.hashCode());
		result = prime * result
				+ ((criteria == null) ? 0 : criteria.hashCode());
		result = prime
				* result
				+ ((criteriaCommented == null) ? 0 : criteriaCommented
						.hashCode());
		result = prime
				* result
				+ ((criteriaNotCommented == null) ? 0 : criteriaNotCommented
						.hashCode());
		result = prime
				* result
				+ ((criteriaNotScored == null) ? 0 : criteriaNotScored
						.hashCode());
		result = prime
				* result
				+ ((criteriaScorable == null) ? 0 : criteriaScorable.hashCode());
		result = prime * result
				+ ((criteriaScored == null) ? 0 : criteriaScored.hashCode());
		result = prime * result + ((file == null) ? 0 : file.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result
				+ ((language == null) ? 0 : language.hashCode());
		result = prime * result
				+ ((licenseDesc == null) ? 0 : licenseDesc.hashCode());
		result = prime * result
				+ ((qsosAppFamily == null) ? 0 : qsosAppFamily.hashCode());
		result = prime * result
				+ ((qsosAppName == null) ? 0 : qsosAppName.hashCode());
		result = prime
				* result
				+ ((qsosSpecificFormat == null) ? 0 : qsosSpecificFormat
						.hashCode());
		result = prime * result + ((release == null) ? 0 : release.hashCode());
		result = prime * result
				+ ((repository == null) ? 0 : repository.hashCode());
		result = prime * result
				+ ((sections == null) ? 0 : sections.hashCode());
		result = prime * result
				+ ((uploader == null) ? 0 : uploader.hashCode());
		result = prime * result
				+ ((validation == null) ? 0 : validation.hashCode());
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
		if (!(obj instanceof Evaluation)) {
			return false;
		}
		Evaluation other = (Evaluation) obj;
		if (appName == null) {
			if (other.appName != null) {
				return false;
			}
		} else if (!appName.equals(other.appName)) {
			return false;
		}
		if (comments == null) {
			if (other.comments != null) {
				return false;
			}
		} else if (!comments.equals(other.comments)) {
			return false;
		}
		if (creationTimestamp == null) {
			if (other.creationTimestamp != null) {
				return false;
			}
		} else if (!creationTimestamp.equals(other.creationTimestamp)) {
			return false;
		}
		if (criteria == null) {
			if (other.criteria != null) {
				return false;
			}
		} else if (!criteria.equals(other.criteria)) {
			return false;
		}
		if (criteriaCommented == null) {
			if (other.criteriaCommented != null) {
				return false;
			}
		} else if (!criteriaCommented.equals(other.criteriaCommented)) {
			return false;
		}
		if (criteriaNotCommented == null) {
			if (other.criteriaNotCommented != null) {
				return false;
			}
		} else if (!criteriaNotCommented.equals(other.criteriaNotCommented)) {
			return false;
		}
		if (criteriaNotScored == null) {
			if (other.criteriaNotScored != null) {
				return false;
			}
		} else if (!criteriaNotScored.equals(other.criteriaNotScored)) {
			return false;
		}
		if (criteriaScorable == null) {
			if (other.criteriaScorable != null) {
				return false;
			}
		} else if (!criteriaScorable.equals(other.criteriaScorable)) {
			return false;
		}
		if (criteriaScored == null) {
			if (other.criteriaScored != null) {
				return false;
			}
		} else if (!criteriaScored.equals(other.criteriaScored)) {
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
		if (licenseDesc == null) {
			if (other.licenseDesc != null) {
				return false;
			}
		} else if (!licenseDesc.equals(other.licenseDesc)) {
			return false;
		}
		if (qsosAppFamily == null) {
			if (other.qsosAppFamily != null) {
				return false;
			}
		} else if (!qsosAppFamily.equals(other.qsosAppFamily)) {
			return false;
		}
		if (qsosAppName == null) {
			if (other.qsosAppName != null) {
				return false;
			}
		} else if (!qsosAppName.equals(other.qsosAppName)) {
			return false;
		}
		if (qsosSpecificFormat == null) {
			if (other.qsosSpecificFormat != null) {
				return false;
			}
		} else if (!qsosSpecificFormat.equals(other.qsosSpecificFormat)) {
			return false;
		}
		if (release == null) {
			if (other.release != null) {
				return false;
			}
		} else if (!release.equals(other.release)) {
			return false;
		}
		if (repository == null) {
			if (other.repository != null) {
				return false;
			}
		} else if (!repository.equals(other.repository)) {
			return false;
		}
		if (sections == null) {
			if (other.sections != null) {
				return false;
			}
		} else if (!sections.equals(other.sections)) {
			return false;
		}
		if (uploader == null) {
			if (other.uploader != null) {
				return false;
			}
		} else if (!uploader.equals(other.uploader)) {
			return false;
		}
		if (validation == null) {
			if (other.validation != null) {
				return false;
			}
		} else if (!validation.equals(other.validation)) {
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
		builder.append("Evaluation [\n\tid=");
		builder.append(id);
		builder.append("\n\t, qsosAppFamily=");
		builder.append(qsosAppFamily);
		builder.append("\n\t, qsosSpecificFormat=");
		builder.append(qsosSpecificFormat);
		builder.append("\n\t, language=");
		builder.append(language);
		builder.append("\n\t, file=");
		builder.append(file);
		builder.append("\n\t, qsosAppName=");
		builder.append(qsosAppName);
		builder.append("\n\t, release=");
		builder.append(release);
		builder.append("\n\t, appName=");
		builder.append(appName);
		builder.append("\n\t, licenseDesc=");
		builder.append(licenseDesc);
		builder.append("\n\t, creationTimestamp=");
		builder.append(creationTimestamp);
		builder.append("\n\t, validation=");
		builder.append(validation);
		builder.append("\n\t, sections=");
		builder.append(sections);
		builder.append("\n\t, criteria=");
		builder.append(criteria);
		builder.append("\n\t, criteriaScorable=");
		builder.append(criteriaScorable);
		builder.append("\n\t, criteriaScored=");
		builder.append(criteriaScored);
		builder.append("\n\t, criteriaNotScored=");
		builder.append(criteriaNotScored);
		builder.append("\n\t, comments=");
		builder.append(comments);
		builder.append("\n\t, criteriaCommented=");
		builder.append(criteriaCommented);
		builder.append("\n\t, criteriaNotCommented=");
		builder.append(criteriaNotCommented);
		builder.append("\n\t, uploader=");
		builder.append(uploader);
		builder.append("\n\t, repository=");
		builder.append(repository);
		/*
		 * builder.append("\n\t, fileContent=");
		 * builder.append(Arrays.toString(fileContent));
		 */
		builder.append("\n]");
		return builder.toString();
	}

}
