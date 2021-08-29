package T04InterfacesAndAbstraction.lab.P04SayHelloExtend;

public class Chinese extends BasePerson {

    public Chinese(String name) {
        super(name);
    }

    @Override
    public String sayHello() {
        return "Djydjybydjy";
    }
}
