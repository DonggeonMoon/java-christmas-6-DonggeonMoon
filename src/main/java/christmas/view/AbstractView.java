package christmas.view;

import christmas.constant.Message;

public abstract class AbstractView {
    protected void println(final String string) {
        System.out.println(string);
    }

    protected void printMessage(final Message message) {
        println(message.getText());
    }
}
