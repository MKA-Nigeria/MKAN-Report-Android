package com.aliumujib.majlis.mkanreport.utils;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.ContentUris;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Base64;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.animation.OvershootInterpolator;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.afollestad.materialdialogs.MaterialDialog;

import com.alium.mkan_report_data.constants.Constants;
import com.squareup.picasso.Callback;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.TimeZone;

import jp.wasabeef.picasso.transformations.RoundedCornersTransformation;

import static java.util.Calendar.DATE;
import static java.util.Calendar.MONTH;
import static java.util.Calendar.YEAR;


/**
 * Created by aliumujib on 08.09.2015.
 */


public class Utils {
    private static int screenWidth = 0;
    private static int screenHeight = 0;
    private static final String TAG = Utils.class.getSimpleName();

    public static ShapeDrawable drawCircle(Context context, int width, int height, int color) {
        ShapeDrawable oval = new ShapeDrawable(new OvalShape());
        oval.setIntrinsicHeight(height);
        oval.setIntrinsicWidth(width);
        oval.getPaint().setColor(color);
        return oval;
    }


    public static void showLoadingDialog(Context mContext) {
        android.app.FragmentManager manager = ((Activity) mContext).getFragmentManager();
    }


    public static boolean isEditTextFilled(EditText editText) {
        if (editText.getText().toString().matches("")) {
            return false;
        }

        return true;
    }

    public static String loadJSONFromAsset(String fileName, Context context) {
        String json = null;
        try {
            InputStream is = context.getAssets().open(fileName);
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }

    public static boolean isEmailValid(String email) {
        if (email.contains("@")) {
            return true;
        }
        return false;
    }


    public static File saveBitmapToFile(File file) {
        try {
            // BitmapFactory options to downsize the image
            BitmapFactory.Options o = new BitmapFactory.Options();
            o.inJustDecodeBounds = true;
            o.inSampleSize = 6;
            // factor of downsizing the image

            FileInputStream inputStream = new FileInputStream(file);
            //Bitmap selectedBitmap = null;
            BitmapFactory.decodeStream(inputStream, null, o);
            inputStream.close();

            // The new size we want to scale to
            final int REQUIRED_SIZE = 75;

            // Find the correct scale value. It should be the power of 2.
            int scale = 1;
            while (o.outWidth / scale / 2 >= REQUIRED_SIZE &&
                    o.outHeight / scale / 2 >= REQUIRED_SIZE) {
                scale *= 2;
            }

            BitmapFactory.Options o2 = new BitmapFactory.Options();
            o2.inSampleSize = scale;
            inputStream = new FileInputStream(file);

            Bitmap selectedBitmap = BitmapFactory.decodeStream(inputStream, null, o2);
            inputStream.close();

            // here i override the original image file
            file.createNewFile();
            FileOutputStream outputStream = new FileOutputStream(file);

            selectedBitmap.compress(Bitmap.CompressFormat.JPEG, 100, outputStream);

            return file;
        } catch (Exception e) {
            return null;
        }
    }

    public static byte[] bitMapToByteArray(Bitmap bmp) {
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bmp.compress(Bitmap.CompressFormat.PNG, 100, stream);
        byte[] byteArray = stream.toByteArray();
        return byteArray;
    }


    public static void unBindViewListener(View view) {
        if (view != null) {
            try {
                if (view.hasOnClickListeners()) {
                    view.setOnClickListener(null);

                }

                if (view.getOnFocusChangeListener() != null) {
                    view.setOnFocusChangeListener(null);

                }

                if (view instanceof ViewGroup && !(view instanceof AdapterView)) {
                    ViewGroup viewGroup = (ViewGroup) view;
                    int viewGroupChildCount = viewGroup.getChildCount();
                    for (int i = 0; i < viewGroupChildCount; i++) {
                        unBindViewListener(viewGroup.getChildAt(i));
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }

/*
    public static void hideLoadingDialog() {
        ld.dismiss();
    }
*/

    /**
     * Recursive implementation, invokes itself for each factor of a thousand, increasing the class on each invokation.
     *
     * @param n         the number to format
     * @param iteration in fact this is the class from the array c
     * @return a String representing the number n formatted in a cool looking way.
     */
    private static char[] c = new char[]{'k', 'm', 'b', 't'};

    public static String numberFormatterToString(double n, int iteration) {
        double d = ((long) n / 100) / 10.0;
        boolean isRound = (d * 10) % 10 == 0;//true if the decimal part is equal to 0 (then it's trimmed anyway)
        return (d < 1000 ? //this determines the class, i.e. 'k', 'm' etc
                ((d > 99.9 || isRound || (!isRound && d > 9.99) ? //this decides whether to trim the decimals
                        (int) d * 10 / 10 : d + "" // (int) d * 10 / 10 drops the decimal
                ) + "" + c[iteration])
                : numberFormatterToString(d, iteration + 1));
    }


    public static Bitmap reduceImageQuality(Uri fileUri) {
        int MAX_IMAGE_SIZE = 500 * 500; // max final file size
        Bitmap bmpPic = BitmapFactory.decodeFile(fileUri.getPath());
        if ((bmpPic.getWidth() >= 1024) && (bmpPic.getHeight() >= 1024)) {
            BitmapFactory.Options bmpOptions = new BitmapFactory.Options();
            bmpOptions.inSampleSize = 1;
            while ((bmpPic.getWidth() >= 1024) && (bmpPic.getHeight() >= 1024)) {
                bmpOptions.inSampleSize++;
                bmpPic = BitmapFactory.decodeFile(fileUri.getPath(), bmpOptions);
            }
            Log.d(TAG, "Resize: " + bmpOptions.inSampleSize);
        }
        int compressQuality = 104; // quality decreasing by 5 every loop. (start from 99)
        int streamLength = MAX_IMAGE_SIZE;
        while (streamLength >= MAX_IMAGE_SIZE) {
            ByteArrayOutputStream bmpStream = new ByteArrayOutputStream();
            compressQuality -= 5;
            Log.d(TAG, "Quality: " + compressQuality);
            bmpPic.compress(Bitmap.CompressFormat.JPEG, compressQuality, bmpStream);
            byte[] bmpPicByteArray = bmpStream.toByteArray();
            streamLength = bmpPicByteArray.length;
            Log.d(TAG, "Size: " + streamLength);
        }
        try {
            FileOutputStream bmpFile = new FileOutputStream(fileUri.getPath());
            bmpPic.compress(Bitmap.CompressFormat.JPEG, compressQuality, bmpFile);
            bmpFile.flush();
            bmpFile.close();
        } catch (Exception e) {
            Log.e(TAG, "Error on saving file");
        }
        return bmpPic;
    }

    public static void loadImage(final ImageView imageView, final String imagURL, final Context context) {
        Log.d("ImageLoader Method", "Loading: " + imagURL);
        PicassoCache.getPicassoInstance(context).with(context)
                .load(imagURL)
                .fit().centerCrop()
                .into(imageView, new Callback() {
                    @Override
                    public void onSuccess() {
                        Log.d("ImageLoader Method", "Done");
                        imageView.animate()
                                .scaleX(1.f).scaleY(1.f)
                                .setInterpolator(new OvershootInterpolator())
                                .setDuration(400)
                                .setStartDelay(200)
                                .start();
                    }

                    @Override
                    public void onError() {

                    }
                });
    }

    public static void loadImageFromSd(final ImageView imageView, final String imagURL, final Context context) {
        Log.d("ImageLoader Method", "Loading: " + imagURL);
        PicassoCache.getPicassoInstance(context).with(context)
                .load("file://" + imagURL).fit().centerCrop()
                /*.fit().centerCrop()*/.transform(new RoundedCornersTransformation(3, 0))
                .into(imageView, new Callback() {
                    @Override
                    public void onSuccess() {
                        Log.d("ImageLoader Method", "Done");
                        imageView.animate()
                                .scaleX(1.f).scaleY(1.f)
                                .setInterpolator(new OvershootInterpolator())
                                .setDuration(400)
                                .setStartDelay(200)
                                .start();
                    }

                    @Override
                    public void onError() {

                    }
                });
    }

    public static String getSexTextBasedOnInt(int sex) {
        String sexString = "";
        switch (sex) {
            case 1:
                sexString = "Male";
                break;
            case 2:
                sexString = "Female";
                break;
            case 3:
                sexString = "Other";
                break;
            default:
                sexString = "N/A";
                break;
        }
        return sexString;
    }


    public static Date getStartOfDay(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTime();
    }

    public static Date getEndOfDay(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        calendar.set(Calendar.MILLISECOND, 999);
        return calendar.getTime();
    }


    @NonNull
    public static Calendar getCalendarInstanceForFutureMonth() {
        Calendar endLimit = Calendar.getInstance();
        endLimit.add(Calendar.MONTH, 1);
        return endLimit;
    }


    public static void loadImage(final ImageView imageView, final String imagURL, final Context context, final ProgressBar pBar) {
        Log.d("ImageLoader Method", "Loading: " + imagURL);
        PicassoCache.getPicassoInstance(context).with(context)
                .load(imagURL)
                .fit().centerCrop()
                .into(imageView, new Callback() {
                    @Override
                    public void onSuccess() {
                        if (pBar != null)
                            pBar.setVisibility(View.INVISIBLE);
                        Log.d("ImageLoader Method", "Done");
                        imageView.animate()
                                .scaleX(1.f).scaleY(1.f)
                                .setInterpolator(new OvershootInterpolator())
                                .setDuration(400)
                                .setStartDelay(200)
                                .start();
                    }

                    @Override
                    public void onError() {
                       /* Log.d("ImageLoader method", "Error loading Images");
                        PicassoCache.getPicassoInstance(context).with(context)
                                .load(R.drawable.no_photo).into(imageView);*/
                    }
                });

    }

    public static TimeZone getCurrentTimeZone() {
        return Calendar.getInstance().getTimeZone();
    }

    public static void toggleVisibility(View... views) {
        for (View view : views) {
            boolean isVisible = view.getVisibility() == View.VISIBLE;
            view.setVisibility(isVisible ? View.GONE : View.VISIBLE);
        }
    }

    public static void showLoginDialog(Context context, MaterialDialog.SingleButtonCallback singleButtonCallback) {
        DialogUtils.alertDialog(context, "Please login or register to use this functionality", singleButtonCallback);
    }


/*
    public static void goHome(Context context) {
        Intent homeIntent = new Intent(context, SpacerMainActivity.class);
        homeIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        homeIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        context.startActivity(homeIntent);
    }
*/


    public static int dpToPx(int dp) {
        return (int) (dp * Resources.getSystem().getDisplayMetrics().density);
    }

    public static Bitmap DownloadImageBitmap(String url) {
        Bitmap bm = null;
        try {
            URL aURL = new URL(url);
            URLConnection conn = aURL.openConnection();
            conn.connect();
            InputStream is = conn.getInputStream();
            BufferedInputStream bis = new BufferedInputStream(is);
            bm = BitmapFactory.decodeStream(bis);
            bis.close();
            is.close();
        } catch (IOException e) {
            Log.e("IMAGE", "Error getting bitmap", e);
        }
        return bm;
    }

    public static long toMillis(int year, int month, int day, int hr, int min) {
        Calendar cal = Calendar.getInstance();
        cal.set(year, month, day, hr, min, 0);
        return cal.getTimeInMillis();
    }


    public static boolean isNetworkAvailable(Context context) {
        ConnectivityManager manager = (ConnectivityManager)
                context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = manager.getActiveNetworkInfo();

        boolean isAvailable = false;
        if (networkInfo != null && networkInfo.isConnected()) {
            isAvailable = true;
        }

        return isAvailable;
    }

    public static void saveImageToGalleryFromIV(Context mContext, ImageView mImageView) {
        BitmapDrawable btmpDr = (BitmapDrawable) mImageView.getDrawable();
        Bitmap bmp = btmpDr.getBitmap();

/*File sdCardDirectory = Environment.getExternalStorageDirectory();*/
        try {
            File sdCardDirectory = new File(Environment.getExternalStorageDirectory() + File.separator + "LBS_ABC_FILES");
            sdCardDirectory.mkdirs();
            Random random = new Random();
            String imageNameForSDCard = "image_" + String.valueOf(random.nextInt(1000)) + System.currentTimeMillis() + ".jpg";

            File image = new File(sdCardDirectory, imageNameForSDCard);
            FileOutputStream outStream;

            outStream = new FileOutputStream(image);
            bmp.compress(Bitmap.CompressFormat.JPEG, 100, outStream);
    /* 100 to keep full quality of the image */
            outStream.flush();
            outStream.close();


            //Refreshing SD card
            mContext.sendBroadcast(new Intent(Intent.ACTION_MEDIA_MOUNTED, Uri.parse("file://" + Environment.getExternalStorageDirectory())));
        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(mContext, "Image could not be saved : Please ensure you have SD card installed " +
                    "properly", Toast.LENGTH_LONG).show();
        }
    }


    public static boolean createDirIfNotExists(String path) {
        boolean ret = true;
        File file = new File(Environment.getExternalStorageDirectory(), path);
        if (!file.exists()) {
            if (!file.mkdirs()) {
                Log.e("TravellerLog :: ", "Problem creating Image folder");
                ret = false;
            }
        }
        return ret;
    }

    public static void saveImageTOGallery(Context mContext, ImageView imageView, String fileName) {
        BitmapDrawable drawable = (BitmapDrawable) imageView.getDrawable();
        Bitmap bitmap = drawable.getBitmap();

        File sdCardDirectory = Environment.getExternalStorageDirectory();
        File image = new File(sdCardDirectory, fileName + ".png");

        boolean success = false;

        // Encode the file as a PNG image.
        FileOutputStream outStream;
        try {

            outStream = new FileOutputStream(image);
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, outStream);
        /* 100 to keep full quality of the image */

            outStream.flush();
            outStream.close();
            success = true;
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (success) {
            Toast.makeText(mContext, "Image saved with success",
                    Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(mContext,
                    "Error during image saving", Toast.LENGTH_LONG).show();
        }

    }


    public static final void hideKeyboard(Activity ctx) {

        if (ctx.getCurrentFocus() != null) {
            InputMethodManager imm = (InputMethodManager) ctx
                    .getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(ctx.getCurrentFocus().getWindowToken(),
                    0);
        }
    }

    public static final void hideKeyboard(Activity ctx, View v) {

        try {
            InputMethodManager imm = (InputMethodManager) ctx
                    .getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static int getScreenHeight(Context c) {
        if (screenHeight == 0) {
            WindowManager wm = (WindowManager) c.getSystemService(Context.WINDOW_SERVICE);
            Display display = wm.getDefaultDisplay();
            Point size = new Point();
            display.getSize(size);
            screenHeight = size.y;
        }

        return screenHeight;
    }

    public static boolean isFilePresent(Context context, String fileName) {
        String path = context.getExternalFilesDir("") + "/" + fileName;
        File file = new File(path);
        return file.exists();
    }

    public static boolean isTablet(Context context) {
        return (context.getResources().getConfiguration().screenLayout
                & Configuration.SCREENLAYOUT_SIZE_MASK)
                >= Configuration.SCREENLAYOUT_SIZE_LARGE;
    }

    public static int getScreenWidth(Context c) {
        if (screenWidth == 0) {
            WindowManager wm = (WindowManager) c.getSystemService(Context.WINDOW_SERVICE);
            Display display = wm.getDefaultDisplay();
            Point size = new Point();
            display.getSize(size);
            screenWidth = size.x;
        }

        return screenWidth;
    }

    public static boolean isAndroid5() {
        return Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP;
    }


    public static byte[] imagetoByteArray(File fileArg) throws IOException {
        File file = fileArg;
        FileInputStream fis = null;
        fis = new FileInputStream(file);

        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        byte[] buf = new byte[1024];
        assert fis != null;
        for (int readNum; (readNum = fis.read(buf)) != -1; ) {
            //Writes to this byte array output stream
            bos.write(buf, 0, readNum);
            System.out.println("read " + readNum + " bytes,");
        }
        byte[] bytes = bos.toByteArray();
        return bytes;
    }


    @TargetApi(Build.VERSION_CODES.KITKAT)
    public static String getPath(final Context context, final Uri uri) {

        final boolean isKitKat = Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT;

        // DocumentProvider
        if (isKitKat && DocumentsContract.isDocumentUri(context, uri)) {
            // ExternalStorageProvider
            if (isExternalStorageDocument(uri)) {
                final String docId = DocumentsContract.getDocumentId(uri);
                final String[] split = docId.split(":");
                final String type = split[0];

                if ("primary".equalsIgnoreCase(type)) {
                    return Environment.getExternalStorageDirectory() + "/" + split[1];
                }

                // TODO handle non-primary volumes
            }
            // DownloadsProvider
            else if (isDownloadsDocument(uri)) {

                final String id = DocumentsContract.getDocumentId(uri);
                final Uri contentUri = ContentUris.withAppendedId(
                        Uri.parse("content://downloads/public_downloads"), Long.valueOf(id));

                return getDataColumn(context, contentUri, null, null);
            }
            // MediaProvider
            else if (isMediaDocument(uri)) {
                final String docId = DocumentsContract.getDocumentId(uri);
                final String[] split = docId.split(":");
                final String type = split[0];

                Uri contentUri = null;
                if ("image".equals(type)) {
                    contentUri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
                } else if ("video".equals(type)) {
                    contentUri = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
                } else if ("audio".equals(type)) {
                    contentUri = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
                }

                final String selection = "_id=?";
                final String[] selectionArgs = new String[]{
                        split[1]
                };

                return getDataColumn(context, contentUri, selection, selectionArgs);
            }
        }
        // MediaStore (and general)
        else if ("content".equalsIgnoreCase(uri.getScheme())) {
            return getDataColumn(context, uri, null, null);
        }
        // File
        else if ("file".equalsIgnoreCase(uri.getScheme())) {
            return uri.getPath();
        }

        return null;
    }


    public static String formatDateAgoString(long start, long end) {
        //Date start = new Date(1167627600000L); // JANUARY_1_2007
        //Date end = new Date(1175400000000L); // APRIL_1_2007

        StringBuffer sb = new StringBuffer();
        long diffInSeconds = (end - start) / 1000;

        long sec = (diffInSeconds >= 60 ? diffInSeconds % 60 : diffInSeconds);
        long min = (diffInSeconds = (diffInSeconds / 60)) >= 60 ? diffInSeconds % 60 : diffInSeconds;
        long hrs = (diffInSeconds = (diffInSeconds / 60)) >= 24 ? diffInSeconds % 24 : diffInSeconds;
        long days = (diffInSeconds = (diffInSeconds / 24)) >= 30 ? diffInSeconds % 30 : diffInSeconds;
        long months = (diffInSeconds = (diffInSeconds / 30)) >= 12 ? diffInSeconds % 12 : diffInSeconds;
        long years = (diffInSeconds = (diffInSeconds / 12));

        if (years > 0) {
            if (years == 1) {
                sb.append("a year");
            } else {
                sb.append(years + " years");
            }
            if (years <= 6 && months > 0) {
                if (months == 1) {
                    sb.append(" and a month");
                } else {
                    sb.append(" and " + months + " months");
                }
            }
        } else if (months > 0) {
            if (months == 1) {
                sb.append("a month");
            } else {
                sb.append(months + " months");
            }
            if (months <= 6 && days > 0) {
                if (days == 1) {
                    sb.append(" and a day");
                } else {
                    sb.append(" and " + days + " days");
                }
            }
        } else if (days > 0) {
            if (days == 1) {
                sb.append("a day");
            } else {
                sb.append(days + " days");
            }
            if (days <= 3 && hrs > 0) {
                if (hrs == 1) {
                    sb.append(" and an hour");
                } else {
                    sb.append(" and " + hrs + " hours");
                }
            }
        } else if (hrs > 0) {
            if (hrs == 1) {
                sb.append("an hour");
            } else {
                sb.append(hrs + " hours");
            }
            if (min > 1) {
                sb.append(" and " + min + " minutes");
            }
        } else if (min > 0) {
            if (min == 1) {
                sb.append("a minute");
            } else {
                sb.append(min + " minutes");
            }
            if (sec > 1) {
                sb.append(" and " + sec + " seconds");
            }
        } else {
            if (sec <= 1) {
                sb.append("about a second");
            } else {
                sb.append("about " + sec + " seconds");
            }
        }

        sb.append(" ago");


    /*String result = new String(String.format(
    "%d day%s, %d hour%s, %d minute%s, %d second%s ago",
    diff[0],
    diff[0] > 1 ? "s" : "",
    diff[1],
    diff[1] > 1 ? "s" : "",
    diff[2],
    diff[2] > 1 ? "s" : "",
    diff[3],
    diff[3] > 1 ? "s" : ""));*/
        return sb.toString();
    }


    public static int getColor() {
        Random rnd = new Random();
        return Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
    }


    public static String getDataColumn(Context context, Uri uri, String selection,
                                       String[] selectionArgs) {

        Cursor cursor = null;
        final String column = "_data";
        final String[] projection = {
                column
        };

        try {
            cursor = context.getContentResolver().query(uri, projection, selection, selectionArgs,
                    null);
            if (cursor != null && cursor.moveToFirst()) {
                final int column_index = cursor.getColumnIndexOrThrow(column);
                return cursor.getString(column_index);
            }
        } finally {
            if (cursor != null)
                cursor.close();
        }
        return null;
    }


    /**
     * @param uri The Uri to check.
     * @return Whether the Uri authority is ExternalStorageProvider.
     */
    public static boolean isExternalStorageDocument(Uri uri) {
        return "com.android.externalstorage.documents".equals(uri.getAuthority());
    }

    /**
     * @param uri The Uri to check.
     * @return Whether the Uri authority is DownloadsProvider.
     */
    public static boolean isDownloadsDocument(Uri uri) {
        return "com.android.providers.downloads.documents".equals(uri.getAuthority());
    }

    /**
     * @param uri The Uri to check.
     * @return Whether the Uri authority is MediaProvider.
     */
    public static boolean isMediaDocument(Uri uri) {
        return "com.android.providers.media.documents".equals(uri.getAuthority());
    }

    public static boolean isListEmpty(List<Object> objects) {
        if (objects != null) {
            if (objects.size() == 0)
                return true;
            else
                return false;
        } else {
            Log.d(TAG, "Empty list");
            return false;
        }
    }

    public static void replaceFragmentWithBackState(Fragment fragment, Context context, int mode, int frameID) {
        String backStateName = fragment.getClass().getName();

        FragmentManager manager = ((AppCompatActivity) context).getSupportFragmentManager();
        boolean fragmentPopped = manager.popBackStackImmediate(backStateName, FragmentManager.POP_BACK_STACK_INCLUSIVE);

        FragmentTransaction ft = manager.beginTransaction();
        ft.replace(frameID, fragment, Constants.SEARCH_FRAGMENT_TAG);
        if (mode == Constants.WITHBSTATE) {
            ft.addToBackStack(backStateName);
        } else {
            ft.addToBackStack(null);
        }
        ft.commit();
    }

    public static void printKeyToLog(Context context) {
        try {
            PackageInfo info = context.getPackageManager().getPackageInfo(
                    context.getPackageName(),
                    PackageManager.GET_SIGNATURES);
            for (Signature signature : info.signatures) {
                MessageDigest md = MessageDigest.getInstance("SHA");
                md.update(signature.toByteArray());
                Log.d("KeyHash:", Base64.encodeToString(md.digest(), Base64.DEFAULT));
            }
        } catch (PackageManager.NameNotFoundException e) {

        } catch (NoSuchAlgorithmException e) {

        }
    }

    public static String capitalizeFirst(final String line) {
        if (line.length() >= 2) {
            return Character.toUpperCase(line.charAt(0)) + line.substring(1);
        } else {
            return line;
        }
    }

    public static Bitmap drawableTOBitMAp(Drawable drawableArg) {
        Drawable drawable = drawableArg;
        Bitmap bitmap = ((BitmapDrawable) drawable).getBitmap();
        return bitmap;
    }

    public static byte[] drwaableToByteArray(Drawable drawableArg) {
        Drawable drawable = drawableArg;
        Bitmap bitmap = ((BitmapDrawable) drawable).getBitmap();
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);
        final byte[] bitmapdata = stream.toByteArray();

        return bitmapdata;
    }

    public static Point getDisplaySize(Display displayMetrics) {
        int width = displayMetrics.getWidth();
        int height = displayMetrics.getHeight();
        return new Point(width, height);
    }

    //I know it's spelt birthday you nerd! but where is the fun in that
    public static int getDiffYears(Calendar first, Calendar last) {
        int diff = last.get(YEAR) - first.get(YEAR);
        if (first.get(MONTH) > last.get(MONTH) ||
                (first.get(MONTH) == last.get(MONTH) && first.get(DATE) > last.get(DATE))) {
            diff--;
        }
        return diff;
    }
}
