package collection;

import java.util.ArrayList;
import java.util.List;

/**
 * created by dbx on 2019/4/28
 *
 */
public class ForeEachMain {

    public static void main(String[] args) {
        List<String> userNames = new ArrayList<String>() {{
            add("Hollis");
            add("hollis");
            add("HollisChuang");
            add("H");
        }};

        //为了安全考虑，在foreEach中不能使用remove() 移除元素
        for (String userName : userNames) {
            if (userName.equals("Hollis")) {
                userNames.remove(userName);
            }
        }

        System.out.println(userNames);



    }

}
