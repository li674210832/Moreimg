package lining20170.bawe.com.testyuecc;

import android.content.Context;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.ArrayList;

/**
 * Created by Lenovo on 2017/4/1.
 * author ：李宁
 * 类注释：
 */

public class Recyadapter extends  RecyclerView.Adapter<Recyadapter.RviewHolder>{
     private Context context;
    private ArrayList<Goodd.DataBean>list;
    private DisplayImageOptions options;

    public Recyadapter(Context context, ArrayList<Goodd.DataBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public RviewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.lv, parent, false);


        return new RviewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(RviewHolder holder, int position) {
        options = new DisplayImageOptions.Builder().cacheInMemory(true).cacheOnDisk(true).build();
        for (int i = 0; i < list.size(); i++) {


        ImageLoader.getInstance().displayImage(list.get(position).getImg(),holder.imm,options);
    }
}
    @Override
    public int getItemCount() {
        return list.size();
    }

    class RviewHolder extends RecyclerView.ViewHolder{

        private final ImageView imm;

        public RviewHolder(View itemView) {
            super(itemView);

            imm = (ImageView) itemView.findViewById(R.id.imm);

        }
    }

}
