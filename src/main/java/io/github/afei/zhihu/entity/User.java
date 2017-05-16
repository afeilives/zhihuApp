package io.github.afei.zhihu.entity;

import cn.bmob.v3.BmobUser;

/**
 * Created by afei on 2016/10/4.
 */
public class User extends BmobUser{
    private String avatar;



    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
}
