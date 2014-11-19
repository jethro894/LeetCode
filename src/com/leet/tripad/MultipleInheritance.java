package com.leet.tripad;

public class MultipleInheritance {
	public interface A{
		void a();
	}
	
	public interface B{
		void b();
	}
	
	public interface C extends A, B{
		
	}
	
	public class D implements A, B{

		@Override
		public void b() {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void a() {
			// TODO Auto-generated method stub
			
		}
		
	}
}
