package es.ua.eps.personalizacioncomponentes

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import android.widget.SeekBar
import android.widget.SeekBar.OnSeekBarChangeListener


class GraficaLayout: LinearLayout {
    var grafica: Grafica? = null
    var seekBar: SeekBar? = null

    constructor(context: Context?) : super(context!!) {inicializar()}
    constructor(ctx: Context?, atts: AttributeSet?)
            : super(ctx, atts) {
        inicializar()
    }

    private fun inicializar() {
        // Creamos la interfaz a partir del layout
        val li = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        li.inflate(R.layout.grafica, this, true)

        // Obtenemos las referencias a las vistas hijas
        grafica = findViewById(R.id.grafica)
        seekBar = findViewById(R.id.seekBar)
        seekBar?.setOnSeekBarChangeListener(SeekBarChangeListener())

    }
    inner class SeekBarChangeListener: OnSeekBarChangeListener{
        override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
            grafica?.setProgress(progress * 3.6F)
        }

        override fun onStartTrackingTouch(seekBar: SeekBar?) {
        }

        override fun onStopTrackingTouch(seekBar: SeekBar?) {
        }

    }
}