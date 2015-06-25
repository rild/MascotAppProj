package com.rild.android.mascotapptest_bitmaptest2;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

/**
 * Created by rild on 15/06/25.
 */
public class BitmapView extends View {
//    Bitmap bitmap[] = new Bitmap[3];
//
//    public BitmapView(Context context){
//        super(context);
//
//        Resources resources = context.getResources();
//        BitmapFactory.Options options = new BitmapFactory.Options();
////        options.inPurgeable = true;
//        options.inJustDecodeBounds = true;
//
//        bitmap[0] = BitmapFactory.decodeResource(resources,R.drawable.pose0body0,options);
//        bitmap[1] = BitmapFactory.decodeResource(resources,R.drawable.pose0eye0,options);
//        bitmap[2] = BitmapFactory.decodeResource(resources,R.drawable.pose0mouth0,options);
//    }
//
//    @Override
//    protected void onDraw(Canvas canvas){
//        canvas.drawColor(Color.WHITE);
//        Paint paint = new Paint();
//
//        for(int i = 0; i < bitmap.length; i++){
//            canvas.drawBitmap(bitmap[i],
//                    (canvas.getWidth() - bitmap[i].getWidth())/2,0,paint);
//        }
//
//    }

//    Bitmap bitmap;
//    Bitmap bitmap2;
//    Bitmap bitmap3;
//
//    public BitmapView(Context context){
//        super(context);
//
//        Resources resources = context.getResources();
//        bitmap = BitmapFactory.decodeResource(resources,R.drawable.pose0body0);
//        bitmap2 = BitmapFactory.decodeResource(resources,R.drawable.pose0eye0);
//        bitmap3 = BitmapFactory.decodeResource(resources,R.drawable.pose0mouth0);
//    }
//
//    @Override
//    protected void onDraw(Canvas canvas){
//        canvas.drawColor(Color.WHITE);
//        Paint paint = new Paint();
//        canvas.drawBitmap(bitmap,
//                (canvas.getWidth() - bitmap.getWidth())/2,0,paint);
//
//    }


    Bitmap bitmap[] = new Bitmap[3];

    public BitmapView(Context context){
        super(context);

        Resources resources = context.getResources();
        BitmapFactory.Options options = new BitmapFactory.Options();

        options.inJustDecodeBounds = true;

        BitmapFactory.decodeResource(resources,R.drawable.pose0body0,options);

        int[][] image = new int[3][2];
        String[] imageType = new String[3];

        image[0][0] = options.outHeight;
        image[0][1] = options.outWidth;
        imageType[0] = options.outMimeType;

        BitmapFactory.decodeResource(resources,R.drawable.pose0eye0,options);

        image[1][0] = options.outHeight;
        image[1][1] = options.outWidth;
        imageType[1] = options.outMimeType;

        BitmapFactory.decodeResource(resources,R.drawable.pose0mouth0,options);

        image[2][0] = options.outHeight;
        image[2][1] = options.outWidth;
        imageType[2] = options.outMimeType;


    }

    @Override
    protected void onDraw(Canvas canvas){
        canvas.drawColor(Color.WHITE);
        Paint paint = new Paint();

//        for(int i = 0; i < bitmap.length; i++){
//            canvas.drawBitmap(bitmap[i],
//                    (canvas.getWidth() - bitmap[i].getWidth())/2,0,paint);
//        }

    }



}
