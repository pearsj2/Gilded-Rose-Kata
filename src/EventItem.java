package com.gildedrose;

public class EventItem extends Item{
	
	public EventItem(String name, int sellIn, int quality) {
		super(name, sellIn, quality);
		
	}

	//Adding subtype attribute for future use with helper methods
	//For later implementation
	public static final String ITEM_TYPE = "EVENT";
	
	public static void update(Item item){

		if(!GildedRose.isPastSellIn(item) && item.sellIn < 11){
			item.quality += 2;
			if(item.sellIn < 6){
				item.quality++;
			}
		}
		
		else if(!GildedRose.isPastSellIn(item) && item.sellIn > 10){
			item.quality++;
		}
		
		else if(GildedRose.isPastSellIn(item)){
			item.quality = 0;
		}
		
	}

}
