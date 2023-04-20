import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import static java.lang.Math.min;

public class Test {
    public static void main(String[] args) {

        int m = 6;
        int n = 6;
        int r = 14;

        int num = 0;
        List<List<Integer>> matrix = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                row.add(++num);
            }
            matrix.add(row);
        }

        matrixRotation(matrix, r);
    }

    public static void matrixRotation(List<List<Integer>> matrix, int r) {

        int m = matrix.size();
        int n = matrix.get(0).size();

        int layersSize = min(m, n) / 2;

        for (int i = 0; i < layersSize; i++) {
            LinkedList<Integer> layer = new LinkedList<>();

            for (int j = i; j < n - i; j++) {
                layer.add(matrix.get(i).get(j));
            }

            for (int j = i + 1; j < m - i; j++) {
                layer.add(matrix.get(j).get(n - i - 1));
            }

            for (int j = n - i - 2; j >= i; j--) {
                layer.add(matrix.get(m - i - 1).get(j));
            }

            for (int j = m - i - 2; j > i; j--) {
                layer.add(matrix.get(j).get(i));
            }

            int rotations = r % layer.size();
            for (int j = 0; j < rotations; j++) {
                Integer temp = layer.getFirst();
                layer.removeFirst();
                layer.addLast(temp);
            }

            Iterator<Integer> iter = layer.iterator();

            for (int j = i; j < n - i; j++) {
                matrix.get(i).set(j, iter.next());
            }

            for (int j = i + 1; j < m - i; j++) {
                matrix.get(j).set(n - i - 1, iter.next());
            }

            for (int j = n - i - 2; j >= i; j--) {
                matrix.get(m - i - 1).set(j, iter.next());
            }

            for (int j = m - i - 2; j > i; j--) {
                matrix.get(j).set(i, iter.next());
            }
        }

        for (List<Integer> row : matrix) {
            for (Integer integer : row) {
                System.out.print(integer + " ");
            }
            System.out.println();
        }
    }
}
