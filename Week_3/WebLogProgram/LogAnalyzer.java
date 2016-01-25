import edu.duke.*;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Write a description of class LogAnalyzer here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

public class LogAnalyzer
{
     private ArrayList<LogEntry> records;
     
     public LogAnalyzer() {
         records = new ArrayList<>();
     }

    public int countUniqueIPs() {
        ArrayList<String> uniqueIPs = new ArrayList<>();
        for (LogEntry le:  records) {
           // String ip = records.get(i).getIpAddress();
            if (!uniqueIPs.contains(le.getIpAddress())) {
                uniqueIPs.add(le.getIpAddress());
            }
        }
        return uniqueIPs.size();
    }

    public void printAllHigherThanNum(int num) {
        for (LogEntry le : records) {
            if (le.getStatusCode() > num) {
                System.out.println(le.toString());
            }
        }
    }

    public ArrayList<String> uniqueIPVisitsOnDay(String day) {
        ArrayList<String> uniqueIPVisitorOnDay = new ArrayList<>();
        for (LogEntry le : records) {
            if (le.getAccessTime().toString().contains(day)) {
                if (!uniqueIPVisitorOnDay.contains(le.getIpAddress())) {
                   uniqueIPVisitorOnDay.add(le.getIpAddress());
                }
            }
        }
        return uniqueIPVisitorOnDay;
    }

    public HashMap<String, Integer> countVisitsPerIP() {
        HashMap<String, Integer> counts = new HashMap<>();
        for (LogEntry le : records) {
            if (!counts.containsKey(le.getIpAddress())) {
                counts.put(le.getIpAddress(), 1);
            } else {
                counts.put(le.getIpAddress(), counts.get(le.getIpAddress()) + 1);
            }
        }
        return counts;
    }

    public HashMap<String, ArrayList<String>> IPsForDays() {
        HashMap<String, ArrayList<String>> map = new HashMap<>();
        ArrayList<String> ip;
        for (LogEntry le : records) {
            String day = le.getAccessTime().toString().substring(4, 10);
            if (!map.containsKey(day)) {
                ip = new ArrayList<>();
                ip.add(le.getIpAddress());
                map.put(day, ip);
            } else {
                ip = map.get(day);
                ip.add(le.getIpAddress()+1);
                map.put(day, ip);
            }
        }
        return map;
    }

    public String dayWithMostIPVisits(HashMap<String, ArrayList<String>> IPsForDays) {
        int maxIdxOfIPvisits = 0;
        String maxDay="";
        for (String day : IPsForDays.keySet()) {
            if (IPsForDays.get(day).size() > maxIdxOfIPvisits) {
                maxIdxOfIPvisits = IPsForDays.get(day).size();
                maxDay = day;
            }
        }
        return maxDay;
    }

    public ArrayList<String> IPsMostVisits(HashMap<String, Integer> map) {
        ArrayList<String> mostVisit = new ArrayList<>();
        int maxCount = 0;
        for (String key: map.keySet()) {
            if (map.get(key) > maxCount) {
                maxCount = map.get(key);
            }
        }
        for (String key : map.keySet()) {
            if (map.get(key) == maxCount) {
                mostVisit.add(key);
            }
        }
        return mostVisit;
    }

    public ArrayList<String> iPsWithMostVisitsOnDay(HashMap<String, ArrayList<String>> map, String day) {
        ArrayList<String> ipMostVisitonDay;
        HashMap<String,Integer> commonIpinDay = new HashMap<>();
        for (String ip : map.get(day)) {
            if (!commonIpinDay.containsKey(ip)) {
                commonIpinDay.put(ip, 1);
            } else {
                commonIpinDay.put(ip, commonIpinDay.get(ip) + 1);
            }
        }
   //     System.out.println("Common IP: "+ commonIpinDay);
        ipMostVisitonDay = IPsMostVisits(commonIpinDay);
        return ipMostVisitonDay;
    }

    public int mostNumberVisitsByIP(HashMap<String, Integer> map) {
        int maxNumber = 0;
        for (String ip : map.keySet()) {
            if (map.get(ip) > maxNumber) {
                maxNumber = map.get(ip);
            }
        }
        return maxNumber;
    }

    public int countUniqueIPsInRange(int low, int high) {
        ArrayList<String> uniqueIp = new ArrayList<>();
        for (LogEntry le : records) {
            if (le.getStatusCode() >= low & le.getStatusCode() <= high) {
                if (!uniqueIp.contains(le.getIpAddress())) {
                    uniqueIp.add(le.getIpAddress());
                }
            }
        }

        return uniqueIp.size();
    }

     public void readFile(String filename) {
         FileResource file = new FileResource(filename);
         for (String line : file.lines()) {
             LogEntry le = WebLogParser.parseEntry(line);
             records.add(le);
         }
     }
        
     public void printAll() {
         for (LogEntry le : records) {
             System.out.println(le);
         }
     }
     
     
}
