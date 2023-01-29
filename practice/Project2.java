package practice;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Stack;

public class Project2 
{
	public static void main(String[] args) 
	{
		Project2 obj = new Project2();
		obj.readCSVFile();
	}
	
	public void readCSVFile()
	{
		try
		{
			// open file input stream for the input csv file
			BufferedReader reader = new BufferedReader(new FileReader("src/test/Country_data.csv"));

			String line = null;
			Scanner scanner = null;
			int index = 0;

			String name = "";
			String code = "";
			String capital = "";
			int population = 0;
			double gdp = 0l;
			int rank = 0;
			
			// Creating empty priority queues
	        PriorityQueue<Country> poorQueue = new PriorityQueue<Country>();
	        PriorityQueue<Country> fairQueue = new PriorityQueue<Country>();
	        PriorityQueue<Country> goodQueue = new PriorityQueue<Country>();
	        PriorityQueue<Country> vgoodQueue = new PriorityQueue<Country>();
	        PriorityQueue<Country> excelQueue = new PriorityQueue<Country>();
			
			boolean first = true;
			
			Long GDP = 0l;
			
			// read file line by line
			while ((line = reader.readLine()) != null) {
				//skip the first line of header as data
				if(first == true)
				{
					first = false;
					continue;
				}
				
				//creating country object with default values; 
				Country country = new Country(name, code, capital, population, gdp, rank);
				scanner = new Scanner(line);
				scanner.useDelimiter(",");
				//reading each column data separated by tab space and setting that into country object
				while (scanner.hasNext()) {
					String data = scanner.next();
					if (index == 0)
						country.setName(data);
					else if (index == 1)
						country.setCode(data);
					else if (index == 2)
						country.setCapitol(data);
					else if (index == 3)
						country.setPopulation(Double.parseDouble(data));
					else if (index == 4)
						country.setGDP(Double.parseDouble(data));
					else if (index == 5)
						country.setHappinessRank(Integer.parseInt(data));
					else
						System.out.println("invalid data::" + data);
					index++;
				}
				index = 0;
				//compare GDP of each country and enter it in specific queue as per the value
				BigDecimal bd = new BigDecimal(country.getGDP().toString());
				GDP = bd.longValue();
				
				if(GDP < 1000)
				{
					poorQueue.add(country);
				}
				else if(GDP > 1000 && GDP < 5000)
				{
					fairQueue.add(country);
				}
				else if(GDP > 5000 && GDP < 20000)
				{
					goodQueue.add(country);
				}
				else if(GDP > 20000 && GDP < 50000)
				{
					vgoodQueue.add(country);
				}
				else if(GDP > 50000)
				{
					excelQueue.add(country);
				}
			}
			
			//close reader
			reader.close();
			
			//Printing content of each queue
			System.out.println("Poor GDP countries queue"+poorQueue);
			System.out.println("Fair GDP countries queue"+fairQueue);
			System.out.println("Good GDP countries queue"+goodQueue);
			System.out.println("Very good GDP countries queue"+vgoodQueue);
			System.out.println("Excellent GDP countries queue"+excelQueue);
			
			//Creating stack and removing poor queue element one by one and inserting to stack
			Stack<Country> stack = new Stack<Country>();
			while(poorQueue.size() != 0)
			{
				stack.push(poorQueue.poll());
			}
			
			System.out.println("Stack of poor GDP country = "+stack);
		}
		catch(FileNotFoundException fe)
		{
			System.out.println("csv input file not found!!");
		} catch (NumberFormatException e) {
			e.printStackTrace();
			System.out.println("Invalid data found!!");
		} catch (IOException e) {
			System.out.println("Some eception occured while reading the csv file!!");
		}
	}
}
