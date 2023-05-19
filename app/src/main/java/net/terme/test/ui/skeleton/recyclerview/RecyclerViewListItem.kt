package net.terme.test.ui.skeleton.recyclerview

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import net.terme.test.R

data class RecyclerViewListItem(
    @StringRes val titleResId: Int,
    @StringRes val descriptionResId: Int,
    @DrawableRes val avatarResId: Int,
    @DrawableRes val wallpaperResId: Int
) {
    companion object {
        val DEMO = listOf(
            RecyclerViewListItem(R.string.user_0_name, R.string.user_0_statement, R.mipmap.ic_launcher, R.mipmap.ic_launcher),
            RecyclerViewListItem(R.string.user_1_name, R.string.user_1_statement, R.mipmap.ic_launcher, R.mipmap.ic_launcher),
            RecyclerViewListItem(R.string.user_2_name, R.string.user_2_statement, R.mipmap.ic_launcher, R.mipmap.ic_launcher)
        )
    }
}