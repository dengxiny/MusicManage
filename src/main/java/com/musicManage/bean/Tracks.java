package com.musicManage.bean;
import java.math.BigDecimal;
import java.util.List;
public class Tracks
{
    private String name;

    private BigDecimal id;

    private BigDecimal position;

    private List<String> alias;

    private BigDecimal status;

    private BigDecimal fee;

    private BigDecimal copyrightId;

    private String disc;

    private BigDecimal no;

    private List<Artists> artists;

    private Album album;

    private boolean starred;

    private BigDecimal popularity;

    private BigDecimal score;

    private BigDecimal starredNum;

    private BigDecimal duration;

    private BigDecimal playedNum;

    private BigDecimal dayPlays;

    private BigDecimal hearTime;

    private String ringtone;

    private String crbt;

    private String audition;

    private String copyFrom;

    private String commentThreadId;

    private String rtUrl;

    private BigDecimal ftype;

    private List<String> rtUrls;

    private BigDecimal copyright;

    private String transName;

    private String sign;

    private BigDecimal rtype;

    private String rurl;

    private BigDecimal mvid;

    private BMusic bMusic;

    private HMusic hMusic;

    private MMusic mMusic;

    private LMusic lMusic;

    private String mp3Url;

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
    public void setPosition(BigDecimal position){
        this.position = position;
    }
    public BigDecimal getPosition(){
        return this.position;
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
    public void setFee(BigDecimal fee){
        this.fee = fee;
    }
    public BigDecimal getFee(){
        return this.fee;
    }
    public void setCopyrightId(BigDecimal copyrightId){
        this.copyrightId = copyrightId;
    }
    public BigDecimal getCopyrightId(){
        return this.copyrightId;
    }
    public void setDisc(String disc){
        this.disc = disc;
    }
    public String getDisc(){
        return this.disc;
    }
    public void setNo(BigDecimal no){
        this.no = no;
    }
    public BigDecimal getNo(){
        return this.no;
    }
    public void setArtists(List<Artists> artists){
        this.artists = artists;
    }
    public List<Artists> getArtists(){
        return this.artists;
    }
    public void setAlbum(Album album){
        this.album = album;
    }
    public Album getAlbum(){
        return this.album;
    }
    public void setStarred(boolean starred){
        this.starred = starred;
    }
    public boolean getStarred(){
        return this.starred;
    }
    public void setPopularity(BigDecimal popularity){
        this.popularity = popularity;
    }
    public BigDecimal getPopularity(){
        return this.popularity;
    }
    public void setScore(BigDecimal score){
        this.score = score;
    }
    public BigDecimal getScore(){
        return this.score;
    }
    public void setStarredNum(BigDecimal starredNum){
        this.starredNum = starredNum;
    }
    public BigDecimal getStarredNum(){
        return this.starredNum;
    }
    public void setDuration(BigDecimal duration){
        this.duration = duration;
    }
    public BigDecimal getDuration(){
        return this.duration;
    }
    public void setPlayedNum(BigDecimal playedNum){
        this.playedNum = playedNum;
    }
    public BigDecimal getPlayedNum(){
        return this.playedNum;
    }
    public void setDayPlays(BigDecimal dayPlays){
        this.dayPlays = dayPlays;
    }
    public BigDecimal getDayPlays(){
        return this.dayPlays;
    }
    public void setHearTime(BigDecimal hearTime){
        this.hearTime = hearTime;
    }
    public BigDecimal getHearTime(){
        return this.hearTime;
    }
    public void setRingtone(String ringtone){
        this.ringtone = ringtone;
    }
    public String getRingtone(){
        return this.ringtone;
    }
    public void setCrbt(String crbt){
        this.crbt = crbt;
    }
    public String getCrbt(){
        return this.crbt;
    }
    public void setAudition(String audition){
        this.audition = audition;
    }
    public String getAudition(){
        return this.audition;
    }
    public void setCopyFrom(String copyFrom){
        this.copyFrom = copyFrom;
    }
    public String getCopyFrom(){
        return this.copyFrom;
    }
    public void setCommentThreadId(String commentThreadId){
        this.commentThreadId = commentThreadId;
    }
    public String getCommentThreadId(){
        return this.commentThreadId;
    }
    public void setRtUrl(String rtUrl){
        this.rtUrl = rtUrl;
    }
    public String getRtUrl(){
        return this.rtUrl;
    }
    public void setFtype(BigDecimal ftype){
        this.ftype = ftype;
    }
    public BigDecimal getFtype(){
        return this.ftype;
    }
    public void setRtUrls(List<String> rtUrls){
        this.rtUrls = rtUrls;
    }
    public List<String> getRtUrls(){
        return this.rtUrls;
    }
    public void setCopyright(BigDecimal copyright){
        this.copyright = copyright;
    }
    public BigDecimal getCopyright(){
        return this.copyright;
    }
    public void setTransName(String transName){
        this.transName = transName;
    }
    public String getTransName(){
        return this.transName;
    }
    public void setSign(String sign){
        this.sign = sign;
    }
    public String getSign(){
        return this.sign;
    }
    public void setRtype(BigDecimal rtype){
        this.rtype = rtype;
    }
    public BigDecimal getRtype(){
        return this.rtype;
    }
    public void setRurl(String rurl){
        this.rurl = rurl;
    }
    public String getRurl(){
        return this.rurl;
    }
    public void setMvid(BigDecimal mvid){
        this.mvid = mvid;
    }
    public BigDecimal getMvid(){
        return this.mvid;
    }
    public void setBMusic(BMusic bMusic){
        this.bMusic = bMusic;
    }
    public BMusic getBMusic(){
        return this.bMusic;
    }
    public void setHMusic(HMusic hMusic){
        this.hMusic = hMusic;
    }
    public HMusic getHMusic(){
        return this.hMusic;
    }
    public void setMMusic(MMusic mMusic){
        this.mMusic = mMusic;
    }
    public MMusic getMMusic(){
        return this.mMusic;
    }
    public void setLMusic(LMusic lMusic){
        this.lMusic = lMusic;
    }
    public LMusic getLMusic(){
        return this.lMusic;
    }
    public void setMp3Url(String mp3Url){
        this.mp3Url = mp3Url;
    }
    public String getMp3Url(){
        return this.mp3Url;
    }
}