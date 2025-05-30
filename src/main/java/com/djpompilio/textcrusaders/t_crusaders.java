//TODO - Game - Make the story for the default character "unknown" slightly different than if the player chooses to make their own build
//TODO clean up code for readability comments
//TODO internal frame for inventory
//TODO basic text mode/cleaner text log ui with font  -- toggle in settings

/* Text Crusaders
 * Dominic Pompilio © 2025
 * Text Based RPG
 * 
 */



package com.djpompilio.textcrusaders;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.*;
import java.util.*;
import javax.swing.*;


public class t_crusaders {
    static GraphicsDevice device = GraphicsEnvironment.getLocalGraphicsEnvironment().getScreenDevices()[0];
    public static void main(String[] args) {

        //OS Check

        String os = System.getProperty("os.name");
        CharSequence macoschar = "Mac OS";
        CharSequence winoschar = "Windows";
        System.out.println("Using System Property: " + os);

        if (os.contains(macoschar)) {
            System.setProperty( "apple.laf.useScreenMenuBar", "true" );
            System.setProperty( "com.apple.mrj.application.apple.menu.about.name", "Text Crusaders" );
        }
        else if (os.contains(winoschar)){
        
        }
        else {

        }


        //----------------------------------------------------------------


        String currentCmd = new String("help");
        int stVal = 0;
        int spVal = 0;
        int luVal = 0;
        int chVal = 0;


        //Font enf = new Font("");
        

        //Standalone Windows


        //Main Window

        JFrame gameFrame = new JFrame();
        gameFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        gameFrame.setSize(1280, 800);
        gameFrame.setTitle("Text Crusaders");
        gameFrame.setIconImage(null);
        JPanel framePanel = new JPanel();
        framePanel.setLayout(null);

        //JOptionPane confExitOptionPane = new JOptionPane("Are you Sure You Want to quit?", YES_NO);
        //JDialog confExit = new JDialog(frame, "Are you Sure You Want to quit?", );


        //Credits Window
        JFrame creditsFrame = new JFrame("Credits and Open Source Licenses");
        creditsFrame.setSize(550, 400);
               
        JTabbedPane creditsTabPane = new JTabbedPane();
  

        JPanel page1 = new JPanel();
        page1.add(new JLabel("This is Tab 1"));
                
        JPanel page2 = new JPanel();
        page2.add(new JLabel("This is Tab 2"));
 
        JPanel page3 = new JPanel();
        page3.add(new JLabel("This is Tab 3"));

                
        creditsTabPane.addTab("Music", page1);
        creditsTabPane.addTab("Software", page2);
        creditsTabPane.addTab("Software 2", page3);


        creditsFrame.add(creditsTabPane);
        creditsFrame.setAlwaysOnTop(true);
        creditsFrame.setLocationByPlatform(true);


        
        //About Window
        JFrame aboutFrame = new JFrame();
        aboutFrame.setTitle("About");
        aboutFrame.setLayout(new FlowLayout(FlowLayout.CENTER));
        aboutFrame.setSize(400, 150);     
        //TODO Do whats below better than this   
        JLabel aboutLabel = new JLabel("About", SwingConstants.CENTER);
        JLabel aboutLabelEDB = new JLabel("Early Development Build v.2.0.0", SwingConstants.CENTER);
        JLabel aboutLabelGame = new JLabel("Text Crusaders (working title) RPG/Adventure Game", SwingConstants.CENTER);
        JLabel aboutLabelGameBy = new JLabel("by: ", SwingConstants.CENTER);
        JLabel aboutLabelGameME = new JLabel("Dominic Pompilio :)", SwingConstants.CENTER);
        JLabel aboutLabelCopy = new JLabel("© Copyright 2025 Dominic Pompilio. All rights reserved.", SwingConstants.CENTER);
        aboutFrame.add(aboutLabel);
        aboutFrame.add(aboutLabelEDB);
        aboutFrame.add(aboutLabelGame);
        aboutFrame.add(aboutLabelGameBy);
        aboutFrame.add(aboutLabelGameME);
        aboutFrame.add(aboutLabelCopy);
        aboutFrame.setAlwaysOnTop(true);
        aboutFrame.setLocationByPlatform(true);


        //New Game Window
        JFrame newGameFrame = new JFrame();
        newGameFrame.setTitle("New Game");
        newGameFrame.setAlwaysOnTop(true);
        newGameFrame.setAutoRequestFocus(true);
        newGameFrame.setResizable(false);
        newGameFrame.setSize(500, 600);
        newGameFrame.setLocationByPlatform(true);
        JTextField nameBox_NG = new JTextField();
        JButton start_NG = new JButton("Start Game");
        JTextArea inst_NG = new JTextArea("Please, use your skill points to increase your level of the chosen attribute. You only get 5 skill points with each experience level. It may aid you upon your journey to invest wisely.");
        newGameFrame.add(nameBox_NG);
        newGameFrame.add(inst_NG);
        newGameFrame.add(start_NG);

        //Settings Window
        JFrame allSettingsFrame = new JFrame();
        allSettingsFrame.setLocationByPlatform(true);
        allSettingsFrame.setSize(550, 400);
        JTabbedPane settingsTabPane = new JTabbedPane();
  

        JPanel gameplaySettPanel = new JPanel();
        gameplaySettPanel.add(new JLabel("This is Tab 1"));
                
        JPanel appearanceSettPanel = new JPanel();
        appearanceSettPanel.add(new JLabel("This is Tab 2"));
 
        

                
        settingsTabPane.addTab("Gameplay", gameplaySettPanel);
        settingsTabPane.addTab("Appearance", appearanceSettPanel);

         allSettingsFrame.add(settingsTabPane);
        




        //Menu Bar
        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        JMenu settMenu = new JMenu("Settings");
        JMenu diffMenu = new JMenu("Difficulty");
        JMenu helpMenu = new JMenu("Help");
        JMenu toolsMenu = new JMenu("Tools");
        JMenu windowsMenu = new JMenu("Windows");



        JMenuItem newMenuItem = new JMenuItem("New Game");
        newMenuItem.setMnemonic(KeyEvent.VK_N);
        newMenuItem.setActionCommand("New");
        newMenuItem.setToolTipText("Start a New Game");

        JMenuItem loadMenuItem = new JMenuItem("Load a Save");
        loadMenuItem.setActionCommand("Open");
        loadMenuItem.setToolTipText("Load an Existing Game Save");

        JMenuItem contMenuItem = new JMenuItem("Continue");
        contMenuItem.setActionCommand("Open");
        contMenuItem.setToolTipText("Continue Playing the Most Recent Save");
        contMenuItem.setEnabled(false);

        JMenuItem saveMenuItem = new JMenuItem("Save Game");
        saveMenuItem.setActionCommand("Save");
        saveMenuItem.setToolTipText("Save Current Game");

        JMenuItem exitMenuItem = new JMenuItem("Quit");
        exitMenuItem.setActionCommand("Exit");
        exitMenuItem.setToolTipText("Quit Game");
        KeyStroke stroke = KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0);
        exitMenuItem.setAccelerator(stroke);
    

        JMenuItem FullScreenMenuItem = new JMenuItem("Full Screen");
        JMenuItem WindowedMenuItem = new JMenuItem("Windowed");
        JMenuItem MapGridMenuItem = new JMenuItem("Toggle Map Gridlines");
        JMenuItem AllSettingsMenuItem = new JMenuItem("All Settings");

        ButtonGroup diffGroup = new ButtonGroup();
        JRadioButtonMenuItem diff_NORMALMenuItem = new JRadioButtonMenuItem("Normal");
        diff_NORMALMenuItem.setSelected(true);
        JRadioButtonMenuItem diff_EASYMenuItem = new JRadioButtonMenuItem("Easy");
        JRadioButtonMenuItem diff_HARDMenuItem = new JRadioButtonMenuItem("Hard");
        JRadioButtonMenuItem diff_FUCKEDMenuItem = new JRadioButtonMenuItem("Almost Unplayable"); //TODO add warning to player upon selection


        JMenuItem helpMenuItem = new JMenuItem("Help");
        JMenuItem aboutMenuItem = new JMenuItem("About");
        JMenuItem creditsMenuItem = new JMenuItem("Credits");
        JMenuItem adventureGuideMenuItem = new JMenuItem("Adventurers Guide");


        //add menu items to menus
        fileMenu.add(newMenuItem);
        fileMenu.add(contMenuItem);
        fileMenu.add(loadMenuItem);
        fileMenu.add(saveMenuItem);
        fileMenu.addSeparator();
        fileMenu.add(exitMenuItem);

        toolsMenu.add(adventureGuideMenuItem);

        settMenu.add(AllSettingsMenuItem);
        settMenu.addSeparator();
        settMenu.add(FullScreenMenuItem);
        settMenu.add(WindowedMenuItem);
        settMenu.add(MapGridMenuItem);

        diffGroup.add(diff_NORMALMenuItem);
        diffGroup.add(diff_EASYMenuItem);
        diffGroup.add(diff_HARDMenuItem);
        diffGroup.add(diff_FUCKEDMenuItem);
        
        diffMenu.add(diff_EASYMenuItem);
        diffMenu.add(diff_NORMALMenuItem);
        diffMenu.add(diff_HARDMenuItem);
        diffMenu.add(diff_FUCKEDMenuItem);

        settMenu.addSeparator();
        settMenu.add(diffMenu);


        helpMenu.add(helpMenuItem);
        helpMenu.addSeparator();
        helpMenu.add(creditsMenuItem);
        helpMenu.add(aboutMenuItem);


        menuBar.add(fileMenu);
        menuBar.add(toolsMenu);
        menuBar.add(settMenu);
        menuBar.add(windowsMenu);
        menuBar.add(helpMenu);
        
        //*****INFO***** Action Listeners

        newMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                player player = new player();
                newGameFrame.setVisible(true);
                
                }
            });  

        diff_EASYMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                player.setDiffMult(1);
                }
            });
        diff_NORMALMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                player.setDiffMult(2);
                }
            }); 
        diff_HARDMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                player.setDiffMult(3);
                }
            });  
        diff_FUCKEDMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                player.setDiffMult(4);
                }
            });  


        exitMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
                }
            });  



        FullScreenMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (os.contains(winoschar)) {
                    device.setFullScreenWindow(gameFrame);
                    }
                }
            });

        WindowedMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (os.contains(winoschar)) {
                    device.setFullScreenWindow(null);
                    }
                }
            });

        aboutMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                aboutFrame.setVisible(true);
                aboutFrame.setAutoRequestFocus(true);
                }
            });
        creditsMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                creditsFrame.setVisible(true);
                creditsFrame.setAutoRequestFocus(true);
                }
            });
        
        AllSettingsMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                allSettingsFrame.setVisible(true);
                allSettingsFrame.setAutoRequestFocus(true);
                }
            });  



        

        JInternalFrame storyLogIF = new JInternalFrame("Story Log", true, true, true, true);
        storyLogIF.setSize(450,600);

        JScrollPane sLogScrollPane = new JScrollPane(); 
        JTextArea sLogText = new JTextArea("The Story Begins Here. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aenean sit amet justo et erat euismod consequat at convallis erat. Proin nunc lorem, lacinia ut augue vitae, imperdiet facilisis odio. Fusce finibus vehicula tortor. Duis laoreet semper sagittis. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Etiam ultricies elementum mi vitae ultrices. Ut congue malesuada ex, quis pellentesque metus pulvinar ut. Duis ut congue nunc. Etiam placerat at erat at suscipit. Nullam vitae mauris risus. Ut sem augue, ultricies vestibulum nisi sed, dignissim porta purus. In et ex massa. Pellentesque ut ipsum egestas, consequat justo in, fermentum massa.\n" + //
                        "\n" + //
                        "Mauris quis fermentum velit. Orci varius natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Suspendisse metus est, mattis eu magna nec, iaculis maximus lorem. Integer blandit ut urna at venenatis. Praesent ac mi at nibh cursus scelerisque. Nulla dapibus, odio eget iaculis tempus, eros risus tincidunt velit, ac viverra leo massa sed nibh. Fusce congue urna convallis maximus efficitur.\n" + //
                        "\n" + //
                        "Vivamus vel accumsan neque, ultrices interdum quam. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Curabitur elit sapien, semper et nunc at, pretium bibendum ligula. Quisque interdum, ex ac maximus interdum, justo tellus convallis urna, ut aliquam justo nibh vel tortor. Donec vitae ipsum non velit consequat porta sed ac turpis. Praesent dui nisi, tempus non finibus quis, faucibus ut lacus. Sed ut nisl sed velit vehicula finibus maximus a sem. Nam sodales sed enim eget sollicitudin. In neque enim, iaculis ut tortor eget, auctor mollis magna.\n" + //
                        "\n" + //
                        "Sed et tristique libero. Maecenas eleifend turpis vel sodales pellentesque. Quisque imperdiet metus et urna hendrerit rhoncus. Nunc non lobortis ligula, gravida hendrerit risus. Morbi suscipit quam in lacus tristique mollis. Ut sed libero tellus. Nulla auctor nisi metus, vitae varius felis tristique rhoncus. Praesent pretium venenatis orci, eget ullamcorper odio dictum at.\n" + //
                        "\n" + //
                        "Proin tempus sem eu porta vehicula. Sed imperdiet mi ut quam convallis, eget iaculis nisl rhoncus. Aenean sapien metus, dictum nec eros sed, tincidunt laoreet nibh. Ut eu ligula massa. Proin egestas turpis ut aliquet tempus. Quisque mauris turpis, pellentesque et sollicitudin at, luctus quis dui. Proin in condimentum velit. Aenean dolor neque, sollicitudin eu metus nec, egestas feugiat nulla.");
        sLogText.setEditable(false);
        Dimension tre = new Dimension(450, 600);
        sLogScrollPane.setPreferredSize(tre);
        sLogScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        //sLogText.setFont();
        sLogText.setBackground(null);
        sLogScrollPane.setViewportView(sLogText);
        storyLogIF.add(sLogScrollPane);

        framePanel.add(storyLogIF);



        JTextField inputBox = new JTextField("Enter Commands Here.");
        inputBox.setSize(100, 300);
        

        gameFrame.add(inputBox, BorderLayout.SOUTH);
        inputBox.requestFocus();
        
        inputBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                inputBox.setText(null);
                
                }
            });    

   
        //health, level, luck, speed, strength, charisma, gold coins

        JInternalFrame status = new JInternalFrame("Status", true, true, false, true);
        status.setSize(400,200);
        JPanel stat_panel = new JPanel(new GridLayout(5, 2));
        stat_panel.setBackground(Color.orange);
        JLabel hp = new JLabel("Health");
        JProgressBar hpProg = new JProgressBar(0, 0,100);
        hpProg.setValue(88);
        stat_panel.add(hp);
        stat_panel.add(hpProg);
        JLabel lvl = new JLabel("Level");
        JProgressBar lvlProg = new JProgressBar(0, 0,100);
        stat_panel.add(lvl);
        stat_panel.add(lvlProg);
        

        JLabel st = new JLabel("Strength  " + stVal);
        JLabel sp = new JLabel("Speed  " + spVal);
        JLabel lu = new JLabel("Luck  " + luVal);
        JLabel ch = new JLabel("Charisma  " + chVal);
        stat_panel.add(st);
        stat_panel.add(sp);
        stat_panel.add(lu);
        stat_panel.add(ch);
        
        status.add(stat_panel);

        framePanel.add(status);

        JInternalFrame inventory = new JInternalFrame("Inventory", true, true, false, true);
        inventory.setSize(400,200);
        framePanel.add(inventory);



        JInternalFrame map = new JInternalFrame("Map", false, true, false, true);
        map.setSize(400,400);
        JLabel mapErrLabel = new JLabel("Map View Unavailable :(", SwingConstants.CENTER);
        mapErrLabel.setForeground(Color.WHITE);
        map.setBackground(Color.black);
        map.add(mapErrLabel);

        framePanel.add(map);                                                                                                                                                                                                                                                                                                                                 




        //Main Frame Setup
        gameFrame.add(framePanel);
        gameFrame.setLocationByPlatform(true);
        gameFrame.setJMenuBar(menuBar);
        gameFrame.setVisible(true);
        
        //Internal Frames
        storyLogIF.setLocation(50, 50);
        storyLogIF.setVisible(true);
        status.setLocation(800, 450);
        status.setVisible(true);
        map.setLocation(800, 50);
        map.setVisible(true);


    }
}