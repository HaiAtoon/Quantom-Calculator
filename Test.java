package hai_atoon;


public class Test{
	
	private String calculator_1;
	private String calculator_2;
	
	public Test(String calculator_1,String calculator_2) {
		this.calculator_1=calculator_1;
		this.calculator_2=calculator_2;
	}
	
	private Calculator create_calculator(String name)
		{
		Calculator c= new Calculator(name);
		Thread t=new Thread(c);
		t.start();
		return c;
		}
	

	
		private int test_calc (Calculator c) {
			
			int success=0;
			System.out.println("Calculator "+c.getName()+":");
			
			for (int i=0;i<20;i++)
			{
				double rand1=Math.random();
				double rand2=Math.random();
				
				if(add_subtract_decision())
				{
				
	
					double total= c.add(rand1, rand2);
					
					System.out.print(rand1+" + "+rand2+" = "+total+"   ->");
							
					if(rand1+rand2 == total)
					{
						System.out.println("(correct)");
						success++;
					}
					else
						System.out.println("(Error)");
				}
				else
				{
					double total= c.subtract(rand1, rand2);
					
					System.out.print(rand1+" - "+rand2+" = "+total+"   ->");
							
					if(rand1-rand2 == total)
					{
						System.out.println("(correct)");
						success++;
					}
					else
						System.out.println("(Error)");
				}
			
			}
			
			System.out.println();
			return success;
		}
		
	private boolean add_subtract_decision()
	{return Math.random()<Math.random()?true:false; }
	
	
	private void print_test(Calculator c1, Calculator c2)
	{
		
		int c1_success=test_calc(c1);
		int c2_success=test_calc(c2);
		
		System.out.println(c1.getName()+" Success rate: "+(double)c1_success/20);
		System.out.println(c2.getName()+" Success rate: "+(double)c2_success/20);
		
		if(c1_success==c2_success)
			System.out.println("There is no success difference between "+c1.getName()+" and "+c2.getName());
		else
		{
			String winner=c1_success<c2_success?c2.getName():c1.getName();
			System.out.println(winner+" is better");
		}
			
		
	}
	
	public void run_test()
	{print_test(create_calculator(this.calculator_1),create_calculator(this.calculator_2));}

}