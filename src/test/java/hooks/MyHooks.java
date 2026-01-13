package hooks;

import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;

public  class MyHooks {
    @BeforeAll
    public static void beforeAll(){
        System.out.println("Before all hook here");
    }

    @AfterAll
    public static void afterAll(){
        System.out.println("Before all hook here");
    }
}
