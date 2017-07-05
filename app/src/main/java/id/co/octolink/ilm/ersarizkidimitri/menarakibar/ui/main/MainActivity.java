package id.co.octolink.ilm.ersarizkidimitri.menarakibar.ui.main;

import android.app.AlertDialog;
import android.app.FragmentManager;
import android.content.BroadcastReceiver;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.widget.TextView;

import com.aurelhubert.ahbottomnavigation.AHBottomNavigation;
import com.aurelhubert.ahbottomnavigation.AHBottomNavigationAdapter;
import com.aurelhubert.ahbottomnavigation.AHBottomNavigationItem;
import com.aurelhubert.ahbottomnavigation.AHBottomNavigationViewPager;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import id.co.octolink.ilm.ersarizkidimitri.menarakibar.R;
import id.co.octolink.ilm.ersarizkidimitri.menarakibar.ui.BaseActivity;
import id.co.octolink.ilm.ersarizkidimitri.menarakibar.ui.events.EventFragment;
import id.co.octolink.ilm.ersarizkidimitri.menarakibar.ui.guide.GuideFragment;
import id.co.octolink.ilm.ersarizkidimitri.menarakibar.ui.info.InfoFragment;
import id.co.octolink.ilm.ersarizkidimitri.menarakibar.ui.news.NewsFragment;
import id.co.octolink.ilm.ersarizkidimitri.menarakibar.ui.profile.ProfileFragment;

public class MainActivity extends BaseActivity {
    @BindView(R.id.view_pager)AHBottomNavigationViewPager viewPager;
    @BindView(R.id.bottom_navigation)AHBottomNavigation bottomNavigation;
    @BindView(R.id.lbl_name)TextView txtMenara;

    public static final String TAG = MainActivity.class.getSimpleName();
    private MainPagerAdapter2 mPagerAdapter;
    private AHBottomNavigationAdapter navigationAdapter;
    private ArrayList<AHBottomNavigationItem> bottomNavigationItems = new ArrayList<>();
    private boolean useMenuResource = true;
    private int[] tabColors;
    private FloatingActionButton floatingActionButton;
    private FragmentManager fragmentManager;
    boolean doubleBackToExitPressedOnce = false;
    private BroadcastReceiver mRegistrationBroadcastReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        fragmentManager = getFragmentManager();

        initUI();

        viewPager = (AHBottomNavigationViewPager) findViewById(R.id.view_pager);
        mPagerAdapter = new MainPagerAdapter2(getSupportFragmentManager());
        viewPager.setAdapter(mPagerAdapter);

        String fontPath = "fonts/Karla-Bold.ttf";
        Typeface tf = Typeface.createFromAsset(getAssets(), fontPath);
        txtMenara.setTypeface(tf);

    }

    private void initUI() {

        if (useMenuResource) {
            tabColors = getApplicationContext().getResources().getIntArray(R.array.tab_colors);
            navigationAdapter = new AHBottomNavigationAdapter(this, R.menu.navigation);
            navigationAdapter.setupWithBottomNavigation(bottomNavigation, tabColors);

            bottomNavigation.setDefaultBackgroundColor(Color.parseColor("#FEFEFE"));
            bottomNavigation.setAccentColor(Color.parseColor("#333333"));
            bottomNavigation.setInactiveColor(Color.parseColor("#999999"));
            bottomNavigation.setForceTint(true);
            bottomNavigation.setForceTitlesDisplay(true);
//            bottomNavigation.setBehaviorTranslationEnabled(false);

        } else {
            AHBottomNavigationItem item1 = new AHBottomNavigationItem(R.string.tab_1, R.drawable.ic_explore, R.color.color_tab_1);
            AHBottomNavigationItem item2 = new AHBottomNavigationItem(R.string.tab_2, R.drawable.ic_subject, R.color.color_tab_2);
            AHBottomNavigationItem item3 = new AHBottomNavigationItem(R.string.tab_3, R.drawable.ic_event, R.color.color_tab_3);
            AHBottomNavigationItem item4 = new AHBottomNavigationItem(R.string.tab_4, R.drawable.ic_feedback, R.color.color_tab_4);
            AHBottomNavigationItem item5 = new AHBottomNavigationItem(R.string.tab_5, R.drawable.ic_perm_identity, R.color.color_tab_5);

            bottomNavigationItems.add(item1);
            bottomNavigationItems.add(item2);
            bottomNavigationItems.add(item3);
            bottomNavigationItems.add(item4);
            bottomNavigationItems.add(item5);

            bottomNavigation.addItems(bottomNavigationItems);

            bottomNavigation.setDefaultBackgroundColor(Color.parseColor("#FEFEFE"));
            bottomNavigation.setAccentColor(Color.parseColor("#333333"));
            bottomNavigation.setInactiveColor(Color.parseColor("#999999"));
            bottomNavigation.setForceTint(true);
            bottomNavigation.setForceTitlesDisplay(true);
//            bottomNavigation.setBehaviorTranslationEnabled(false);

        }

        bottomNavigation.setOnTabSelectedListener(new AHBottomNavigation.OnTabSelectedListener() {
            @Override
            public boolean onTabSelected(int position, boolean wasSelected) {

                if (position == 0){
                    GuideFragment guideFragment = new GuideFragment();
                    Bundle arguments = new Bundle();
    //                    arguments.putString("Id", txtId);
                    guideFragment.setArguments(arguments);
                    getSupportFragmentManager().beginTransaction()
                            .setCustomAnimations(R.anim.activityslidein, R.anim.activityslideinout, R.anim.activityslideoutpop, R.anim.activityslideout)
                            .replace(R.id.root_frame, guideFragment, "guideFragment")
                            .commit();
                }
                if (position == 1) {
                    NewsFragment newsFragment = new NewsFragment();
                    Bundle arguments = new Bundle();
                    //                    arguments.putString("Id", txtId);
                    newsFragment.setArguments(arguments);
                    getSupportFragmentManager().beginTransaction()
                            .setCustomAnimations(R.anim.activityslidein, R.anim.activityslideinout, R.anim.activityslideoutpop, R.anim.activityslideout)
                            .replace(R.id.root_frame, newsFragment, "newsFragment")
                            .commit();
                }
                if (position == 2){
                    EventFragment eventFragment = new EventFragment();
                    Bundle arguments = new Bundle();
                    //                    arguments.putString("Id", txtId);
                    eventFragment.setArguments(arguments);
                    getSupportFragmentManager().beginTransaction()
                            .setCustomAnimations(R.anim.activityslidein, R.anim.activityslideinout, R.anim.activityslideoutpop, R.anim.activityslideout)
                            .replace(R.id.root_frame, eventFragment, "eventFragment")
                            .commit();
                }
                if (position == 3){
                    InfoFragment infoFragment = new InfoFragment();
                    Bundle arguments = new Bundle();
                    //                    arguments.putString("Id", txtId);
                    infoFragment.setArguments(arguments);
                    getSupportFragmentManager().beginTransaction()
                            .setCustomAnimations(R.anim.activityslidein, R.anim.activityslideinout, R.anim.activityslideoutpop, R.anim.activityslideout)
                            .replace(R.id.root_frame, infoFragment, "infoFragment")
                            .commit();
                }
                if (position == 4){
                    ProfileFragment profileFragment = new ProfileFragment();
                    Bundle arguments = new Bundle();
                    //                    arguments.putString("Id", txtId);
                    profileFragment.setArguments(arguments);
                    getSupportFragmentManager().beginTransaction()
                            .setCustomAnimations(R.anim.activityslidein, R.anim.activityslideinout, R.anim.activityslideoutpop, R.anim.activityslideout)
                            .replace(R.id.root_frame, profileFragment, "profileFragment")
                            .commit();
                }
                else {

                }
            return true;
            }
        });

//        bottomNavigation.setOnNavigationPositionListener(new AHBottomNavigation.OnNavigationPositionListener() {
//            @Override public void onPositionChange(int y) {
//                Log.d("DemoActivity", "BottomNavigation Position: " + y);
//            }
//        });

//        viewPager.setOffscreenPageLimit(4);
//        adapter = new MainViewPagerAdapter(getSupportFragmentManager());
//        viewPager.setAdapter(adapter);

//        currentFragment = adapter.getCurrentFragment();

//        final Handler handler = new Handler();
//        handler.postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                // Setting custom colors for notification
//                AHNotification notification = new AHNotification.Builder()
//                        .setText(":)")
//                        .setBackgroundColor(ContextCompat.getColor(MainActivity.this, R.color.color_notification_back))
//                        .setTextColor(ContextCompat.getColor(MainActivity.this, R.color.color_notification_text))
//                        .build();
//                bottomNavigation.setNotification(notification, 1);
//                Snackbar.make(bottomNavigation, "Snackbar with bottom navigation",
//                        Snackbar.LENGTH_SHORT).show();
//            }
//        }, 3000);

//        bottomNavigation.setDefaultBackgroundResource(R.drawable.bottom_navigation_background);
    }

    public void confirmExit(){
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setCancelable(false);
        alertDialogBuilder.setTitle("Exit");
        alertDialogBuilder.setMessage("Are you sure you want to exit?");
        alertDialogBuilder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface arg0, int arg1) {
                doubleBackToExitPressedOnce = false;
                finish();
            }
        });
        alertDialogBuilder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                doubleBackToExitPressedOnce = false;
            }
        });
        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }

    @Override
    public void onBackPressed() {
        //Checking for fragment count on backstack
        if (getSupportFragmentManager().getBackStackEntryCount() > 0) {
            getSupportFragmentManager().popBackStack();
        } else if (!doubleBackToExitPressedOnce) {
            this.doubleBackToExitPressedOnce = true;
            confirmExit();
//            Toast.makeText(this,"Please click BACK again to exit.", Toast.LENGTH_SHORT).show();
//            new Handler().postDelayed(new Runnable() {
//                @Override
//                public void run() {
//                    doubleBackToExitPressedOnce = false;
//                }
//            }, 2000);
        } else {
            super.onBackPressed();
            return;
        }
    }

}
