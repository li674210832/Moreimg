package lining20170.bawe.com.testyueb;

import android.app.Application;

import org.greenrobot.eventbus.EventBus;

import java.util.List;

/**
 * Created by Lenovo on 2017/4/1.
 * author ：李宁
 * 类注释：
 */

public class EvevtbusMannerss {
    public List<Good.ResultBean.RowsBean> list;

    public EvevtbusMannerss(List<Good.ResultBean.RowsBean> list) {
        this.list = list;
    }

    public void setList(List<Good.ResultBean.RowsBean> list) {
        this.list = list;
    }

    public List<Good.ResultBean.RowsBean> getList() {
        return list;
    }
}
