package no.greenall.jouren.entities;

/**
 * Responsibility: Create journal package objects.
 */
public class JournalPackage {
    private String identifier;
    private String name;
    private String provider;

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

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }
}
