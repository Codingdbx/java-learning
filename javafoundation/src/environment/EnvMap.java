package environment;

import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

/**
 * java 环境变量
 * created by dbx on 2019/4/8
 */
public class EnvMap {

//    "file.separator"	用于分隔文件路径组件的字符。这/在UNIX上是“ ”，\在Windows 上是“ ” 。
//    "java.class.path"	用于查找包含类文件的目录和JAR存档的路径。类路径的元素由path.separator属性中指定的特定于平台的字符分隔。
//    "java.home"	Java Runtime Environment（JRE）的安装目录
//    "java.vendor"	JRE供应商名称
//    "java.vendor.url"	JRE供应商URL
//    "java.version"	JRE版本号
//    "line.separator"	操作系统用于分隔文本文件中的行的序列
//    "os.arch"	操作系统架构
//    "os.name"	操作系统名称
//    "os.version"	操作系统版本
//    "path.separator"	用于的路径分隔符 java.class.path
//    "user.dir"	用户工作目录
//    "user.home"	用户主目录
//    "user.name"	用户帐户名称

    public static void main (String[] args) {

        Map<String, String> env = System.getenv();
        for (String envName : env.keySet()) {
            System.out.format("%s=%s%n", envName, env.get(envName));
        }

        System.out.println("-----------------------------------------------------------------");


        Properties properties = System.getProperties();

        Iterator<Map.Entry<Object, Object>> iterator = properties.entrySet().iterator();

        while (iterator.hasNext()){
            Map.Entry<Object, Object> next = iterator.next();
            System.out.println("key="+next.getKey()+"--------value="+next.getValue());
        }

        properties.forEach((key,value)->{
            System.out.println("key=" + key + " value=" + value);
        });
    }
}

