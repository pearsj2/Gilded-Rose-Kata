package com.gildedrose;

public class LegendaryItem extends Item{
	
	public LegendaryItem(String name, int sellIn, int quality) {
		super(name, sellIn, quality);
		
	}
	//Adding subtype attribute for future use with helper methods
	//For later implementation
	public static final String ITEM_TYPE = "LEGENDARY";
	
	public static void update(Item item){
		//Nothing changes for right now as legendary items are exempt
		//from the rules of degradation
	}

}
