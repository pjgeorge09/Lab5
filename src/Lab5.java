import java.io.*;
import java.util.Scanner;
import java.util.Date;
import java.util.Comparator;

public class Lab5 {
	
	
	static DateComparator dateComparator = new DateComparator();
	static StringComparator stringComparator = new StringComparator();
	public static PriorityQueue<Date, Game> datePriorityQueue = new PriorityQueue<Date, Game>(dateComparator);
	public static PriorityQueue<String, Game> stringPriorityQueue = new PriorityQueue<String, Game>(stringComparator);
	public static int lineCount = 0;
	@SuppressWarnings({ "resource", "unchecked", "rawtypes" })
	
	
	public static void sortGames(File anInFile, File anOutFile, SortBy aSort) throws IOException {
		
		Scanner scan = new Scanner(anInFile).useDelimiter("-delim-"); //Also equals ("(,|\\s)+");     "(\\p{javaWhitespace}|,)+"   WHITESPACE
		
		if(aSort == SortBy.DATE) {			
			while(scan.hasNextLine()) {				
				String[] toSplit = scan.nextLine().split("-delim-");
				lineCount++;				
				if(toSplit.length == 3) {	//String split by the -delim- into an array of exactly 3, if NOT THREE,  goes to else condition, prints line & break
					String gameName = toSplit[0]; //GAME NAME
					String gameDateString = toSplit[1];
					Date gameDate = new Date(Long.parseLong(gameDateString));// GAME DATE PARSED TO DATE OBJECT
					String gameConsole = toSplit[2]; //GAME CONSOLE
					Game newGame = new Game(gameName, gameDate, gameConsole); // GAME OBJECT
					datePriorityQueue.insert(new PQEntry(gameDate, newGame));
				}
			}
			
			PrintWriter writer = new PrintWriter(anOutFile); //		C:\\Users\\Peter\\Repos\\Lab5\\anOutFile.txt
			
			for(int i = datePriorityQueue.size(); i > 0; i--) {
				PQEntry temp = datePriorityQueue.remove();
				writer.println(temp.getValue().toString());//Should I put it back in the queue? 
			}
			writer.close();
			lineCount = 0;
		}
		else {
			while(scan.hasNextLine()) {				
				String[] toSplit = scan.nextLine().split("-delim-");
				lineCount++;				
				if(toSplit.length == 3) {	//String split by the -delim- into an array of exactly 3, if NOT THREE,  goes to else condition, prints line & break
					String gameName = toSplit[0]; //GAME NAME
					String gameDateString = toSplit[1];
					Date gameDate = new Date(Long.parseLong(gameDateString));// GAME DATE PARSED TO DATE OBJECT
					String gameConsole = toSplit[2]; //GAME CONSOLE
					Game newGame = new Game(gameName, gameDate, gameConsole); // GAME OBJECT
					if(aSort == SortBy.NAME) {
						stringPriorityQueue.insert(new PQEntry(gameName, newGame));
					}
					if(aSort == SortBy.CONSOLE) {
						stringPriorityQueue.insert(new PQEntry(gameConsole, newGame));
					}
				}
			}
			PrintWriter writer = new PrintWriter(anOutFile); //		C:\\Users\\Peter\\Repos\\Lab5\\anOutFile.txt
			
			for(int i = stringPriorityQueue.size(); i > 0; i--) {
				PQEntry temp = stringPriorityQueue.remove();
				writer.println(temp.getValue().toString()); //Should I put it back in the queue? 
			}
			writer.close();
			lineCount = 0;
		}
		scan.close();
	}
	
	
	
	public static class DateComparator implements Comparator<Date>{

		@Override
		public int compare(Date o1, Date o2) {
			return o1.compareTo(o2);
		}
		
	}
	public static class StringComparator implements Comparator<String>{

		@Override
		public int compare(String o1, String o2) {
			return o1.compareTo(o2);
		}	
	}

	
}
