package np.edu.asmt.asmtfirstapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText edtText;
    Spinner spinner;
    Button btnClickMe;
    RadioGroup radioGender;
    CheckBox isAndroid;
    RadioButton radioMale,radioFemale;
    ImageView thumbImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        edtText = (EditText) findViewById(R.id.editText);
        spinner = (Spinner) findViewById(R.id.spinner);
        btnClickMe = (Button) findViewById(R.id.button);
        radioGender=(RadioGroup) findViewById (R.id.radioGender);
        isAndroid = (CheckBox) findViewById(R.id.checkBox);
        radioMale = (RadioButton) findViewById(R.id.radioMale);
        radioFemale = (RadioButton) findViewById(R.id.radioFemale);
        thumbImage = (ImageView) findViewById(R.id.imgThumb);

        radioMale.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked) {
                   // showToast("Male is active");
                    thumbImage.setImageResource(R.drawable.thumb_male);
                }
            }
        });
        radioFemale.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked) {
                    // showToast("Female is active");
                    thumbImage.setImageResource(R.drawable.thumb_female);
                }

            }
        });


        btnClickMe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] groupArray = getResources().getStringArray(R.array.group_name);
                int position = spinner.getSelectedItemPosition();
                String txtMyName = edtText.getText().toString();
                int selectedGender = radioGender.getCheckedRadioButtonId();
                RadioButton selectedRadio = (RadioButton)findViewById(selectedGender);
                showToast(txtMyName + " from "+groupArray[position]+" is "+selectedRadio.getText()+(isAndroid.isChecked()?" an Android user ":" non Android user") );

            }
        });

    }
    public void showToast(String msg){
        Toast.makeText(getApplicationContext(),msg,Toast.LENGTH_SHORT).show();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
