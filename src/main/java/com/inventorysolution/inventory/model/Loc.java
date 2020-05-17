package com.inventorysolution.inventory.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Loc {

    @Id
    private int serialKey;
    private String loc;
    private String locationType;
    private String locationFlag;
    private String locationCategory;
    private String section;
    private String abc;
    private String putAwayZone;
    private String lastLocCountDate;

    public int getSerialKey() { return serialKey; }
    public void setSerialKey(int serialKey) { this.serialKey = serialKey; }

    public String getLoc() { return loc; }
    public void setLoc(String loc) { this.loc = loc; }

    public String getLocationType() { return locationType; }
    public void setLocationType(String locationType) { this.locationType = locationType; }

    public String getLocationFlag() { return locationFlag; }
    public void setLocationFlag(String locationFlag) { this.locationFlag = locationFlag; }

    public String getLocationCategory() { return locationCategory; }
    public void setLocationCategory(String locationCategory) { this.locationCategory = locationCategory; }

    public String getSection() { return section; }
    public void setSection(String section) { this.section = section; }

    public String getAbc() { return abc; }
    public void setAbc(String abc) { this.abc = abc; }

    public String getPutAwayZone() { return putAwayZone; }
    public void setPutAwayZone(String putAwayZone) { this.putAwayZone = putAwayZone; }

    public String getLastLocCountDate() { return lastLocCountDate; }
    public void setLastLocCountDate(String lastLocCountDate) { this.lastLocCountDate = lastLocCountDate; }
}
