package cs.ualberta.ca.devito_traveltracker_assignment;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

public class Viewclaimactivity extends Activity {
	private TextView claimText = null;
	private Spinner catSpin;
	private Spinner statSpin;
	private TextView dateText = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.claim_view);
		
		TextView claimview;
		Intent intent = getIntent();
		Claim gotClaim = (Claim) intent.getSerializableExtra("passClaim");
		//int pos = (Integer) intent.getSerializableExtra("position");
		claimText = (TextView) findViewById(R.id.editClaim);
		claimText.setText(gotClaim.getName());
		catSpin = (Spinner) findViewById(R.id.editcatpinner);
		catSpin.setSelection(getIndex(catSpin,gotClaim.getCategory()));
		
		ListView listView = (ListView) findViewById(R.id.amount_listview);
		//Claim claim = ClaimListController.getClaimList().getClaimList().get(pos);
		final ArrayList<Amount> list = gotClaim.getAmountsList();
		ArrayAdapter<Amount> amountAdapter = new ArrayAdapter<Amount>(this, android.R.layout.simple_list_item_1, list);
		listView.setAdapter(amountAdapter);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.viewclaimactivity, menu);
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
	//Got from
	//http://www.mysamplecode.com/2012/11/android-spinner-set-selected-item-by-value.html
	//2/2/2015
	private int getIndex(Spinner spinner, String myString){
		 
		  int index = 0;
		 
		  for (int i=0;i<spinner.getCount();i++){
		   if (spinner.getItemAtPosition(i).equals(myString)){
		    index = i;
		   }
		  }
		  return index;
		 }
}
