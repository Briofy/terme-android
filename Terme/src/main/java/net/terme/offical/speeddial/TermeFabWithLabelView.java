package net.terme.offical.speeddial;

import static com.google.android.material.floatingactionbutton.FloatingActionButton.SIZE_AUTO;
import static com.google.android.material.floatingactionbutton.FloatingActionButton.SIZE_MINI;
import static com.google.android.material.floatingactionbutton.FloatingActionButton.SIZE_NORMAL;
import static net.terme.offical.speeddial.TermeSpeedDialActionItem.RESOURCE_NOT_SET;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.ColorInt;
import androidx.annotation.DrawableRes;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.widget.ImageViewCompat;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.shape.ShapeAppearanceModel;

import net.terme.offical.R;

import timber.log.Timber;

/**
 * View that contains fab button and its label.
 */
@SuppressWarnings({"unused", "WeakerAccess"})
public class TermeFabWithLabelView extends LinearLayout {
    private TextView mLabelTextView;
    private FloatingActionButton mFab;
    private CardView mLabelCardView;
    private boolean mIsLabelEnabled;
    @Nullable
    private TermeSpeedDialActionItem mTermeSpeedDialActionItem;
    @Nullable
    private TermeSpeedDialView.OnActionSelectedListener mOnActionSelectedListener;
    @FloatingActionButton.Size
    private int mCurrentFabSize;
    private float mLabelCardViewElevation;
    @Nullable
    private Drawable mLabelCardViewBackground;

    public TermeFabWithLabelView(Context context) {
        super(context);
        init(context, null);
    }

    public TermeFabWithLabelView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public TermeFabWithLabelView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    @SuppressLint("RestrictedApi")
    @Override
    public void setVisibility(int visibility) {
        super.setVisibility(visibility);
        getFab().setVisibility(visibility);
        if (isLabelEnabled()) {
            getLabelBackground().setVisibility(visibility);
        }
    }

    @Override
    public void setOrientation(int orientation) {
        super.setOrientation(orientation);
        setFabSize(mCurrentFabSize);
        if (orientation == VERTICAL) {
            setLabelEnabled(false);
        } else {
            setLabel(mLabelTextView.getText().toString());
        }
    }

    /**
     * Return true if button has label, false otherwise.
     */
    public boolean isLabelEnabled() {
        return mIsLabelEnabled;
    }

    /**
     * Enables or disables label of button.
     */
    private void setLabelEnabled(boolean enabled) {
        mIsLabelEnabled = enabled;
        mLabelCardView.setVisibility(enabled ? View.VISIBLE : View.GONE);
    }

    /**
     * Returns FAB labels background card.
     */
    public CardView getLabelBackground() {
        return mLabelCardView;
    }

    /**
     * Returns the {@link FloatingActionButton}.
     */
    public FloatingActionButton getFab() {
        return mFab;
    }

    public TermeSpeedDialActionItem getSpeedDialActionItem() {
        if (mTermeSpeedDialActionItem == null) {
            throw new IllegalStateException("TermeSpeedDialActionItem not set yet!");
        }
        return mTermeSpeedDialActionItem;
    }

    /**
     * Returns an instance of the {@link TermeSpeedDialActionItem.Builder} initialized with the current instance of the
     * {@link TermeSpeedDialActionItem} to make it easier to modify the current Action Item settings.
     */
    public TermeSpeedDialActionItem.Builder getSpeedDialActionItemBuilder() {
        return new TermeSpeedDialActionItem.Builder(getSpeedDialActionItem());
    }

    public void setSpeedDialActionItem(TermeSpeedDialActionItem actionItem) {
        mTermeSpeedDialActionItem = actionItem;
        if (actionItem.getFabType().equals(TermeSpeedDialActionItem.TYPE_FILL)) {
            this.removeView(mFab);
            View view = inflate(getContext(), R.layout.sd_fill_fab, this);
            FloatingActionButton newFab = view.findViewById(R.id.sd_fab_fill);
            mFab = newFab;
        }
        setId(actionItem.getId());
        setLabel(actionItem.getLabel(getContext()));
        setFabContentDescription(actionItem.getContentDescription(getContext()));
        TermeSpeedDialActionItem termeSpeedDialActionItem = getSpeedDialActionItem();
        setLabelClickable(termeSpeedDialActionItem != null && termeSpeedDialActionItem.isLabelClickable());
        setFabIcon(actionItem.getFabImageDrawable(getContext()));
        int imageTintColor = actionItem.getFabImageTintColor();
        if (imageTintColor == RESOURCE_NOT_SET) {
            imageTintColor = UiUtils.getOnSecondaryColor(getContext());
        }
        boolean imageTint = actionItem.getFabImageTint();
        if (imageTint) {
            setFabImageTintColor(imageTintColor);
        }
        int fabBackgroundColor = actionItem.getFabBackgroundColor();
        if (fabBackgroundColor == RESOURCE_NOT_SET) {
            fabBackgroundColor = UiUtils.getPrimaryColor(getContext());
        }
        setFabBackgroundColor(fabBackgroundColor);
        int labelColor = actionItem.getLabelColor();
        if (labelColor == RESOURCE_NOT_SET) {
            labelColor = ResourcesCompat.getColor(getResources(), R.color.sd_label_text_color,
                    getContext().getTheme());
        }
        setLabelColor(labelColor);
        int labelBackgroundColor = actionItem.getLabelBackgroundColor();
        if (labelBackgroundColor == RESOURCE_NOT_SET) {
            labelBackgroundColor = ResourcesCompat.getColor(getResources(), R.color.sd_label_background_color, getContext().getTheme());
        }
        setLabelBackgroundColor(labelBackgroundColor);
        if (actionItem.getFabSize() == SIZE_AUTO || actionItem.getFabType().equals(TermeSpeedDialActionItem.TYPE_FILL)) {
            getFab().setSize(SIZE_MINI);
        } else {
            getFab().setSize(actionItem.getFabSize());
        }
        setFabSize(actionItem.getFabSize());

        if (!actionItem.isLabelClickable()) {
            mLabelCardView.setVisibility(GONE);
        }
    }

    /**
     * Set a listener that will be notified when a menu fab is selected.
     *
     * @param listener listener to set.
     */
    public void setOnActionSelectedListener(@Nullable TermeSpeedDialView.OnActionSelectedListener listener) {
        mOnActionSelectedListener = listener;
        if (mOnActionSelectedListener != null) {
            setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View view) {
                    TermeSpeedDialActionItem termeSpeedDialActionItem = getSpeedDialActionItem();
                    if (mOnActionSelectedListener != null
                            && termeSpeedDialActionItem != null) {
                        if (termeSpeedDialActionItem.isLabelClickable()) {
                            UiUtils.performTap(getLabelBackground());
                        } else {
                            UiUtils.performTap(getFab());
                        }
                    }
                }
            });
            getFab().setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View view) {
                    TermeSpeedDialActionItem termeSpeedDialActionItem = getSpeedDialActionItem();
                    if (mOnActionSelectedListener != null
                            && termeSpeedDialActionItem != null) {
                        mOnActionSelectedListener.onActionSelected(termeSpeedDialActionItem);
                    }
                }
            });

            getLabelBackground().setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View view) {
                    TermeSpeedDialActionItem termeSpeedDialActionItem = getSpeedDialActionItem();
                    if (mOnActionSelectedListener != null
                            && termeSpeedDialActionItem != null
                            && termeSpeedDialActionItem.isLabelClickable()) {
                        mOnActionSelectedListener.onActionSelected(termeSpeedDialActionItem);
                    }
                }
            });
        } else {
            getFab().setOnClickListener(null);
            getLabelBackground().setOnClickListener(null);
        }

    }

    /**
     * Init custom attributes.
     *
     * @param context context.
     * @param attrs   attributes.
     */
    private void init(Context context, @Nullable AttributeSet attrs) {
        View rootView = inflate(context, R.layout.sd_fab_with_label_view, this);
        rootView.setFocusable(false);
        rootView.setFocusableInTouchMode(false);

        mFab = rootView.findViewById(R.id.sd_fab);
        mLabelTextView = rootView.findViewById(R.id.sd_label);
        mLabelCardView = rootView.findViewById(R.id.sd_label_container);

//        setFabSize(SIZE_MINI);
        setOrientation(LinearLayout.HORIZONTAL);
        setClipChildren(false);
        setClipToPadding(false);

        TypedArray attr = context.obtainStyledAttributes(attrs,
                R.styleable.TermeFabWithLabelView, 0, 0);

        try {
            @DrawableRes int src = attr.getResourceId(R.styleable.TermeFabWithLabelView_srcCompat, RESOURCE_NOT_SET);
            if (src == RESOURCE_NOT_SET) {
                src = attr.getResourceId(R.styleable.TermeFabWithLabelView_android_src, RESOURCE_NOT_SET);
            }
            TermeSpeedDialActionItem.Builder builder = new TermeSpeedDialActionItem.Builder(getId(), src);
            String labelText = attr.getString(R.styleable.TermeFabWithLabelView_fabLabel);
            builder.setLabel(labelText);
            @ColorInt int fabBackgroundColor = UiUtils.getPrimaryColor(context);
            fabBackgroundColor = attr.getColor(R.styleable.TermeFabWithLabelView_fabBackgroundColor, fabBackgroundColor);
            builder.setFabBackgroundColor(fabBackgroundColor);
            @ColorInt int labelColor = RESOURCE_NOT_SET;
            labelColor = attr.getColor(R.styleable.TermeFabWithLabelView_fabLabelColor, labelColor);
            builder.setLabelColor(labelColor);
            @ColorInt int labelBackgroundColor = RESOURCE_NOT_SET;
            labelBackgroundColor = attr.getColor(R.styleable.TermeFabWithLabelView_fabLabelBackgroundColor,
                    labelBackgroundColor);
            builder.setLabelBackgroundColor(labelBackgroundColor);
            boolean labelClickable = attr.getBoolean(R.styleable.TermeFabWithLabelView_fabLabelClickable, true);
            builder.setLabelClickable(labelClickable);
            setSpeedDialActionItem(builder.create());
        } catch (Exception e) {
            Timber.e(e, "Failure setting TermeFabWithLabelView icon");
        } finally {
            attr.recycle();
        }
    }

    private void setFabSize(@FloatingActionButton.Size int fabSize) {
        int normalFabSizePx = getContext().getResources().getDimensionPixelSize(R.dimen.sd_fab_normal_size);
        int miniFabSizePx = getContext().getResources().getDimensionPixelSize(R.dimen.sd_fab_mini_size);
        int fabSideMarginPx = getContext().getResources().getDimensionPixelSize(R.dimen.sd_fab_side_margin);
        int fabSizePx = fabSize == SIZE_NORMAL ? normalFabSizePx : miniFabSizePx;
        LayoutParams rootLayoutParams;
        LayoutParams fabLayoutParams = (LayoutParams) mFab.getLayoutParams();
        if (getOrientation() == HORIZONTAL) {
            rootLayoutParams = new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, fabSizePx);
            rootLayoutParams.gravity = Gravity.END;

            if (fabSize == SIZE_NORMAL) {
                int excessMargin = (normalFabSizePx - miniFabSizePx) / 2;
                fabLayoutParams.setMargins(fabSideMarginPx - excessMargin, 0, fabSideMarginPx - excessMargin, 0);
            } else {
                fabLayoutParams.setMargins(fabSideMarginPx, 0, fabSideMarginPx, 0);

            }
        } else {
            rootLayoutParams = new LayoutParams(fabSizePx, ViewGroup.LayoutParams.WRAP_CONTENT);
            rootLayoutParams.gravity = Gravity.CENTER_VERTICAL;
            fabLayoutParams.setMargins(0, 0, 0, 0);
        }

        setLayoutParams(rootLayoutParams);
        mFab.setLayoutParams(fabLayoutParams);
        mCurrentFabSize = fabSize;
    }

    /**
     * Sets fab drawable.
     *
     * @param mDrawable drawable to set.
     */
    private void setFabIcon(@Nullable Drawable mDrawable) {
        mFab.setImageDrawable(mDrawable);
    }

    public void setShapeAppearanceModel(ShapeAppearanceModel model){
        mFab.setShapeAppearanceModel(model);
    }

    /**
     * Sets fab label․
     *
     * @param sequence label to set.
     */
    private void setLabel(@Nullable CharSequence sequence) {
        if (!TextUtils.isEmpty(sequence)) {
            mLabelTextView.setText(sequence);
            setLabelEnabled(getOrientation() == HORIZONTAL);
        } else {
            setLabelEnabled(false);
        }
    }

    private void setLabelClickable(boolean clickable) {
        getLabelBackground().setClickable(clickable);
        getLabelBackground().setFocusable(clickable);
        getLabelBackground().setEnabled(clickable);
    }

    /**
     * Sets fab content description․
     *
     * @param sequence content description to set.
     */
    private void setFabContentDescription(@Nullable CharSequence sequence) {
        if (!TextUtils.isEmpty(sequence)) {
            mFab.setContentDescription(sequence);
        }
    }

    /**
     * Sets fab image tint color in floating action menu.
     *
     * @param color color to set.
     */
    private void setFabImageTintColor(@ColorInt int color) {
        ImageViewCompat.setImageTintList(mFab, ColorStateList.valueOf(color));
    }

    /**
     * Sets fab color in floating action menu.
     *
     * @param color color to set.
     */
    private void setFabBackgroundColor(@ColorInt int color) {
        mFab.setBackgroundTintList(ColorStateList.valueOf(color));
    }

    private void setLabelColor(@ColorInt int color) {
        mLabelTextView.setTextColor(color);
    }

    public void setLabel(String text) {
        mLabelTextView.setText(text);
    }

    private void setLabelBackgroundColor(@ColorInt int color) {
        if (color == Color.TRANSPARENT) {
            mLabelCardView.setCardBackgroundColor(Color.TRANSPARENT);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                mLabelCardViewElevation = mLabelCardView.getElevation();
                mLabelCardView.setElevation(0);
            } else {
                mLabelCardView.setBackgroundColor(Color.TRANSPARENT);
                mLabelCardViewBackground = mLabelCardView.getBackground();
            }
        } else {
            mLabelCardView.setCardBackgroundColor(ColorStateList.valueOf(color));
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                if (mLabelCardViewElevation != 0) {
                    mLabelCardView.setElevation(mLabelCardViewElevation);
                    mLabelCardViewElevation = 0;
                }
            } else {
                if (mLabelCardViewBackground != null) {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                        mLabelCardView.setBackground(mLabelCardViewBackground);
                    } else {
                        mLabelCardView.setBackgroundDrawable(mLabelCardViewBackground);
                    }
                    mLabelCardViewBackground = null;
                }
            }
        }
    }
}