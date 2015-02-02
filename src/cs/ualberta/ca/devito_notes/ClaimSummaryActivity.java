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

import java.util.ArrayList;

import cs.ualberta.ca.devito_notes.R;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class ClaimSummaryActivity extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.vieworedit_listview);
		ListView listView = (ListView) findViewById(R.id.claimlistview);
		final ArrayList<Expense> claimlist = ExpenseListController.getClaimList().getClaimList();
		final ArrayList<Expense> list = new ArrayList<Expense>(claimlist);
		ArrayAdapter<Expense> claimAdapter = new ArrayAdapter<Expense>(this, android.R.layout.simple_list_item_1, list);
		listView.setAdapter(claimAdapter);
		
		listView.setOnItemClickListener(new OnItemClickListener(){
			

			
			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				//This section inspired by http://stackoverflow.com/a/7923530
				//2/1/2015
				//Toast.makeText(VieworEditActivity.this, String.valueOf(position), Toast.LENGTH_SHORT).show();
				Intent intent = new Intent(ClaimSummaryActivity.this, ViewAndEditExpenseActivity.class);
				intent.putExtra("passClaim", claimlist.get(position));
				startActivity(intent);
				
			}

			
		});
		
		
		listView.setOnItemLongClickListener(new OnItemLongClickListener(){

			@Override
			public boolean onItemLongClick(AdapterView<?> parent, View view,
					int position, long id) {
				Toast.makeText(ClaimSummaryActivity.this, "Delete "+ list.get(position).toString(), 
					Toast.LENGTH_SHORT).show();	
				Expense claim = list.get(position);
				ExpenseListController.getClaimList().removeClaim(claim);
				ClaimSummaryActivity.this.recreate();
					
				return false;
			}
			
		});
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.viewor_edit, menu);
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
	public void sendemailaction(View v){
		//Taken from http://stackoverflow.com/a/8284804
		//By Igor Popov
		//Written on Nov 27 '11
		//2/2/2015
		Intent send = new Intent(Intent.ACTION_SENDTO);
		String uriText = "mailto:" + Uri.encode("email@gmail.com") + 
		          "?subject=" + Uri.encode("the subject") + 
		          "&body=" + Uri.encode("the body of the message");
		Uri uri = Uri.parse(uriText);

		send.setData(uri);
		startActivity(Intent.createChooser(send, "Send mail..."));
	}
	
}
