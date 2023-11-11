package christmas.view;

import christmas.constant.Message;

public abstract class AbstractView {
    protected void println(String string) {
        System.out.println(string);
    }

    protected void printf(String string, Object... args) {
        System.out.printf(string, args);
    }

    protected void printMessage(Message message) {
        println(message.getText());
    }
}
