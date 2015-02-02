package cs.ualberta.ca.devito_traveltracker_assignment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        Button View_Edit_Button = (Button) findViewById(R.id.vieweditbutton);
        View_Edit_Button.setOnClickListener(new View.OnClickListener() {
  
			public void onClick(View v) {
				setResult(RESULT_OK);
				Intent intent = new Intent(MainActivity.this, VieworEditActivity.class);
				startActivity(intent);
			}
		});
        
        Button add_button = (Button) findViewById(R.id.addbutton);
        add_button.setOnClickListener(new View.OnClickListener() {
  
			public void onClick(View v) {
				setResult(RESULT_OK);
				Intent intent = new Intent(MainActivity.this, AddClaimActivity.class);
				startActivity(intent);
			}
		});
        
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    
}
