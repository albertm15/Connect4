public class Geometry {

    private final int windowHeight;
    private final int windowWidth;
    private final int displayRows;
    private final int displayColumns;
    private final double padding;

    public Geometry(int windowHeight, int windowWidth, int displayRows, int displayColumns, double padding) {
        this.windowHeight = windowHeight;
        this.windowWidth = windowWidth;
        this.displayRows = displayRows;
        this.displayColumns = displayColumns;
        this.padding = padding;
    }

    public double getRowHeight() {
        return this.windowHeight / this.displayRows;
    }

    public double getColumnWidth() {
        return this.windowWidth / this.displayColumns;
    }

    public double getDiskHeight() {
        return (getRowHeight() - (getRowHeight() * (this.padding)));
    }

    public double getDiskWidth() {
        return (getColumnWidth() - (getColumnWidth() * (this.padding)));
    }

    public double columnToCenterX(int column) {
        return ((getColumnWidth() * column) + (getColumnWidth() / 2));
    }

    public double rowToCenterY(int row) {
        return ((getRowHeight() * row) + (getRowHeight() / 2));
    }

    public double columnToTopLeftX(int column) {
        return ((getColumnWidth() * column) + (getColumnWidth() * (this.padding/2)));
    }

    public double rowToTopLeftY(int row) {
        return ((getRowHeight() * row) + (getRowHeight() * (this.padding/2)));
    }

    public int xToColumn(int x) {
        return x / (int)getColumnWidth();
    }
}
