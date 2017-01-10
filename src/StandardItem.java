package com.gildedrose;

public class StandardItem extends Item{
	
	public StandardItem(String name, int sellIn, int quality) {
		super(name, sellIn, quality);
	}

	//Adding subtype attribute for future use with helper methods
	//For later implementation
	public static final String ITEM_TYPE = "STANDARD";
		
	public static void update(Item item){

		if(!GildedRose.isPastSellIn(item)&& item.quality > 0){
			item.quality--;
		}
		
		else if(GildedRose.isPastSellIn(item)&& item.quality > 1){
			item.quality = item.quality - 2;
		}
		
		else{
			item.quality = 0;
		}
		
	}

}
