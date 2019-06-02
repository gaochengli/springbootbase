/**
 * 
 */
package IO和NIO;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;


/**
 * @author clgao
 *
 */
public class ParallelStream {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		
		String contents = new String(Files.readAllBytes(Paths.get("W:\\专业学习\\主流技术汇总\\java核心技术\\words.txt")),java.nio.charset.StandardCharsets.UTF_8);
		List<String> words = Arrays.asList(contents.split("\\PL+"));
		long  count = 0;
		for(String w: words) {
			if(w.length()>5) {
				count++;
			}
		}
		System.out.println(count);
		System.out.println(words.stream().filter(w->w.length()>5).count());
		System.out.println(words.parallelStream().filter(w->w.length()>5).count());
		Stream<String> swords = Stream.of(contents.split("\\PL+"));
		System.out.println(swords.toString());
	}

}
