package T04InterfacesAndAbstraction.lab.P04SayHelloExtend;

public class European extends BasePerson {

    public European(String name) {
        super(name);
    }

    @Override
    public String sayHello() {
        return "Hello";
    }
}
