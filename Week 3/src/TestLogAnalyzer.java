public class TestLogAnalyzer {
    public static void main(String[] args) {
        //testLogAnalyzer();
        testUniqueIP();
    }

    private static void testLogAnalyzer() {
        LogAnalyzer logAnalyzer = new LogAnalyzer();
        //logAnalyzer.testLogEntry();
        logAnalyzer.readFile("datasets/small_log.txt");
        logAnalyzer.printAll();
    }

    private static void testUniqueIP() {
        LogAnalyzer logAnalyzer = new LogAnalyzer();
        logAnalyzer.readFile("datasets/small_log.txt");
        System.out.println("Number of Unique ips: " + logAnalyzer.countUniqueIPs());
        logAnalyzer.printAllHigherThanNum(200);
        System.out.println(logAnalyzer.uniqueIPVisitsOnDay("Sep 30").size());
        System.out.println(logAnalyzer.countUniqueIPsInRange(100, 300));
    }


}
