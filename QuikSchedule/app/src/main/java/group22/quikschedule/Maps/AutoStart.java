package group22.quikschedule.Maps;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/**
 * Created by Ty Dewes and David Thomson on 11/14/16.
 */

public class AutoStart extends BroadcastReceiver {

    Polling polling = new Polling();

    /**
     * starts the alarm to poll for the location of days first even on reboot.
     * @param context current context
     * @param intent the intent that was received, checked to see if it was a reboot.
     */
    @Override
    public void onReceive( Context context, Intent intent )
    {
        if (intent.getAction().equals( Intent.ACTION_BOOT_COMPLETED ) )
        {
            polling.setAlarm( context );
        }
    }
}
