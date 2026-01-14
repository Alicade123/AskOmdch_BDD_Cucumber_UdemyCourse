package step.definitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.DataTableType;
import io.cucumber.java.en.*;
import parameter.type.CustomerCredentialTable;

import java.util.List;
import java.util.Map;

public class DataTableSD {
//    @DataTableType
//    public CustomerCredentialTable credentials(List<String> data){
//        return new CustomerCredentialTable(data.get(0),data.get(1));
//    }
//    @Given("my credentials")
//    public void setCredentials(DataTable dataTable){
////        List<String> crd = dataTable.row(0)
////       List<String> crd2 = dataTable.values();
//
//        List<List<String>> CredentialData = dataTable.asLists();
//        System.out.println("Username is: "+CredentialData.get(0).get(0));
//        System.out.println("Username is: "+CredentialData.get(0).get(1));
//    }
//@Given("my credentials")
//public void setCredentials(CustomerCredentialTable customerCredentialTable){
//    System.out.println("Username is: "+customerCredentialTable.getUsername());
//    System.out.println("Username is: "+customerCredentialTable.getPassword());
//}
@Given("my credentials")
public void setCredentials(DataTable dataTable){
       List<Map<String,String>> map = dataTable.asMaps();
    System.out.println("Username is: "+map.get(0).get("username"));
    System.out.println("Username is: "+map.get(0).get("password"));
}
}
