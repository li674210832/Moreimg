package lining20170.bawe.com.testyuecc;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.MapStatus;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.map.MapView;
import com.baidu.mapapi.map.MyLocationData;
import com.baidu.mapapi.model.LatLng;
import com.google.gson.Gson;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private boolean isFirstLoc=true;
    private BaiduMap mBaiduMap;
    private LocationClient mLocClient;
    public MyLocationListenner myListener = new MyLocationListenner();
    public class MyLocationListenner implements BDLocationListener {
    @Override
    public void onReceiveLocation(BDLocation location) {
        // map view 销毁后不在处理新接收的位置
        if (location == null || mMapView == null) {
            return;
        }
        MyLocationData locData = new MyLocationData.Builder()
                .accuracy(location.getRadius())
                // 此处设置开发者获取到的方向信息，顺时针0-360
                .direction(100).latitude(location.getLatitude())
                .longitude(location.getLongitude()).build();
        mBaiduMap.setMyLocationData(locData);
        //是否是第一次定位
        if (isFirstLoc) {
            isFirstLoc = false;
            LatLng ll = new LatLng(location.getLatitude(),
                    location.getLongitude());
            MapStatus.Builder builder = new MapStatus.Builder();
            builder.target(ll).zoom(18.0f);
            mBaiduMap.animateMapStatus(MapStatusUpdateFactory.newMapStatus(builder.build()));
        }
    }


        @Override
        public void onConnectHotSpotMessage(String s, int i) {

        }

        public void onReceivePoi(BDLocation poiLocation) {
    }
}
    private ArrayList<Goodd.DataBean> list2;
   Handler handler=new Handler(){
       @Override
       public void handleMessage(Message msg) {
           super.handleMessage(msg);
          recy.setAdapter(recyadapter);
       }
   };
    private RecyclerView recy;
    private Recyadapter recyadapter;
    private MapView mMapView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        recy = (RecyclerView) findViewById(R.id.recy);
        list2 = new ArrayList<>();
        recy.setLayoutManager(new LinearLayoutManager(this));
        recyadapter = new Recyadapter(this, list2);
        initview();
        mMapView = (MapView) findViewById(R.id.bmapView);
       // mMapView.setVisibility(View.GONE);
    }

    private void initview() {
        new Thread(){
            @Override
            public void run() {
                super.run();
                String url="http://www.yulin520.com/a2a/impressApi/news/mergeList?sign=C7548DE604BCB8A17592EFB9006F9265&pageSize=10&gender=2&ts=1871746850&page=1";
                try {
                    String okget = Httpok.okget(url);
                    Log.d("zzz","okget"+okget);
                    Gson gson = new Gson();
                    Goodd goodd = gson.fromJson(okget, Goodd.class);
                    List<Goodd.DataBean> data = goodd.getData();
                     list2.addAll(data);
                     handler.sendEmptyMessage(0);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }.start();

    }

    public void dingwei(View view) {
        mBaiduMap = mMapView.getMap();
      // mMapView.setVisibility(View.INVISIBLE);
       recy.setVisibility(View.GONE);
        mBaiduMap.setMyLocationEnabled(true);
        // 定位初始化
        mLocClient = new LocationClient(this);
        mLocClient.registerLocationListener(myListener);
        LocationClientOption option = new LocationClientOption();
        option.setOpenGps(true); // 打开gps
        option.setCoorType("bd09ll"); // 设置坐标类型
        option.setScanSpan(1000);
        mLocClient.setLocOption(option);
        mLocClient.start();
    }

    public void clear(View view) {
        recy.setVisibility(View.VISIBLE);
        ImageLoader.getInstance().clearDiskCache();
        ImageLoader.getInstance().clearMemoryCache();

    }

    protected void onDestroy() {
        super.onDestroy();
        //在activity执行onDestroy时执行mMapView.onDestroy()，实现地图生命周期管理
        mMapView.onDestroy();
    }
    @Override
    protected void onResume() {
        super.onResume();
        //在activity执行onResume时执行mMapView. onResume ()，实现地图生命周期管理
        mMapView.onResume();
    }
    @Override
    protected void onPause() {
        super.onPause();
        //在activity执行onPause时执行mMapView. onPause ()，实现地图生命周期管理
        mMapView.onPause();
    }
}
