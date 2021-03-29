package Model;

public class nation_data {
	private String nation;		
	private long male_Population;		
	private double male_Proportion;	
	private long female_Population;		
	private double female_Proportion;
        private double sex_ratio;
	
	public void setNation(String nation){
		this.nation = nation;
	}
	
	public void setMale_Population(long male_Population){
		this.male_Population = male_Population;
	}
	
	public void setMale_Proportion(double male_Proportion){
		this.male_Proportion = male_Proportion;
	}
	
	public void setFemale_Population(long female_Population){
		this.female_Population = female_Population;
	}
	
	public void setFemale_Proportion(double female_Proportion){
		this.female_Proportion = female_Proportion;
	}
        
        public void setSex_ratio(double sex_ratio){
		this.sex_ratio = sex_ratio;
	}
	
	public String getNation(){
		return nation;
	}
	
	public long getMale_Population(){
		return male_Population;
	}
	
	public double getMale_Proportion(){
		return male_Proportion;
	}
	
	public long getFemale_Population(){
		return female_Population;
	}
        
        public double getFemale_Proportion(){
		return female_Proportion;
	}
        
        public double getSex_ratio(){
		return sex_ratio;
	}
}
