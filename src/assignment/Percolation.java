package assignment;

public class Percolation {

    private final static int c_end = -1;
    private final static int c_root = -2;
    private int m_n;
    private int m_size;
    private boolean[] m_grid;
    private int[] m_graph;
    private int m_openSite;
    private boolean m_isPercolate;
    /**
     * create n-by-n grid, with all sites blocked
     * @param n
     */
    public Percolation(int n)
    {
        m_n = n;
        m_size = n*n;
        m_openSite = 0;
        m_isPercolate = false;
        m_grid = new boolean[m_size];
        m_graph = new int[m_size];

        for(int i=0;i<m_n;++i)
        {
            m_grid[i] = false;
            m_graph[i] = c_root;
        }

        for(int i=n;i<m_size;++i)
        {
            m_grid[i] = false;
            m_graph[i] = i;
        }

    }

    /**
     * open site (row, col) if it is not open already
     * @param row
     * @param col
     */
    public void open(int row, int col)
    {
        int p = convertIndex(row,col);
        if(!m_grid[p])
        {
            m_openSite++;
            m_grid[p] = true;

            int top = convertIndex(row-1,col);
            int left = convertIndex(row,col-1);
            int right = convertIndex(row,col+1);
            int bottom = convertIndex(row+1,col);
            if(row>1 && m_grid[top] )
            {
                union(p,top);
            }
            if(col>1 && m_grid[left])
            {
                union(p,left);
            }
            if(col<m_n && m_grid[right])
            {
                union(p,right);
            }
            if(row<m_n && m_grid[bottom])
            {
                union(p,bottom);
            }
        }
    }

    private int convertIndex(int row, int col)
    {
        return (row-1)*m_n + (col-1);
    }

    private void union(int p, int q)
    {
        int pid = m_graph[p]<m_graph[q]? m_graph[p]:m_graph[q];
        int qid = m_graph[p]>=m_graph[q]? m_graph[p]:m_graph[q];

        for(int i=0;i<m_size;++i)
        {
            if(m_grid[i] && m_graph[i]==qid) m_graph[i]=pid;
        }
    }
    /*private void union(int p, int q)
    {
        int pid = m_graph[p]<m_graph[q]? m_graph[p]:m_graph[q];
        int qid = m_graph[p]>=m_graph[q]? m_graph[p]:m_graph[q];

        for(int i=0;i<m_n;++i)
        {
            if(m_graph[i]==qid) m_graph[i]=pid;
        }
    }*/

    /**
     * is site (row, col) open?
     * @param row
     * @param col
     * @return
     */
    public boolean isOpen(int row, int col)
    {
        return m_grid[convertIndex(row,col)];
    }

    /**
     * is site (row, col) full?
     * @param row
     * @param col
     * @return
     */
    public boolean isFull(int row, int col)
    {
        return m_grid[convertIndex(row,col)] && m_graph[convertIndex(row,col)] == c_root;
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
        if(!m_isPercolate) {
            for (int i = m_size - m_n; i < m_size; ++i) {
                if (m_grid[i] && m_graph[i] == c_root) {
                    m_isPercolate = true;
                }
            }
        }
        return m_isPercolate;
    }

    /**
     * test client (optional)
     * @param args
     */
    /*public static void main(String[] args)
    {
        throw new UnsupportedOperationException("Not implemented");
    }*/
}
