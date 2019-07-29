package com.netease.mini9demo.entity;

import org.litepal.crud.LitePalSupport;

import java.util.ArrayList;
import java.util.List;

public class Album extends LitePalSupport {

    private Integer id;
    private String name;
    private String plantTag;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPlantTag() {
        return plantTag;
    }

    public void setPlantTag(String plantTag) {
        this.plantTag = plantTag;
    }
}