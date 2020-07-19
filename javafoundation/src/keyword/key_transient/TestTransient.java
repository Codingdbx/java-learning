package keyword.key_transient;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * <p>Description:  </p>
 *
 * @author dbix
 * @date 2019/10/25
 * @since JDK1.8
 */
public class TestTransient {

    public static void main(String[] args) {

        User user = new User("李刚",18,"男","play ball","china");
        User2 user2 = new User2("张三", 20, "男", "china");

        System.out.println("序列化前=================="+user.toString());
        System.out.println("序列化前=================="+user2.toString());
        //序列化
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("D:\\myproject\\java-learning\\javafoundation\\keyword\\key_transient\\user.txt"))) {
            oos.writeObject(user);
        } catch (Exception e) {
            e.printStackTrace();
        }

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("D:\\myproject\\java-learning\\javafoundation\\keyword\\key_transient\\user2.txt"))) {
            oos.writeObject(user2);
        } catch (Exception e) {
            e.printStackTrace();
        }

        //反序列化
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("D:\\myproject\\java-learning\\javafoundation\\keyword\\key_transient\\user.txt"))) {
            User read_user = (User)ois.readObject();
            System.out.println("反序列化后=================="+read_user.toString());

        } catch (Exception e) {
            e.printStackTrace();
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("D:\\myproject\\java-learning\\javafoundation\\keyword\\key_transient\\user2.txt"))) {
            User2 read_user2 = (User2)ois.readObject();
            System.out.println("反序列化后=================="+read_user2.toString());

        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
