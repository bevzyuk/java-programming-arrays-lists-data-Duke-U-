
/**
 * Write a description of class TesterSimple here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.util.*;

public class Main
{
    public static void main(String[] args) {
        LogEntrySimple le = new LogEntrySimple("1.2.3.4", new Date(), "example request", 200, 500);
        System.out.println(le);
        LogEntrySimple le2 = new LogEntrySimple("1.2.100.4", new Date(), "example request 2", 300, 400);
        System.out.println(le2);
    }
    
    public void testLogAnalyzer() {
        // complete method
    }
}
