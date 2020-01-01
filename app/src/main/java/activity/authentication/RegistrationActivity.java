package activity.authentication;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;

import com.example.onlineserviceportal.R;
import com.example.onlineserviceportal.databinding.ActivityRegistrationBinding;

import activity.basic.BaseApp;
import activity.home.HomePageTabActivity;

public class RegistrationActivity extends BaseApp {

    ActivityRegistrationBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_registration);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_registration);
        setSupportActionBar(binding.toolbar);

        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        check();
        buttonClick();

    }

    public void check() {
        binding.registration.fname2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (editable.toString().equals("")) {
                    binding.registration.fname.setError("Required");
                } else
                    binding.registration.fname.setError(null);
            }
        });

        binding.registration.lname2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (editable.toString().equals("")) {
                    binding.registration.lname.setError("Required");
                } else
                    binding.registration.lname.setError(null);
            }
        });

        binding.registration.email2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                String email = binding.registration.email2.getEditableText().toString().trim();
                String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
                if (!email.matches(emailPattern)) {
                    binding.registration.email.setError("Email format not valid");
                } else
                    binding.registration.email.setError(null);
            }
        });

        binding.registration.pass2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (binding.registration.pass2.getText().toString().equals("")) {
                    binding.registration.pass.setError("required");
                } else
                    binding.registration.pass.setError(null);
            }
        });

        binding.registration.cpass2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                String pass = binding.registration.pass2.getText().toString();
                if (!pass.equals(binding.registration.cpass2.getText().toString())) {
                    binding.registration.cpass.setError("Pasword not matches");
                } else
                    binding.registration.cpass.setError(null);
            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (binding.registration.cpass2.getText().toString().equals("")) {
                    binding.registration.cpass.setError("required");
                }
            }
        });

        binding.registration.mobile2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (!(charSequence.length() == 10)) {
                    binding.registration.mobile.setError("Mobile number must have 10 number");
                } else
                    binding.registration.mobile.setError(null);
            }

            @Override
            public void afterTextChanged(Editable editable) {
            }
        });

    }

    public void buttonClick() {
        binding.registration.sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (binding.registration.fname2.getText().toString().equals("") ||
                        binding.registration.lname2.getText().toString().equals("") || binding.registration.email2.getText().toString().equals("") ||
                        binding.registration.pass2.getText().toString().equals("") || binding.registration.cpass2.getText().toString().equals("") ||
                        binding.registration.mobile2.getText().toString().equals(""))
                {
                    if (binding.registration.fname2.getText().toString().equals(""))
                    {
                        binding.registration.fname.setError("Require");
                    }
                    if (binding.registration.lname2.getText().toString().equals(""))
                    {
                        binding.registration.lname.setError("Require");
                    }
                    if (binding.registration.email2.getText().toString().equals(""))
                    {
                        binding.registration.email.setError("Require");
                    }
                    if (binding.registration.pass2.getText().toString().equals(""))
                    {
                        binding.registration.pass.setError("Require");
                    }
                    if (binding.registration.cpass2.getText().toString().equals(""))
                    {
                        binding.registration.cpass.setError("Require");
                    }
                    if (binding.registration.mobile2.getText().toString().equals(""))
                    {
                        binding.registration.mobile.setError("Require");
                    }
                }
                else
                {
                    binding.registration.fname.setError(null);
                    binding.registration.lname.setError(null);
                    binding.registration.email.setError(null);
                    binding.registration.pass.setError(null);
                    binding.registration.cpass.setError(null);
                    binding.registration.mobile.setError(null);
                    Intent i = new Intent(getApplicationContext(), VerifyOTPActivity.class);
                    startActivity(i);
                }
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }

    }

}
