package regex;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import java.io.CharArrayReader;

/**
 * <p>Description: 使用 ScriptEngineManager 解析逻辑表达式</p>
 *
 * @author dbx
 * @date 2020/6/5 13:34
 * @since JDK1.8
 */
public class TestExpression {

    static final String expression = "'y'!='y'?workflow_bill;5>0?workflow_formbase";

    public static void main(String[] args) {
        String selectid = "";
        if (expression.indexOf("?") > 0) {
            String[] s = expression.split(";");
            for (String expre : s) {
                //id<0?workflow_bill
                String[] ss = expre.split("\\?");
                try {
                    String exp = ss[0];//表达式
                    String left = parseExpressionLeftValue(exp);
                    String opertor = parseExpressionOperator(exp);
                    String right = parseExpressionRightValue(exp);

                    String val = ss[1];//值
                    ScriptEngineManager manager = new ScriptEngineManager();
                    ScriptEngine se = manager.getEngineByName("js");//将表达式替换成js使用的文本格式
                    Boolean result = null;

                    result = (Boolean) se.eval(exp);
                    if (result) {
                        selectid = val;
                        break;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        System.out.println("selectid:" + selectid);

    }

    private static String parseExpressionLeftValue(String exp) throws Exception {

        StringBuilder sb = new StringBuilder();

        CharArrayReader reader = new CharArrayReader(exp.toCharArray());
        int ch;
        char value;
        while ((ch = reader.read()) != -1) {
            value = (char) ch;
            if (value == '<'||value == '>'||value == '='||value == '!') {
                break;
            }
            sb.append(value);
        }
        return sb.toString();
    }

    private static String parseExpressionOperator(String exp) throws Exception {
        StringBuilder sb = new StringBuilder();
        CharArrayReader reader = new CharArrayReader(exp.toCharArray());
        int ch;
        char value;
        while ((ch = reader.read()) != -1) {
            value = (char) ch;
            if (value == '<'||value == '>'||value == '='||value == '!') {
                sb.append(value);
            }
        }
        return sb.toString();
    }


    private static String parseExpressionRightValue(String exp) throws Exception {

        StringBuilder sb = new StringBuilder();

        CharArrayReader reader = new CharArrayReader(exp.toCharArray());
        int ch;
        char value;

        boolean st = false;
        while ((ch = reader.read()) != -1) {
            value = (char) ch;
            if (value == '<'||value == '>'||value == '='||value == '!') {
                st = true;
                continue;
            }
            if (st) {
                sb.append(value);
            }
        }
        return sb.toString();
    }
}
