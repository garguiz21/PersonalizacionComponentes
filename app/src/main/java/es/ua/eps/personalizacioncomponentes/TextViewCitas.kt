package es.ua.eps.personalizacioncomponentes

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Canvas
import android.util.AttributeSet
import android.view.KeyEvent
import android.view.MotionEvent
import androidx.appcompat.widget.AppCompatTextView

class TextViewCitas : AppCompatTextView {
    var frases = arrayOf("No hay que ir para atrás ni para darse impulso", "No hay caminos para la paz; la paz es el camino", "Para trabajar basta estar convencido de una cosa: que trabajar es menos aburrido que divertirse", "Lo peor que hacen los malos es obligarnos a dudar de los buenos")
    constructor(context: Context?, attrs: AttributeSet?, defStyle: Int)
            : super(context!!, attrs, defStyle)
    constructor(context: Context?, attrs: AttributeSet?) : super(context!!, attrs) {}
    constructor(context: Context?) : super(context!!) {
        this.text = frases[(Math.random() * frases.size).toInt()]

    }

    override fun onDraw(canvas: Canvas?) {
        // Primero dibujamos debajo del texto...
        // Luego mostramos el texto de la manera habitual
        // haciendo uso de la clase base...
        super.onDraw(canvas)

        // Y por último dibujamos cosas por encima del texto
    }

    override fun onKeyDown(keyCode: Int, keyEvent: KeyEvent?): Boolean {
        // Primero realizamos las acciones que sean oportunas
        // según la tecla pulsada...
        // ...y a continuación hacemos también uso de la clase base
        return super.onKeyDown(keyCode, keyEvent)
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        if(event?.action == MotionEvent.ACTION_DOWN){
            val position = (Math.random() * frases.size).toInt()
            this.setText(frases[position])
            return true
        }
        return false
    }


}