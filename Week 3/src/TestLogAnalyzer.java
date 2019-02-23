public class TestLogAnalyzer {
    public static void main(String[] args) {
        testLogAnalyzer();
    }

    private static void testLogAnalyzer() {
        LogAnalyzer logAnalyzer = new LogAnalyzer();
        //logAnalyzer.testLogEntry();
        logAnalyzer.readFile("datasets/small_log.txt");
        logAnalyzer.printAll();
    }
}
