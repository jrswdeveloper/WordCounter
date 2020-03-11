import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;

// This program reads a text file and counts the number of times each word appears.
public class WordCounter {
	public static void main(String[] args) throws IOException,Exception {
		// use a hash map to store words
		HashMap<String,Integer> map = new HashMap<String,Integer>();
		
		// Use scanner class to read a text file
		System.out.println("Enter the file name with directory:");
		Scanner scan = new Scanner(System.in);
		String fileName=scan.nextLine();
        
        // hashset for storing commonwords.txt
        HashSet<String> common = new HashSet<String>();
		
		Scanner commonWordsFile = new Scanner(new File("C:\\Users\\Hp\\Desktop\\data ödev 2, 4 mayýs\\commonwords.txt"));        
        
        while(commonWordsFile.hasNext()) {
        	String commonWord = commonWordsFile.next().toLowerCase();
        	common.add(commonWord);
        }
        commonWordsFile.close();
        Scanner bookFile = new Scanner(new File(fileName));
	
		while(bookFile.hasNext()) {
			String word = bookFile.next().trim().toLowerCase();  // to make case insensitive  
			String[] onlyWord = word.split("[^a-zA-Z0-9']+");   
     				for(String s : onlyWord) {
     					if(!common.contains(s)) {
     						if(map.containsKey(s) && s.length()>1) {
     							// increase count to 1 if this word has already existed in map
     							map.put(s, map.get(s)+1);
     						}
     						else {
     							map.put(s, 1);
     						}
     					}
     					
     					}	
     				}
			bookFile.close();
		// get the thresold value from user
		int number = scan.nextInt();
		for(Map.Entry<String, Integer> entry : map.entrySet()) {
			if(map.get(entry.getKey())>number) {
			System.out.println(entry.getKey() + ":" + entry.getValue());
			}
		}
		scan.close();
	}
}
