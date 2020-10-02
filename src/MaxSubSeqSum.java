import java.util.Random;
public class MaxSubSeqSum {
	public static class MaxSubSequence
	{
		private int max_sum;
		private int begin_iteration;
		private int end_iteration;
		
		public MaxSubSequence(int max, int start, int finish)
		{
			max_sum = max;
			begin_iteration = start;
			end_iteration = finish;
		}
		

	}
	

	public static MaxSubSequence Max_Sum_First(int[] numbers)
	{
	       int max_sum = 0;
	       int begin_iteration = -1;
	       int end_iteration = -1;
	       for (int i = 0; i < numbers.length; i++)
	           for (int j = i; j < numbers.length; j++) {
	               int sum = 0;
	               for (int k = i; k <= j; k++)
	                   sum += numbers[k];
	               if (sum > max_sum) {
	                   begin_iteration = i;
	                   end_iteration = j;
	                   max_sum = sum;
	               }
		}
		return new MaxSubSequence(max_sum, begin_iteration, end_iteration);
		}

	

	
	public static MaxSubSequence Max_Sum_Second(int[] numbers)
	{
		int max_sum = 0;
		int begin_iteration = -1;
		int end_iteration = -1;
		
		for(int i =0; i < numbers.length; i++)
		{
			int sum = 0 ;
			
			for(int j = i; j < numbers.length; j++)
			{	
					sum+=numbers[j];
					
					if(sum > max_sum)
					{
						max_sum = sum;
						begin_iteration = i;
						end_iteration = j;
					}
			}
		}
		return new MaxSubSequence(max_sum, begin_iteration, end_iteration);
	}
	
	   public static MaxSubSequence maxSumRec(int[] numbers, int left, int right) {
	       if (left == right) // Best Case Time Complexity 
	           if (numbers[left] > 0)
	               return new MaxSubSequence(numbers[left], left, right);
	           else
	               return new MaxSubSequence(0, left, right);

	       int middle = (left + right) / 2;
	       MaxSubSequence max_Left_Seq = maxSumRec(numbers, left, middle);
	       MaxSubSequence max_Right_Seq = maxSumRec(numbers, middle + 1, right);

	       int begin_left = middle;
	       int end_left = left;
	       int max_Left_Sum = 0, left_Sum = 0;
	       for (int i = middle; i >= left; i--) {
	           left_Sum += numbers[i];
	           if (left_Sum > max_Left_Sum) {
	               max_Left_Sum = left_Sum;
	               begin_left = i;
	               end_left = middle;
	           }
	       }

	       int begin_right = middle + 1;
	       int end_right = right;
	       int max_Right_Sum = 0, right_Sum = 0;
	       for (int i = middle + 1; i <= right; i++) {
	           right_Sum += numbers[i];
	           if (right_Sum > max_Right_Sum) {
	               max_Right_Sum = right_Sum;
	               begin_right = middle + 1;
	               end_right = i;
	           }
	       }

	       if (max_Left_Seq.max_sum > max_Right_Seq.max_sum
	               && max_Left_Seq.max_sum > max_Left_Sum + max_Right_Sum) {
	           return max_Left_Seq;
	       } else if (max_Right_Seq.max_sum > max_Left_Seq.max_sum
	               && max_Right_Seq.max_sum > max_Left_Sum + max_Right_Sum) {
	           return max_Right_Seq;
	       } else {
	           return new MaxSubSequence(max_Left_Sum + max_Right_Sum, begin_left, end_right);
	       }
	   }

	   public static MaxSubSequence Max_Sum_Fourth(int[] a) {
	       int max_sum = 0, thisSum = 0;
	       int begin = -1;
	       int end = -1;
	      
	       for (int j = 0; j < a.length; j++){
	           if(thisSum == 0) {
	               begin = j;
	           }
	           thisSum += a[j];
	           if (thisSum > max_sum) {
	               max_sum = thisSum;
	               end = j;
	           }
	           else if (thisSum < 0) {
	               thisSum = 0;
	           }
	       }

	       return new MaxSubSequence(max_sum, begin, end);

	   }
	public static void main(String [] args)
	{
	      Random rd = new Random(); // creating Random object
	      int[] numbers = new int[1000];
	      for (int i = 0; i < numbers.length; i++) {
	         numbers[i] = rd.nextInt(); // storing random integers in an array
	      }
		  	long Start= System. nanoTime();
		    Max_Sum_First(numbers);
		   	long End= System.nanoTime();
		   	long CPUTime=End-Start;
			System.out.println("1->CPUTime: " + CPUTime);
		
		
		   long Start_2= System. nanoTime();
	       Max_Sum_Second(numbers);
		   long End_2= System.nanoTime();
		   long CPUTime_2=End-Start;
		   System.out.println("2->CPUTime: " + CPUTime_2);
	       
	       
	       
		   long Start_3= System. nanoTime();
	       maxSumRec(numbers, 0, numbers.length -1);
		   long End_3= System.nanoTime();
		   long CPUTime_3=End-Start;
		   System.out.println("3->CPUTime: " + CPUTime_3);
	       
	       
	       
	       long Start_4= System. nanoTime();
	       Max_Sum_Fourth(numbers);
		   long End_4= System.nanoTime();
		   long CPUTime_4=End-Start;
		   System.out.println("4->CPUTime: " + CPUTime_4);
	       
	       
	       
		   
		   System.out.println("---------------------------------------------------------"); 
	      
	      Random rd_2 = new Random(); // creating Random object
	      int[] numbers_2 = new int[10000];
	      for (int i = 0; i < numbers_2.length; i++) {
	         numbers_2[i] = rd_2.nextInt(); // storing random integers in an array
	      }
	      
	      long Start_5= System. nanoTime();
	       Max_Sum_First(numbers_2);
		   long End_5= System.nanoTime();
		   long CPUTime_5=End-Start;
		   System.out.println("1->CPUTime: " + CPUTime_5);
	       
	       
	       
	       long Start_6= System. nanoTime();
	       Max_Sum_Second(numbers_2);
		   long End_6= System.nanoTime();
		   long CPUTime_6=End-Start;
		   System.out.println("2->CPUTime: " + CPUTime_6);
	       
	       
	       
	       long Start_7= System. nanoTime();
	       maxSumRec(numbers_2, 0, numbers_2.length -1);
		   long End_7= System.nanoTime();
		   long CPUTime_7=End-Start;
		   System.out.println("3->CPUTime: " + CPUTime_7);
	       
	       
	       
	       long Start_8= System. nanoTime();
	       Max_Sum_Fourth(numbers_2);
		   long End_8= System.nanoTime();
		   long CPUTime_8=End-Start;
		   System.out.println("4->CPUTime: " + CPUTime_8);
	      
	     
		   
		   
	 System.out.println("---------------------------------------------------------"); 
	      Random rd_3 = new Random(); // creating Random object
	      int[] numbers_3 = new int[100000];
	      for (int i = 0; i < numbers_3.length; i++) {
	         numbers_3[i] = rd_3.nextInt(); // storing random integers in an array
	      }
	      
	      
	      long Start_9= System. nanoTime();
	       Max_Sum_First(numbers_3);
		   long End_9= System.nanoTime();
		   long CPUTime_9=End-Start;
		   System.out.println("1->CPUTime: " + CPUTime_9);

	       
	       
	       long Start_10= System. nanoTime();
	       Max_Sum_Second(numbers_3);
		   long End_10= System.nanoTime();
		   long CPUTime_10=End-Start;
		   System.out.println("2->CPUTime: " + CPUTime_10);
	       
	       
	       long Start_11= System. nanoTime();
	       maxSumRec(numbers_3, 0, numbers_3.length -1);
		   long End_11= System.nanoTime();
		   long CPUTime_11=End-Start;
		   System.out.println("3->CPUTime: " + CPUTime_11);    
	   
	       
	       
	       long Start_12= System. nanoTime();
	       Max_Sum_Fourth(numbers_3);
		   long End_12= System.nanoTime();
		   long CPUTime_12=End-Start;
		   System.out.println("4->CPUTime: " + CPUTime_12);
	       
	       
		   System.out.println("---------------------------------------------------------");     
	      
	      Random rd_4 = new Random(); // creating Random object
	      int[] numbers_4 = new int[1000000];
	      for (int i = 0; i < numbers_4.length; i++) {
	         numbers_4[i] = rd_4.nextInt(); // storing random integers in an array
	      }
	      
	      
	      long Start_13= System. nanoTime();
	       Max_Sum_First(numbers_4);
		   long End_13= System.nanoTime();
		   long CPUTime_13=End-Start;
		   System.out.println("1->CPUTime: " + CPUTime_13);
	       
	       
	       
	       long Start_14= System. nanoTime();
	       Max_Sum_Second(numbers_4);
		   long End_14= System.nanoTime();
		   long CPUTime_14=End-Start;
		   System.out.println("2->CPUTime: " + CPUTime_14);
	       
	       
	       
	       long Start_15= System. nanoTime();
	       maxSumRec(numbers_4, 0, numbers_4.length -1);
		   long End_15= System.nanoTime();
		   long CPUTime_15=End-Start;
		   System.out.println("3->CPUTime: " + CPUTime_15);
	       
	       
	       
	       long Start_16= System. nanoTime();
	       Max_Sum_Fourth(numbers_4);
		   long End_16= System.nanoTime();
		   long CPUTime_16=End-Start;
		   System.out.println("4->CPUTime: " + CPUTime_16);
	       
	    
		  System.out.println("---------------------------------------------------------"); 
		   
		   
	      Random rd_5 = new Random(); // creating Random object
	      int[] numbers_5 = new int[10000000];
	      for (int i = 0; i < numbers_5.length; i++) {
	         numbers_5[i] = rd_5.nextInt(); // storing random integers in an array
	      }
	      
	      
	      
	      long Start_17= System. nanoTime();
	       Max_Sum_First(numbers_5);
		   long End_17= System.nanoTime();
		   long CPUTime_17=End-Start;
		   System.out.println("1->CPUTime: " + CPUTime_17);
	       
	       
	       
	       long Start_18= System. nanoTime();
	       Max_Sum_Second(numbers_5);
		   long End_18= System.nanoTime();
		   long CPUTime_18=End-Start;
		   System.out.println("2->CPUTime: " + CPUTime_18);
	       
	       
	       
	       long Start_19= System. nanoTime();
	       maxSumRec(numbers_5, 0, numbers_5.length -1);  
		   long End_19= System.nanoTime();
		   long CPUTime_19=End-Start;
		   System.out.println("3->CPUTime: " + CPUTime_19);
	       
	       
	       
	       
	       long Start_20= System. nanoTime();
	       Max_Sum_Fourth(numbers_5);
		   long End_20= System.nanoTime();
		   long CPUTime_20=End-Start;
		   System.out.println("4->CPUTime: " + CPUTime_20);
	      
	}
		
		
	
}
