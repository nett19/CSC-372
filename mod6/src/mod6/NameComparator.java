package mod6;

import java.util.Comparator;

class NameComparator implements Comparator<User> {
    @Override
    public int compare(User s1, User s2) {
        return s1.name.compareTo(s2.name);
    }
}

class RollNoComparator implements Comparator<User> {
    @Override
    public int compare(User s1, User s2) {
        return s1.rollno - s2.rollno;
    }
}