package me.pexcn.android.utils.graphics;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import me.pexcn.android.utils.Utils;

/**
 * Created by pexcn on 2017-07-17.
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public class ImageUtils {
    private ImageUtils() {
    }

    /**
     * 获取 /sdcard/DCIM/Camera 下面媒体文件的 File 对象
     *
     * @param type 媒体文件类型
     * @return File 对象
     */
    public static File getOutputMediaFile(int type) {
        final String dcim = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM).getPath();
        final String camera = File.separator + "Camera";
        final File dir = new File(dcim + camera);

        if (!dir.exists()) {
            if (!dir.mkdirs()) {
                return null;
            }
        }

        final String time = new SimpleDateFormat("yyyyMMdd_HHmmss", Locale.getDefault()).format(new Date());

        final File file;
        if (type == MediaStore.Files.FileColumns.MEDIA_TYPE_IMAGE) {
            file = new File(dir.getPath() + File.separator + "IMG_" + time + ".jpg");
        } else if (type == MediaStore.Files.FileColumns.MEDIA_TYPE_VIDEO) {
            file = new File(dir.getPath() + File.separator + "VID_" + time + ".mp4");
        } else {
            return null;
        }

        return file;
    }

    /**
     * 获取 /sdcard/DCIM/Camera 下面媒体文件的 Uri 对象
     *
     * @param type 媒体文件类型
     * @return Uri 对象
     */
    public static Uri getOutputMediaFileUri(int type) {
        return Uri.fromFile(getOutputMediaFile(type));
    }

    /**
     * 根据 Uri 获取文件真实路径
     *
     * @param uri Uri 对象
     * @return 文件路径
     */
    public static String getRealPathFromUri(Uri uri) {
        final String result;
        final Cursor cursor = Utils.getContext().getContentResolver().query(uri, null, null, null, null);
        if (cursor == null) {
            result = uri.getPath();
        } else {
            cursor.moveToFirst();
            final int index = cursor.getColumnIndex(MediaStore.Images.ImageColumns.DATA);
            result = cursor.getString(index);
            cursor.close();
        }
        return result;
    }

    /**
     * Bitmap 对象转字节数组
     *
     * @param bitmap Bitmap 对象
     * @return 字节数组
     */
    public static byte[] bitmap2Bytes(Bitmap bitmap) {
        final ByteArrayOutputStream baos = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, baos);
        return baos.toByteArray();
    }

    /**
     * 字节数组转 Bitmap 对象
     *
     * @param bytes 字节数组
     * @return Bitmap 对象
     */
    public static Bitmap bytes2Bitmap(byte[] bytes) {
        return BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
    }

    /**
     * 从 Uri 获取 Bitmap
     *
     * @return Bitmap 对象
     */
    public static Bitmap getBitmapFromUri(Uri uri) {
        try {
            return MediaStore.Images.Media.getBitmap(Utils.getContext().getContentResolver(), uri);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 把图片插入到系统图库
     *
     * @param uri 图片 Uri
     */
    public static void insertImageToGallery(Uri uri) {
        final Intent intent = new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE);
        intent.setData(uri);
        Utils.getContext().sendBroadcast(intent);
    }

//    public static Bitmap getCompressBitmap(String path) {
//        final Bitmap bitmap = BitmapFactory.decodeFile(path);
//        FileOutputStream fos = null;
//        try {
//            fos = new FileOutputStream("dist");
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
//        bitmap.compress(Bitmap.CompressFormat.JPEG, 90, fos);
//        return bitmap;
//    }
}
