package com.jingdong.app.mall.navigationbar;

/**
 * Created by Robin on 2016/5/19.
 */
//x
public class UnifyRequestDataHolder {
    private static UnifyRequestDataHolder instance = null;

    //a()
    public static UnifyRequestDataHolder getInstance() {
        if(instance == null){
            synchronized (UnifyRequestDataHolder.class){
                if(instance == null){
                    instance = new UnifyRequestDataHolder();
                }
            }
        }
        return instance;
    }

    public void b() {
        //TODO: 未实现
    }

}
