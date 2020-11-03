package org.progmatic.nov3;

import java.util.Comparator;
import java.util.List;
import java.util.Map;

public class orderProfessionNum implements Comparator<Map<String, List<Person>>> {

    @Override
    public int compare(Map<String, List<Person>> o1, Map<String, List<Person>> o2) {
        return 1;
    }
}
