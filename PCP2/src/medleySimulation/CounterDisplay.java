//M. M. Kuttel 2024 mkuttel@gmail.com
// Simple Thread class to update the display of a text field
package medleySimulation;

import java.awt.Color;
import javax.swing.JLabel;

//You don't need to change this class
public class CounterDisplay  implements Runnable {
	
	private FinishCounter results;
	private JLabel win;
	private JLabel second;
	private JLabel third;
		
	CounterDisplay(JLabel w,JLabel s, JLabel t, FinishCounter score) {
        this.win=w;
		second = s;
		third = t;
        this.results=score;
    }
	
	public void run() { //this thread just updates the display of a text field
        while (true) {
        	//test changes colour when the race is won
        	if (results.isRaceWon()) {
        		win.setForeground(new Color(255, 215, 0));
               	win.setText("First Team: " + results.getWinningTeam() + "!!"); 
				//+results.toStringSecond()+results.toStringThird()
				if (results.getSecondAcross()){ 
					second.setForeground(new Color(192, 192, 192));
					second.setText(results.toStringSecond());
				}
				if (results.getThirdAcross()){
					third.setForeground(new Color(205, 127, 50));
					third.setText(results.toStringThird());
				}
			}
        	else {
        		win.setForeground(Color.BLACK);
        		win.setText("------"); 
				second.setForeground(Color.BLACK);
        		second.setText("     ------     "); 
				third.setForeground(Color.BLACK);
        		third.setText("------"); 

        	}	
        }
    }
}
