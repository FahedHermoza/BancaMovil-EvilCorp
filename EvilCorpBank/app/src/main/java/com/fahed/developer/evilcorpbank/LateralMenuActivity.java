package com.fahed.developer.evilcorpbank;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class LateralMenuActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private Fragment fragment = null;
    private static final String KEY_FRAGMENT = "com.fahed.developer.evilcorpbank.keyFragment";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lateral_menu);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.nav_header_main,null);
        TextView tvEmail= (TextView ) view.findViewById(R.id.tvEmail);
        tvEmail.setText("admin@gmail.com");
        navigationView.addHeaderView(view);

        navigationView.setNavigationItemSelectedListener(this);
        changePage(R.id.navigation_menu_account);
        navigationView.setCheckedItem(R.id.navigation_menu_account);
    }

    private  void changePage(int id){
        if (id == R.id.navigation_sign_off) {
            startActivity(new Intent(getBaseContext(), LoginActivity.class));
            finish();
        }else {
            if (id == R.id.navigation_menu_account) {
                fragment = new AccountFragment();
                setTitle(getResources().getString(R.string.title_menu_account));
            } else if (id == R.id.navigation_menu_operations) {
                fragment = new OperationFragment();
                setTitle(getResources().getString(R.string.title_menu_operations));
            }
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, fragment).commitNow();

            DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
            drawer.closeDrawer(GravityCompat.START);
        }
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        changePage(item.getItemId());
        return true;
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        //super.onSaveInstanceState(outState);
        getSupportFragmentManager().putFragment(outState, KEY_FRAGMENT, fragment);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        //super.onRestoreInstanceState(savedInstanceState);
        fragment = getSupportFragmentManager().getFragment(savedInstanceState, KEY_FRAGMENT);
    }

}
