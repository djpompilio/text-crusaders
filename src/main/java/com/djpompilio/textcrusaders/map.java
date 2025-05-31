package com.djpompilio.textcrusaders;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

// Map 2D array key: 1 = player   4 = test object


public class map implements Serializable {
    private int[][] worldMap = {{1, 0, 0, 0}, {0, 4, 0, 0}, {0, 4, 0, 0}, {0, 0, 0, 0}};

    public int[][] getMapData(){
        return worldMap;
    }
    void setPlayerLocation(int x, int y) {

    }
    void updateMap(int x, int y, int type) { //add locations to map etc.

    }
    public void saveMap() throws IOException, ClassNotFoundException {
    FileOutputStream fileOutputStream = new FileOutputStream("map.bin");
    ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
    objectOutputStream.writeObject(worldMap);
    objectOutputStream.flush();
    objectOutputStream.close();

    }
    
}
