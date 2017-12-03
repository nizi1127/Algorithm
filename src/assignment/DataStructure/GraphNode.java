package assignment.DataStructure;

public class GraphNode {
    private int m_row;
    private int m_col;
    private int m_root;
    private boolean m_isOpen;
    public GraphNode(int row, int col)
    {
        m_row = row;
        m_col = col;
        m_root = -1;
        m_isOpen = false;
    }
    public void Open()
    {
        if(!m_isOpen) m_isOpen = true;
    }
    public boolean IsOpen() { return m_isOpen; }
    public int GetRow() { return m_row; }
    public int GetColumn() { return m_col; }
    public int GetRoot() { return m_root; }

    public boolean SetRoot(int root)
    {
        if(m_isOpen)
        {
            m_root = root;
            return true;
        }
        return false;
    }
}
