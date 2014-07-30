package com.mschwartz.quickaction;

import android.app.Activity;
import android.os.Bundle;

import android.view.View;

import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener; 
import android.widget.PopupWindow;

import com.mschwartz.quickaction.lib.ActionItem;
import com.mschwartz.quickaction.lib.QuickAction;

/**
 * QuickAction demo activity. 
 * 
 * This demo shows how to use quickaction, add items, setup listener for 
 * action item click and dismiss. It also shows how to implements quickaction on listview, get the
 * listview selected row and perform the action for each action item.
 * 
 * @author Lorensius W. L. T <lorenz@londatiga.net>
 *
 */
public class Example2Activity extends Activity {

	/**
	 * Right arrow icon on each listview row
	 */
	private ImageView mMoreIv = null;
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        setContentView(R.layout.example2);
        
        final ListView mList 			= (ListView) findViewById(R.id.l_list);
        
        NewQAAdapter adapter 	= new NewQAAdapter(this);
        
        final String[] data 	= {"Test 01", "Test 02", "Test 03", "Test 04", "Test 05", "Test 06", "Test 07", "Test 08",
        					   	  "Test 09", "Test 10"};
        
        adapter.setData(data);
        mList.setAdapter(adapter);
        
        ActionItem addItem 		= new ActionItem<String>("Add", getResources().getDrawable(R.drawable.ic_add)) {
            @Override
            public void onClick(String object) {
                Toast.makeText(getApplicationContext(), getTitle() + " selected for item " + object, Toast.LENGTH_SHORT).show();
            }
        };
		ActionItem acceptItem 	= new ActionItem<String>("Accept", getResources().getDrawable(R.drawable.ic_accept)) {
            @Override
            public void onClick(String object) {
                Toast.makeText(getApplicationContext(), getTitle() + " selected for item " + object, Toast.LENGTH_SHORT).show();
            }
        };
        ActionItem uploadItem 	= new ActionItem<String>("Upload", getResources().getDrawable(R.drawable.ic_up)) {
            @Override
            public void onClick(String object) {
                Toast.makeText(getApplicationContext(), getTitle() + " selected for item " + object, Toast.LENGTH_SHORT).show();
            }
        };
		
		final QuickAction mQuickAction 	= new QuickAction(this);
		
		mQuickAction.addActionItem(addItem);
		mQuickAction.addActionItem(acceptItem);
		mQuickAction.addActionItem(uploadItem);
		
		//setup on dismiss listener, set the icon back to normal
		mQuickAction.setOnDismissListener(new PopupWindow.OnDismissListener() {			
			@Override
			public void onDismiss() {
				mMoreIv.setImageResource(R.drawable.ic_list_more);
			}
		});
		
		mList.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				mQuickAction.show(view, mList.getItemAtPosition(position));
				
				//change the right arrow icon to selected state 
				mMoreIv = (ImageView) view.findViewById(R.id.i_more);
				mMoreIv.setImageResource(R.drawable.ic_list_more_selected);
			}
		});
    }
}