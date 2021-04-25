import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MainClassTest {


    int[][] sudoku = {{5,3,0,0,7,0,0,0,0},{6,0,0,1,9,5,0,0,0},{0,9,8,0,0,0,0,6,0},{8,0,0,0,6,0,0,0,3},{4,0,0,8,0,3,0,0,1},{7,0,0,0,2,0,0,0,6},{0,6,0,0,0,0,2,8,0},{0,0,0,4,1,9,0,0,5},{0,0,0,0,8,0,0,7,9}};
    private final SudokuSolver sudokuSolver = new SudokuSolver(sudoku);
    Line line;

    public void prettyPrint(int[][] array){
        for(int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++)
                System.out.print(array[i][j] + " ");
            System.out.println();
        }
    }

    @Test
    public void testSelect(){

        line = sudokuSolver.selectLine();

        assertEquals(4,line.number);
        assertFalse(line.type);

        sudoku = sudokuSolver.fillLine(line);

        int total = 0;
        for (int[] ints : sudoku) {
            total += ints[4];
        }
        prettyPrint(sudoku);
        assertEquals(45,total);
    }

    @Test
    public void testSolver(){

        boolean ok = true;
        while (ok) {
            ok = false;
            for (int i = 0; i < sudoku.length; i++) {
                for (int j = 0; j < sudoku.length; j++) {
                    if (sudoku[i][j] == 0) {
                        ok = true;
                        line = sudokuSolver.selectLine();
                        sudoku = sudokuSolver.fillLine(line);
                    }
                }
            }
        }
        prettyPrint(sudoku);

    }
}
