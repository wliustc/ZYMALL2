package com.zy.common.entity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;

import com.zy.common.utils.Log;

import java.io.ByteArrayOutputStream;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Robin on 2016/6/19.
 */
public class ShareInfo implements Parcelable, Cloneable{
    public static final Parcelable.Creator<ShareInfo> CREATOR = new Parcelable.Creator<ShareInfo>(){//ShareInfo.1();
        @Override
        public ShareInfo createFromParcel(Parcel source) {
            return new ShareInfo(source);
        }

        @Override
        public ShareInfo[] newArray(int size) {
            return new ShareInfo[size];
        }
    };
    private String cancelEventId = "";
    private String channels = "";
    private String[] defaultChannels = { "Wxfriends", "Wxmoments", "Sinaweibo", "QQfriends", "QQzone", "CopyURL", "Moreshare" };
    private String eventFrom = "";
    private String eventName = "";
    private String iconUrl = "";
    private String normalText = "";
    private byte[] shareLogo = new byte[0];
    private String summary = "";
    private String title = "";
    private String transaction = "";
    private String url = "";
    private String wxMomentsContent = "";
    private String wxcontent = "";

    public ShareInfo()
    {
    }

    private ShareInfo(Parcel paramParcel)
    {
        this.title = paramParcel.readString();
        this.url = paramParcel.readString();
        this.summary = paramParcel.readString();
        this.wxcontent = paramParcel.readString();
        this.wxMomentsContent = paramParcel.readString();
        this.normalText = paramParcel.readString();
        this.iconUrl = paramParcel.readString();
        this.eventFrom = paramParcel.readString();
        this.cancelEventId = paramParcel.readString();
        this.eventName = paramParcel.readString();
        this.transaction = paramParcel.readString();
        this.channels = paramParcel.readString();
        paramParcel.readStringArray(this.defaultChannels);
        paramParcel.readByteArray(this.shareLogo);
    }

    public ShareInfo(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
    {
        this.url = paramString1;
        this.title = paramString2;
        this.summary = paramString3;
        this.iconUrl = paramString4;
        this.eventName = paramString5;
    }

    public ShareInfo(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, Bitmap paramBitmap)
    {
        this.title = paramString1;
        this.summary = paramString2;
        this.wxcontent = paramString2;
        this.wxMomentsContent = paramString3;
        this.url = paramString4;
        this.normalText = paramString5;
        this.eventFrom = paramString6;
        this.iconUrl = paramString7;
        setShareLogo(paramBitmap);
    }

    public ShareInfo(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, Bitmap paramBitmap, String paramString8)
    {
        this.title = paramString1;
        this.summary = paramString2;
        this.wxcontent = paramString2;
        this.wxMomentsContent = paramString3;
        this.url = paramString4;
        this.normalText = paramString5;
        this.eventFrom = paramString6;
        this.iconUrl = paramString7;
        setShareLogo(paramBitmap);
        this.eventName = paramString8;
    }

    public ShareInfo clone()
    {
        ShareInfo localShareInfo1 = new ShareInfo();
        try
        {
            ShareInfo localShareInfo2 = (ShareInfo)super.clone();
            return localShareInfo2;
        }
        catch (CloneNotSupportedException e)
        {
            if (Log.E)
                e.printStackTrace();
        }
        return localShareInfo1;
    }

    public int describeContents()
    {
        return 0;
    }

    public String getCancelEventId()
    {
        return this.cancelEventId;
    }

    public String getChannels()
    {
        return this.channels;
    }

    public List<String> getChannelsList()
    {
        if (!TextUtils.isEmpty(this.channels))
            return Arrays.asList(this.channels.split(","));
        return Arrays.asList(this.defaultChannels);
    }

    public String getEventFrom()
    {
        return this.eventFrom;
    }

    public String getEventName()
    {
        return this.eventName;
    }

    public String getIconUrl()
    {
        return this.iconUrl;
    }

    public String getNormalText()
    {
        return this.normalText;
    }

    public Bitmap getShareLogo()
    {
        Bitmap localBitmap = null;
        if (this.shareLogo != null)
            localBitmap = BitmapFactory.decodeByteArray(this.shareLogo, 0, this.shareLogo.length);
        return localBitmap;
    }

    public byte[] getShareLogoBytes()
    {
        return (byte[])this.shareLogo.clone();
    }

    public String getSummary()
    {
        return this.summary;
    }

    public String getTitle()
    {
        return this.title;
    }

    public String getTransaction()
    {
        return this.transaction;
    }

    public String getUrl()
    {
        return this.url;
    }

    public String getWxMomentsContent()
    {
        return this.wxMomentsContent;
    }

    public String getWxcontent()
    {
        return this.wxcontent;
    }

    public void setCancelEventId(String paramString)
    {
        this.cancelEventId = paramString;
    }

    public void setChannels(String paramString)
    {
        this.channels = paramString;
    }

    public void setEventFrom(String paramString)
    {
        this.eventFrom = paramString;
    }

    public void setEventName(String paramString)
    {
        this.eventName = paramString;
    }

    public void setIconUrl(String paramString)
    {
        this.iconUrl = paramString;
    }

    public void setNormalText(String paramString)
    {
        this.normalText = paramString;
    }

    public void setShareLogo(Bitmap paramBitmap)
    {
        if (paramBitmap != null)
        {
            ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
            paramBitmap.compress(Bitmap.CompressFormat.PNG, 100, localByteArrayOutputStream);
            this.shareLogo = localByteArrayOutputStream.toByteArray();
        }
    }

    public void setShareLogo(byte[] paramArrayOfByte)
    {
        this.shareLogo = ((byte[])paramArrayOfByte.clone());
    }

    public void setShareLogoDefault(Bitmap paramBitmap, int paramInt)
    {
        int i = 100;
        if (paramBitmap != null)
        {
            ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
            paramBitmap.compress(Bitmap.CompressFormat.PNG, 100, localByteArrayOutputStream);
            this.shareLogo = localByteArrayOutputStream.toByteArray();
            while ((this.shareLogo.length > paramInt) && (i > 0))
            {
                localByteArrayOutputStream.reset();
                paramBitmap.compress(Bitmap.CompressFormat.JPEG, i, localByteArrayOutputStream);
                this.shareLogo = localByteArrayOutputStream.toByteArray();
                i -= 5;
            }
        }
    }

    public void setSummary(String paramString)
    {
        this.summary = paramString;
    }

    public void setTitle(String paramString)
    {
        this.title = paramString;
    }

    public void setTransaction(String paramString)
    {
        this.transaction = paramString;
    }

    public void setUrl(String paramString)
    {
        this.url = paramString;
    }

    public void setWxMomentsContent(String paramString)
    {
        this.wxMomentsContent = paramString;
    }

    public void setWxcontent(String paramString)
    {
        this.wxcontent = paramString;
    }

    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
        paramParcel.writeString(this.title);
        paramParcel.writeString(this.url);
        paramParcel.writeString(this.summary);
        paramParcel.writeString(this.wxcontent);
        paramParcel.writeString(this.wxMomentsContent);
        paramParcel.writeString(this.normalText);
        paramParcel.writeString(this.iconUrl);
        paramParcel.writeString(this.eventFrom);
        paramParcel.writeString(this.cancelEventId);
        paramParcel.writeString(this.eventName);
        paramParcel.writeString(this.transaction);
        paramParcel.writeString(this.channels);
        paramParcel.writeStringArray(this.defaultChannels);
        paramParcel.writeByteArray(this.shareLogo);
    }
}
