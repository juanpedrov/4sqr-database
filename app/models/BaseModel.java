package models;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.hibernate.annotations.GenericGenerator;

import play.db.jpa.GenericModel;

@MappedSuperclass
public class BaseModel extends GenericModel{

	@Id
    @GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	protected String id;

	
	/**
	 * Getters
	 */
	public String getId() {
		return id;
	}
}
