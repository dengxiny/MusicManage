package com.musicManage.bean;
import java.math.BigDecimal;
import java.util.List;
public class Result
{
    private List<String> subscribers;

    private boolean subscribed;

    private Creator creator;

    private String artists;

    private List<Tracks> tracks;

    private boolean ordered;

    private List<String> tags;

    private boolean highQuality;

    private BigDecimal createTime;

    private BigDecimal subscribedCount;

    private BigDecimal cloudTrackCount;

    private boolean newImported;

    private BigDecimal trackNumberUpdateTime;

    private BigDecimal trackUpdateTime;

    private BigDecimal trackCount;

    private BigDecimal coverImgId;

    private BigDecimal privacy;

    private boolean anonimous;

    private BigDecimal updateTime;

    private String commentThreadId;

    private BigDecimal totalDuration;

    private BigDecimal playCount;

    private String coverImgUrl;

    private BigDecimal specialType;

    private BigDecimal userId;

    private BigDecimal adType;

    private String description;

    private BigDecimal status;

    private String name;

    private BigDecimal id;

    private BigDecimal shareCount;

    private BigDecimal commentCount;

    public void setSubscribers(List<String> subscribers){
        this.subscribers = subscribers;
    }
    public List<String> getSubscribers(){
        return this.subscribers;
    }
    public void setSubscribed(boolean subscribed){
        this.subscribed = subscribed;
    }
    public boolean getSubscribed(){
        return this.subscribed;
    }
    public void setCreator(Creator creator){
        this.creator = creator;
    }
    public Creator getCreator(){
        return this.creator;
    }
    public void setArtists(String artists){
        this.artists = artists;
    }
    public String getArtists(){
        return this.artists;
    }
    public void setTracks(List<Tracks> tracks){
        this.tracks = tracks;
    }
    public List<Tracks> getTracks(){
        return this.tracks;
    }
    public void setOrdered(boolean ordered){
        this.ordered = ordered;
    }
    public boolean getOrdered(){
        return this.ordered;
    }
    public void setTags(List<String> tags){
        this.tags = tags;
    }
    public List<String> getTags(){
        return this.tags;
    }
    public void setHighQuality(boolean highQuality){
        this.highQuality = highQuality;
    }
    public boolean getHighQuality(){
        return this.highQuality;
    }
    public void setCreateTime(BigDecimal createTime){
        this.createTime = createTime;
    }
    public BigDecimal getCreateTime(){
        return this.createTime;
    }
    public void setSubscribedCount(BigDecimal subscribedCount){
        this.subscribedCount = subscribedCount;
    }
    public BigDecimal getSubscribedCount(){
        return this.subscribedCount;
    }
    public void setCloudTrackCount(BigDecimal cloudTrackCount){
        this.cloudTrackCount = cloudTrackCount;
    }
    public BigDecimal getCloudTrackCount(){
        return this.cloudTrackCount;
    }
    public void setNewImported(boolean newImported){
        this.newImported = newImported;
    }
    public boolean getNewImported(){
        return this.newImported;
    }
    public void setTrackNumberUpdateTime(BigDecimal trackNumberUpdateTime){
        this.trackNumberUpdateTime = trackNumberUpdateTime;
    }
    public BigDecimal getTrackNumberUpdateTime(){
        return this.trackNumberUpdateTime;
    }
    public void setTrackUpdateTime(BigDecimal trackUpdateTime){
        this.trackUpdateTime = trackUpdateTime;
    }
    public BigDecimal getTrackUpdateTime(){
        return this.trackUpdateTime;
    }
    public void setTrackCount(BigDecimal trackCount){
        this.trackCount = trackCount;
    }
    public BigDecimal getTrackCount(){
        return this.trackCount;
    }
    public void setCoverImgId(BigDecimal coverImgId){
        this.coverImgId = coverImgId;
    }
    public BigDecimal getCoverImgId(){
        return this.coverImgId;
    }
    public void setPrivacy(BigDecimal privacy){
        this.privacy = privacy;
    }
    public BigDecimal getPrivacy(){
        return this.privacy;
    }
    public void setAnonimous(boolean anonimous){
        this.anonimous = anonimous;
    }
    public boolean getAnonimous(){
        return this.anonimous;
    }
    public void setUpdateTime(BigDecimal updateTime){
        this.updateTime = updateTime;
    }
    public BigDecimal getUpdateTime(){
        return this.updateTime;
    }
    public void setCommentThreadId(String commentThreadId){
        this.commentThreadId = commentThreadId;
    }
    public String getCommentThreadId(){
        return this.commentThreadId;
    }
    public void setTotalDuration(BigDecimal totalDuration){
        this.totalDuration = totalDuration;
    }
    public BigDecimal getTotalDuration(){
        return this.totalDuration;
    }
    public void setPlayCount(BigDecimal playCount){
        this.playCount = playCount;
    }
    public BigDecimal getPlayCount(){
        return this.playCount;
    }
    public void setCoverImgUrl(String coverImgUrl){
        this.coverImgUrl = coverImgUrl;
    }
    public String getCoverImgUrl(){
        return this.coverImgUrl;
    }
    public void setSpecialType(BigDecimal specialType){
        this.specialType = specialType;
    }
    public BigDecimal getSpecialType(){
        return this.specialType;
    }
    public void setUserId(BigDecimal userId){
        this.userId = userId;
    }
    public BigDecimal getUserId(){
        return this.userId;
    }
    public void setAdType(BigDecimal adType){
        this.adType = adType;
    }
    public BigDecimal getAdType(){
        return this.adType;
    }
    public void setDescription(String description){
        this.description = description;
    }
    public String getDescription(){
        return this.description;
    }
    public void setStatus(BigDecimal status){
        this.status = status;
    }
    public BigDecimal getStatus(){
        return this.status;
    }
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
    public void setShareCount(BigDecimal shareCount){
        this.shareCount = shareCount;
    }
    public BigDecimal getShareCount(){
        return this.shareCount;
    }
    public void setCommentCount(BigDecimal commentCount){
        this.commentCount = commentCount;
    }
    public BigDecimal getCommentCount(){
        return this.commentCount;
    }
}