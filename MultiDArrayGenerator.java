import java.util.Scanner;

public class MultiDArrayGenerator {
    Scanner sc = new Scanner(System.in);
    String arrayType, valueType;
    int values, rows, cols, depth, min, max;
    private Object array;

    // get access to the created array
    public Object getArray() {
        return array;
    }

    // method to check if the array type is '1d', '2d' or '3d'
    private String readArrayType() {
        String input;
        while (true) {
            input = sc.nextLine().trim().toLowerCase();
            if (input.equals("1d") || input.equals("2d") || input.equals("3d")) {
                return input;
            }
            System.out.println("Invalid array type. Enter '1d', '2d' or '3d'.");
        }
    }

    // method to check if the value type is 'random' or 'custom'
    private String readValueType() {
        String input;
        while (true) {
            input = sc.nextLine().trim().toLowerCase();
            if (input.equals("random") || input.equals("custom")) {
                return input;
            }
            System.out.println("Invalid value type. Enter 'random' or 'custom'.");
        }
    }
    
    // method to check if the user input is an 'int'
    private int readInteger() {
        while (!sc.hasNextInt()) {
            System.out.println("Invalid value. Enter an integer.");
            sc.next();
        }
        return sc.nextInt();
    }
    
    // method to check if the user input is an 'int > 0'
    private int readPositiveInteger() {
        int input = readInteger();
        
        while (input <= 0) {
            System.out.println("Invalid value. Enter a positive integer greater than '0'.");
            input = readInteger();
        }
        return input;
    }

    // method to check if the user random value range is valid 'min < max'
    private int[] readRandomRange() {
        int min = readInteger();
        int max = readInteger();

        while (min > max) {
            System.out.println("The maximum must be greater than or equal to the minimum.");
            max = readInteger();
        }
        return new int[]{min, max};
    }

    // method to create an array based on user input
    public Object createArray() {
        System.out.println("Enter the array type to create (1d, 2d, 3d):");
        arrayType = readArrayType();    
        System.out.println("Enter the value type to store (random, custom):");
        valueType = readValueType();

        switch (arrayType) {
            case "1d" -> array = create1DArray(sc, valueType);
            case "2d" -> array = create2DArray(sc, valueType);
            case "3d" -> array = create3DArray(sc, valueType);
        }
        return array;
    }

    // method to create one dimensional array
    public int[] create1DArray(Scanner sc, String valueType) {
        System.out.println("Enter number of values:");
        values = readPositiveInteger();

        int[] array = new int[values];

        if (valueType.equals("random")) {
            System.out.println("Enter the minimum and maximum value for the random numbers:");
            int[] range = readRandomRange();
            min = range[0];
            max = range[1];

            for (int i = 0; i < values; i++) {
                array[i] = (int) (Math.random() * (max - min + 1)) + min;
            }
        } else {
            System.out.println("Enter " + values + " values for the 1D array:");

            for (int i = 0; i < values; i++) {
                System.out.println("Enter value for index array1D[" + i + "]:");
                array[i] = readInteger();
            }
        }
        return array;
    }

    // method to create two dimensional array
    public int[][] create2DArray(Scanner sc, String valueType) {
        System.out.println("Enter number of rows and columns:");
        rows = readPositiveInteger();
        cols = readPositiveInteger();

        int[][] array = new int[rows][cols];

        if (valueType.equals("random")) {
            System.out.println("Enter the minimum and maximum value for the random numbers:");
            int[] range = readRandomRange();
            min = range[0];
            max = range[1];

            for (int row = 0; row < rows; row++) {
                for (int col = 0; col < cols; col++) {
                    array[row][col] = (int) (Math.random() * (max - min + 1)) + min;
                }
            }
        } else {
            System.out.println("Enter " + (rows * cols) + " values for the 2D array:");
    
            for (int row = 0; row < rows; row++) {
                for (int col = 0; col < cols; col++) {
                    System.out.println("Enter value for index array2D[" + row + "][" + col + "]:");
                    array[row][col] = readInteger();
                }
            }
        }
        return array;
    }

    // method to create three dimensional array
    public int[][][] create3DArray(Scanner sc, String valueType) {
        System.out.println("Enter number of rows, columns and depth:");
        rows = readPositiveInteger();
        cols = readPositiveInteger();
        depth = readPositiveInteger();

        int[][][] array = new int[rows][cols][depth];

        if (valueType.equals("random")) {
            System.out.println("Enter the minimum and maximum value for the random numbers:");
            int[] range = readRandomRange();
            min = range[0];
            max = range[1];

            for (int row = 0; row < rows; row++) {
                for (int col = 0; col < cols; col++) {
                    for (int dep = 0; dep < depth; dep++) {
                        array[row][col][dep] = (int) (Math.random() * (max - min + 1)) + min;
                    }
                }
            }
        } else {
            System.out.println("Enter " + (rows * cols * depth) + " values for the 3D array:");

            for (int row = 0; row < rows; row++) {
                for (int col = 0; col < cols; col++) {
                    for (int dep = 0; dep < depth; dep++) {
                        System.out.println("Enter value for index array3D[" + row + "][" + col + "][" + dep + "]:");
                        array[row][col][dep] = readInteger();
                    }
                }
            }
        }
        return array;
    }

    // method to display the array based on the array type
    public void displayArray() {
        if (array instanceof int[]) {
            print1DArray((int[]) array);

            System.out.printf("Array type: %s\nValue type: %s\n", arrayType, valueType);
            System.out.println("Number of values: " + values);

            if (valueType.equals("random")) {
                System.out.printf("Range: %d|%d\n", min, max);
            }
        }
        if (array instanceof int[][]) {
            print2DArray((int[][]) array);
            values = rows * cols;

            System.out.printf("Array type: %s\nValue type: %s\n", arrayType, valueType);
            System.out.printf("Rows: %d\nColumns: %d\nValues: %d\n", rows, cols, values);

            if (valueType.equals("random")) {
                System.out.printf("Range: %d|%d\n", min, max);
            }
        }
        if (array instanceof int[][][]) {
            print3DArray((int[][][]) array);
            values = (rows * cols * depth);

            System.out.printf("Array type: %s\nValue type: %s\n", arrayType, valueType);
            System.out.printf("Rows: %d\nColumns: %d\nDepth: %d\nValues: %d\n", rows, cols, depth, values);

            if (valueType.equals("random")) {
                System.out.printf("Range: %d|%d\n", min, max);
            }
        }
    }

    // method to print 1D array with the format 'array[index]'
    public static void print1DArray(int[] array) {
        System.out.println();

        for (int i = 0; i < array.length; i++) {
            System.out.printf("array1D[%d]: %d\n", i, array[i]);
        }
        System.out.println();
    }

    // method to print 2D array with the format 'array[row][column]'
    public static void print2DArray(int[][] array) {
        System.out.println();

        for (int row = 0; row < array.length; row++) {
            System.out.println("Row at index: " + row);

            for (int col = 0; col < array[row].length; col++) {
                System.out.printf("\tarray2D[%d][%d]: %d\n", row, col, array[row][col]);
            }
            System.out.println();
        }
    }

    // method to print 3D array with the format 'array[row][column][depth]'
    public static void print3DArray(int[][][] array) {
        System.out.println();

        for (int row = 0; row < array.length; row++) {
            System.out.println("Row at index: " + row);

            for (int col = 0; col < array[row].length; col++) {
                System.out.println("\tColumn at index: " + col);
                
                for (int depth = 0; depth < array[row][col].length; depth++) {
                    System.out.printf("\tarray3D[%d][%d][%d]: %d\n", row, col, depth, array[row][col][depth]);
                }
                System.out.println();
            }
        }
    }
}

class MultiDArray extends MultiDArrayGenerator {
    // methods to convert an object to an array of type 1D, 2D or 3D
    public static int[] convert1DArray(Object obj) {
        int[] array = (int[]) obj;
        return array;
    }
    public static int[][] convert2DArray(Object obj) {
        int[][] array = (int[][]) obj;
        return array;
    }
    public static int[][][] convert3DArray(Object obj) {
        int[][][] array = (int[][][]) obj;
        return array;
    }

    public static void main(String[] args) {
        // create new arrays as objects
        MultiDArray array = new MultiDArray();
        array.createArray();
        array.displayArray();

        Object arrayCopy = array.getArray();

        if (arrayCopy instanceof int[]) {
            int[] array1D = convert1DArray(arrayCopy);
            array1D[0] = 777;
            print1DArray(array1D);
        }
        if (arrayCopy instanceof int[][]) {
            int[][] array2D = convert2DArray(arrayCopy);
            array2D[0][0] = 888;
            print2DArray(array2D);
        }
        if (arrayCopy instanceof int[][][]) {
            int[][][] array3D = convert3DArray(arrayCopy);
            array3D[0][0][0] = 999;
            print3DArray(array3D);
        }
    }
}