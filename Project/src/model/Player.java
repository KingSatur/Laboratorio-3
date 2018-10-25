package model;

public class Player {

	private int year;
	private String team;
	private String name;
	private int age;
	private int g;
	private int pointsForMatch;
	private int rebounds;
	private int assistences;
	private int ballThefts;
	private int locks;
	
	public Player(int year, String team, String name, int age, int g, int pointsForMatch, int rebounds, int assistences,int ballThefts, int locks) {
		this.year = year;
		this.team = team;
		this.name = name;
		this.age = age;
		this.g = g;
		this.pointsForMatch = pointsForMatch;
		this.rebounds = rebounds;
		this.assistences = assistences;
		this.ballThefts = ballThefts;
		this.locks = locks;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		this.team = team;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getG() {
		return g;
	}

	public void setG(int g) {
		this.g = g;
	}

	public int getPointsForMatch() {
		return pointsForMatch;
	}

	public void setPointsForMatch(int pointsForMatch) {
		this.pointsForMatch = pointsForMatch;
	}

	public int getRebounds() {
		return rebounds;
	}

	public void setRebounds(int rebounds) {
		this.rebounds = rebounds;
	}

	public int getAssistences() {
		return assistences;
	}

	public void setAssistences(int assistences) {
		this.assistences = assistences;
	}

	public int getBallThefts() {
		return ballThefts;
	}

	public void setBallThefts(int ballThefts) {
		this.ballThefts = ballThefts;
	}

	public int getLocks() {
		return locks;
	}

	public void setLocks(int locks) {
		this.locks = locks;
	}

		
	
	
	
	
	
	
	
}
