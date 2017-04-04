package lining20170.bawe.com.testyueb.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.util.Collections;
import java.util.List;

import lining20170.bawe.com.testyueb.Good;
import lining20170.bawe.com.testyueb.R;

/**
 * Created by Lenovo on 2017/3/31.
 * author ：李宁
 * 类注释：
 */

public class Adapterright extends RecyclerView.Adapter<Adapterright.LeftHolder>{
    private Context context;
    private List<Good.ResultBean.RowsBean> list;

    public Adapterright(Context context, List<Good.ResultBean.RowsBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public LeftHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.right, parent, false);
        return new LeftHolder(inflate);
    }

    @Override
    public void onBindViewHolder(LeftHolder holder, int position) {
        for (int i = 0; i < list.size(); i++) {
            Log.d("zzz","img"+list.get(position).getInfo().getDefault_image());
            Glide.with(context).load(list.get(position).getInfo().getDefault_image()).into(holder.img);
        }

    }

    @Override
    public int getItemCount() {
        return list.size();
    }


   ///移动
    public  void onMove(int oldposition,int newposition){
        //交换数据
        Collections.swap(list,oldposition,newposition);
        //刷新
        this.notifyItemMoved(oldposition,newposition);
    }




    //删除
    public  void delect(int position){
        list.remove(position);
        this.notifyItemRemoved(position);
    }



    class  LeftHolder extends RecyclerView.ViewHolder{

        public   ImageView img;

        public LeftHolder(View itemView) {
            super(itemView);
            img = (ImageView) itemView.findViewById(R.id.img);
        }
    }
}
