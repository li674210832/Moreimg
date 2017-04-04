package lining20170.bawe.com.testyue4;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

import lining20170.bawe.com.testyue4.frag.Fragmenthome;
import lining20170.bawe.com.testyue4.frag.Fragmentuser;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ViewPager vp;
    private ArrayList<Fragment> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        vp = (ViewPager) findViewById(R.id.vp);
        ininview();
        TextView  tv1= (TextView) findViewById(R.id.tv1);
        TextView  tv2= (TextView) findViewById(R.id.tv2);
        tv1.setOnClickListener(this);
        tv2.setOnClickListener(this);
        vpadapter();
    }

    private void ininview() {
        list = new ArrayList<>();
        list.add(new Fragmenthome());
        list.add(new Fragmentuser());

    }

    private void vpadapter() {
        vp.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return list.get(position);
            }

            @Override
            public int getCount() {
                return list.size();
            }
        });
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case  R.id.tv1:
                vp.setCurrentItem(0);
            break;
            case  R.id.tv2:
                vp.setCurrentItem(1);
                break;
        }
    }
}
