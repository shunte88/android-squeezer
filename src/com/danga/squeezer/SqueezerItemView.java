package com.danga.squeezer;

import android.content.res.Resources;
import android.os.Parcelable.Creator;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;


/**
 * Defines view logic for a {@link SqueezerItem}
 * 
 * @author Kurt Aaholst
 * 
 * @param <T>
 *            Denotes the class of the item this class implements view logic for
 */
public interface SqueezerItemView<T extends SqueezerItem> {

	/**
	 * @return The activity associated with this view logic
	 */
	SqueezerBaseActivity getActivity();

	/**
	 * @return {@link Resources#getQuantityString(int, int)}
	 */
	String getQuantityString(int quantity);

	/**
	 * <p>Called by {@link Adapter#getView(int, View, ViewGroup)}
	 * 
	 * @param convertView
	 * @param item
	 * @return
	 */
	View getAdapterView(View convertView, T item);

	/**
	 * @return The generic argument of the implementation
	 */
    Class<T> getItemClass();
    
    /**
     * @return the creator for the current {@link SqueezerItem} implementation
     */
	Creator<T> getCreator();

}