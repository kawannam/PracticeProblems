import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class F {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int cases = Integer.parseInt(sc.nextLine());
		for(int i = 0; i<cases; i++){
			HashMap<Character, Integer> m = new HashMap<Character, Integer>();
			
			ArrayList<String> commands = new ArrayList<String>();
			String line = sc.nextLine();
			String current = "";
			for(int j = 0; j< line.length(); j++){
				Character c = line.charAt(j);
				if(c.equals('[')){
					while(!c.equals(']')){
						current += c;
						j++;
						c = line.charAt(j);
					}
					current += c;
					c = line.charAt(j);
					commands.add(current);
					current = "";
				} else if(c.equals('(')){
					while(!c.equals(')')){
						current += c;
						j++;
						c = line.charAt(j);
					}
					current += c;
					commands.add(current);
					current = "";
				} else if(c.equals('<')){
					while(!c.equals('>')){
						current += c;
						j++;
						c = line.charAt(j);
					}
					current += c;
					commands.add(current);
					current = "";
				}
			}
			
			boolean suc = evaluate(m, commands);
			if(suc){
				System.out.println("ASSERTIONS ALWAYS HOLD");
			}else{
				System.out.println("ASSERTIONS INVALID");
			}
					
		}
	
	}
	
	
	private static ArrayList<String>  findcommands(String line){
		ArrayList<String> commands = new ArrayList<String>();
		String current = "";
		for(int j = 0; j< line.length(); j++){
			Character c = line.charAt(j);
			if(c.equals('[')){
				while(!c.equals(']')){
					current += c;
					j++;
					c = line.charAt(j);
				}
				current += c;
				c = line.charAt(j);
				commands.add(current);
				current = "";
			} else if(c.equals('(')){
				while(!c.equals(')')){
					current += c;
					j++;
					c = line.charAt(j);
				}
				current += c;
				commands.add(current);
				current = "";
			} else if(c.equals('<')){
				while(!c.equals('>')){
					current += c;
					j++;
					c = line.charAt(j);
				}
				current += c;
				commands.add(current);
				current = "";
			}
		}
		return commands;
	}
	
	private static boolean evaluate(HashMap<Character, Integer> map, List<String> commands){
		for(int i = 0; i< commands.size(); i++){
			String command = commands.get(i);
			if(command.charAt(0) == '['){
				String var = command.substring(1, 2);
				String val = command.substring(3, command.length()-1);
				if(val.contains("+")){
					String a = val.split("\\+")[0];
					String b = val.split("\\+")[1];
					map.put(var.charAt(0), getVal(map, a) +  getVal(map, b));
				} else if(val.equals("?")){
					HashMap<Character, Integer>  oneMap = (HashMap<Character, Integer>) map.clone();
					HashMap<Character, Integer>  zeroMap = (HashMap<Character, Integer>) map.clone();
					oneMap.put(var.charAt(0), 1);
					zeroMap.put(var.charAt(0), 0);
					
					
					boolean oneVal = evaluate(oneMap, commands.subList(i+1, commands.size()));
					boolean zeroVal = evaluate(zeroMap, commands.subList(i+1, commands.size()));
					
					return oneVal && zeroVal;
					
					
					
					
				} else{
					map.put(var.charAt(0), Integer.parseInt(val));
				}
			}
			if(command.charAt(0) == '('){
				String foo = command.substring(1, command.length()-1);
				String conditional = foo.split("\\{")[0];
				String a = conditional.split("<")[0];
				String b = conditional.split("<")[1];
				if(getVal(map, a) < getVal(map, b)){
					String com2 = command.substring(command.indexOf('{')+1, command.length()-2);
					evaluate(map,findcommands(com2));
				}
			}
			if(command.charAt(0) == '<'){
				String val = command.substring(1, command.length()-1);
				String a= val.split("=")[0];
				String b= val.split("=")[1];
				if(!getVal(map, a).equals(getVal(map, b))){
					return false;
				}
			}
		}
		return true;
	}
	
	private static Integer getVal(HashMap<Character, Integer> map, String key){
		try{
			return Integer.parseInt(key);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return map.getOrDefault(key.charAt(0), 0);
	}
}
