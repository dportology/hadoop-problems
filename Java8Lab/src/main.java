import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static java.util.function.Function.identity;
import static java.util.stream.Collectors.*;

public class main {
	
	public static String something(String x){
		if(x.length() != 0){
			if(Character.isLetter(x.charAt(0))){
				String res =  "" + x.charAt(0);
				return res.toUpperCase();
			}
		}
		return "NA";
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		Map<String, Long> numberOfLines = 
				Files.lines(Paths.get("/home/training/training_materials/admin/data/shakespeare.txt"))
					.map(w -> w.split("\\s+"))
					.flatMap(Arrays::stream)
					.map(t -> something(t))
					.collect(groupingBy(identity(), counting()));
										
		
		System.out.println(numberOfLines);
		
	}

}
