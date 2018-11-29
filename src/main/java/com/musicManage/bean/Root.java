package com.musicManage.bean;

import java.math.BigDecimal;

public class Root
{
    private Result result;

    private BigDecimal code;

    public void setResult(Result result){
        this.result = result;
    }
    public Result getResult(){
        return this.result;
    }
    public void setCode(BigDecimal code){
        this.code = code;
    }
    public BigDecimal getCode(){
        return this.code;
    }
}