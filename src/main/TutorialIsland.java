package main;

import org.rspeer.RSPeer;
import org.rspeer.runetek.adapter.component.InterfaceComponent;
import org.rspeer.runetek.adapter.scene.Npc;
import org.rspeer.runetek.api.Varps;
import org.rspeer.runetek.api.commons.Time;
import org.rspeer.runetek.api.commons.math.Random;
import org.rspeer.runetek.api.component.Bank;
import org.rspeer.runetek.api.component.Dialog;
import org.rspeer.runetek.api.component.Interfaces;
import org.rspeer.runetek.api.component.Production;
import org.rspeer.runetek.api.component.tab.*;
import org.rspeer.runetek.api.input.Keyboard;
import org.rspeer.runetek.api.movement.Movement;
import org.rspeer.runetek.api.movement.position.Area;
import org.rspeer.runetek.api.movement.position.Position;
import org.rspeer.runetek.api.scene.HintArrow;
import org.rspeer.runetek.api.scene.Npcs;
import org.rspeer.runetek.api.scene.Players;
import org.rspeer.runetek.api.scene.SceneObjects;
import org.rspeer.script.Script;
import org.rspeer.script.ScriptCategory;
import org.rspeer.script.ScriptMeta;
import org.rspeer.ui.Log;

import java.awt.*;
import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.util.function.BooleanSupplier;


@ScriptMeta(name = "Zoruda's Tutorial Island",  desc = "My tut island script for private use", version = 1.1, developer = "Zoruda", category = ScriptCategory.OTHER)
public class TutorialIsland extends Script {

    private static final int ValueNumber = 281;
    private Robot robot;
    private int mineExtra = Random.nextInt(1,6);
    private int afterIsland = Random.nextInt(1,8);

    private Area chickens = Area.polygonal(
            new Position(3137, 3091, 0),
            new Position(3140, 3088, 0),
            new Position(3140, 3087, 0),
            new Position(3144, 3087, 0),
            new Position(3144, 3090, 0),
            new Position(3142, 3092, 0),
            new Position(3137, 3092, 0));


    @Override
    public void onStart() {
        //Login.enterCredentials(RSPeer.getQuickStartArgs().getRsUsername(),RSPeer.getQuickStartArgs().getRsPassword());
    }

    @Override
    public int loop() {

        int config = Varps.get(ValueNumber);

        BooleanSupplier Animating = () -> Players.getLocal().isAnimating();
        BooleanSupplier Moving = () -> Players.getLocal().isMoving();
        BooleanSupplier NotMoving = () -> !Players.getLocal().isMoving();

        if (Players.getLocal().getAnimation() != -1 || Players.getLocal().isMoving()) {
            return 1000;
        }

        if(Dialog.isOpen() && Dialog.canContinue()){

            Dialog.processContinue();
            return 900;

        }

        if(Players.getLocal().getPosition().distance(HintArrow.getPosition()) > 20){
            Movement.walkToRandomized(HintArrow.getPosition());
            Time.sleepUntil(Moving, 1500);
            Time.sleepUntil(NotMoving, 600, 5000);
        }

        switch (config){
            case 0:
                return 1000;
            case 1:
                if(Interfaces.getComponent(558,11) != null && Interfaces.getComponent(558,11).getText().equalsIgnoreCase("") && !Interfaces.getComponent(162, 45).getText().contains("*")){
                    Interfaces.getComponent(558,7).click();
                    Time.sleep(1000);
                }
                if(Interfaces.isOpen(558)) {
                    if (Interfaces.getComponent(558, 12) != null && Interfaces.getComponent(558, 12).getText().contains("Great!")) {
                        Interfaces.getComponent(558, 18).click();
                        Time.sleepUntil(() -> !Interfaces.isOpen(558), 600, 7000);
                        return Random.nextInt(500, 1000);
                    }
                    if (Interfaces.isOpen(558) && Interfaces.getComponent(558, 12).getText().contains("not available")) {
                        int rand = Random.nextInt(14, 16);
                        Interfaces.getComponent(558, rand).click();
                        return Random.nextInt(600, 1500);
                    }
                    if (Interfaces.getComponent(162, 45) != null && Interfaces.getComponent(162, 45).getText().equals("*")) {
                        String username = getAccount().getUsername().split("@gmail.com")[0];
                        username = username.substring(0, Math.min(username.length(), 12));
                        type(username);
                        Keyboard.pressEnter();
                        Time.sleepUntil(() -> Interfaces.getComponent(558, 12).getText().contains("Requesting"), 100, 1500);
                        Time.sleepUntil(() -> !Interfaces.getComponent(558, 12).getText().contains("Requesting"), 300, 7000);
                    }
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

                    for(int i = 0; i < Random.nextInt(buttons.length - 5, buttons.length * 3); i++) {
                        int b = Random.nextInt(0, buttons.length);
                        for(int t = 0; t < Random.nextInt(0,8); t++) {
                            buttons[b].click();
                            //Time.sleep(Random.nextInt(100,200));
                        }
                    }
                    Time.sleep(Random.nextInt(400,3000));
                    Interfaces.getComponent(269, 99).click();
                }
                break;
            case 2:
                talkTo("Gielinor Guide");
                if(Dialog.isOpen() && !Dialog.canContinue()){

                    Dialog.process(Random.nextInt(0, Dialog.getChatOptions().length));

                }
                break;
            case 3:
                if(!Tabs.isOpen(Tab.OPTIONS)){
                    Tabs.open(Tab.OPTIONS);
                    Time.sleep(Random.nextInt(300,800));
                    Time.sleepUntil(() -> Tabs.isOpen(Tab.OPTIONS), 400, 5000);
                }
                break;
            case 7:
                talkTo("Gielinor Guide");
                break;
            case 10:
                interact("Door", 0, "Open");
                Time.sleepUntil(Moving, 1500);
                Time.sleepUntil(NotMoving, 600, 5000);
                break;
            case 20:
            case 60:
                talkTo("Survival Expert");
                break;
            case 30:
                if(!Tabs.isOpen(Tab.INVENTORY)){
                    Tabs.open(Tab.INVENTORY);
                    Time.sleep(Random.nextInt(300,800));
                    Time.sleepUntil(() -> Tabs.isOpen(Tab.INVENTORY), 1000, 5000);
                }
                break;
            case 40:
                interact("Fishing spot", 0, "Net");
                Time.sleepUntil(() -> Inventory.contains("Raw shrimps"), 1000, 10000);
                break;
            case 50:
                if(!Tabs.isOpen(Tab.SKILLS)){
                    Tabs.open(Tab.SKILLS);
                    Time.sleep(Random.nextInt(300,800));
                    Time.sleepUntil(() -> Tabs.isOpen(Tab.SKILLS), 400, 5000);
                }
                break;
            case 70:
                interact("Tree", 0, "Chop down");
                Time.sleepUntil(() -> Inventory.contains("Logs"), 1000, 10000);
                break;
            case 80:
                if(SceneObjects.getFirstAt(Players.getLocal().getPosition()) != null && SceneObjects.getFirstAt(Players.getLocal().getPosition()).getName().equals("Fire")){
                    Movement.walkTo(new Position(Random.nextInt(3090, 3110),Random.nextInt(3075, 3110)));
                    return 200;
                } // 3103 3098

                if(Inventory.getFirst("Tinderbox").interact("Use")) {
                    Time.sleep(200);
                    if(Inventory.getFirst("Logs").interact("Use")) {
                        Time.sleepUntil(Moving,1500);
                    }
                }
                Time.sleepUntil(Animating, 1000, 1000);
                break;
            case 90:
                if(Inventory.getFirst("Raw shrimps").interact("Use")) {
                    Time.sleep(200);
                    if(SceneObjects.getNearest("Fire").interact("Use")) {
                        Time.sleepUntil(Moving,1500);
                    }
                }
                break;
            case 120:
                interact("Gate", 0, "Open");
                break;
            case 130:
                interact("Door", 0, "Open");
                break;
            case 140:
                talkTo("Master Chef");
                break;
            case 150:
                if(Inventory.getFirst("Pot of flour").interact("Use")) {
                    Time.sleep(200);
                    Inventory.getFirst("Bucket of water").interact("Use");
                    Time.sleepUntil(()->Inventory.contains("Bread dough"),1500);
                }
                break;
            case 160:
                if(Inventory.getFirst("Bread dough").interact("Use")) {
                    Time.sleep(200);
                    if(SceneObjects.getNearest("Range").interact("Use")) {
                        Time.sleepUntil(Moving,1500);
                    }
                }
                Time.sleepUntil(Animating, 1000, 1000);
                break;
            case 170:
                interact("", 9710, "Open");
                break;
            case 200:
                if(!Movement.isRunEnabled()){
                    Movement.toggleRun(true);
                }
                if(Players.getLocal().getPosition().getY() < 3122){
                    Movement.walkToRandomized(new Position(3086, 3126));
                    Time.sleepUntil(Moving, 1500);
                    Time.sleepUntil(NotMoving, 600, 5000);
                } else {
                    interact("Door", 0, "Open");
                }
                break;
            case 220:
                talkTo("Quest Guide");
                break;
            case 230:
                if(!Tabs.isOpen(Tab.QUEST_LIST)) {
                    Tabs.open(Tab.QUEST_LIST);
                    Time.sleep(Random.nextInt(300,800));
                    Time.sleepUntil(() -> Tabs.isOpen(Tab.QUEST_LIST), 400, 5000);
                }
                break;
            case 240:
                talkTo("Quest Guide");
                break;
            case 250:
                interact("Ladder", 0, "Climb-down");
                break;
            case 260:
                if(Players.getLocal().getPosition().getY() > 9509){
                    Movement.walkToRandomized(new Position(3080, 9506));
                    Time.sleepUntil(Moving, 1500);
                    Time.sleepUntil(() -> !Players.getLocal().isMoving(), 600, 5000);
                }
                talkTo("Mining Instructor");
                break;
            case 270:
                talkTo("Mining Instructor");
                break;
            case 300:
                if(mineExtra == 1){
                    for(int i = 0; i < Random.nextInt(2,8); i++){
                        if (Players.getLocal().getAnimation() != -1 || Players.getLocal().isMoving()) {
                            Time.sleep(Random.nextInt(500,2000));
                        }
                        interact("", 10080, "Mine");
                    }
                }
                interact("", 10080, "Mine");
                break;
            case 310:
                if(mineExtra == 1){
                    for(int i = 0; i < Random.nextInt(2,8); i++){
                        if (Players.getLocal().getAnimation() != -1 || Players.getLocal().isMoving()) {
                            Time.sleep(Random.nextInt(500,2000));
                        }
                        interact("", 10079, "Mine");
                    }
                }
                interact("", 10079, "Mine");
                break;
            case 320:
                SceneObjects.getNearest("Furnace").interact("Use");
                if(Production.isOpen()){
                    Production.initiate("Bronze bar");
                    Time.sleepUntil(Animating, 2000);
                    Time.sleepUntil(() -> !Players.getLocal().isAnimating(), 600, 10000);
                }
                break;
            case 330:
                talkTo("Mining Instructor");
                break;
            case 340:
                interact("Anvil", 0, "Smith");
                break;
            case 350:
                Interfaces.getComponent(312,2).click();
                Time.sleepUntil(Animating, 1500);
                Time.sleepUntil(() -> !Players.getLocal().isAnimating(), 600, 5000);
                break;
            case 360:
                if(SceneObjects.getNearest("Gate") != null){
                    interact("Gate", 0, "Open");
                } else {
                    Movement.walkToRandomized(new Position(3091,9497));
                }
                break;
            case 370:
            case 410:
                talkTo("Combat Instructor");
                break;
            case 390:
                if(!Tabs.isOpen(Tab.EQUIPMENT)) {
                    Tabs.open(Tab.EQUIPMENT);
                    Time.sleep(Random.nextInt(300,800));
                    Time.sleepUntil(() -> Tabs.isOpen(Tab.EQUIPMENT), 400, 5000);
                }
                break;
            case 400:
                if(!Tabs.isOpen(Tab.EQUIPMENT)) {
                    Tabs.open(Tab.EQUIPMENT);
                    Time.sleep(Random.nextInt(300,800));
                    Time.sleepUntil(() -> Tabs.isOpen(Tab.EQUIPMENT), 400, 5000);
                }
                Interfaces.getComponent(387,17).click();
                Time.sleepUntil(() -> Interfaces.isOpen(387), 600, 5000);
                Time.sleep(Random.nextInt(300, 600));
                Interfaces.closeAll();
                break;
            case 405:
                if(!Tabs.isOpen(Tab.INVENTORY)) {
                    Tabs.open(Tab.INVENTORY);
                    Time.sleep(Random.nextInt(300,800));
                    Time.sleepUntil(() -> Tabs.isOpen(Tab.INVENTORY), 400, 5000);
                }
                Inventory.getFirst("Bronze dagger").interact("Wield");
                Time.sleepUntil(() -> EquipmentSlot.MAINHAND.getItemName().equals("Bronze dagger"), 600, 5000);
                break;
            case 420:
                if(!Tabs.isOpen(Tab.INVENTORY)) {
                    Tabs.open(Tab.INVENTORY);
                    Time.sleep(Random.nextInt(300,800));
                    Time.sleepUntil(() -> Tabs.isOpen(Tab.INVENTORY), 400, 5000);
                }
                Inventory.getFirst("Bronze sword").interact("Wield");
                Time.sleepUntil(() -> EquipmentSlot.MAINHAND.getItemName().equals("Bronze sword"), 600, 5000);

                Inventory.getFirst("Wooden shield").interact("Wield");
                Time.sleepUntil(() -> EquipmentSlot.OFFHAND.getItemName().equals("Wooden shield"), 600, 5000);
                break;
            case 430:
                if(!Tabs.isOpen(Tab.COMBAT)) {
                    Tabs.open(Tab.COMBAT);
                    Time.sleep(Random.nextInt(300,800));
                    Time.sleepUntil(() -> Tabs.isOpen(Tab.COMBAT), 400, 5000);
                }
                break;
            case 440:
            case 450:
            case 460:
                Npc npc = Npcs.getNearest(3313);
                if (!npc.isPositionInteractable()){
                    interact("", 9720, "Open");
                    Time.sleepUntil(npc::isPositionInteractable, 1000, 5000);
                }
                if (npc.isPositionInteractable() && !Players.getLocal().isHealthBarVisible()) {
                    npc.interact("Attack");
                    Time.sleepUntil(Moving, 1500);
                    Time.sleepUntil(NotMoving, 600, 5000);
                    Time.sleepUntil(() -> npc == null, 600, 15000);
                } else {
                    return Random.nextInt(300,600);
                }
                Time.sleepUntil(() -> config == 470, 600, 10000);

                break;
            case 470:
                interact("", 9720, "Open");
                Npc instructor = Npcs.getNearest("Combat Instructor");
                if(instructor.isPositionWalkable()){
                    talkTo("Combat Instructor");
                } else {
                    interact("", 9720, "Open");
                }
                break;
            case 490:
            case 480:
                if(!EquipmentSlot.MAINHAND.getItemName().equals("Shortbow")) {
                    Inventory.getFirst("Shortbow").interact("Wield");
                    Time.sleepUntil(() -> EquipmentSlot.MAINHAND.getItemName().equals("Shortbow"), 600, 5000);
                }
                if(!EquipmentSlot.QUIVER.getItemName().equals("Bronze arrow")) {
                    Inventory.getFirst("Bronze arrow").interact("Wield");
                    Time.sleepUntil(() -> EquipmentSlot.OFFHAND.getItemName().equals("Bronze arrow"), 600, 5000);
                }
                Npc npcc = Npcs.getNearest(3313);
                if (EquipmentSlot.MAINHAND.getItemName().equals("Shortbow") && EquipmentSlot.QUIVER.getItemName().equals("Bronze arrow") && !Players.getLocal().isHealthBarVisible()) {
                    npcc.interact("Attack");
                    Time.sleepUntil(() -> npcc == null, 600, 15000);
                }
                break;
            case 500:
                if(SceneObjects.getNearest("Ladder") == null){
                    Movement.walkToRandomized(new Position(3111,9525));
                } else {
                    interact("Ladder", 0, "Climb-up");
                }
                break;
            case 510:
                interact("Bank booth", 0, "Use");
                break;
            case 520:
                interact("Poll booth", 0, "Use");
                break;
            case 525:
                interact("", 9721, "Open");
                break;
            case 530:
            case 532:
                talkTo("Account Guide");
                break;
            case 531:
                if(!Tabs.isOpen(Tab.ACCOUNT_MANAGEMENT)) {
                    Tabs.open(Tab.ACCOUNT_MANAGEMENT);
                    Time.sleep(Random.nextInt(300,800));
                    Time.sleepUntil(() -> Tabs.isOpen(Tab.ACCOUNT_MANAGEMENT), 400, 5000);
                }
                break;
            case 540:
                interact("", 9722, "Open");
                break;
            case 550:
                if(Npcs.getNearest("Brother Brace") == null){
                    Movement.walkToRandomized(new Position(3121, 3106));
                }else if((!Npcs.getNearest("Brother Brace").isPositionWalkable())){
                    interact("", 1106, "Open");
                } else {
                    talkTo("Brother Brace");
                }
                break;
            case 560:
                if(!Tabs.isOpen(Tab.PRAYER)) {
                    Tabs.open(Tab.PRAYER);
                    Time.sleep(Random.nextInt(300,800));
                    Time.sleepUntil(() -> Tabs.isOpen(Tab.PRAYER), 400, 5000);
                }
                break;
            case 570:
            case 600:
                if((!Npcs.getNearest("Brother Brace").isPositionWalkable())){
                    interact("", 1106, "Open");
                } else {
                    talkTo("Brother Brace");
                }
                break;
            case 580:
                if(!Tabs.isOpen(Tab.FRIENDS_LIST)) {
                    Tabs.open(Tab.FRIENDS_LIST);
                    Time.sleep(Random.nextInt(300,800));
                    Time.sleepUntil(() -> Tabs.isOpen(Tab.FRIENDS_LIST), 400, 5000);
                }
                break;
            case 610:
                interact("", 9723, "Open");
                break;
            case 620:
                if(Npcs.getNearest("Magic Instructor") == null){
                    Movement.walkToRandomized(new Position(3140,3087));
                } else {
                    talkTo("Magic Instructor");
                }
                break;
            case 630:
                if(!Tabs.isOpen(Tab.MAGIC)) {
                    Tabs.open(Tab.MAGIC);
                    Time.sleep(Random.nextInt(300,800));
                    Time.sleepUntil(() -> Tabs.isOpen(Tab.MAGIC), 400, 5000);
                }
                break;
            case 640:
                talkTo("Magic Instructor");
                break;
            case 650:
                if(!chickens.contains(Players.getLocal().getPosition())){
                    Movement.walkToRandomized(chickens.getCenter());
                    return 1000;
                }
                if(Interfaces.getComponent(162,44).getText().equals("I can't reach that!") || Interfaces.getComponent(162,44).getText().equals("Someone is already attacking that!")){
                    Interfaces.getComponent(162, 45).click();
                }
                Npc chicken = Npcs.getNearest("Chicken");
                Magic.cast(Spell.Modern.WIND_STRIKE, chicken);
                Time.sleep(Random.nextInt(200,600));
                break;
            case 670:
                if(Interfaces.getComponent(162,44).getText().equals("I can't reach that!") || Interfaces.getComponent(162,44).getText().equals("Someone is already attacking that!")){
                    Interfaces.getComponent(162, 45).click();
                }
                talkTo("Magic Instructor");
                if(Dialog.getChatOptions().length == 2){
                    Dialog.process(0);
                }
                if(Dialog.getChatOptions().length == 3){
                    Dialog.process(2);
                }
                Time.sleep(Random.nextInt(1500,3000));
                break;
            case 1000:
                Time.sleep(Random.nextInt(1000,10000));
                switch(afterIsland){
                    case 1:
                        if(Bank.isOpen()){
                            Bank.depositInventory();
                            int rand = Random.nextInt(1,3);
                            if(rand == 1){
                                Bank.depositEquipment();
                            } else if(rand == 2) {
                                Bank.depositInventory();
                            } else if(rand == 3){
                                Bank.depositEquipment();
                                Bank.depositInventory();
                            }
                            replaceSelected(RSPeer.getQuickStartArgs().getRsUsername() + "," + RSPeer.getQuickStartArgs().getRsPassword());
                            RSPeer.shutdown();
                        } else {
                            Bank.open();
                        }
                    case 2:
                        if(Skills.getCurrentLevel(Skill.ATTACK) > 3) {
                            replaceSelected(RSPeer.getQuickStartArgs().getRsUsername() + "," + RSPeer.getQuickStartArgs().getRsPassword());
                            RSPeer.shutdown();
                        } else {
                            if(Players.getLocal().getPosition().distance(new Position(3253,3245)) < 30){
                                Npc goblin = Npcs.getNearest("Goblin");
                                if (goblin.isPositionWalkable() && !Players.getLocal().isHealthBarVisible()) {
                                    goblin.interact("Attack");
                                    Time.sleepUntil(Moving, 1500);
                                    Time.sleepUntil(NotMoving, 600, 5000);
                                    Time.sleepUntil(() -> goblin == null, 2000, 25000);
                                }
                            } else {
                                Movement.walkToRandomized(new Position (3253, 3245));
                            }
                        }
                    case 3:
                        if(Players.getLocal().getPosition().distance(new Position(3160,3490)) < 10) {
                            replaceSelected(RSPeer.getQuickStartArgs().getRsUsername() + "," + RSPeer.getQuickStartArgs().getRsPassword());
                            RSPeer.shutdown();
                        } else {
                            Movement.walkToRandomized(new Position (3160, 3490));
                        }
                    case 4:
                        if(Players.getLocal().getPosition().distance(new Position(3091,3242)) < 8) {
                            replaceSelected(RSPeer.getQuickStartArgs().getRsUsername() + "," + RSPeer.getQuickStartArgs().getRsPassword());
                            RSPeer.shutdown();
                        } else {
                            Movement.walkToRandomized(new Position (3091, 3242));
                        }
                    case 5:
                        replaceSelected(RSPeer.getQuickStartArgs().getRsUsername() + "," + RSPeer.getQuickStartArgs().getRsPassword());
                        RSPeer.shutdown();
                    case 6:
                        replaceSelected(RSPeer.getQuickStartArgs().getRsUsername() + "," + RSPeer.getQuickStartArgs().getRsPassword());
                        RSPeer.shutdown();
                    case 7:
                        replaceSelected(RSPeer.getQuickStartArgs().getRsUsername() + "," + RSPeer.getQuickStartArgs().getRsPassword());
                        RSPeer.shutdown();
                    case 8:
                        replaceSelected(RSPeer.getQuickStartArgs().getRsUsername() + "," + RSPeer.getQuickStartArgs().getRsPassword());
                        RSPeer.shutdown();
                }

                break;
            default:
                Log.severe("Unexpected value: " + config);
                return 0;
        }

        return 0;
    }

    private static void replaceSelected(String replaceWith) {
        try {
            BufferedReader file = new BufferedReader(new FileReader("/home/zoruda/Coding/Runescape/Zoruda-s-Tutorial-Island/accounts.csv"));
            StringBuilder inputBuffer = new StringBuilder();
            String line;

            while ((line = file.readLine()) != null) {
                inputBuffer.append(line);
                inputBuffer.append('\n');
            }
            file.close();
            String inputStr = inputBuffer.toString();
            inputStr = inputStr.replace(replaceWith + ",FALSE", replaceWith + ",TRUE");
            FileOutputStream fileOut = new FileOutputStream("/home/zoruda/Coding/Runescape/Zoruda-s-Tutorial-Island/accounts.csv");
            fileOut.write(inputStr.getBytes());
            fileOut.close();

        } catch (Exception e) {
            Log.severe("Problem reading file." + e);
        }
    }

    private void talkTo(String name){
        if (Npcs.getNearest(name) != null && !Dialog.isOpen() && Npcs.getNearest(name).isPositionWalkable()){
            Npcs.getNearest(name).click();
            Time.sleepUntil(Dialog::isOpen, 1000, 10000);
        }
    }

    private void interact(String name, int id, String action){
        try {
            if (!name.equals("")) {
                if (SceneObjects.getNearest(name).isPositionWalkable()) {
                    SceneObjects.getNearest(name).interact(action);
                    Time.sleepUntil(() -> Players.getLocal().isMoving(), 1500);
                    Time.sleepUntil(() -> !Players.getLocal().isMoving(), 600, 5000);
                    return;
                }
            }
            if (id != 0) {
                if (SceneObjects.getNearest(id).isPositionWalkable()) {
                    SceneObjects.getNearest(id).interact(action);
                    Time.sleepUntil(() -> Players.getLocal().isMoving(), 1500);
                    Time.sleepUntil(() -> !Players.getLocal().isMoving(), 600, 5000);
                }
            }
        }
        catch(NullPointerException e){
            if (!name.equals("")) {
                if (Npcs.getNearest(name).isPositionWalkable()) {
                    Npcs.getNearest(name).interact(action);
                    Time.sleepUntil(() -> Players.getLocal().isMoving(), 1500);
                    Time.sleepUntil(() -> !Players.getLocal().isMoving(), 600, 5000);
                    return;
                }
            }
            if (id != 0) {
                if (Npcs.getNearest(id).isPositionWalkable()) {
                    Npcs.getNearest(id).interact(action);
                    Time.sleepUntil(() -> Players.getLocal().isMoving(), 1500);
                    Time.sleepUntil(() -> !Players.getLocal().isMoving(), 600, 5000);
                }
            }
        }
    }

    private void type(String s){
        char[] Char = s.toCharArray();
        for (char b : Char)
        {
            Time.sleep(Random.nextInt(100,400));
            Keyboard.sendKey(b);
        }
    }

    @Override
    public void onStop() {


    }
}