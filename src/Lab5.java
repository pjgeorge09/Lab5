import java.io.*;
import java.util.Scanner;
import java.util.Date;
//import java.util.Comparator;

public class Lab5 {
	
	@SuppressWarnings("rawtypes")
	public static PriorityQueue<Comparable, Game> priorityQueue;
	//public static PriorityQueue<Comparable, Game> priorityQueueTemp;
	public static Game aGame;
	public static int lineCount = 0;
	@SuppressWarnings({ "resource", "unchecked", "rawtypes" })
	
	
	
	public void sortGames(File anInFile, File anOutFile, SortBy aSort) throws IOException {
		
		FileReader fr = new FileReader(anInFile); //"C:\\Users\\Peter\\Repos\\Lab5\\anInFile.txt" for myself
		Scanner scan = new Scanner(fr).useDelimiter("-delim-"); //Also equals ("(,|\\s)+");     "(\\p{javaWhitespace}|,)+"   WHITESPACE
		
		if((aSort == SortBy.NAME) || (aSort == SortBy.DATE) || (aSort == SortBy.CONSOLE)) {
			while(scan.hasNextLine()) {
				
				String[] toSplit = scan.nextLine().split("-delim-");
				lineCount++;
				
				if(toSplit.length == 2) {	//String split by the -delim- into an array of exactly 3, if NOT THREE,  goes to else condition, prints line & break

					String gameName = toSplit[0]; //GAME NAME
					
					String gameDateString = toSplit[1];
					int conversion = Integer.parseInt(gameDateString);  // GAME DATE PARSED TO DATE OBJECT
					Date gameDate = new Date(conversion); 
				
					String gameConsole = toSplit[2]; //GAME CONSOLE
				
					Game newGame = new Game(gameName, gameDate, gameConsole); // GAME OBJECT
				
					if(aSort == SortBy.NAME) {
						priorityQueue.insert(new PQEntry(gameName, newGame));
					}
					else if (aSort == SortBy.DATE) {
						priorityQueue.insert(new PQEntry(gameDate, newGame));
					}
					else if (aSort == SortBy.CONSOLE) {
						priorityQueue.insert(new PQEntry(gameConsole, newGame));
					}
					else {
						System.out.println("Something went wrong. Tried to sort by something other than NAME, DATE, or CONSOLE");
						break;
					}
				}
				else {
					System.out.println("An error occured on line " + lineCount + ". Format needs to be exactly Name, Date, Console");
				}
				
		PrintWriter writer = new PrintWriter(anOutFile); //		C:\\Users\\Peter\\Repos\\Lab5\\anOutFile.txt
		
		for(int i = priorityQueue.size(); i > 0; i--) {
			PQEntry temp = priorityQueue.remove();
			writer.write(temp.getValue().toString()); //Should I put it back in the queue? 
			//priorityQueueTemp.insert(temp);
		}
		//priorityQueue = priorityQueueTemp; //Two things pointing same location, probably bad.
		writer.close();
		scan.close();
		fr.close();
		lineCount = 0;
			}
		}
		else {
			System.out.println("Something went wrong. Tried to sort by something other than NAME, DATE, or CONSOLE");
		}
	}
	
}
