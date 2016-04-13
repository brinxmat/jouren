package no.greenall.jouren.cors;

import org.junit.Assert;
import org.junit.Test;

/**
 * Responsibility: Tests that the CORS filter does what we expect.
 */
public class CORSResponseFilterTest {


    @Test
    public void test_constructor_exists() {

        Assert.assertNotNull(new CORSResponseFilter());
    }
}
