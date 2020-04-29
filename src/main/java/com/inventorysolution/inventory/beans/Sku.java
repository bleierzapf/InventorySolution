package com.inventorysolution.inventory.beans;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Sku {

    @Id
    private int serialKey;
    private int storerKey;
    private String sku;
    private String descr;
    private String packKey;
    private String putAwayZone;
    private String putAwayLoc;
    private String abc;
    private String lastCycleCount;
    private String lastCCReleaseDate;
    private String editDate;
    private String editWho;

    public int getSerialKey() { return serialKey; }
    public void setSerialKey(int serialKey) { this.serialKey = serialKey; }

    public int getStorerKey() { return storerKey; }
    public void setStorerKey(int storerKey) { this.storerKey = storerKey; }

    public String getSku() { return sku; }
    public void setSku(String sku) { this.sku = sku; }

    public String getDescr() { return descr; }
    public void setDescr(String descr) { this.descr = descr; }

    public String getPackKey() { return packKey; }
    public void setPackKey(String packKey) { this.packKey = packKey; }

    public String getPutAwayZone() { return putAwayZone; }
    public void setPutAwayZone(String putAwayZone) { this.putAwayZone = putAwayZone; }

    public String getPutAwayLoc() { return putAwayLoc; }
    public void setPutAwayLoc(String putAwayLoc) { this.putAwayLoc = putAwayLoc; }

    public String getAbc() { return abc; }
    public void setAbc(String abc) { this.abc = abc; }

    public String getLastCycleCount() { return lastCycleCount; }
    public void setLastCycleCount(String lastCycleCount) { this.lastCycleCount = lastCycleCount; }

    public String getLastCCReleaseDate() { return lastCCReleaseDate; }
    public void setLastCCReleaseDate(String lastCCReleaseDate) { this.lastCCReleaseDate = lastCCReleaseDate; }

    public String getEditDate() { return editDate; }
    public void setEditDate(String editDate) { this.editDate = editDate; }

    public String getEditWho() { return editWho; }
    public void setEditWho(String editWho) { this.editWho = editWho; }
}
