package se.kmdev.tvepg.epg.domain;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Kristoffer.
 */
public class EPGChannel implements Parcelable {

    private String channelID;
    private String name;
    private String imageURL;
    private String language;

    public String getChannelID() {
        return channelID;
    }

    public void setChannelID(String channelID) {
        this. channelID = channelID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public EPGChannel(Parcel in) {
        channelID = in.readString();
        name = in.readString();
        imageURL = in.readString();
        language = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(channelID);
        dest.writeString(name);
        dest.writeString(imageURL);
        dest.writeString(language);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<EPGChannel> CREATOR = new Parcelable.Creator<EPGChannel>() {
        @Override
        public EPGChannel createFromParcel(Parcel in) {
            return new EPGChannel(in);
        }

        @Override
        public EPGChannel[] newArray(int size) {
            return new EPGChannel[size];
        }
    };
}