package wacode.yuki.designsupportlibrarysample.kotCode.FloatActionButton

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import butterknife.bindView

import wacode.yuki.designsupportlibrarysample.R

class ktFABActivity : AppCompatActivity() {
    private val toolbar: Toolbar by bindView(R.id.toolbar)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kt_fab)

        initToolbar()
    }

    private fun initToolbar(){
        setSupportActionBar(toolbar)
    }

}
