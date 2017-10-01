package tradersAndTransactions;

public  class TraderBase implements Trader {

    private String name;
    private String city;

    public TraderBase(String n, String c){
        this.name = n;
        this.city = c;
    }

    @Override
    public String name(){
        return this.name;
    }

    @Override
    public String city(){
        return this.city;
    }

    public String toString(){
        return "Trader:"+this.name + " in " + this.city;
    }
}
