package com.inventorysolution.inventory.model;

import lombok.Data;

@Data
public class MobileCCVariables {
    private String section;
    private String facility;
    private String zone;
    private String client;

    private Tasks curCount;
}
