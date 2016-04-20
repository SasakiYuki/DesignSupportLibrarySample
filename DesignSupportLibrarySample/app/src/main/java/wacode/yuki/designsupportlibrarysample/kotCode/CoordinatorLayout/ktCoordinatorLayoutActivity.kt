package wacode.yuki.designsupportlibrarysample.kotCode.CoordinatorLayout

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.KeyEvent
import android.widget.Button
import butterknife.bindView

import wacode.yuki.designsupportlibrarysample.R
import wacode.yuki.designsupportlibrarysample.kotCode.CoordinatorLayout.Container.CoordinatorContainer

class ktCoordinatorLayoutActivity : AppCompatActivity() {

    val button1:Button by bindView(R.id.button1)
    val button2:Button by bindView(R.id.button2)
    val button3:Button by bindView(R.id.button3)

    private var container:CoordinatorContainer? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kt_coordinator_layout)
        container = findViewById(R.id.container) as CoordinatorContainer
        container!!.showEA()
        setButton()
    }

    private fun setButton(){
        button1.setOnClickListener { container!!.showEA() }
        button2.setOnClickListener { container!!.showEAC() }
        button3.setOnClickListener { container!!.showEUC() }
    }

    fun getContainer():CoordinatorContainer?{
        return container
    }

    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        if(keyCode == KeyEvent.KEYCODE_BACK) {
            if (container!!.leadTheEnd()) {
                finish()
                return false
            } else {
                container!!.showButtonLayout()
                return true
            }
        }
        return false
    }
}
