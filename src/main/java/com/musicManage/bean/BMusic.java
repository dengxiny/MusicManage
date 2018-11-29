package com.musicManage.bean;

import java.math.BigDecimal;

public class BMusic
{
    private String name;

    private BigDecimal id;

    private BigDecimal size;

    private String extension;

    private BigDecimal sr;

    private BigDecimal dfsId;

    private BigDecimal bitrate;

    private BigDecimal playTime;

    private double volumeDelta;

    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return this.name;
    }
    public void setId(BigDecimal id){
        this.id = id;
    }
    public BigDecimal getId(){
        return this.id;
    }
    public void setSize(BigDecimal size){
        this.size = size;
    }
    public BigDecimal getSize(){
        return this.size;
    }
    public void setExtension(String extension){
        this.extension = extension;
    }
    public String getExtension(){
        return this.extension;
    }
    public void setSr(BigDecimal sr){
        this.sr = sr;
    }
    public BigDecimal getSr(){
        return this.sr;
    }
    public void setDfsId(BigDecimal dfsId){
        this.dfsId = dfsId;
    }
    public BigDecimal getDfsId(){
        return this.dfsId;
    }
    public void setBitrate(BigDecimal bitrate){
        this.bitrate = bitrate;
    }
    public BigDecimal getBitrate(){
        return this.bitrate;
    }
    public void setPlayTime(BigDecimal playTime){
        this.playTime = playTime;
    }
    public BigDecimal getPlayTime(){
        return this.playTime;
    }
    public void setVolumeDelta(double volumeDelta){
        this.volumeDelta = volumeDelta;
    }
    public double getVolumeDelta(){
        return this.volumeDelta;
    }
}