package main;

import org.rspeer.runetek.adapter.component.InterfaceComponent;
import org.rspeer.runetek.adapter.scene.Npc;
import org.rspeer.runetek.api.Login;
import org.rspeer.runetek.api.Varps;
import org.rspeer.runetek.api.commons.Time;
import org.rspeer.runetek.api.commons.math.Random;
import org.rspeer.runetek.api.component.Dialog;
import org.rspeer.runetek.api.component.Interfaces;
import org.rspeer.runetek.api.component.tab.*;
import org.rspeer.runetek.api.movement.Movement;
import org.rspeer.runetek.api.movement.position.Position;
import org.rspeer.runetek.api.scene.Npcs;
import org.rspeer.runetek.api.scene.Players;
import org.rspeer.runetek.api.scene.SceneObjects;
import org.rspeer.script.Script;
import org.rspeer.script.ScriptCategory;
import org.rspeer.script.ScriptMeta;
import org.rspeer.ui.Log;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.*;
import java.util.ArrayList;


@ScriptMeta(name = "Zoruda's Tutorial Island",  desc = "My tut island script for private use", developer = "Zoruda", category = ScriptCategory.OTHER)
public class TutorialIsland extends Script {

    private int config;
    public static final int ValueNumber = 281;
    Robot robot;
    String username;
    ArrayList<String[]> accounts = new ArrayList<String[]>();


    @Override
    public void onStart() {


    }

    @Override
    public int loop() {
        config = Varps.get(ValueNumber);

        if (Players.getLocal().getAnimation() != -1 || Players.getLocal().isMoving()) {
            return 1000;
        }

        if(Dialog.isOpen() && Dialog.canContinue()){

            Dialog.processContinue();
            return Random.nextInt(500, 1500);

        }

        switch (config){
            case 1:
                if(Interfaces.isOpen(558) && !Interfaces.getComponent(162, 45).isVisible()){
                    Interfaces.getComponent(558,7).click();
                    return 1000;
                }
                if(Interfaces.getComponent(162, 45).getText().equals("*")) {
                    try {
                        robot = new Robot();
                    } catch (AWTException e) {
                        return 300;
                    }
                    username = getAccount().getUsername().split("@gmail.com")[0];
                    username = username.substring(0, Math.min(username.length(), 12));
                    type(username);
                    robot.keyPress(KeyEvent.VK_ENTER);
                }
                if(Interfaces.isOpen(558) && Interfaces.getComponent(558, 12).getText().contains("not available")){
                    Log.severe("Taken");
                    int rand = Random.nextInt(14,16);
                    Interfaces.getComponent(558, rand).click();
                    Log.info(rand);
                    return Random.nextInt(600,1500);
                }
                if(Interfaces.isOpen(558) && Interfaces.getComponent(558, 12).getText().contains("Great!")) {
                    Interfaces.getComponent(558, 18).click();
                    return Random.nextInt(600,1500);
                }
                if(Interfaces.isOpen(269) && Interfaces.getComponent(269, 97).getText().toLowerCase().contains("welcome to runescape")){
                    if(Random.nextInt(1,5) == 5){
                        Interfaces.getComponent(269,137).click();
                    }
                    InterfaceComponent handsButtonRight;
                    InterfaceComponent legsButtonRight;
                    InterfaceComponent feetButtonRight;
                    InterfaceComponent colorHeadButtonLeft;
                    InterfaceComponent colorTorsoButtonLeft;
                    InterfaceComponent colorSkinButtonLeft;
                    InterfaceComponent colorHeadButtonRight;
                    InterfaceComponent colorTorsoButtonRight;
                    InterfaceComponent colorLegsButtonRight;
                    InterfaceComponent colorFeetButtonRight;
                    InterfaceComponent colorSkinButtonRight;
                    InterfaceComponent headButtonLeft;
                    InterfaceComponent jawButtonLeft;
                    InterfaceComponent torsoButtonLeft;
                    InterfaceComponent armsButtonLeft;
                    InterfaceComponent handsButtonLeft;
                    InterfaceComponent feetButtonLeft;
                    InterfaceComponent legsButtonLeft;
                    InterfaceComponent headButtonRight;
                    InterfaceComponent jawButtonRight;
                    InterfaceComponent armsButtonRight;
                    InterfaceComponent colorLegsButtonLeft;
                    InterfaceComponent colorFeetButtonLeft;
                    InterfaceComponent torsoButtonRight;
                    InterfaceComponent[] buttons = {
                            headButtonLeft = Interfaces.getComponent(269, 106),
                            jawButtonLeft = Interfaces.getComponent(269, 107),
                            torsoButtonLeft = Interfaces.getComponent(269, 108),
                            armsButtonLeft = Interfaces.getComponent(269, 109),
                            handsButtonLeft = Interfaces.getComponent(269, 110),
                            legsButtonLeft = Interfaces.getComponent(269, 111),
                            feetButtonLeft = Interfaces.getComponent(269, 112),

                            headButtonRight = Interfaces.getComponent(269, 113),
                            jawButtonRight = Interfaces.getComponent(269, 114),
                            torsoButtonRight = Interfaces.getComponent(269, 115),
                            armsButtonRight = Interfaces.getComponent(269, 116),
                            handsButtonRight = Interfaces.getComponent(269, 117),
                            legsButtonRight = Interfaces.getComponent(269, 118),
                            feetButtonRight = Interfaces.getComponent(269, 119),

                            colorHeadButtonLeft = Interfaces.getComponent(269, 105),
                            colorTorsoButtonLeft = Interfaces.getComponent(269, 123),
                            colorLegsButtonLeft = Interfaces.getComponent(269, 122),
                            colorFeetButtonLeft = Interfaces.getComponent(269, 124),
                            colorSkinButtonLeft = Interfaces.getComponent(269, 125),

                            colorHeadButtonRight = Interfaces.getComponent(269, 121),
                            colorTorsoButtonRight = Interfaces.getComponent(269, 127),
                            colorLegsButtonRight = Interfaces.getComponent(269, 129),
                            colorFeetButtonRight = Interfaces.getComponent(269, 130),
                            colorSkinButtonRight = Interfaces.getComponent(269, 131)
                    } ;

                    for(int i = 0; i < Random.nextInt(10, buttons.length); i++) {
                        int b = Random.nextInt(0, buttons.length);
                        for(int t = 0; t < Random.nextInt(0,8); t++) {
                            buttons[b].click();
                            //Time.sleep(Random.nextInt(100,200));
                        }
                    }
                    Time.sleep(Random.nextInt(400,3000));
                    Interfaces.getComponent(269, 99).click();
                }
            case 2:
                talkTo("Gielinor Guide");
                if(Dialog.isOpen() && !Dialog.canContinue()){

                    Dialog.process(Random.nextInt(0, Dialog.getChatOptions().length));

                }
            case 3:
                if(!Tabs.isOpen(Tab.OPTIONS)){
                    Tabs.open(Tab.OPTIONS);
                    Time.sleepUntil(() -> Tabs.isOpen(Tab.OPTIONS), 400, 5000);
                }
            case 7:
                talkTo("Gielinor Guide");
            case 10:
                interact("Door", 0, "Open");
                Time.sleepUntil(() -> Players.getLocal().isMoving(), 1500);
                Time.sleepUntil(() -> !Players.getLocal().isMoving(), 600, 5000);
            case 20:
                talkTo("Survival Expert");
            case 30:
                if(!Tabs.isOpen(Tab.INVENTORY)){
                    Tabs.open(Tab.INVENTORY);
                    Time.sleepUntil(() -> Tabs.isOpen(Tab.INVENTORY), 400, 5000);
                }
            case 40:
                interact("Fishing spot", 0, "Net");
                Time.sleepUntil(() -> Inventory.contains("Raw shrimps"), 1000, 10000);
            case 50:
                if(!Tabs.isOpen(Tab.SKILLS)){
                    Tabs.open(Tab.SKILLS);
                    Time.sleepUntil(() -> Tabs.isOpen(Tab.SKILLS), 400, 5000);
                }
            case 60:
                talkTo("Survival Expert");
            case 70:
                interact("Tree", 0, "Chop down");
                Time.sleepUntil(() -> Inventory.contains("Logs"), 1000, 10000);
            case 80:
                if(SceneObjects.getFirstAt(Players.getLocal().getPosition()).getName().equals("Fire")){
                    Movement.walkTo(new Position(Random.nextInt(3090, 3110),Random.nextInt(3075, 3110)));
                    return 200;
                } // 3103 3098

                if(Inventory.getFirst("Tinderbox").interact("Use")) {
                    Time.sleep(200);
                    if(Inventory.getFirst("Logs").interact("Use")) {
                        Time.sleepUntil(()->Players.getLocal().isMoving(),1500);
                    }
                }
                Time.sleepUntil(() -> Players.getLocal().isAnimating(), 1000, 1000);
            case 90:
                if(Inventory.getFirst("Raw shrimps").interact("Use")) {
                    Time.sleep(200);
                    if(SceneObjects.getNearest("Fire").interact("Use")) {
                        Time.sleepUntil(()->Players.getLocal().isMoving(),1500);
                    }
                }
            case 120:
                interact("Gate", 0, "Open");
            case 130:
                interact("Door", 0, "Open");
            case 140:
                talkTo("Master Chef");
            case 150:
                if(Inventory.getFirst("Pot of flour").interact("Use")) {
                    Time.sleep(200);
                    Inventory.getFirst("Bucket of water").interact("Use");
                    Time.sleepUntil(()->Inventory.contains("Bread dough"),1500);
                }
            case 160:
                if(Inventory.getFirst("Bread dough").interact("Use")) {
                    Time.sleep(200);
                    if(SceneObjects.getNearest("Range").interact("Use")) {
                        Time.sleepUntil(()->Players.getLocal().isMoving(),1500);
                    }
                }
                Time.sleepUntil(() -> Players.getLocal().isAnimating(), 1000, 1000);
            case 170:
                interact("", 9710, "Open");
            case 200:
                if(!Movement.isRunEnabled()){
                    Movement.toggleRun(true);
                }
                if(Players.getLocal().getPosition().getY() < 3122){
                    Movement.walkToRandomized(new Position(3086, 3126));
                    Time.sleepUntil(() -> Players.getLocal().isMoving(), 1500);
                    Time.sleepUntil(() -> !Players.getLocal().isMoving(), 600, 5000);
                } else {
                    interact("Door", 0, "Open");
                }
            case 220:
                talkTo("Quest Guide");
            case 230:
                if(!Tabs.isOpen(Tab.QUEST_LIST)) {
                    Tabs.open(Tab.QUEST_LIST);
                    Time.sleepUntil(() -> Tabs.isOpen(Tab.QUEST_LIST), 400, 5000);
                }
            case 240:
                talkTo("Quest Guide");
            case 250:
                interact("Ladder", 0, "Climb-down");
            case 260:
                if(Players.getLocal().getPosition().getY() > 9509){
                    Movement.walkToRandomized(new Position(3080, 9506));
                    Time.sleepUntil(() -> Players.getLocal().isMoving(), 1500);
                    Time.sleepUntil(() -> !Players.getLocal().isMoving(), 600, 5000);
                }
            case 270:
                talkTo("Mining Instructor");
            case 300:
                //10080
                interact("", 10080, "Mine");
            case 310:
                interact("", 10079, "Mine");
            case 320:
                SceneObjects.getNearest("Furnace").interact("Use");
            case 330:
                talkTo("Mining Instructor");
            case 340:
                interact("Anvil", 0, "Smith");
            case 350:
                Interfaces.getComponent(312,2).click();
                Time.sleepUntil(() -> Players.getLocal().isAnimating(), 1500);
                Time.sleepUntil(() -> !Players.getLocal().isAnimating(), 600, 5000);
            case 360:
                if(SceneObjects.getNearest("Gate") != null){
                    interact("Gate", 0, "Open");
                } else {
                    Movement.walkToRandomized(new Position(3091,9497));
                }
            case 370:
                talkTo("Combat Instructor");
            case 390:
                if(!Tabs.isOpen(Tab.EQUIPMENT)) {
                    Tabs.open(Tab.EQUIPMENT);
                    Time.sleepUntil(() -> Tabs.isOpen(Tab.EQUIPMENT), 400, 5000);
                }

            case 400:
                if(!Tabs.isOpen(Tab.EQUIPMENT)) {
                    Tabs.open(Tab.EQUIPMENT);
                    Time.sleepUntil(() -> Tabs.isOpen(Tab.EQUIPMENT), 400, 5000);
                }
                Interfaces.getComponent(387,17).click();
                Time.sleepUntil(() -> Interfaces.isOpen(387), 600, 5000);
                Time.sleep(Random.nextInt(300, 600));
                Interfaces.closeAll();
            case 405:
                if(!Tabs.isOpen(Tab.INVENTORY)) {
                    Tabs.open(Tab.INVENTORY);
                    Time.sleepUntil(() -> Tabs.isOpen(Tab.INVENTORY), 400, 5000);
                }
                Inventory.getFirst("Bronze dagger").interact("Wield");
                Time.sleepUntil(() -> EquipmentSlot.MAINHAND.getItemName() == "Bronze dagger", 600, 5000);

            case 410:
                talkTo("Combat Instructor");
            case 420:
                if(!Tabs.isOpen(Tab.INVENTORY)) {
                    Tabs.open(Tab.INVENTORY);
                    Time.sleepUntil(() -> Tabs.isOpen(Tab.INVENTORY), 400, 5000);
                }
                Inventory.getFirst("Bronze sword").interact("Wield");
                Time.sleepUntil(() -> EquipmentSlot.MAINHAND.getItemName() == "Bronze sword", 600, 5000);

                Inventory.getFirst("Wooden shield").interact("Wield");
                Time.sleepUntil(() -> EquipmentSlot.OFFHAND.getItemName() == "Wooden shield", 600, 5000);
            case 430:
                if(!Tabs.isOpen(Tab.COMBAT)) {
                    Tabs.open(Tab.COMBAT);
                    Time.sleepUntil(() -> Tabs.isOpen(Tab.COMBAT), 400, 5000);
                }
            case 440:
                interact("", 9720, "Open");
            case 450:
                Npc npc = Npcs.getNearest(3313);
                if (npc.isPositionWalkable()) {
                    npc.interact("Attack");
                    Time.sleepUntil(() -> Players.getLocal().isMoving(), 1500);
                    Time.sleepUntil(() -> !Players.getLocal().isMoving(), 600, 5000);
                    Time.sleepUntil(() -> npc == null, 600, 15000);
                }
            case 470:
                interact("", 9720, "Open");
                talkTo("Combat Instructor");
            case 480:
                if(!EquipmentSlot.MAINHAND.getItemName().equals("Shortbow")) {
                    Inventory.getFirst("Shortbow").interact("Wield");
                    Time.sleepUntil(() -> EquipmentSlot.MAINHAND.getItemName() == "Shortbow", 600, 5000);
                }
                if(!EquipmentSlot.QUIVER.getItemName().equals("Bronze arrow")) {
                    Inventory.getFirst("Bronze arrow").interact("Wield");
                    Time.sleepUntil(() -> EquipmentSlot.OFFHAND.getItemName() == "Bronze arrow", 600, 5000);
                }
                Npc npcc = Npcs.getNearest(3313);
                if (EquipmentSlot.MAINHAND.getItemName().equals("Shortbow") && EquipmentSlot.QUIVER.getItemName().equals("Bronze arrow")) {
                    npcc.interact("Attack");
                    Time.sleepUntil(() -> Players.getLocal().isMoving(), 1500);
                    Time.sleepUntil(() -> !Players.getLocal().isMoving(), 600, 5000);
                    Time.sleepUntil(() -> npcc == null, 600, 15000);
                }
            case 500:
                if(SceneObjects.getNearest("Ladder") == null){
                    Movement.walkToRandomized(new Position(3111,9525));
                } else {
                    interact("Ladder", 0, "Climb-up");
                }
            case 510:
                interact("Bank booth", 0, "Use");
            case 520:
                interact("Poll booth", 0, "Use");
            case 525:
                interact("", 9721, "Open");
            case 530:
                talkTo("Account Guide");
            case 531:
                if(!Tabs.isOpen(Tab.ACCOUNT_MANAGEMENT)) {
                    Tabs.open(Tab.ACCOUNT_MANAGEMENT);
                    Time.sleepUntil(() -> Tabs.isOpen(Tab.ACCOUNT_MANAGEMENT), 400, 5000);
                }
            case 532:
                talkTo("Account Guide");
            case 540:
                interact("", 9722, "Open");
            case 550:
                if((!Npcs.getNearest("Brother Brace").isPositionWalkable())){
                    interact("", 1106, "Open");
                } else {
                    talkTo("Brother Brace");
                }
            case 560:
                if(!Tabs.isOpen(Tab.PRAYER)) {
                    Tabs.open(Tab.PRAYER);
                    Time.sleepUntil(() -> Tabs.isOpen(Tab.PRAYER), 400, 5000);
                }
            case 570:
                if((!Npcs.getNearest("Brother Brace").isPositionWalkable())){
                    interact("", 1106, "Open");
                } else {
                    talkTo("Brother Brace");
                }
            case 580:
                if(!Tabs.isOpen(Tab.FRIENDS_LIST)) {
                    Tabs.open(Tab.FRIENDS_LIST);
                    Time.sleepUntil(() -> Tabs.isOpen(Tab.FRIENDS_LIST), 400, 5000);
                }
            case 600:
                if((!Npcs.getNearest("Brother Brace").isPositionWalkable())){
                    interact("", 1106, "Open");
                } else {
                    talkTo("Brother Brace");
                }
            case 610:
                interact("", 9723, "Open");
            case 620:
                if(Npcs.getNearest("Magic Instructor") == null){
                    Movement.walkToRandomized(new Position(3140,3087));
                } else {
                    talkTo("Magic Instructor");
                }
            case 630:
                if(!Tabs.isOpen(Tab.MAGIC)) {
                    Tabs.open(Tab.MAGIC);
                    Time.sleepUntil(() -> Tabs.isOpen(Tab.MAGIC), 400, 5000);
                }
            case 640:
                talkTo("Magic Instructor");
            case 650:
                Npc chicken = Npcs.getNearest("Chicken");
                Magic.cast(Spell.Modern.WIND_STRIKE, chicken);
                Time.sleep(Random.nextInt(200,600));
            case 670:
                talkTo("Magic Instructor");
                if(Dialog.getChatOptions().length == 2){
                    Dialog.process(0);
                }
                if(Dialog.getChatOptions().length == 3){
                    Dialog.process(2);
                }
                return Random.nextInt(1000,1500);
            case 1000:
                /*accounts.remove(username);
                Tabs.open(Tab.LOGOUT);
                Time.sleep(Random.nextInt(500));
                Interfaces.getComponent(182,8).click();
                int account = Random.nextInt(0, accounts.size());
                while(accounts.get(account)[2].equalsIgnoreCase("true")){
                    account = Random.nextInt(0, accounts.size());
                }
                if(accounts.get(account)[2].equalsIgnoreCase("false")) {
                    Login.enterCredentials(accounts.get(account)[0], accounts.get(account)[1]);
                }*/


        }

        return 0;
    }

    private boolean talkTo(String name){
        if (Npcs.getNearest(name) != null && !Dialog.isOpen() && Npcs.getNearest(name).isPositionWalkable()){
            Npcs.getNearest(name).click();
            Time.sleepUntil(Dialog::isOpen, 1000, 10000);
            return true;
        }
        return false;
    }

    private boolean interact(String name, int id, String action){
        try {
            if (name != "") {
                if (SceneObjects.getNearest(name).isPositionWalkable()) {
                    SceneObjects.getNearest(name).interact(action);
                    Time.sleepUntil(() -> Players.getLocal().isMoving(), 1500);
                    Time.sleepUntil(() -> !Players.getLocal().isMoving(), 600, 5000);
                    return true;
                }
            }
            if (id != 0) {
                if (SceneObjects.getNearest(id).isPositionWalkable()) {
                    SceneObjects.getNearest(id).interact(action);
                    Time.sleepUntil(() -> Players.getLocal().isMoving(), 1500);
                    Time.sleepUntil(() -> !Players.getLocal().isMoving(), 600, 5000);
                    return true;
                }
            }
        }
        catch(NullPointerException e){
            if (name != "") {
                if (Npcs.getNearest(name).isPositionWalkable()) {
                    Npcs.getNearest(name).interact(action);
                    Time.sleepUntil(() -> Players.getLocal().isMoving(), 1500);
                    Time.sleepUntil(() -> !Players.getLocal().isMoving(), 600, 5000);
                    return true;
                }
            }
            if (id != 0) {
                if (Npcs.getNearest(id).isPositionWalkable()) {
                    Npcs.getNearest(id).interact(action);
                    Time.sleepUntil(() -> Players.getLocal().isMoving(), 1500);
                    Time.sleepUntil(() -> !Players.getLocal().isMoving(), 600, 5000);
                    return true;
                }
            }
        }
        return false;
    }

    private void type(String s){
        byte[] bytes = s.getBytes();
        for (byte b : bytes)
        {
            int code = b;
            // keycode only handles [A-Z] (which is ASCII decimal [65-90])
            if (code > 96 && code < 123) code = code - 32;
            robot.delay(200);
            robot.keyPress(code);
            robot.keyRelease(code);
        }
    }

    @Override
    public void onStop() {


    }
}