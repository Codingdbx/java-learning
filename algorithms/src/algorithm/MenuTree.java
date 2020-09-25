package algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>Description: </p>
 *
 * @author dbx
 * @date 2020/9/25 17:01
 * @since JDK1.8
 */
public class MenuTree {

    private List<Menu> menuList;

    MenuTree(List<Menu> menuList) {
        this.menuList = menuList;
    }

    static class Menu {

        private String id;
        private String parentId; //上一级菜单id
        private String text;  //菜单名子
        private String url;  //链接地址
        private List<Menu> children; //子菜单

        String getParentId() {
            return parentId;
        }

        String getId() {
            return id;
        }

        void setChildren(List<Menu> children) {
            this.children = children;
        }

        Menu(String id, String parentId, String text, String url) {
            this.id = id;
            this.parentId = parentId;
            this.text = text;
            this.url = url;
        }
    }

    //获取树型结构
    List<Menu> buildTree() {
        List<Menu> treeMenus = new ArrayList<>();
        for (Menu menuNode : getRootNode()) {
            menuNode = buildChildTree(menuNode);
            treeMenus.add(menuNode);
        }
        return treeMenus;
    }

    //获取根节点
    List<Menu> getRootNode() {
        List<Menu> rootMenuLists = new ArrayList<Menu>();
        for (Menu menuNode : menuList) {
            if (menuNode.getParentId().equals("0")) {
                rootMenuLists.add(menuNode);
            }
        }
        return rootMenuLists;
    }


    //递归，建立子树形结构
    private Menu buildChildTree(Menu pNode) {
        List<Menu> childMenus = new ArrayList<>();
        for (Menu menuNode : menuList) {
            if (menuNode.getParentId().equals(pNode.getId())) {
                childMenus.add(buildChildTree(menuNode));
            }
        }
        pNode.setChildren(childMenus);
        return pNode;
    }

    public static void main(String[] args) {
        List<Menu> menuList = new ArrayList<Menu>();
        /*插入一些数据*/
        menuList.add(new Menu("GN001D000", "0", "系统管理", "/admin"));
        menuList.add(new Menu("GN001D100", "GN001D000", "权限管理", "/admin"));
        menuList.add(new Menu("GN001D110", "GN001D100", "密码修改", "/admin"));
        menuList.add(new Menu("GN001D120", "GN001D100", "新加用户", "/admin"));
        menuList.add(new Menu("GN001D200", "GN001D000", "系统监控", "/admin"));
        menuList.add(new Menu("GN001D210", "GN001D200", "在线用户", "/admin"));
        menuList.add(new Menu("GN002D000", "0", "订阅区", "/admin"));
        menuList.add(new Menu("GN003D000", "0", "未知领域", "/admin"));
        /*让我们创建树*/
        MenuTree menuTree = new MenuTree(menuList);
        menuList = menuTree.buildTree();
    }

}
