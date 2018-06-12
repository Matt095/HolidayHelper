package cmpmchad.ljmu.ac.uk.holidayhelper;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.text.DecimalFormat;

public class CurrencyConverter extends AppCompatActivity {

    //Variables to allow for functionality in converting currencies
    double amount;
    String currencyFrom;
    String currencyTo;
    double result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_currency_converter);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //Declaration of values in activity to allow for user interaction
        final EditText convertAmount = (EditText) findViewById(R.id.txtAmount);
        final Spinner countryFrom = (Spinner) findViewById(R.id.txtCountryFrom);
        final Spinner countryTo = (Spinner) findViewById(R.id.txtCountryTo);
        Button b = (Button) findViewById(R.id.btnHome);//Returns user to main activity
        Button convert = (Button) findViewById(R.id.btnConvert);

        //Carries out the calculation based on the currencies selected and the amount the user
        // wishes to convert
        convert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currencyFrom = countryFrom.getSelectedItem().toString();
                currencyTo = countryTo.getSelectedItem().toString();
                amount = Double.parseDouble(convertAmount.getText().toString());
                DecimalFormat currency = new DecimalFormat("###,###.##");
                if(countryFrom.getSelectedItem().equals(countryTo.getSelectedItem())){
                    result = amount;
                }
                else if(countryFrom.getSelectedItem().equals("GBP") &&
                        (countryTo.getSelectedItem().equals("USD"))){
                    result = amount * 1.22;
                }
                else if(countryFrom.getSelectedItem().equals("GBP") &&
                        (countryTo.getSelectedItem().equals("EUR"))){
                    result = amount * 1.15;
                }
                else if(countryFrom.getSelectedItem().equals("GBP") &&
                        (countryTo.getSelectedItem().equals("JPY"))){
                    result = amount * 140.26;
                }
                else if(countryFrom.getSelectedItem().equals("USD") &&
                        (countryTo.getSelectedItem().equals("GBP"))){
                    result = amount / 1.22;
                }
                else if(countryFrom.getSelectedItem().equals("USD") &&
                        (countryTo.getSelectedItem().equals("EUR"))){
                    result = amount /1.06;
                }
                else if(countryFrom.getSelectedItem().equals("USD") &&
                        (countryTo.getSelectedItem().equals("JPY"))){
                    result = amount * 115.43;
                }
                else if(countryFrom.getSelectedItem().equals("EUR") &&
                        (countryTo.getSelectedItem().equals("GBP"))){
                    result = amount / 1.15;
                }
                else if(countryFrom.getSelectedItem().equals("EUR") &&
                        (countryTo.getSelectedItem().equals("USD"))){
                    result = amount * 1.06;
                }
                else if(countryFrom.getSelectedItem().equals("EUR") &&
                        (countryTo.getSelectedItem().equals("JPY"))){
                    result = amount * 122.45;
                }
                else if(countryFrom.getSelectedItem().equals("JPY") &&
                        (countryTo.getSelectedItem().equals("GBP"))){
                    result = amount / 140.26;
                }
                else if(countryFrom.getSelectedItem().equals("JPY") &&
                        (countryTo.getSelectedItem().equals("EUR"))){
                    result = amount / 115.43;
                }
                else if(countryFrom.getSelectedItem().equals("JPY") &&
                        (countryTo.getSelectedItem().equals("USD"))){
                    result = amount / 122.45;
                }
                //Reads the result in order to display to screen
                final TextView finalResult = ((TextView) findViewById (R.id.txtResult));
                //finalResult.setText("The Amount is " + currency.format(result) +
                // " when converted from "
                //       + countryFrom.getSelectedItem().toString() + " to " +
                //        countryTo.getSelectedItem().toString());
                finalResult.setText(currency.format(amount) +
                        countryFrom.getSelectedItem().toString() + " equals " +
                        currency.format(result) + countryTo.getSelectedItem().toString());
            }
        });

        //Returns to main activity
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CurrencyConverter.this, MainActivity.class));
            }
        });
    }
}
