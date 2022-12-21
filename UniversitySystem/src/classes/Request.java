package classes;

import java.io.Serializable;

import enums.StateOfRequest;
import generators.GeneratorRequestID;
import users.User;

/**
 * Request class
 */
public class Request implements Serializable {
	private static final long serialVersionUID = 1L;
	private String id;
	private String description;
	private User from;
	private StateOfRequest state;

	/**
	 * Default constructor
	 * @param id
	 * @param description
	 * @param from
	 * @param state
	 */
	public Request(String id, String description, User from, StateOfRequest state) {
		this.id = id;
		this.description = description;
		this.from = from;
		this.state = state;
	}
	
	/**
	 * Default constructor
	 * @param from
	 * @param description
	 */
	public Request(User from, String description) {
		this.id = GeneratorRequestID.generateID();
		this.from = from;
		this.description = description;
		this.state = StateOfRequest.CHECKING;
	}

	/**
	 * Getter for Request ID
	 * @return String
	 */
	public String getId() {
		return this.id;
	}

	/**
	 * Getter for Request Description
	 * @return String
	 */
	public String getDescription() {
		return this.description;
	}

	/**
	 * Setter for Request Description
	 * @param description
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * Getter for Request sender
	 * @return User
	 */
	public User getFrom() {
		return this.from;
	}

	/**
	 * Setter for Request sender
	 * @param from
	 */
	public void setFrom(User from) {
		this.from = from;
	}

	/**
	 * Getter for Request Status
	 * @return
	 */
	public StateOfRequest getState() {
		return this.state;
	}

	/**
	 * Setter for Request Status
	 * @param state
	 */
	public void setState(StateOfRequest state) {
		this.state = state;
	}
	
	public boolean equals(Object o) {
		if(this == o) return true;
		if(o == null) return false;
		if(this.getClass() != o.getClass()) return false;
		
		Request r = (Request) o;
		return this.getId().equals(r.getId());
	}
	
	/**
	 * Return string representation of the Object
	 * @return String
	 */
	public String toString() {
		return this.id + " " + this.getFrom().getId() + " " + this.getFrom().getName() + " " +  this.description + " "
				+ this.state;
	}
}
