package com.mepro.appname.types;

import java.util.ArrayList;
import java.util.List;

public enum BooleanStatus {
    FALSE(false, 0),
    TRUE(true, 1);

    private boolean label;
    private int code;

    public boolean getLabel() {
        return label;
    }

    public void setLabel(boolean label) {
        this.label = label;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    private BooleanStatus(boolean label, int code) {
        this.label = label;
        this.code = code;
    }

    public static List<BooleanStatus> getListBooleanStatus() {
        List<BooleanStatus> listBooleanStatus = new ArrayList<BooleanStatus>();
        listBooleanStatus.add(FALSE);
        listBooleanStatus.add(TRUE);
        return listBooleanStatus;
    }

    public static BooleanStatus getBooleanStatusByCode(int code) {
        BooleanStatus booleanStatus = null;
        List<BooleanStatus> listBooleanStatus = getListBooleanStatus();
        for (int i = 0; i < listBooleanStatus.size(); i++) {
            BooleanStatus temp = listBooleanStatus.get(i);
            if (temp.getCode() == code) {
                booleanStatus = temp;
                break;
            }
        }
        return booleanStatus;
    }
    
    
}
