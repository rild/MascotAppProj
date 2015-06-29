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


        int[][] image = new int[3][2];
        String[] imageType = new String[3];

        BitmapFactory.decodeResource(resources,R.drawable.pose0body0,options);

        image[0][0] = options.outHeight;
        image[0][1] = options.outWidth;
        imageType[0] = options.outMimeType;

        bitmap[0] = decodeSampledBitmapFromResource(resources,R.drawable.pose0body0,image[0][0],image[0][1]);

        BitmapFactory.decodeResource(resources,R.drawable.pose0eye0,options);

        image[1][0] = options.outHeight;
        image[1][1] = options.outWidth;
        imageType[1] = options.outMimeType;

        bitmap[1] = decodeSampledBitmapFromResource(resources,R.drawable.pose0body0,image[1][0],image[1][1]);
        //java.lang.OutOfMemoryError 2015.06.28

        BitmapFactory.decodeResource(resources,R.drawable.pose0mouth0,options);

        image[2][0] = options.outHeight;
        image[2][1] = options.outWidth;
        imageType[2] = options.outMimeType;

        bitmap[2] = decodeSampledBitmapFromResource(resources,R.drawable.pose0body0,image[2][0],image[2][1]);


    }

    @Override
    protected void onDraw(Canvas canvas){
        canvas.drawColor(Color.WHITE);
        Paint paint = new Paint();

        for(int i = 0; i < bitmap.length; i++){
            canvas.drawBitmap(bitmap[i],
                    (canvas.getWidth() - bitmap[i].getWidth())/2,0,paint);
        }

    }


    //bitmapのサイズを元にサブサンプルにサイズを決める
    //サブサンプル？？　2015.06.27
    public static int calculateInSampleSize(BitmapFactory.Options options, int reqWidth, int reqHeight) {

        // 画像の元サイズ
        final int height = options.outHeight;
        final int width = options.outWidth;
        int inSampleSize = 1;

        if (height > reqHeight || width > reqWidth) {
            if (width > height) {
                inSampleSize = Math.round((float)height / (float)reqHeight);
            } else {
                inSampleSize = Math.round((float)width / (float)reqWidth);
            }
        }
        return inSampleSize;
    }

//    public static Bitmap decodeSampledBitmapFromFile(String filePath, int reqWidth, int reqHeight) {
//
//        // inJustDecodeBounds=true で画像のサイズをチェック
//        final BitmapFactory.Options options = new BitmapFactory.Options();
//        options.inJustDecodeBounds = true;
//        BitmapFactory.decodeFile(filePath, options);
//
//        // inSampleSize を計算
//        options.inSampleSize = calculateInSampleSize(options, reqWidth, reqHeight);
//
//        // inSampleSize をセットしてデコード
//        options.inJustDecodeBounds = false;
//        return BitmapFactory.decodeFile(filePath, options);
//    }

    public static Bitmap decodeSampledBitmapFromResource(Resources resources,int res, int reqWidth, int reqHeight) {

        // inJustDecodeBounds=true で画像のサイズをチェック
        final BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(resources, res, options);

        // inSampleSize を計算
        options.inSampleSize = calculateInSampleSize(options, reqWidth, reqHeight);

        // inSampleSize をセットしてデコード
        options.inJustDecodeBounds = false;
        //これはなんだろう
        //2015.06.28
        return BitmapFactory.decodeResource(resources, res, options);
    }



}
