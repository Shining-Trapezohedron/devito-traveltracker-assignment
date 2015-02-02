package cs.ualberta.ca.devito_traveltracker_assignment;

import java.util.ArrayList;
import java.util.Collection;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class AddClaimActivity extends Activity {
	protected Spinner category_spinner;
	protected Spinner status_spinner;
	private EditText claimText;
	private EditText descText;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.add_claim);
		

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.add_claim, menu);
		
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
		public void addListenerOnSpinnerItemSelection() {
		category_spinner = (Spinner) findViewById(R.id.type_spinner);
		category_spinner.setOnItemSelectedListener(new SpinnerSelectedListener());
		
		status_spinner = (Spinner) findViewById(R.id.status_spinner);
		status_spinner.setOnItemSelectedListener(new SpinnerSelectedListener());
		  }
		 
	public boolean isAlpha(String name) {
		//http://stackoverflow.com/questions/4531396/get-value-of-a-edit-text-field
		//2/1/2015
	    char[] chars = name.toCharArray();
        if(name.isEmpty()){
        	return false;
        }
	    for (char c : chars) {
	        if(!Character.isLetter(c) && !Character.isDigit(c)) {
	        	//Toast.makeText(this,name, Toast.LENGTH_SHORT).show();
	            return false;
	        }

	    }
	    return true;
	}
	public void addclaimaction(View v){
		claimText = (EditText) findViewById(R.id.claim_text_field);
		descText = (EditText) findViewById(R.id.description_text_field);
		String ClaimTextFromField = claimText.getText().toString();
		String descriptionText = descText.toString();
		boolean flag = isAlpha(ClaimTextFromField);
		if(flag == true){
			Claim ourClaim = new Claim();
			
			Spinner categoryS = (Spinner)findViewById(R.id.type_spinner);
			String categorySet = categoryS.getSelectedItem().toString();
			
			Spinner statusS = (Spinner) findViewById(R.id.status_spinner);
			String statusSet = statusS.getSelectedItem().toString();
			Toast.makeText(this,statusSet, Toast.LENGTH_SHORT).show();
			
			
			ourClaim.setName(ClaimTextFromField);
			ourClaim.setCategory(categorySet);
			ourClaim.setStatus(statusSet);
			ClaimListController cs = new ClaimListController();
			cs.addClaim(ourClaim);
			
			
			Intent intent = new Intent(AddClaimActivity.this, MainActivity.class);
			startActivity(intent);
		};
	}
		
		
	/*Spinner spinner = (Spinner) findViewById(R.id.type_spinner);
	// Create an ArrayAdapter using the string array and a default spinner layout
	ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
	        R.array.category_array, android.R.layout.simple_spinner_item);
	// Specify the layout to use when the list of choices appears
	adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
	// Apply the adapter to the spinner
	spinner.setAdapter(adapter);*/
}