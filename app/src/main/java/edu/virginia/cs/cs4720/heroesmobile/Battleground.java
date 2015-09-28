package edu.virginia.cs.cs4720.heroesmobile;

import android.graphics.drawable.Drawable;

/**
 * Basic Java class to store info about each battleground
 * Created by Matt on 9/28/2015.
 */
public class Battleground {
    private final String[] mapDescriptions =
    {
        "The Haunted Mines will periodically open to reveal an undead army underneath." +
                "\nDestroy the undead and collect their skulls to power your team's golem." +
                "\nOnce the army has been defeated, a golem will arise for each team. " +
                "\nThe more skulls your team collects, the stronger your golem.",
        "The Raven Lord will periodically create tributes for either team to gather." +
                "\nWhen one team captures three tributes, the Raven Lord will curse their opponents." +
                "\nWhile cursed, towers and forts will not fire, and lane minions are reduced to 1 (one) health." +
                "\nThe Raven Lord's Curse does not affect the core or captured mercenaries.",
        "",
        "",
        "",
        "",
        "",
        "",
        "The Infernal Shrines periodically gather power. Activate them and prepare for a fight. " +
                "\nDefeat 30 Guardians at the active shrine to bring forth one of three unique Punishers. " +
                "\nOnce summoned, Punishers help push the nearest lane." +
                "\nBut be careful, because Punishers focus on attacking heroes above all else."
    };

    public final int HAUNTED_MINES = 0;
    public final int CURSED_HOLLOW = 1;
    public final int DRAGON_SHIRE = 2;
    public final int BLACKHEARTS_BAY = 3;
    public final int GARDEN_OF_TERROR = 4;
    public final int SKY_TEMPLE = 5;
    public final int TOMB_OF_THE_SPIDER_QUEEN = 6;
    public final int BATTLEFIELD_OF_ETERNITY = 7;
    public final int INFERNAL_SHRINES = 8;


    private String[] name;
    private Drawable[] mapImage;


    public Battleground(int mapID)
    {

    }


}
