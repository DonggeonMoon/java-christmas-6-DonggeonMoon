package christmas.view;

import christmas.constant.string.Message;

public abstract class AbstractView {
    protected final void println(final String string) {
        System.out.println(string);
    }

    protected final void printMessage(final Message message) {
        println(message.getText());
    }
}
