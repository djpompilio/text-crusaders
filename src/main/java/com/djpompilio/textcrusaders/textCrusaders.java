// TODO - Game - Make the story for the default character "unknown" slightly different than if the player chooses to make their own build
// TODO basic text mode/cleaner text log ui with font  -- toggle in settings
// TODO Pure text mode setting

/* 
 * 
 * 
 *         _____          _       ___                         _               
 *        /__   \_____  _| |_    / __\ __ _   _ ___  __ _  __| | ___ _ __ ___ 
 *          / /\/ _ \ \/ / __|  / / | '__| | | / __|/ _` |/ _` |/ _ \ '__/ __|
 *         / / |  __/>  <| |_  / /__| |  | |_| \__ \ (_| | (_| |  __/ |  \__ \
 *         \/   \___/_/\_\\__| \____/_|   \__,_|___/\__,_|\__,_|\___|_|  |___/
 * 
 * 
 *                          ---Text Crusaders---
 *                             Text Based RPG
 * 
 *                         © Dominic Pompilio  2025
 *  
 * 
 *
 *  Note: Some comments may look slightly strange or have "tags i.e. (#, *, ?, !)" at the begining. I am using
 *  Better Comments Next by: Edwin Xu to keep comments and things organized
 * 
 *  
 * 
 * 
 */

// # test

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


public class textCrusaders {
    static GraphicsDevice device = GraphicsEnvironment.getLocalGraphicsEnvironment().getScreenDevices()[0];
    
    public static void main(String[] args) throws ClassNotFoundException, IOException {


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


        //************************************************************************************


        String currentCmd = new String("help");
        int stVal = 0;
        int spVal = 0;
        int luVal = 0;
        int chVal = 0;

        map test = new map();
        test.saveMap();


       // Font ELFont = new Font("Eagle Lake", 0, 14);

        //ELFont.createFont(Font.TRUETYPE_FONT, );
        

        // nav      ---Standalone Windows---


        // Main Window

        JFrame gameFrame = new JFrame();
        gameFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        gameFrame.setSize(1280, 800);
        gameFrame.setTitle("Text Crusaders");
        gameFrame.setIconImage(null);
        JPanel framePanel = new JPanel();
        framePanel.setLayout(null);

        //JOptionPane confExitOptionPane = new JOptionPane("Are you Sure You Want to quit?", YES_NO);
        //JDialog confExit = new JDialog(frame, "Are you Sure You Want to quit?", );


        // Credits Window
        JFrame creditsFrame = new JFrame("Credits and Open Source Licenses");
        creditsFrame.setSize(550, 400);
               
        JTabbedPane creditsTabPane = new JTabbedPane();
        JTabbedPane fontCreditsTabPane = new JTabbedPane();
  

        JPanel musicCredPanel = new JPanel();
        JTextArea musicCredText = new JTextArea("\"Achaidh Cheide\", \"Adventures in Adventureland\", \"Ancient Winds\", \"Big Drumming\", \"Circus of Freaks\", \"Crusade - Heavy Industry\", \"Elf Meditation\", \"Errigal\", \"Evening\", \"Expeditionary\", \"Goblin Tinker Soldier Spy\", \"Morning\", \"Night Vigil\", \"Rites\", \"Strength of the Titans\", \"Temple of the Manes\", \"That Zen Moment\", \"The Ice Giants\", \"The North\", \"Witch Hunt\"\n" + //
                        "Kevin MacLeod (incompetech.com)\n" + //
                        "Licensed under Creative Commons: By Attribution 3.0\n" + //
                        "http://creativecommons.org/licenses/by/3.0/");
        musicCredText.setSize(525, 400);
        musicCredText.setEditable(false);
        musicCredText.setBackground(null);
        musicCredText.setLineWrap(true);
        musicCredText.setWrapStyleWord(true);

        musicCredPanel.add(musicCredText);
                
        
        JScrollPane fontELScrollPane = new JScrollPane();
        
        JTextArea fontELCredText = new JTextArea("Copyright (c) 2012, Brian J. Bonislawsky DBA Astigmatic (AOETI) (astigma@astigmatic.com), with Reserved Font Names \"Eagle Lake\"\r\n" + //
                        "\r\n" + //
                        "\r\n" + //
                        "This Font Software is licensed under the SIL Open Font License, Version 1.1.\r\n" + //
                        "This license is copied below, and is also available with a FAQ at:\r\n" + //
                        "https://openfontlicense.org\r\n" + //
                        "\r\n" + //
                        "\r\n" + //
                        "-----------------------------------------------------------\r\n" + //
                        "SIL OPEN FONT LICENSE Version 1.1 - 26 February 2007\r\n" + //
                        "-----------------------------------------------------------\r\n" + //
                        "\r\n" + //
                        "PREAMBLE\r\n" + //
                        "The goals of the Open Font License (OFL) are to stimulate worldwide\r\n" + //
                        "development of collaborative font projects, to support the font creation\r\n" + //
                        "efforts of academic and linguistic communities, and to provide a free and\r\n" + //
                        "open framework in which fonts may be shared and improved in partnership\r\n" + //
                        "with others.\r\n" + //
                        "\r\n" + //
                        "The OFL allows the licensed fonts to be used, studied, modified and\r\n" + //
                        "redistributed freely as long as they are not sold by themselves. The\r\n" + //
                        "fonts, including any derivative works, can be bundled, embedded, \r\n" + //
                        "redistributed and/or sold with any software provided that any reserved\r\n" + //
                        "names are not used by derivative works. The fonts and derivatives,\r\n" + //
                        "however, cannot be released under any other type of license. The\r\n" + //
                        "requirement for fonts to remain under this license does not apply\r\n" + //
                        "to any document created using the fonts or their derivatives.\r\n" + //
                        "\r\n" + //
                        "DEFINITIONS\r\n" + //
                        "\"Font Software\" refers to the set of files released by the Copyright\r\n" + //
                        "Holder(s) under this license and clearly marked as such. This may\r\n" + //
                        "include source files, build scripts and documentation.\r\n" + //
                        "\r\n" + //
                        "\"Reserved Font Name\" refers to any names specified as such after the\r\n" + //
                        "copyright statement(s).\r\n" + //
                        "\r\n" + //
                        "\"Original Version\" refers to the collection of Font Software components as\r\n" + //
                        "distributed by the Copyright Holder(s).\r\n" + //
                        "\r\n" + //
                        "\"Modified Version\" refers to any derivative made by adding to, deleting,\r\n" + //
                        "or substituting -- in part or in whole -- any of the components of the\r\n" + //
                        "Original Version, by changing formats or by porting the Font Software to a\r\n" + //
                        "new environment.\r\n" + //
                        "\r\n" + //
                        "\"Author\" refers to any designer, engineer, programmer, technical\r\n" + //
                        "writer or other person who contributed to the Font Software.\r\n" + //
                        "\r\n" + //
                        "PERMISSION & CONDITIONS\r\n" + //
                        "Permission is hereby granted, free of charge, to any person obtaining\r\n" + //
                        "a copy of the Font Software, to use, study, copy, merge, embed, modify,\r\n" + //
                        "redistribute, and sell modified and unmodified copies of the Font\r\n" + //
                        "Software, subject to the following conditions:\r\n" + //
                        "\r\n" + //
                        "1) Neither the Font Software nor any of its individual components,\r\n" + //
                        "in Original or Modified Versions, may be sold by itself.\r\n" + //
                        "\r\n" + //
                        "2) Original or Modified Versions of the Font Software may be bundled,\r\n" + //
                        "redistributed and/or sold with any software, provided that each copy\r\n" + //
                        "contains the above copyright notice and this license. These can be\r\n" + //
                        "included either as stand-alone text files, human-readable headers or\r\n" + //
                        "in the appropriate machine-readable metadata fields within text or\r\n" + //
                        "binary files as long as those fields can be easily viewed by the user.\r\n" + //
                        "\r\n" + //
                        "3) No Modified Version of the Font Software may use the Reserved Font\r\n" + //
                        "Name(s) unless explicit written permission is granted by the corresponding\r\n" + //
                        "Copyright Holder. This restriction only applies to the primary font name as\r\n" + //
                        "presented to the users.\r\n" + //
                        "\r\n" + //
                        "4) The name(s) of the Copyright Holder(s) or the Author(s) of the Font\r\n" + //
                        "Software shall not be used to promote, endorse or advertise any\r\n" + //
                        "Modified Version, except to acknowledge the contribution(s) of the\r\n" + //
                        "Copyright Holder(s) and the Author(s) or with their explicit written\r\n" + //
                        "permission.\r\n" + //
                        "\r\n" + //
                        "5) The Font Software, modified or unmodified, in part or in whole,\r\n" + //
                        "must be distributed entirely under this license, and must not be\r\n" + //
                        "distributed under any other license. The requirement for fonts to\r\n" + //
                        "remain under this license does not apply to any document created\r\n" + //
                        "using the Font Software.\r\n" + //
                        "\r\n" + //
                        "TERMINATION\r\n" + //
                        "This license becomes null and void if any of the above conditions are\r\n" + //
                        "not met.\r\n" + //
                        "\r\n" + //
                        "DISCLAIMER\r\n" + //
                        "THE FONT SOFTWARE IS PROVIDED \"AS IS\", WITHOUT WARRANTY OF ANY KIND,\r\n" + //
                        "EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO ANY WARRANTIES OF\r\n" + //
                        "MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT\r\n" + //
                        "OF COPYRIGHT, PATENT, TRADEMARK, OR OTHER RIGHT. IN NO EVENT SHALL THE\r\n" + //
                        "COPYRIGHT HOLDER BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY,\r\n" + //
                        "INCLUDING ANY GENERAL, SPECIAL, INDIRECT, INCIDENTAL, OR CONSEQUENTIAL\r\n" + //
                        "DAMAGES, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING\r\n" + //
                        "FROM, OUT OF THE USE OR INABILITY TO USE THE FONT SOFTWARE OR FROM\r\n" + //
                        "OTHER DEALINGS IN THE FONT SOFTWARE.\r\n" + //
                        "");
        fontELCredText.setEditable(false);
        fontELCredText.setBackground(null);
        fontELCredText.setLineWrap(true);
        fontELCredText.setWrapStyleWord(true);
        fontELScrollPane.setSize(525, 400);
        fontELScrollPane.setViewportView(fontELCredText);
        fontELScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        fontCreditsTabPane.addTab("Eagle Lake", fontELScrollPane);

                
        JScrollPane fontQTScrollPane = new JScrollPane();
        
        JTextArea fontQTCredText = new JTextArea("Copyright (c) 2012, Brian J. Bonislawsky DBA Astigmatic (AOETI) (astigma@astigmatic.com), with Reserved Font Names 'Quintessential'\r\n" + //
                        "\r\n" + //
                        "This Font Software is licensed under the SIL Open Font License, Version 1.1.\r\n" + //
                        "This license is copied below, and is also available with a FAQ at:\r\n" + //
                        "https://openfontlicense.org\r\n" + //
                        "\r\n" + //
                        "\r\n" + //
                        "-----------------------------------------------------------\r\n" + //
                        "SIL OPEN FONT LICENSE Version 1.1 - 26 February 2007\r\n" + //
                        "-----------------------------------------------------------\r\n" + //
                        "\r\n" + //
                        "PREAMBLE\r\n" + //
                        "The goals of the Open Font License (OFL) are to stimulate worldwide\r\n" + //
                        "development of collaborative font projects, to support the font creation\r\n" + //
                        "efforts of academic and linguistic communities, and to provide a free and\r\n" + //
                        "open framework in which fonts may be shared and improved in partnership\r\n" + //
                        "with others.\r\n" + //
                        "\r\n" + //
                        "The OFL allows the licensed fonts to be used, studied, modified and\r\n" + //
                        "redistributed freely as long as they are not sold by themselves. The\r\n" + //
                        "fonts, including any derivative works, can be bundled, embedded, \r\n" + //
                        "redistributed and/or sold with any software provided that any reserved\r\n" + //
                        "names are not used by derivative works. The fonts and derivatives,\r\n" + //
                        "however, cannot be released under any other type of license. The\r\n" + //
                        "requirement for fonts to remain under this license does not apply\r\n" + //
                        "to any document created using the fonts or their derivatives.\r\n" + //
                        "\r\n" + //
                        "DEFINITIONS\r\n" + //
                        "\"Font Software\" refers to the set of files released by the Copyright\r\n" + //
                        "Holder(s) under this license and clearly marked as such. This may\r\n" + //
                        "include source files, build scripts and documentation.\r\n" + //
                        "\r\n" + //
                        "\"Reserved Font Name\" refers to any names specified as such after the\r\n" + //
                        "copyright statement(s).\r\n" + //
                        "\r\n" + //
                        "\"Original Version\" refers to the collection of Font Software components as\r\n" + //
                        "distributed by the Copyright Holder(s).\r\n" + //
                        "\r\n" + //
                        "\"Modified Version\" refers to any derivative made by adding to, deleting,\r\n" + //
                        "or substituting -- in part or in whole -- any of the components of the\r\n" + //
                        "Original Version, by changing formats or by porting the Font Software to a\r\n" + //
                        "new environment.\r\n" + //
                        "\r\n" + //
                        "\"Author\" refers to any designer, engineer, programmer, technical\r\n" + //
                        "writer or other person who contributed to the Font Software.\r\n" + //
                        "\r\n" + //
                        "PERMISSION & CONDITIONS\r\n" + //
                        "Permission is hereby granted, free of charge, to any person obtaining\r\n" + //
                        "a copy of the Font Software, to use, study, copy, merge, embed, modify,\r\n" + //
                        "redistribute, and sell modified and unmodified copies of the Font\r\n" + //
                        "Software, subject to the following conditions:\r\n" + //
                        "\r\n" + //
                        "1) Neither the Font Software nor any of its individual components,\r\n" + //
                        "in Original or Modified Versions, may be sold by itself.\r\n" + //
                        "\r\n" + //
                        "2) Original or Modified Versions of the Font Software may be bundled,\r\n" + //
                        "redistributed and/or sold with any software, provided that each copy\r\n" + //
                        "contains the above copyright notice and this license. These can be\r\n" + //
                        "included either as stand-alone text files, human-readable headers or\r\n" + //
                        "in the appropriate machine-readable metadata fields within text or\r\n" + //
                        "binary files as long as those fields can be easily viewed by the user.\r\n" + //
                        "\r\n" + //
                        "3) No Modified Version of the Font Software may use the Reserved Font\r\n" + //
                        "Name(s) unless explicit written permission is granted by the corresponding\r\n" + //
                        "Copyright Holder. This restriction only applies to the primary font name as\r\n" + //
                        "presented to the users.\r\n" + //
                        "\r\n" + //
                        "4) The name(s) of the Copyright Holder(s) or the Author(s) of the Font\r\n" + //
                        "Software shall not be used to promote, endorse or advertise any\r\n" + //
                        "Modified Version, except to acknowledge the contribution(s) of the\r\n" + //
                        "Copyright Holder(s) and the Author(s) or with their explicit written\r\n" + //
                        "permission.\r\n" + //
                        "\r\n" + //
                        "5) The Font Software, modified or unmodified, in part or in whole,\r\n" + //
                        "must be distributed entirely under this license, and must not be\r\n" + //
                        "distributed under any other license. The requirement for fonts to\r\n" + //
                        "remain under this license does not apply to any document created\r\n" + //
                        "using the Font Software.\r\n" + //
                        "\r\n" + //
                        "TERMINATION\r\n" + //
                        "This license becomes null and void if any of the above conditions are\r\n" + //
                        "not met.\r\n" + //
                        "\r\n" + //
                        "DISCLAIMER\r\n" + //
                        "THE FONT SOFTWARE IS PROVIDED \"AS IS\", WITHOUT WARRANTY OF ANY KIND,\r\n" + //
                        "EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO ANY WARRANTIES OF\r\n" + //
                        "MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT\r\n" + //
                        "OF COPYRIGHT, PATENT, TRADEMARK, OR OTHER RIGHT. IN NO EVENT SHALL THE\r\n" + //
                        "COPYRIGHT HOLDER BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY,\r\n" + //
                        "INCLUDING ANY GENERAL, SPECIAL, INDIRECT, INCIDENTAL, OR CONSEQUENTIAL\r\n" + //
                        "DAMAGES, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING\r\n" + //
                        "FROM, OUT OF THE USE OR INABILITY TO USE THE FONT SOFTWARE OR FROM\r\n" + //
                        "OTHER DEALINGS IN THE FONT SOFTWARE.\r\n" + //
                        "");
        fontQTCredText.setEditable(false);
        fontQTCredText.setBackground(null);
        fontQTCredText.setLineWrap(true);
        fontQTCredText.setWrapStyleWord(true);
        fontQTScrollPane.setSize(525, 400);
        fontQTScrollPane.setViewportView(fontQTCredText);
        fontQTScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        fontCreditsTabPane.addTab("Quintessential", fontQTScrollPane);
        
        
        
        
 
        JPanel page3 = new JPanel();
        page3.add(new JLabel("This is Tab 3"));

                
        creditsTabPane.addTab("Music", musicCredPanel);
        creditsTabPane.addTab("Fonts", fontCreditsTabPane);
        creditsTabPane.addTab("Software 2", page3);


        creditsFrame.add(creditsTabPane);
        creditsFrame.setAlwaysOnTop(true);
        creditsFrame.setLocationByPlatform(true);


        
        // About Window
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


        // New Game Window
        // TODO finish new game window
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

        map map = new map();

        // Settings Window
        // TODO finish settings
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


        // nav       ---Game Frame Menu Bar---
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

        JCheckBoxMenuItem sLogMenuItem = new JCheckBoxMenuItem("Story Log", true);
        JCheckBoxMenuItem statusMenuItem = new JCheckBoxMenuItem("Status", true);
        JCheckBoxMenuItem mapMenuItem = new JCheckBoxMenuItem("Map", true);
        JCheckBoxMenuItem invMenuItem = new JCheckBoxMenuItem("Inventory", true);



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


        windowsMenu.add(sLogMenuItem);
        windowsMenu.add(mapMenuItem);
        windowsMenu.add(statusMenuItem);
        windowsMenu.add(invMenuItem);



        helpMenu.add(helpMenuItem);
        helpMenu.addSeparator();
        helpMenu.add(creditsMenuItem);
        helpMenu.add(aboutMenuItem);


        menuBar.add(fileMenu);
        menuBar.add(toolsMenu);
        menuBar.add(settMenu);
        menuBar.add(windowsMenu);
        menuBar.add(helpMenu);
 

        // nav      ---Internal Frames---

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
        sLogText.setLineWrap(true);
        sLogText.setWrapStyleWord(true);
        sLogText.setMargin(new Insets(20, 20, 10, 10));
        
        Dimension tre = new Dimension(450, 600);
        sLogScrollPane.setPreferredSize(tre);
        sLogScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        sLogText.setBackground(Color.MAGENTA);
        sLogScrollPane.setViewportView(sLogText);
        sLogScrollPane.setAutoscrolls(true);
        storyLogIF.add(sLogScrollPane);
        storyLogIF.setResizable(true);
        storyLogIF.pack();

        framePanel.add(storyLogIF);



        JTextField inputBox = new JTextField("Enter Commands Here.");
        inputBox.setSize(100, 300);
        

        gameFrame.add(inputBox, BorderLayout.SOUTH);
        inputBox.requestFocus();
        
            

   
        // Status Window
        JInternalFrame statusIF = new JInternalFrame("Status", true, true, false, true);
        statusIF.setSize(400,200);
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
        
        statusIF.add(stat_panel);

        framePanel.add(statusIF);

        JInternalFrame inventoryIF = new JInternalFrame("Inventory", true, true, false, true);
        inventoryIF.setSize(400,200);
        framePanel.add(inventoryIF);



        JInternalFrame mapIF = new JInternalFrame("Map", false, true, false, true);
        mapIF.setSize(400,400);
        JLabel mapErrLabel = new JLabel("Map View Unavailable :(", SwingConstants.CENTER);
        mapErrLabel.setForeground(Color.WHITE);
        mapIF.setBackground(Color.black);
        mapIF.add(mapErrLabel);

        framePanel.add(mapIF);                                                                                                                                                                                                                                                                                                                                 




               
        // nav      ---Action Listeners---

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


        sLogMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (storyLogIF.isVisible() == true) {
                    storyLogIF.setVisible(false);
                    }
                else {
                    storyLogIF.setVisible(true);
                }
                }
            });
        
        mapMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (mapIF.isVisible() == true) {
                    mapIF.setVisible(false);
                    }
                else {
                    mapIF.setVisible(true);
                }
                }
            });

        statusMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (statusIF.isVisible() == true) {
                    statusIF.setVisible(false);
                    }
                else {
                    statusIF.setVisible(true);
                }
                }
            });

        invMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (inventoryIF.isVisible() == true) {
                    inventoryIF.setVisible(false);
                    }
                else {
                    inventoryIF.setVisible(true);
                }
                }
            });

        inputBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                inputBox.setText(null);
                
                }
            });




        try {
            Font ELFont = Font.createFont(Font.TRUETYPE_FONT, new File("src/main/resources/media/fonts/Eagle_Lake/EagleLake-Regular.ttf"));
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(ELFont);
            sLogText.setFont(ELFont.deriveFont(18f));
            musicCredText.setFont(ELFont.deriveFont(12f));
        } 
        catch (FontFormatException | IOException e) {
            e.printStackTrace();
        }



        

        //Main Frame Setup
        gameFrame.add(framePanel);
        gameFrame.setLocationByPlatform(true);
        gameFrame.setJMenuBar(menuBar);
        gameFrame.setVisible(true);
        
        //Internal Frames
        storyLogIF.setLocation(50, 50);
        storyLogIF.setVisible(true);
        statusIF.setLocation(800, 450);
        statusIF.setVisible(true);
        mapIF.setLocation(800, 50);
        mapIF.setVisible(true);
        inventoryIF.setLocation(800, 50);
        inventoryIF.setVisible(true);


    }
    static void writeStoryLog(String story) {

    }
}