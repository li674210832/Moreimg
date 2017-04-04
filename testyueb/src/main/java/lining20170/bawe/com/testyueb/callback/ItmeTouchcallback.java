package lining20170.bawe.com.testyueb.callback;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.util.Log;

import lining20170.bawe.com.testyueb.adapter.Adapterright;

/**
 * Created by Lenovo on 2017/4/1.
 * author ：李宁
 * 类注释：
 */

public class ItmeTouchcallback extends ItemTouchHelper.Callback {
    public  Adapterright adapterright;

    public void setAdapter(Adapterright adapterright) {
        this.adapterright = adapterright;
    }

    //获取滑动标记
    @Override
    public int getMovementFlags(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
        //拖动改变位置标记
        int drag =ItemTouchHelper.DOWN | ItemTouchHelper.UP | ItemTouchHelper.LEFT |ItemTouchHelper.RIGHT;
        //滑动删除的标记
        int swip= ItemTouchHelper.LEFT |ItemTouchHelper.RIGHT;

        return makeMovementFlags(drag,swip);

    }
  // 交换位置--移动
    @Override
    public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
       //移动的时候
        int oldd = viewHolder.getAdapterPosition();
        int newposition = target.getAdapterPosition();
        //交换位置-交换集合，刷新适配器
        adapterright.onMove(oldd,newposition);

        return true;
    }
    //删除
    @Override
    public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
    adapterright.delect(viewHolder.getAdapterPosition());

    }
}
