package net.terme.offical.speeddial;

import static com.google.android.material.floatingactionbutton.FloatingActionButton.SIZE_AUTO;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.ContextThemeWrapper;

import androidx.annotation.ColorInt;
import androidx.annotation.DrawableRes;
import androidx.annotation.IdRes;
import androidx.annotation.Nullable;
import androidx.annotation.StringDef;
import androidx.annotation.StringRes;
import androidx.annotation.StyleRes;
import androidx.appcompat.content.res.AppCompatResources;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@SuppressWarnings({"unused", "WeakerAccess"})
public class TermeSpeedDialActionItem implements Parcelable {
    public static final int RESOURCE_NOT_SET = Integer.MIN_VALUE;

    @StringDef({TYPE_NORMAL, TYPE_FILL})
    @Retention(RetentionPolicy.RUNTIME)
    public @interface FabType {
    }
    public static final String TYPE_NORMAL = "normal";
    public static final String TYPE_FILL = "fill";

    @IdRes
    private final int mId;
    @Nullable
    private final String mLabel;
    @StringRes
    private final int mLabelRes;
    @Nullable
    private final String mContentDescription;
    @StringRes
    private final int mContentDescriptionRes;
    @DrawableRes
    private final int mFabImageResource;
    @Nullable
    private final Drawable mFabImageDrawable;
    @ColorInt
    private final int mFabImageTintColor;
    private final boolean mFabImageTint;
    private final String mFabType;
    @ColorInt
    private final int mFabBackgroundColor;
    @ColorInt
    private final int mLabelColor;
    @ColorInt
    private final int mLabelBackgroundColor;
    private boolean mLabelClickable ;
    @FloatingActionButton.Size
    private final int mFabSize;
    @StyleRes
    private final int mTheme;

    private boolean enableToolTip = true;

    public void isEnableToolTip(boolean enableToolTip) {
        this.enableToolTip = enableToolTip;
    }

    public boolean isEnableToolTip() {
        return enableToolTip;
    }

    private TermeSpeedDialActionItem(Builder builder) {
        mId = builder.mId;
        mLabel = builder.mLabel;
        mLabelRes = builder.mLabelRes;
        mContentDescription = builder.mContentDescription;
        mContentDescriptionRes = builder.mContentDescriptionRes;
        mFabImageTintColor = builder.mFabImageTintColor;
        mFabImageTint = builder.mFabImageTint;
        mFabType = builder.mFabType;
        mFabImageResource = builder.mFabImageResource;
        mFabImageDrawable = builder.mFabImageDrawable;
        mFabBackgroundColor = builder.mFabBackgroundColor;
        mLabelColor = builder.mLabelColor;
        mLabelBackgroundColor = builder.mLabelBackgroundColor;
        mLabelClickable = builder.mLabelClickable;
        mFabSize = builder.mFabSize;
        mTheme = builder.mTheme;


        if (mLabel != null || mLabelRes != RESOURCE_NOT_SET) {
            mLabelClickable = true;
        }
    }

    public int getId() {
        return mId;
    }

    @Nullable
    public String getLabel(Context context) {
        if (mLabel != null) {
            return mLabel;
        } else if (mLabelRes != RESOURCE_NOT_SET) {
            return context.getString(mLabelRes);
        } else {
            return null;
        }
    }

    @Nullable
    public String getContentDescription(Context context) {
        if (mContentDescription != null) {
            return mContentDescription;
        } else if (mContentDescriptionRes != RESOURCE_NOT_SET) {
            return context.getString(mContentDescriptionRes);
        } else {
            return null;
        }
    }

    /**
     * Gets the current Drawable, or null if no Drawable has been assigned.
     *
     * @param context A context to retrieve the Drawable from (needed for TermeSpeedDialActionItem.Builder(int, int).
     * @return the speed dial item drawable, or null if no drawable has been assigned.
     */
    @Nullable
    public Drawable getFabImageDrawable(Context context) {
        if (mFabImageDrawable != null) {
            return mFabImageDrawable;
        } else if (mFabImageResource != RESOURCE_NOT_SET) {
            return AppCompatResources.getDrawable(context, mFabImageResource);
        } else {
            return null;
        }
    }

    @ColorInt
    public int getFabImageTintColor() {
        return mFabImageTintColor;
    }

    public boolean getFabImageTint() {
        return mFabImageTint;
    }

    @FabType
    public String getFabType() {
        return mFabType;
    }

    @ColorInt
    public int getFabBackgroundColor() {
        return mFabBackgroundColor;
    }

    @ColorInt
    public int getLabelColor() {
        return mLabelColor;
    }

    public int getLabelBackgroundColor() {
        return mLabelBackgroundColor;
    }

    public boolean isLabelClickable() {
        return mLabelClickable;
    }

    @StyleRes
    public int getTheme() {
        return mTheme;
    }

    public TermeFabWithLabelView createFabWithLabelView(Context context) {
        TermeFabWithLabelView termeFabWithLabelView;
        int theme = getTheme();
        if (theme == RESOURCE_NOT_SET) {
            termeFabWithLabelView = new TermeFabWithLabelView(context);
        } else {
            termeFabWithLabelView = new TermeFabWithLabelView(new ContextThemeWrapper(context, theme), null, theme);
        }
        termeFabWithLabelView.setSpeedDialActionItem(this);
        return termeFabWithLabelView;
    }

    @FloatingActionButton.Size
    public int getFabSize() {
        return mFabSize;
    }

    public static class Builder {
        @IdRes
        private final int mId;
        @DrawableRes
        private final int mFabImageResource;
        @Nullable
        private Drawable mFabImageDrawable;
        @ColorInt
        private int mFabImageTintColor = RESOURCE_NOT_SET;
        private boolean mFabImageTint = true;

        private String mFabType = TYPE_NORMAL;
        @Nullable
        private String mLabel;
        @StringRes
        private int mLabelRes = RESOURCE_NOT_SET;
        @Nullable
        private String mContentDescription;
        @StringRes
        private int mContentDescriptionRes = RESOURCE_NOT_SET;
        @ColorInt
        private int mFabBackgroundColor = RESOURCE_NOT_SET;
        @ColorInt
        private int mLabelColor = RESOURCE_NOT_SET;
        @ColorInt
        private int mLabelBackgroundColor = RESOURCE_NOT_SET;
        private boolean mLabelClickable = false;
        @FloatingActionButton.Size
        private int mFabSize = SIZE_AUTO;


        @StyleRes
        private int mTheme = RESOURCE_NOT_SET;

        /**
         * Creates a builder for a speed dial action item that uses a {@link DrawableRes} as icon.
         *
         * @param id               the identifier for this action item. The identifier must be unique to the instance
         *                         of {@link TermeSpeedDialView}. The identifier should be a positive number.
         * @param fabImageResource resId the resource identifier of the drawable
         */
        public Builder(@IdRes int id, @DrawableRes int fabImageResource) {
            mId = id;
            mFabImageResource = fabImageResource;
            mFabImageDrawable = null;
        }

        /**
         * Creates a builder for a speed dial action item that uses a {@link Drawable} as icon.
         * <p class="note">{@link Drawable} are not parcelables so is not possible to restore them when the view is
         * recreated for example after an orientation change. If possible always use the {@link #Builder(int, int)}</p>
         *
         * @param id       the identifier for this action item. The identifier must be unique to the instance
         *                 of {@link TermeSpeedDialView}. The identifier should be a positive number.
         * @param drawable the Drawable to set, or null to clear the content
         */
        public Builder(@IdRes int id, @Nullable Drawable drawable) {
            mId = id;
            mFabImageDrawable = drawable;
            mFabImageResource = RESOURCE_NOT_SET;
        }

        /**
         * Creates a builder for a speed dial action item that uses a {@link TermeSpeedDialActionItem} instance to
         * initialize the default values.
         *
         * @param termeSpeedDialActionItem it will be used for the default values of the builder.
         */
        public Builder(TermeSpeedDialActionItem termeSpeedDialActionItem) {
            mId = termeSpeedDialActionItem.mId;
            mLabel = termeSpeedDialActionItem.mLabel;
            mLabelRes = termeSpeedDialActionItem.mLabelRes;
            mContentDescription = termeSpeedDialActionItem.mContentDescription;
            mContentDescriptionRes = termeSpeedDialActionItem.mContentDescriptionRes;
            mFabImageResource = termeSpeedDialActionItem.mFabImageResource;
            mFabImageDrawable = termeSpeedDialActionItem.mFabImageDrawable;
            mFabImageTintColor = termeSpeedDialActionItem.mFabImageTintColor;
            mFabImageTint = termeSpeedDialActionItem.mFabImageTint;
            mFabType = termeSpeedDialActionItem.mFabType;
            mFabBackgroundColor = termeSpeedDialActionItem.mFabBackgroundColor;
            mLabelColor = termeSpeedDialActionItem.mLabelColor;
            mLabelBackgroundColor = termeSpeedDialActionItem.mLabelBackgroundColor;
            mLabelClickable = termeSpeedDialActionItem.mLabelClickable;
            mFabSize = termeSpeedDialActionItem.mFabSize;
            mTheme = termeSpeedDialActionItem.mTheme;
        }

        public Builder setLabel(@Nullable String label) {
            mLabel = label;
            if (mContentDescription == null || mContentDescriptionRes == RESOURCE_NOT_SET) {
                mContentDescription = label;
            }
            return this;
        }

        public Builder setLabel(@StringRes int labelRes) {
            mLabelRes = labelRes;
            if (mContentDescription == null || mContentDescriptionRes == RESOURCE_NOT_SET) {
                mContentDescriptionRes = labelRes;
            }
            return this;
        }

        public Builder setContentDescription(@Nullable String contentDescription) {
            mContentDescription = contentDescription;
            return this;
        }

        public Builder setContentDescription(@StringRes int contentDescriptionRes) {
            mContentDescriptionRes = contentDescriptionRes;
            return this;
        }

        public Builder setFabImageTintColor(@Nullable @ColorInt Integer fabImageTintColor) {
            if (fabImageTintColor == null) {
                mFabImageTint = false;
            } else {
                mFabImageTint = true;
                mFabImageTintColor = fabImageTintColor;
            }
            return this;
        }

        /**
         * set TermeSpeedDialActionItem size.
         * TermeSpeedDialActionItem.TYPE_NORMAL Use normal Fab.
         * TermeSpeedDialActionItem.TYPE_FILL Set Floating Action Button image to fill the button.
         */
        public Builder setFabType(@FabType String fabType) {
            mFabType = fabType;
            return this;
        }

        public Builder setFabBackgroundColor(@ColorInt int fabBackgroundColor) {
            mFabBackgroundColor = fabBackgroundColor;
            return this;
        }

        public Builder setLabelColor(@ColorInt int labelColor) {
            mLabelColor = labelColor;
            return this;
        }

        public Builder setLabelBackgroundColor(@ColorInt int labelBackgroundColor) {
            mLabelBackgroundColor = labelBackgroundColor;
            return this;
        }

        public Builder setLabelClickable(boolean labelClickable) {
            mLabelClickable = labelClickable;
            return this;
        }

        public Builder setTheme(int mTheme) {
            this.mTheme = mTheme;
            return this;
        }

        public TermeSpeedDialActionItem create() {
            return new TermeSpeedDialActionItem(this);
        }

        public Builder setFabSize(@FloatingActionButton.Size int fabSize) {
            mFabSize = fabSize;
            return this;
        }

    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.mId);
        dest.writeString(this.mLabel);
        dest.writeInt(this.mLabelRes);
        dest.writeString(this.mContentDescription);
        dest.writeInt(this.mContentDescriptionRes);
        dest.writeInt(this.mFabImageResource);
        dest.writeInt(this.mFabImageTintColor);
        dest.writeByte(this.mFabImageTint ? (byte) 1 : (byte) 0);
        dest.writeString(this.mFabType);
        dest.writeInt(this.mFabBackgroundColor);
        dest.writeInt(this.mLabelColor);
        dest.writeInt(this.mLabelBackgroundColor);
        dest.writeByte(this.mLabelClickable ? (byte) 1 : (byte) 0);
        dest.writeInt(this.mFabSize);
        dest.writeInt(this.mTheme);
    }

    protected TermeSpeedDialActionItem(Parcel in) {
        this.mId = in.readInt();
        this.mLabel = in.readString();
        this.mLabelRes = in.readInt();
        this.mContentDescription = in.readString();
        this.mContentDescriptionRes = in.readInt();
        this.mFabImageResource = in.readInt();
        this.mFabImageDrawable = null;
        this.mFabImageTintColor = in.readInt();
        this.mFabImageTint = in.readByte() != 0;
        this.mFabType = in.readString();
        this.mFabBackgroundColor = in.readInt();
        this.mLabelColor = in.readInt();
        this.mLabelBackgroundColor = in.readInt();
        this.mLabelClickable = in.readByte() != 0;
        this.mFabSize = in.readInt();
        this.mTheme = in.readInt();
    }

    public static final Creator<TermeSpeedDialActionItem> CREATOR = new Creator<TermeSpeedDialActionItem>() {
        @Override
        public TermeSpeedDialActionItem createFromParcel(Parcel source) {
            return new TermeSpeedDialActionItem(source);
        }

        @Override
        public TermeSpeedDialActionItem[] newArray(int size) {
            return new TermeSpeedDialActionItem[size];
        }
    };
}
