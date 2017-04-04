package lining20170.bawe.com.testyue4.frag;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import lining20170.bawe.com.testyue4.Cricleview;
import lining20170.bawe.com.testyue4.R;

/**
 * Created by Lenovo on 2017/4/2.
 * author ：李宁
 * 类注释：
 */

public class Fragmenthome extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = View.inflate(getActivity(), R.layout.home, null);
        Cricleview cc=(Cricleview)inflate.findViewById(R.id.cri);
       cc.setOncricle(new Cricleview.onCriclelinnter() {
           @Override
           public void onCricleone() {
               Toast.makeText(getActivity(), "内圆", Toast.LENGTH_SHORT).show();
           }

           @Override
           public void onCricletwo() {
               Toast.makeText(getActivity(), "外圆", Toast.LENGTH_SHORT).show();

           }

           @Override
           public void onCriclethree() {
               Toast.makeText(getActivity(), "方形", Toast.LENGTH_SHORT).show();

           }
       });
        return inflate;
    }
}
