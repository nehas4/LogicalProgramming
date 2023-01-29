package practice;

public class Country implements Comparable<Country>
{
	private String name;
    private String code;
    private String capitol;
    private int happinessRank;
    private Double population;
    private Double GDP;
    
    public Country(String name,String code,String capitol,double population,double gdp,int hr) {
        this.name=name;
        this.code=code;
        this.capitol=capitol;
        this.population=population;
        GDP=gdp;
        happinessRank=hr;
    }

    public String getCapitol() {
        return capitol;
    }
    public void setCapitol(String capitol) {
        this.capitol = capitol;
    }
    public Double getPopulation() {
        return population;
    }
    public void setPopulation(Double population) {
        this.population = population;
    }

    public int getHappinessRank() {
        return happinessRank;
    }
    public void setHappinessRank(int happinessRank) {
        this.happinessRank = happinessRank;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }

    public Double getGDP() {
        return GDP;
    }
    public void setGDP(Double gDP) {
        GDP = gDP;
    }

    @Override
    public String toString() {
        return name+","+code+","+capitol+","+population+","+GDP+","+happinessRank;
    }
    @Override
    public int compareTo(Country arg0) {
        if (this == arg0) return 0;
        return this.name.compareTo(arg0.name);
    }

}
