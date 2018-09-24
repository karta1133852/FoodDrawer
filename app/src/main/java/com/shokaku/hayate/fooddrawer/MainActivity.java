package com.shokaku.hayate.fooddrawer;

import android.support.annotation.NonNull;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.design.widget.NavigationView;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
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
  
  //建立右上方選單
  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    // Inflate the menu; this adds items to the action bar if it is present.
    getMenuInflater().inflate(R.menu.bar_menu, menu);
    return true;
  }
  //選項設定
  @Override
  public boolean onOptionsItemSelected(MenuItem item) {
    // Handle action bar item clicks here. The action bar will
    // automatically handle clicks on the Home/Up button, so long
    // as you specify a parent activity in AndroidManifest.xml.
    int id = item.getItemId();
    
    //noinspection SimplifiableIfStatement
    switch ( id ) {
      
      case R.id.action_backup:
        return true;
      
      case R.id.action_recovery:
        return true;
      
      case R.id.action_setInit:
        return true;
      
      case R.id.action_settings:
        return true;
    }
    
    return super.onOptionsItemSelected(item);
  }
  
}
