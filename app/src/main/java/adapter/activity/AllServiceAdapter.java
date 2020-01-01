package adapter.activity;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import fragment.SubTypeAllServiceFragment;

public class AllServiceAdapter extends FragmentPagerAdapter {

    private Context myContext;
    int totalTabs;
    String cid;

    public AllServiceAdapter (Context context, FragmentManager fm, int totalTabs){
        super(fm);
        myContext = context;
        this.totalTabs = totalTabs;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                SubTypeAllServiceFragment homeFragment = new SubTypeAllServiceFragment(myContext);
                return homeFragment;
            case 1:
                SubTypeAllServiceFragment homeFragment2 = new SubTypeAllServiceFragment(myContext);
                return homeFragment2;
            case 2:
                SubTypeAllServiceFragment homeFragment3 = new SubTypeAllServiceFragment(myContext);
                return homeFragment3;
            case 3:
                SubTypeAllServiceFragment homeFragment4 = new SubTypeAllServiceFragment(myContext);
                return homeFragment4;
            case 4:
                SubTypeAllServiceFragment homeFragment5 = new SubTypeAllServiceFragment(myContext);
                return homeFragment5;
            case 5:
                SubTypeAllServiceFragment homeFragment6 = new SubTypeAllServiceFragment(myContext);
                return homeFragment6;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return totalTabs;
    }
}
