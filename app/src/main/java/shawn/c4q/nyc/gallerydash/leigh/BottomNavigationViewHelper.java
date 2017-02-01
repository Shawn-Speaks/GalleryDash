package shawn.c4q.nyc.gallerydash.leigh;

import android.support.design.internal.BottomNavigationItemView;
import android.support.design.internal.BottomNavigationMenuView;
import android.support.design.widget.BottomNavigationView;
import android.util.Log;

import java.lang.reflect.Field;

/**
 * Created by leighdouglas on 1/31/17.
 */


//From stack overflow, I added explanation so I could understand
public class BottomNavigationViewHelper {

    public static void disableShift(BottomNavigationView view) {
        //gets the menuview inside of the navbar. the children of the menuview are each item/button
        //in the menu
        BottomNavigationMenuView menuView = (BottomNavigationMenuView) view.getChildAt(0);
        try {
            //gets the field/variable of the menuView object. mShifting mode is a boolean
            //that runs true if the menu item count is more than 3. this enable shift mode on each item in the menu
            Field shiftingMode = menuView.getClass().getDeclaredField("mShiftingMode");
            //here we are setting the field as accessible, changing it to false, and then limiting the access again
            shiftingMode.setAccessible(true);
            shiftingMode.setBoolean(menuView, false);
            shiftingMode.setAccessible(false);
            for (int i = 0; i < menuView.getChildCount(); i++) {
                //get the item in the menu
                BottomNavigationItemView item = (BottomNavigationItemView) menuView.getChildAt(i);
                //noinspection RestrictedApi
                item.setShiftingMode(false);//disable shift mode on the menu item
                // set once again checked value, so view will be updated
                //noinspection RestrictedApi
                item.setChecked(item.getItemData().isChecked()); //sets items so that they all display the text
            }
        } catch (NoSuchFieldException e) { //catches in case the field doesnt exist
            Log.e("BNVHelper", "Unable to get shift mode field", e);
        } catch (IllegalAccessException e) { //catches in case field is inaccessible
            Log.e("BNVHelper", "Unable to change value of shift mode", e);
        }

    }
}
