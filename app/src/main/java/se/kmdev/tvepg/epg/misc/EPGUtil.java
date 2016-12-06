package se.kmdev.tvepg.epg.misc;

import android.content.Context;
import android.net.Uri;
import android.util.Log;

import com.jakewharton.picasso.OkHttp3Downloader;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

import org.joda.time.LocalDate;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.util.Locale;

import okhttp3.OkHttpClient;

/**
 * Created by Kristoffer.
 */
public class EPGUtil {
    private static final String TAG = "EPGUtil";
    //private static final DateTimeFormatter dtfShortTime = DateTimeFormat.mediumTime().withLocale( Locale.getDefault() );
    private static Picasso picasso = null;

    public static String getShortTime(long timeMillis) {
        return dtfShortTime.print(timeMillis);
    }

    public static String getWeekdayName(long dateMillis) {
        LocalDate date = new LocalDate(dateMillis);
        return date.dayOfWeek().getAsText();
    }

    public static void loadImageInto(Context context, String url, int width, int height, Target target) {
        initPicasso(context);

        picasso.load(url)
                .resize(width, height)
                .centerInside()
                .into(target);
    }

    private static void initPicasso(Context context) {
        if (picasso == null) {
            picasso = new Picasso.Builder(context)
                    .downloader(new OkHttp3Downloader(new OkHttpClient()))
                    .listener(new Picasso.Listener() {
                        @Override
                        public void onImageLoadFailed(Picasso picasso, Uri uri, Exception exception) {
                            Log.e(TAG, "Failed to load image: " + exception.getMessage());
                        }
                    })
                    .build();
        }
    }

}
