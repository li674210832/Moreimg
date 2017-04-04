package lining20170.bawe.com.moreimg;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Lenovo on 2017/3/30.
 * author ：李宁
 * 类注释：
 */
    public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
        private Context context;

        public MyAdapter(Context context){
            this.context=context;
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view= LayoutInflater.from(context).inflate(R.layout.recycle_itme,parent,false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {

        }

        @Override
        public int getItemCount() {
            return 100;
        }

        class ViewHolder extends RecyclerView.ViewHolder{

            public ViewHolder(View itemView) {
                super(itemView);
            }
        }
    }
