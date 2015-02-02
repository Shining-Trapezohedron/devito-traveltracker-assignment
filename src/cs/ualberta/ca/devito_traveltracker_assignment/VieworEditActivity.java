package cs.ualberta.ca.devito_traveltracker_assignment;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
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

public class VieworEditActivity extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.vieworedit_listview);
		ListView listView = (ListView) findViewById(R.id.claimlistview);
		final ArrayList<Claim> claimlist = ClaimListController.getClaimList().getClaimList();
		final ArrayList<Claim> list = new ArrayList<Claim>(claimlist);
		ArrayAdapter<Claim> claimAdapter = new ArrayAdapter<Claim>(this, android.R.layout.simple_list_item_1, list);
		listView.setAdapter(claimAdapter);
		
		listView.setOnItemClickListener(new OnItemClickListener(){
			

			
			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				//This section inspired by http://stackoverflow.com/a/7923530
				//2/1/2015
				//Toast.makeText(VieworEditActivity.this, String.valueOf(position), Toast.LENGTH_SHORT).show();
				Intent intent = new Intent(VieworEditActivity.this, Viewclaimactivity.class);
				intent.putExtra("passClaim", claimlist.get(position));
				startActivity(intent);
				
			}

			
		});
		
		
		listView.setOnItemLongClickListener(new OnItemLongClickListener(){

			@Override
			public boolean onItemLongClick(AdapterView<?> parent, View view,
					int position, long id) {
				Toast.makeText(VieworEditActivity.this, "Delete "+ list.get(position).toString(), 
					Toast.LENGTH_SHORT).show();	
				Claim claim = list.get(position);
				ClaimListController.getClaimList().removeClaim(claim);
				VieworEditActivity.this.recreate();
					
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
	
}
