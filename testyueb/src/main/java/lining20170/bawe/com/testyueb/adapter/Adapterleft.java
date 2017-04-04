package lining20170.bawe.com.testyueb.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import lining20170.bawe.com.testyueb.Good;
import lining20170.bawe.com.testyueb.R;
import lining20170.bawe.com.testyueb.Recyonclick;

/**
 * Created by Lenovo on 2017/3/31.
 * author ：李宁
 * 类注释：
 */

public class Adapterleft extends RecyclerView.Adapter<Adapterleft.LeftHolder>{
    private Context context;
    private List<Good.ResultBean.RowsBean> list;
   public Recyonclick recyonclick;

    public void setRecyonclick(Recyonclick recyonclick) {
        this.recyonclick = recyonclick;
    }

    public Adapterleft(Context context, List<Good.ResultBean.RowsBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public LeftHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.left, parent, false);

        return new LeftHolder(inflate);
    }

    @Override
    public void onBindViewHolder(LeftHolder holder, final int position) {

        for (int i = 0; i < list.size(); i++) {
            holder.tv.setText(list.get(position).getInfo().getRegion_title());
            Log.d("zzz", "list///" + list.get(position).getInfo().getRegion_title());
        }

    }

    @Override
    public int getItemCount() {

        return list.size();
    }

    class  LeftHolder extends RecyclerView.ViewHolder{

        private final TextView tv;

        public LeftHolder(View itemView) {
            super(itemView);
            tv = (TextView) itemView.findViewById(R.id.tv);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(recyonclick!=null){
                        recyonclick.onItmeOnclick(getLayoutPosition());
                    }
                }
            });
        }
    }
}
