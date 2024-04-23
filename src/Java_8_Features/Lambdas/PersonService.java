package Java_8_Features.Lambdas;

import java.util.Collections;
import java.util.List;

public class PersonService {
    public List<Person> getPersonListInSortedName(List<Person> personList)
    {
        Collections.sort(personList, (p1, p2) -> p1.getName().compareTo(p2.getName()));
        return personList;
    }

    public List<Person> getPersonListInDescendingAge(List<Person> personList)
    {
        Collections.sort(personList, (p1, p2) -> p2.getAge() - p1.getAge());
        return personList;
    }
}
