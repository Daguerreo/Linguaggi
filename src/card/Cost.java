package card;

public class Cost 
{
	public enum CostType
	{
		MONO,
		DUO,
		TRIO
	}

	CostType cost;
	Element e1;
	int 	c1;
	Element e2;
	int		c2;
	Element e3;
	int		c3;
	
	public Cost()
	{}
	
	public Cost( Element e1, int c1 )
	{
		cost = CostType.MONO;
		this.e1 = e1;
		this.c1 = c1;
	}
	
	public Cost( Element e1, int c1, Element e2, int c2 )
	{
		cost = CostType.DUO;
		this.e1 = e1;
		this.c1 = c1;
		this.e1 = e2;
		this.c1 = c2;
	}
	
	public Cost( Element e1, int c1 , Element e2, int c2, Element e3, int c3 )
	{
		cost = CostType.TRIO;
		this.e1 = e1;
		this.c1 = c1;
		this.e2 = e2;
		this.c2 = c2;
		this.e3 = e3;
		this.c3 = c3;
	}
}
