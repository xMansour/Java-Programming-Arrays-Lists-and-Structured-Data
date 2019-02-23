import edu.duke.FileResource;

import java.util.ArrayList;
import java.util.Date;

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


}
