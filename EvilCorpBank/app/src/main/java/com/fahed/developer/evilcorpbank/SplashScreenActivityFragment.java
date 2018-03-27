package com.fahed.developer.evilcorpbank;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * A placeholder fragment containing a simple view.
 */
public class SplashScreenActivityFragment extends Fragment {
    private View viewRoot;
    private TextView textViewLogin;
    public SplashScreenActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        viewRoot = inflater.inflate(R.layout.fragment_splash_screen, container, false);

        textViewLogin = (TextView) viewRoot.findViewById(R.id.textViewLogin);
        textViewLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goLogin(viewRoot);
            }
        });


        return viewRoot;
    }

    public void goLogin(View rootView) {
        Intent i = new Intent(rootView.getContext(), LoginActivity.class);
        startActivity(i);
    }
}
