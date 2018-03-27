package com.fahed.developer.evilcorpbank;

import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

/**
 * A placeholder fragment containing a simple view.
 */
public class LoginActivityFragment extends Fragment {
    private View viewRoot;
    private EditText editTextEmail;
    private EditText editTextPassword;
    private Button buttonLogin;
    public LoginActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        viewRoot = inflater.inflate(R.layout.fragment_login, container, false);
        buttonLogin = (Button) viewRoot.findViewById(R.id.buttonLogin);

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editTextEmail =  (EditText) viewRoot.findViewById(R.id.editTextMail);
                editTextPassword = (EditText) viewRoot.findViewById(R.id.editTextPassword);
                if(editTextEmail.getText().toString().trim().length()>0 &&
                        editTextPassword.getText().toString().trim().length()>0  ){
                    if(editTextEmail.getText().toString().trim().equals("admin@gmail.com") &&
                            editTextPassword.getText().toString().trim().equals("admin")){
                        navigationToMenu();
                    }else{
                        Snackbar.make(viewRoot, R.string.snackbar_account_error_login, Snackbar.LENGTH_LONG).show();
                    }

                }else{
                    Snackbar.make(viewRoot, R.string.snackbar_error_login, Snackbar.LENGTH_LONG).show();
                }
            }
        });

        return viewRoot;
    }

    public void navigationToMenu() {
        startActivity(new Intent(getContext(), LateralMenuActivity.class));
        getActivity().finish();
    }

}
