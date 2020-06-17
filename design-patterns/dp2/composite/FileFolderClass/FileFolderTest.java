import java.util.ArrayList;

//https://refactoring.guru/design-patterns/composite/

public class FileFolderTest {

    public static void main(String[] args) {
        System.out.println("this pattern contain left , composite and component interface ");

    }
}

// 1. The component interface(abstract class) declares
// common operations for both
// simple and complex objects of a composition..
// In here this AbstractFileFolder common for both file and folder
abstract class AbstractFileOrFolder {
    private String name;
    private double size;

    public AbstractFileOrFolder(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public abstract double getSize();
}

// The composite class represents complex components that may
// have children. Composite objects usually delegate the actual
// work to their children and then "sum up" the result.
class Folder extends AbstractFileOrFolder {
private ArrayList<AbstractFileOrFolder> abstractFileOrFolder;
    public Folder(String name) {
        super(name);
        // TODO Auto-generated constructor stub
    }

    @Override
    public double getSize() {
        // TODO Auto-generated method stub
        return 0;
    }

    
}