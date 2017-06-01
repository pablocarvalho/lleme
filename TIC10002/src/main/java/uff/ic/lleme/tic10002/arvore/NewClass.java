package uff.ic.lleme.tic10002.arvore;

public class NewClass {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    public static void main(String[] args) {

        System.out.println("\033[31;1mHello\033[0m, \033[32;1;2mworld!\033[0m");
        System.out.println("\033[31mRed\033[32m, Green\033[33m, Yellow\033[34m, Blue\033[0m");
    }
}
