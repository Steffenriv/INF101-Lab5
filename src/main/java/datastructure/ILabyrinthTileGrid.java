package datastructure;

import labyrinth.LabyrinthTile;

/**
 * ILabyrinthTileGrid is a grid of Labyrinth Tiles
 * @author Anna Eilertsen - anna.eilertsen@uib.no
 */
public interface ILabyrinthTileGrid {

	/**
	 * @return The height of the grid.
	 */
	int numColumns();

	/**
	 * @return The width of the grid.
	 */
	int numRows();

	/**
	 * Set the contents of the cell in the given x,y location.
	 * <p>
	 * y must be greater than or equal to 0 and less than getHeight().
	 * x must be greater than or equal to 0 and less than getWidth().
	 * @param loc The location of the cell to change the contents of.
	 * @param element The contents the cell is to have.
	 */
	void set(Location loc, LabyrinthTile element);

	/**
	 * Get the contents of the cell in the given x,y location.
	 * <p>
	 * y must be greater than or equal to 0 and less than getHeight().
	 * x must be greater than or equal to 0 and less than getWidth().
	 * @param x The column of the cell to get the contents of.
	 * @param y The row of the cell to get contents of.
	 */
	LabyrinthTile get(Location loc);

	Iterable<Location> locations();

	boolean isOnGrid(Location loc);

	/**
	 * Make a copy
	 * @return A shallow copy of the grid, with the same elements
	 */
	ILabyrinthTileGrid copy();

}
