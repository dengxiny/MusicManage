package com.musicManage.bean;
import java.math.BigDecimal;
import java.util.List;
public class Album
{
    private String name;

    private BigDecimal id;

    private String type;

    private BigDecimal size;

    private BigDecimal picId;

    private String blurPicUrl;

    private BigDecimal companyId;

    private BigDecimal pic;

    private String picUrl;

    private BigDecimal publishTime;

    private String description;

    private String tags;

    private String company;

    private String briefDesc;

    private Artist artist;

    private List<String> songs;

    private List<String> alias;

    private BigDecimal status;

    private BigDecimal copyrightId;

    private String commentThreadId;

    private List<Artists> artists;

    private String subType;

    private String transName;

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
    public void setType(String type){
        this.type = type;
    }
    public String getType(){
        return this.type;
    }
    public void setSize(BigDecimal size){
        this.size = size;
    }
    public BigDecimal getSize(){
        return this.size;
    }
    public void setPicId(BigDecimal picId){
        this.picId = picId;
    }
    public BigDecimal getPicId(){
        return this.picId;
    }
    public void setBlurPicUrl(String blurPicUrl){
        this.blurPicUrl = blurPicUrl;
    }
    public String getBlurPicUrl(){
        return this.blurPicUrl;
    }
    public void setCompanyId(BigDecimal companyId){
        this.companyId = companyId;
    }
    public BigDecimal getCompanyId(){
        return this.companyId;
    }
    public void setPic(BigDecimal pic){
        this.pic = pic;
    }
    public BigDecimal getPic(){
        return this.pic;
    }
    public void setPicUrl(String picUrl){
        this.picUrl = picUrl;
    }
    public String getPicUrl(){
        return this.picUrl;
    }
    public void setPublishTime(BigDecimal publishTime){
        this.publishTime = publishTime;
    }
    public BigDecimal getPublishTime(){
        return this.publishTime;
    }
    public void setDescription(String description){
        this.description = description;
    }
    public String getDescription(){
        return this.description;
    }
    public void setTags(String tags){
        this.tags = tags;
    }
    public String getTags(){
        return this.tags;
    }
    public void setCompany(String company){
        this.company = company;
    }
    public String getCompany(){
        return this.company;
    }
    public void setBriefDesc(String briefDesc){
        this.briefDesc = briefDesc;
    }
    public String getBriefDesc(){
        return this.briefDesc;
    }
    public void setArtist(Artist artist){
        this.artist = artist;
    }
    public Artist getArtist(){
        return this.artist;
    }
    public void setSongs(List<String> songs){
        this.songs = songs;
    }
    public List<String> getSongs(){
        return this.songs;
    }
    public void setAlias(List<String> alias){
        this.alias = alias;
    }
    public List<String> getAlias(){
        return this.alias;
    }
    public void setStatus(BigDecimal status){
        this.status = status;
    }
    public BigDecimal getStatus(){
        return this.status;
    }
    public void setCopyrightId(BigDecimal copyrightId){
        this.copyrightId = copyrightId;
    }
    public BigDecimal getCopyrightId(){
        return this.copyrightId;
    }
    public void setCommentThreadId(String commentThreadId){
        this.commentThreadId = commentThreadId;
    }
    public String getCommentThreadId(){
        return this.commentThreadId;
    }
    public void setArtists(List<Artists> artists){
        this.artists = artists;
    }
    public List<Artists> getArtists(){
        return this.artists;
    }
    public void setSubType(String subType){
        this.subType = subType;
    }
    public String getSubType(){
        return this.subType;
    }
    public void setTransName(String transName){
        this.transName = transName;
    }
    public String getTransName(){
        return this.transName;
    }
}