package com.perscholas.selenium_cucumber_template.automation;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.perscholas.selenium_cucumber_template.step_definitions.MenuOptionsRunner;
import com.perscholas.selenium_cucumber_template.step_definitions.PopularSessionRunner;



@RunWith(Suite.class)
@SuiteClasses({MenuOptionsRunner.class, PopularSessionRunner.class})
public class MainRunnerSuite {

}
