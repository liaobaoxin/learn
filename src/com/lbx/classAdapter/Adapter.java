package com.lbx.classAdapter;

/**
 * Create by lbx on 2018/4/14  14:50
 **/
public class Adapter extends Usber implements Ps2 {

    @Override
    public void isPs2() {
        isUsb();
    }


}
