package io.commandline;

import java.io.Console;
import java.io.IOException;
import java.util.Arrays;

/**
 * created by dbx on 2019/2/19
 */
public class Password {

    public static void main (String args[]) throws IOException {

        Console c = System.console();
        if (c == null) {//操作系统不支持Console
            System.err.println("No console.");
            System.exit(1);
        }

        String login = c.readLine("Enter your login: ");
        char [] oldPassword = c.readPassword("Enter your old password: ");

        if (verify(login, oldPassword)) {
            boolean noMatch;
            do {
                char [] newPassword1 = c.readPassword("Enter your new password: ");
                char [] newPassword2 = c.readPassword("Enter new password again: ");
                noMatch = ! Arrays.equals(newPassword1, newPassword2);
                if (noMatch) {
                    c.format("Passwords don't match. Try again.%n");
                } else {
                    change(login, newPassword1);
                    c.format("Password for %s changed.%n", login);
                }
                Arrays.fill(newPassword1, ' ');//将指定的char值分配给指定的chars数组的每个元素。
                Arrays.fill(newPassword2, ' ');
            } while (noMatch);
        }

        Arrays.fill(oldPassword, ' ');
    }

    // 虚拟更改方法.
    static boolean verify(String login, char[] password) {
        // This method always returns
        // true in this example.
        // Modify this method to verify
        // password according to your rules.
        return true;
    }

    // Dummy change method.
    static void change(String login, char[] password) {
        // Modify this method to change
        // password according to your rules.
    }

//    尝试检索Console对象。如果对象不可用，则中止。
//    调用Console.readLine以提示并读取用户的登录名。
//    调用Console.readPassword以提示并读取用户的现有密码。
//    调用verify以确认用户有权更改密码。（在此示例中，verify是一个始终返回的虚方法true。）
//    重复以下步骤，直到用户输入两次相同的密码：
//    调用Console.readPassword两次以提示并读取新密码。
//    如果用户两次输入相同的密码，请调用change以进行更改。（再次，change是一种虚拟方法。）
//    用空格覆盖两个密码。
//    用空格覆盖旧密码。
}
