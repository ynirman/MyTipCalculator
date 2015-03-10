package tipcalculator.huji.ac.il.mytipcalculator;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;


public class TipCalculatorActivity extends ActionBarActivity {
    public final static double TIP = 0.12;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tip_calculator);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_tip_calculator, menu);
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

    public void calculateTip(View view) {
        EditText edtBillAmount = (EditText) findViewById(R.id.edtBillAmount);
        CheckBox chkRound = (CheckBox) findViewById(R.id.chkRound);
        TextView txtTipResult = (TextView) findViewById(R.id.txtTipResult);
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        double tip = Double.parseDouble(edtBillAmount.getText().toString()) * TIP;
        if (chkRound.isChecked()) {
            txtTipResult.setText("Tip: " + decimalFormat.format(Math.round(tip)) + "$");
        }
        else {
            txtTipResult.setText("Tip: " + decimalFormat.format(tip) + "$");
        }
    }
}
