package no.greenall.jouren.entities;

import org.joda.time.DateTime;
import org.junit.Assert;
import org.junit.Test;

import java.util.Date;

/**
 * Responsibility: Test that the journal class behaves as expected.
 */
public class JournalTest {
    @Test
    public void has_default_constructor() {
        Assert.assertNotNull(new Journal());
    }

    @Test
    public void complete_journal_record_can_be_created() {
        String journalPublisherId = "121";
        String journalPublisher = "Anon Peachy publisher";
        String journalPackageId = "131";
        String journalPackageName = "Peachy journal package A";
        String journalPackageProvider = "Peachy journal aggregator";
        String rightsId = "141";
        DateTime rightsBegins = new DateTime(2001, 01, 01, 0, 0, 0);
        DateTime rightsEnds = new DateTime(2010, 12, 31, 0, 0, 0);
        int rightsMovingWall = 0;
        String journalId = "111";
        String journalName = "Journal of journals";

        Journal journal = new Journal();

        Publisher publisher = new Publisher();
        publisher.setIdentifier(journalPublisherId);
        publisher.setName(journalPublisher);

        JournalPackage journalPackage = new JournalPackage();
        journalPackage.setIdentifier(journalPackageId);
        journalPackage.setName(journalPackageName);
        journalPackage.setProvider(journalPackageProvider);

        Rights rights = new Rights();
        rights.setIdentifier(rightsId);
        rights.setBegins(rightsBegins);
        rights.setEnds(rightsEnds);
        rights.setMovingWall(rightsMovingWall);

        journal.setIdentifier(journalId);
        journal.setName(journalName);
        journal.setPublisher(publisher);
        journal.setJournal_package(journalPackage);
        journal.setRights(rights);

        Assert.assertEquals(journalId, journal.getIdentifier());
        Assert.assertEquals(journalName, journal.getName());
        Assert.assertEquals(journalPackage, journal.getJournalPackage());
        Assert.assertEquals(publisher, journal.getPublisher());
        Assert.assertEquals(rights, journal.getRights());
        Assert.assertEquals(rightsBegins.toDateTimeISO().toString("YYYY-MM-dd") + "-" + rightsEnds.toDateTimeISO().toString("YYYY-MM-dd"), journal.getRightsString());
    }
}
