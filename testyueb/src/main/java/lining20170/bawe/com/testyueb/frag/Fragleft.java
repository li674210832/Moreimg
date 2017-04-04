package lining20170.bawe.com.testyueb.frag;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.gson.Gson;

import org.greenrobot.eventbus.EventBus;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import lining20170.bawe.com.testyueb.EvevtbusMannerss;
import lining20170.bawe.com.testyueb.Good;
import lining20170.bawe.com.testyueb.Httpok;
import lining20170.bawe.com.testyueb.R;
import lining20170.bawe.com.testyueb.Recyonclick;
import lining20170.bawe.com.testyueb.adapter.Adapterleft;

/**
 * Created by Lenovo on 2017/3/31.
 * author ：李宁
 * 类注释：
 */

public class Fragleft extends Fragment{
    private RecyclerView recyleft;
    private List<Good.ResultBean.RowsBean> list;
    Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            recyleft.setAdapter(adapterleft);

        }
    };
    private Adapterleft adapterleft;
    private ArrayList<Good.ResultBean.RowsBean> listl1;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = View.inflate(getActivity(), R.layout.frag_left, null);
        listl1 = new ArrayList<>();



        recyleft = (RecyclerView) inflate.findViewById(R.id.recyleft);
        recyleft.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false));
        initdate();
        adapterleft = new Adapterleft(getActivity(), listl1);
        //recycleview监听
       adapterleft.setRecyonclick(new Recyonclick() {
           @Override
           public void onItmeOnclick(int position) {
               Log.d("zzz","position*****:"+position);

               FragmentManager manager = getActivity().getSupportFragmentManager();
               Fragright  ff= (Fragright) manager.findFragmentByTag("right");

               ff.setTV(listl1.get(position).getInfo().getRegion_title());
                 Log.d("zzz","getRegion_title*****"+listl1.get(position).getInfo().getRegion_title());
               //ff.setList(list);
               EventBus.getDefault().post(new EvevtbusMannerss(listl1));

           }
       });

        return inflate;
    }


    private void initdate() {
        new Thread(){
            @Override
            public void run() {
                super.run();
                String url="http://api.fang.anjuke.com/m/android/1.3/shouye/recInfosV3/?city_id=14&lat=40.04652&lng=116.306033&api_key=androidkey&sig=9317e9634b5fbc16078ab07abb6661c5&macid=45cd2478331b184ff0e15f29aaa89e3e&app=a-ajk&_pid=11738&o=PE-TL10-user+4.4.2+HuaweiPE-TL10+CHNC00B260+ota-rel-keys%2Crelease-keys&from=mobile&m=Android-PE-TL10&cv=9.5.1&cid=14&i=864601026706713&v=4.4.2&pm=b61&uuid=1848c59c-185d-48d9-b0e9-782016041109&_chat_id=0&qtime=20160411091603";
                try {
                    String okhttpp = Httpok.okHttp(url);
                    Gson gson = new Gson();
                    Good good = gson.fromJson(okhttpp, Good.class);
                    list = good.getResult().getRows();
                    listl1.addAll(list);

                    Log.d("zzz","okhttpp"+okhttpp.toString());
                    Log.d("zzz","zzz"+list.toString());
                  handler.sendEmptyMessage(0);


                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }.start();



    }


    @Override
    public void onDestroy(){
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}
