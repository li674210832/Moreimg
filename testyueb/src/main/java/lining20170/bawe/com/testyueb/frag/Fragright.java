package lining20170.bawe.com.testyueb.frag;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.gson.Gson;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import lining20170.bawe.com.testyueb.EvevtbusMannerss;
import lining20170.bawe.com.testyueb.Good;
import lining20170.bawe.com.testyueb.Httpok;
import lining20170.bawe.com.testyueb.R;
import lining20170.bawe.com.testyueb.adapter.Adapterright;
import lining20170.bawe.com.testyueb.callback.ItmeTouchcallback;

/**
 * Created by Lenovo on 2017/3/31.
 * author ：李宁
 * 类注释：
 */

public class Fragright extends Fragment{
   private RecyclerView recyright;
   // private List<Good.ResultBean.RowsBean> list;
   /* Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);

        }
    };*/
    private TextView ttt;
    private Adapterright adapterright;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = View.inflate(getActivity(), R.layout.frag_right, null);
        recyright = (RecyclerView)inflate.findViewById(R.id.recyright);
        ttt = (TextView) inflate.findViewById(R.id.ttt);
        EventBus.getDefault().register(this);
       // list = new ArrayList<>();
        recyright.setLayoutManager(new GridLayoutManager(getActivity(),3, GridLayoutManager.VERTICAL,false));
        //initdate();
        /*//创建回调
        ItmeTouchcallback itmeTouchcallback = new ItmeTouchcallback();
        //设置帮助类
        ItemTouchHelper helper = new ItemTouchHelper(itmeTouchcallback);
        //进行关联
        helper.attachToRecyclerView(recyright);
        itmeTouchcallback.setAdapter(adapterright);*/
        return inflate;
    }
   public void setTV(String ss){
       ttt.setText(ss);
   }
   @Subscribe
   public  void onEventMainThread(EvevtbusMannerss even){
       List<Good.ResultBean.RowsBean> listlist = even.getList();
       adapterright = new Adapterright(getActivity(), listlist);
       recyright.setAdapter(adapterright);
//创建回调
       ItmeTouchcallback itmeTouchcallback = new ItmeTouchcallback();
       //设置帮助类
       ItemTouchHelper helper = new ItemTouchHelper(itmeTouchcallback);
       //进行关联
       helper.attachToRecyclerView(recyright);
       itmeTouchcallback.setAdapter(adapterright);
   }

    @Override
    public void onDestroy(){
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
  /*  public void setList(List<Good.ResultBean.RowsBean> list){
        Adapterright adapterright = new Adapterright(getActivity(), list);
        recyright.setAdapter(adapterright);
    }*/

}
