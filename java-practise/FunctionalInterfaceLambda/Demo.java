package FunctionalInterfaceLambda;

// @FunctionalInterface
// interface A
// {
// 	void show();
// //	void run();
// }
// //class B implements A
// //{
// //	public void show()
// //	{
// //		System.out.println("in Show");
// //	}
// //}


// public class Demo {
//     public static void main(String[] args) {
    	
//     	A obj = () -> {
//                 System.out.println(
//                     "somethign"
//                 );
//         };
//  //   	A obj=new A();
//  //   	A obj=new B();
//     	obj.show();
//     }
// }
@FunctionalInterface
interface A
{
	int add(int i, int j);
}


public class Demo {
    public static void main(String[] args) {
//    	
//   	A obj=new A()
//   	{
//   		public int add(int i, int j)
//   		{
//   			return i+j;
//   		}
//   	};
    	
    	A obj=(i,j) -> i+j;
   	
   	int result=obj.add(5, 4);
   	System.out.println(result);
    }
}
