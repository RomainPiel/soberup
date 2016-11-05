package com.romainpiel.soberup.utils

import android.content.res.Resources

object Screen {
    fun dpToPx(dp: Int): Float {
        return (dp * Resources.getSystem().getDisplayMetrics().density)
    }
    fun pxToDp(px: Int): Float {
        return (px / Resources.getSystem().displayMetrics.density)
    }
}
