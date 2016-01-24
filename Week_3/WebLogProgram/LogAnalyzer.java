import java.util.ArrayList;

/**
 * Write a description of class LogAnalyzer here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

public class LogAnalyzer
{
     private ArrayList<LogEntrySimple> records;
     
     public LogAnalyzer() {
         // complete constructor
     }
        
     public void readFile(String filename) {
         // complete method
     }
        
     public void printAll() {
         for (LogEntrySimple le : records) {
             System.out.println(le);
         }
     }
     
     
}
