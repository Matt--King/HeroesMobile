package edu.virginia.cs.cs4720.heroesmobile;

import android.graphics.drawable.Drawable;

/**
 * Basic Java class to store info about each battleground
 * The mapping of battlegrounds to array indices matches the integer IDs
 * Created by Matt on 9/28/2015.
 */
public class Battleground {

    public final int HAUNTED_MINES = 0;
    public final int CURSED_HOLLOW = 1;
    public final int DRAGON_SHIRE = 2;
    public final int BLACKHEARTS_BAY = 3;
    public final int GARDEN_OF_TERROR = 4;
    public final int SKY_TEMPLE = 5;
    public final int TOMB_OF_THE_SPIDER_QUEEN = 6;
    public final int BATTLEFIELD_OF_ETERNITY = 7;
    public final int INFERNAL_SHRINES = 8;


    private final String[] names =
            {
                    "Haunted Mines",
                    "Cursed Hollow",
                    "Dragon Shire",
                    "Blackheart's Bay",
                    "Garden of Terror",
                    "Sky Temple",
                    "Tomb of the Spider Queen",
                    "Battlefield of Eternity",
                    "Infernal Shrines",
            };

    private final Drawable[] mapImages = {};


    private final String[] mapDescriptions =
            {
                    "The Haunted Mines will periodically open to reveal an undead army underneath." +
                            " Destroy the undead and collect their skulls to power your team's golem." +
                            " Once the army has been defeated, a golem will arise for each team. " +
                            " The more skulls your team collects, the stronger your golem.",

                    "The Raven Lord will periodically create tributes for either team to gather in random locations." +
                            " When one team captures three tributes, the Raven Lord will curse their opponents." +
                            " While cursed, towers and forts will not fire, and lane minions are reduced to one health." +
                            " The Raven Lord's Curse does not affect the core or captured mercenaries.",

                    "There are two shrines that your team needs to control in order to activate the Dragon Knight." +
                            " Whiled activated, a hero can channel in front of the statue to control the Dragon Knight." +
                            " The Dragon Knight disappears once it is defeated or after a timer expires." +
                            " The Dragon Knight has two unique abilities, Flame Breath and Savage Charge.",

                    "Attack treasure chests, mercenaries, and skeletal doubloon camps in order to find doubloons." +
                            " Turn in your doubloons to Captain Blackheart at his pirate ship, or you will drop them all when you die." +
                            " After receiving enough doubloons from either team, Blackheart will bombard their enemies buildings." +
                            " Blackheart shoots twelve cannonballs at a time, and each volley costs more than the previous did.",

                    "At night, Shamblers will rise from the gardens. Kill the Shamblers and collect seeds for your team." +
                            " Once either team gathers 100 seeds, a Garden Terror appears in their base for one minute. Channel near it" +
                            " to gain control over it for a short period of time, or until it is destroyed. The Garden Terror" +
                            " has three unique abilities: Spawn Queen's Curse, Plant Horror Overgrowth, and Sprint.",

                    "Temples will periodically awaken. Stand within their glowing circles and defend the temple against" +
                            " the enemy team in order for the temple to unleash its power for your team. The guardians" +
                            " of the temple will attempt to remove your team from the temple grounds. Defeat them as well" +
                            " to secure the temples' power for yourselves.",

                    "Collect Gems by killing enemy spider minions and Heroes. Turn in your gems at one of the Spider Queen's" +
                            " altars, or you will drop them all when you die. Whichever team turns in enough gems will" +
                            " be granted three Webweavers, which push each lane for a short period of time, or until defeated." +
                            " Each time that a team unleashes the Webweavers, the gem cost of unleashing them again is increased.",

                    "Two immortals fight at the center of the map. Your team must help your immortal defeat the enemy team and" +
                            "their immortal. Once one immortal is defeated, the other recovers its health and then gains a shield" +
                            " proportional to how much health it had remaining when the other immortal was defeated. Then, it " +
                            " helps the winning team push one of the two lanes, Dealing high damage to structures.",

                    "The Infernal Shrines periodically gather power. Activate them and prepare for a fight. " +
                            " Defeat 30 Guardians at the active shrine to bring forth one of three unique Punishers: " +
                            " Mortar, Ice, and Arcane. Once summoned, Punishers help push the nearest lane with powerful area of " +
                            " effect attacks. But be careful, because Punishers focus on attacking heroes above all else."
            };


    /***
     * creates a new Battleground object
     *
     *
     * @param battlegroundID an integer 0 - 8, which denotes which battleground is being created.
     *                       using an integer larger than 8 or smaller than 0 will result in numerous
     *                       array out of bounds exceptions
     */
    public Battleground(int battlegroundID)
    {

    }






}
