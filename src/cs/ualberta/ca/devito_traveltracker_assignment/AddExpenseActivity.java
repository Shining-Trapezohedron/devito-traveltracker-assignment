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

package cs.ualberta.ca.devito_traveltracker_assignment;

import java.util.ArrayList;
import java.util.Collection;

import android.R.integer;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

public class AddExpenseActivity extends Activity {
	protected Spinner category_spinner;
	protected Spinner status_spinner;
	protected Spinner cur_spinner;
	private ArrayList<Amount> amountstoadd = new ArrayList<Amount>();
	private EditText claimText;
	private EditText descText;
	private EditText ammountText;
	private EditText date1;
	private EditText date2;
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
		
		cur_spinner = (Spinner) findViewById(R.id.curspinneredit);
		cur_spinner.setOnItemSelectedListener(new SpinnerSelectedListener());
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
		date1 = (EditText) findViewById(R.id.adddatefromfield);
		date2 = (EditText) findViewById(R.id.adddatetofield);
		String ClaimTextFromField = claimText.getText().toString();
		String descriptionText = descText.getText().toString();
		String date1Str = date1.getText().toString();
		String date2str = date2.getText().toString();
		boolean flag = isAlpha(ClaimTextFromField);
		if(flag == true){
			Expense ourClaim = new Expense();
			
			Spinner categoryS = (Spinner)findViewById(R.id.type_spinner);
			String categorySet = categoryS.getSelectedItem().toString();
			
			Spinner statusS = (Spinner) findViewById(R.id.status_spinner);
			String statusSet = statusS.getSelectedItem().toString();
			Toast.makeText(this,"Thanks for the Claim", Toast.LENGTH_SHORT).show();
			
			
			ourClaim.setName(ClaimTextFromField);
			ourClaim.setCategory(categorySet);
			ourClaim.setStatus(statusSet);
			ourClaim.setDescription(descriptionText);
			ourClaim.setDate(date1Str, date2str);
			for(int i = 0; i < amountstoadd.size(); i++){
				ourClaim.addAmount(amountstoadd.get(i));
			}
			ExpenseListController cs = new ExpenseListController();
			cs.addClaim(ourClaim);
			
			finish();
		};
	}
	public void addamountaction(View v){
		Toast.makeText(this, "Adding an amount", Toast.LENGTH_SHORT).show();
		Spinner curSpin = (Spinner)findViewById(R.id.curspinneredit);
		String cur= curSpin.getSelectedItem().toString();
		
		ammountText = (EditText) findViewById(R.id.amountfield);
		int amountFound = Integer.parseInt((ammountText.getText().toString()));
		Amount amount = new Amount();
		amount.setAmount(amountFound);
		amount.setCurrency(cur);
		amountstoadd.add(amount);
		ListView amountView = (ListView) findViewById(R.id.add_amount_list);
		ArrayAdapter<Amount> amountAdapter = new ArrayAdapter<Amount>(this, android.R.layout.simple_list_item_1, amountstoadd);
		amountView.setAdapter(amountAdapter);
		
		
	}
		

}
