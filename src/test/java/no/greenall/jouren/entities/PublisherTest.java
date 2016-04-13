package no.greenall.jouren.entities;

import org.junit.Assert;
import org.junit.Test;

import static javafx.scene.input.KeyCode.M;

/**
 * Responsibility: Ensure publisher objects behave as expected.
 */
public class PublisherTest {

    @Test
    public void test_default_constructor() {
        Assert.assertNotNull(new Publisher());
    }

    @Test
    public void full_publisher_object_can_be_created() {
        String journalPublisherId = "123";
        String journalPublisher = "Anon publisher";

        Publisher publisher = new Publisher();
        publisher.setIdentifier(journalPublisherId);
        publisher.setName(journalPublisher);

        Assert.assertEquals(journalPublisherId, publisher.getIdentifier());
        Assert.assertEquals(journalPublisher, publisher.getName());
    }
}
