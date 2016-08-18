package com.jingdong.app.mall.faxian.b.d;

import com.jingdong.common.entity.ChannelTabInfo;
import com.zy.cleanmvp.presenter.IBaseUI;

import java.util.List;

/**
 * Created by Robin on 2016/5/19.
 */
//d
public interface IFaxianUI extends IBaseUI {
    public abstract void a(List<ChannelTabInfo> paramList, boolean paramBoolean);

    public abstract void b();
}
