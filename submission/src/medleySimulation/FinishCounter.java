// Simple class to record when someone has crossed the line first and wins
package medleySimulation;

public class FinishCounter {
	private boolean firstAcrossLine; //flag
	private boolean secondAcrossLine; //new variables for second
	private boolean thirdAcrossLine;  //new varaibles for third
	private int first; //who won
	private int firstTeam; //counter for patrons who have left the club
	private int second; //no-one has won at start
	private int	secondTeam; //no-one has won at start
	private int third; //no-one has won at start
	private int thirdTeam;
	
	FinishCounter() { 
		firstAcrossLine = true;//no-one has won at start
		secondAcrossLine = true;
		thirdAcrossLine = true;
		first =-1; //no-one has won at start
		firstTeam=-1; //no-one has won at start
		second =-1; //no-one has won at start
		secondTeam=-1; //no-one has won at start
		third =-1; //no-one has won at start
		thirdTeam=-1; //no-one has won at start
	}
		
	//This is called by a swimmer when they touch the fnish line
	public synchronized void finishRace(int swimmer, int team) {
		if(firstAcrossLine) {
			firstAcrossLine=false;
			first =swimmer;
			firstTeam=team;
			}
		//modified to allow second and third place
		else if (secondAcrossLine){
			secondAcrossLine=false;
			second = swimmer;
			secondTeam = team;
		}
		else if (thirdAcrossLine){
			thirdAcrossLine = false;
			third = swimmer;
			thirdTeam = team;
		}
	}
	
	//Has race been won?
	public boolean isRaceWon() {
		return !firstAcrossLine;
	}
	public boolean getSecondAcross() {return !secondAcrossLine;}
	public boolean getThirdAcross() {return !thirdAcrossLine;}


	public int getWinner() { return first; }
	public int getSecond() { return second; }
	public int getThird() { return third;}
	
	public int getWinningTeam() { return firstTeam;}
	public int getSecondTeam() {return secondTeam;}
	public int getThirdTeam() {return thirdTeam;}

	public String toStringSecond()
	{ 
		if (!secondAcrossLine){
			return " Second Team: "+
			getSecondTeam()+"!";
		}
		return "     ------     ";
	}
	public String toStringThird()
	{ 
		if (!thirdAcrossLine){
			return " Third Team: "+
			getThirdTeam();
		}
		return "------";
	} 
}	
