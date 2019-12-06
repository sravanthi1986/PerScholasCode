package org.perscholas;

public  class OOPintro {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
     person.Eat("Hungry");
     person qee=new person();
     qee.age=90;
     System.out.println(qee.age);
		
	}
	public static class person{
		//fields or attributes 
		private String name;
		private int age;
		private String gender;
		private double hight;
		private double weight;
		//methods
		public static void Eat(String s) {
			if(s.equals("Hungry"))
				System.out.println("need to food");
			else
				System.out.println("let me do my work");
			
			
		}
		public  void Sleep(String s) {
			if(s.equals("tierd"))
				System.out.println("go to sleep");
			else
				System.out.println("read fro exam");
		}
		/**
		 * @return the name
		 */
		public String getName() {
			return name;
		}
		/**
		 * @param name the name to set
		 */
		public void setName(String name) {
			this.name = name;
		}
		/**
		 * @return the age
		 */
		public int getAge() {
			return age;
		}
		/**
		 * @param age the age to set
		 */
		public void setAge(int age) {
			this.age = age;
		}
		/**
		 * @return the gender
		 */
		public String getGender() {
			return gender;
		}
		/**
		 * @param gender the gender to set
		 */
		public void setGender(String gender) {
			this.gender = gender;
		}
		/**
		 * @return the hight
		 */
		public double getHight() {
			return hight;
		}
		/**
		 * @param hight the hight to set
		 */
		public void setHight(double hight) {
			this.hight = hight;
		}
		/**
		 * @return the weight
		 */
		public double getWeight() {
			return weight;
		}
		/**
		 * @param weight the weight to set
		 */
		public void setWeight(double weight) {
			this.weight = weight;
		}
		
		
	}

}
