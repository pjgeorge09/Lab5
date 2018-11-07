import java.util.Date;

public class Game {

												//Instance Variables
	private String name;
	private String console;
	private Date date;
	
												//Parameterized Constructor
	public Game(String aName, Date gameDate, String aConsole) {
		name = aName;
		console = aConsole;
		date = gameDate;
	}
	
												//			GETTERS
	/* Getter method for name of Game object	
	 */
	public String getName() {
		return name;
	}
	/* Getter method for console of Game object	
	 */
	public String getConsole() {
		return console;
	}
	/* Getter method for date of Game object	
	 */
	public Date getDate() {
		return date;
	}
	
												//			SETTERS
	/* Setter method to set Game object name	
	 */
	public void setName(String aName) {
		this.name = aName;
	}
	/* Setter method to set Game object console	
	 */
	public void setConsole(String aConsole) {
		this.console = aConsole;
	}
	/* Setter method to set Game object date	
	 */
	public void setDate(Date aDate) {
		this.date = aDate;
	}
	
	
	@Override
	/* Override method for toString
	 */
	public String toString() {
		String toReturn = this.getName() + "-delim-" + this.getDate().getTime() + "-delim-" + this.getConsole();
		return toReturn;
	}
	
}
