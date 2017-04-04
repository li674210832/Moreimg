package lining20170.bawe.com.testyue4;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by Lenovo on 2017/4/2.
 * author ：李宁
 * 类注释：
 */

public class Cricleview extends View {
    public Paint paint=new Paint();
    private int width;
    private int height;
    public  int ON_CRICLE=1;
    public  int ON_OUTCRICLE=2;
    public  int ON_RECTCRICLE=3;
    private float downx;
    private float dowy;
public  onCriclelinnter onCriclelinnter;
    public  void setOncricle( onCriclelinnter onCriclelinnter){
        this.onCriclelinnter=onCriclelinnter;
    }
    public Cricleview(Context context) {
        super(context);

    }

    public Cricleview(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        paint.setAntiAlias(true);
        width = getWidth() / 2;
        height = getHeight()/2;

        paint.setColor(Color.GREEN);
        canvas.drawRect(width -160, height -160, width +160, height +160,paint);

        paint.setColor(Color.RED);
        canvas.drawCircle(width, height,150,paint);

        paint.setColor(Color.WHITE);
        canvas.drawCircle(width, height,80,paint);
        paint.setColor(Color.BLACK);
        paint.setTextSize(25);
        canvas.drawText("圆环",width-20,height+10,paint);


    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
       switch (event.getAction()){
           case MotionEvent.ACTION_DOWN:
               downx = event.getX();
               dowy = event.getY();
               break;
           case MotionEvent.ACTION_UP:
               float upx = event.getX();
               float upy = event.getY();
               if(downx==upx&&dowy==upy){
                   int getcurentlation = getcurentlation(upx, upy);
                      if(getcurentlation==ON_CRICLE){
                          onCriclelinnter.onCricleone();
                      }else if(getcurentlation==ON_OUTCRICLE){
                          onCriclelinnter.onCricletwo();
                      }else if(getcurentlation==ON_RECTCRICLE){
                          onCriclelinnter.onCriclethree();
                      }
               }
               break;

       }
        return true;
    }

    private  int getcurentlation(float x,float y){
        float v=(x-width)*(x-width)+(y-height)*(y-height);
        double ff=Math.sqrt(v);
        if(ff<80){
            return ON_CRICLE;
        }else if(ff>80&&ff<150){
            return  ON_OUTCRICLE;
        }else if(ff>150&&ff<160){
            return  ON_RECTCRICLE;
        }

        return -1;
    }



    public  interface onCriclelinnter{
         public void onCricleone();
         public void onCricletwo();
         public void onCriclethree();
    }
}
