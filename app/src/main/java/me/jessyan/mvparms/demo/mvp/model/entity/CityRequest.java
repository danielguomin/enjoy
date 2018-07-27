package me.jessyan.mvparms.demo.mvp.model.entity;

/**
 * Created by guomin on 2018/7/25.
 */

public class CityRequest extends BaseRequest {
    private int cmd = 901;


    public int getCmd() {
        return cmd;
    }

    public void setCmd(int cmd) {
        this.cmd = cmd;
    }

    @Override
    public String toString() {
        return "CityRequest{" +
                "cmd=" + cmd +
                '}';
    }
}
