package net.terme.offical.speeddial;

import static net.terme.offical.speeddial.TermeSpeedDialActionItem.RESOURCE_NOT_SET;
import static net.terme.offical.speeddial.TermeSpeedDialView.ExpansionMode.BOTTOM;
import static net.terme.offical.speeddial.TermeSpeedDialView.ExpansionMode.LEFT;
import static net.terme.offical.speeddial.TermeSpeedDialView.ExpansionMode.RIGHT;
import static net.terme.offical.speeddial.TermeSpeedDialView.ExpansionMode.TOP;
import static java.lang.annotation.RetentionPolicy.SOURCE;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;

import androidx.annotation.ColorInt;
import androidx.annotation.DrawableRes;
import androidx.annotation.IdRes;
import androidx.annotation.IntDef;
import androidx.annotation.MenuRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.PopupMenu;
import androidx.cardview.widget.CardView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.ViewCompat;
import androidx.core.widget.ImageViewCompat;
import androidx.recyclerview.widget.RecyclerView;
import androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat;

import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.floatingactionbutton.FloatingActionButton.OnVisibilityChangedListener;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.snackbar.Snackbar;

import net.terme.offical.R;
import net.terme.offical.tooltips.TermeTooltip;

import java.lang.annotation.Retention;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import timber.log.Timber;

@SuppressWarnings({"unused", "WeakerAccess", "UnusedReturnValue"})
public class TermeSpeedDialView extends LinearLayout implements CoordinatorLayout.AttachedBehavior {
    private static final String TAG = TermeSpeedDialView.class.getSimpleName();
    private static final String STATE_KEY_SUPER = "superState";
    private static final String STATE_KEY_IS_OPEN = "isOpen";
    private static final String STATE_KEY_EXPANSION_MODE = "expansionMode";
    private static final int DEFAULT_ROTATE_ANGLE = 45;
    private static final int ACTION_ANIM_DELAY = 25;
    private static final int MAIN_FAB_HORIZONTAL_MARGIN_IN_DP = 4;
    private static final int MAIN_FAB_VERTICAL_MARGIN_IN_DP = -2;
    private final InstanceState mInstanceState = new InstanceState();
    private final List<TermeFabWithLabelView> mTermeFabWithLabelViews = new ArrayList<>();
    @Nullable
    private Drawable mMainFabClosedDrawable = null;
    @Nullable
    private Drawable mMainFabOpenedDrawable = null;
    @Nullable
    private Drawable mMainFabCloseOriginalDrawable;
    private FloatingActionButton mMainFab;
    private ShapeAppearanceModel mShapeAppearanceModel;
    @IdRes
    private int mOverlayLayoutId;
    @Nullable
    private SpeedDialOverlayLayout mOverlayLayout;
    @Nullable
    private OnChangeListener mOnChangeListener;
    @Nullable
    private OnActionSelectedListener mOnActionSelectedListener;
    private final OnActionSelectedListener mOnActionSelectedProxyListener = new OnActionSelectedListener() {
        @Override
        public boolean onActionSelected(TermeSpeedDialActionItem actionItem) {
            if (mOnActionSelectedListener != null) {
                if (mOnActionSelectedListener.onActionSelected(actionItem)) {
                    if (actionItem.isEnableToolTip()) {
                        String msg = actionItem.getLabel(getContext());
                        int bColor = actionItem.getLabelBackgroundColor();
                        int tColor = actionItem.getLabelColor();
                        int exp = getExpansionMode();
                        TermeTooltip.Position position = TermeTooltip.Position.LEFT;
                        if (exp == LEFT || exp == RIGHT) {
                            position = TermeTooltip.Position.TOP;
                        }
                        TermeTooltip.on(findViewById(actionItem.getId()))
                                .autoHide(true, 4000)
                                .position(position)
                                .corner(30)
                                .color(bColor != RESOURCE_NOT_SET ? bColor : -1)
                                .titleColor(tColor != RESOURCE_NOT_SET ? tColor : -1)
                                .title(msg != null ? msg : "actionItem")
                                .show();

                    }
                    return true;
                }
                close(false);
            }
            return false;
        }
    };

    public TermeSpeedDialView(Context context) {
        super(context);
        init(context, null);
    }

    public TermeSpeedDialView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public TermeSpeedDialView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    public boolean getUseReverseAnimationOnClose() {
        return mInstanceState.mUseReverseAnimationOnClose;
    }

    public void setUseReverseAnimationOnClose(boolean useReverseAnimation) {
        mInstanceState.mUseReverseAnimationOnClose = useReverseAnimation;
    }

    @ExpansionMode
    public int getExpansionMode() {
        return mInstanceState.mExpansionMode;
    }

    public void setExpansionMode(@ExpansionMode int expansionMode) {
        setExpansionMode(expansionMode, false);
    }

    private void setExpansionMode(@ExpansionMode int expansionMode, boolean force) {
        if (mInstanceState.mExpansionMode != expansionMode || force) {
            mInstanceState.mExpansionMode = expansionMode;
            switch (expansionMode) {
                case TOP:
                case BOTTOM:
                    setOrientation(VERTICAL);
                    for (TermeFabWithLabelView termeFabWithLabelView : mTermeFabWithLabelViews) {
                        termeFabWithLabelView.setOrientation(HORIZONTAL);
                    }
                    break;
                case LEFT:
                case RIGHT:
                    setOrientation(HORIZONTAL);
                    for (TermeFabWithLabelView termeFabWithLabelView : mTermeFabWithLabelViews) {
                        termeFabWithLabelView.setOrientation(VERTICAL);
                    }
                    break;
            }
            close(false);
            ArrayList<TermeSpeedDialActionItem> actionItems = getActionItems();
            clearActionItems();
            addAllActionItems(actionItems);
        }
    }

    @Override
    public void setOrientation(int orientation) {
        super.setOrientation(orientation);
    }

    public void show() {
        show(null);
    }

    public void show(@Nullable final OnVisibilityChangedListener listener) {
        setVisibility(VISIBLE);
        showFabWithWorkaround(mMainFab, listener);
    }

    /*
     * WORKAROUND: Remove if Google will finally fix this: https://issuetracker.google.com/issues/111316656
     */
    private void showFabWithWorkaround(FloatingActionButton fab, @Nullable final OnVisibilityChangedListener listener) {
        fab.show(new OnVisibilityChangedListener() {
            @SuppressWarnings("unchecked")
            @Override
            public void onShown(FloatingActionButton fab) {
                try {
                    Field declaredField = fab.getClass().getDeclaredField("impl");
                    declaredField.setAccessible(true);
                    Object impl = declaredField.get(fab);
                    Class implClass = Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP
                            ? impl.getClass().getSuperclass() : impl.getClass();
                    Method scale = implClass.getDeclaredMethod("setImageMatrixScale", Float.TYPE);
                    scale.setAccessible(true);
                    scale.invoke(impl, 1.0F);
                } catch (NoSuchMethodException e) {
                    Timber.e(e, "Method setImageMatrixScale not found");
                } catch (IllegalAccessException e) {
                    Timber.e(e, "IllegalAccessException");
                } catch (InvocationTargetException e) {
                    Timber.e(e, "InvocationTargetException");
                } catch (NoSuchFieldException e) {
                    Timber.e(e, "Field impl not found");
                }
                if (listener != null) {
                    listener.onShown(fab);
                }
            }

            @Override
            public void onHidden(FloatingActionButton fab) {
                if (listener != null) {
                    listener.onHidden(fab);
                }
            }
        });
    }

    public void hide() {
        hide(null);
    }

    @Override
    public void setContentDescription(CharSequence contentDescription) {
        FloatingActionButton mainFab = getMainFab();
        if (mainFab != null) {
            mainFab.setContentDescription(contentDescription);
        }
    }

    public void hide(@Nullable final OnVisibilityChangedListener listener) {
        if (isOpen()) {
            close();
            // Workaround for mMainFab.hide() breaking the rotate anim
            ViewCompat.animate(mMainFab).rotation(0).setDuration(0).start();
        }
        mMainFab.hide(new OnVisibilityChangedListener() {
            @Override
            public void onShown(FloatingActionButton fab) {
                super.onShown(fab);
                if (listener != null) {
                    listener.onShown(fab);
                }
            }

            @Override
            public void onHidden(FloatingActionButton fab) {
                super.onHidden(fab);
                setVisibility(INVISIBLE);
                if (listener != null) {
                    listener.onHidden(fab);
                }
            }
        });
    }

    @Nullable
    public SpeedDialOverlayLayout getOverlayLayout() {
        return mOverlayLayout;
    }

    /**
     * Add the overlay/touch guard view to appear together with the speed dial menu.
     *
     * @param overlayLayout The view to add.
     */
    public void setOverlayLayout(@Nullable SpeedDialOverlayLayout overlayLayout) {
        if (mOverlayLayout != null) {
            setOnClickListener(null);
        }
        mOverlayLayout = overlayLayout;
        if (overlayLayout != null) {
            overlayLayout.setOnClickListener(view -> close());
            showHideOverlay(isOpen(), false);
        }
    }

    /**
     * Inflate a menu resource into this TermeSpeedDialView. Any existing Action item will be removed.
     * <p class="note">Using the Menu resource it is possible to specify only the ID, the icon and the label of the
     * Action item. No color customization is available.</p>
     *
     * @param menuRes Menu resource to inflate
     */
    public void inflate(@MenuRes int menuRes) {
        clearActionItems();
        PopupMenu popupMenu = new PopupMenu(getContext(), new View(getContext()));
        popupMenu.inflate(menuRes);
        Menu menu = popupMenu.getMenu();
        for (int i = 0; i < menu.size(); i++) {
            MenuItem menuItem = menu.getItem(i);
            TermeSpeedDialActionItem actionItem = new TermeSpeedDialActionItem.Builder(menuItem.getItemId(), menuItem.getIcon())
                    .setLabel(menuItem.getTitle() != null ? menuItem.getTitle().toString() : null)
                    .create();
            addActionItem(actionItem);
        }
    }

    /**
     * Appends all of the {@link TermeSpeedDialActionItem} to the end of the list, in the order that they are returned by
     * the specified
     * collection's Iterator.
     *
     * @param actionItemCollection collection containing {@link TermeSpeedDialActionItem} to be added to this list
     * @return a collection containing the instances of {@link TermeFabWithLabelView} added.
     */
    public Collection<TermeFabWithLabelView> addAllActionItems(Collection<TermeSpeedDialActionItem> actionItemCollection) {
        ArrayList<TermeFabWithLabelView> termeFabWithLabelViews = new ArrayList<>();
        for (TermeSpeedDialActionItem termeSpeedDialActionItem : actionItemCollection) {
            termeFabWithLabelViews.add(addActionItem(termeSpeedDialActionItem));
        }
        return termeFabWithLabelViews;
    }

    /**
     * Appends the specified {@link TermeSpeedDialActionItem} to the end of this list.
     *
     * @param termeSpeedDialActionItem {@link TermeSpeedDialActionItem} to be appended to this list
     * @return the instance of the {@link TermeFabWithLabelView} if the add was successful, null otherwise.
     */
    @Nullable
    public TermeFabWithLabelView addActionItem(TermeSpeedDialActionItem termeSpeedDialActionItem) {
        return addActionItem(termeSpeedDialActionItem, mTermeFabWithLabelViews.size());
    }

    /**
     * Inserts the specified {@link TermeSpeedDialActionItem} at the specified position in this list. Shifts the element
     * currently at that position (if any) and any subsequent elements to the right (adds one to their indices).
     *
     * @param actionItem {@link TermeSpeedDialActionItem} to be appended to this list
     * @param position   index at which the specified element is to be inserted
     * @return the instance of the {@link TermeFabWithLabelView} if the add was successful, null otherwise.
     */
    @Nullable
    public TermeFabWithLabelView addActionItem(TermeSpeedDialActionItem actionItem, int position) {
        return addActionItem(actionItem, position, true);
    }

    /**
     * Inserts the specified {@link TermeSpeedDialActionItem} at the specified position in this list. Shifts the element
     * currently at that position (if any) and any subsequent elements to the right (adds one to their indices).
     *
     * @param actionItem {@link TermeSpeedDialActionItem} to be appended to this list
     * @param position   index at which the specified element is to be inserted
     * @param animate    true to animate the insertion, false to insert instantly
     * @return the instance of the {@link TermeFabWithLabelView} if the add was successful, null otherwise.
     */
    @Nullable
    public TermeFabWithLabelView addActionItem(TermeSpeedDialActionItem actionItem, int position, boolean animate) {
        TermeFabWithLabelView oldView = findFabWithLabelViewById(actionItem.getId());
        if (oldView != null) {
            return replaceActionItem(oldView.getSpeedDialActionItem(), actionItem);
        } else {
            TermeFabWithLabelView newView = actionItem.createFabWithLabelView(getContext());
            newView.setOrientation(getOrientation() == VERTICAL ? HORIZONTAL : VERTICAL);
            newView.setOnActionSelectedListener(mOnActionSelectedProxyListener);
            newView.setShapeAppearanceModel(mShapeAppearanceModel);
            int layoutPosition = getLayoutPosition(position);
            addView(newView, layoutPosition);
            mTermeFabWithLabelViews.add(position, newView);
            if (isOpen()) {
                if (animate) {
                    showWithAnimationFabWithLabelView(newView, 0);
                }
            } else {
                newView.setVisibility(GONE);
            }
            return newView;
        }
    }

    /**
     * Removes the {@link TermeSpeedDialActionItem} at the specified position in this list. Shifts any subsequent elements
     * to the left (subtracts one from their indices).
     *
     * @param position the index of the {@link TermeSpeedDialActionItem} to be removed
     * @return the {@link TermeSpeedDialActionItem} that was removed from the list
     */
    @Nullable
    public TermeSpeedDialActionItem removeActionItem(int position) {
        TermeSpeedDialActionItem termeSpeedDialActionItem = mTermeFabWithLabelViews.get(position).getSpeedDialActionItem();
        removeActionItem(termeSpeedDialActionItem);
        return termeSpeedDialActionItem;
    }

    /**
     * Removes the specified {@link TermeSpeedDialActionItem} from this list, if it is present. If the list does not
     * contain the element, it is unchanged.
     * <p>
     * Returns true if this list contained the specified element (or equivalently, if this list changed
     * as a result of the call).
     *
     * @param actionItem {@link TermeSpeedDialActionItem} to be removed from this list, if present
     * @return true if this list contained the specified element
     */
    public boolean removeActionItem(@Nullable TermeSpeedDialActionItem actionItem) {
        return actionItem != null && removeActionItemById(actionItem.getId()) != null;
    }

    /**
     * Finds and removes the first {@link TermeSpeedDialActionItem} with the given ID, if it is present. If the list does not
     * contain the element, it is unchanged.
     *
     * @param idRes the ID to search for
     * @return the {@link TermeSpeedDialActionItem} that was removed from the list, or null otherwise
     */
    @Nullable
    public TermeSpeedDialActionItem removeActionItemById(@IdRes int idRes) {
        return removeActionItem(findFabWithLabelViewById(idRes));
    }

    /**
     * Replace the {@link TermeSpeedDialActionItem} at the specified position in this list with the one provided as
     * parameter.
     *
     * @param newActionItem {@link TermeSpeedDialActionItem} to use for the replacement
     * @param position      the index of the {@link TermeSpeedDialActionItem} to be replaced
     * @return the instance of the new {@link TermeFabWithLabelView} if the replace was successful, null otherwise.
     */
    @Nullable
    public TermeFabWithLabelView replaceActionItem(TermeSpeedDialActionItem newActionItem, int position) {
        return replaceActionItem(mTermeFabWithLabelViews.get(position).getSpeedDialActionItem(), newActionItem);
    }

    /**
     * Replace an already added {@link TermeSpeedDialActionItem} with the one provided as parameter.
     *
     * @param oldTermeSpeedDialActionItem the old {@link TermeSpeedDialActionItem} to remove
     * @param newTermeSpeedDialActionItem the new {@link TermeSpeedDialActionItem} to add
     * @return the instance of the new {@link TermeFabWithLabelView} if the replace was successful, null otherwise.
     */
    @Nullable
    public TermeFabWithLabelView replaceActionItem(@Nullable TermeSpeedDialActionItem oldTermeSpeedDialActionItem,
                                                   TermeSpeedDialActionItem newTermeSpeedDialActionItem) {
        if (oldTermeSpeedDialActionItem == null) {
            return null;
        } else {
            TermeFabWithLabelView oldView = findFabWithLabelViewById(oldTermeSpeedDialActionItem.getId());
            if (oldView != null) {
                int index = mTermeFabWithLabelViews.indexOf(oldView);
                if (index < 0) {
                    return null;
                }
                removeActionItem(findFabWithLabelViewById(newTermeSpeedDialActionItem.getId()), null, false);
                removeActionItem(findFabWithLabelViewById(oldTermeSpeedDialActionItem.getId()), null, false);
                return addActionItem(newTermeSpeedDialActionItem, index, false);
            } else {
                return null;
            }
        }
    }

    /**
     * Removes all of the {@link TermeSpeedDialActionItem} from this list.
     */
    public void clearActionItems() {
        Iterator<TermeFabWithLabelView> it = mTermeFabWithLabelViews.iterator();
        while (it.hasNext()) {
            TermeFabWithLabelView termeFabWithLabelView = it.next();
            removeActionItem(termeFabWithLabelView, it, true);
        }
    }

    @NonNull
    public ArrayList<TermeSpeedDialActionItem> getActionItems() {
        ArrayList<TermeSpeedDialActionItem> termeSpeedDialActionItems = new ArrayList<>(mTermeFabWithLabelViews.size());
        for (TermeFabWithLabelView termeFabWithLabelView : mTermeFabWithLabelViews) {
            termeSpeedDialActionItems.add(termeFabWithLabelView.getSpeedDialActionItem());
        }
        return termeSpeedDialActionItems;
    }

    @NonNull
    @Override
    public CoordinatorLayout.Behavior getBehavior() {
        return new SnackbarBehavior();
    }

    /**
     * Set a listener that will be notified when a menu fab is selected.
     *
     * @param listener listener to set.
     */
    public void setOnActionSelectedListener(@Nullable OnActionSelectedListener listener) {
        mOnActionSelectedListener = listener;

        for (int index = 0; index < mTermeFabWithLabelViews.size(); index++) {
            final TermeFabWithLabelView termeFabWithLabelView = mTermeFabWithLabelViews.get(index);
            termeFabWithLabelView.setOnActionSelectedListener(mOnActionSelectedProxyListener);
        }
    }

    /**
     * Set Main FloatingActionButton ClickMOnOptionFabSelectedListener.
     *
     * @param onChangeListener listener to set.
     */
    public void setOnChangeListener(@Nullable final OnChangeListener onChangeListener) {
        mOnChangeListener = onChangeListener;
    }

    /**
     * Opens speed dial menu.
     */
    public void open() {
        toggle(true, true);
    }

    public void open(boolean animate) {
        toggle(true, animate);
    }

    /**
     * Closes speed dial menu.
     */
    public void close() {
        toggle(false, true);
    }

    public void close(boolean animate) {
        toggle(false, animate);
    }

    /**
     * Toggles speed dial menu.
     */
    public void toggle() {
        toggle(!isOpen(), true);
    }

    public void toggle(boolean animate) {
        toggle(!isOpen(), animate);
    }

    /**
     * Return returns true if speed dial menu is open,false otherwise.
     */
    public boolean isOpen() {
        return mInstanceState.mIsOpen;
    }

    public FloatingActionButton getMainFab() {
        return mMainFab;
    }

    public float getMainFabAnimationRotateAngle() {
        return mInstanceState.mMainFabAnimationRotateAngle;
    }

    public void setMainFabAnimationRotateAngle(float mainFabAnimationRotateAngle) {
        mInstanceState.mMainFabAnimationRotateAngle = mainFabAnimationRotateAngle;
        setMainFabOpenedDrawable(mMainFabCloseOriginalDrawable);
    }

    public void setMainFabClosedDrawable(@Nullable Drawable drawable) {
        mMainFabClosedDrawable = drawable;
        updateMainFabDrawable(false);
    }

    public void setMainFabOpenedDrawable(@Nullable Drawable drawable) {
        mMainFabCloseOriginalDrawable = drawable;
        if (mMainFabCloseOriginalDrawable == null) {
            mMainFabOpenedDrawable = null;
        } else {
            mMainFabOpenedDrawable = UiUtils.getRotateDrawable(mMainFabCloseOriginalDrawable,
                    -getMainFabAnimationRotateAngle());
        }
        updateMainFabDrawable(false);
    }

    @ColorInt
    public int getMainFabClosedBackgroundColor() {
        return mInstanceState.mMainFabClosedBackgroundColor;
    }

    public void setMainFabClosedBackgroundColor(@ColorInt int mainFabClosedBackgroundColor) {
        mInstanceState.mMainFabClosedBackgroundColor = mainFabClosedBackgroundColor;
        updateMainFabBackgroundColor();
    }

    @ColorInt
    public int getMainFabOpenedBackgroundColor() {
        return mInstanceState.mMainFabOpenedBackgroundColor;
    }

    public void setMainFabOpenedBackgroundColor(@ColorInt int mainFabOpenedBackgroundColor) {
        mInstanceState.mMainFabOpenedBackgroundColor = mainFabOpenedBackgroundColor;
        updateMainFabBackgroundColor();
    }

    @ColorInt
    public int getMainFabClosedIconColor() {
        return mInstanceState.mMainFabClosedIconColor;
    }

    public void setMainFabClosedIconColor(@ColorInt int mainFabClosedIconColor) {
        mInstanceState.mMainFabClosedIconColor = mainFabClosedIconColor;
        updateMainFabIconColor();
    }

    @ColorInt
    public int getMainFabOpenedIconColor() {
        return mInstanceState.mMainFabOpenedIconColor;
    }

    public void setMainFabOpenedIconColor(@ColorInt int mainFabOpenedIconColor) {
        mInstanceState.mMainFabOpenedIconColor = mainFabOpenedIconColor;
        updateMainFabIconColor();
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (mOverlayLayout == null) {
            SpeedDialOverlayLayout overlayLayout = getRootView().findViewById(mOverlayLayoutId);
            setOverlayLayout(overlayLayout);
        }
    }

    @Nullable
    @Override
    protected Parcelable onSaveInstanceState() {
        Bundle bundle = new Bundle();
        mInstanceState.mTermeSpeedDialActionItems = getActionItems();
        bundle.putParcelable(InstanceState.class.getName(), mInstanceState);
        bundle.putParcelable(STATE_KEY_SUPER, super.onSaveInstanceState());
        return bundle;
    }

    @Override
    protected void onRestoreInstanceState(Parcelable state) {
        if (state instanceof Bundle) {
            Bundle bundle = (Bundle) state;
            InstanceState instanceState = bundle.getParcelable(InstanceState.class.getName());
            if (instanceState != null
                    && instanceState.mTermeSpeedDialActionItems != null
                    && !instanceState.mTermeSpeedDialActionItems.isEmpty()) {
                setUseReverseAnimationOnClose(instanceState.mUseReverseAnimationOnClose);
                setMainFabAnimationRotateAngle(instanceState.mMainFabAnimationRotateAngle);
                setMainFabOpenedBackgroundColor(instanceState.mMainFabOpenedBackgroundColor);
                setMainFabClosedBackgroundColor(instanceState.mMainFabClosedBackgroundColor);
                setMainFabOpenedIconColor(instanceState.mMainFabOpenedIconColor);
                setMainFabClosedIconColor(instanceState.mMainFabClosedIconColor);
                setExpansionMode(instanceState.mExpansionMode, true);
                addAllActionItems(instanceState.mTermeSpeedDialActionItems);
                toggle(instanceState.mIsOpen, false);
            }
            state = bundle.getParcelable(STATE_KEY_SUPER);
        }
        super.onRestoreInstanceState(state);
    }

    @Override
    public void setEnabled(boolean enabled) {
        super.setEnabled(enabled);
        getMainFab().setEnabled(enabled);
    }

    private int getLayoutPosition(int position) {
        if (getExpansionMode() == TOP || getExpansionMode() == LEFT) {
            return mTermeFabWithLabelViews.size() - position;
        } else {
            return position + 1;
        }
    }

    @Nullable
    private TermeSpeedDialActionItem removeActionItem(@Nullable TermeFabWithLabelView view,
                                                      @Nullable Iterator<TermeFabWithLabelView> it,
                                                      boolean animate) {
        if (view != null) {
            TermeSpeedDialActionItem termeSpeedDialActionItem = view.getSpeedDialActionItem();
            if (it != null) {
                it.remove();
            } else {
                mTermeFabWithLabelViews.remove(view);
            }

            if (isOpen()) {
                if (mTermeFabWithLabelViews.isEmpty()) {
                    close();
                }
                if (animate) {
                    UiUtils.shrinkAnim(view, true);
                } else {
                    removeView(view);
                }
            } else {
                removeView(view);
            }
            return termeSpeedDialActionItem;
        } else {
            return null;
        }
    }

    @Nullable
    private TermeSpeedDialActionItem removeActionItem(@Nullable TermeFabWithLabelView view) {
        return removeActionItem(view, null, true);
    }

    private void init(Context context, @Nullable AttributeSet attrs) {
        mMainFab = createMainFab();
        addView(mMainFab);
        setClipChildren(false);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            setElevation(getResources().getDimension(R.dimen.sd_close_elevation));
        }
        TypedArray styledAttrs = context.obtainStyledAttributes(attrs, R.styleable.TermeSpeedDialView, 0, 0);
        try {

            boolean isSquare = styledAttrs.getBoolean(R.styleable.TermeSpeedDialView_fabIsSquare, false);

            int shapeAppearanceResId = isSquare ?
                    R.style.RoundedShapeAppearance : R.style.CircularShapeAppearance;
            mShapeAppearanceModel = ShapeAppearanceModel.builder(getContext(), shapeAppearanceResId, shapeAppearanceResId).build();

            mMainFab.setShapeAppearanceModel(mShapeAppearanceModel);

            setEnabled(styledAttrs.getBoolean(R.styleable.TermeSpeedDialView_android_enabled, isEnabled()));
            setUseReverseAnimationOnClose(styledAttrs.getBoolean(R.styleable.TermeSpeedDialView_useReverseAnimationOnClose,
                    getUseReverseAnimationOnClose()));

            setMainFabAnimationRotateAngle(styledAttrs.getFloat(R.styleable.TermeSpeedDialView_mainFabAnimationRotateAngle,
                    getMainFabAnimationRotateAngle()));
            @DrawableRes int openDrawableRes = styledAttrs.getResourceId(R.styleable.TermeSpeedDialView_mainFabClosedSrc,
                    RESOURCE_NOT_SET);
            if (openDrawableRes != RESOURCE_NOT_SET) {
                setMainFabClosedDrawable(AppCompatResources.getDrawable(getContext(), openDrawableRes));
            }
            int closeDrawableRes = styledAttrs.getResourceId(R.styleable.TermeSpeedDialView_mainFabOpenedSrc,
                    RESOURCE_NOT_SET);
            if (closeDrawableRes != RESOURCE_NOT_SET) {
                setMainFabOpenedDrawable(AppCompatResources.getDrawable(context, closeDrawableRes));
            }
            setExpansionMode(styledAttrs.getInt(R.styleable.TermeSpeedDialView_expansionMode, getExpansionMode()), true);

            setMainFabClosedBackgroundColor(styledAttrs.getColor(R.styleable.TermeSpeedDialView_mainFabClosedBackgroundColor,
                    getMainFabClosedBackgroundColor()));
            setMainFabOpenedBackgroundColor(styledAttrs.getColor(R.styleable.TermeSpeedDialView_mainFabOpenedBackgroundColor,
                    getMainFabOpenedBackgroundColor()));
            setMainFabClosedIconColor(styledAttrs.getColor(R.styleable.TermeSpeedDialView_mainFabClosedIconColor,
                    getMainFabClosedIconColor()));
            setMainFabOpenedIconColor(styledAttrs.getColor(R.styleable.TermeSpeedDialView_mainFabOpenedIconColor,
                    getMainFabOpenedIconColor()));
            mOverlayLayoutId = styledAttrs.getResourceId(R.styleable.TermeSpeedDialView_overlayLayout, RESOURCE_NOT_SET);
        } catch (Exception e) {
            Timber.e(e, "Failure setting TermeFabWithLabelView icon");
        } finally {
            styledAttrs.recycle();
        }
    }

    private FloatingActionButton createMainFab() {
        FloatingActionButton floatingActionButton = new FloatingActionButton(getContext());
        LayoutParams layoutParams = new LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        layoutParams.gravity = Gravity.END;
        int marginHorizontal = UiUtils.dpToPx(getContext(), MAIN_FAB_HORIZONTAL_MARGIN_IN_DP);
        int marginVertical = UiUtils.dpToPx(getContext(), MAIN_FAB_VERTICAL_MARGIN_IN_DP);
        layoutParams.setMargins(marginHorizontal, marginVertical, marginHorizontal, marginVertical);
        floatingActionButton.setId(R.id.sd_main_fab);
        floatingActionButton.setUseCompatPadding(true);
        floatingActionButton.setLayoutParams(layoutParams);
        floatingActionButton.setClickable(true);
        floatingActionButton.setFocusable(true);
        floatingActionButton.setSize(FloatingActionButton.SIZE_NORMAL);
        floatingActionButton.setContentDescription(getContentDescription());
        floatingActionButton.setOnClickListener(view -> {
            if (isOpen()) {
                if (mOnChangeListener == null || !mOnChangeListener.onMainActionSelected()) {
                    close();
                }
            } else {
                open();
            }
        });
        return floatingActionButton;
    }

    private void toggle(boolean show, boolean animate) {
        if (show && mTermeFabWithLabelViews.isEmpty()) {
            show = false;
            if (mOnChangeListener != null) {
                mOnChangeListener.onMainActionSelected();
            }
        }
        if (isOpen() == show) {
            return;
        }
        mInstanceState.mIsOpen = show;
        visibilitySetup(show, animate, mInstanceState.mUseReverseAnimationOnClose);
        updateMainFabDrawable(animate);
        updateMainFabBackgroundColor();
        updateMainFabIconColor();
        showHideOverlay(show, animate);
        if (mOnChangeListener != null) {
            mOnChangeListener.onToggleChanged(show);
        }
    }

    private void updateMainFabDrawable(boolean animate) {
        if (isOpen()) {
            if (mMainFabOpenedDrawable != null) {
                // This is a workaround. I don't know why I can't set the rotated bitmap with `setImageBitmap`
                // after set directly the rotated Drawable with `setImageDrawable`
                // on Android API 25 or lower (works on API 26 or higher).
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N &&
                        mMainFabOpenedDrawable instanceof AnimatedVectorDrawable) {
                    mMainFab.setImageDrawable(mMainFabOpenedDrawable);
                    ((AnimatedVectorDrawable) mMainFabOpenedDrawable).start();
                } else if (Build.VERSION.SDK_INT < Build.VERSION_CODES.N &&
                        mMainFabOpenedDrawable instanceof AnimatedVectorDrawableCompat) {
                    mMainFab.setImageDrawable(mMainFabOpenedDrawable);
                    ((AnimatedVectorDrawableCompat) mMainFabOpenedDrawable).start();
                } else if (mMainFabOpenedDrawable instanceof AnimationDrawable) {
                    mMainFab.setImageDrawable(mMainFabOpenedDrawable);
                    ((AnimationDrawable) mMainFabOpenedDrawable).start();
                } else {
                    // This is a workaround.
                    // I don't know why if I set directly the rotated Drawable with `setImageDrawable`
                    // it will be transparent/empty on Android API 20 or lower (works on API 21 or higher).

                    Bitmap bitmap = UiUtils.getBitmapFromDrawable(mMainFabOpenedDrawable);
                    mMainFab.setImageBitmap(bitmap);
                }
            }
            UiUtils.rotateForward(mMainFab, getMainFabAnimationRotateAngle(), animate);
        } else {
            UiUtils.rotateBackward(mMainFab, animate);
            mMainFab.setImageDrawable(mMainFabClosedDrawable);
            if (mMainFabClosedDrawable != null) {

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N &&
                        mMainFabClosedDrawable instanceof AnimatedVectorDrawable) {
                    ((AnimatedVectorDrawable) mMainFabClosedDrawable).start();
                } else if (Build.VERSION.SDK_INT < Build.VERSION_CODES.N &&
                        mMainFabClosedDrawable instanceof AnimatedVectorDrawableCompat) {
                    ((AnimatedVectorDrawableCompat) mMainFabClosedDrawable).start();
                } else if (mMainFabClosedDrawable instanceof AnimationDrawable) {
                    ((AnimationDrawable) mMainFabClosedDrawable).start();
                }
            }
        }
    }

    private void updateMainFabBackgroundColor() {
        int color;
        if (isOpen()) {
            color = getMainFabOpenedBackgroundColor();
        } else {
            color = getMainFabClosedBackgroundColor();
        }
        if (color != RESOURCE_NOT_SET) {
            mMainFab.setBackgroundTintList(ColorStateList.valueOf(color));
        } else {
            mMainFab.setBackgroundTintList(ColorStateList.valueOf(UiUtils.getAccentColor(getContext())));
        }
    }

    private void updateMainFabIconColor() {
        int color;
        if (isOpen()) {
            color = getMainFabOpenedIconColor();
        } else {
            color = getMainFabClosedIconColor();
        }
        if (color != RESOURCE_NOT_SET) {
            ImageViewCompat.setImageTintList(mMainFab, ColorStateList.valueOf(color));
        }
    }

    private void updateElevation() {
        if (isOpen()) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                setElevation(getResources().getDimension(R.dimen.sd_open_elevation));
            } else {
                bringToFront();
            }
        } else {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                setElevation(getResources().getDimension(R.dimen.sd_close_elevation));
            }
        }
    }

    private void showHideOverlay(boolean show, boolean animate) {
        if (mOverlayLayout != null) {
            if (show) {
                mOverlayLayout.show(animate);
            } else {
                mOverlayLayout.hide(animate);
            }
        }
    }

    @Nullable
    private TermeFabWithLabelView findFabWithLabelViewById(@IdRes int id) {
        for (TermeFabWithLabelView termeFabWithLabelView : mTermeFabWithLabelViews) {
            if (termeFabWithLabelView.getId() == id) {
                return termeFabWithLabelView;
            }
        }
        return null;
    }

    /**
     * Set menus visibility (visible or invisible).
     */
    private void visibilitySetup(boolean visible, boolean animate, boolean reverseAnimation) {
        int size = mTermeFabWithLabelViews.size();
        if (visible) {
            for (int i = 0; i < size; i++) {
                TermeFabWithLabelView termeFabWithLabelView = mTermeFabWithLabelViews.get(i);
                termeFabWithLabelView.setAlpha(1);
                termeFabWithLabelView.setVisibility(VISIBLE);
                if (animate) {
                    showWithAnimationFabWithLabelView(termeFabWithLabelView, i * ACTION_ANIM_DELAY);
                }
                if (i == 0) {
                    termeFabWithLabelView.getFab().requestFocus();
                }
                if (i == size - 1) {
                    termeFabWithLabelView.getFab().setNextFocusUpId(termeFabWithLabelView.getFab().getId());
                    getMainFab().setNextFocusDownId(getMainFab().getId());
                    getMainFab().setNextFocusForwardId(getMainFab().getId());
                }
            }
        } else {
            for (int i = 0; i < size; i++) {
                int index = reverseAnimation ? size - 1 - i : i;
                TermeFabWithLabelView termeFabWithLabelView = mTermeFabWithLabelViews.get(index);
                if (animate) {
                    if (reverseAnimation) {
                        hideWithAnimationFabWithLabelView(termeFabWithLabelView, i * ACTION_ANIM_DELAY);
                    } else {
                        UiUtils.shrinkAnim(termeFabWithLabelView, false);
                    }
                } else {
                    termeFabWithLabelView.setAlpha(0);
                    termeFabWithLabelView.setVisibility(GONE);
                }
            }
        }
    }

    private void showWithAnimationFabWithLabelView(TermeFabWithLabelView termeFabWithLabelView, int delay) {
        ViewCompat.animate(termeFabWithLabelView).cancel();
        UiUtils.enlargeAnim(termeFabWithLabelView.getFab(), delay);
        if (termeFabWithLabelView.isLabelEnabled()) {
            CardView labelBackground = termeFabWithLabelView.getLabelBackground();
            ViewCompat.animate(labelBackground).cancel();
            Animation animation = AnimationUtils.loadAnimation(getContext(), R.anim.sd_fade_and_translate_in);
            animation.setStartOffset(delay);
            labelBackground.startAnimation(animation);
        }
    }

    private void hideWithAnimationFabWithLabelView(final TermeFabWithLabelView termeFabWithLabelView, int delay) {
        ViewCompat.animate(termeFabWithLabelView).cancel();
        UiUtils.shrinkAnim(termeFabWithLabelView.getFab(), delay);
        if (termeFabWithLabelView.isLabelEnabled()) {
            final CardView labelBackground = termeFabWithLabelView.getLabelBackground();
            ViewCompat.animate(labelBackground).cancel();
            Animation animation = AnimationUtils.loadAnimation(getContext(), R.anim.sd_fade_and_translate_out);
            animation.setAnimationListener(new Animation.AnimationListener() {
                @Override
                public void onAnimationEnd(Animation animation) {
                    labelBackground.setVisibility(View.GONE);
                }

                @Override
                public void onAnimationStart(Animation animation) {
                }

                @Override
                public void onAnimationRepeat(Animation animation) {
                }
            });
            animation.setStartOffset(delay);
            labelBackground.startAnimation(animation);
        }
    }

    /**
     * Listener for handling events on option fab's.
     */
    public interface OnChangeListener {
        /**
         * Called when the main action has been clicked.
         *
         * @return true to keep the Speed Dial open, false otherwise.
         */
        boolean onMainActionSelected();

        /**
         * Called when the toggle state of the speed dial menu changes (eg. it is opened or closed).
         *
         * @param isOpen true if the speed dial is open, false otherwise.
         */
        void onToggleChanged(boolean isOpen);
    }

    /**
     * Listener for handling events on option fab's.
     */
    public interface OnActionSelectedListener {
        /**
         * Called when a speed dial action has been clicked.
         *
         * @param actionItem the {@link TermeSpeedDialActionItem} that was selected.
         * @return true to keep the Speed Dial open, false otherwise.
         */
        boolean onActionSelected(TermeSpeedDialActionItem actionItem);
    }

    @Retention(SOURCE)
    @IntDef({TOP, BOTTOM, LEFT, RIGHT})
    public @interface ExpansionMode {
        int TOP = 0;
        int BOTTOM = 1;
        int LEFT = 2;
        int RIGHT = 3;
    }

    private static class InstanceState implements Parcelable {
        private boolean mIsOpen = false;
        @ColorInt
        private int mMainFabClosedBackgroundColor = RESOURCE_NOT_SET;
        @ColorInt
        private int mMainFabOpenedBackgroundColor = RESOURCE_NOT_SET;
        @ColorInt
        private int mMainFabClosedIconColor = RESOURCE_NOT_SET;
        @ColorInt
        private int mMainFabOpenedIconColor = RESOURCE_NOT_SET;
        @ExpansionMode
        private int mExpansionMode = TOP;
        private float mMainFabAnimationRotateAngle = DEFAULT_ROTATE_ANGLE;
        private boolean mUseReverseAnimationOnClose = false;
        private ArrayList<TermeSpeedDialActionItem> mTermeSpeedDialActionItems = new ArrayList<>();

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeByte(this.mIsOpen ? (byte) 1 : (byte) 0);
            dest.writeInt(this.mMainFabClosedBackgroundColor);
            dest.writeInt(this.mMainFabOpenedBackgroundColor);
            dest.writeInt(this.mMainFabClosedIconColor);
            dest.writeInt(this.mMainFabOpenedIconColor);
            dest.writeInt(this.mExpansionMode);
            dest.writeFloat(this.mMainFabAnimationRotateAngle);
            dest.writeByte(this.mUseReverseAnimationOnClose ? (byte) 1 : (byte) 0);
            dest.writeTypedList(this.mTermeSpeedDialActionItems);
        }

        public InstanceState() {
        }

        protected InstanceState(Parcel in) {
            this.mIsOpen = in.readByte() != 0;
            this.mMainFabClosedBackgroundColor = in.readInt();
            this.mMainFabOpenedBackgroundColor = in.readInt();
            this.mMainFabClosedIconColor = in.readInt();
            this.mMainFabOpenedIconColor = in.readInt();
            this.mExpansionMode = in.readInt();
            this.mMainFabAnimationRotateAngle = in.readFloat();
            this.mUseReverseAnimationOnClose = in.readByte() != 0;
            this.mTermeSpeedDialActionItems = in.createTypedArrayList(TermeSpeedDialActionItem.CREATOR);
        }

        public static final Creator<InstanceState> CREATOR = new Creator<InstanceState>() {
            @Override
            public InstanceState createFromParcel(Parcel source) {
                return new InstanceState(source);
            }

            @Override
            public InstanceState[] newArray(int size) {
                return new InstanceState[size];
            }
        };
    }

    /**
     * Behavior designed for use with {@link View} instances. Its main function
     * is to move {@link View} views so that any displayed {@link Snackbar}s do
     * not cover them.
     */
    @SuppressWarnings({"unused", "WeakerAccess"})
    public static class SnackbarBehavior extends CoordinatorLayout.Behavior<View> {
        private static final boolean AUTO_HIDE_DEFAULT = true;

        @Nullable
        private Rect mTmpRect;
        @Nullable
        private OnVisibilityChangedListener mInternalAutoHideListener;
        private boolean mAutoHideEnabled;

        public SnackbarBehavior() {
            super();
            mAutoHideEnabled = AUTO_HIDE_DEFAULT;
        }

        public SnackbarBehavior(Context context, AttributeSet attrs) {
            super(context, attrs);
            //R.styleable.FloatingActionButton_Behavior_Layout
            TypedArray a = context.obtainStyledAttributes(attrs,
                    com.google.android.material.R.styleable.FloatingActionButton_Behavior_Layout

            );
            mAutoHideEnabled = a.getBoolean(
                    com.google.android.material.R.styleable.FloatingActionButton_Behavior_Layout_behavior_autoHide,
                    AUTO_HIDE_DEFAULT);
            a.recycle();
        }

        private static boolean isBottomSheet(@NonNull View view) {
            final ViewGroup.LayoutParams lp = view.getLayoutParams();
            if (lp instanceof CoordinatorLayout.LayoutParams) {
                return ((CoordinatorLayout.LayoutParams) lp)
                        .getBehavior() instanceof BottomSheetBehavior;
            }
            return false;
        }

        /**
         * Returns whether the associated View automatically hides when there is
         * not enough space to be displayed.
         *
         * @return true if enabled
         */
        public boolean isAutoHideEnabled() {
            return mAutoHideEnabled;
        }

        /**
         * Sets whether the associated View automatically hides when there is
         * not enough space to be displayed. This works with {@link AppBarLayout}
         * and {@link BottomSheetBehavior}.
         *
         * @param autoHide true to enable automatic hiding
         */
        public void setAutoHideEnabled(boolean autoHide) {
            mAutoHideEnabled = autoHide;
        }

        @Override
        public void onAttachedToLayoutParams(@NonNull CoordinatorLayout.LayoutParams lp) {
            if (lp.dodgeInsetEdges == Gravity.NO_GRAVITY) {
                // If the developer hasn't set dodgeInsetEdges, lets set it to BOTTOM so that
                // we dodge any Snackbars
                lp.dodgeInsetEdges = Gravity.BOTTOM;
            }
        }

        @Override
        public boolean onDependentViewChanged(CoordinatorLayout parent, View child,
                                              View dependency) {
            if (dependency instanceof AppBarLayout) {
                // If we're depending on an AppBarLayout we will show/hide it automatically
                // if the VIEW is anchored to the AppBarLayout
                updateFabVisibilityForAppBarLayout(parent, (AppBarLayout) dependency, child);
            } else if (isBottomSheet(dependency)) {
                updateFabVisibilityForBottomSheet(dependency, child);
            }
            return false;
        }

        @Override
        public boolean onLayoutChild(CoordinatorLayout parent, View child,
                                     int layoutDirection) {
            // First, let's make sure that the visibility of the VIEW is consistent
            final List<View> dependencies = parent.getDependencies(child);
            for (int i = 0, count = dependencies.size(); i < count; i++) {
                final View dependency = dependencies.get(i);
                if (dependency instanceof AppBarLayout) {
                    if (updateFabVisibilityForAppBarLayout(
                            parent, (AppBarLayout) dependency, child)) {
                        break;
                    }
                } else if (isBottomSheet(dependency)) {
                    if (updateFabVisibilityForBottomSheet(dependency, child)) {
                        break;
                    }
                }
            }
            // Now let the CoordinatorLayout lay out the VIEW
            parent.onLayoutChild(child, layoutDirection);
            return true;
        }

        @VisibleForTesting
        void setInternalAutoHideListener(@Nullable OnVisibilityChangedListener listener) {
            mInternalAutoHideListener = listener;
        }

        protected void show(View child) {
            if (child instanceof FloatingActionButton) {
                ((FloatingActionButton) child).show(mInternalAutoHideListener);
            } else if (child instanceof TermeSpeedDialView) {
                ((TermeSpeedDialView) child).show(mInternalAutoHideListener);
            } else {
                child.setVisibility(View.VISIBLE);
            }
        }

        protected void hide(View child) {
            if (child instanceof FloatingActionButton) {
                ((FloatingActionButton) child).hide(mInternalAutoHideListener);
            } else if (child instanceof TermeSpeedDialView) {
                ((TermeSpeedDialView) child).hide(mInternalAutoHideListener);
            } else {
                child.setVisibility(View.INVISIBLE);
            }
        }

        private boolean shouldUpdateVisibility(View dependency, View child) {
            final CoordinatorLayout.LayoutParams lp =
                    (CoordinatorLayout.LayoutParams) child.getLayoutParams();
            if (!mAutoHideEnabled) {
                return false;
            }

            if (lp.getAnchorId() != dependency.getId()) {
                // The anchor ID doesn't match the dependency, so we won't automatically
                // show/hide the VIEW
                return false;
            }

            //noinspection RedundantIfStatement
            if (child.getVisibility() != VISIBLE) {
                // The view isn't set to be visible so skip changing its visibility
                return false;
            }

            return true;
        }

        private boolean updateFabVisibilityForAppBarLayout(CoordinatorLayout parent,
                                                           AppBarLayout appBarLayout, View child) {
            if (!shouldUpdateVisibility(appBarLayout, child)) {
                return false;
            }

            if (mTmpRect == null) {
                mTmpRect = new Rect();
            }

            // First, let's get the visible rect of the dependency
            final Rect rect = mTmpRect;
            ViewGroupUtils.getDescendantRect(parent, appBarLayout, rect);

            if (rect.bottom <= getMinimumHeightForVisibleOverlappingContent(appBarLayout)) {
                // If the anchor's bottom is below the seam, we'll animate our VIEW out
                //            child.hide(mInternalAutoHideListener);
                child.setVisibility(View.GONE);
            } else {
                // Else, we'll animate our VIEW back in
                //            child.show(mInternalAutoHideListener);
                child.setVisibility(View.VISIBLE);
            }
            return true;
        }

        private int getMinimumHeightForVisibleOverlappingContent(AppBarLayout appBarLayout) {
            int minHeight = ViewCompat.getMinimumHeight(appBarLayout);
            if (minHeight != 0) {
                return minHeight * 2;
            } else {
                int childCount = appBarLayout.getChildCount();
                return childCount >= 1 ? ViewCompat.getMinimumHeight(appBarLayout.getChildAt(childCount - 1)) * 2 : 0;
            }
        }

        private boolean updateFabVisibilityForBottomSheet(View bottomSheet,
                                                          View child) {
            if (!shouldUpdateVisibility(bottomSheet, child)) {
                return false;
            }
            CoordinatorLayout.LayoutParams lp =
                    (CoordinatorLayout.LayoutParams) child.getLayoutParams();
            if (bottomSheet.getTop() < child.getHeight() / 2 + lp.topMargin) {
                hide(child);
            } else {
                show(child);
            }
            return true;
        }
    }

    /**
     * Behavior designed for use with {@link View} instances. Its main function
     * is to move {@link View} views so that any displayed {@link Snackbar}s do
     * not cover them.
     */
    @SuppressWarnings({"unused", "WeakerAccess"})
    public static class ScrollingViewSnackbarBehavior extends SnackbarBehavior {
        private boolean mWasShownAlready = false;

        public ScrollingViewSnackbarBehavior() {
        }

        public ScrollingViewSnackbarBehavior(Context context, AttributeSet attrs) {
            super(context, attrs);
        }

        @Override
        public boolean onStartNestedScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View child, @NonNull
        View directTargetChild, @NonNull View target, int axes, int type) {
            return true;
        }

        @Override
        public boolean layoutDependsOn(CoordinatorLayout parent, View child, View dependency) {
            if (!mWasShownAlready
                    && dependency instanceof RecyclerView
                    && (
                    ((RecyclerView) dependency).getAdapter() == null
                            || ((RecyclerView) dependency).getAdapter().getItemCount() == 0)) {
                show(child);
                mWasShownAlready = true;
            }
            return dependency instanceof RecyclerView || super.layoutDependsOn(parent, child, dependency);
        }

        @Override
        public void onNestedScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View child, @NonNull View
                target, int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed, int type, @NonNull int[] consumed) {
            super.onNestedScroll(coordinatorLayout, child, target, dxConsumed, dyConsumed, dxUnconsumed, dyUnconsumed,
                    type, consumed);
            mWasShownAlready = false;
            if (dyConsumed > 0 && child.getVisibility() == View.VISIBLE) {
                hide(child);
            } else if (dyConsumed < 0) {
                show(child);
            }
        }
    }

    public static class NoBehavior extends CoordinatorLayout.Behavior<View> {
        public NoBehavior() {
        }

        public NoBehavior(Context context, AttributeSet attrs) {
            super(context, attrs);
        }
    }
}