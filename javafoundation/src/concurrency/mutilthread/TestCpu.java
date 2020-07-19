package concurrency.mutilthread;

/**
 * <p>Description: </p>
 *
 * @author dbx
 * @date 2020/4/2 13:39
 * @since JDK1.8
 */
public class TestCpu {
    private static Object object = new Object();
    private static int count = 0;

    public static void main(String[] args) {
        for(;;){
            new Thread(new Runnable(){
                public void run(){
                    synchronized(object){
                        count += 1;
                        System.err.println("New thread #"+count);
                    }
                    for(;;){
                        try {
                            Thread.sleep(1000);
                        } catch (Exception e){
                            System.err.println(e);
                        }
                    }
                }
            }).start();
        }
    }
}
