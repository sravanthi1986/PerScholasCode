package org.perscholas.Qestion10Test;
import org.junit.experimental.categories.Categories;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

	@RunWith(Categories.class)
	@Categories.IncludeCategory({Weekly.class})
	@Suite.SuiteClasses({ StudentTests.class, SchoolTests.class, InstructorTests.class })


public class IncludesWeeklyTestsOnlySuite {

}
