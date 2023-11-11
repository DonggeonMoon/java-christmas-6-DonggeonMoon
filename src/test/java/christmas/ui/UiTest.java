package christmas.ui;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

public abstract class UiTest {
    private PrintStream systemOut;
    private OutputStream captor;

    @BeforeEach
    protected void init() {
        systemOut = System.out;
        captor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(captor));
    }

    protected final String getOutput() {
        return captor.toString().trim();
    }

    protected void input(final String... arguments) {
        final byte[] bytes = String.join("\n").getBytes();
        System.setIn(new ByteArrayInputStream(bytes));
    }

    @AfterEach
    protected void destroy() {
        System.setOut(systemOut);
        System.out.println(captor);
    }

}
