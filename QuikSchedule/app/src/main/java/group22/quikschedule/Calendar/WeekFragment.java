package group22.quikschedule.Calendar;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.AppCompatButton;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import group22.quikschedule.Calendar.CalendarActivity;
import group22.quikschedule.Calendar.FragmentPageAdapter;
import group22.quikschedule.R;


public class WeekFragment extends Fragment implements View.OnClickListener{

    AppCompatButton button;

    public WeekFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_week, container, false);

        button = (AppCompatButton) v.findViewById(R.id.month);
        button.setOnClickListener(this);

        Calendar cal = Calendar.getInstance();

        if(getArguments() != null) {

            cal.set(getArguments().getInt("Year"), getArguments().getInt("Month"),
                    getArguments().getInt("Day"));
        }

        int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);

        cal.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
        DateFormat formatter = new SimpleDateFormat("EEEE, MMMM d, yyyy");
        String[] dates = new String[7];
        for(int i = 0; i < 7; i++) {
            dates[i] = formatter.format(cal.getTime());
            cal.roll(Calendar.DAY_OF_WEEK, 1);
        }
        Bundle bundle = new Bundle();
        bundle.putStringArray("Dates", dates);

        ViewPager viewPager = (ViewPager) v.findViewById(R.id.pager);
        FragmentPageAdapter f = new FragmentPageAdapter(getChildFragmentManager(), bundle);
        viewPager.setAdapter(f);
        viewPager.setCurrentItem(dayOfWeek-1);

        TabLayout tabLayout = (TabLayout) v.findViewById(R.id.tab_layout);
        tabLayout.setupWithViewPager(viewPager);

        for(int i = 0; i < 7; i++) {
            TabLayout.Tab t = tabLayout.getTabAt(i);
            t.setText(dates[i].substring(dates[i].length()-8, dates[i].length()-6));
        }

        // Inflate the layout for this fragment
        return v;
    }

    @Override
    public void onClick(View v) {

        switch(v.getId()) {
            case R.id.month:
                Intent i = new Intent(getActivity(), CalendarActivity.class);
                startActivity(i);
                break;

        }
    }

}