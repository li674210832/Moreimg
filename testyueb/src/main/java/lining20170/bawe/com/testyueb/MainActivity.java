package lining20170.bawe.com.testyueb;

import android.os.Handler;
import android.os.Message;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.google.gson.Gson;

import java.io.IOException;
import java.util.List;

import lining20170.bawe.com.testyueb.frag.Fragleft;
import lining20170.bawe.com.testyueb.frag.Fragright;

public class MainActivity extends AppCompatActivity {





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
      init();


    }

    private void init() {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.linleft,new Fragleft(),"left");
        transaction.replace(R.id.lin_right,new Fragright(),"right");
        transaction.commit();

    }


}
