package christmas.view;

import christmas.constant.Message;

public interface View {
    default void println(String string) {
        System.out.println(string);
    }

    default void printf(String string, Object... args) {
        System.out.printf(string, args);
    }

    default void printMessage(Message message) {
        println(message.getText());
    }
}
