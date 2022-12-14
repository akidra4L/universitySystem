package classes;

import enums.MarkLetter;

public class Mark {
	private double score;
	private MarkLetter markLetter;
	
	public Mark(double score) {
		this.score = score;
	}
	
	public double getScore() {
		return score;
	}
	public void setScore(double score) {
		this.score = score;
	}
	
	public MarkLetter getMarkLetter() {
		return markLetter;
	}
	public void setMarkLetter(MarkLetter markLetter) {
		this.markLetter = markLetter;
	}
	
	public String toString() {
		return this.score + " " + this.markLetter;
	}
}
