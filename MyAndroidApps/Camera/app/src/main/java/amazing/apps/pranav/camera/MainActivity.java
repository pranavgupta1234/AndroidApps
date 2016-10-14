package amazing.apps.pranav.camera;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;

public class MainActivity extends Activity implements View.OnClickListener {
    ImageButton ib;
    ImageView iv;
    Button b;
    Intent i;
    final static int cameraData = 0;
    Bitmap bmp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialise();
        InputStream is = getResources().openRawResource(R.drawable.wall);
        bmp = BitmapFactory.decodeStream(is);
    }

    private void initialise() {
        ib=(ImageButton)findViewById(R.id.takePic);
        iv=(ImageView)findViewById(R.id.returnPic);
        b=(Button)findViewById(R.id.setWall);
        b.setOnClickListener(this);
        ib.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.takePic:
                  i= new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                   startActivityForResult(i,cameraData);
                              break;
            case R.id.setWall:
                try {
                    getApplicationContext().setWallpaper(bmp);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode==RESULT_OK){
            Bundle extras = data.getExtras();
            bmp =(Bitmap)extras.get("data");
            iv.setImageBitmap(bmp);
        }
    }
}
