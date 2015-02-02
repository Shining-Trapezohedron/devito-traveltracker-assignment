/*
   A simple Claim/Expense tracking program by James Devito

    Copyright (C) 2015  James Devito

    This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with this program.  If not, see <http://www.gnu.org/licenses/>.
    */
package cs.ualberta.ca.devito_notes;

import cs.ualberta.ca.devito_notes.R;
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
				Intent intent = new Intent(MainActivity.this, ClaimSummaryActivity.class);
				startActivity(intent);
			}
		});
        
        Button add_button = (Button) findViewById(R.id.addbutton);
        add_button.setOnClickListener(new View.OnClickListener() {
  
			public void onClick(View v) {
				setResult(RESULT_OK);
				Intent intent = new Intent(MainActivity.this, AddExpenseActivity.class);
				startActivity(intent);
			}
		});
        
        Button claimbutton = (Button) findViewById(R.id.changeclaimbutton);
        claimbutton.setOnClickListener(new View.OnClickListener() {
  
			public void onClick(View v) {
				setResult(RESULT_OK);
				Intent intent = new Intent(MainActivity.this, ClaimHolderActivity.class);
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
    public void gotosuperlist(){
    	Intent i = new Intent(MainActivity.this,ClaimHolderActivity.class);
    	startActivity(i);
    }
}
