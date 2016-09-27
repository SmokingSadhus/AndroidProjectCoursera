package com.example.modernartui;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.app.DialogFragment;
import android.app.Dialog;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.SeekBar.OnSeekBarChangeListener;


public class MainActivity extends ActionBarActivity {
    private DialogFragment mDialog;
    private SeekBar seekBar;
    private TextView textView1;
    private TextView textView2;
    private TextView textView3;
    private TextView textView4;
    private TextView textView5;
    private int oriColor1;
    private int oriColor2;
    private int oriColor3;
    private int oriColor4;
    private int oriColor5;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initializeVariables();
        seekBar.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {

            int progress = 0;


            @Override

            public void onProgressChanged(SeekBar seekBar, int progresValue, boolean fromUser) {

                progress = progresValue;
                int x = 500 * progress;

                textView1.setBackgroundColor(oriColor1+x);
                textView2.setBackgroundColor(oriColor2+x);
                textView3.setBackgroundColor(oriColor3+x);
                textView5.setBackgroundColor(oriColor5+x);
            }


            @Override

            public void onStartTrackingTouch(SeekBar seekBar) {

                // Toast.makeText(getApplicationContext(), "Started tracking seekbar", Toast.LENGTH_SHORT).show();

            }


            @Override

            public void onStopTrackingTouch(SeekBar seekBar) {

                // int x = 500 * progress;


                /*int cp=c.getColor();
                cp=cp+x;
                textView1.setBackgroundColor(cp);*/

                // Toast.makeText(getApplicationContext(), "Stopped tracking seekbar", Toast.LENGTH_SHORT).show();

            }

        });

    }
    private void initializeVariables(){
        seekBar = (SeekBar) findViewById(R.id.seekBar1);

        textView1 = (TextView) findViewById(R.id.textView1);
        textView2 = (TextView) findViewById(R.id.textView2);
        textView3 = (TextView) findViewById(R.id.textView3);
        textView4 = (TextView) findViewById(R.id.textView4);
        textView5 = (TextView) findViewById(R.id.textView5);
        ColorDrawable c1 = (ColorDrawable)textView1.getBackground();
        ColorDrawable c2 = (ColorDrawable)textView2.getBackground();
        ColorDrawable c3 = (ColorDrawable)textView3.getBackground();
        ColorDrawable c4 = (ColorDrawable)textView4.getBackground();
        ColorDrawable c5 = (ColorDrawable)textView5.getBackground();
        oriColor1=c1.getColor();
        oriColor2=c2.getColor();
        oriColor3=c3.getColor();
        oriColor4=c4.getColor();
        oriColor5=c5.getColor();

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
        showDialogFragment();
        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    private void showDialogFragment()
    {

        mDialog = AlertDialogFragment.newInstance();
//mDialog=new AlertDialogFragment();
        // Show AlertDialogFragment
        mDialog.show(getFragmentManager(), "Alert");



    }

    public static class AlertDialogFragment extends DialogFragment {


        public static AlertDialogFragment newInstance() {
            return new AlertDialogFragment();
        }
        // Build AlertDialog using AlertDialog.Builder
        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            return new AlertDialog.Builder(getActivity())
                    .setMessage("Inspired by the works of artists such as Piet Mondrian and Ben Nicholson \n"+"\n"+"Click below to learn more")

                            // User cannot dismiss dialog by hitting back button
                    .setCancelable(false)

                            // Set up No Button
                    .setNegativeButton("Not Now",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog,
                                                    int id) {
                                    return;
                                }
                            })

                            // Set up Yes Button
                    .setPositiveButton("Visit MOMA",
                            new DialogInterface.OnClickListener() {
                                public void onClick(
                                        final DialogInterface dialog, int id) {
                                    startImplicitActivation();
                                    return;
                                }
                            }).create();
        }
        private void startImplicitActivation() {

            //Log.i(TAG, "Entered startImplicitActivation()");

            // TODO - Create a base intent for viewing a URL
            // (HINT:  second parameter uses Uri.parse())
            Uri webpage = Uri.parse("http://www.moma.org");
            Intent baseIntent = null;
            baseIntent=new Intent(Intent.ACTION_VIEW,webpage);

            // TODO - Create a chooser intent, for choosing which Activity
            // will carry out the baseIntent
            // (HINT: Use the Intent class' createChooser() method)
            /*Intent chooserIntent = null;
            chooserIntent=Intent.createChooser(baseIntent,"Load http://www.google.com with");*/

            // Log.i(TAG,"Chooser Intent Action:" + chooserIntent.getAction());



            // TODO - Start the chooser Activity, using the chooser intent

            this.startActivity(baseIntent);
        }











    }

    // Class that creates the ProgressDialog






}