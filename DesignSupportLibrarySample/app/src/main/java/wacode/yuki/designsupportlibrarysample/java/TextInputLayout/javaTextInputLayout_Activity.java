package wacode.yuki.designsupportlibrarysample.java.TextInputLayout;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import wacode.yuki.designsupportlibrarysample.R;

/**
 * Created by Riberd on 2016/04/15.
 */
public class javaTextInputLayout_Activity extends AppCompatActivity{
    private EditText mEditText_name;
    private EditText mEditTet_mail;
    private EditText mEditText_pass;
    private TextInputLayout mTextInputLayout_name;
    private TextInputLayout mTextInputLayout_mail;
    private TextInputLayout mTextInputLayout_pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_input_layout);
        setViews();
    }
    private void setViews(){
        Toolbar toolbar = (Toolbar)findViewById(R.id.toolBar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mEditText_name = (EditText)findViewById(R.id.editText_name);
        mEditTet_mail = (EditText)findViewById(R.id.editText_mail);
        mEditText_pass = (EditText)findViewById(R.id.editText_pass);
        mTextInputLayout_name = (TextInputLayout)findViewById(R.id.textInputLayout_name);
        mTextInputLayout_mail = (TextInputLayout)findViewById(R.id.textInputLayout_mail);
        mTextInputLayout_pass = (TextInputLayout)findViewById(R.id.textInputLayout_pass);
        Button button = (Button)findViewById(R.id.buttonSignUp);

        mEditText_name.addTextChangedListener(new Custom_TextWatcher(mEditText_name));
        mEditTet_mail.addTextChangedListener(new Custom_TextWatcher(mEditTet_mail));
        mEditText_pass.addTextChangedListener(new Custom_TextWatcher(mEditText_pass));
        button.setOnClickListener(click);
    }

    private boolean validateName(){
        if (mEditText_name.getText().toString().isEmpty()){
            mTextInputLayout_name.setError(getString(R.string.name_error_message));
            return false;
        }else {
            mTextInputLayout_name.setErrorEnabled(false);
        }
        return true;
    }

    private boolean validateEmail() {
        String email = mEditTet_mail.getText().toString();

        if (email.isEmpty() || !isValidEmail(email)) {
            mTextInputLayout_mail.setError(getString(R.string.mail_error_message));
            return false;
        } else {
            mTextInputLayout_mail.setErrorEnabled(false);
        }
        return true;
    }

    private boolean validatePass(){
        if (mEditText_pass.getText().toString().isEmpty()){
            mTextInputLayout_pass.setError(getString(R.string.pass_error_message));
            return false;
        }else {
            mTextInputLayout_pass.setErrorEnabled(false);
        }
        return true;
    }

    private static boolean isValidEmail(String email) {
        return !TextUtils.isEmpty(email) && android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }

    private View.OnClickListener click = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (!validateName()){
                return;
            }
            if (!validateEmail()){
                return;
            }
            if (!validatePass()){
                return;
            }

            Snackbar.make(v, getString(R.string.inputLayout_snac_message) + "　" + mEditText_name.getText().toString(), Snackbar.LENGTH_SHORT)
                    .setAction("Action", null).show();
        }
    };

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }


    public class Custom_TextWatcher implements TextWatcher {
        private View m_v;
        public Custom_TextWatcher(View v){
            m_v = v;
        }
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {}

        @Override
        public void afterTextChanged(Editable s) {
            switch (m_v.getId()){
                case R.id.editText_name:
                    //please write your code
                    break;
                case R.id.editText_mail:
                    validateEmail();
                    break;
                case R.id.editText_pass:
                    //please write your code
                    break;

            }
        }
    }
}


