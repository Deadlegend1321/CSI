package com.example.mudit.csi;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toolbar;

public class Main2Activity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    DrawerLayout ac;
    ActionBarDrawerToggle mt;
    android.support.v7.widget.Toolbar t;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        t=(android.support.v7.widget.Toolbar)findViewById(R.id.t);
        ac=(DrawerLayout)findViewById(R.id.ac);
        NavigationView nv=findViewById(R.id.nv);
        nv.setNavigationItemSelectedListener(this);
        mt=new ActionBarDrawerToggle(this,ac,t,R.string.OPEN,R.string.CLOSE);
        ac.addDrawerListener(mt);
        mt.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id=item.getItemId();
        if (id==R.id.p)
        {
            getSupportFragmentManager().beginTransaction().replace(R.id.frag,new photo()).commit();
        }
        else if (id==R.id.l)
        {
            Intent k = new Intent(Main2Activity.this, MainActivity.class);
            startActivity(k);
        }
        ac.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onBackPressed() {
        if (ac.isDrawerOpen(GravityCompat.START))
        {
            ac.closeDrawer(GravityCompat.START);
        }

        super.onBackPressed();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (mt.onOptionsItemSelected(item))
            return true;
        return super.onOptionsItemSelected(item);
    }
}
