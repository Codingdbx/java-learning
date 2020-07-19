package date;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * created by dbx on 2019/1/25
 */
public class TestSimpleDateFormat {

    public static void  main(String[] args) {

        /**
         * SimpleDateFormat 是线程不安全的，JDK8之后的建议使用 DateTimeFormatter
         * 如果非要使用 SimpleDateFormat
         * 1.不要用static 修饰（不用static，性能会不好）
         * 2.如果定义为static 变量，则在方法里加 synchronized（并发量大的时候会对性能有影响，线程阻塞）
         * 3.使用ThreadLocal 类（ThreadLocal可以确保每个线程都可以得到单独的一个SimpleDateFormat的对象，那么自然也就不存在竞争问题了）
         */
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        Date time = gregorianCalendar.getTime();
        System.out.println("gregorianCalendar================ " + sdf.format(time));


        /**
         * Calendar
         */
        Calendar calendar = Calendar.getInstance();
        Date time1 = calendar.getTime();
        System.out.println("calendar================ " + sdf.format(time1));

        Calendar cal = Calendar.getInstance();
        int day = cal.get(Calendar.DATE);
        int month = cal.get(Calendar.MONTH) + 1;
        int year = cal.get(Calendar.YEAR);
        int dow = cal.get(Calendar.DAY_OF_WEEK);
        int dom = cal.get(Calendar.DAY_OF_MONTH);
        int doy = cal.get(Calendar.DAY_OF_YEAR);
 
        System.out.println("当期时间: " + cal.getTime());
        System.out.println("日期: " + day);
        System.out.println("月份: " + month);
        System.out.println("年份: " + year);
        System.out.println("一周的第几天: " + dow);  // 星期日为一周的第一天输出为 1，星期一输出为 2，以此类推
        System.out.println("一月中的第几天: " + dom);
        System.out.println("一年的第几天: " + doy);


        /**
         * 基于JDK1.8 的 DateTimeFormatter 线程安全
         */
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        LocalDateTime startTime = LocalDateTime.now();
        LocalDateTime endTime = startTime.plusDays(7);

        String start = formatter.format(startTime);
        String end = formatter.format(endTime);

        System.out.println("DateTimeFormatter start================ " + start);
        System.out.println("DateTimeFormatter end================ " + end);

    }
}
