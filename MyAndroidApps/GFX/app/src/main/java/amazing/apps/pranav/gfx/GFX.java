package amazing.apps.pranav.gfx;

import android.animation.Animator;
import android.app.Activity;
import android.os.Bundle;

/**
 * Created by root on 13/10/16.
 */

public class GFX extends Activity{
    Game ourView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gfx);
        ourView = new Game(this);
        setContentView(ourView);
    }
}
