package no.greenall.jouren;


import org.junit.Test;

import static org.junit.Assert.assertNotNull;


/**
 * Responsibility: Test App class
 */
public class AppTest {

    public static final int DEFAULT_PORT = 8005;

    @Test
    public void test_constructor() {
        assertNotNull(new App(DEFAULT_PORT));
    }
}
