package classandobject;

/**
 * 本地类
 * created by dbx on 2019/3/4
 */
public class LocalClasses {

    /*该示例通过首先从电话号码中删除除0到9之外的所有字符来验证电话号码。之后，它检查电话号码是否包含正好十位数（北美电话号码的长度）。*/


    static String regularExpression = "[^0-9]";

    //本地类与内部类类似，因为它们无法定义或声明任何静态成员。
    // 静态方法中的本地类（如静态方法PhoneNumber中定义的类）validatePhoneNumber只能引用封闭类的静态成员。
    public static void validatePhoneNumber(String phoneNumber1, String phoneNumber2) {

        final int numberLength = 10;

        // Valid in JDK 8 and later:

        // int numberLength = 10;

        class PhoneNumber {

            String formattedPhoneNumber = null;

            PhoneNumber(String phoneNumber){
                // numberLength = 7;
                // 成功则返回替换的字符串，失败则返回原始字符串。

                String currentNumber = phoneNumber.replaceAll(regularExpression, "");

                //此外，本地类可以访问局部变量。但是，本地类只能访问声明为final的局部变量
                if (currentNumber.length() == numberLength)
                    formattedPhoneNumber = currentNumber;
                else
                    formattedPhoneNumber = null;
            }

            public String getNumber() {
                return formattedPhoneNumber;
            }

            // Valid in JDK 8 and later:
            // 如果在方法中声明本地类，它可以访问方法的参数。
//            public void printOriginalNumbers() {
//                System.out.println("Original numbers are " + phoneNumber1 +
//                    " and " + phoneNumber2);
//            }
        }

        PhoneNumber myNumber1 = new PhoneNumber(phoneNumber1);
        PhoneNumber myNumber2 = new PhoneNumber(phoneNumber2);

        // Valid in JDK 8 and later:

//        myNumber1.printOriginalNumbers();

        if (myNumber1.getNumber() == null)
            System.out.println("First number is invalid");
        else
            System.out.println("First number is " + myNumber1.getNumber());
        if (myNumber2.getNumber() == null)
            System.out.println("Second number is invalid");
        else
            System.out.println("Second number is " + myNumber2.getNumber());

    }

    public void sayGoodbyeInEnglish() {

        class EnglishGoodbye {
            //本地类可以具有静态成员，前提是它们是常量变量。
            public static final String farewell = "Bye bye";
            public void sayGoodbye() {
                System.out.println(farewell);
            }
        }
        EnglishGoodbye myEnglishGoodbye = new EnglishGoodbye();
        myEnglishGoodbye.sayGoodbye();
    }

    public static void main(String... args) {
        validatePhoneNumber("123-456-7890", "456-7890");

    }
}
