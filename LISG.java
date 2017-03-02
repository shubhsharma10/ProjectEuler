class LISG
{
	public boolean[] visited;
	public int[] state;
	public int[][] cache;

	public LISG(int nRow,int nCol)
	{
		visited = new boolean[nRow*nCol];
		state = new int[nRow*nCol];
		cache = new int[nRow][nCol];
		int i=0,j=0;
		for(i=0;i<nRow;i++)
		{
			for(j=0;j<nCol;j++)
				cache[i][j] = 0;
		}
	}


	public void topSort(int[][] matrix,Stack topSort)
	{

	}

	public int longestIncreasingPath(int[][] matrix)
    {        
        int nRow = matrix.length;
        int nCol = matrix[0].length;
        LISG st = new LISG(nRow,nCol);
        return 0;
        
    }
}