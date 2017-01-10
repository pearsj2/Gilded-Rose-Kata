package com.gildedrose;

public class ConjuredItem extends Item{


	public ConjuredItem(String name, int sellIn, int quality) {
		super(name, sellIn, quality);
		
	}
	//Adding subtype attribute for future use with helper methods
	//For later implementation
	public static final String ITEM_TYPE = "CONJURED";

	
	public static void update(Item item){

		if(!GildedRose.isPastSellIn(item)&& item.quality > 2){
			item.quality = item.quality - 2;
		}
		
		else if(GildedRose.isPastSellIn(item)&& item.quality > 4){
			item.quality = item.quality - 4;
		}
		
		else{
			item.quality = 0;
		}
		
	}

}
