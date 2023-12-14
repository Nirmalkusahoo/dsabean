package com.nirmal.dsabean.dto;

public class EnUserNameDto {
    String technicalName;
    String endUserName;

    public String getTechnicalName() {
        return technicalName;
    }

    public void setTechnicalName(String technicalName) {
        this.technicalName = technicalName;
    }

    public String getEndUserName() {
        return endUserName;
    }

    public void setEndUserName(String endUserName) {
        this.endUserName = endUserName;
    }

    public EnUserNameDto(String technicalName, String endUserName) {
        this.technicalName = technicalName;
        this.endUserName = endUserName;
    }
}
