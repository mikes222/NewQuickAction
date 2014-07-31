NewQuickAction
==============

Android QuickAction

This is a fork of the original "New QuickAction" for android developed by Lorensius W. L. T <lorenz@londatiga.net>. 

Unfortunately there was no improvement in the last 3 years. Therefore I have ported the project to Android Studio and refactored it a bit. 

If you are willing to contribute to this fork please contact me. 

create and import the library
==============

- check out the project
- at the libary, right-click "Make module quickactionlib"
- copy the build/outputs/aar/quickactionlib.aar file to your project module into the subdirectory "libs"
- add the following to your cradle.build:

    repositories {
        flatDir {
            dirs 'libs'
        }
    }

    dependencies {
        compile(name:'quickactionlib', ext:'aar')
    }

Use the library
==============

    protected void onCreate(Bundle savedInstanceState) {
        ...
        QuickAction<String> quickAction 	= new QuickAction(this);
        quickAction.addActionItem(new ActionItem<String>("Whatever") {
            @Override
            public void onClick(String object) {
                Toast.makeText(getApplicationContext(), getTitle() + " selected for button " + object, Toast.LENGTH_SHORT).show();
            }
        });
        
        Button btn1 = (Button) this.findViewById(R.id.btn1);
        quickAction.bindTo(btn1);
    }

