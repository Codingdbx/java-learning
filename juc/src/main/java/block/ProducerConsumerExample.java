package block;

/**
 * created by dbx on 2019/3/26
 */
public class ProducerConsumerExample {

    public static void main(String[] args) {
        Drop drop = new Drop();

        (new Thread(new Producer(drop))).start();

        (new Thread(new Consumer(drop))).start();
    }
}
