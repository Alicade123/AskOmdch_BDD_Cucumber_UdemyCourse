package hooks;

import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import org.junit.AfterClass;
import org.junit.BeforeClass;

public  class MyHooks {
    @BeforeClass
    public static void setUp(){
        System.out.println("*** This is before class annotation");
    }
    @AfterClass
    public static void tearDown(){
        System.out.println("*** This is after class annotation");
    }

    @BeforeAll
    public static void beforeAllScenariosHook(){
        System.out.println("** Before all hook here");
    }

    @AfterAll
    public static void afterAllScenariosHook(){
        System.out.println("** Before all hook here");
    }

    @Before(order = 0 , value="@scenario1")
    public static void beforeEveryScenarioHook0(){
        System.out.println("This is before Hook annotation >> Order 1");
    }
    @Before(order = 1, value="@scenario2")
    public static void beforeEveryScenarioHook1(){
        System.out.println("This is before Hook annotation >> Order 2");
    }
    @After(order = 1, value="@scenario1")
    public static void afterEveryScenarioHook0(){
        System.out.println("This is after Hook annotation >> Order 1");
    }

    @After(order = 0, value="@scenario2")
    public static void afterEveryScenarioHook1(){
        System.out.println("This is after Hook annotation >> Order 2");
    }
}
