package sortedmatrixsearch;
import java.awt.Point;
/**
 * @author sieyip
 * Given an M x N matrix in which each row and each column is sorted in 
 * ascending order, write a method to find an element.
 * ex: Find 6
 * 0 1 2 3
 * 4 5 6 7
 * 8 9 10 11
 * 
 * Solution: Binary Search O(log n)
 */
public class SortedMatrixSearch {
    /**
     * Returns Point(-1,-1) if the searchElement is not found, Points are given
     * in X (column) and Y(row) coordinates starting at index 1
     */
    public static Point findElement (int[][] integerMatrix, int searchElement) {
        int maxHeight = integerMatrix.length;
        int maxLength = integerMatrix[0].length;
        int tail = maxHeight*maxLength - 1;
        int head = 0;                
        while (head <= tail) { 
            int mid = (head + tail) / 2;
            int midPointY = mid/maxLength;
            int midPointX = mid%maxLength;
            int value = integerMatrix[midPointY][midPointX];
            
            if(value == searchElement) return new Point(midPointX+1, midPointY+1);
            else if(value < searchElement) head = mid + 1;
            else tail = mid - 1;
        }
        return new Point(-1, -1);
    }

    public static void main(String[] args) {
        int[][] matrix = { {0, 1, 2, 3} , {4, 5, 7, 8}, {9, 10, 11, 12}};
        assert findElement(matrix, 0).equals(new Point(1,1));
        assert findElement(matrix, 12).equals(new Point(4,3));
        assert findElement(matrix, 8).equals(new Point(4,2));
        assert findElement(matrix, 6).equals(new Point(-1,-1));
        assert findElement(matrix, 13).equals(new Point(-1,-1));
        assert findElement(matrix, -1).equals(new Point(-1,-1));
    }
}
