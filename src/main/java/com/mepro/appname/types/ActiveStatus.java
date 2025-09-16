package com.mepro.appname.types;

import java.util.ArrayList;
import java.util.List;

public enum ActiveStatus {
    ACTIVE("A","A"),
    INACTIVE("I","I");
    
    private String label;
    private String code;

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
    
    private ActiveStatus (String label, String code) {
        this.label = label;
        this.code = code;
    }
    
    public static List<ActiveStatus> getListActiveStatus () {
        List<ActiveStatus> listActiveStatus  = new ArrayList<ActiveStatus>();
        listActiveStatus.add(ACTIVE);
        listActiveStatus.add(INACTIVE);
        return listActiveStatus;
    }
    
    public static ActiveStatus getActiveStatus(String code) {
        ActiveStatus activeStatus = null;
        List<ActiveStatus> listActiveStatus = getListActiveStatus();
        for (int i = 0; i < listActiveStatus.size(); i++) {
            ActiveStatus temp = listActiveStatus.get(i);
            if (temp.getCode() == code) {
                activeStatus = temp;
                break;
            }
        }
        return activeStatus;
    }
}
