package amazing.apps.pranav.list;


import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Created by root on 8/10/16.
 */

public class Menu extends ListActivity {
    String classes[] ={"VPN Settings","textPlay","Hotspot and Tethering Setup","Bluetooth Tethering","WLAN Setup","WPA Settings",
              "WEP Security","Cryptography","Temperature Settings","Android Manifestation","Main Content","CryptoAnalysis","MD-5"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setListAdapter(new ArrayAdapter<String>(Menu.this,android.R.layout.simple_expandable_list_item_1,classes));
    }
    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        String selected = classes[position];
        try{
            Class ourClass = Class.forName("amazing.apps.pranav.list."+ selected);
            Intent ourIntent = new Intent(Menu.this,ourClass);
            startActivity(ourIntent);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
