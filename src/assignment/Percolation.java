package assignment;

import java.util.ArrayList;

public class Percolation {

    private final static int c_close = -1;
    private final static int c_root = -2;
    private boolean[][] m_grid;
    private int[][] m_graph;
    private int m_openSite;
    private boolean m_isPercolate;
    /**
     * create n-by-n grid, with all sites blocked
     * @param n
     */
    public Percolation(int n)
    {
        m_openSite = 0;
        m_isPercolate = false;
        m_grid = new boolean[n][n];
        for(int i=0;i<n;++i)
        {
            for(int j=0;i<n;++j)
            {
                m_grid[i][j] = false;
                m_graph[i][j] = c_close;
            }
        }
    }

    /**
     * open site (row, col) if it is not open already
     * @param row
     * @param col
     */
    public void open(int row, int col)
    {
        if(!m_grid[row][col])
        {
            m_openSite++;
            m_grid[row][col] = true;
            if(row>0)
            {

            }
        }
    }

    /**
     * is site (row, col) open?
     * @param row
     * @param col
     * @return
     */
    public boolean isOpen(int row, int col)
    {
        return m_grid[row][col];
    }

    /**
     * is site (row, col) full?
     * @param row
     * @param col
     * @return
     */
    public boolean isFull(int row, int col)
    {
        return m_graph[row][col] == c_root;
    }

    /**
     * number of open sites
     * @return
     */
    public int numberOfOpenSites()
    {
        return m_openSite;
    }

    /**
     * does the system percolate?
     * @return
     */
    public boolean percolates()
    {
        return m_isPercolate;
    }

    /**
     * test client (optional)
     * @param args
     */
    public static void main(String[] args)
    {
        throw new UnsupportedOperationException("Not implemented");
    }
}
