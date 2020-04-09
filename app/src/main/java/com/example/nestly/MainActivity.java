package com.example.nestly;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentTransaction;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.renderscript.Sampler;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.navigation.NavigationView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import androidx.appcompat.widget.Toolbar;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private NavigationView navView;
    private View navHeader;
    private DrawerLayout myDrawerLayout;
    private Toolbar myBar;
    private ActionBarDrawerToggle toggle;
    private TextView myName;
    private TextView myYear;
    private SharedPreferences myPrefs;

    private FirebaseDatabase myBase;
    private DatabaseReference dbref;
    private DatabaseReference profilesRef;
    private ValueEventListener listener;
    private ArrayList<User> profiles;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myPrefs = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        boolean loggedIn = myPrefs.getBoolean("loggedIn", false);

        if (!loggedIn) {
            startActivity(new Intent(this, StartActivity.class));
            SharedPreferences.Editor peditor = myPrefs.edit();
            peditor.putBoolean("loggedIn", true);
            peditor.commit();
        }

        profiles = new ArrayList<User>();

        // Firebase database and references
        myBase = FirebaseDatabase.getInstance();
        dbref = myBase.getReference();
        profilesRef = dbref.child("profiles");
        listener = new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot snap : dataSnapshot.getChildren()) {
                    Object curUser = snap.getValue();
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        };
        profilesRef.addListenerForSingleValueEvent(listener);


        // Set action bar title
        myBar = findViewById(R.id.main_bar);
        myBar.setTitle("Home");

        // Navigation View
        navView = findViewById(R.id.nav_view);
        navHeader = navView.getHeaderView(0);
        navView.setNavigationItemSelectedListener(this);
        navView.bringToFront();
        myDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        toggle = new ActionBarDrawerToggle(this, myDrawerLayout, myBar,
               0, 0);
        toggle.setDrawerIndicatorEnabled(true);
        myDrawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        // set to what the user entered during signup
        myName = (TextView) navHeader.findViewById(R.id.my_name);
        myYear = (TextView) navHeader.findViewById(R.id.my_year);
        String name = myPrefs.getString("name", "John Doe");
        String year = myPrefs.getString("year", "2022");
        myName.setText(name);
        myYear.setText("Class of " + year);

        // Initialize grid view fragment
        GridFragment myGridFrag = new GridFragment();
        FragmentTransaction tr = getSupportFragmentManager().beginTransaction();
        tr.replace(R.id.home_frag, myGridFrag);
        tr.addToBackStack(null);
        tr.commit();
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int myID = item.getItemId();
        FragmentTransaction tr = getSupportFragmentManager().beginTransaction();
        if (myID == R.id.home_tab) {
            // Do nothing
        }
        else if (myID == R.id.my_profile_tab) {
            startActivity(new Intent(this, MyProfileActivity.class));
        }
        else if (myID == R.id.favorites_tab) {
            // Change to Favorites fragment
            myBar.setTitle("Favorites");
            FavoritesFragment myFavsFrag = new FavoritesFragment();
            tr.replace(R.id.home_frag, myFavsFrag);
            tr.addToBackStack(null);
            tr.commit();
        }
        else if (myID == R.id.logout_tab) {
            SharedPreferences.Editor peditor = myPrefs.edit();
            peditor.putBoolean("loggedIn", false);
            peditor.commit();
            startActivity(new Intent(this, StartActivity.class));
        }
        else if (myID == R.id.hide_acc_tab) {

        }
        else if (myID == R.id.delete_acc_tab) {

        }

        myDrawerLayout.closeDrawers();
        return true;
    }

    void viewProfile(int pos) {
        Intent intent = new Intent(this, ViewProfileActivity.class);
        startActivity(intent);
    }
}

