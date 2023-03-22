public class Level {
    static final int EMPTY = 0;
    static final int WALL = 1;
    static final int PLAYER = 2;
    static final int TARGET = 4;
    static final int BOX = 8;

    int[][] board;
    int l, c;
    String name;
    int playerL, playerC;
    int nbTarget, nbBoxOnTarget;

    public Level(){
        board = new int[1][1];
        l = c =0;
    }

    private int adjust(int c, int i){
        while (c <= i)
            c *= 2;
        return  c;
    }

    private void resizeBoard(int l, int c){
        int oldL = board.length;
        int oldC = board[0].length;

        if((oldL <= l) || (oldC <= c)){
            int newL = adjust(oldL,l);
            int newC = adjust(oldC, c);

            int [][] newBoard = new int [newL][newC];
            for(int i = 0; i < oldL; i++)
                for(int j = 0; j < oldC; j++)
                    newBoard[i][j] = board[i][j];
            board = newBoard;
        }
        if(this.l <= l)
            this.l = l +1;
        if(this.c <= c)
            this.c = c +1;
    }

    public void fixName(String nm){
        name = nm;
    }


    public void emptyCell(int i, int j){
        board[i][j] = EMPTY;
    }

    private void addContent(int content, int i, int j){
        resizeBoard(i, j);
        board[i][j] |= content;
        if(content == BOX)
            if(hasTarget(i,j))
                nbBoxOnTarget++;
    }


    public void addWall(int i, int j){
        addContent(WALL, i, j);
    }

    public void addPlayer(int i, int j){
        addContent(PLAYER, i, j);
        playerL = i;
        playerC = j;
    }
    public void addBox(int i, int j){
        addContent(BOX, i, j);
    }

    public void addTarget(int i, int j){
        addContent(TARGET, i, j);
        nbTarget++;
        if(hasBox(i,j))
            nbBoxOnTarget++;
    }

    public int lines(){
        return l;
    }

    public int columns(){
        return  c;
    }

    public String name(){
        return name;
    }

    public boolean isEmpty(int i, int j){
        return board[i][j] ==EMPTY;
    }

    public boolean hasWall(int i, int j){
        return (board[i][j] & WALL) != 0;
    }

    public boolean hasTarget(int i, int j){
        return (board[i][j] & TARGET) != 0;
    }

    public boolean hasPlayer(int i, int j){
        return (board[i][j] & PLAYER) != 0;
    }

    public boolean hasBox(int i, int j){
        return (board[i][j] & BOX) != 0;
    }

    public int playerL(){
        return playerL;
    }

    public int playerC(){
        return playerC;
    }

    public boolean move(int dL, int dC){
        int destL = playerL + dL;
        int destC = playerC + dC;
        if(hasBox(destL, destC)){
            int boxL = destL + dL;
            int boxC = destC + dC;
            if(isFree(boxL, boxC)){
                delete(BOX,destL, destC);
                addContent(BOX, boxL, boxC);
            }
        }
        if(isFree(destL, destC)){
            delete(PLAYER, playerL, playerC);
            playerL = destL;
            playerC = destC;
            addContent(PLAYER, playerL,playerC);
            return true;
        }else{
            return false;
        }
    }

    public boolean isFree(int l, int c){
        return !hasWall(l,c) && !hasBox(l,c);
    }

    public void delete(int elm, int i, int j){
        board[i][j] &= ~elm;
        if(elm ==BOX)
            if(hasTarget(i,j))
                nbBoxOnTarget--;
    }

    public boolean isFinished(){
        return nbBoxOnTarget == nbTarget;
    }
}
