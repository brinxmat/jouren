package no.greenall.jouren.entities;

/**
 * Responsibility: create a journal object.
 */

public class Journal {
    private String identifier;
    private String name;
    private Publisher publisher;
    private JournalPackage journalPackage;
    private Rights rights;

    public Journal() {}

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    public JournalPackage getJournalPackage() {
        return journalPackage;
    }

    public void setJournal_package(JournalPackage journalPackage) {
        this.journalPackage = journalPackage;
    }

    public Rights getRights() {
        return rights;
    }

    public void setRights(Rights rights) {
        this.rights = rights;
    }

    public String getRightsString() {
        return rights.getRightsString();
    }
}
