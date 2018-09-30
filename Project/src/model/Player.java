package model;

public class Player {

	private String name;
	private int age;
	private String team;
	private int pointForMatch;
	private int reboundsForMatch;
	private int assistencesForMatch;
	private int locksForMatch;
	
	public Player(String name, int age, String team, int pointForMatch, int reboundsForMatch, int assitencesForMatch, int locksForMatch) {
		this.name = name;
		this.age = age;
		this.pointForMatch = pointForMatch;
		this.reboundsForMatch = reboundsForMatch;
		this.assistencesForMatch = assitencesForMatch;
		this.locksForMatch = locksForMatch;
	}
	
	public Player(String nombre, int  edad) {
		this.name = nombre;
		this.age = edad;
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

	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		this.team = team;
	}

	public int getPointForMatch() {
		return pointForMatch;
	}

	public void setPointForMatch(int pointForMatch) {
		this.pointForMatch = pointForMatch;
	}

	public int getReboundsForMatch() {
		return reboundsForMatch;
	}

	public void setReboundsForMatch(int reboundsForMatch) {
		this.reboundsForMatch = reboundsForMatch;
	}

	public int getAssistencesForMatch() {
		return assistencesForMatch;
	}

	public void setAssistencesForMatch(int assistencesForMatch) {
		this.assistencesForMatch = assistencesForMatch;
	}

	public int getLocksForMatch() {
		return locksForMatch;
	}

	public void setLocksForMatch(int locksForMatch) {
		this.locksForMatch = locksForMatch;
	}
	
	
	
	
	
}
