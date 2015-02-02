package cs.ualberta.ca.devito_traveltracker_assignment;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

public class Superlist extends Activity {
	private EditText name;
	private EditText startdate;
	private EditText enddate;
	//private ArrayList<ClaimHolder> claimHolder = new ArrayList<ClaimHolder>();
	final ArrayList<ClaimHolder> claimHolder = ClaimHolderController.getClaimHolderList();
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.changeclaim);


	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.superlist, menu);
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
	
	public void addnewclaim(View v){
		
		//Toast.makeText(this, "Adding an amount", Toast.LENGTH_SHORT).show();
		
		name = (EditText) findViewById(R.id.supernametext);
		String nametext = name.getText().toString();
		startdate = (EditText) findViewById(R.id.superstartdate);
		String startdatetext = startdate.getText().toString();
		enddate = (EditText) findViewById(R.id.superenddate);
		String enddatetext = enddate.getText().toString();
		
		ClaimHolder holder = new ClaimHolder();
		holder.setName(nametext);
		holder.setStart(startdatetext);
		holder.setEnd(enddatetext);
		claimHolder.add(holder);

		ListView claim_View = (ListView) findViewById(R.id.superclaimlist);
		ArrayAdapter<ClaimHolder> claimAdapter = new ArrayAdapter<ClaimHolder>(this, android.R.layout.simple_list_item_1, claimHolder);
		claim_View.setAdapter(claimAdapter);
			

			
		}
}
