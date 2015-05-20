package Geometry;


/**
 *
 * @author DougM
 */
public final class Matrix {

    private Integer rows = 0;
    private Integer cols = 0;
    private Double[][] values;

    public Matrix(Number[][] values) {
        rows = values.length;

        for (int i = 0; i < rows; i++) {
            if (values[i].length > cols) {
                cols = values[i].length;
            }
        }

        this.setValues(values);
    }

    public Matrix(Integer rows, Integer cols) {
        this.rows = rows;
        this.cols = cols;
    }

    /**
     * @return the values
     */
    public Double[][] getValues() {
        return values;
    }

    /**
     * @param values the values to set
     */
    public void setValues(Number[][] values) {
        for (int i = 0; i < rows; i++) {
            if (values[i].length != cols) {
                throw new IndexOutOfBoundsException();
            }
        }

        this.values = new Double[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                this.values[i][j] = values[i][j].doubleValue();
            }
        }
    }

    public Double get(int i, int j) {
        if (i > rows) {
            throw new IndexOutOfBoundsException();
        }

        if (j > cols) {
            throw new IndexOutOfBoundsException();
        }

        return values[j - 1][i - 1];
    }

    public void set(int i, int j, Number n) {
        values[j - 1][i - 1] = n.doubleValue();
    }

    public Double getDeterminant() {
        double positivo = 0.0;

        if (rows == 2 && cols == 2) {
            return values[0][0] * values[1][1] - values[1][0] * values[0][1];
        }

        for (int i = 0; i < rows; i++) {
            double mult = 1.0;

            for (int j = 0; j < cols; j++) {
                int row = i + j;

                if (row >= rows) {
                    row %= rows;
                }

                mult *= values[row][j];
            }

            positivo += mult;
        }

        double negativo = 0.0;

        for (int i = 0; i < rows; i++) {
            double mult = -1.0;

            for (int j = 0; j < cols; j++) {
                int row = i + j;

                if (row > rows - 1) {
                    row %= rows;
                }

                mult *= values[rows - 1 - row][j];
            }

            negativo += mult;
        }

        return positivo + negativo;
    }

    public Matrix transpose() {
        Matrix m = new Matrix(cols, rows);

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                m.set(cols - j - 1, rows - i - 1, values[i][j]);
            }
        }

        return m;
    }

    public Boolean isSimetric() {
        return rows == cols;
    }

    public Matrix multiply(Number num) {
        Matrix m = new Matrix(rows, cols);

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; i++) {
                m.set(i, j, values[i][j] * num.doubleValue());
            }
        }

        return m;
    }

    public Matrix multiply(Matrix m) {
        Matrix m2 = new Matrix(rows, cols);

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; i++) {
                m2.set(i, j, values[i][j] * m.get(i, j));
            }
        }

        return m2;
    }

    public Matrix add(Number num) {
        Matrix m = new Matrix(rows, cols);

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; i++) {
                m.set(i, j, values[i][j] + num.doubleValue());
            }
        }

        return m;
    }

    public Matrix add(Matrix m) {
        Matrix m2 = new Matrix(rows, cols);

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; i++) {
                m2.set(i, j, values[i][j] + m.get(i, j));
            }
        }

        return m2;
    }

    public Matrix sub(Number num) {
        Matrix m = new Matrix(rows, cols);

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; i++) {
                m.set(i, j, values[i][j] - num.doubleValue());
            }
        }

        return m;
    }

    public Matrix sub(Matrix m) {
        Matrix m2 = new Matrix(rows, cols);

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; i++) {
                m2.set(i, j, values[i][j] - m.get(i, j));
            }
        }

        return m2;
    }

    public Matrix divide(Number num) {
        Matrix m = new Matrix(rows, cols);

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; i++) {
                m.set(i, j, values[i][j] / num.doubleValue());
            }
        }

        return m;
    }

    public Matrix divide(Matrix m) {
        Matrix m2 = new Matrix(rows, cols);

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; i++) {
                m2.set(i, j, values[i][j] / m.get(i, j));
            }
        }

        return m2;
    }

    public static Matrix identity(Integer rowscols) {
        Matrix m = new Matrix(rowscols, rowscols);

        for (int i = 0; i < rowscols; i++) {
            for (int j = 0; j < rowscols; i++) {
                if (i == j) {
                    m.set(i, j, 1);
                } else {
                    m.set(i, j, 0);
                }
            }
        }

        return m;
    }
}
