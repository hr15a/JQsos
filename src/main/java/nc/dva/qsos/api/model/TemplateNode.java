package nc.dva.qsos.api.model;

public class TemplateNode {

	private int level;
	private String id;
	private String parent_id;
	private String criteria;

	public TemplateNode() {
	}

	/**
	 * @param level
	 * @param id
	 * @param parent_id
	 * @param criteria
	 */
	public TemplateNode(int level, String id, String parent_id, String criteria) {
		this.level = level;
		this.id = id;
		this.parent_id = parent_id;
		this.criteria = criteria;
	}

	/**
	 * @return the level
	 */
	public int getLevel() {
		return level;
	}

	/**
	 * @param level
	 *            the level to set
	 */
	public void setLevel(int level) {
		this.level = level;
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the parent_id
	 */
	public String getParent_id() {
		return parent_id;
	}

	/**
	 * @param parent_id
	 *            the parent_id to set
	 */
	public void setParent_id(String parent_id) {
		this.parent_id = parent_id;
	}

	/**
	 * @return the criteria
	 */
	public String getCriteria() {
		return criteria;
	}

	/**
	 * @param criteria
	 *            the criteria to set
	 */
	public void setCriteria(String criteria) {
		this.criteria = criteria;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Node [level=").append(level).append(", ");
		if (id != null)
			builder.append("id=").append(id).append(", ");
		if (parent_id != null)
			builder.append("parent_id=").append(parent_id).append(", ");
		if (criteria != null)
			builder.append("criteria=").append(criteria);
		builder.append("]");
		return builder.toString();
	}

}
