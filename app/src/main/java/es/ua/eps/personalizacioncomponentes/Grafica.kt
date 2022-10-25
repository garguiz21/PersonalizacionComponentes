package es.ua.eps.personalizacioncomponentes

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.RectF
import android.util.AttributeSet
import android.view.View

class Grafica : View {
    var paint = Paint(Paint.ANTI_ALIAS_FLAG)
    var rectF = RectF(0F, 0F, 100F, 100F)
    var percentage = 360F
    constructor(context: Context?) : super(context!!) { inicializar(null) }
    constructor(context: Context?, attrs: AttributeSet?, defStyle: Int) : super(context!!, attrs, defStyle) { inicializar(attrs) }
    constructor(context: Context?, attrs: AttributeSet?) : super(context!!, attrs) { inicializar(attrs) }

    private fun inicializar(attrs: AttributeSet?) {
        if (attrs == null) return
        val ta = context.obtainStyledAttributes(
            attrs, R.styleable.Grafica )
        this.percentage = ta.getFloat(R.styleable.Grafica_percentage, 100F) * 3.6F
    }

    fun setProgress(progress: Float){
        this.percentage = progress
        this.invalidate()
    }
    override fun onDraw(canvas: Canvas?) {
        // Definir cómo dibujar el componente
        rectF.right = canvas?.clipBounds?.width()?.toFloat() ?: 100F
        rectF.bottom = canvas?.clipBounds?.width()?.toFloat() ?: 100F
        paint.color = Color.RED
        canvas?.drawArc(rectF, 0F, percentage, true, paint)

        paint.color = Color.BLUE
        canvas!!.drawArc(rectF, percentage, 360F - percentage, true, paint)
    }
    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        val widthMode = MeasureSpec.getMode(widthMeasureSpec)
        val widthSize = MeasureSpec.getSize(widthMeasureSpec)
        val heightMode = MeasureSpec.getMode(heightMeasureSpec)
        val heightSize = MeasureSpec.getSize(heightMeasureSpec)
        var width = 100
        var height = 100
        when (heightMode) {
            MeasureSpec.EXACTLY -> height = heightSize
            MeasureSpec.AT_MOST -> if (height > heightSize) height = heightSize
        }
        when (widthMode) {
            MeasureSpec.EXACTLY -> {
                width = widthSize
                height = widthSize
            }
            MeasureSpec.AT_MOST -> if (width > widthSize) {
                width = widthSize
                height = widthSize
            }
        }
        setMeasuredDimension(width, height)
    }
}