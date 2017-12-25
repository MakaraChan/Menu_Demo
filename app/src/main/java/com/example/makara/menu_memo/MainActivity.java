package com.example.makara.menu_memo;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView tv_context_menu;
    Button btn_Context_Button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv_context_menu = findViewById(R.id.tv_Context_Menu);
        Button btn_Context_Button =findViewById(R.id.btn_context);
        registerForContextMenu(tv_context_menu);
        registerForContextMenu(btn_Context_Button);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater= getMenuInflater();
        inflater.inflate(R.menu.option_menu,menu);
        return true;


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.setting:
                this.showMessage("This is setting");
                return true;
            case R.id.search:
                this.showMessage("This is Search");
                return true;
            case R.id.share:
                Intent intent= new Intent(Intent.ACTION_VIEW);
                Uri.parse("https://google.com");
                startActivity(intent);
        }
        this.showMessage("menu item clicked");

        return false;
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        menu.setHeaderTitle("Action");
        if (v.getId()== R.id.tv_Context_Menu){
            inflater.inflate(R.menu.context_menu,menu);
        }else if(v.getId()==R.id.btn_context){
            inflater.inflate(R.menu.context_menu_1,menu);
        }

    }

    public void showMessage(String message){
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show();
    }


    }


