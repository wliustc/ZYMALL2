package com.zy.common.entity;

import com.jingdong.common.utils.JSONObjectProxy;
import com.zy.common.utils.JSONArrayProxy;

import org.json.JSONArray;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by robin on 16-8-4.
 */
public class ProductFeeInfo implements Serializable {
    private ArrayList<ProductFeeInfo.FeeInfo> mFeeInfos;

    public ProductFeeInfo(JSONObjectProxy paramJSONObjectProxy)
    {
        if (paramJSONObjectProxy != null)
            try
            {
                JSONArrayProxy arrayProxy = paramJSONObjectProxy.getJSONArrayOrNull("treatyList");
                if ((arrayProxy != null) && (arrayProxy.length() > 0))
                {
                    this.mFeeInfos = new ArrayList(arrayProxy.length());

                    for (int i = 0; i < arrayProxy.length(); i++)
                    {
                        JSONObjectProxy localObject = arrayProxy.getJSONObjectOrNull(i);
                        if (localObject != null)
                        {
                            ProductFeeInfo.FeeInfo feeInfo = new ProductFeeInfo.FeeInfo(this, (JSONObjectProxy)localObject, i);
                            this.mFeeInfos.add(feeInfo);
                        }
                    }
                }
            }
            catch (java.lang.Exception e)
            {
            }
    }

    public ArrayList<FeeInfo> getFeeInfos()
    {
        return this.mFeeInfos;
    }

    public class FeeInfo
            implements Serializable
    {
        public static final String FEE_TYPE_HEYUE = "0";
        public static final String FEE_TYPE_NORMAL = "1";
        private static final long serialVersionUID = -3927567535238748537L;
        private String ft;
        private int index;
        private String name;
        public String oldType;
        public String skuId;
        private String type;

        public FeeInfo(ProductFeeInfo paramProductFeeInfo, JSONObjectProxy paramJSONObjectProxy, int paramInt)
        {
            this.index = paramInt;
            if (paramJSONObjectProxy != null)
            {
                this.skuId = paramJSONObjectProxy.getStringOrNull("sku");
                this.name = paramJSONObjectProxy.getStringOrNull("name");
                this.type = paramJSONObjectProxy.getStringOrNull("type");
                this.ft = paramJSONObjectProxy.getStringOrNull("ft");
                this.oldType = paramJSONObjectProxy.getStringOrNull("oldType");
            }
        }

        public String getFt()
        {
            return this.ft;
        }

        public int getIndex()
        {
            return this.index;
        }

        public String getName()
        {
            return this.name;
        }

        public String getSkuId()
        {
            return this.skuId;
        }

        public String getType()
        {
            return this.type;
        }
    }
}
