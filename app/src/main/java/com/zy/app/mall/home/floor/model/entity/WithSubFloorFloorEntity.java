package com.zy.app.mall.home.floor.model.entity;

import com.zy.app.mall.home.floor.model.entity.FloorEntity;
import com.zy.common.entity.HomeFloorNewElements;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by Robin on 2016/7/6.
 */
public class WithSubFloorFloorEntity  extends FloorEntity {
    protected ArrayList<HomeFloorNewElements> mLsElements = null;
    protected int mSubFloorDividerHeight = 0;

    public WithSubFloorFloorEntity()
    {
        this.mTopDividerHeight = 1;
    }

    public Iterator<HomeFloorNewElements> getElementIterator()
    {
        if (!hasElement())
            return null;
        return this.mLsElements.iterator();
    }

    protected boolean hasElement()
    {
        return (this.mLsElements != null) && (this.mLsElements.size() != 0);
    }

    protected boolean hasSubFloorDivider()
    {
        return this.mSubFloorDividerHeight > 0;
    }

    public void setElements(ArrayList<HomeFloorNewElements> paramArrayList)
    {
        if (paramArrayList != null){
            if (this.mLsElements == null)
                this.mLsElements = new ArrayList();
            else
                this.mLsElements.clear();
            this.mLsElements.addAll(paramArrayList);
            return;
        }

    }
}
