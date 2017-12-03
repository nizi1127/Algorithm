package assignment.DataStructure;

public class Graph2D {
    private int[][] m_graph;

    public Graph2D(int n, int m)
    {
        m_graph = new int[n][m];
        for(int i=0; i<n; ++i)
        {
            for(int j=0; j<m; ++j)
            {
                m_graph[n][m] = n*i + m*j;
            }
        }
    }

    public void Union(int n1_row, int n1_col, int n2_row, int n2_col)
    {
        if(m_graph[n1_row][n1_col]<m_graph[n2_row][n2_col])
        {

        }
    }
}
