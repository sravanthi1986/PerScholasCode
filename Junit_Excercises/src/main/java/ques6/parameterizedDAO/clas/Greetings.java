package ques6.parameterizedDAO.clas;

public  abstract class Greetings {
	
		public String selectLanguage(Integer i) {
			switch (i) {
			case 1:
				return "English";
			case 2:
				return "Spanish";
			case 3:
				return "Chinese";
			case 4:
				return "Swahili";
			default:
				return "Invalid Selection";
			}
		}

		public abstract String selectGreeting(Integer i);
	}

