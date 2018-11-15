
class Singelton 
{

	static Singelton singeltonObject;
	//private static Object mutex = new Object();


	private Singelton(){}

	public static Singelton getSingeltonObject() 
	{  
		Singelton result = singeltonObject;
		if (singeltonObject ==  null)
		{
			synchronized(Singelton.class){
				result = singeltonObject;
				if (result== null)
				 {
					result = singeltonObject =  new Singelton();
				 }
			}

		}	
		return result;

	}

}


public class SingeltonClass {



	public static void main(String a[]) {
		System.out.println("Hey how are you ");
      
		new SingeltonClass().mulitpleThreads();
		
	}
	
	public void mulitpleThreads() 
	{
		for(int i=0; i<20;i++) 
	   { 
			CodeRunner cr = new CodeRunner();
			Thread thread = new Thread(cr);
	        thread.start();
	   }
	}
	
}	
	class CodeRunner implements Runnable {

	    @Override
	    public void run() {
	        
	            System.out.println(Thread.currentThread().getName()+" ==>> "+Singelton.getSingeltonObject().toString());
	            
	    }
	    
	}

