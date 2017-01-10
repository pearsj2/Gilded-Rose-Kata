package com.gildedrose;

public class TexttestFixture {
    public static void main(String[] args) {
        System.out.println("OMGHAI!");

        Item[] items = new Item[] {
                new StandardItem("+5 Dexterity Vest", 10, 20), //
                new AgeableItem("Aged Brie", 2, 0), //
                new StandardItem("Elixir of the Mongoose", 5, 7), //
                new LegendaryItem("Sulfuras, Hand of Ragnaros", 0, 80), //
                new LegendaryItem("Sulfuras, Hand of Ragnaros", -1, 80),
                new EventItem("Backstage passes to a TAFKAL80ETC concert", 15, 10),
                new EventItem("Backstage passes to a TAFKAL80ETC concert", 10, 10),
                new EventItem("Backstage passes to a TAFKAL80ETC concert", 5, 10),
                new ConjuredItem("Conjured Mana Cake", 3, 6) };

        GildedRose app = new GildedRose(items);

        int days = 3;
        if (args.length > 0) {
            days = Integer.parseInt(args[0]) + 1;
        }

        for (int i = 0; i < days; i++) {
            System.out.println("-------- day " + i + " --------");
            System.out.println("name, sellIn, quality");
            for (Item item : items) {
                System.out.println(item);
            }
            System.out.println();
            app.updateQuality();
        }
    }

}
