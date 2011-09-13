package com.danga.squeezer.model;

import java.util.Map;

import android.os.Parcel;

import com.danga.squeezer.Util;
import com.danga.squeezer.framework.SqueezerItem;

public class SqueezerPluginItem extends SqueezerItem {
	private String name;
	@Override public String getName() { return name; }
	public SqueezerPluginItem setName(String name) { this.name = name; return this; }

	private String description;
	public String getDescription() { return description; }
	public void setDescription(String description) { this.description = description; }

	private String image;
	public String getImage() { return image; }
	public void setImage(String icon) { this.image = icon; }

	private boolean hasitems;
	public boolean isHasitems() { return hasitems; }
	public void setHasitems(boolean hasitems) { this.hasitems = hasitems; }

	private String type;
	public String getType() { return type; }
	public void setType(String type) { this.type = type; }

	public SqueezerPluginItem(Map<String, String> record) {
		setId(record.get("id"));
		name = record.containsKey("name") ? record.get("name") : record.get("title");
		description = record.get("description");
		type = record.get("type");
		image = record.get("image");
		hasitems = (Util.parseDecimalIntOrZero(record.get("hasitems")) != 0);
	}
	
	public static final Creator<SqueezerPluginItem> CREATOR = new Creator<SqueezerPluginItem>() {
		public SqueezerPluginItem[] newArray(int size) {
			return new SqueezerPluginItem[size];
		}

		public SqueezerPluginItem createFromParcel(Parcel source) {
			return new SqueezerPluginItem(source);
		}
	};
	private SqueezerPluginItem(Parcel source) {
		setId(source.readString());
		name = source.readString();
		description = source.readString();
		type = source.readString();
		image = source.readString();
		hasitems = (source.readInt() != 0);
	}
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeString(getId());
		dest.writeString(name);
		dest.writeString(description);
		dest.writeString(type);
		dest.writeString(image);
		dest.writeInt(hasitems ? 1 : 0);
	}
	
	@Override
	public String toString() {
		return "id=" + getId() + ", name=" + name;
	}
	
}
