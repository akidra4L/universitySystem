package classes;

import java.io.Serializable;

import enums.MarkLetter;

public class Mark implements Serializable {
	private static final long serialVersionUID = 1L;
	private double score;
	private MarkLetter markLetter;
	
	public Mark(double score) {
		this.score = score;
	}
	
	public Mark() {
		this.score = 0;
	}
	
	public double getScore() {
		return score;
	}
	public void setScore(double score) {
		this.score = score;
	}
	
	public void setMarkLetter(MarkLetter markLetter) {
		this.markLetter = markLetter;
	}
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
	
	public String toString() {
		return this.score + " " + this.markLetter;
	}
}
