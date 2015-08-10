package br.com.activitytransictions.activity;

import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import br.com.activitytransictions.R;
import br.com.activitytransictions.model.Contact;

public class DatailsActivity extends AppCompatActivity {

    public final static String ID = "ID";
    public Contact mContact;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datails);
        mContact = Contact.getItem(getIntent().getIntExtra(ID, 0));
        setAttributes();
    }

    private void setAttributes(){
//        TextView mCircle = (TextView) findViewById(R.id.DETAILS_circle);
        TextView mName = (TextView) findViewById(R.id.DETAILS_name);
        TextView mPhone = (TextView) findViewById(R.id.DETAILS_phone);
        TextView mEmail = (TextView) findViewById(R.id.DETAILS_email);
        TextView mCity = (TextView) findViewById(R.id.DETAILS_city);
        View mCircle = (View) findViewById(R.id.DETAILS_circle);
        mName.setText(mContact.get(Contact.Field.NAME));
        mPhone.setText(mContact.get(Contact.Field.PHONE));
        mEmail.setText(mContact.get(Contact.Field.EMAIL));
        mCity.setText(mContact.get(Contact.Field.CITY));
        // Set the color of the shape
        GradientDrawable bgShape = (GradientDrawable) mCircle.getBackground();
        bgShape.setColor(Color.parseColor(mContact.get(Contact.Field.COLOR)));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_datails, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
