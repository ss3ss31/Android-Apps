package com.bank.atm_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.motion.widget.Debug;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.atm_app.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import kotlin.random.Random;

public class ExchangeActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener, View.OnClickListener {

    Spinner spinner_up, spinner_down;
    String[] currency_up = {"USD", "EURO", "SHEKEL"};
    String[] currency_down = {"USD", "EURO", "SHEKEL"};


    ImageButton btn_ex_num_del;
    Button btn_ex_now, btn_ex_num1, btn_ex_num2, btn_ex_num3, btn_ex_num4, btn_ex_num5, btn_ex_num6, btn_ex_num7, btn_ex_num8, btn_ex_num9, btn_ex_nothing, btn_ex_num0;

    ArrayAdapter<String> adapter, adapter_up, adapter_down;
    TextView currentUp, newUp, priceUp, currentDown, newDown, priceDown, upSignCurrency, upNumberCurrency, equalsSign, downSignCurrency, downNumberCurrency;
    float currency_convert;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exchange);

        //FindViewById
        spinner_up = (Spinner) findViewById(R.id.spinner_up);
        spinner_down = (Spinner) findViewById(R.id.spinner_down);

        //bottons
        btn_ex_now = (Button) findViewById(R.id.bt_ex_now);
        btn_ex_num1 = (Button) findViewById(R.id.bt_ex_num1);
        btn_ex_num2 = (Button) findViewById(R.id.bt_ex_num2);
        btn_ex_num3 = (Button) findViewById(R.id.bt_ex_num3);
        btn_ex_num4 = (Button) findViewById(R.id.bt_ex_num4);
        btn_ex_num5 = (Button) findViewById(R.id.bt_ex_num5);
        btn_ex_num6 = (Button) findViewById(R.id.bt_ex_num6);
        btn_ex_num7 = (Button) findViewById(R.id.bt_ex_num7);
        btn_ex_num8 = (Button) findViewById(R.id.bt_ex_num8);
        btn_ex_num9 = (Button) findViewById(R.id.bt_ex_num9);
        btn_ex_num0 = (Button) findViewById(R.id.bt_ex_num0);
        btn_ex_num_del = (ImageButton) findViewById(R.id.bt_ex_num_del);
        btn_ex_nothing = (Button) findViewById(R.id.bt_ex_nothing);


        currentUp = (TextView) findViewById(R.id.tv_current_up);
        newUp = (TextView) findViewById(R.id.tv_new_up);
        priceUp = (TextView) findViewById(R.id.tv_price_up);
        currentDown = (TextView) findViewById(R.id.tv_current_down);
        newDown = (TextView) findViewById(R.id.tv_new_down);
        priceDown = (TextView) findViewById(R.id.tv_price_down);

        upSignCurrency = (TextView) findViewById(R.id.currency_sign_up);
        upNumberCurrency = (TextView) findViewById(R.id.currency_number_up);
        equalsSign = (TextView) findViewById(R.id.currency_equals);
        downSignCurrency = (TextView) findViewById(R.id.currency_sign_down);
        downNumberCurrency = (TextView) findViewById(R.id.currency_number_down);


        // Functions

        btn_ex_now.setOnClickListener(this);
        btn_ex_num1.setOnClickListener(this);
        btn_ex_num2.setOnClickListener(this);
        btn_ex_num3.setOnClickListener(this);
        btn_ex_num4.setOnClickListener(this);
        btn_ex_num5.setOnClickListener(this);
        btn_ex_num6.setOnClickListener(this);
        btn_ex_num7.setOnClickListener(this);
        btn_ex_num8.setOnClickListener(this);
        btn_ex_num9.setOnClickListener(this);
        btn_ex_num0.setOnClickListener(this);
        btn_ex_num_del.setOnClickListener(this);
        btn_ex_nothing.setOnClickListener(this);

        priceUp.setText("0");
        priceDown.setText("0");
        currency_convert = 0.86f;

        // spinner set on item selected listener
        spinner_up.setOnItemSelectedListener(this);
        spinner_down.setOnItemSelectedListener(this);

        // spinner_up view
        adapter_up = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, currency_up);
        adapter_up.createFromResource(this, R.array.spinner, android.R.layout.simple_spinner_item);
        spinner_up.setAdapter(adapter_up);


        // spinner_down view
        adapter_down = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, currency_down);
        adapter_down.createFromResource(this, R.array.spinner, android.R.layout.simple_spinner_item);
        spinner_down.setAdapter(adapter_down);


    }

    String currencyConvert(String signFrom, String signTo) {

        float convertNum = 1f;
        int from, to;
        float usd, shekel, euro;
        String result = null;


/*
         usd =0.3123f;
         shekel=1f;        // shekel/1usd= 3.202
         euro=0.2668f;      //shekel/1euro=3.748

         usd = 1f;
         shekel=3.2017f;    // usd/1shekel=0.3123
         euro = 0.8541f;    // usd/1euro=1.170

         usd = 1.1708f;     // euro/1usd = 0.854
         shekel=3.7485f;    // euro/1shekel = 0.266
         euro = 1f;


*/

        if (signFrom == signTo) {
            convertNum = 1;
        }
        if (signFrom == "USD") {
            if (signTo == "SHEKEL") {

                convertNum = convertNum * 0.3123f;
            }
            if (signTo == "EURO") {

                convertNum = convertNum * 1.170f;
            }
            if (signTo == "USD") {

                convertNum = 1;
            }
        }

        if (signFrom == "EURO") {
            if (signTo == "SHEKEL") {

                convertNum = convertNum * 0.266f;
            }
            if (signTo == "USD") {

                convertNum = convertNum * 0.854f;
            }
            if (signTo == "EURO") {

                convertNum = 1;
            }
            result = String.valueOf(convertNum);
        }

        if (signFrom == "SHEKEL") {
            if (signTo == "USD") {

                convertNum = convertNum * 3.202f;
            }
            if (signTo == "EURO") {

                convertNum = convertNum * 3.748f;
            }
            if (signTo == "SHEKEL") {

                convertNum = 1;
            }
            result = String.valueOf(convertNum);
        }


        result = String.valueOf(convertNum);
        return result;
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        // On selecting a spinner item
        String item = adapterView.getItemAtPosition(i).toString();
        //upSignCurrency,upNumberCurrency,equalsSign,downSignCurrency,downNumberCurrency
        //{"USD", "EURO", "SHEKEL"}


        //upNumberCurrency
        //downNumberCurrency
        String temp = null;

        /*switch (adapterView.getId()){
            case  R.id.spinner_up:
                switch (item)
                {

                    case "USD":
                        upNumberCurrency.setText(currencyConvert("USD",temp));
                        break;
                    case "EURO":
                        upNumberCurrency.setText(currencyConvert("EURO",temp));

                        break;
                    case "SHEKEL":
                        upNumberCurrency.setText(currencyConvert("SHEKEL",temp));
                        break;
                    default:

                        break;
                }
                break;
            case  R.id.spinner_down:
                switch (item)
                {
                    case "USD":
                        downNumberCurrency.setText(currencyConvert(temp,"USD"));

                        break;
                    case "EURO":
                        downNumberCurrency.setText(currencyConvert(temp,"EURO"));
                        break;
                    case "SHEKEL":
                        downNumberCurrency.setText(currencyConvert(temp,"SHEKEL"));
                        break;

                    default:
                        temp="USD";
                        break;
                }
                break;
            default:

                break;
        }*/



//            upSignCurrency.setText("$");
//            upNumberCurrency.setText("0"); // String function
//            downSignCurrency.setText("$");
//            downNumberCurrency.setText("0");

            if (adapterView.getId() == R.id.spinner_up) {
                upSignCurrency.setText("spinner_up");
                if (item == "USD") {
                    if (adapterView.getId() == R.id.spinner_down) {
                        if (item == "USD") {
                            upSignCurrency.setText("$");
                            upNumberCurrency.setText(currencyConvert("USD", "USD")); // String function
                            downSignCurrency.setText("$");
                            downNumberCurrency.setText(currencyConvert("USD", "USD"));
                        }
                        if (item == "EURO") {
                            upSignCurrency.setText("$");
                            upNumberCurrency.setText(currencyConvert("USD", "EURO")); // String function
                            downSignCurrency.setText("€");
                            downNumberCurrency.setText(currencyConvert("USD", "EURO"));
                        }
                        if (item == "SHEKEL") {
                            upSignCurrency.setText("$");
                            upNumberCurrency.setText(currencyConvert("USD", "SHEKEL")); // String function
                            downSignCurrency.setText("₪");
                            downNumberCurrency.setText(currencyConvert("USD", "SHEKEL"));
                        }

                    }
                    if (adapterView.getId() == R.id.spinner_down) {
                        if (item == "USD") {
                            if (adapterView.getId() == R.id.spinner_up) {
                                if (item == "USD") {
                                    upSignCurrency.setText("$");
                                    upNumberCurrency.setText(currencyConvert("USD", "USD")); // String function
                                    downSignCurrency.setText("$");
                                    downNumberCurrency.setText(currencyConvert("USD", "USD"));
                                }
                                if (item == "EURO") {
                                    upSignCurrency.setText("$");
                                    upNumberCurrency.setText(currencyConvert("USD", "EURO")); // String function
                                    downSignCurrency.setText("€");
                                    downNumberCurrency.setText(currencyConvert("USD", "EURO"));
                                }
                                if (item == "SHEKEL") {
                                    upSignCurrency.setText("$");
                                    upNumberCurrency.setText(currencyConvert("USD", "SHEKEL")); // String function
                                    downSignCurrency.setText("₪");
                                    downNumberCurrency.setText(currencyConvert("USD", "SHEKEL"));
                                }

                            }
                        }

                    }
                }
            }

        //--
            /*
            upSignCurrency.setText("$");
            upNumberCurrency.setText(currencyConvert("USD", "USD")); // String function
            downNumberCurrency.setText(currencyConvert("USD", "USD"));

        } else if (item == "EURO") {
            upSignCurrency.setText("€");
            upNumberCurrency.setText(currencyConvert("EURO", "SHEKEL")); // String function
            downNumberCurrency.setText("1");

        } else if (item == "SHEKEL") {
            upSignCurrency.setText("₪");
            upNumberCurrency.setText(currencyConvert("SHEKEL", "SHEKEL")); // String function
            downNumberCurrency.setText("1");
        } else if (item == "USD") {
            upSignCurrency.setText("$");
            upNumberCurrency.setText(currencyConvert("USD", "USD")); // String function
            downNumberCurrency.setText("1");

        }

    } else if (adapterView.getId() == R.id.spinner_down) {
        if (item == "USD") {
            downSignCurrency.setText("$");
            upNumberCurrency.setText(currencyConvert("USD", "USD")); // String function
            downNumberCurrency.setText(currencyConvert("USD", "USD"));

        } else if (item == "EURO") {
            downSignCurrency.setText("€");
            downNumberCurrency.setText("1");
            downNumberCurrency.setText(currencyConvert("EURO", "SHEKEL"));

        } else if (item == "SHEKEL") {
            downSignCurrency.setText("₪");
            downNumberCurrency.setText("1");
            downNumberCurrency.setText(currencyConvert("SHEKEL", "SHEKEL"));
        }


    }
}catch (Exception e){
    e.printStackTrace();
}
*/

        // Showing selected spinner item
        Toast.makeText(adapterView.getContext(), "Selected: " + item, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {


    }

    @Override
    public void onClick(View v) {
        String value = "";
        int temp = 0;
        value = priceUp.getText().toString();
        if (value != "") {
            temp = Integer.parseInt(value);
        }
        switch (v.getId()) {
            case R.id.bt_ex_num_del:
                temp /= 10;
                break;
            case R.id.bt_ex_now:
                // do your code
                priceDown.setText(String.valueOf(temp * currency_convert));
                break;
            case R.id.bt_ex_nothing:
                // do your code
                break;
            case R.id.bt_ex_num0:
                temp *= 10;
                temp += 0;
                break;
            case R.id.bt_ex_num1:
                temp *= 10;
                temp += 1;
                break;
            case R.id.bt_ex_num2:
                temp *= 10;
                temp += 2;
                break;
            case R.id.bt_ex_num3:
                temp *= 10;
                temp += 3;
                break;
            case R.id.bt_ex_num4:
                temp *= 10;
                temp += 4;
                break;
            case R.id.bt_ex_num5:
                temp *= 10;
                temp += 5;
                break;
            case R.id.bt_ex_num6:
                temp *= 10;
                temp += 6;
                break;
            case R.id.bt_ex_num7:
                temp *= 10;
                temp += 7;
                break;
            case R.id.bt_ex_num8:
                temp *= 10;
                temp += 8;
                break;
            case R.id.bt_ex_num9:
                temp *= 10;
                temp += 9;
                break;


            default:

                break;
        }
        priceUp.setText(String.valueOf(temp));


    }

}


