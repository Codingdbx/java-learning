package interfaceandInheritance;

/**
 * created by dbx on 2019/3/9
 */
public class TestSimpleTimeClient {

    public static void main(String... args) {
        TimeClient2 myTimeClient = new SimpleTimeClient();
        System.out.println("Current time: " + myTimeClient.toString());
        System.out.println("Time in Asia: " + myTimeClient.getZonedDateTime("Blah blah").toString());
    }
}
