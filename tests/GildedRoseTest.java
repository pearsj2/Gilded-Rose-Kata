package com.gildedrose;

import static org.junit.Assert.*;

import org.junit.Test;

public class GildedRoseTest {
	


    @Test
    public void foo() {
        Item[] items = new Item[] { new Item("foo", 0, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("foo", app.items[0].name);
    }
    
    //Tests for item quality within requirements for each category
    
    //******************
    //Tests for Standard items
    //******************
    @Test
    public void regularItemQualityNotBelow0(){
    	Item[] items = new Item[] { new StandardItem("Wooden Shield", 2, 1) };
        GildedRose app = new GildedRose(items);
        daysToRun(3, app);
        assertEquals(0, app.items[0].quality);
    }
    
    @Test
    public void regularItemDegrade(){
    	Item[] items = new Item[] { new StandardItem("Wooden Shield", 10, 10) };
        GildedRose app = new GildedRose(items);
        daysToRun(3, app);
        assertEquals(7, app.items[0].quality);
    }
    
    @Test
    public void regularItemPastSellDate(){
    	Item[] items = new Item[] { new StandardItem("Wooden Shield", 1, 10) };
        GildedRose app = new GildedRose(items);
        daysToRun(3, app);
        assertEquals(5, app.items[0].quality);
    }
    
    @Test
    public void regularItemNotExceedQualityMax(){
    	Item[] items = new Item[] { new StandardItem("Wooden Shield", 10, 78) };
        GildedRose app = new GildedRose(items);
        daysToRun(1, app);
        assertEquals(50, app.items[0].quality);
    }
    
    //******************
    //Tests for Event items
    //******************
    @Test
    public void backStageItemQualityGreaterThan10DaysOut(){
    	Item[] items = new Item[] { new EventItem("Backstage passes to a TAFKAL80ETC concert", 15, 10) };
        GildedRose app = new GildedRose(items);
        daysToRun(2, app);
        assertEquals(12, app.items[0].quality);
    }
    
    @Test
    public void backStageItemQualityGreaterThan5DaysOut(){
    	Item[] items = new Item[] { new EventItem("Backstage passes to a TAFKAL80ETC concert", 10, 10) };
        GildedRose app = new GildedRose(items);
        daysToRun(2, app);
        assertEquals(14, app.items[0].quality);
    }
    
    @Test
    public void backStageItemQualityGreaterThan0DaysOut(){
    	Item[] items = new Item[] { new EventItem("WBackstage passes to a TAFKAL80ETC concert", 5, 10) };
        GildedRose app = new GildedRose(items);
        daysToRun(2, app);
        assertEquals(16, app.items[0].quality);
    }
    
    @Test
    public void backStageItemQualityAfterEventDay(){
    	Item[] items = new Item[] { new EventItem("Backstage passes to a TAFKAL80ETC concert", 1, 10) };
        GildedRose app = new GildedRose(items);
        daysToRun(2, app);
        assertEquals(0, app.items[0].quality);
    }
    
    @Test
    public void backStageItemQualityNotExceedMax(){
    	Item[] items = new Item[] { new EventItem("Backstage passes to a TAFKAL80ETC concert", 4, 50) };
        GildedRose app = new GildedRose(items);
        daysToRun(2, app);
        assertEquals(50, app.items[0].quality);
    }
    
    //******************
    //Tests for Ageable items
    //******************
    @Test
    public void agingAgreeableItemQualityIncreaseBeforeSellDate(){
    	Item[] items = new Item[] { new AgeableItem("Aged Brie", 2, 0) };
        GildedRose app = new GildedRose(items);
        daysToRun(1, app);
        assertEquals(1, app.items[0].quality);
    }
    
    @Test
    public void agingAgreeableItemQualityIncreaseAfterSellDate(){
    	Item[] items = new Item[] { new AgeableItem("Aged Brie", 0, 0) };
        GildedRose app = new GildedRose(items);
        daysToRun(1, app);
        assertEquals(2, app.items[0].quality);
    }
    
    @Test
    public void agingAgreeableItemQualityNotExceedMax(){
    	Item[] items = new Item[] { new AgeableItem("Aged Brie", 0, 48) };
        GildedRose app = new GildedRose(items);
        daysToRun(5, app);
        assertEquals(50, app.items[0].quality);
    }
    
    //******************
    //Tests for Legendary items
    //******************
    @Test
    public void legendaryItemQualityRemains(){
    	Item[] items = new Item[] { new LegendaryItem("Sulfuras, Hand of Ragnaros", 0, 20) };
        GildedRose app = new GildedRose(items);
        daysToRun(5, app);
        assertEquals(20, app.items[0].quality);
    }
    
    @Test
    public void legendaryItemQualityCanExceedMax(){
    	Item[] items = new Item[] { new LegendaryItem("Sulfuras, Hand of Ragnaros", 10, 80) };
        GildedRose app = new GildedRose(items);
        daysToRun(5, app);
        assertEquals(80, app.items[0].quality);
    }
    
    //******************
    //Tests for Conjured items 
    //******************
    @Test
    public void conjuredItemQualityDegrade2TimesFast(){
    	Item[] items = new Item[] { new LegendaryItem("Conjured Mana Cake", 10, 10) };
        GildedRose app = new GildedRose(items);
        daysToRun(5, app);
        assertEquals(0, app.items[0].quality);
    }
    
    @Test
    public void conjuredItemQualityGoneAfterSellDate(){
    	Item[] items = new Item[] { new LegendaryItem("Conjured Mana Cake", 2, 10) };
        GildedRose app = new GildedRose(items);
        daysToRun(5, app);
        assertEquals(0, app.items[0].quality);
    }
    
    @Test
    public void conjuredItemQualityNotExceedMax(){
    	Item[] items = new Item[] { new LegendaryItem("Conjured Mana Cake", 10, 89) };
        GildedRose app = new GildedRose(items);
        daysToRun(1, app);
        assertEquals(50, app.items[0].quality);
    }
    
	public void daysToRun(int days, GildedRose app){
		while(days > 0){
			app.updateQuality();
			days--;
		}
	}

}
