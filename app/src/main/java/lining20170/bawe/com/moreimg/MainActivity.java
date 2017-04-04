package lining20170.bawe.com.moreimg;

import android.content.Context;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.azoft.carousellayoutmanager.CarouselLayoutManager;
import com.azoft.carousellayoutmanager.CarouselZoomPostLayoutListener;
import com.azoft.carousellayoutmanager.CenterScrollListener;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerView recyclerView1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        Context con;
        View view;

    }
    public void initView(){

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView1 = (RecyclerView) findViewById(R.id.recyclerView1);
        CarouselLayoutManager carouselLayoutManager=new CarouselLayoutManager(CarouselLayoutManager.HORIZONTAL,true);
        carouselLayoutManager.setPostLayoutListener(new CarouselZoomPostLayoutListener());
        recyclerView.setLayoutManager(carouselLayoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(new MyAdapter(this));
        recyclerView.addOnScrollListener(new CenterScrollListener());

        CarouselLayoutManager carouselLayoutManager1=new CarouselLayoutManager(CarouselLayoutManager.HORIZONTAL,true);
        carouselLayoutManager1.setPostLayoutListener(new CarouselZoomPostLayoutListener());
        recyclerView1.setLayoutManager(carouselLayoutManager1);
        recyclerView1.setHasFixedSize(true);
        recyclerView1.setAdapter(new MyAdapter(this));
        recyclerView1.addOnScrollListener(new CenterScrollListener());
    }
}
