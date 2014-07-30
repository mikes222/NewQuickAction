package com.mschwartz.quickaction.lib;

import android.graphics.drawable.Drawable;

/**
 * Action item, displayed as menu with icon and text.
 * 
 * @author Lorensius. W. L. T <lorenz@londatiga.net>
 * 
 * Contributors:
 * - Kevin Peck <kevinwpeck@gmail.com>
 *
 */
public abstract class ActionItem<T extends Object> {
    /**
     * The icon of the action or null
     */
	private Drawable icon;
    /**
     * The displayable title of the action
     */
	private String title;

    /**
     * A sticky item will not dismiss the view after the item has been clicked
     */
    private boolean sticky;
	
    /**
     * Constructor
     * 
     * @param title     Title
     * @param icon      Icon to use
     */
    public ActionItem(String title, Drawable icon) {
        this.title = title;
        this.icon = icon;
    }
    
    /**
     * Constructor
     */
    public ActionItem() {
        this(null, null);
    }
    
    /**
     * Constructor
     * 
     * @param title     Text to show for the item
     */
    public ActionItem(String title) {
        this(title, null);
    }
    
    /**
     * Constructor
     * 
     * @param icon {@link Drawable} action icon
     */
    public ActionItem(Drawable icon) {
        this(null, icon);
    }
    
	/**
	 * Set action title
	 * 
	 * @param title action title
	 */
	public ActionItem setTitle(String title) {
		this.title = title;
        return this;
	}
	
	/**
	 * Get action title
	 * 
	 * @return action title
	 */
	public String getTitle() {
		return this.title;
	}
	
	/**
	 * Set action icon
	 * 
	 * @param icon {@link Drawable} action icon
	 */
	public ActionItem setIcon(Drawable icon) {
		this.icon = icon;
        return this;
	}
	
	/**
	 * Get action icon
	 * @return  {@link Drawable} action icon
	 */
	public Drawable getIcon() {
		return this.icon;
	}
	
    /**
     * Set sticky status of button
     * 
     * @param sticky  true for sticky, pop up sends event but does not disappear
     */
    public ActionItem setSticky(boolean sticky) {
        this.sticky = sticky;
        return this;
    }
    
    /**
     * @return  true if button is sticky, menu stays visible after press
     */
    public boolean isSticky() {
        return sticky;
    }

    /**
     * Implement this method and do whatever you want to do here.
     */
    public abstract void onClick(T object);
}