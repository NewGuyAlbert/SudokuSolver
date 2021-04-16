public class SudokuSolver {

    private int[][] sudoku;

    public SudokuSolver(int[][] sudoku){
        this.sudoku = sudoku;
    }


    public Line selectLine() {
        int min = 9;
        int count;
        Line line = new Line();

        int i;
        int j;

        for(i = 0; i < this.sudoku.length; i++){
            count = 0;
            for(j = 0; j < this.sudoku.length; j++){
                if(this.sudoku[i][j] == 0) count++;
            }
            if(min > count && count!=0){
                min = count;
                line.number = i;
                line.type = true;
            }
        }

        for(j = 0; j < this.sudoku.length; j++){
            count = 0;
            for(i = 0; i < this.sudoku.length; i++){
                if(this.sudoku[i][j] == 0) count++;
            }
            if(min > count && count!=0){
                min = count;
                line.number = j;
                line.type = false;
            }
        }

        return line;
    }

    public int[][] fillLine(Line line) {

        if(!line.type){
            for(int i = 0; i < this.sudoku.length; i++){
                if(this.sudoku[i][line.number] == 0){
                    insert(i,line.number);
                }
            }
        }
        else{
            for(int j = 0; j < this.sudoku.length; j++){
                if(this.sudoku[line.number][j] == 0){
                    insert(line.number,j);
                }
            }
        }
        return this.sudoku;
    }

    private void insert(int row,int col){

        boolean inserted = false;
        boolean okToInsert;
        int numberToInsert = 1;
        while(!inserted){
            okToInsert = true;
            for(int i = 0; i < this.sudoku.length; i++){
                if(sudoku[i][col] == numberToInsert) okToInsert = false;
            }
            for(int j = 0; j < this.sudoku.length; j++){
                if(sudoku[row][j] == numberToInsert) okToInsert = false;
            }
            if(!okToInsert){
                numberToInsert ++;
            }
            else{
                sudoku[row][col] = numberToInsert;
                inserted = true;
            }
        }

    }

}
