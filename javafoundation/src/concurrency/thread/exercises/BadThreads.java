package concurrency.thread.exercises;

/**
 * created by dbx on 2019/4/8
 */
public class BadThreads {

    static String message;

//    synchronized String setMessage(String message) {
//        BadThreads.message = message;
//        return message;
//    }

    private static class CorrectorThread extends Thread {

        public void run() {
            try {
                sleep(1000);
            } catch (InterruptedException e) {

            }
            // Key statement 1:
            message = "Mares do eat oats.";
        }
    }

    public static void main(String args[]) throws InterruptedException {
//        BadThreads.CorrectorThread correctorThread = new CorrectorThread();
//        correctorThread.start();
//        correctorThread.join();

        (new CorrectorThread()).start();

        message = "Mares do not eat oats.";
        Thread.sleep(2000);
        // Key statement 2:
        System.out.println(message);
    }
}
