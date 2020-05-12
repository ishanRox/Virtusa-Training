public abstract class Milk implements Cloneable{

    String type;
    String temp;
    String condiments;

    public String getCondiments() {
        return condiments;
    }

    public void setCondiments(String condiments) {
        this.condiments = condiments;
    }

    public String getType() {
        return type;
    }

    public String getTemp() {
        return temp;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setTemp(String temp) {
        this.temp = temp;
    }

    abstract void mix();

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return (temp+"  "+type+" is mixed with "+ condiments);
    }
}
