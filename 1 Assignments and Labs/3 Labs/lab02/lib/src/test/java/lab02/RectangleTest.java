/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package lab02;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;

class RectangleTest {
    int partition(int arr[], int begin, int end) {
        int pivot = arr[end];
        int i = (begin - 1);

        for (int j = begin; j < end; j++) {
            if (arr[j] <= pivot) {
                i++;

                int swapTemp = arr[i];
                arr[i] = arr[j];
                arr[j] = swapTemp;
            }
        }

        int swapTemp = arr[i + 1];
        arr[i + 1] = arr[end];
        arr[end] = swapTemp;

        return i + 1;
    }

    void quickSort(int arr[]) {
        int begin = 0;
        int end = arr.length - 1;
        quickSortRec(arr, begin, end);
    }

    void quickSortRec(int arr[], int begin, int end) {
        if (begin < end) {
            int partitionIndex = partition(arr, begin, end);

            quickSortRec(arr, begin, partitionIndex - 1);
            quickSortRec(arr, partitionIndex + 1, end);
        }
    }

    @Test
    void testHarnessWorking() {
        assertTrue(true);
    }

    @Test
    void createDefaultRect() {
        Rectangle r = new Rectangle();
        assertEquals(1, r.getWidth());
        assertEquals(1, r.getHeight());
        assertEquals(0, r.getX());
        assertEquals(0, r.getY());
    }
    @Test
    void changeWidthValid() {
        Rectangle r = new Rectangle(5,5,10,10);
        r.setWidth(20);
        assertEquals(20, r.getWidth());
    }
    @Test
    void changeWidthNegative() {
        Rectangle r = new Rectangle(5, 5, 10, 10);
        r.setWidth(-20);
        assertEquals(20,r.getWidth());
//        assertThrows(IllegalArgumentException.class, () -> {r.setWidth(-10);});
    }
    @Test
    void changeHeightNegative() {
        Rectangle r = new Rectangle(5, 5, 10, 10);
        r.setHeight(-20);
        assertEquals(20,r.getHeight());
    }

    @Test
    void equalityRecTest() {
        Rectangle rOne = new Rectangle(5, 5, 10, 20);
        Rectangle rTwo = new Rectangle(5, 5, 20, 10);
        assertEquals(rTwo.getArea(), rOne.getArea());
        assertNotEquals(rOne.getWidth(), rTwo.getWidth());
        assertNotEquals(rOne.getHeight(), rTwo.getHeight());
    }

    @Test
    void AreaRectangleTest() {
        Rectangle r = new Rectangle(5, 5, 10, 10);
        assertEquals(100,r.getArea());
    }

    @Test
    void checkRecInside() {
        Rectangle r = new Rectangle(5, 5, 10, 10);
        r.Rectangle2(3,4,5,6);
    }
    @Test
    void checkAreaSorted() {
        Rectangle r1 = new Rectangle(5, 5, 10, 10);
        Rectangle r2 = new Rectangle(5, 5, 20, 20);
        Rectangle r3 = new Rectangle(5, 5, 30, 30);
        int[] RecAreaUnsorted = {r2.getArea(),r3.getArea(),r1.getArea()};
        int[] RecArea = Arrays.copyOf(RecAreaUnsorted,RecAreaUnsorted.length);
        System.out.println("\n\nRecAreaUnSorted:\t"+Arrays.toString(RecArea));
        quickSort(RecArea);
        System.out.println("RecAreaSorted:\t\t"+Arrays.toString(RecArea)+"\n\n");
        int[] RecAreaExpected = {100,400,900};
        assertArrayEquals(RecAreaExpected,RecArea);
    }
}
