//TODO - Game - Make the story for the default character "unknown" slightly different than if the player chooses to make their own build
//TODO clean up code for readability comments
//TODO internal frame for inventory

/* Text Crusaders
 * Dominic Pompilio © 2025
 * Text Based RPG
 * 
 */

package com.djpompilio;

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

        String currentCmd = new String("help");
        int stVal = 0;
        int spVal = 0;
        int luVal = 0;
        int chVal = 0;
        

        //os check
        String os = System.getProperty("os.name");
        CharSequence macoschar = "Mac OS";
        CharSequence winoschar = "Windows";
        System.out.println("Using System Property: " + os);

        if (os.contains(macoschar)) {
            System.setProperty( "apple.laf.useScreenMenuBar", "true" );
        }
        else if (os.contains(winoschar)){
        
        }
        else {

        }

        //Window Components
        

        //Full Windows

        //Main Window
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(1280, 800);
        frame.setIconImage(null);
        JPanel framePanel = new JPanel();
        framePanel.setLayout(null);

        //JOptionPane confExitOptionPane = new JOptionPane("Are you Sure You Want to quit?", YES_NO);
        //JDialog confExit = new JDialog(frame, "Are you Sure You Want to quit?", );


        //Credits Window
        JFrame creditsFrame = new JFrame();
        JTabbedPane creditsPane = new JTabbedPane();

        
        //About Window
        JFrame aboutFrame = new JFrame();
        aboutFrame.setTitle("About");
        aboutFrame.setLayout(new FlowLayout(FlowLayout.CENTER));
        aboutFrame.setSize(400, 150);        
        JLabel aboutLabel = new JLabel("About", SwingConstants.CENTER);
        JLabel aboutLabelEDB = new JLabel("Early Development Build v.1.6", SwingConstants.CENTER);
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


        //New Game Window
        JFrame newGameFrame = new JFrame();
        newGameFrame.setTitle("New Game");
        newGameFrame.setAlwaysOnTop(true);
        newGameFrame.setAutoRequestFocus(true);
        newGameFrame.setResizable(false);
        newGameFrame.setSize(500, 600);
        JTextField nameBox_NG = new JTextField();
        JButton start_NG = new JButton("Start Game");
        JTextArea inst_NG = new JTextArea("Please, use your skill points to increase your level of the chosen attribute. You only get 5 skill points with each experience level. It may aid you upon your journey to invest wisely.");
        newGameFrame.add(nameBox_NG);
        newGameFrame.add(inst_NG);
        newGameFrame.add(start_NG);




        //Menu Bar
        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        JMenu settMenu = new JMenu("Settings");
        JMenu diffMenu = new JMenu("Difficulty");
        JMenu helpMenu = new JMenu("Help");
        JMenu toolsMenu = new JMenu("Tools");



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

        ButtonGroup diffGroup = new ButtonGroup();
        JRadioButtonMenuItem diff_NORMALMenuItem = new JRadioButtonMenuItem("Normal");
        diff_NORMALMenuItem.setSelected(true);
        JRadioButtonMenuItem diff_EASYMenuItem = new JRadioButtonMenuItem("Easy");
        JRadioButtonMenuItem diff_HARDMenuItem = new JRadioButtonMenuItem("Hard");
        JRadioButtonMenuItem diff_ANNOYINGMenuItem = new JRadioButtonMenuItem("Almost Unplayable"); //add warning to player upon selection


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


        settMenu.add(FullScreenMenuItem);
        settMenu.add(WindowedMenuItem);
        settMenu.add(MapGridMenuItem);

        diffGroup.add(diff_NORMALMenuItem);
        diffGroup.add(diff_EASYMenuItem);
        diffGroup.add(diff_HARDMenuItem);
        diffGroup.add(diff_ANNOYINGMenuItem);
        
        diffMenu.add(diff_EASYMenuItem);
        diffMenu.add(diff_NORMALMenuItem);
        diffMenu.add(diff_HARDMenuItem);
        diffMenu.add(diff_ANNOYINGMenuItem);

        settMenu.addSeparator();
        settMenu.add(diffMenu);


        helpMenu.add(helpMenuItem);
        helpMenu.addSeparator();
        helpMenu.add(creditsMenuItem);
        helpMenu.add(aboutMenuItem);


        menuBar.add(fileMenu);
        menuBar.add(toolsMenu);
        menuBar.add(settMenu);
        menuBar.add(helpMenu);
        


        newMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                player player = new player();
                newGameFrame.setVisible(true);
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
                    device.setFullScreenWindow(frame);
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

        JInternalFrame storyLog = new JInternalFrame("Story Log", true);
        storyLog.setSize(450,600);
        JPanel sl_panel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        sl_panel.setBackground(Color.cyan);

        JTextPane sLogBox = new JTextPane();
        sLogBox.setText("testing jtextpane for the log");
        sLogBox.setEditable(false);
        sLogBox.setBackground(null);
        sLogBox.setBounds(0, 0, 450, 600);
        sLogBox.setAutoscrolls(true);

        sl_panel.add(sLogBox);

        storyLog.add(sl_panel);

        framePanel.add(storyLog);



        JTextField inputBox = new JTextField("Enter Commands Here.");
        inputBox.setSize(100, 300);
        

        frame.add(inputBox, BorderLayout.SOUTH);
        inputBox.requestFocus();
        
        inputBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sLogBox.setText(sLogBox.getText() + inputBox.getText());
                inputBox.setText(null);
                
                }
            });    

   
        //health, level, luck, speed, strength, charisma, gold coins

        JInternalFrame status = new JInternalFrame("Status", true);
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

        JInternalFrame map = new JInternalFrame("Map", false);
        map.setSize(400,400);
        JLabel mapErrLabel = new JLabel("Map View Unavailable :(", SwingConstants.CENTER);
        mapErrLabel.setForeground(Color.WHITE);
        map.setBackground(Color.black);
        map.add(mapErrLabel);

        framePanel.add(map);




        //Main Frame Setup
        frame.add(framePanel);
        frame.setLocationByPlatform(true);
        frame.setJMenuBar(menuBar);
        frame.setVisible(true);
        
        //Internal Frames
        storyLog.setLocation(50, 50);
        storyLog.setVisible(true);
        status.setLocation(800, 450);
        status.setVisible(true);
        map.setLocation(800, 50);
        map.setVisible(true);


    }
}