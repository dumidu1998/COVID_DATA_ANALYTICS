package models;

public class CovidCase extends Date {
    private String country;
    private String province;
    private String region;
    private String ageGroup;
    private String sex;
    private int cases;

    public CovidCase(int day, int month, int year, String country, String province, String region, String ageGroup,
            String sex, int cases) {
        super(day, month, year);
        this.country = country;
        this.province = province;
        this.region = region;
        this.ageGroup = ageGroup;
        this.sex = sex;
        this.cases = cases;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getAgeGroup() {
        return ageGroup;
    }

    public void setAgeGroup(String ageGroup) {
        this.ageGroup = ageGroup;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getCases() {
        return cases;
    }

    public void setCases(int cases) {
        this.cases = cases;
    }

    public void printCase() {
        System.out.println("DAY: " + this.getDay() + ", MONTH: " + this.getMonth() + ", YEAR: " + this.getYear()
                + ", COUNTRY: " + this.getCountry() + ", PROVINCE: " + this.getProvince() + ", REGION: "
                + this.getRegion() + ", AGE GROUP: " + this.getAgeGroup() + ", SEX: " + this.getSex() + ", CASES: "
                + this.getCases());
    }
}
