package mchehab.com.bottomnavigationdemo;

import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity{

    private HomeFragment homeFragment = new HomeFragment();
    private RecentFragment recentFragment = new RecentFragment();

    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.bottomNavigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(item -> {
            switch (item.getItemId()){
                case R.id.menuHome: replaceFragment(homeFragment);break;
                case R.id.menuRecent: replaceFragment(recentFragment);break;
            }
            return true;
        });

        bottomNavigationView.setSelectedItemId(R.id.menuHome);
    }

    @Override
    public void onBackPressed() {
        if(bottomNavigationView.getSelectedItemId() == R.id.menuHome){
            super.onBackPressed();
        }else{
            bottomNavigationView.setSelectedItemId(R.id.menuHome);
        }
    }

    private void replaceFragment(Fragment fragment){
        getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, fragment).commit();
    }
}