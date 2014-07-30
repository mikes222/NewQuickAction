package com.mschwartz.quickaction;

import android.os.Bundle;
import android.app.Activity;

import android.widget.Button;
import android.widget.Toast;
import android.view.View;
import android.view.View.OnClickListener;

import com.mschwartz.quickaction.lib.ActionItem;
import com.mschwartz.quickaction.lib.QuickAction;

/**
 * QuickAction demo activity. 
 * 
 * This demo shows how to use quickaction, add items, setup listener for 
 * action item click and dismiss. 
 * 
 * @author Lorensius W. L. T <lorenz@londatiga.net>
 *
 */
public class Example1Activity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.example1);
		
		ActionItem addItem 		= new ActionItem<String>("Add", getResources().getDrawable(R.drawable.ic_add)) {
            @Override
            public void onClick(String object) {
                Toast.makeText(getApplicationContext(), getTitle() + " selected for button " + object, Toast.LENGTH_SHORT).show();
            }
        };
		ActionItem acceptItem 	= new ActionItem<String>("Accept", getResources().getDrawable(R.drawable.ic_accept)){
            @Override
            public void onClick(String object) {
                Toast.makeText(getApplicationContext(), getTitle() + " selected for button " + object, Toast.LENGTH_SHORT).show();
            }
        };
        //use setSticky(true) to disable QuickAction dialog being dismissed after an item is clicked
        ActionItem uploadItem 	= new ActionItem<String>("Upload", getResources().getDrawable(R.drawable.ic_up)){
            @Override
            public void onClick(String object) {
                Toast.makeText(getApplicationContext(), getTitle() + " selected for button " + object, Toast.LENGTH_SHORT).show();
            }
        }.setSticky(true);
       
		final QuickAction<String> mQuickAction 	= new QuickAction(this);
		
		mQuickAction.addActionItem(addItem);
		mQuickAction.addActionItem(acceptItem);
		mQuickAction.addActionItem(uploadItem);
        mQuickAction.addActionItem(new ActionItem<String>("Whatever") {
            @Override
            public void onClick(String object) {
                Toast.makeText(getApplicationContext(), getTitle() + " selected for button " + object, Toast.LENGTH_SHORT).show();
            }
        });
		
		mQuickAction.setOnDismissListener(new QuickAction.OnDismissListener() {
			@Override
			public void onDismiss() {
				Toast.makeText(getApplicationContext(), "Ups..dismissed", Toast.LENGTH_SHORT).show();
			}
		});
		
		Button btn1 = (Button) this.findViewById(R.id.btn1);
		btn1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				mQuickAction.show(v, "Button1");
			}
		});

		Button btn2 = (Button) this.findViewById(R.id.btn2);
		btn2.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
                mQuickAction.setAnimStyle(QuickAction.ANIM_GROW_FROM_CENTER);
				mQuickAction.show(v, "Button2");
			}
		});

        Button btn3 = (Button) this.findViewById(R.id.btn3);
        btn2.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                mQuickAction.show(v, "Button3");
            }
        });
	}
}