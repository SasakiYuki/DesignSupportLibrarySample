package wacode.yuki.designsupportlibrarysample.kotCode.Snackbar

import android.app.Activity
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.view.View
import android.widget.Button
import butterknife.bindView

import wacode.yuki.designsupportlibrarysample.R

class ktSnackBarActivity : Activity() {
    val button:Button by bindView(R.id.button_show)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kt_snack_bar)
        button.setOnClickListener { UseSnackBar() }
    }

    private fun UseSnackBar(){
        val layout = findViewById(R.id.coordinatorLayout)
        val message = "Hello Snackbar"
        Snackbar.make(layout,message,Snackbar.LENGTH_SHORT).
                setAction("UNDO", View.OnClickListener {
                }).
                show()
    }
}
