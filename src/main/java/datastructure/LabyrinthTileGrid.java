package datastructure;

import java.util.ArrayList;
import java.util.List;

import labyrinth.LabyrinthTile;

/**
 * A Grid contains a set of labyrinth tiles
 */
public class LabyrinthTileGrid implements ILabyrinthTileGrid {
	private final List<LabyrinthTile> cells;
	private final int columns;
	private final int rows;

	/**
	 * Construct a grid with the given dimensions.
	 * 
	 * @param rows
	 * @param columns
	 * @param initElement What the cells should initially hold (possibly null)
	 */
	public LabyrinthTileGrid(int rows, int columns, LabyrinthTile initElement) {
		if (rows <= 0 || columns <= 0) {
			throw new IllegalArgumentException();
		}

		this.columns = columns;
		this.rows = rows;
		cells = new ArrayList<LabyrinthTile>(columns * rows);
		for (int i = 0; i < columns * rows; ++i) {
			cells.add(initElement);
		}
	}

	@Override
	public int numColumns() {
		return columns;
	}

	@Override
	public int numRows() {
		return rows;
	}

	public void checkLocation(Location loc) {
		if (!isOnGrid(loc)) {
			throw new IndexOutOfBoundsException();
		}
	}

	@Override
	public void set(Location loc, LabyrinthTile elem) {
		checkLocation(loc);

		// TODO: fyll inn
		cells.set(coordinateToIndex(loc), elem);
	}

	private int coordinateToIndex(Location loc) {
		return loc.row + loc.col * rows;
	}

	@Override
	public LabyrinthTile get(Location loc) {
		checkLocation(loc);

		return cells.get(coordinateToIndex(loc));
	}

	@Override
	public Iterable<Location> locations() {
		return new GridLocationIterator(numRows(), numColumns());
	}

	@Override
	public LabyrinthTileGrid copy() {
		LabyrinthTileGrid newGrid = new LabyrinthTileGrid(numRows(), numColumns(), null);

		for (Location loc : this.locations()) {
			newGrid.set(loc, this.get(loc));
		}
		return newGrid;
	}

	@Override
	public boolean isOnGrid(Location loc) {
		if (loc.row < 0 || loc.row >= rows) {
			return false;
		}
		return loc.col >= 0 && loc.col < columns;
	}

}
