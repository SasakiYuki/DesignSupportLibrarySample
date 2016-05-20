package wacode.yuki.designsupportlibrarysample.kotCode.InputTextLayout

import android.app.Activity
import android.app.ProgressDialog
import android.content.Context
import android.os.Bundle
import android.os.Handler
import android.support.design.widget.Snackbar
import android.text.TextUtils
import android.view.KeyEvent
import android.view.View
import android.view.inputmethod.EditorInfo
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView
import butterknife.bindView

import wacode.yuki.designsupportlibrarysample.R

class ktInputTextActivity : Activity() {

    private val editText_name:EditText by bindView(R.id.editText_name)
    private val editText_mail:EditText by bindView(R.id.editText_mail)
    private val button: Button by bindView(R.id.button)
    private val layout:LinearLayout by bindView(R.id.linearLayout)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kt_input_text)
        setEditNameView()
        button.setOnClickListener { checkLogin() }
    }

    private fun setEditNameView(){
        editText_mail.setOnEditorActionListener(TextView.OnEditorActionListener { textView, i, keyEvent ->
            if(i == 6 && keyEvent == null || keyEvent != null && keyEvent.keyCode == KeyEvent.KEYCODE_ENTER){
                val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                imm.hideSoftInputFromWindow(textView.windowToken,InputMethodManager.HIDE_NOT_ALWAYS)
                checkLogin()
                return@OnEditorActionListener true
            }else{
                return@OnEditorActionListener false
            }
        })
    }

    private fun checkLogin(){
        resetErrors()

        val name = editText_name.text.toString()
        val mail = editText_mail.text.toString()

        var errorView:View = editText_name
        var isCancel = false

        if(!TextUtils.isEmpty(name) && !isNameValid(name)){
            editText_name.error = resources.getText(R.string.input_error_name)
            errorView = editText_name
            isCancel = true
        }

        if(TextUtils.isEmpty(mail)){
            editText_mail.error = resources.getText(R.string.input_error_mail)
            errorView = editText_mail
            isCancel = true
        }else if(!isEmailValid(mail)){
            editText_mail.error = resources.getText(R.string.input_error_mail2)
            errorView = editText_mail
            isCancel = true
        }

        if(isCancel){
            errorView.requestFocus()
        }else{
            //Start Sync!!
            val loginProgressDialog = ProgressDialog(this)
            loginProgressDialog.show()
            Handler().postDelayed(Runnable {
                loginProgressDialog.dismiss()
                Snackbar.make(layout,"Completed!!",Snackbar.LENGTH_SHORT).show()
            },2000)
        }
    }

    private fun resetErrors(){
        editText_name.error = null
        editText_mail.error = null
    }
    private fun isNameValid(name:String) = name.length >= 4;
    private fun isEmailValid(mail:String) = mail.contains("@gmail.com")

}
