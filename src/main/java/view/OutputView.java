package view;

import common.MainCategory;
import menu.Menu;
import order.Order;
import table.Table;

import java.util.List;

public class OutputView {
    private static final String TOP_LINE = "┌ ─ ┐";
    private static final String TABLE_FORMAT = "| %s |";
    private static final String BOTTOM_LINE = "└ ─ ┘";
    private static final String MAIN_TITLE = "## 메인화면";
    private static final String CONNECTION = " - ";
    private static final String CHOICE_OPTION = "## 원하는 기능을 선택하세요.";
    private static final String CHOICE_TABLE = "## 테이블을 선택하세요.";
    private static final String CHOICE_MENU = "## 등록할 메뉴를 선택하세요.";
    private static final String AMOUNT_MENU = "## 메뉴의 수량을 입력하세요.";
    private static final String ORDER_TITLE = "## 주문 내역";
    private static final String ORDER_CATEGORY = "메뉴 수량 금액";


    public static void printTables(final List<Table> tables) {
        System.out.println("## 테이블 목록");
        final int size = tables.size();
        printLine(TOP_LINE, size);
        printTableNumbers(tables);
        printLine(BOTTOM_LINE, size);
    }

    public static void printMenus(final List<Menu> menus) {
        for (final Menu menu : menus) {
            System.out.println(menu);
        }
        System.out.println();
    }

    private static void printLine(final String line, final int count) {
        for (int index = 0; index < count; index++) {
            System.out.print(line);
        }
        System.out.println();
    }

    private static void printTableNumbers(final List<Table> tables) {
        for (final Table table : tables) {
            System.out.printf(TABLE_FORMAT, table);
        }
        System.out.println();
    }

    public static void printMainView() {
        System.out.println(MAIN_TITLE);
        for (MainCategory category : MainCategory.values()) {
            System.out.println(category.getCategory() + CONNECTION + category.getDescription());
        }
        System.out.println();
    }

    public static void choiceOption() {
        System.out.println(CHOICE_OPTION);
    }

    public static void selectTable() {
        System.out.println(CHOICE_TABLE);
    }

    public static void selectMenu() {
        System.out.println(CHOICE_MENU);
    }

    public static void amountMenu() {
        System.out.println(AMOUNT_MENU);
    }

    public static void showOrder(List<Order> orders) {
        System.out.println(ORDER_TITLE);
        System.out.println(ORDER_CATEGORY);
        for (Order order : orders) {
            Menu menu = order.getMenu();
            int totalPrice = order.getAmount() * menu.getPrice();
            System.out.println(menu.getName() + " " + order.getAmount() + " " + totalPrice);
        }
        System.out.println();
    }
}
