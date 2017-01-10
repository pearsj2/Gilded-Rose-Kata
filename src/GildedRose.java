package com.gildedrose;

class GildedRose {
    Item[] items;
    
    //Adding quality guidelines as final variables
    public static final int MIN_QUALITY = 0;
    public static final int MAX_QUALITY = 50;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
       
    	for (int i = 0; i < items.length; i++) {
        	
        	//potentially replace this with a switch and enum the item types
    		//Future implementation could create another abstract layer of Inventory to house
    		//some additional functionality and helper methods
        	if(items[i].name.contains("Conjured")){
        		ConjuredItem.update(items[i]);
          	}
        	else if(items[i].name.contains("Aged Brie")){
        		AgeableItem.update(items[i]);
        	}
        	else if(items[i].name.contains("Sulfuras")){
        		LegendaryItem.update(items[i]);
        	}
        	else if(items[i].name.contains("Backstage passes")){
        		EventItem.update(items[i]);
        	}
        	else{
        		StandardItem.update(items[i]);
        	}
        	
        	assureQuality(items[i]);
        	

            if (!items[i].name.contains("Sulfuras")) {
                items[i].sellIn = items[i].sellIn - 1;
            }

        }
    }


    //Function to ensure quality of items remains within the rule 0 <= Q <= 50
    private void assureQuality(Item item){
    	
    	if(!item.name.contains("Sulfuras")){
        	
    		if(item.quality > GildedRose.MAX_QUALITY){
    			item.quality = GildedRose.MAX_QUALITY;
    		}
    		
    		if(item.quality < GildedRose.MIN_QUALITY){
    			item.quality = GildedRose.MIN_QUALITY;
    		}
    	}
    }
    
    //Function to determine if the item is past its sell by date
	static boolean isPastSellIn(Item item){
		if(item.sellIn > 0){
			return false;
		}
		else return true;
	}



}
