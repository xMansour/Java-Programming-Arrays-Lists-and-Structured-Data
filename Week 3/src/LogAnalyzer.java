import edu.duke.FileResource;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

/**
 * In the LogAnalyzer class you will need to complete the constructor to initialize records to an empty ArrayList
 * and complete the readFile method to create a FileResource and to iterate over all the lines in the file. For each line,
 * create a LogEntry and store it in the records ArrayList. (Refer to the lecture on parsing log files for help.)
 */
public class LogAnalyzer {
    private ArrayList<LogEntry> records;

    public LogAnalyzer() {
        records = new ArrayList<>();
    }

    public void readFile(String fileName) {
        FileResource fileResource = new FileResource(fileName);
        for (String line : fileResource.lines()) {
            LogEntry logEntry = WebLogParser.parseEntry(line);
            records.add(logEntry);
        }
    }

    public void testLogEntry() {
        LogEntry le = new LogEntry("1.2.3.4", new Date(), "example request", 200, 500);
        System.out.println(le);
        LogEntry le2 = new LogEntry("1.2.100.4", new Date(), "example request 2", 300, 400);
        System.out.println(le2);
    }

    public void printAll() {
        for (LogEntry logEntry : records) {
            System.out.println(logEntry);
        }
    }

    public int countUniqueIPs() {
        ArrayList<String> uniqueIps = new ArrayList<>();

        for (LogEntry logEntry : records) {
            String ip = logEntry.getIpAddress();
            if (!uniqueIps.contains(ip)) {
                uniqueIps.add(ip);
            }
        }

        return uniqueIps.size();
    }

    public void printAllHigherThanNum(int num) {
        for (LogEntry logEntry : records) {
            if (logEntry.getStatusCode() > num) {
                System.out.println(logEntry);
            }
        }
    }


    public ArrayList<String> uniqueIPVisitsOnDay(String someday) {
        ArrayList<String> ips = new ArrayList<>();
        for (LogEntry logEntry : records) {
            if (logEntry.getAccessTime().toString().contains(someday)) {
                ips.add(logEntry.getIpAddress());
            }

        }

        return ips;
    }

    public int countUniqueIPsInRange(int low, int high) {
        int numberOfIps = 0;
        for (LogEntry logEntry : records) {
            if (logEntry.getStatusCode() > low && logEntry.getStatusCode() < high) {
                numberOfIps++;
            }
        }

        return numberOfIps;
    }


    public HashMap<String, Integer> countVisitsPerIp() {
        HashMap<String, Integer> counts = new HashMap<>();
        for (LogEntry logEntry : records) {
            if (counts.containsKey(logEntry.getIpAddress())) {
                counts.put(logEntry.getIpAddress(), counts.get(logEntry.getIpAddress()) + 1);
            } else {
                counts.put(logEntry.getIpAddress(), 1);
            }
        }

        return counts;
    }


    public int mostNumberVisitsByIP(HashMap<String, Integer> map) {
        int max = 0;
        for (int value : map.values()) {
            if (max < value)
                max = value;

        }
        return max;
    }


    public ArrayList<String> iPsMostVisits(HashMap<String, Integer> map) {
        ArrayList<String> ips = new ArrayList<>();
        int max = mostNumberVisitsByIP(map);
        for (String ip : map.keySet()) {
            if (map.get(ip) >= max)
                ips.add(ip);
        }

        return ips;
    }


    public HashMap<String, ArrayList<String>> iPsForDays() {
        HashMap<String, ArrayList<String>> map = new HashMap<>();

        for (LogEntry logEntry : records) {
            String date = logEntry.getAccessTime().toString();
            if (map.containsKey(date)) {
                ArrayList<String> ips = new ArrayList<>();
                ips.add(logEntry.getIpAddress());
                map.put(date, ips);
            } else {
                map.get(date).add(logEntry.getIpAddress());
            }
        }

        return map;
    }

    public String dayWithMostIPVisits(HashMap<String, ArrayList<String>> map) {
        int max = 0;
        String mostVisitedDay = null;
        for (String date : map.keySet()) {
            if (map.get(date).size() > max) {
                max = map.get(date).size();
                mostVisitedDay = date;
            }
        }
        return mostVisitedDay;
    }

    public ArrayList<String> iPsWithMostVisitsOnDay(HashMap<String, ArrayList<String>> map, String date) {
        ArrayList<String> ips = map.get(date);
        HashMap<String, Integer> counts = new HashMap<>();
        for (String iP : ips) {
            if (!counts.containsKey(iP)) {
                counts.put(iP, 1);
            } else {
                counts.put(iP, counts.get(iP) + 1);
            }
        }
        return iPsMostVisits(counts);
    }
}
