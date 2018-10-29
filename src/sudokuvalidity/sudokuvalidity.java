package sudokuvalidity;

public class sudokuvalidity {
    static int[][] sMatrix = {


            {3,1,6,5,7,8,4,9,3},
            {5,2,9,1,3,4,7,6,8},
            {4,8,7,6,2,9,5,3,1},
            {2,6,3,4,1,5,9,8,7},
            {9,7,4,8,6,3,1,2,5},
            {8,5,1,7,9,2,6,4,3},
            {1,3,8,9,4,7,2,5,6},
            {6,9,2,3,5,1,8,7,4},
            {7,4,5,2,8,6,3,1,9}

    };

    public static void main(String[] args) {
        if (rowColumnCheck() && boxCheck()) {
            System.out.println("Valid!");
        } else {
            System.out.println("Invalid!");
        }
    }

    private static boolean boxCheck() {
        for (int i = 0; i < sMatrix.length; i += 3) {
            for (int j = 0; j < sMatrix.length; j += 3) {
                boolean[] gridMatrix = new boolean[9];
                for (int k = i; k < 3 + i; k++) {
                    for (int l = j; l < 3 + j; l++) {
                        int currentNumber = sMatrix[k][l];
                        if (currentNumber < 1 || currentNumber > 9) {
                            return false;
                        }
                        gridMatrix[currentNumber - 1] = true;
                    }
                }
                for (boolean booleanValue : gridMatrix) {
                    if (!booleanValue) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    private static boolean rowColumnCheck() {
        for (int i = 0; i < 9; i++) {
            boolean[] rowArray = new boolean[9];
            boolean[] columnArray = new boolean[9];
            for (int j = 0; j < 9; j++) {
                int currentNumberRow = sMatrix[i][j];
                int currentNumberColumn = sMatrix[j][i];
                if ((currentNumberRow < 1 || currentNumberRow > 9) && (currentNumberColumn < 1 || currentNumberColumn > 9)) {
                    return false;
                }
                rowArray[currentNumberRow - 1] = true;
                columnArray[currentNumberColumn - 1] = true;

            }
            for (boolean booleanValue : rowArray) {
                if (!booleanValue) {
                    return false;
                }
            }
            for (boolean booleanValue : columnArray) {
                if (!booleanValue) {
                    return false;
                }
            }
        }
        return true;
    }
}
