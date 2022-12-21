package classes;

import java.io.Serializable;

import enums.MarkLetter;

/**
 * Mark Class
 *
 */
public class Mark implements Serializable {
	private static final long serialVersionUID = 1L;
	private double score;
	private MarkLetter markLetter;
	
	/**
	 * Default constructor
	 * @param score
	 */
	public Mark(double score) {
		this.score = score;
	}
	/**
	 * Default constructor
	 */
	public Mark() {
		this.score = 0;
	}
	
	/**
	 * Getter for Mark's total score
	 * @return Double
	 */
	public double getScore() {
		return score;
	}
	/**
	 * Setter for Mark's total score
	 * @param score
	 */
	public void setScore(double score) {
		this.score = score;
	}
	/**
	 * Setter for Mark Letter representation
	 * @param markLetter
	 */
	public void setMarkLetter(MarkLetter markLetter) {
		this.markLetter = markLetter;
	}
	/**
	 * Getter for Mark Letter representation
	 */
	public MarkLetter getMarkLetter() {
		if (score < 30) {
			setMarkLetter(MarkLetter.F);
		} else if (score > 30 && score < 50) {
			setMarkLetter(MarkLetter.D);
		} else if (score >= 50 && score < 70) {
			setMarkLetter(MarkLetter.C);
		} else if (score >= 70 && score < 90) {
			setMarkLetter(MarkLetter.B);
		} else {
			setMarkLetter(MarkLetter.A);
		}
		return markLetter;
	}
	
	/**
	 * Return string representation of the Object
	 * @return String
	 */
	public String toString() {
		return this.score + " " + this.markLetter;
	}
}
