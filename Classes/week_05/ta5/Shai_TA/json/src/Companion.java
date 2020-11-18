public class Companion {
    String _name = "";
    int _age = -1;

    Companion(String name, int age) {
        _name = name;
        _age = age;
    }

    @Override
    public String toString() {
        return "name='" + _name + "\',"+
                "\tage=" + _age;
    }
}
