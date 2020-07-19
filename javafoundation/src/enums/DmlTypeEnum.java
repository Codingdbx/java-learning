package enums;

/**
 * <p>Description:  </p>
 *
 * @author dbix
 * @date 2019/10/12
 * @since JDK1.8
 */
public enum DmlTypeEnum {
    /**
     * dml操作类型
     */
    INSERT,UPDATE,DELETE,CUSTOM;

    private String type;

    DmlTypeEnum(){
        this.type = name().toLowerCase();
    }

    public String getType(){
        return this.type;
    }


    public static void main(String[] args) {
        String type = DmlTypeEnum.INSERT.getType();
        System.out.println(type);
    }
}
