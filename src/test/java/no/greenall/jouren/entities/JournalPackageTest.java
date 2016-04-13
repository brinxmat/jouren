package no.greenall.jouren.entities;

import org.junit.Assert;
import org.junit.Test;

/**
 * Responsibility: tests that journal package objects behave as expected.
 */
public class JournalPackageTest {

    @Test
    public void test_default_constructor() {
        Assert.assertNotNull(new JournalPackage());
    }

    @Test
    public void full_journal_package_object_can_be_created() {

        String journalPackageId = "321";
        String journalPackageName = "Anon journal package";
        String journalPackageProvider = "Anon provider";

        JournalPackage journalPackage = new JournalPackage();
        journalPackage.setIdentifier(journalPackageId);
        journalPackage.setName(journalPackageName);
        journalPackage.setProvider(journalPackageProvider);

        Assert.assertEquals(journalPackageId, journalPackage.getIdentifier());
        Assert.assertEquals(journalPackageName, journalPackage.getName());
        Assert.assertEquals(journalPackageProvider, journalPackage.getProvider());
    }
}
