package Geometry;


/**
 *
 * @author Douglas Maitelli
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
        
        this.values = new Double[rows][cols];

        this.setValues(values);
    }

    public Matrix(Integer rows, Integer cols) {
        this.rows = rows;
        this.cols = cols;
        
        this.values = new Double[rows][cols];
    }
    
    public Integer getRows() {
		return rows;
	}
    
    public Integer getCols() {
		return cols;
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

        return values[i][j];
    }

    public void set(int i, int j, Number n) {
        values[i][j] = n.doubleValue();
    }

    public Double getDeterminant() {
        double positive = 0.0;

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

            positive += mult;
        }

        double negative = 0.0;

        for (int i = 0; i < rows; i++) {
            double mult = -1.0;

            for (int j = 0; j < cols; j++) {
                int row = i + j;

                if (row > rows - 1) {
                    row %= rows;
                }

                mult *= values[rows - 1 - row][j];
            }

            negative += mult;
        }

        return positive + negative;
    }

    public Matrix transpose() {
        Matrix m = new Matrix(cols, rows);

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                m.set(j, i, values[i][j]);
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
            for (int j = 0; j < cols; j++) {
                m.set(i, j, values[i][j] * num.doubleValue());
            }
        }

        return m;
    }

    public Matrix multiply(Matrix m) {
        Matrix m2 = new Matrix(rows, cols);

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                m2.set(i, j, values[i][j] * m.get(i, j));
            }
        }

        return m2;
    }

    public Matrix add(Number num) {
        Matrix m = new Matrix(rows, cols);

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                m.set(i, j, values[i][j] + num.doubleValue());
            }
        }

        return m;
    }

    public Matrix add(Matrix m) {
        Matrix m2 = new Matrix(rows, cols);

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                m2.set(i, j, values[i][j] + m.get(i, j));
            }
        }

        return m2;
    }

    public Matrix sub(Number num) {
        Matrix m = new Matrix(rows, cols);

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                m.set(i, j, values[i][j] - num.doubleValue());
            }
        }

        return m;
    }

    public Matrix sub(Matrix m) {
        Matrix m2 = new Matrix(rows, cols);

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                m2.set(i, j, values[i][j] - m.get(i, j));
            }
        }

        return m2;
    }

    public Matrix divide(Number num) {
        Matrix m = new Matrix(rows, cols);

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                m.set(i, j, values[i][j] / num.doubleValue());
            }
        }

        return m;
    }

    public Matrix divide(Matrix m) {
        Matrix m2 = new Matrix(rows, cols);

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                m2.set(i, j, values[i][j] / m.get(i, j));
            }
        }

        return m2;
    }

    public static Matrix identity(Integer rowscols) {
        Matrix m = new Matrix(rowscols, rowscols);

        for (int i = 0; i < rowscols; i++) {
            for (int j = 0; j < rowscols; j++) {
                if (i == j) {
                    m.set(i, j, 1);
                } else {
                    m.set(i, j, 0);
                }
            }
        }

        return m;
    }
    
    @Override
    public boolean equals(Object obj) {
    	Matrix m = (Matrix) obj;
    	
    	if (rows != m.getRows() || cols != m.getCols()) {
    		return false;
    	}
    	
    	for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
            	if (!values[i][j].equals(m.get(i, j))) {
            		return false;
            	}
            }
        }
    	
    	return true;
    }
}
