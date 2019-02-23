public class TestMapsVersionOfGladLibs {
    public static void main(String[] args) {
        MapsVersionOfGladLibs mapsVersionOfGladLibs = new MapsVersionOfGladLibs("dataset/data");
        mapsVersionOfGladLibs.makeStory();
        System.out.println();
        System.out.println("Total labels " + mapsVersionOfGladLibs.totalWordsInMap());
        System.out.println("Total used labels " + mapsVersionOfGladLibs.totalWordsConsidered());
    }
}
