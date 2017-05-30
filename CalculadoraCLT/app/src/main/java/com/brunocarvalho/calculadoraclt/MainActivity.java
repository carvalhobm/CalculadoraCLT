package com.brunocarvalho.calculadoraclt;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.brunocarvalho.calculadoraclt.fragments.FeriasFragment;
import com.brunocarvalho.calculadoraclt.fragments.RescisaoFragment;
import com.brunocarvalho.calculadoraclt.fragments.SalLiquidoFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;

    private Toolbar toolbar;
    private TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_main);

        this.toolbar = (Toolbar) this.findViewById(R.id.toolbar);
        this.setSupportActionBar(this.toolbar);

        // Set up the ViewPager with the sections adapter.
        this.mViewPager = (ViewPager) this.findViewById(R.id.viewpager);
        this.setupViewPager(this.mViewPager);

        this.tabLayout = (TabLayout) this.findViewById(R.id.tabs);
        this.tabLayout.setupWithViewPager(this.mViewPager);
    }

    private void setupViewPager(ViewPager viewPager){
        ViewPagerAdapter adapter = new ViewPagerAdapter(this.getSupportFragmentManager());
        adapter.addFragment(new RescisaoFragment(), "Rescisão");
        adapter.addFragment(new FeriasFragment(), "Férias");
        adapter.addFragment(new SalLiquidoFragment(), "Sal. Líquido");
        viewPager.setAdapter(adapter);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        this.getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_sobre) {
            this.startActivity(new Intent(this, AboutActivity.class));
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return this.mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return this.mFragmentList.size();
        }

        void addFragment(Fragment fragment, String title) {
            this.mFragmentList.add(fragment);
            this.mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return this.mFragmentTitleList.get(position);
        }
    }
}
