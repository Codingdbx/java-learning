package Lambda;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * lambda表达式
 *
 * created by dbx on 2019/3/4
 */
public class Person {

    public enum Sex {
        MALE, FEMALE
    }

    String name;
    LocalDate birthday;
    Sex gender;
    String emailAddress;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public Sex getGender() {
        return gender;
    }

    public void setGender(Sex gender) {
        this.gender = gender;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public int getAge() {
        // ...
        return 0;
    }

    public void printPerson() {
        // ...
    }


    public  static List<Person> createRoster(){
        List<Person> personList = new ArrayList<>();
        return personList;
    }

  /*  public Calendar getBirthday() {
        return birthday;
    }*/

    public static int compareByAge(Person a, Person b) {
        return a.birthday.compareTo(b.birthday);
    }



}
