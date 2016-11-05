package com.romainpiel.soberup.ui.widget

import android.content.Context
import android.graphics.Canvas
import android.graphics.Path
import android.graphics.RectF
import android.util.AttributeSet
import android.widget.FrameLayout
import com.romainpiel.soberup.R

class RoundedFrameLayout : FrameLayout {
    internal val path: Path = Path()
    internal var cornerRadii: FloatArray = FloatArray(8)

    constructor(context: Context) : super(context) {
        init(null);
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        init(attrs);
    }

    constructor(context: Context, attrs: AttributeSet, defStyle: Int) : super(context, attrs, defStyle) {
        init(attrs);
    }

    fun init(attrs: AttributeSet?) {
        if (attrs != null) {
            val a = context.obtainStyledAttributes(attrs, R.styleable.RoundedFrameLayout, 0, 0)
            val cornerRadius = a.getDimensionPixelSize(R.styleable.RoundedFrameLayout_cornerRadius, 0)
            val cornerRadiusSide = a.getInteger(R.styleable.RoundedFrameLayout_cornerRadiusSide, 0)
            setCornerRadii(cornerRadius.toFloat(), cornerRadiusSide)
            a.recycle()
        }
        setWillNotDraw(false)
    }

    internal fun setCornerRadii(cornerRadius: Float, cornerRadiusSide: Int) {
        for (i in 0..7) {
            if (i < 4) {
                cornerRadii[i] = if (cornerRadiusSide == 1) cornerRadius else 0F
            } else {
                cornerRadii[i] = if (cornerRadiusSide == 2) cornerRadius else 0F
            }
        }
    }

    override fun draw(canvas: Canvas) {
        canvas.save()
        canvas.clipPath(path)
        super.draw(canvas)
        canvas.restore()
    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        val r = RectF(0F, 0F, w.toFloat(), h.toFloat())
        path.reset()
        path.addRoundRect(r, cornerRadii, Path.Direction.CW)
        path.close()
    }
}