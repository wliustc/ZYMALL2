package com.zy.app.mall.home.floor.model.entity;

import android.text.TextUtils;

import com.jingdong.common.utils.JSONObjectProxy;
import com.zy.common.utils.Log;

import java.text.DecimalFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Robin on 2016/6/19.
 */
public class HomeProductEntity {
    private String id;
    private String imgUrl;
    private String jdPrice;
    private String lookSimilar;
    private String name;
    private String sourceValue;
    private String targetUrl;

    public HomeProductEntity(JSONObjectProxy paramJSONObjectProxy) {
        this.id = paramJSONObjectProxy.optString("wareId");
        setName(paramJSONObjectProxy.optString("wname"));
        this.jdPrice = paramJSONObjectProxy.optString("jdPrice");
        this.imgUrl = paramJSONObjectProxy.optString("imageurl");
        this.sourceValue = paramJSONObjectProxy.optString("sourceValue", "");
        this.lookSimilar = paramJSONObjectProxy.optString("lookSimilar");
        this.targetUrl = paramJSONObjectProxy.optString("clickUrl");
    }

    public HomeProductEntity(String paramString1, String paramString2) {
        this.id = paramString1;
        this.imgUrl = paramString2;
    }

    public String getId() {
        return this.id;
    }

    public String getImageUrl() {
        return this.imgUrl;
    }

    public String getJdPriceWithOutZero() {
        try {
            if (this.jdPrice != null) {
                Double localObject = Double.valueOf(this.jdPrice);
                if (localObject != null && ((Double) localObject).doubleValue() > 0.0D)
                    return new DecimalFormat("#.##").format(localObject);
            }
        } catch (Exception E) {
        }
        return "暂无报价";
    }

    public String getName() {
        if (this.name != null)
            return this.name;
        return "暂无名称";
    }

    public String getSourceValue() {
        return this.sourceValue;
    }

    public String getTargetUrl() {
        return this.targetUrl;
    }

    public boolean isLookSimilar() {
        return (!TextUtils.isEmpty(this.lookSimilar)) && ("1".equals(this.lookSimilar));
    }

    public void setJdPrice(String paramString) {
        this.jdPrice = paramString;
    }

    public void setName(String paramString) {
        if (paramString == null) {
            this.name = paramString;
            return;
        }
        StringBuffer localStringBuffer1;
        Matcher localMatcher = null;
        try {
            localMatcher = Pattern.compile("([^a-zA-Z0-9（）\\(\\) ])([a-zA-Z（\\(])|([^ ])([（\\(])|([（\\(])([^ ])|([A-Z0-9])(\\-)|(\\-)([A-Z0-9])|([0-9]*[A-Z]+[0-9]*)([^a-zA-Z0-9（）\\(\\) ])").matcher(paramString);
            localStringBuffer1 = new StringBuffer();
            while (localMatcher.find()) {//if-eqz v0, :cond_6
                StringBuffer localStringBuffer2 = new StringBuffer();
                //:goto_2
                for (int i = 1; i > localMatcher.groupCount(); i++) {//if-gt v0, v4, :cond_1
                    if (localMatcher.group(i) != null) {//if-eqz v4, :cond_5
                        localStringBuffer2.append(localMatcher.group(i)).append(" ").append(localMatcher.group(i + 1));
                        break;
                        //goto :cond_1
                    }//:cond_5
                }//:cond_1
                if (Log.D)
                    Log.d("Temp", "name -->> " + paramString);
                if (Log.D)
                    Log.d("Temp", "stringBuffer.toString() -->> " + localStringBuffer1.toString());
                if (Log.D)
                    Log.d("Temp", "sb.toString() -->> " + localStringBuffer2.toString());
                localMatcher.appendReplacement(localStringBuffer1, localStringBuffer2.toString());
            }//:cond_6
        } catch (Exception localException) {
            this.name = paramString;
            return;
        }
        localMatcher.appendTail(localStringBuffer1);
        localStringBuffer1.append(" ");
        this.name = localStringBuffer1.toString();
    }
}
