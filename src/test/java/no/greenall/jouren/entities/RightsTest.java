package no.greenall.jouren.entities;

import org.joda.time.DateTime;
import org.junit.Assert;
import org.junit.Test;

/**
 * Responsibility: Ensure rights objects behave as expected.
 */
public class RightsTest {

    @Test
    public void it_has_default_constructor() {
        Assert.assertNotNull(new Rights());
    }

    @Test
    public void full_record_can_be_added() {
        String rightsId = "141";
        DateTime rightsBegins = new DateTime(2001, 01, 01, 0, 0, 0);
        DateTime rightsEnds = new DateTime(2010, 12, 31, 0, 0, 0);
        int rightsMovingWall = 0;

        Rights rights = new Rights();
        rights.setIdentifier(rightsId);
        rights.setBegins(rightsBegins);
        rights.setEnds(rightsEnds);
        rights.setMovingWall(rightsMovingWall);

        Assert.assertEquals(rightsId, rights.getIdentifier());
        Assert.assertEquals(rightsBegins, rights.getBegins());
        Assert.assertEquals(rightsEnds, rights.getEnds());
        Assert.assertEquals(rightsMovingWall, rights.getMovingWall());
    }

    @Test
    public void moving_wall_overrides_set_end_date_and_creates_correct_end_date() {
        DateTime rightsBegins = new DateTime(2001, 01, 01, 0, 0, 0);
        DateTime rightsEnds = new DateTime(2010, 12, 31, 0, 0, 0);
        int rightsMovingWall = 6;

        Rights rights = new Rights();
        rights.setBegins(rightsBegins);
        rights.setEnds(rightsEnds);
        rights.setMovingWall(rightsMovingWall);

        Assert.assertEquals(DateTime.now().minusMonths(rightsMovingWall).toString("YYYYMMdd"), rights.getEnds().toString("YYYYMMdd"));
    }
}
