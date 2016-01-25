
/**
 * Write a description of class TesterSimple here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.util.Date;

public class Tester
{
    public void testLogEntry() {
        LogEntry le = new LogEntry("1.2.3.4", new Date(), "example request", 200, 500);
        System.out.println(le);
        LogEntry le2 = new LogEntry("1.2.100.4", new Date(), "example request 2", 300, 400);
        System.out.println(le2);
    }
    
    public void testLogAnalyzer() {
        //  FileResource fr = new FileResource();
        String fr = "weblog2_log"; //"weblog1_log";
        LogAnalyzer logAnalyzer = new LogAnalyzer();
        //   System.out.println(fr.asString());
        logAnalyzer.readFile(fr);
     //   logAnalyzer.printAll();
        System.out.println("Uniques IPs is: " + logAnalyzer.countUniqueIPs());
        System.out.println("Log with status great than 400");
        logAnalyzer.printAllHigherThanNum(404);
        System.out.println("Unique visitor on day " + logAnalyzer.uniqueIPVisitsOnDay("Sep 24").size());
        System.out.println("Unique IP in range "+logAnalyzer.countUniqueIPsInRange(200,299));

        System.out.println("********************");
        System.out.println("Most IP visits is " + logAnalyzer.IPsMostVisits(logAnalyzer.countVisitsPerIP()));
        System.out.println("********************");

        System.out.println("********************");
        System.out.println("!!!Most number IP visits is " + logAnalyzer.mostNumberVisitsByIP(logAnalyzer.countVisitsPerIP()));
        System.out.println("********************");

        // HashMap<String, ArrayList<String>> ipForDays = logAnalyzer.IPsForDays();
        System.out.println("Day with most IP visits is: " + logAnalyzer.dayWithMostIPVisits(logAnalyzer.IPsForDays()));
        System.out.println("********************");
        String day = "Sep 29";
        System.out.println("Most visit IP per "+day+" "+ logAnalyzer.iPsWithMostVisitsOnDay(logAnalyzer.IPsForDays(),day));
    }
}
