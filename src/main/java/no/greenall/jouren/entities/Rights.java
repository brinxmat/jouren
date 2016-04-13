package no.greenall.jouren.entities;

import org.joda.time.DateTime;

import java.util.Date;

import static com.sun.javafx.tools.resource.DeployResource.Type.data;

/**
 * Responsibility: Create rights objects.
 */
public class Rights {
    private String identifier;
    private DateTime begins;
    private DateTime ends;
    private int movingWall;

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public DateTime getBegins() {
        return begins;
    }

    public void setBegins(DateTime begins) {
        this.begins = begins;
    }

    public DateTime getEnds() {
        DateTime time = ends;

        if (this.movingWall > 0) {
            time = DateTime.now().minusMonths(this.movingWall);
        }

        return time;
    }

    public void setEnds(DateTime ends) {
        this.ends = ends;
    }

    public int getMovingWall() {
        return movingWall;
    }

    public void setMovingWall(int movingWall) {
        this.movingWall = movingWall;
    }

    public String getRightsString() {

        return this.getBegins().toString("YYYY-MM-dd") + "-" + this.getEnds().toString("YYYY-MM-dd");
    }
}
