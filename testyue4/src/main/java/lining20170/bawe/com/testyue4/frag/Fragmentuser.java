package lining20170.bawe.com.testyue4.frag;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import lining20170.bawe.com.testyue4.R;

/**
 * Created by Lenovo on 2017/4/2.
 * author ：李宁
 * 类注释：
 */

public class Fragmentuser extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = View.inflate(getActivity(), R.layout.user, null);
        return inflate;
    }
}
