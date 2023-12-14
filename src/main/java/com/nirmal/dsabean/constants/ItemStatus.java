package com.nirmal.dsabean.constants;

import com.nirmal.dsabean.dto.EnUserNameDto;

import java.util.ArrayList;
import java.util.List;

public enum ItemStatus {
    Solved("Solved"),
    TODO("Todo"),
    ReVisit("Re Visit"),
    Confident("Confident"),
    CanBeSkipped("Can Be Skipped"),
    NotClear("Not Clear");

    private String itemStatus;

    ItemStatus(String value) {
        this.itemStatus = value;
    }

    public String getItemStatus() {
        return itemStatus;
    }

    public static List<EnUserNameDto> getList() {
        List<EnUserNameDto> list = new ArrayList<>();
        for (ItemStatus status : ItemStatus.values()) {
            list.add(new EnUserNameDto(status.name(), status.getItemStatus()));
        }
        return list;
    }
}
