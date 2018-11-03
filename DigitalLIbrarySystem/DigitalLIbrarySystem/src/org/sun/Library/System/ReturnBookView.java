package org.sun.Library.System;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.sun.Library.Bean.Message;
import org.sun.Library.Controler.Interfaces.View;
import org.sun.Library.Controler.Types.Role;

public class ReturnBookView  implements View{
    @Override
    public Message display() {
        // TODO Implement this method
        return null;
    }

    @Override
    public Message displayAll(Object desc) {
        Map<String,Object>data = (Map<String, Object>) desc;
        Map<String,Object>attributes=new HashMap<>();
        List<Object>forValues=new ArrayList<>();
        String fromDate = (String) data.get("fromDate");
        String toDate = (String) data.get("toDate");
        forValues.add(fromDate);
        forValues.add(toDate);
        attributes.put("foValues", forValues);
        List<String>byConditions=new ArrayList<>();
        byConditions.add(" RE.RETURNED_DATE ");
        byConditions.add("");
        attributes.put("byConditions", byConditions);
        List<String>operators=new ArrayList<>();
        operators.add(" BETWEEN ");
        operators.add("");
        List<String>seperators=new ArrayList<>();
        seperators.add(" AND ");
        seperators.add("");
        attributes.put("operators", operators);
        attributes.put("seperators", seperators);
        return new ReturnsBooksSearch().search(attributes);
    }
}
