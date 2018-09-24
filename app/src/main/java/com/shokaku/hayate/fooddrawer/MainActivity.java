package com.shokaku.hayate.fooddrawer;

import android.support.annotation.NonNull;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.design.widget.NavigationView;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {
  
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
  
    final DrawerLayout drawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
    NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
  
    Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
    // 用toolbar做為APP的ActionBar
    setSupportActionBar(toolbar);
  
    // 將drawerLayout和toolbar整合，會出現「三」按鈕
    ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this,
            drawerLayout, toolbar, R.string.open, R.string.close);
    drawerLayout.addDrawerListener(actionBarDrawerToggle);
    actionBarDrawerToggle.syncState();
    
    // 為navigationView設置點擊事件
    navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
      @Override
      public boolean onNavigationItemSelected(@NonNull MenuItem item) {
      
        // 點選時收起選單
        drawerLayout.closeDrawer(GravityCompat.START);
      
        // 取得選項id
        int id = item.getItemId();
      
        // 依照id判斷點了哪個項目並做相應事件
        if (id == R.id.menu_drawer) {
          return true;
        }
        else if (id == R.id.menu_list) {
          return true;
        }
        return false;
      }
    });
    
  }
}
