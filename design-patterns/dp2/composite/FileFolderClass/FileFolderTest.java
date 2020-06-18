import java.util.ArrayList;

//https://refactoring.guru/design-patterns/composite/

// The client code works with all the components via their base
// interface. This way the client code can support simple leaf
// components as well as complex composites.
public class FileFolderTest {

    public static void main(String[] args) {
        System.out.println("this pattern contain left , composite and component interface ");

        Folder folder = new Folder("Movies");
        File file = new File("Portal2", 20);
        File file1 = new File("Assasin Creed", 20);
        Folder folder1 = new Folder("Games");
        folder1.addFileOrFolder(file);
        folder1.addFileOrFolder(file1);
        folder.addFileOrFolder(folder1);

        File movieFile = new File("sausage party", 4);
        folder.addFileOrFolder(movieFile);
        System.out.println(folder.getSize() + " Folder");
        System.out.println(folder1.getSize() + " Folder1");
    }
}

// 1. The component interface(abstract class) declares
// common operations for both
// simple and complex objects of a composition..
// In here this AbstractFileFolder common for both file and folder
abstract class AbstractFileOrFolder {
    // abstract class or interface ekata
    // leaf ekei composite ekei common ewa danawa
    private String name;
    // protected double size; get size mehema thibboth call karana gane increment
    // wenawa

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
        abstractFileOrFolder = new ArrayList<>();
    }

    // Folder ekata size ekak na files wala size eka thama eyage size eka
    @Override
    public double getSize() {
        double size = 0.0;
        for (AbstractFileOrFolder abstractFileOrFolderItem : abstractFileOrFolder) {
            System.out.println(abstractFileOrFolderItem.getName());
            size += abstractFileOrFolderItem.getSize();
        }
        return size;
    }

    public void addFileOrFolder(AbstractFileOrFolder fileOrFolder) {
        abstractFileOrFolder.add(fileOrFolder);
    }

    public void removeAbstractFileOrFolder(AbstractFileOrFolder fileOrFolder) {
        abstractFileOrFolder.remove(abstractFileOrFolder);
    }
}

// The leaf class represents end objects of a composition. A
// leaf object can't have any sub-objects. Usually, it's leaf
// objects that do the actual work, while composite objects only
// delegate to their sub-components.
class File extends AbstractFileOrFolder {
    private double size;

    File(String name, double size) {
        super(name);
        this.size = size;
    }

    @Override
    public double getSize() {
        return size;
    }

}