package group22.quikschedule.Calendar;

import android.content.Context;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Class: EventView
 *
 * Bugs: None known
 * Version: 1.0
 * Date: 10/30/16
 *
 * Description: This class is a custom TextView that holds all the information of each event and
 *              is shown on the UI in the form of a TextView. It contains data fields holding
 *              event information such as event name, start time, end time, etc. so that it can be
 *              accessed by other classes. It also contains two methods getTimeAsInt and
 *              getTimeAsString that format the times as ints and Strings to be used when
 *              displaying the event on the UI.
 *
 * @author Rohan Chhabra
 */
public class EventView extends TextView {

    public static final int STARTTIME = 0;
    public static final int ENDTIME = 1;
    public String name;
    public String location;
    public String startTime;
    public String endTime;
    public String id;
    public String comments;
    public String materials;
    DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS");
    public int transportation; //0=transit, 1=driving, 2=cycling, 3=walking

    public EventView(Context context) {
        super(context);
    }

    public int getTimeAsInt(int timeType) {

        Calendar c = Calendar.getInstance();

        try {
            Date inputDate;
            switch(timeType) {
                case STARTTIME:
                    inputDate = formatter.parse(startTime);
                    break;
                default:
                    inputDate = formatter.parse(endTime);
                    break;

            }

            c.setTime(inputDate);
        }
        catch(ParseException e) {
            e.printStackTrace();
        }

        return (c.get(Calendar.HOUR_OF_DAY)*60)+c.get(Calendar.MINUTE);
    }

    public String getTimeAsString (int timeType) {

        Date inputDate = null;
        try {
            switch(timeType) {
                case STARTTIME:
                    inputDate = formatter.parse(startTime);
                    break;
                default:
                    inputDate = formatter.parse(endTime);
                    break;

            }
        }
        catch(ParseException e) {
            e.printStackTrace();
        }

        DateFormat dateFormat = new SimpleDateFormat("h:mm a");

        return dateFormat.format(inputDate);
    }
}
