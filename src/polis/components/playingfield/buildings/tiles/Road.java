package polis.components.playingfield.buildings.tiles;

import polis.components.playingfield.buildings.BuildingTileModel;

public class Road extends BuildingTileModel {

    /**
     *  ROAD UPDATE
     *
     * right  = 1
     * below  = 2
     * left = 4
     * top = 8
     *
     * **/

    private boolean[] neighbours;

    public Road(int row, int column, boolean[] neighbours) {
        super(row, column, "road", 1);
        this.neighbours = neighbours;
        Update();
    }

    public Road(int row, int column, boolean[] neighbours, boolean isDestructible) {
        super(row, column, "road", 1);
        this.neighbours = neighbours;
        setDestructible(isDestructible);
        Update();
    }

    public void setNeighbours(boolean[] adj){
        neighbours = adj;
        Update();
    }

    public void Update(){
        int level = calculateLevel();
        setImage(getName()+"-"+level);
    }

    public int calculateLevel(){
        int level = 0;
        int[] codes = new int[]{1,2,4,8};
        for (int i=0; i<4; i++) {
            if (neighbours[i]) {
                level += codes[i];
            }
        }
        return level;
    }

}