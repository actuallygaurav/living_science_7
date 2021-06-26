//package com.learn.livingscienceclass7;
//
//import android.content.ActivityNotFoundException;
//import android.content.DialogInterface;
//import android.content.Intent;
//import android.net.Uri;
//import android.os.Bundle;
//import android.view.Menu;
//import android.view.MenuInflater;
//import android.view.MenuItem;
//
//import androidx.annotation.NonNull;
//import androidx.appcompat.app.AlertDialog;
//import androidx.appcompat.app.AppCompatActivity;
//import androidx.fragment.app.Fragment;
//
//import com.gaurav.livingscience.R;
//import com.google.android.gms.ads.AdRequest;
//import com.google.android.gms.ads.AdView;
//
//import util.Constants;
//import view.ChapterIndexFragment;
//import view.MessageFragment;
//
//
//
//
//public class MainActivity extends AppCompatActivity {
//
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//
//        getSupportFragmentManager()
//                .beginTransaction()
//                .replace(R.id.fragment_container, new ChapterIndexFragment())
//                .commit();
//
//        // load Ad
//        AdView mAdView = findViewById(R.id.adView);
//        AdRequest adRequest = new AdRequest.Builder().build();
//        mAdView.loadAd(adRequest);
//
//    }
//
//
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        MenuInflater menuInflater = getMenuInflater();
//        menuInflater.inflate(R.menu.top_menu, menu);
//        return true;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
//        switch (item.getItemId()) {
//            case R.id.top_star_icon:
//                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
//                builder.setTitle(Constants.ARE_YOU_SURE)
//                        .setMessage(Constants.PLAY_STORE_DIALOG_MSG)
//                        .setCancelable(true)
//                        .setPositiveButton(Constants.YES_SURE, new DialogInterface.OnClickListener() {
//                            @Override
//                            public void onClick(DialogInterface dialog, int which) {
//                                rateApp();
//                            }
//                        })
//                        .setNegativeButton(Constants.NO_THANKS, new DialogInterface.OnClickListener() {
//                            @Override
//                            public void onClick(DialogInterface dialog, int which) {
//                            }
//                        });
//                AlertDialog dialog  = builder.create();
//                dialog.show();
//                return true;
//
//            case R.id.message_icon:
//                Fragment messageFrag = getSupportFragmentManager().findFragmentByTag(Constants.MESSAGE_FRAGMENT_TAG);
//                if(messageFrag == null) {
//                    getSupportFragmentManager()
//                            .beginTransaction()
//                            .replace(R.id.fragment_container, new MessageFragment(), Constants.MESSAGE_FRAGMENT_TAG)
//                            .addToBackStack(null)
//                            .commit();
//                    return true;
//                }
//        }
//        return false;
//    }
//
//
//    public void rateApp() {
//        try {
//            Intent rateIntent = rateIntentForUrl(Constants.MARKET_DETAILS);
//            startActivity(rateIntent);
//        } catch (ActivityNotFoundException e) {
//            Intent rateIntent = rateIntentForUrl(Constants.PLAY_STORE_URL);
//            startActivity(rateIntent);
//        }
//    }
//
//    private Intent rateIntentForUrl(String url) {
//        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(String.format("%s?id=%s", url, getPackageName())));
//        int flags = Intent.FLAG_ACTIVITY_NO_HISTORY | Intent.FLAG_ACTIVITY_MULTIPLE_TASK;
//        flags |= Intent.FLAG_ACTIVITY_NEW_DOCUMENT;
//        intent.addFlags(flags);
//        return intent;
//    }
//}
