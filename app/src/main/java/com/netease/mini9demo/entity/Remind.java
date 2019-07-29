package com.netease.mini9demo.entity;

import org.litepal.crud.LitePalSupport;

public class Remind extends LitePalSupport {

    private Integer id;
    private String plantName;
    private Integer imageId;
    private String remindType;
    private Long remindTime;
    private Integer remindStep;
    private String extraInfo;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPlantName() {
        return plantName;
    }

    public void setPlantName(String plantName) {
        this.plantName = plantName;
    }

    public Integer getImageId() {
        return imageId;
    }

    public void setImageId(Integer imageId) {
        this.imageId = imageId;
    }

    public String getRemindType() {
        return remindType;
    }

    public void setRemindType(String remindType) {
        this.remindType = remindType;
    }

    public Long getRemindTime() {
        return remindTime;
    }

    public void setRemindTime(Long remindTime) {
        this.remindTime = remindTime;
    }

    public Integer getRemindStep() {
        return remindStep;
    }

    public void setRemindStep(Integer remindStep) {
        this.remindStep = remindStep;
    }

    public String getExtraInfo() {
        return extraInfo;
    }

    public void setExtraInfo(String extraInfo) {
        this.extraInfo = extraInfo;
    }

}
