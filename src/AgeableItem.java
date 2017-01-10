package com.gildedrose;

public class AgeableItem extends Item{
	
	public AgeableItem(String name, int sellIn, int quality) {
		super(name, sellIn, quality);
		
	}

	//Adding subtype attribute for future use with helper methods
	//For later implementation
	public static final String ITEM_TYPE = "AGEABLE";
	
	public static void update(Item item){

		if(!GildedRose.isPastSellIn(item)){
			item.quality++;
		}
		
		else if(GildedRose.isPastSellIn(item)){
			item.quality = item.quality + 2;
		}
		
	}

}
